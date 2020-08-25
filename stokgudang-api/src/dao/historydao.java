/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.histori;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Riki subagja
 */
public interface historydao extends Remote{
    boolean update (histori histori) throws RemoteException;
    boolean delete (histori histori) throws RemoteException;
   histori gethistoribyid(String id_histori) throws RemoteException;
   List<histori>gethistori() throws RemoteException;
}

