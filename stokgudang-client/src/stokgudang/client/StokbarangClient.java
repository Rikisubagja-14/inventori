/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.client;

import autonumber.autoNumber_interface;
import dao.adminDao;
import dao.barangkeluarDao;
import dao.barangmasukDao;
import dao.customerDao;
import dao.historydao;
import dao.lokasidao;
import dao.masterbarangDao;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.SwingUtilities;
import stokgudang.client.dialog.JF_Splash;
import dao.stokdao;


/**
 *
 * @author Riki subagja
 */
public class StokbarangClient {
    /**
     * @param args the command line arguments
     * @throws java.rmi.NotBoundException
     * @throws java.rmi.RemoteException
     */
    public static void main(String[] args) throws RemoteException, NotBoundException{
        // TODO code application logic here
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        
        
        Registry client = LocateRegistry.getRegistry("localhost", 1109);
        final adminDao AdminDao = (adminDao) client.lookup("admin");
        final autoNumber_interface autoNumber=(autoNumber_interface) client.lookup("auto");
        final customerDao CustomerDao=(customerDao) client.lookup("customer");
        final lokasidao lokasiDao = (lokasidao) client.lookup("lokasi");
        final masterbarangDao masterbarangDao=(masterbarangDao) client.lookup("masterbarang");
        final barangkeluarDao barangkeluarDao=(barangkeluarDao) client.lookup("barangkeluar");
        final barangmasukDao barangmasukDao=(barangmasukDao) client.lookup("barangmasuk");
        final stokdao stokdao=(stokdao)client.lookup("stok");
        final historydao historidao=(historydao)client.lookup("histori");
        
        JF_Splash ss = new JF_Splash();
        ss.setVisible(true);
            for (int i=0;i<=100;i++){
                ss.getProgressBar().setValue(i);
                try {
                    Thread.sleep(25);
                } catch (InterruptedException ex) {
                     java.util.logging.Logger.getLogger(StokbarangClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                }
            }
            ss.dispose();
            
            SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                MainMenu menu = new MainMenu(historidao);
                menu.setAdminDAO(AdminDao);
                menu.setCustomerDAO(CustomerDao);
                menu.setMasterbarangDAO(masterbarangDao);
                menu.setLokasiDAO(lokasiDao);
                menu.setBarangkeluarDAO(barangkeluarDao);
                menu.setBarangmasukDAO(barangmasukDao);
                menu.setAutoNumber_interface(autoNumber);
                menu.setstok(stokdao);
                menu.sethistori(historidao);
                menu.setVisible(true);
                menu.setAwal();
             
            }
        });
                    
            }
            }
                    
