/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.server.daoimpl;

import com.mysql.jdbc.PreparedStatement;
import dao.customerDao;
import entity.Customer;
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
    public class customerImpl extends UnicastRemoteObject implements customerDao {
    

    private final Connection connection;

    public customerImpl() throws RemoteException {
        connection = databaseutilities.getConnection();
    }

    
    @Override
    public boolean insert(Customer customer) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
        
        String sql = "INSERT INTO `dbcustomer`(`kode_customer`, `nama_customer`, `wilayah`, `no_tlp`) VALUES (?,?,?,?)";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, customer.getkode_customer());
            statement.setString(2, customer.getnamacustomer());
            statement.setString(3, customer.getAlamat());
            statement.setString(4, customer.getTelp());
            
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(customerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(customerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    
    @Override
    public boolean update(Customer customer) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
        
        String sql = "UPDATE  dbcustomer set nama_customer=?, wilayah=?, no_tlp=? where kode_customer=? ";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            
            statement.setString(1, customer.getnamacustomer());
            statement.setString(2, customer.getAlamat());
            statement.setString(3, customer.getTelp());
            statement.setString(4, customer.getkode_customer());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(customerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(customerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

    
    @Override
    public boolean delete(Customer customer) throws RemoteException {
        PreparedStatement statement = null;
        boolean valid = false;
        
        String sql = "DELETE from dbcustomer where kode_customer = ?";
        try {
            statement = (PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, customer.getkode_customer());
            statement.executeUpdate();
            valid = true;
        } catch (SQLException ex) {
            Logger.getLogger(customerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(customerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return valid;
    }

   
    @Override
    public Customer getcustomer(String id) throws RemoteException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        Customer customer =null;
        
        String sql = "SELECT * from dbcustomer where kode_customer=?";
        try {
            statement =(PreparedStatement) connection.prepareStatement(sql);
            statement.setString(1, id);
            rs=statement.executeQuery();
            while (rs.next()){
                customer = new Customer();
                customer.setkode_customer(rs.getString("kode_customer"));
                customer.setnamacustomer(rs.getString("nama_customer"));
                customer.setAlamat(rs.getString("wilayah"));
                customer.setTelp(rs.getString("no_tlp"));
                
            }
            return customer;
        } catch (SQLException ex) {
            Logger.getLogger(customerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(customerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(customerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    
    @Override
    public List<Customer> getcustomer() throws RemoteException {
        PreparedStatement statement = null;
        ResultSet rs = null;
        List<Customer> list = new ArrayList<>();
        
        String sql = "SELECT * FROM `dbcustomer` ";
        try {
            statement =(PreparedStatement) connection.prepareStatement(sql);
            rs=statement.executeQuery();
            while (rs.next()){
                Customer customer = new Customer();
                customer.setkode_customer(rs.getString("kode_customer"));
                customer.setnamacustomer(rs.getString("nama_customer"));
                customer.setAlamat(rs.getString("wilayah"));
                customer.setTelp(rs.getString("no_tlp"));
                list.add(customer);
            }
            return list;
           
        } catch (SQLException ex) {
            Logger.getLogger(customerImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }finally{
            if(statement!=null){
                try {
                    statement.close();
                } catch (SQLException ex) {
                    Logger.getLogger(customerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException ex) {
                    Logger.getLogger(customerImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

   
}
