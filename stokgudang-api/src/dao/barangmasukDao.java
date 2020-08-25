/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import entity.BarangMasuk;
import entity.BarangMasukDetail;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Riki subagja
 */
public interface barangmasukDao extends Remote{
    boolean insert(BarangMasuk barangmasuk) throws RemoteException;
    List<BarangMasuk> getPembelian() throws RemoteException;
    List<BarangMasuk> getPembelian(Date tglMulai,Date tgAkhir) throws RemoteException;
    List<BarangMasukDetail> getPembelianDetil(String kode_transaksi ) throws RemoteException;
    BarangMasuk getbarangmasuk(String id) throws RemoteException;
}
