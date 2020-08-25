/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.LokasiPenyimpanan;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Riki subagja
 */
public interface lokasidao extends Remote{
    boolean insert(LokasiPenyimpanan lokasi)throws RemoteException;
    boolean update(LokasiPenyimpanan lokasi)throws RemoteException;
    boolean delete(LokasiPenyimpanan lokasi)throws RemoteException;
    LokasiPenyimpanan getlokasibyID(String id_lokasi)throws RemoteException;
    List<LokasiPenyimpanan>getlokasi()throws RemoteException;
}

