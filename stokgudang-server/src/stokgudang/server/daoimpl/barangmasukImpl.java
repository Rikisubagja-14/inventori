

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.server.daoimpl;

import dao.barangmasukDao;
import entity.BarangMasuk;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import stokgudang.server.db.databaseutilities;
import entity.BarangMasukDetail;
import entity.Customer;
/**
 *
 * @author Riki subagja
 */
public class barangmasukImpl extends UnicastRemoteObject implements barangmasukDao{
    private final Connection connection;
    private final masterbarangImpl masterbarangImpl;
    private final customerImpl customerImpl;

    public barangmasukImpl() throws RemoteException {
        connection = databaseutilities.getConnection();
        masterbarangImpl = new masterbarangImpl();
        customerImpl = new customerImpl();
    }

    @Override
    public boolean insert(BarangMasuk barangmasuk) throws RemoteException{
        boolean valid = false;
        PreparedStatement statement = null;
        String sql =  "insert into dbbarangmasuk (kode_transaksi,tanggal,kode_customer,nama_customer) values(?,?,?,?)";
        try {
            connection.setAutoCommit(false);
            statement=connection.prepareStatement(sql);
            statement.setString(1, barangmasuk.getKode_transaksi());
            statement.setDate(2, new java.sql.Date(barangmasuk.getTgl().getTime()));
            statement.setString(3, barangmasuk.getkode_Customer().getkode_customer());
            statement.setString(4, barangmasuk.getkode_Customer().getnamacustomer());
            statement.executeUpdate();
            
            // proses insert ke barang transaksi
            String TRANSAKSI_SQL="insert into barangmasuk_detail(kode_transaksi, kode_barang, nama_barang, batch,kategori_nf,lokasi, qty, isi, satuan, total_qty, kemasan) values" 
                    +" (?,?,?,?,?,?,?,?,?,?,?)";
//            String sql_update = "update barangmasuk_detail set qty=?,total_qty=? where batch=?";
                
                List<BarangMasukDetail> detailmasuk = barangmasuk.getDetailMasuk();
                
            for(BarangMasukDetail barangmasukdetail: detailmasuk) {
                statement=connection.prepareStatement(TRANSAKSI_SQL);
                statement.setString(1, barangmasukdetail.getKode_transaksi());
                statement.setString(2, barangmasukdetail.getKode_barang());
                statement.setString(3, barangmasukdetail.getNama_barang());
                statement.setString(4, barangmasukdetail.getBatch());
                statement.setString(5, barangmasukdetail.getKategori_nf());
                statement.setString(6, barangmasukdetail.getLok());
                statement.setDouble(7, barangmasukdetail.getQty());
                statement.setDouble(8, barangmasukdetail.getIsi());
                statement.setString(9, barangmasukdetail.getSatuan());
                statement.setDouble(10,barangmasukdetail.getTotal_qty());
                statement.setString(11,barangmasukdetail.getKemasan());
                statement.executeUpdate();
//                    statement = connection.prepareStatement(sql_update);
//                    statement.setDouble(1, barangmasukdetail.getQty());
//                    statement.setDouble(2,barangmasukdetail.getTotal_qty());
//                    statement.setString(3,barangmasukdetail.getBatch());
//                    statement.executeUpdate();
                
            }
      
            connection.commit();
            connection.setAutoCommit(true);
            valid=true;
        } catch (SQLException ex) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
                Logger.getLogger(barangmasukImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex1) {
                Logger.getLogger(barangmasukImpl.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(barangmasukImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        }
        return valid;
    }

    @Override
   
    public List<BarangMasuk> getPembelian() throws RemoteException {
        PreparedStatement statement = null;
        ResultSet rs=null;
        List list = new ArrayList();
        String sql="SELECT * FROM dbbarangmasuk ";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                BarangMasuk p=new BarangMasuk();
                p.setKode_transaksi(rs.getString("kode_transaksi"));
                p.setTgl(rs.getDate("tanggal"));
                String kode_cust = rs.getString("kode_customer");
                Customer getCustomer = customerImpl.getcustomer(kode_cust);
                p.setkode_Customer(getCustomer);
                p.setDetailMasuk(getPembelianDetil(rs.getString("kode_transaksi")));
                list.add(p);
         }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(barangmasukImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(barangmasukImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(barangmasukImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<BarangMasuk> getPembelian(Date tglMulai, Date tglAkhir) throws RemoteException {
        PreparedStatement statement = null;
        ResultSet rs=null;
        List list = new ArrayList();
        String sql="SELECT * FROM dbbarangmasuk where dbbarangmasuk.tanggal >= ? AND dbbarangmasuk.tanggal <= ?";
        
        try {
            statement=connection.prepareStatement(sql);
            
            statement.setDate(1, new java.sql.Date(tglMulai.getTime()));
            statement.setDate(2, new java.sql.Date(tglAkhir.getTime()));
            System.out.println("Inspeksi :"+tglMulai+" + "+tglAkhir);
            rs=statement.executeQuery();
            while(rs.next()){
                BarangMasuk p=new BarangMasuk();
                p.setKode_transaksi(rs.getString("dbbarangmasuk.kode_transaksi"));
                p.setTgl(rs.getDate("dbbarangmasuk.tanggal"));
                String kode_cust = rs.getString("dbbarangmasuk.kode_customer");
                Customer getCustomer = customerImpl.getcustomer(kode_cust);
                p.setkode_Customer(getCustomer);

                p.setDetailMasuk(getPembelianDetil((p.getKode_transaksi())));
                list.add(p);     
         }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(barangmasukImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(barangmasukImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(barangmasukImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<BarangMasukDetail> getPembelianDetil(String kode_transaksi) throws RemoteException {
        PreparedStatement statement = null;
        ResultSet rs=null;
        List list = new ArrayList();
        String sql="SELECT * FROM barangmasuk_detail where kode_transaksi=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, kode_transaksi);
            rs=statement.executeQuery();
            while(rs.next()){
                BarangMasukDetail p =new BarangMasukDetail();
                p.setKode_transaksi(rs.getString("kode_transaksi"));
                p.setMasterBarang(masterbarangImpl.getById(rs.getString("kode_barang")));
                p.setMasterBarang(masterbarangImpl.getById(rs.getString("nama_barang")));
                p.setBatch(rs.getString("batch"));
                p.setKategori_nf(rs.getString("kategori_nf"));
                p.setLok(rs.getString("lokasi"));
                p.setQty(rs.getInt("qty"));
                p.setIsi(rs.getDouble("isi"));
                p.setSatuan(rs.getString("satuan"));
                p.setTotal_qty(rs.getDouble("total_qty"));
                
                list.add(p);
                
         }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(barangmasukImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(barangmasukImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(barangmasukImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    @Override
    public BarangMasuk getbarangmasuk(String id) throws RemoteException {
        PreparedStatement statement = null;
        ResultSet rs=null;
        BarangMasuk p=null;
        String sql="SELECT * FROM dbbarangmasuk where kode_transaksi=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, id);
            rs=statement.executeQuery();
            while(rs.next()){
               p=new BarangMasuk();
                p.setKode_transaksi(rs.getString("kode_transaksi"));
                p.setTgl(rs.getDate("tanggal"));
                String kd_customer = rs.getString("kode_customer");
                Customer getCustomer = customerImpl.getcustomer(kd_customer);
                p.setkode_Customer(getCustomer);

                p.setDetailMasuk(getPembelianDetil(rs.getString("kode_transaksi")));
                
          }
            return p;
        } catch (SQLException ex) {
            Logger.getLogger(barangmasukImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(barangmasukImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(barangmasukImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}