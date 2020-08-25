/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.server.daoimpl;
import entity.Admin;
import dao.adminDao;
import com.mysql.jdbc.PreparedStatement;
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
public class adminDaoImpl extends UnicastRemoteObject implements adminDao{
    
    private  Connection connection;
    
    public adminDaoImpl() throws RemoteException {
        connection = databaseutilities.getConnection();
    }

    
     @Override
    public boolean insert(Admin admin) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
        
        String sql = "INSERT INTO `admin`(`kode_user`, `nama_user`, `usernama`, `password`, `bagian`, `alamat`, `no_tlpn`) VALUES (?,?,?,?,?,?,?)";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, admin.getKd_user());
            statement.setString(2, admin.getNm_user());
            statement.setString(3, admin.getUser_name());
            statement.setString(4, admin.getUser_pass());
            statement.setString(5, admin.getBagian());
            statement.setString(6, admin.getTelepon());
            statement.setString(7, admin.getAlamat());
            
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(adminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(adminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

     @Override
    public boolean update(Admin admin) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
       
        String sql = "UPDATE  admin set nama_user=?, usernama = ? , password = ?, bagian = ?,alamat = ?, no_tlpn=? where kode_user = ? ";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, admin.getNm_user());
            statement.setString(2, admin.getUser_name());
            statement.setString(3, admin.getUser_pass());
            statement.setString(4, admin.getBagian());
            statement.setString(5, admin.getTelepon());
            statement.setString(6, admin.getAlamat());
            statement.setString(7, admin.getKd_user());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(adminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(adminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

     @Override
    public boolean delete(Admin admin) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
        
        String sql = "DELETE from admin where kode_user = ?";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            
           
            statement.setString(1, admin.getKd_user());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(adminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(adminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    @Override
    public Admin getadmin(String id) throws RemoteException {
       PreparedStatement statement = null;
        ResultSet rs = null;
        Admin admin=null;
        
        String sql = "SELECT * from admin where kode_user=?";
        try {
            statement =(PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, id);
            rs=statement.executeQuery();
            while (rs.next()){
                admin = new Admin();
                admin.setKd_user(rs.getString("kode_user"));
                admin.setNm_user(rs.getString("nama_user"));
                admin.setUser_name(rs.getString("usernama"));
                admin.setUser_pass(rs.getString("password"));
                admin.setBagian(rs.getString("bagian"));
                admin.setAlamat(rs.getString("alamat"));
                admin.setTelepon(rs.getString("no_tlpn"));
            }
            return admin;
        } catch (SQLException ex) {
            Logger.getLogger(adminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(adminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(adminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public Admin getadminLogin(Admin adm) throws RemoteException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Admin admin=null;
        
        String sql = "SELECT * FROM admin WHERE usernama=? AND password=?";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, adm.getUser_name());
            statement.setString(2, adm.getUser_pass());
            rs = statement.executeQuery();
            while(rs.next()){
                admin = new Admin();
                admin.setKd_user(rs.getString("kode_user"));
                admin.setNm_user(rs.getString("nama_user"));
                admin.setUser_name(rs.getString("usernama"));
                admin.setUser_pass(rs.getString("password"));
                admin.setBagian(rs.getString("bagian"));
                admin.setAlamat(rs.getString("alamat"));
                admin.setTelepon(rs.getString("no_tlpn"));
            }
            return admin;
        } catch (SQLException ex) {
            Logger.getLogger(adminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(adminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(adminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public List<Admin> getadmin() throws RemoteException {
         PreparedStatement statement = null;
        ResultSet rs = null;
        List<Admin> list = new ArrayList<>();
        
        String sql = "SELECT * FROM `admin`";
        try {
            statement =(PreparedStatement) connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while (rs.next()){
                Admin admin = new Admin();
                admin.setKd_user(rs.getString("kode_user"));
                admin.setNm_user(rs.getString("nama_user"));
                admin.setUser_name(rs.getString("usernama"));
                admin.setUser_pass(rs.getString("password"));
                admin.setBagian(rs.getString("bagian"));
                admin.setAlamat(rs.getString("alamat"));
                admin.setTelepon(rs.getString("no_tlpn"));
                list.add(admin);
            }
            return list;
           
        } catch (SQLException ex) {
            Logger.getLogger(adminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(adminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(adminDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
