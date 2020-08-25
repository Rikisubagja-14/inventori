/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Riki subagja
 */
public class histori implements Serializable {
    @TableColumn(name = "Kode Barang", number = 1)
    private String kode_barang;
    @TableColumn(name = "Nama Barang", number = 2)
    private String nama_barang;
    @TableColumn(name = "Batch", number = 3)
    private String batch;
    @TableColumn(name = "qty", number = 4)
    private int qty;
    @TableColumn(name = "Total_qty", number = 5)
    private double total_qty;
    @TableColumn(name = "Isi", number = 6)
    private double isi;
    @TableColumn(name = "satuan", number = 7)
    private String satuan;
    @TableColumn(name = "kemasan", number = 8)
    private String kemasan;
    @TableColumn(name = "kode_transaksi", number = 9)
    private String kode_transaksi;
    @TableColumn(name = "nama_customer", number = 10)
    private String nama_customer;
    @TableColumn(name = "tanggal", number = 11)
    private  Date tanggal;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.kode_barang);
        hash = 97 * hash + Objects.hashCode(this.nama_barang);
        hash = 97 * hash + Objects.hashCode(this.batch);
        hash = 97 * hash + this.qty;
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.total_qty) ^ (Double.doubleToLongBits(this.total_qty) >>> 32));
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.isi) ^ (Double.doubleToLongBits(this.isi) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.satuan);
        hash = 97 * hash + Objects.hashCode(this.kemasan);
        hash = 97 * hash + Objects.hashCode(this.kode_transaksi);
        hash = 97 * hash + Objects.hashCode(this.nama_customer);
        hash = 97 * hash + Objects.hashCode(this.tanggal);
        return hash;
    }

    @Override
    public String toString() {
        return "histori{" + "kode_barang=" + kode_barang + ", nama_barang=" + nama_barang + ", batch=" + batch + ", qty=" + qty + ", total_qty=" + total_qty + ", isi=" + isi + ", satuan=" + satuan + ", kemasan=" + kemasan + ", kode_transaksi=" + kode_transaksi + ", nama_customer=" + nama_customer + ", tanggal=" + tanggal + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final histori other = (histori) obj;
        if (this.qty != other.qty) {
            return false;
        }
        if (Double.doubleToLongBits(this.total_qty) != Double.doubleToLongBits(other.total_qty)) {
            return false;
        }
        if (Double.doubleToLongBits(this.isi) != Double.doubleToLongBits(other.isi)) {
            return false;
        }
        if (!Objects.equals(this.kode_barang, other.kode_barang)) {
            return false;
        }
        if (!Objects.equals(this.nama_barang, other.nama_barang)) {
            return false;
        }
        if (!Objects.equals(this.batch, other.batch)) {
            return false;
        }
        if (!Objects.equals(this.satuan, other.satuan)) {
            return false;
        }
        if (!Objects.equals(this.kemasan, other.kemasan)) {
            return false;
        }
        if (!Objects.equals(this.kode_transaksi, other.kode_transaksi)) {
            return false;
        }
        if (!Objects.equals(this.nama_customer, other.nama_customer)) {
            return false;
        }
        if (!Objects.equals(this.tanggal, other.tanggal)) {
            return false;
        }
        return true;
    }

    public String getKode_barang() {
        return kode_barang;
    }

    public void setKode_barang(String kode_barang) {
        this.kode_barang = kode_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal_qty() {
        return total_qty;
    }

    public void setTotal_qty(double total_qty) {
        this.total_qty = total_qty;
    }

    public double getIsi() {
        return isi;
    }

    public void setIsi(double isi) {
        this.isi = isi;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public String getKemasan() {
        return kemasan;
    }

    public void setKemasan(String kemasan) {
        this.kemasan = kemasan;
    }

    public String getKode_transaksi() {
        return kode_transaksi;
    }

    public void setKode_transaksi(String kode_transaksi) {
        this.kode_transaksi = kode_transaksi;
    }

    public String getNama_customer() {
        return nama_customer;
    }

    public void setNama_customer(String nama_customer) {
        this.nama_customer = nama_customer;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

   
    
}
