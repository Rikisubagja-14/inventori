/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.server.daoimpl;

import com.mysql.jdbc.PreparedStatement;
import dao.masterbarangDao;
import entity.MasterBarang;
import java.rmi.RemoteException;
import java.sql.Connection;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import stokgudang.server.db.databaseutilities;
/**
 *
 * @author Riki subagja
 */
public class masterbarangImpl extends UnicastRemoteObject implements masterbarangDao{
    private final Connection connection;
    
    public masterbarangImpl() throws RemoteException {
        connection = databaseutilities.getConnection();
    }
    
    @Override
    public boolean insert(MasterBarang barang) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
        
        String sql = "INSERT INTO `dbmasterbarang`(`kode_barang`, `nama_barang`, `kategori`, `isi`, `satuan`, `kemasan`) VALUES (?,?,?,?,?,?)";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, barang.getKode_barang());
            statement.setString(2, barang.getNama_barang());
            statement.setString(3, barang.getKategori());
            statement.setDouble(4, barang.getIsi());
            statement.setString(5, barang.getSatuan());
            statement.setString(6, barang.getKemasan());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean update(MasterBarang barang) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
       
        String sql = "UPDATE `dbmasterbarang` SET `nama_barang`=?,`kategori`=?,`isi`=?,"
                + "`satuan`=?,`kemasan`=? WHERE `kode_barang`=?";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, barang.getNama_barang());
            statement.setString(2, barang.getKategori());
            statement.setDouble(3, barang.getIsi());
            statement.setString(4, barang.getSatuan());
            statement.setString(5, barang.getKemasan());
            statement.setString(6, barang.getKode_barang());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean delete(MasterBarang barang) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
        
        String sql = "DELETE FROM `dbmasterbarang` WHERE `kode_barang`=?";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, barang.getKode_barang());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }


    

    @Override
    public boolean kurangJumlahStok(double jumlah, MasterBarang barang) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
       
        String sql = "UPDATE dbmasterbarang  where kode_barang=?";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setDouble(1, jumlah);
            statement.setString(2, barang.getKode_barang());
            
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean tambahJumlahStok(double jumlah, MasterBarang barang) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
       
        String sql = "UPDATE dbmasterbarang where kode_barang=?";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setDouble(1, jumlah);
            statement.setString(2, barang.getKode_barang());
            
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public MasterBarang getById(String Id) throws RemoteException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        MasterBarang barang=null;
        
        String sql = "SELECT * from dbmasterbarang where kode_barang=?";
        try {
            statement =(PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, Id);
            rs=statement.executeQuery();
            while (rs.next()){
                barang = new MasterBarang();
                barang.setKode_barang(rs.getString("kode_barang"));
                barang.setNama_barang(rs.getString("nama_barang"));
                barang.setKategori(rs.getString("kategori"));
                barang.setIsi(rs.getDouble("isi"));
                barang.setSatuan(rs.getString("satuan"));
                barang.setKemasan(rs.getString("kemasan"));
            }
            return barang;
        } catch (SQLException ex) {
            Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    

    @Override
    public List<MasterBarang> getBarangNotIn() throws RemoteException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<MasterBarang> list = new ArrayList<>();
        
        String sql = "select * from dbmasterbarang WHERE kd_brg NOT IN ( SELECT dbmasterbarang_kode_barang FROM barangmasuk ); ";
        try {
            statement =(PreparedStatement) connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while (rs.next()){
                MasterBarang barang = new MasterBarang();
                barang.setKode_barang(rs.getString("kode_barang"));
                barang.setNama_barang(rs.getString("nama_barang"));
                barang.setKategori(rs.getString("kategori"));
                barang.setIsi(rs.getDouble("isi"));
                barang.setSatuan(rs.getString("satuan"));
                barang.setKemasan(rs.getString("kemasan"));
               
                list.add(barang);
            }
            return list;
           
        } catch (SQLException ex) {
            Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<MasterBarang> getBarang() throws RemoteException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<MasterBarang> list = new ArrayList<>();
        
        String sql = "SELECT * FROM `dbmasterbarang`";
        try {
            statement =(PreparedStatement) connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while (rs.next()){
                MasterBarang barang = new MasterBarang();
                barang.setKode_barang(rs.getString("kode_barang"));
                barang.setNama_barang(rs.getString("nama_barang"));
                barang.setKategori(rs.getString("kategori"));
                barang.setIsi(rs.getDouble("isi"));
                barang.setSatuan(rs.getString("satuan"));
                barang.setKemasan(rs.getString("kemasan"));
               
                list.add(barang);
            }
            return list;
           
        } catch (SQLException ex) {
            Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(masterbarangImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
    