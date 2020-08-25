/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.client;

import javax.swing.JDialog;
import net.sf.jasperreports.swing.JRViewer;

/**
 *
 * @author Riki subagja
 */
public class Tampilreport extends JDialog{
    private String title;
    private JRViewer jv;

    public Tampilreport(String title, JRViewer jv) {
        this.title = title;
        this.jv = jv;
        atur();
    }

    Tampilreport(String laporan_Penjualan_Berdasarkan_Tanggal, net.sf.jasperreports.view.JRViewer jv) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void atur(){
        setSize(1200, 750);
        setModal(true);
        setTitle(title);
        getContentPane().add(jv);
        setVisible(true);
    }
}
