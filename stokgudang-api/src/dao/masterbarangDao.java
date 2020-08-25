/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.MasterBarang;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Riki subagja
 */
public interface masterbarangDao extends Remote{
  boolean insert (MasterBarang  masterbarang) throws RemoteException;
  boolean update (MasterBarang masterbarang) throws RemoteException;
  boolean delete (MasterBarang masterbarang) throws RemoteException;
  boolean kurangJumlahStok(double qty, MasterBarang masterbarang)throws RemoteException;
  boolean tambahJumlahStok(double qty, MasterBarang masterbarang)throws RemoteException;
  MasterBarang getById(String Id)throws RemoteException;
  List<MasterBarang> getBarang()throws RemoteException;
  List<MasterBarang> getBarangNotIn()throws RemoteException; 
}
