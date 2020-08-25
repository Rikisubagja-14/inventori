/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.server.daoimpl;

import dao.historydao;
import entity.histori;
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

/**
 *
 * @author Riki subagja
 */
public class historiimpl extends  UnicastRemoteObject implements historydao {
    
      private static final long serialVersionUID = 1L;
       private Connection connection;
       public historiimpl() throws RemoteException{
           connection = databaseutilities.getConnection();
       }
    
    
    
    
    
    @Override
    public histori gethistoribyid(String id_histori) throws RemoteException {
        PreparedStatement statement=null;
         ResultSet rs=null;
         histori hs=null;
        
        String sql="SELECT * FROM histori ";
           
        try {
            
            statement= (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, id_histori);
            rs=statement.executeQuery();
            while(rs.next()){
            hs=new histori();
            hs.setKode_barang(rs.getString("kode_barang"));
            hs.setNama_barang(rs.getString("nama_barang"));
            hs.setBatch(rs.getString("batch"));
            hs.setQty(rs.getInt("qty"));
            hs.setTotal_qty(rs.getDouble("total_qty"));
            hs.setIsi(rs.getDouble("isi"));
            hs.setSatuan(rs.getString("satuan"));
            hs.setKemasan(rs.getString("kemasan"));
            hs.setKode_transaksi(rs.getString("kode_transaksi"));
            hs.setNama_customer(rs.getString("nama_customer"));
            hs.setTanggal(rs.getDate("tanggal"));
            }
            return hs;
                        
            
        } catch (SQLException ex) {
              Logger.getLogger(historiimpl.class.getName()).log(Level.SEVERE, null, ex);
              return null;
          }finally{
            if(hs!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(historiimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(historiimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<histori> gethistori() throws RemoteException {
         PreparedStatement statement=null;
         ResultSet rs=null;
         List<histori> list= new ArrayList<>();
        
        String sql="SELECT * FROM histori ";
           
        try {
            
            statement= (PreparedStatement) connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while(rs.next()){
                histori hs = new histori();
            hs.setKode_barang(rs.getString("kode_barang"));
            hs.setNama_barang(rs.getString("nama_barang"));
            hs.setBatch(rs.getString("batch"));
            hs.setQty(rs.getInt("qty"));
            hs.setTotal_qty(rs.getDouble("total_qty"));
            hs.setIsi(rs.getDouble("isi"));
            hs.setSatuan(rs.getString("satuan"));
            hs.setKemasan(rs.getString("kemasan"));
            hs.setKode_transaksi(rs.getString("kode_transaksi"));
            hs.setNama_customer(rs.getString("nama_customer"));
            hs.setTanggal(rs.getDate("tanggal"));
            
            list.add(hs);
            }
            return list;
                        
            
        } catch (SQLException ex) {
              Logger.getLogger(historiimpl.class.getName()).log(Level.SEVERE, null, ex);
              return null;
          }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(historiimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(historiimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    
    }

    @Override
    public boolean update(histori histori) throws RemoteException {
    PreparedStatement statement=null;
    boolean valid=false;
    String sql="UPDATE `histori` SET `nama_barang`=?,`batch`=?,`qty`=?,`isi`=?,`total_qty`=?"
                + "`satuan`=?,`kemasan`=?,`nama_customer`=?,`tanggal`=? WHERE `kode_barang`=?";
        try {
            statement=(PreparedStatement)connection.prepareStatement(sql);
            statement.setString(1, histori.getNama_barang());
            statement.setString(2, histori.getBatch());
            statement.setDouble(3, histori.getQty());
            statement.setDouble(4, histori.getIsi());
            statement.setDouble(5, histori.getTotal_qty());
            statement.setString(6, histori.getSatuan());
            statement.setString(7, histori.getKemasan());
            statement.setString(8, histori.getKode_barang());
            statement.setString(9, histori.getNama_customer());
            statement.setDate(10, (java.sql.Date) histori.getTanggal());
            statement.executeUpdate();
        } catch (SQLException e) {
           Logger.getLogger(historiimpl.class.getName()).log(Level.SEVERE, null, e);
        }
          finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(historiimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean delete(histori histori) throws RemoteException {
       com.mysql.jdbc.PreparedStatement statement = null;
        boolean valid = false;
        
        String sql = "DELETE FROM `histori` WHERE `kode_barang`=?";
        try {
            statement = (com.mysql.jdbc.PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, histori.getKode_barang());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(historiimpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(historiimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        }
          return valid;
    }
}
