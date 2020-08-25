/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.server.daoimpl;
import dao.lokasidao;
import dao.masterbarangDao;
import dao.stokdao;
import entity.stok;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import stokgudang.client.dialog.JD_BarangInputM;

import stokgudang.server.db.databaseutilities;

/**
 *
 * @author Riki subagja
 */
public class stokimpl extends UnicastRemoteObject implements stokdao{
   
       private static final long serialVersionUID = 1L;
       private Connection connection;
       private masterbarangDao mbDao;
       private lokasidao lokDao;
       JD_BarangInputM barangInput = new JD_BarangInputM(mbDao, lokDao, this);
 
       public stokimpl() throws RemoteException{
           connection = databaseutilities.getConnection();
       }
       
       
    @Override
    public stok getstokbyid(String id_stok, String kdbarang) throws RemoteException {
        PreparedStatement statement=null;
        ResultSet rs=null;
        stok st=null;
        String testQuery ="\""+"%"+kdbarang+"%"+"\"";
        System.out.println(testQuery);
            try {
                statement= connection.prepareStatement("SELECT id,kode_barang, nama_barang, batch,lokasi, SUM(qty) AS qty, SUM(total_qty)"
                     + " AS total_qty, isi, satuan,kemasan "
                     + "FROM" 
                     + " transaksi where id=? AND kode_barang like "+ testQuery +" GROUP BY kode_barang,batch,kemasan ");
                statement.setString(1, id_stok);
                System.out.println(id_stok);
                rs=statement.executeQuery();
                 while(rs.next()){
                st=new stok();
                st.setId(rs.getInt("id"));
                st.setKode_barang(rs.getString("kode_barang"));
                st.setNama_barang(rs.getString("nama_barang"));
                st.setBatch(rs.getString("batch"));
                st.setLokasi(rs.getString("lokasi"));
                st.setQty(rs.getInt("qty"));
                st.setTotal_qty(rs.getDouble("total_qty"));
                st.setIsi(rs.getDouble("isi"));
                st.setSatuan(rs.getString("satuan"));
                st.setKemasan(rs.getString("kemasan"));
                }
                return st;
            } catch (SQLException ex) {
              Logger.getLogger(stokimpl.class.getName()).log(Level.SEVERE, null, ex);
              return null;
            }finally{
                if(st!=null){
                    try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(stokimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(stokimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
       
            
       @Override
    public List<stok> getstok(String kdbarang) throws RemoteException {
         
         PreparedStatement statement=null;
         ResultSet rs=null;
         List<stok> list= new ArrayList<>();
         String testQuery ="\""+"%"+kdbarang+"%"+"\"";
//         System.out.println("QUERY:"+testQuery);
         
        
         String sql="SELECT id,kode_barang, nama_barang, batch,lokasi, SUM(qty) AS qty, SUM(total_qty)"
                 + " AS total_qty, isi, satuan,kemasan "
                 + "FROM" 
                 + " transaksi WHERE kode_barang like  "+ testQuery +" GROUP BY kode_barang,batch, kemasan ";
       
        try {
            statement= (PreparedStatement) connection.prepareStatement(sql);
            
            rs=statement.executeQuery();
            while(rs.next()){
            stok  st=new stok();
            st.setId(rs.getInt("id"));
            st.setKode_barang(rs.getString("kode_barang"));
            st.setNama_barang(rs.getString("nama_barang"));
            st.setBatch(rs.getString("batch"));
            st.setLokasi(rs.getString("lokasi"));
            st.setQty(rs.getInt("qty"));
            st.setTotal_qty(rs.getDouble("total_qty"));
            st.setIsi(rs.getDouble("isi"));
            st.setSatuan(rs.getString("satuan"));
            st.setKemasan(rs.getString("kemasan"));
            
        
            list.add(st);
            }
            return list;
                        
            
        } catch (SQLException ex) {
              Logger.getLogger(stokimpl.class.getName()).log(Level.SEVERE, null, ex);
              return null;
          }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(stokimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(stokimpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }  
    }

   
    

   

   
}    
    
    

