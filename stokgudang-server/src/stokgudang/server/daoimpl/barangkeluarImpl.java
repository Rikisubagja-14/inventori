/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.server.daoimpl;

import java.rmi.RemoteException;
import entity.Customer;
import entity.BarangKeluar;
import dao.barangkeluarDao;
import dao.masterbarangDao;
import entity.BarangKeluarDetail;
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
import java.text.SimpleDateFormat;
/**
 *
 * @author Riki subagja
 */
public class barangkeluarImpl extends UnicastRemoteObject implements barangkeluarDao{

    private final Connection connection;
    private final masterbarangImpl masterbarangImpl;
    private final customerImpl customerImpl;
   
    

    public barangkeluarImpl() throws RemoteException {
        connection = databaseutilities.getConnection();
        masterbarangImpl = new masterbarangImpl();
        customerImpl = new customerImpl();
        
    }

    @Override
    public boolean insert(BarangKeluar barangkeluar) throws RemoteException {
        boolean valid = false;
        PreparedStatement statement = null;
        String sql = "insert into dbbarangkeluar (kode_transaksi,tanggal,kode_customer,nama_customer) values(?,?,?,?)";
        try {
            connection.setAutoCommit(false);
            statement=connection.prepareStatement(sql);
            statement.setString(1,barangkeluar.getKode_transaksi());
            statement.setDate(2, new java.sql.Date(barangkeluar.getTgl().getTime()));
            statement.setString(3,barangkeluar.getCustomer().getkode_customer());
            statement.setString(4,barangkeluar.getCustomer().getnamacustomer());
            statement.executeUpdate();
            String trans_sql = "insert into barangkeluar_detail(kode_transaksi, kode_barang, nama_barang, batch,kategori_nf,lokasi, qty, isi, satuan, total_qty, kemasan) values" 
                    +" (?,?,?,?,?,?,?,?,?,?,?)";
//            String sql_update = "update barangmasuk_detail set qty,total_qty where batch=?";
            List<BarangKeluarDetail> detailKeluar = barangkeluar.getDetailkeluar();
            
                for (BarangKeluarDetail barangKeluarDetail: detailKeluar){ 
                    statement=connection.prepareStatement(trans_sql);
                    statement.setString(1, barangKeluarDetail.getKode_transaksi());
                    statement.setString(2, barangKeluarDetail.getKode_barang());
                    statement.setString(3, barangKeluarDetail.getNama_barang());
                    statement.setString(4, barangKeluarDetail.getBatch());
                    statement.setString(5, barangKeluarDetail.getKategori_nf());
                    statement.setString(6, barangKeluarDetail.getLok());
                    statement.setDouble(7, barangKeluarDetail.getQty());
                    statement.setDouble(8, barangKeluarDetail.getIsi());
                    statement.setString(9, barangKeluarDetail.getSatuan());
                    statement.setDouble(10,barangKeluarDetail.getTotal_qty());
                    statement.setString(11,barangKeluarDetail.getKemasan());
                 
                    statement.executeUpdate();
//                    statement = connection.prepareStatement(sql_update);
//                    statement.setDouble(1, barangKeluarDetail.getQty());
//                    statement.setDouble(2, barangKeluarDetail.getTotal_qty());
//                    statement.setString(3, barangKeluarDetail.getBatch());
//                    statement.executeUpdate();
                    
              
//              String  sql_temp =" select select kode_barang,nama_barang,batch,sum(qty+total_qty),isi,kemasan,satuan";
                    
                    
                    
                }
                
                connection.commit();
                connection.setAutoCommit(true);
                valid=true;
                
        } catch (SQLException ex) {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
                Logger.getLogger(barangkeluarImpl.class.getName()).log(Level.SEVERE, null,ex);
            } catch (SQLException ex1) {
                Logger.getLogger(barangkeluarImpl.class.getName()).log(Level.SEVERE, null,ex1);
            }
        } finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(barangkeluarImpl.class.getName()).log(Level.SEVERE, null,ex);
                }
            }
        }
        return valid;
    }

    @Override
    public List<BarangKeluarDetail> getBarangKeluardetail(String kode_transaksi) throws RemoteException {
        PreparedStatement statement = null;
        ResultSet rs=null;
        List list =new ArrayList();
        String sql="select * from barangkeluar_detail where kode_transaksi=?";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, kode_transaksi);
            rs=statement.executeQuery();
             while(rs.next()){
                BarangKeluarDetail p=new BarangKeluarDetail();
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
             Logger.getLogger(barangkeluarImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(barangkeluarImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(barangkeluarImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<BarangKeluar> getbarangkeluar() throws RemoteException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List list = new ArrayList();
        String sql="select * from dbbarangkeluar";
        try {
            statement=connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                BarangKeluar p=new BarangKeluar();
                p.setKode_transaksi(rs.getString("kode_transaksi"));
                p.setTgl(rs.getDate("tgl"));
                String kode_cust = rs.getString("kode_customer");
                Customer getCustomer = customerImpl.getcustomer(kode_cust);
                p.setCustomer(getCustomer);

                p.setDetailkeluar(getBarangKeluardetail(rs.getString("kode_transaksi")));
                list.add(p);
            }
            return list;
        } catch (SQLException e1 ) {
                Logger.getLogger(barangkeluarImpl.class.getName()).log(Level.SEVERE, null,e1);
                return null;
        } finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(barangkeluarImpl.class.getName()).log(Level.SEVERE, null,e);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                     Logger.getLogger(barangkeluarImpl.class.getName()).log(Level.SEVERE, null,e);
                }
            }
        }
    }

    @Override
    public List<BarangKeluar> getbarangkeluar(Date tglMulai, Date tgAkhir) throws RemoteException {
        PreparedStatement statement =null;
        ResultSet rs=null;
        List list = new ArrayList();
        String sql="select * from dbbarangkeluar where (barangmasuk.tgl>=?) and (barangmasuk.tgl<=?)";
        try {
            statement=connection.prepareStatement(sql);
            statement.setDate(1, new java.sql.Date(tglMulai.getTime()));
            statement.setDate(2, new java.sql.Date(tgAkhir.getTime()));
            rs=statement.executeQuery();
            while(rs.next()){
                BarangKeluar p = new BarangKeluar();
                p.setKode_transaksi(rs.getString("dbbarangkeluar.kode_transaksi"));
                p.setTgl(rs.getDate("dbbarangkeluar.tgl"));
                String kode_cust = rs.getString("dbbarangmasuk.kode_customer");
                Customer getCustomer = customerImpl.getcustomer(kode_cust);
                p.setCustomer(getCustomer);

                p.setDetailkeluar(getBarangKeluardetail((p.getKode_transaksi())));
                list.add(p);
            } 
            return list;
        } catch (SQLException e1) {
             Logger.getLogger(barangkeluarImpl.class.getName()).log(Level.SEVERE, null,e1);
                return null;
        } finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(barangkeluarImpl.class.getName()).log(Level.SEVERE, null,e);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                     Logger.getLogger(barangkeluarImpl.class.getName()).log(Level.SEVERE, null,e);
                }
            }
        }
    }

  
    @Override
    public BarangKeluar getbarangkeluar(String id) throws RemoteException {
         PreparedStatement statement = null;
        ResultSet rs=null;
        BarangKeluar p=null;
        String sql="select * from dbbarangkeluar where kode_transaksi";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1, id);
            rs=statement.executeQuery();
            while(rs.next()){
               p=new BarangKeluar();
                p.setKode_transaksi(rs.getString("kode_transaksi"));
                p.setTgl(rs.getDate("tgl"));
                String kd_customer = rs.getString("kode_customer");
                Customer getCustomer = customerImpl.getcustomer(kd_customer);
                p.setCustomer(getCustomer);

               p.setDetailkeluar(getBarangKeluardetail(rs.getString("kode_transaksi")));
            }
            return p;
        } catch (SQLException ex) {
             Logger.getLogger(barangkeluarImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(barangkeluarImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(barangkeluarImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

 
  

}
