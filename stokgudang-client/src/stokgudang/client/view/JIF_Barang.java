/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.client.view;

import autonumber.autoNumber_interface;
import com.stripbandunk.jwidget.JDynamicTable;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import entity.MasterBarang;
import dao.masterbarangDao;
import java.awt.event.ItemListener;
import java.rmi.RemoteException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableRowSorter;
 
/**
 *
 * @author Riki subagja
 */
public class JIF_Barang extends javax.swing.JInternalFrame implements DocumentListener{

    private static final long serialVersionUID = 1L;

    DynamicTableModel tableModel;
    private JDynamicTable tabelBarang;
    private masterbarangDao masterbarangDAO;
    private TableRowSorter<DynamicTableModel> sorter;
    
    
    public JIF_Barang(masterbarangDao masterbarangdao) {
        this.masterbarangDAO = masterbarangdao;
        initComponents();
    }
    
    

    public void loadAwal(){
        try {
           List<MasterBarang> barang = masterbarangDAO.getBarang();
           if(barang!=null){
                 
                tableModel = new DynamicTableModel<>(barang, MasterBarang.class);
                tabelBarang = new JDynamicTable(tableModel);
                TabelBergulir.setViewportView(tabelBarang);
                sorter = new TableRowSorter<>(tableModel);
                tabelBarang.setRowSorter(sorter);
                txt_cari.getDocument().addDocumentListener(this);
                tabelBarang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        int index=tabelBarang.getSelectedRow();
                        if(index!=-1){
                            MasterBarang get = (MasterBarang) tableModel.get(tabelBarang.convertRowIndexToModel(index));
                            txt_kode.setText(get.getKode_barang());
                            txt_nama.setText(get.getNama_barang());
                            txt_kategori.setText(get.getKategori());
                            txt_isibarang.setText(String.valueOf(get.getIsi()));
                            txt_satuan.setText(get.getSatuan());
                            txt_kemasan.setText(get.getKemasan());
                            txt_kode.setEnabled(true);
                            txt_nama.setEnabled(true);
                            txt_kategori.setEnabled(true);
                            txt_isibarang.setEnabled(true);
                            txt_satuan.setEnabled(true);
                            txt_kemasan.setEnabled(true);
                            bt_Insert.setEnabled(false);
                            bt_New.setEnabled(false);
                            bt_Update.setEnabled(true);
                            bt_Delete.setEnabled(true);
                            bt_Reset.setEnabled(true);
                        }
                    }
                });
                       
            }
        } catch (RemoteException e) {
            Logger.getLogger(JIF_Barang.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public  boolean validainput(){
        boolean valid =false;
        if(txt_kode.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"kode masih kosong silahkan diisi");
        }else if(txt_nama.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"nama masih kosong silahkan diisi");
        }else if(txt_kategori.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"silahkan terlebih dahulu pilih kategori");
        }else if(txt_isibarang.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"silahkan isi terlebih dahulu");
        }else if(txt_satuan.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"silahkan isi terlebih dahulu");
        }else if(txt_kemasan.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"silahkan isi terlebih dahulu");
        } else{
            valid=true;
           }
        return valid;
    }
    
    
    
    
    public MasterBarang getmasterbarang(){
       MasterBarang mb =new MasterBarang();
       mb.setKode_barang(txt_kode.getText());
       mb.setNama_barang(txt_nama.getText());
       mb.setKategori(txt_kategori.getText());
       double isi = Double.parseDouble(txt_isibarang.getText());
       mb.setIsi(isi);
       mb.setSatuan(txt_satuan.getText());
       mb.setKemasan(txt_kemasan.getText());
       return mb;
    }
    
    public void reset(){
        txt_kode.setText("");
        txt_nama.setText("");
        txt_kategori.setText("");
        txt_isibarang.setText("");
        txt_satuan.setText("");
        txt_kemasan.setText("");
        txt_nama.setEnabled(false);
        txt_kategori.setEnabled(false);
        txt_isibarang.setEnabled(false);
        txt_satuan.setEnabled(false);
        txt_kemasan.setEnabled(false);
        bt_Insert.setEnabled(false);
        bt_New.setEnabled(true);
        bt_Update.setEnabled(false);
        bt_Delete.setEnabled(false);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_kode = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_satuan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_kemasan = new javax.swing.JTextField();
        txt_kategori = new javax.swing.JTextField();
        txt_isibarang = new javax.swing.JFormattedTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        TabelBergulir = new javax.swing.JScrollPane();
        scrolPencarian = new javax.swing.JScrollPane();
        tabelPencarian = new com.stripbandunk.jwidget.JDynamicTable();
        bt_New = new javax.swing.JButton();
        bt_Insert = new javax.swing.JButton();
        bt_Update = new javax.swing.JButton();
        bt_Reset = new javax.swing.JButton();
        bt_Delete = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Tambah Barang");

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
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
        );

        jLabel2.setText("Kode Barang");

        jLabel3.setText("Nama Barang");

        jLabel6.setText("Kategori");

        txt_kode.setEnabled(false);

        txt_nama.setEnabled(false);

        jLabel4.setText("Isi Barang");

        jLabel5.setText("Satuan");

        txt_satuan.setEnabled(false);

        jLabel7.setText("Kemasan");

        txt_kemasan.setEnabled(false);
        txt_kemasan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kemasanActionPerformed(evt);
            }
        });

        txt_kategori.setEnabled(false);

        txt_isibarang.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,##0.00"))));
        txt_isibarang.setEnabled(false);
        txt_isibarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_isibarangActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_kemasan, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txt_satuan)
                    .addComponent(txt_kode, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                    .addComponent(txt_nama)
                    .addComponent(txt_kategori)
                    .addComponent(txt_isibarang))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_kategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_isibarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_kemasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel9.setText("Cari Barang");

        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Informasi"));
        jPanel4.setLayout(new java.awt.BorderLayout());

        TabelBergulir.setToolTipText("");

        scrolPencarian.setViewportView(tabelPencarian);

        TabelBergulir.setViewportView(scrolPencarian);

        jPanel4.add(TabelBergulir, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel9)
                        .addGap(10, 10, 10)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        bt_New.setText("NEW");
        bt_New.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_NewActionPerformed(evt);
            }
        });

        bt_Insert.setText("INSERT");
        bt_Insert.setEnabled(false);
        bt_Insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_InsertActionPerformed(evt);
            }
        });

        bt_Update.setText("UPDATE");
        bt_Update.setEnabled(false);
        bt_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_UpdateActionPerformed(evt);
            }
        });

        bt_Reset.setText("RESET");
        bt_Reset.setEnabled(false);
        bt_Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ResetActionPerformed(evt);
            }
        });

        bt_Delete.setText("DELETE");
        bt_Delete.setEnabled(false);
        bt_Delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_DeleteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_New, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_Insert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_Update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_Reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_New)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Insert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Delete)
                        .addGap(0, 48, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        
    }//GEN-LAST:event_txt_cariKeyReleased

    private void bt_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_NewActionPerformed
        txt_kode.setText("");
        txt_nama.setText("");
        txt_kategori.setText("");
        txt_isibarang.setText("");
        txt_satuan.setText("");
        txt_kemasan.setText("");
        txt_kode.setEnabled(true);
        txt_nama.setEnabled(true);
        txt_kategori.setEnabled(true);
        txt_isibarang.setEnabled(true);
        txt_satuan.setEnabled(true);
        txt_kemasan.setEnabled(true);
        bt_Insert.setEnabled(true);
        bt_New.setEnabled(false);
        bt_Update.setEnabled(false);
        bt_Delete.setEnabled(false);
    }//GEN-LAST:event_bt_NewActionPerformed

    private void bt_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_InsertActionPerformed
        if(validainput()){
            MasterBarang barang = getmasterbarang();
            if(barang!=null){
                try {
                    if(masterbarangDAO.insert(barang)){
                        JOptionPane.showMessageDialog(rootPane, "Data Berhasil Disimpan!");
                        loadAwal();
                        reset();
                    } else{
                        JOptionPane.showMessageDialog(rootPane, "Data Gagal Disimpan!");
                    }
                } catch (RemoteException e) {
                    Logger.getLogger(JIF_Barang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
        
    }//GEN-LAST:event_bt_InsertActionPerformed

    private void bt_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_UpdateActionPerformed
        if(validainput()){
            MasterBarang barang = getmasterbarang();
            if(barang!=null){
                try {
                    if(masterbarangDAO.update(barang)){
                        JOptionPane.showMessageDialog(rootPane, "Data Berhasil Diubah!");
                        loadAwal();
                        reset();
                    } else{
                        JOptionPane.showMessageDialog(rootPane, "Data Gagal Diubah!");
                    }
                } catch (RemoteException e) {
                    Logger.getLogger(JIF_Barang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }//GEN-LAST:event_bt_UpdateActionPerformed

    private void bt_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ResetActionPerformed
        reset();
        loadAwal();
    }//GEN-LAST:event_bt_ResetActionPerformed

    private void bt_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_DeleteActionPerformed
        if(validainput()){
            MasterBarang barang = getmasterbarang();
            if(barang!=null){
                try {
                    if(masterbarangDAO.delete(barang)){
                        JOptionPane.showMessageDialog(rootPane, "Data Berhasil Dihapus!");
                        loadAwal();
                        reset();
                    } else{
                        JOptionPane.showMessageDialog(rootPane, "Data Gagal Dihapus!");
                    }
                } catch (RemoteException e) {
                    Logger.getLogger(JIF_Barang.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }//GEN-LAST:event_bt_DeleteActionPerformed

    private void txt_kemasanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kemasanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kemasanActionPerformed

    private void txt_isibarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_isibarangActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txt_isibarangActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane TabelBergulir;
    private javax.swing.JButton bt_Delete;
    private javax.swing.JButton bt_Insert;
    private javax.swing.JButton bt_New;
    private javax.swing.JButton bt_Reset;
    private javax.swing.JButton bt_Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane scrolPencarian;
    private com.stripbandunk.jwidget.JDynamicTable tabelPencarian;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JFormattedTextField txt_isibarang;
    private javax.swing.JTextField txt_kategori;
    private javax.swing.JTextField txt_kemasan;
    private javax.swing.JTextField txt_kode;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_satuan;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
        saring();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        saring();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        saring();
    }

    public void saring(){
        String text=txt_cari.getText();
        if(text.length()==0){
            sorter.setRowFilter(null);
        } else{
            sorter.setRowFilter(RowFilter.regexFilter(Pattern.compile("(?i).*"+text+".*",
                    Pattern.CASE_INSENSITIVE | Pattern.DOTALL).toString()
            ));
        }
    }
    
}
