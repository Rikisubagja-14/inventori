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
public class Customer implements Serializable{
       
  @TableColumn(name="Kode Customer",number=1,size=10)
  private String kode_customer;
  @TableColumn(name="Nama Customer",number=2,size=25)
  private String nama_customer;
  @TableColumn(name="Alamat/Wilayah",number=3,size=35)
  private String alamat;
  @TableColumn(name="Telepon",number=4,size=19)
  private String no_tlpn ;

    public String getkode_customer() {
        return kode_customer;
    }

    public void setkode_customer(String kode_customer) {
        this.kode_customer = kode_customer;
    }

    public String getnamacustomer() {
        return nama_customer;
    }

    public void setnamacustomer(String nama_customer) {
        this.nama_customer = nama_customer;
    }

    public String getTelp() {
        return no_tlpn;
    }

    public void setTelp(String no_tlp) {
        this.no_tlpn = no_tlp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.kode_customer);
        hash = 83 * hash + Objects.hashCode(this.nama_customer);
        hash = 83 * hash + Objects.hashCode(this.no_tlpn);
        hash = 83 * hash + Objects.hashCode(this.alamat);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (!Objects.equals(this.kode_customer, other.kode_customer)) {
            return false;
        }
        if (!Objects.equals(this.nama_customer, other.nama_customer)) {
            return false;
        }
        if (!Objects.equals(this.no_tlpn, other.no_tlpn)) {
            return false;
        }
        return Objects.equals(this.alamat, other.alamat);
    }

    @Override
    public String toString() {
        return kode_customer ;
    }
  
}
