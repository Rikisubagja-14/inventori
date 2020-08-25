/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.client;

import dao.adminDao;
import java.awt.Dimension;
import javax.swing.JInternalFrame;
import stokgudang.client.view.JIF_Admin;
import autonumber.autoNumber_interface;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;
import dao.barangkeluarDao;
import dao.barangmasukDao;
import dao.stokdao;
import dao.historydao;
import entity.histori;
import dao.customerDao;
import dao.historydao;
import dao.lokasidao;
import dao.masterbarangDao;
import entity.Admin;
import entity.stok;
import entity.BarangMasuk;
import entity.BarangMasukDetail;
import entity.BarangKeluar;
import entity.BarangMasuk;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import stokgudang.client.dialog.JD_Login;
import stokgudang.client.view.JD_Histori;
import stokgudang.client.view.JD_kartuStok;
import stokgudang.client.view.JD_saldoPerItem;
import stokgudang.client.view.JIF_Barang;
import stokgudang.client.view.JIF_Customer;
import stokgudang.client.view.JIF_Lokasi;
import stokgudang.client.view.JIF_TransaksiKeluar;
import stokgudang.client.view.JIF_TransaksiMasuk;
import stokgudang.client.dialog.JD_CariTanggal;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import stokgudang.client.lap.path.directori;




/**
 *
 * @author Riki subagja
 */
public class MainMenu extends javax.swing.JFrame {

    private adminDao AdminDAO;
    private barangkeluarDao BarangkeluarDAO;
    private barangmasukDao BarangmasukDAO;
    private customerDao CustomerDAO;
    private lokasidao LokasiDAO;
    private masterbarangDao MasterbarangDAO;
    private stokdao s_dao;
    private historydao histo;
    private histori his;
    private Admin ad;
    private autoNumber_interface AutoNumber_interface;
    
    public MainMenu(historydao hisDao) {
        this.setTitle("Program Inventori Gudang");
        this.histo = hisDao;
        initComponents();
        tampilkanJam();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    public final void tampilkanJam(){
        ActionListener taskPerformer = new ActionListener() {

        public void actionPerformed(ActionEvent evt) {
        String nol_jam = "", nol_menit = "",nol_detik = "";
        String nol_hari = "", nol_bulan = "",nol_tahun = "";
        Calendar kalender = new GregorianCalendar();
        java.util.Date dateTime = new java.util.Date();
        int nilai_jam = dateTime.getHours();
        int nilai_menit = dateTime.getMinutes();
        int nilai_detik = dateTime.getSeconds();
        int nilai_hari = dateTime.getDate();
        int nilai_bulan = dateTime.getMonth()+1;
        int nilai_tahun = kalender.get(Calendar.YEAR);

        if(nilai_hari <= 9) nol_hari= "0";
        if(nilai_bulan <= 9) nol_bulan= "0";

        String hari = nol_hari + Integer.toString(nilai_hari);
        String bulan = nol_bulan + Integer.toString(nilai_bulan);
        String tahun = Integer.toString(nilai_tahun);

        if(nilai_jam <= 9) nol_jam= "0";
        if(nilai_menit <= 9) nol_menit= "0";
        if(nilai_detik <= 9) nol_detik="0";
        

        String jam = nol_jam + Integer.toString(nilai_jam);
        String menit = nol_menit + Integer.toString(nilai_menit);
        String detik = nol_detik + Integer.toString(nilai_detik);
        
        lbl_waktu.setText(jam+":"+menit+":"+detik+"("+hari+"/"+bulan+"/"+tahun+")");
        }
        };
        new javax.swing.Timer(1000, taskPerformer).start();
    }
    
    //<editor-fold defaultstate="collapsed" desc="geter remote ">
    
    public void setAdminDAO(adminDao AdminDAO) {
        this.AdminDAO = AdminDAO;
    }

    public void setBarangkeluarDAO(barangkeluarDao BarangkeluarDAO) {
        this.BarangkeluarDAO = BarangkeluarDAO;
    }

    public void setBarangmasukDAO(barangmasukDao BarangmasukDAO) {
        this.BarangmasukDAO = BarangmasukDAO;
    }

    public void setCustomerDAO(customerDao CustomerDAO) {
        this.CustomerDAO = CustomerDAO;
    }

    public void setLokasiDAO(lokasidao LokasiDAO) {
        this.LokasiDAO = LokasiDAO;
    }

    public void setMasterbarangDAO(masterbarangDao MasterbarangDAO) {
        this.MasterbarangDAO = MasterbarangDAO;
    }

    public void setAutoNumber_interface(autoNumber_interface AutoNumber_interface) {
        this.AutoNumber_interface = AutoNumber_interface;
    }
    public  void  setstok(stokdao stokdao){
        this.s_dao= stokdao;
    }
    public  void  sethistori(historydao historidao){
        this.histo= historidao;
    }
//    </editor-fold>
    
    public void setAwal(){
        tampilkanJam();
        aturkeAdmin(false);
        JD_Login L = new JD_Login(AdminDAO);
        ad = L.tampil();
            
            switch (ad.getBagian()){
                case "Admin":
                    aturkeAdmin(true);
                    break;
                case "Petugas":
                    aturkePG(true);
                    break;
//                case "Manager":
//                    aturkeManager(true);
//                    break;
            }
    }
    
    private void aturkeAdmin(boolean valid) {
        menuAkun.setEnabled(valid);
        menuMaster.setEnabled(valid);
        menuLaporan.setEnabled(valid);
        menuTransaksi.setEnabled(valid);
        menuBarang.setEnabled(valid);
       
        
    }

    private void aturkePG(boolean valid) {
        menuAkun.setEnabled(valid);
        menuMaster.setEnabled(valid);
            ItemPengguna.setEnabled(false);
            ItemCustomer.setEnabled(false);
        menuLaporan.setEnabled(valid);
            ItemLaporanPengguna.setEnabled(false);
        menuTransaksi.setEnabled(valid);
            ItemHistori.setEnabled(false);
            ItemKartuStok.setEnabled(false);
            ItemSaldo.setEnabled(false);
        menuBarang.setEnabled(valid);
       
    }

//    private void aturkeManager(boolean valid) {
//        menuAkun.setEnabled(valid);
//        menuMaster.setEnabled(valid);
//            ItemPengguna.setEnabled(false);
//            ItemCustomer.setEnabled(false);
//        menuLaporan.setEnabled(valid);
////            ItemLaporanPengguna.setEnabled(false);
//            
//        menuTransaksi.setEnabled(valid);
////            ItemHistori.setEnabled(false);
////            ItemKartuStok.setEnabled(false);
////            ItemSaldo.setEnabled(false);
//        menuBarang.setEnabled(valid);
//        menuBantuan.setEnabled(valid);
//    }
    
    private void setSkrin(JInternalFrame frame){
        jDesktopPane1.add(frame);
        Dimension scren=this.getSize();
        Dimension dim=frame.getSize();
        frame.setLocation((scren.width-dim.width)/2,(scren.height-dim.height)/3);
        frame.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        lbl_waktu = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jDesktopPane1 = new ClGambarDesktop();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuAkun = new javax.swing.JMenu();
        itemInfoAkun = new javax.swing.JMenuItem();
        ItemKeluarAkun = new javax.swing.JMenuItem();
        ItemKeluarAplikasi = new javax.swing.JMenuItem();
        menuMaster = new javax.swing.JMenu();
        ItemPengguna = new javax.swing.JMenuItem();
        ItemCustomer = new javax.swing.JMenuItem();
        itemLokasi = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        menuBarang = new javax.swing.JMenuItem();
        menuTransaksi = new javax.swing.JMenu();
        ItemTransaksiMasuk = new javax.swing.JMenuItem();
        ItemTransaksiKeluar = new javax.swing.JMenuItem();
        ItemHistori = new javax.swing.JMenuItem();
        menuLaporan = new javax.swing.JMenu();
        ItemLaporanPengguna = new javax.swing.JMenuItem();
        ItemLaporanDataMasuk = new javax.swing.JMenuItem();
        ItemLaporanDataKeluar = new javax.swing.JMenuItem();
        ItemSaldo = new javax.swing.JMenuItem();
        ItemKartuStok = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(214, 237, 110));

        jPanel5.setBackground(new java.awt.Color(0, 102, 255));
        jPanel5.setForeground(new java.awt.Color(155, 163, 205));

        lbl_waktu.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(1090, Short.MAX_VALUE)
                .addComponent(lbl_waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 255));

        jPanel6.setBackground(new java.awt.Color(102, 153, 255));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 15, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 612, Short.MAX_VALUE)
        );

        jMenuBar1.setBackground(new java.awt.Color(51, 51, 51));

        menuAkun.setText("Akun");

        itemInfoAkun.setText("Informasi Akun");
        menuAkun.add(itemInfoAkun);

        ItemKeluarAkun.setText("Keluar Akun");
        ItemKeluarAkun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemKeluarAkunActionPerformed(evt);
            }
        });
        menuAkun.add(ItemKeluarAkun);

        ItemKeluarAplikasi.setText("Keluar Aplikasi");
        ItemKeluarAplikasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemKeluarAplikasiActionPerformed(evt);
            }
        });
        menuAkun.add(ItemKeluarAplikasi);

        jMenuBar1.add(menuAkun);

        menuMaster.setText("Master");
        menuMaster.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMasterActionPerformed(evt);
            }
        });

        ItemPengguna.setText("Kelola Pengguna");
        ItemPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemPenggunaActionPerformed(evt);
            }
        });
        menuMaster.add(ItemPengguna);

        ItemCustomer.setText("Kelola Customer");
        ItemCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemCustomerActionPerformed(evt);
            }
        });
        menuMaster.add(ItemCustomer);

        itemLokasi.setText("Kelola Lokasi");
        itemLokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemLokasiActionPerformed(evt);
            }
        });
        menuMaster.add(itemLokasi);
        menuMaster.add(jSeparator1);

        menuBarang.setText("Tambah Barang");
        menuBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBarangActionPerformed(evt);
            }
        });
        menuMaster.add(menuBarang);

        jMenuBar1.add(menuMaster);

        menuTransaksi.setText("Transaksi");

        ItemTransaksiMasuk.setText("Transaksi Masuk");
        ItemTransaksiMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemTransaksiMasukActionPerformed(evt);
            }
        });
        menuTransaksi.add(ItemTransaksiMasuk);

        ItemTransaksiKeluar.setText("Transaksi Keluar");
        ItemTransaksiKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemTransaksiKeluarActionPerformed(evt);
            }
        });
        menuTransaksi.add(ItemTransaksiKeluar);

        ItemHistori.setText("Histori");
        ItemHistori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemHistoriActionPerformed(evt);
            }
        });
        menuTransaksi.add(ItemHistori);

        jMenuBar1.add(menuTransaksi);

        menuLaporan.setText("Laporan");

        ItemLaporanPengguna.setText("Laporan Data Pengguna");
        menuLaporan.add(ItemLaporanPengguna);

        ItemLaporanDataMasuk.setText("Laporan Data Stok Masuk");
        ItemLaporanDataMasuk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemLaporanDataMasukActionPerformed(evt);
            }
        });
        menuLaporan.add(ItemLaporanDataMasuk);

        ItemLaporanDataKeluar.setText("Laporan Data Stok keluar");
        ItemLaporanDataKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemLaporanDataKeluarActionPerformed(evt);
            }
        });
        menuLaporan.add(ItemLaporanDataKeluar);

        ItemSaldo.setText("Saldo Per-Item");
        ItemSaldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemSaldoActionPerformed(evt);
            }
        });
        menuLaporan.add(ItemSaldo);

        ItemKartuStok.setText("Kartu Stok");
        ItemKartuStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemKartuStokActionPerformed(evt);
            }
        });
        menuLaporan.add(ItemKartuStok);

        jMenuBar1.add(menuLaporan);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ItemSaldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemSaldoActionPerformed
        JD_saldoPerItem tampil10 = 
                new JD_saldoPerItem(MasterbarangDAO);
        tampil10.loadawal();
        tampil10.setVisible(true);
    }//GEN-LAST:event_ItemSaldoActionPerformed

    private void ItemPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemPenggunaActionPerformed
        JIF_Admin tampil = 
                new JIF_Admin(AdminDAO, AutoNumber_interface);
        tampil.loadawal();
        setSkrin(tampil);
        
    }//GEN-LAST:event_ItemPenggunaActionPerformed

    private void ItemCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemCustomerActionPerformed
        JIF_Customer tampil2 = 
                new JIF_Customer(CustomerDAO, AutoNumber_interface);
        tampil2.loadAwal();
        setSkrin(tampil2);
    }//GEN-LAST:event_ItemCustomerActionPerformed

    private void ItemTransaksiMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemTransaksiMasukActionPerformed
        JIF_TransaksiMasuk tampil6 = 
                new JIF_TransaksiMasuk(AutoNumber_interface, s_dao, CustomerDAO, ad, MasterbarangDAO, BarangmasukDAO, LokasiDAO);
        tampil6.loadAwal();
        setSkrin(tampil6);
    }//GEN-LAST:event_ItemTransaksiMasukActionPerformed

    private void ItemTransaksiKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemTransaksiKeluarActionPerformed
        JIF_TransaksiKeluar tampil7 = 
                new JIF_TransaksiKeluar(AutoNumber_interface, CustomerDAO, MasterbarangDAO, ad, LokasiDAO, BarangkeluarDAO, s_dao);
        tampil7.loadAwal();
        setSkrin(tampil7);
    }//GEN-LAST:event_ItemTransaksiKeluarActionPerformed

    private void ItemKeluarAkunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemKeluarAkunActionPerformed
        setAwal();
    }//GEN-LAST:event_ItemKeluarAkunActionPerformed

    private void menuMasterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMasterActionPerformed
        
    }//GEN-LAST:event_menuMasterActionPerformed

    private void itemLokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemLokasiActionPerformed
        JIF_Lokasi tampil3 = new JIF_Lokasi(LokasiDAO);
        tampil3.loadAwal();
        setSkrin(tampil3);
    }//GEN-LAST:event_itemLokasiActionPerformed

    private void ItemKartuStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemKartuStokActionPerformed
       JD_kartuStok tampil8 = new JD_kartuStok(MasterbarangDAO, s_dao);
       tampil8.loadkartu();
       tampil8.setVisible(true);
    }//GEN-LAST:event_ItemKartuStokActionPerformed

    private void ItemHistoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemHistoriActionPerformed
        JD_Histori tampil9 = new JD_Histori(histo);
        tampil9.loadPencarian();
        tampil9.setVisible(true);
        tampil9.setLocationRelativeTo(this);
    }//GEN-LAST:event_ItemHistoriActionPerformed

    private void ItemKeluarAplikasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemKeluarAplikasiActionPerformed
        if(JOptionPane.showConfirmDialog(rootPane, "Apakah Anda\nIngin Keluar?","Konfirmasi",
                JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION){
            System.exit(0);
        }
    }//GEN-LAST:event_ItemKeluarAplikasiActionPerformed

    private void menuBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBarangActionPerformed
        JIF_Barang tampil5 = new JIF_Barang(MasterbarangDAO);
        tampil5.loadAwal();
        setSkrin(tampil5);
    }//GEN-LAST:event_menuBarangActionPerformed
public InputStream getPath(String file){
            return getClass().getClassLoader().
                        getResourceAsStream("stokgudang/client/laporan/"+file+".jasper");
}
    
    private void ItemLaporanDataKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemLaporanDataKeluarActionPerformed
        // TODO add your handling code here:
        JD_CariTanggal ct= new JD_CariTanggal();
        ct.load();
        if(ct.getTglAwal()!=null&&ct.getTglAkhir()!=null){
            try {
               List<BarangKeluar> keluar = BarangkeluarDAO.getbarangkeluar(ct.getTglAwal(),ct.getTglAkhir());
                HashMap map=new HashMap();
                map.put("barangkeluar_detail",getClass().getClassLoader().getResourceAsStream("stokgudang/client/laporan/laporanbarangkeluar_detail.jasper"));
                map.put("tanggal2", ct.getTglAkhir());
               JasperPrint jRpPrint =JasperFillManager.fillReport( new directori().getPath("laporanbarangkeluar_detail"),map, new JRBeanCollectionDataSource(keluar));
//                        getResourceAsStream("stokgudang/client/lap/laporan_barangmasuk.jasper"),map, new JRBeanCollectionDataSource(masuk));  
//                JasperViewer.viewReport(jRprint, false);
                  JRViewer jv= new JRViewer(jRpPrint);
                  Tampilreport report=new Tampilreport("Laporan Penjualan Berdasarkan Tanggal", jv);
                
            }catch ( RemoteException|JRException  ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }//GEN-LAST:event_ItemLaporanDataKeluarActionPerformed

    
    private void ItemLaporanDataMasukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemLaporanDataMasukActionPerformed
        // TODO add your handling code here:
        JD_CariTanggal ct= new JD_CariTanggal();
        ct.load();
        if(ct.getTglAwal()!=null&&ct.getTglAkhir()!=null){
            try {
               List<BarangMasuk> masuk = BarangmasukDAO.getPembelian(ct.getTglAwal(),ct.getTglAkhir());
                HashMap map=new HashMap();
                map.put("barangmasuk_detail",getClass().getClassLoader().getResourceAsStream("stokgudang/client/laporan/laporanbarangmasuk_detail.jasper"));
//                map.put("tanggal2", ct.getTglAkhir());
               JasperPrint jRprint=JasperFillManager.fillReport(new directori().getPath("laporanbarangmasuk_detail"),map, new JRBeanCollectionDataSource(masuk));
//                        getResourceAsStream("stokgudang/client/lap/laporan_barangmasuk.jasper"),map, new JRBeanCollectionDataSource(masuk));  
//                JasperViewer.viewReport(jRprint, false);
                  JRViewer jv= new JRViewer(jRprint);
                  Tampilreport report=new Tampilreport("Laporan Penjualan Berdasarkan Tanggal", jv);
                
            }catch ( RemoteException|JRException  ex) {
                Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_ItemLaporanDataMasukActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemCustomer;
    private javax.swing.JMenuItem ItemHistori;
    private javax.swing.JMenuItem ItemKartuStok;
    private javax.swing.JMenuItem ItemKeluarAkun;
    private javax.swing.JMenuItem ItemKeluarAplikasi;
    private javax.swing.JMenuItem ItemLaporanDataKeluar;
    private javax.swing.JMenuItem ItemLaporanDataMasuk;
    private javax.swing.JMenuItem ItemLaporanPengguna;
    private javax.swing.JMenuItem ItemPengguna;
    private javax.swing.JMenuItem ItemSaldo;
    private javax.swing.JMenuItem ItemTransaksiKeluar;
    private javax.swing.JMenuItem ItemTransaksiMasuk;
    private javax.swing.JMenuItem itemInfoAkun;
    private javax.swing.JMenuItem itemLokasi;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel lbl_waktu;
    private javax.swing.JMenu menuAkun;
    private javax.swing.JMenuItem menuBarang;
    private javax.swing.JMenu menuLaporan;
    private javax.swing.JMenu menuMaster;
    private javax.swing.JMenu menuTransaksi;
    // End of variables declaration//GEN-END:variables

    
}
