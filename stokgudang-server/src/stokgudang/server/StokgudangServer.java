/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.server;
import autonumber.autoNumber_interface;
import stokgudang.server.daoimpl.customerImpl;
import stokgudang.server.daoimpl.adminDaoImpl;
import stokgudang.server.daoimpl.masterbarangImpl;
import stokgudang.server.daoimpl.barangmasukImpl;
import stokgudang.server.daoimpl.barangkeluarImpl;
import  stokgudang.server.daoimpl.stokimpl;
import dao.adminDao;
import dao.masterbarangDao;
import dao.customerDao;
import dao.barangmasukDao;
import dao.barangkeluarDao;
import dao.lokasidao;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;
import stokgudang.server.daoimpl.lokasiImpl;
import dao.stokdao;
import dao.historydao;
import stokgudang.server.daoimpl.historiimpl;

/**
 *
 * @author Riki subagja
 */
public class StokgudangServer {

    /**
     * @param args the command line arguments
     * @throws java.rmi.RemoteException
     */
    public static void main(String[] args) throws RemoteException, AccessException, NotBoundException {
        Registry server = LocateRegistry.createRegistry(1109);
        adminDao adminDao = (adminDao) new adminDaoImpl(); //interface diisi kelas
        autoNumber_interface autoNumber_Interface =new stokgudang.server.daoimpl.autonumber();
        customerDao  customerDao = (customerDao) new customerImpl();
        masterbarangDao masterbarangDao =(masterbarangDao) new masterbarangImpl();
        lokasidao lokasiDao = (lokasidao) new lokasiImpl();
        barangmasukDao barangmasukDao= (barangmasukDao) new barangmasukImpl();
        barangkeluarDao barangkeluarDao =(barangkeluarDao) new barangkeluarImpl();
        stokdao stokdao = (stokdao) new stokimpl();
        historydao historidao=(historydao)new historiimpl();
        
        server.rebind("admin", (Remote) adminDao);
        server.rebind("auto", (Remote) autoNumber_Interface);
        server.rebind("customer", (Remote) customerDao);
        server.rebind("lokasi", (Remote) lokasiDao);
        server.rebind("masterbarang", (Remote) masterbarangDao);
        server.rebind("barangkeluar", (Remote) barangkeluarDao);
        server.rebind("barangmasuk",(Remote)barangmasukDao);
        server.rebind("stok",(Remote) stokdao);
        server.rebind("histori", (Remote) historidao);
        JOptionPane.showMessageDialog(null, "SERVER BERJALAN!");
        System.out.println("selamat server anda sudah berjalan");
        
    }
    
}
