/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Riki subagja
 */
public class MasterBarang implements Serializable{

    
     @TableColumn(name="Kode", number=1)
    private String kode_barang;
    @TableColumn(name="Nama", number=2)
    private String nama_barang;
    @TableColumn(name="kategori", number=3)
    private String kategori;
    @TableColumn(name="isi", number=4)
    private double isi;
    @TableColumn(name="satuan", number=5)
    private String satuan;
    @TableColumn(name="kemasan", number=6)
    private String kemasan;

    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.kode_barang);
        hash = 97 * hash + Objects.hashCode(this.nama_barang);
        hash = 97 * hash + Objects.hashCode(this.kategori);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.isi) ^ (Double.doubleToLongBits(this.isi) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.satuan);
        hash = 97 * hash + Objects.hashCode(this.kemasan);
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
        final MasterBarang other = (MasterBarang) obj;
        if (Double.doubleToLongBits(this.isi) != Double.doubleToLongBits(other.isi)) {
            return false;
        }
        if (!Objects.equals(this.kode_barang, other.kode_barang)) {
            return false;
        }
        if (!Objects.equals(this.nama_barang, other.nama_barang)) {
            return false;
        }
        if (!Objects.equals(this.satuan, other.satuan)) {
            return false;
        }
        if (!Objects.equals(this.kemasan, other.kemasan)) {
            return false;
        }
        return Objects.equals(this.kategori, other.kategori);
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

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
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
    public String toString() {
        return "masterbarang{" + "kode_barang=" + kode_barang + ", nama_barang=" + nama_barang + ", kategori=" + kategori + ", isi=" + isi + ", satuan=" + satuan + ", kemasan=" + kemasan + '}';
    }
    
}
