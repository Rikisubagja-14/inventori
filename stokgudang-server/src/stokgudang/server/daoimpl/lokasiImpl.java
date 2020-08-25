/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.server.daoimpl;

import dao.lokasidao;
import entity.LokasiPenyimpanan;
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
import javax.print.DocFlavor;
import stokgudang.server.db.databaseutilities;

/**
 *
 * @author Riki subagja
 */
public class lokasiImpl extends UnicastRemoteObject implements lokasidao{

    private Connection connection;
    
    public lokasiImpl() throws RemoteException{
        connection = databaseutilities.getConnection();
    }
    
    @Override
    public boolean insert(LokasiPenyimpanan lokasi) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
        
        String sql = "INSERT INTO `lokasi`(`kode_lokasi`, `keterangan`) VALUES (?,?) ";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, lokasi.getKode_lokasi());
            statement.setString(2, lokasi.getKeterangan_lokasi());
            
            statement.executeUpdate();
            valid=true;
        } catch (SQLException e) {
            Logger.getLogger(lokasiImpl.class.getName()).log(Level.SEVERE, null,e);
        } finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(lokasiImpl.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean update(LokasiPenyimpanan lokasi) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
        
        String sql ="UPDATE `lokasi` SET `keterangan`=? WHERE kode_lokasi=?";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, lokasi.getKeterangan_lokasi());
            statement.setString(2, lokasi.getKode_lokasi());
            statement.executeUpdate();
            valid=true;
        } catch (SQLException e) {
            Logger.getLogger(lokasiImpl.class.getName()).log(Level.SEVERE, null,e);
        } finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(lokasiImpl.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        return valid;
    }

    @Override
    public boolean delete(LokasiPenyimpanan lokasi) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
        
        String sql = "DELETE FROM `lokasi` WHERE `kode_lokasi`=? ";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, lokasi.getKode_lokasi());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException e) {
            Logger.getLogger(lokasiImpl.class.getName()).log(Level.SEVERE, null,e);
        } finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(lokasiImpl.class.getName()).log(Level.SEVERE, null,e);
                }
            }
        }
        return valid;
    }

    @Override
    public LokasiPenyimpanan getlokasibyID(String id_lokasi) throws RemoteException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        LokasiPenyimpanan lokasi = null;
        
        String sql = "SELECT * FROM `lokasi` WHERE `kode_lokasi`=?";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, id_lokasi);
            rs = statement.executeQuery();
            
            while(rs.next()){
                lokasi = new LokasiPenyimpanan();
                lokasi.setKode_lokasi(rs.getString("kode_lokasi"));
                lokasi.setKeterangan_lokasi(rs.getString("keterangan"));
            }
            return lokasi;
        } catch (SQLException e) {
            Logger.getLogger(lokasiImpl.class.getName()).log(Level.SEVERE, null,e);
            return null;
        } finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(lokasiImpl.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    Logger.getLogger(lokasiImpl.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }

    @Override
    public List<LokasiPenyimpanan> getlokasi() throws RemoteException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<LokasiPenyimpanan> list = new ArrayList<>();
        
        String sql = "SELECT * FROM `lokasi`";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            rs = statement.executeQuery();
            
            while(rs.next()){
                LokasiPenyimpanan lokasi = new LokasiPenyimpanan();
                lokasi.setKode_lokasi(rs.getString("kode_lokasi"));
                lokasi.setKeterangan_lokasi(rs.getString("keterangan"));
                list.add(lokasi);
            }
            return list;
        } catch (SQLException e) {
            Logger.getLogger(lokasiImpl.class.getName()).log(Level.SEVERE, null, e);
            return null;
        } finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    Logger.getLogger(lokasiImpl.class.getName()).log(Level.SEVERE, null, e);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    Logger.getLogger(lokasiImpl.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }
    
}
