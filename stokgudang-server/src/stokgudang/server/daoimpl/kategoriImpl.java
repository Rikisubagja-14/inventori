/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.server.daoimpl;

import com.mysql.jdbc.PreparedStatement;
import dao.kategoriDao;
import entity.Kategori;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
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
public class kategoriImpl extends UnicastRemoteObject implements kategoriDao{
   private final Connection connection;

    public kategoriImpl() throws RemoteException {
        connection = databaseutilities.getConnection();
    }
    
    
    
   @Override
    public boolean insert(Kategori kategori) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
        
        String sql = "INSERT INTO `dbkategori`(`kode_kategori`, `nama_kategori`) VALUES (?,?)";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, kategori.getKode_kategori());
            statement.setString(2, kategori.getNama_kategori());
            
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(kategoriImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(kategoriImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    
   @Override
    public boolean update(Kategori kategori) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
       
        String sql = "UPDATE `dbkategori` SET `nama_kategori`=? WHERE `kode_kategori`=?";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, kategori.getNama_kategori());
            statement.setString(2, kategori.getKode_kategori());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(kategoriImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(kategoriImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    
   @Override
    public boolean delete(Kategori kategori) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
        
        String sql = "DELETE FROM `dbkategori` WHERE `kode_kategori`=?";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            
           
            statement.setString(1, kategori.getKode_kategori());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(kategoriImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(kategoriImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

   
   @Override
    public Kategori getKategori(String id) throws RemoteException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Kategori kategori=null;
        
        String sql = "SELECT * FROM `dbkategori` WHERE `kode_kategori`=?";
        try {
            statement =(PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, id);
            rs=statement.executeQuery();
            while (rs.next()){
                kategori = new Kategori();
                kategori.setKode_kategori(rs.getString("kode_kategori"));
                kategori.setNama_kategori(rs.getString("nama_kategori"));
                
            }
            return kategori;
        } catch (SQLException ex) {
            Logger.getLogger(kategoriImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(kategoriImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(kategoriImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Kategori> getKategori() throws RemoteException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Kategori> list = new ArrayList<>();
        
        String sql = "SELECT * from dbkategori ";
        try {
            statement =(PreparedStatement) connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while (rs.next()){
                Kategori kategori = new Kategori();
                kategori.setKode_kategori(rs.getString("kode_kategori"));
                kategori.setNama_kategori(rs.getString("nama_kategori"));
                
                list.add(kategori);
            }
            return list;
           
        } catch (SQLException ex) {
            Logger.getLogger(kategoriImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(kategoriImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(kategoriImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

 
}
