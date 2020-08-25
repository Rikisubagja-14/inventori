/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.Kategori;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Riki subagja
 */
public interface kategoriDao extends Remote{
    boolean insert(Kategori kategori)throws RemoteException;
    boolean update(Kategori kategori)throws RemoteException;
    boolean delete(Kategori kategori)throws RemoteException;
    Kategori getKategori(String id)throws RemoteException;
    List<Kategori>getKategori() throws RemoteException;
}
