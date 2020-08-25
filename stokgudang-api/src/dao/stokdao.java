/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import entity.stok;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Riki subagja
 */
public interface stokdao extends Remote {
   
    /**
     *
     * @param id_stok
     * @param lokasi
     * @param batch
     * @return
     * @throws RemoteException
     */
    stok getstokbyid(String id_stok, String kdbarang) throws RemoteException;
    List<stok>getstok(String kode_barang) throws RemoteException;

    
}
