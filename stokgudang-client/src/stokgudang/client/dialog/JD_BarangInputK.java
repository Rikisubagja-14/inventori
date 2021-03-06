/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.client.dialog;

import com.stripbandunk.jwidget.model.DynamicTableModel;
import dao.lokasidao;
import dao.stokdao;
import dao.masterbarangDao;
import entity.BarangKeluarDetail;
import entity.LokasiPenyimpanan;
import entity.MasterBarang;
import entity.stok;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import stokgudang.client.view.JIF_Barang;
import stokgudang.client.view.JIF_Lokasi;

/**
 *
 * @author Riki subagja
 */
public class JD_BarangInputK extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    
    private masterbarangDao masterbarangDao;
    private MasterBarang masterBarang;
    private LokasiPenyimpanan lokpem;
    private lokasidao l_dao;
     private stokdao stokdao;
    private stok batchCari;
     private List stok=new ArrayList();
    private double isiBarang, totalQty;
    private int jumlah;
    private String batch, lokasi, nf, nama, kemasan , kodeBarang,  satuanBarang;

    /**
     * Creates new form JD_BarangInput
     * @param mbDao
     */
    public JD_BarangInputK(masterbarangDao mbDao,lokasidao lokdao,stokdao stokdao) {
        this.masterbarangDao=mbDao;
        this.l_dao = lokdao;
        this.stokdao = stokdao;
        setModal(true);   
        initComponents();  
    }

    public String getNama() {
        return nama;
    }
    
    public LokasiPenyimpanan getLokpem() {
        return lokpem;
    }
    
    public MasterBarang getMasterBarang() {
        return masterBarang;
    }
  
    public double getIsiBarang() {
        return isiBarang;
    }

    public double getTotalQty() {
        return totalQty;
    }

    public double getJumlah() {
        return jumlah;
    }

    public String getBatch() {
        return batch;
    }

    public String getNf() {
        return nf;
    }

    public String getLokasi() {
        return lokasi;
    }
    
    public String getKemasan() {
        return kemasan;
    }

    public String getKodeBarang() {
        return kodeBarang;
    }

    public String getSatuanBarang() {
        return satuanBarang;
    }
    
    public void load(){
        setTitle("Tambah Barang Keluar");
        setLocationRelativeTo(getParent());
        setVisible(true);
    }
    
     public void update(BarangKeluarDetail pd){
       
        setTitle("Ubah Barang");
//        bt_cari.setEnabled(false);
        masterBarang = pd.getMasterBarang();
        jumlah = pd.getQty();
        txt_kode.setText(String.valueOf(pd.getKode_barang()));
        txt_nama.setText(String.valueOf(pd.getNama_barang()));
        txt_batch.setText(String.valueOf(pd.getBatch()));
        cb_NF.setSelectedItem(String.valueOf(pd.getKategori_nf()));
        txt_lokasi.setText(String.valueOf(pd.getLok()));
        txt_qty.setText(String.valueOf(pd.getQty()));
        txt_isi.setText(String.valueOf(pd.getIsi()));
        txt_satuan.setText(String.valueOf(pd.getSatuan()));
        txt_total.setText(String.valueOf(pd.getTotal_qty()));
        cb_kemasan.setSelectedItem(String.valueOf(pd.getKemasan()));
        setLocationRelativeTo(getParent());
        setVisible(true);
    }
     
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_kode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_nama = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cb_NF = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        txt_batch = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txt_satuan = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        bt_cari = new javax.swing.JButton();
        cb_kemasan = new javax.swing.JComboBox<>();
        btnbatch = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        txt_qty = new javax.swing.JTextField();
        txt_isi = new javax.swing.JTextField();
        txt_total = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_lokasi = new javax.swing.JTextField();
        btn_lokasi = new javax.swing.JButton();
        txt_saldo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_kemasan = new javax.swing.JTextField();
        bt_Put = new javax.swing.JButton();
        bt_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Input Barang");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
        );

        jLabel2.setText("Kode Barang");

        jLabel3.setText("Nama Barang");

        jLabel9.setText("Type Transaksi");

        cb_NF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Silahkan Pilih", "OUT" }));

        jLabel11.setText("Batch/Inv");

        jLabel12.setText("Qty");

        jLabel13.setText("Isi");

        jLabel14.setText("Satuan");

        txt_satuan.setEnabled(false);

        jLabel15.setText("Kemasan");

        bt_cari.setText(". . .");
        bt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cariActionPerformed(evt);
            }
        });

        cb_kemasan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dus", "Drum", "Zak", "Kilogram" }));
        cb_kemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_kemasanActionPerformed(evt);
            }
        });

        btnbatch.setText(". . .");
        btnbatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbatchActionPerformed(evt);
            }
        });

        jLabel16.setText("Total Qty");

        txt_qty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_qtyActionPerformed(evt);
            }
        });
        txt_qty.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_qtyKeyPressed(evt);
            }
        });

        txt_isi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txt_isiMouseClicked(evt);
            }
        });
        txt_isi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_isiActionPerformed(evt);
            }
        });
        txt_isi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_isiKeyPressed(evt);
            }
        });

        txt_total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalActionPerformed(evt);
            }
        });
        txt_total.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_totalKeyPressed(evt);
            }
        });

        jLabel4.setText("Lokasi");

        btn_lokasi.setText(". . .");
        btn_lokasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_lokasiActionPerformed(evt);
            }
        });

        txt_saldo.setEnabled(false);
        txt_saldo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_saldoActionPerformed(evt);
            }
        });

        jLabel5.setText("Saldo");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(txt_kode)
                                .addGap(45, 45, 45))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nama)
                                    .addComponent(txt_batch))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnbatch, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bt_cari, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cb_NF, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 97, Short.MAX_VALUE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(txt_lokasi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_lokasi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(388, 388, 388)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_kemasan, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(txt_satuan, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_qty, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                    .addComponent(txt_isi, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txt_total, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel5))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cb_kemasan, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(txt_qty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(bt_cari)
                            .addComponent(txt_isi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_saldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_batch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbatch)
                    .addComponent(jLabel16)
                    .addComponent(txt_total, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(cb_NF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel14)
                    .addComponent(txt_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(cb_kemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(txt_kemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_lokasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btn_lokasi)))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        bt_Put.setText("AMBIL BARANG");
        bt_Put.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_PutActionPerformed(evt);
            }
        });

        bt_cancel.setText("BATAL");
        bt_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_Put)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_cancel)
                    .addComponent(bt_Put))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cariActionPerformed
        
        try {
            // TODO add your handling code here:
            List<MasterBarang> bar = masterbarangDao.getBarang();
            if(!bar.isEmpty()){
                DynamicTableModel tableModel=new DynamicTableModel(bar, MasterBarang.class);
                JD_BarangCari pencarian=new JD_BarangCari();
                pencarian.setTitle("Pencarian Barang");
                pencarian.setTableModel(tableModel);
                pencarian.loadPencarian();
                String ambilData = pencarian.ambilData();
                if(ambilData!=null){

                    masterBarang = masterbarangDao.getById(ambilData);
                    txt_kode.setText(masterBarang.getKode_barang());
                    txt_nama.setText(masterBarang.getNama_barang());
                    txt_satuan.setText(masterBarang.getSatuan());
                    txt_isi.setText(String.valueOf(masterBarang.getIsi()));
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Barang pada gudang ini kosong !");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(JIF_Barang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_cariActionPerformed

    private void cb_kemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_kemasanActionPerformed
        String data;
        data = (String) cb_kemasan.getSelectedItem();
        txt_kemasan.setText(data);
    }//GEN-LAST:event_cb_kemasanActionPerformed

    private void txt_qtyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_qtyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_qtyActionPerformed

    private void txt_qtyKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_qtyKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_qtyKeyPressed

    private void txt_isiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_isiMouseClicked
        String total;
        double isi=0,hasil=0;
        int qty;
        try {
            qty = Integer.valueOf(txt_qty.getText());
            isi = Double.valueOf(txt_isi.getText());
            hasil = qty*isi;
            total = String.valueOf(hasil);
            txt_total.setText(String.valueOf(total));
        } catch (NumberFormatException e) {
            Logger.getLogger(JD_BarangInputM.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_txt_isiMouseClicked

    private void txt_isiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_isiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_isiActionPerformed

    private void txt_isiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_isiKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_isiKeyPressed

    private void txt_totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalActionPerformed

    private void txt_totalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_totalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalKeyPressed

    private void btn_lokasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_lokasiActionPerformed
        try {
            // TODO add your handling code here:
            List<LokasiPenyimpanan> lok = l_dao.getlokasi();
            if(!lok.isEmpty()){
                DynamicTableModel tableModel=new DynamicTableModel(lok, LokasiPenyimpanan.class);
                JD_BarangCari pencarian=new JD_BarangCari();
                pencarian.setTitle("Pencarian Lokasi");
                pencarian.setTableModel(tableModel);
                pencarian.loadPencarian();
                String ambilData = pencarian.ambilData();
                if(ambilData!=null){
                lokpem = l_dao.getlokasibyID(ambilData);
                txt_lokasi.setText(lokpem.getKode_lokasi());
//                    masterBarang = masterbarangDao.getById(ambilData);
//                    txt_kode.setText(masterBarang.getKode_barang());
//                    txt_nama.setText(masterBarang.getNama_barang());
//                    txt_satuan.setText(masterBarang.getSatuan());
//                    txt_isi.setText(String.valueOf(masterBarang.getIsi()));
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Barang pada gudang ini kosong !");
            }
        } catch (RemoteException ex) {
            Logger.getLogger(JD_BarangInputK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_lokasiActionPerformed

    private void bt_PutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_PutActionPerformed
        if(txt_kode.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Kode Barang Masih Kosong !");
        } else if(txt_nama.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Nama Barang Masih Kosong !");
        } else if(txt_batch.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Batch Masih Kosong !");
        } else if(cb_NF.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(rootPane, "Kategori NF Belum Diatur !");
        } else if(txt_lokasi.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Lokasi Masih Kosong !");
        } else if(txt_qty.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Qty Masih Kosong !");
        } else if(txt_isi.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Isi Belum Diatur !");
        } else if(txt_total.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Total Masih Kosong !");
        } else if(txt_satuan.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Satuan Masih Kosong !");
        } else if(txt_kemasan.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Kemasan Belum Diatur !");
        }else{
            kodeBarang = txt_kode.getText();
            nama = txt_nama.getText();
            satuanBarang = txt_satuan.getText();
            totalQty = Double.valueOf(txt_total.getText());
            jumlah = Integer.valueOf(txt_qty.getText());
            isiBarang = Double.valueOf(txt_isi.getText());
            nf = cb_NF.getSelectedItem().toString();
            kemasan = txt_kemasan.getText();
            batch = txt_batch.getText();
            lokasi = txt_lokasi.getText();
            dispose();
        }
    }//GEN-LAST:event_bt_PutActionPerformed

    private void bt_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cancelActionPerformed
        masterBarang=null;
        jumlah=0;
        dispose();
    }//GEN-LAST:event_bt_cancelActionPerformed

    private void btnbatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbatchActionPerformed
        try {
            String kdbarang= txt_kode.getText().toString();
//            System.out.println(kdbarang);
            // TODO add your handling code here:
            List<stok> sko = stokdao.getstok(kdbarang);
         
            if(!sko.isEmpty()){
                DynamicTableModel tableModel = new DynamicTableModel(sko,stok.class);
                JD_BatchCari pencarian = new JD_BatchCari();
                pencarian.setTitle("Tampilkan Stok");
                pencarian.setTableModel(tableModel);
                pencarian.loadPencarian();
                String ambilData = pencarian.ambilData() ;
                    if(ambilData!=null){
                        batchCari = stokdao.getstokbyid(ambilData, kdbarang);

                        txt_batch.setText(batchCari.getBatch());
                        txt_saldo.setText(String.valueOf(batchCari.getTotal_qty()));
                        cb_kemasan.setSelectedItem(String.valueOf(batchCari.getKemasan()));
                        txt_kemasan.setText(batchCari.getKemasan());
                        txt_isi.setText(String.valueOf(batchCari.getIsi()));
                        txt_lokasi.setText(batchCari.getLokasi());
                    }
                } else{
                    JOptionPane.showMessageDialog(rootPane, "Barang pada batch ini kosong !");
                }
            
        } catch (RemoteException ex) {
            Logger.getLogger(JD_BarangInputK.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnbatchActionPerformed

    private void txt_saldoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_saldoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_saldoActionPerformed

    public JD_BarangInputK() {
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Put;
    private javax.swing.JButton bt_cancel;
    private javax.swing.JButton bt_cari;
    private javax.swing.JButton btn_lokasi;
    private javax.swing.JButton btnbatch;
    private javax.swing.JComboBox<String> cb_NF;
    private javax.swing.JComboBox<String> cb_kemasan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txt_batch;
    private javax.swing.JTextField txt_isi;
    private javax.swing.JTextField txt_kemasan;
    private javax.swing.JTextField txt_kode;
    private javax.swing.JTextField txt_lokasi;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_qty;
    private javax.swing.JTextField txt_saldo;
    private javax.swing.JTextField txt_satuan;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}