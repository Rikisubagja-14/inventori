/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.Customer;
import entity.MasterBarang;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Riki subagja
 */
public interface customerDao extends Remote{
    boolean insert (Customer customer)throws RemoteException;
    boolean update (Customer customer)throws RemoteException;
    boolean delete (Customer customer)throws RemoteException;
    Customer getcustomer (String id)throws RemoteException;
    List<Customer> getcustomer()throws RemoteException; 
}
