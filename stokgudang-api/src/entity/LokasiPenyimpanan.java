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
public class LokasiPenyimpanan implements Serializable{

    private static final long serialVersionUID = 1L;
    @TableColumn(name="Kode Lokasi", number=1)
    private String kode_lokasi;
    @TableColumn(name="Keterangan", number=2)
    private String keterangan_lokasi;

    public String getKode_lokasi() {
        return kode_lokasi;
    }

    public void setKode_lokasi(String kode_lokasi) {
        this.kode_lokasi = kode_lokasi;
    }
    
    public String getKeterangan_lokasi() {
        return keterangan_lokasi;
    }

    public void setKeterangan_lokasi(String keterangan_lokasi) {
        this.keterangan_lokasi = keterangan_lokasi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.kode_lokasi);
        hash = 17 * hash + Objects.hashCode(this.keterangan_lokasi);
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
        final LokasiPenyimpanan other = (LokasiPenyimpanan) obj;
        if (!Objects.equals(this.kode_lokasi, other.kode_lokasi)) {
            return false;
        }
        if (!Objects.equals(this.keterangan_lokasi, other.keterangan_lokasi)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "LokasiPenyimpanan{" + "kode_lokasi=" + kode_lokasi + ", keterangan_lokasi=" + keterangan_lokasi + '}';
    }

    
}
