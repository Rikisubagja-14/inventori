/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.BarangKeluar;
import entity.BarangKeluarDetail;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Riki subagja
 */
public interface barangkeluarDao extends Remote{
    boolean insert(BarangKeluar barangkeluar) throws RemoteException;
    List<BarangKeluar> getbarangkeluar() throws RemoteException;
    List<BarangKeluar> getbarangkeluar(Date tglMulai,Date tgAkhir) throws RemoteException;
    List<BarangKeluarDetail> getBarangKeluardetail(String kode_transaksi) throws RemoteException;
    BarangKeluar getbarangkeluar (String id) throws RemoteException; 
}
