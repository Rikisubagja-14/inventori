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
public class Kategori implements Serializable{
   @TableColumn(name="Kode",number=1)
   private String kode_kategori;
    @TableColumn(name="Nama Kategori",number=2, size = 50)
   private String nama_kategori;

    public String getKode_kategori() {
        return kode_kategori;
    }

    public void setKode_kategori(String kode_kategori) {
        this.kode_kategori = kode_kategori;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.kode_kategori);
        hash = 83 * hash + Objects.hashCode(this.nama_kategori);
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
        final Kategori other = (Kategori) obj;
        if (!Objects.equals(this.kode_kategori, other.kode_kategori)) {
            return false;
        }
        return Objects.equals(this.nama_kategori, other.nama_kategori);
    }

    @Override
    public String toString() {
        return nama_kategori;
    }

}