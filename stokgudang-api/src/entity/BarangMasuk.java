/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import com.stripbandunk.jwidget.annotation.TableColumn;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Riki subagja
 */
public class BarangMasuk implements Serializable{

   @TableColumn(name = "kode transaksi", number = 1)
   private String kode_transaksi;
   @TableColumn(name = "Tanggal", number = 2)
   private Date tgl;
   @TableColumn(name = "Customer",number = 3)
   private Customer customer;
   @TableColumn(name = "Petugas", number = 4)
   private Admin petugas;
   private List<BarangMasukDetail>detailMasuk;

    public String getKode_transaksi() {
        return kode_transaksi;
    }

    public void setKode_transaksi(String kode_transaksi) {
        this.kode_transaksi = kode_transaksi;
    }

    public Date getTgl() {
        return tgl;
    }

    public void setTgl(Date tgl) {
        this.tgl = tgl;
    }

    public Customer getkode_Customer() {
        return customer;
    }

    public void setkode_Customer(Customer customer) {
        this.customer = customer;
    }

    public Admin getPetugas() {
        return petugas;
    }

    public void setPetugas(Admin petugas) {
        this.petugas = petugas;
    }

    public List<BarangMasukDetail> getDetailMasuk() {
        return Collections.unmodifiableList(detailMasuk);
    }

    public void setDetailMasuk(List<BarangMasukDetail> detailMasuk) {
        this.detailMasuk = detailMasuk;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.kode_transaksi);
        hash = 29 * hash + Objects.hashCode(this.tgl);
        hash = 29 * hash + Objects.hashCode(this.customer);
        hash = 29 * hash + Objects.hashCode(this.petugas);
        hash = 29 * hash + Objects.hashCode(this.detailMasuk);
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
        final BarangMasuk other = (BarangMasuk) obj;
        if (!Objects.equals(this.kode_transaksi, other.kode_transaksi)) {
            return false;
        }
        if (!Objects.equals(this.tgl, other.tgl)) {
            return false;
        }
        if (!Objects.equals(this.customer, other.customer)) {
            return false;
        }
        if (!Objects.equals(this.petugas, other.petugas)) {
            return false;
        }
        if (!Objects.equals(this.detailMasuk, other.detailMasuk)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "BarangMasuk{" + "kode_transaksi=" + kode_transaksi + ", tgl=" + tgl + ", customer=" + customer + ", petugas=" + petugas + ", detailMasuk=" + detailMasuk + '}';
    }

}

    
