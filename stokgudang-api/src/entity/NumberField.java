/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Riki subagja
 */
public class NumberField implements Serializable{
    private String awalan="";
    private int panjangField;
    private String namaField;
    private String namaTabel;

    @Override
    public String toString() {
        return "NumberField{" + "awalan=" + awalan + ", panjangField=" + panjangField + ", namaField=" + namaField + ", namaTabel=" + namaTabel + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.awalan);
        hash = 41 * hash + this.panjangField;
        hash = 41 * hash + Objects.hashCode(this.namaField);
        hash = 41 * hash + Objects.hashCode(this.namaTabel);
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
        final NumberField other = (NumberField) obj;
        if (this.panjangField != other.panjangField) {
            return false;
        }
        if (!Objects.equals(this.awalan, other.awalan)) {
            return false;
        }
        if (!Objects.equals(this.namaField, other.namaField)) {
            return false;
        }
        if (!Objects.equals(this.namaTabel, other.namaTabel)) {
            return false;
        }
        return true;
    }

    public String getAwalan() {
        return awalan;
    }

    public void setAwalan(String awalan) {
        this.awalan = awalan;
    }

    public int getPanjangField() {
        return panjangField;
    }

    public void setPanjangField(int panjangField) {
        this.panjangField = panjangField;
    }

    public String getNamaField() {
        return namaField;
    }

    public void setNamaField(String namaField) {
        this.namaField = namaField;
    }

    public String getNamaTabel() {
        return namaTabel;
    }

    public void setNamaTabel(String namaTabel) {
        this.namaTabel = namaTabel;
    }
}
