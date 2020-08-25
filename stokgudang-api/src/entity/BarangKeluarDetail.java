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
public class BarangKeluarDetail implements Serializable{
    private LokasiPenyimpanan lokasi;
    private MasterBarang masterBarang;
    @TableColumn(name="No Transaksi",number=1)
    private String kode_transaksi;
    @TableColumn(name="Kode Barang",number=2)
    private String kode_barang;
    @TableColumn(name="Nama Barang",number=3)
    private String nama_barang;
    @TableColumn(name="Batch",number=4)
    private String batch;
    @TableColumn(name="Kategori NF",number=5)
    private String kategori_nf;
    @TableColumn(name = "Lokasi", number = 6)
    private String lok;
    @TableColumn(name="Qty",number=7)
    private int qty;
    @TableColumn(name="Isi",number=8)
    private Double isi;
    @TableColumn(name="Total_qty",number=9)
    private Double total_qty;
    @TableColumn(name="Satuan",number=10)
    private String satuan;
    @TableColumn(name="kemasan",number=11)
    private String kemasan;

    public LokasiPenyimpanan getLokasi() {
        return lokasi;
    }

    public void setLokasi(LokasiPenyimpanan lokasi) {
        this.lokasi = lokasi;
    }

    public MasterBarang getMasterBarang() {
        return masterBarang;
    }

    public void setMasterBarang(MasterBarang masterBarang) {
        this.masterBarang = masterBarang;
    }

    public String getKode_transaksi() {
        return kode_transaksi;
    }

    public void setKode_transaksi(String kode_transaksi) {
        this.kode_transaksi = kode_transaksi;
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

    public String getKategori_nf() {
        return kategori_nf;
    }

    public void setKategori_nf(String kategori_nf) {
        this.kategori_nf = kategori_nf;
    }

    public String getLok() {
        return lok;
    }

    public void setLok(String lok) {
        this.lok = lok;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Double getIsi() {
        return isi;
    }

    public void setIsi(Double isi) {
        this.isi = isi;
    }

    public Double getTotal_qty() {
        return total_qty;
    }

    public void setTotal_qty(Double total_qty) {
        this.total_qty = total_qty;
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
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.lokasi);
        hash = 53 * hash + Objects.hashCode(this.masterBarang);
        hash = 53 * hash + Objects.hashCode(this.kode_transaksi);
        hash = 53 * hash + Objects.hashCode(this.kode_barang);
        hash = 53 * hash + Objects.hashCode(this.nama_barang);
        hash = 53 * hash + Objects.hashCode(this.batch);
        hash = 53 * hash + Objects.hashCode(this.kategori_nf);
        hash = 53 * hash + Objects.hashCode(this.lok);
        hash = 53 * hash + this.qty;
        hash = 53 * hash + Objects.hashCode(this.isi);
        hash = 53 * hash + Objects.hashCode(this.total_qty);
        hash = 53 * hash + Objects.hashCode(this.satuan);
        hash = 53 * hash + Objects.hashCode(this.kemasan);
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
        final BarangKeluarDetail other = (BarangKeluarDetail) obj;
        if (this.qty != other.qty) {
            return false;
        }
        if (!Objects.equals(this.kode_transaksi, other.kode_transaksi)) {
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
        if (!Objects.equals(this.kategori_nf, other.kategori_nf)) {
            return false;
        }
        if (!Objects.equals(this.lok, other.lok)) {
            return false;
        }
        if (!Objects.equals(this.satuan, other.satuan)) {
            return false;
        }
        if (!Objects.equals(this.kemasan, other.kemasan)) {
            return false;
        }
        if (!Objects.equals(this.lokasi, other.lokasi)) {
            return false;
        }
        if (!Objects.equals(this.masterBarang, other.masterBarang)) {
            return false;
        }
        if (!Objects.equals(this.isi, other.isi)) {
            return false;
        }
        if (!Objects.equals(this.total_qty, other.total_qty)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BarangKeluarDetail{" + "lokasi=" + lokasi + ", masterBarang=" + masterBarang + ", kode_transaksi=" + kode_transaksi + ", kode_barang=" + kode_barang + ", nama_barang=" + nama_barang + ", batch=" + batch + ", kategori_nf=" + kategori_nf + ", lok=" + lok + ", qty=" + qty + ", isi=" + isi + ", total_qty=" + total_qty + ", satuan=" + satuan + ", kemasan=" + kemasan + '}';
    }

    
}

    
