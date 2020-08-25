/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;
import entity.BarangMasuk;
import dao.barangmasukDao;

/**
 *
 * @author Riki subagja
 */
public class ReportBarangMasuk {
    private barangmasukDao barangmasukDao;
    private BarangMasuk barangmasuk ;
    
    
    public barangmasukDao getbarangmasuk() {
        return barangmasukDao ;
    }

    public void setbarangmasukDao(barangmasukDao barangmasukDao) {
        this.barangmasukDao = barangmasukDao ;
    }

    
}
