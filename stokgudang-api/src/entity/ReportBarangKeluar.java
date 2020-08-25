/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import dao.barangkeluarDao;
import dao.barangmasukDao;
import entity.BarangKeluar;
/**
 *
 * @author Riki subagja
 */
public class ReportBarangKeluar {
    private barangkeluarDao barangkeluarDao; 
    private BarangKeluar barangkeluar ;
   
    public barangkeluarDao getbarangmasuk() {
        return barangkeluarDao ;
    }

    public void setbarangkeluarDao(barangkeluarDao barangkeluarDao) {
        this.barangkeluarDao = barangkeluarDao ;
    }
}
