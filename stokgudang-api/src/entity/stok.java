/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.Serializable;
import java.util.Objects;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;


/**
 *
 * @author Riki subagja
 */
public class stok implements Serializable {
    @TableColumn(name = "id", size=2, number = 1)
    private int id;
    @TableColumn(name = "Kode Barang", size = 15, number = 2)
    private String kode_barang;
    @TableColumn(name = "Nama Barang",size = 25, number = 3)
    private String nama_barang;
    @TableColumn(name = "Batch",size = 25, number = 4)
    private String batch;
     @TableColumn(name = "lokasi", number = 5)
    private String lokasi;
    @TableColumn(name = "qty", number = 6)
    private int qty;
    @TableColumn(name = "Total_qty", number = 7)
    private double total_qty;
    @TableColumn(name = "Isi", number = 8)
    private double isi;
    @TableColumn(name = "satuan", number = 9)
    private String satuan;
    @TableColumn(name = "kemasan", number = 10)
    private String kemasan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.id;
        hash = 43 * hash + Objects.hashCode(this.kode_barang);
        hash = 43 * hash + Objects.hashCode(this.nama_barang);
        hash = 43 * hash + Objects.hashCode(this.batch);
        hash = 43 * hash + Objects.hashCode(this.lokasi);
        hash = 43 * hash + this.qty;
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.total_qty) ^ (Double.doubleToLongBits(this.total_qty) >>> 32));
        hash = 43 * hash + (int) (Double.doubleToLongBits(this.isi) ^ (Double.doubleToLongBits(this.isi) >>> 32));
        hash = 43 * hash + Objects.hashCode(this.satuan);
        hash = 43 * hash + Objects.hashCode(this.kemasan);
        return hash;
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
        final stok other = (stok) obj;
        if (this.id != other.id) {
            return false;
        }
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
        if (!Objects.equals(this.lokasi, other.lokasi)) {
            return false;
        }
        if (!Objects.equals(this.satuan, other.satuan)) {
            return false;
        }
        if (!Objects.equals(this.kemasan, other.kemasan)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "stok{" + "id=" + id + ", kode_barang=" + kode_barang + ", nama_barang=" + nama_barang + ", batch=" + batch + ", lokasi=" + lokasi + ", qty=" + qty + ", total_qty=" + total_qty + ", isi=" + isi + ", satuan=" + satuan + ", kemasan=" + kemasan + '}';
    }

}
