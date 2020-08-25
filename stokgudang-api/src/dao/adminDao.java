/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Admin;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Riki subagja
 */
public interface adminDao extends Remote{
    boolean insert (Admin admin)throws RemoteException;
    boolean update (Admin admin)throws RemoteException;
    boolean delete (Admin admin)throws RemoteException;
    Admin getadmin (String id)throws RemoteException;
    Admin getadminLogin(Admin admin) throws RemoteException;
    List<Admin> getadmin()throws RemoteException;
}
