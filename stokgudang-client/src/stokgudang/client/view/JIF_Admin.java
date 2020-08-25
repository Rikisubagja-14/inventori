/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.client.view;


import com.stripbandunk.jwidget.JDynamicTable;
import autonumber.autoNumber_interface;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import java.rmi.RemoteException;
import javax.swing.table.TableRowSorter;
import dao.adminDao;
import entity.NumberField;
import entity.Admin;
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
import stokgudang.server.daoimpl.adminDaoImpl;
/**
 *
 * @author Riki subagja
 */
public class JIF_Admin extends javax.swing.JInternalFrame implements DocumentListener{

    /**
     * Creates new form JIF_Admin
     */
    DynamicTableModel tableModel;
    private JDynamicTable tabelAdmin;
    private adminDao adminDAO;
    private autoNumber_interface autoNumber_interface1;
    private TableRowSorter<DynamicTableModel> sorter;
    
    public JIF_Admin(adminDao adminDao , autoNumber_interface autonumber_interface) {
        this.setTitle("Kelola Akun dan Pengguna");
        
        this.adminDAO = adminDao;
        this.autoNumber_interface1 = autonumber_interface;
        initComponents();
    }
    
    public void loadawal(){
        try {
         List<Admin> admin = adminDAO.getadmin();
         if(admin!=null){
             tableModel= new DynamicTableModel<>(admin,Admin.class);
             tabelAdmin= new JDynamicTable(tableModel);
             tableBergulir.setViewportView(tabelAdmin);
             sorter=new TableRowSorter<>(tableModel);
             tabelAdmin.setRowSorter(sorter);
             txt_cari.getDocument().addDocumentListener(this);
             tabelAdmin.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                 
                 @Override
                 public void valueChanged(ListSelectionEvent e) {
                     int index = tabelAdmin.getSelectedRow();
                     if(index!=-1){
                         Admin get =(Admin) tableModel.get(tabelAdmin.convertRowIndexToModel(index));
                         txt_kode.setText(get.getKd_user());
                         txt_nama.setText(get.getNm_user());
                         txt_user.setText(get.getUser_name());
                         txt_password.setText(get.getUser_pass());
                         cb_jabatan.setSelectedItem(get.getBagian());
                         txt_alamat.setText(get.getAlamat());
                         txt_tlp.setText(get.getTelepon());
                         txt_nama.setEnabled(true);
                         txt_user.setEnabled(true);
                         txt_password.setEnabled(true);
                         cb_jabatan.setEnabled(true);
                         txt_alamat.setEnabled(true);
                         txt_tlp.setEnabled(true);
                         bt_Update.setEnabled(true);
                         bt_Delete.setEnabled(true);
                         bt_New.setEnabled(false);
                         bt_Reset.setEnabled(true);
                     }
                 }
             });
             
             
         }
        } catch (RemoteException ex) {
            Logger.getLogger(JIF_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public  boolean  validasiinput(){
        boolean valid=false;
        if(txt_kode.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"kode masih kosong !!! ");
        }else if(txt_nama.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"nama masih kosong !!!");
        }else if(txt_user.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"user masih kosong !!!");
        }else if(txt_password.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"password  masih kosong !!!");
        }else if(cb_jabatan.getSelectedItem().toString().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane," bagioan belom dipilih !!!");
        }else if(txt_alamat.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"alamat masih kosong !!!");
        }else if(txt_tlp.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane,"telepon masih kosong !!!");
        }else{
            valid=true;
        }
        return  valid;
       
    }
    
    public Admin getadmin(){
        Admin a = new Admin();
        a.setKd_user(txt_kode.getText());
        a.setNm_user(txt_nama.getText());
        a.setUser_name(txt_user.getText());
        a.setUser_pass(new String(txt_password.getPassword()));
        a.setBagian(cb_jabatan.getSelectedItem().toString());
        a.setTelepon(txt_alamat.getText());
        a.setAlamat(txt_tlp.getText());
        return a ;
    }
    
    
    public  void reset(){
                     txt_kode.setText("");
                     txt_nama.setText("");
                     txt_user.setText("");
                     txt_password.setText("");
                     cb_jabatan.setSelectedItem("");
                     txt_alamat.setText("");
                     txt_tlp.setText("");
                     txt_nama.setEnabled(false);
                     txt_user.setEnabled(false);
                     txt_password.setEnabled(false);
                     cb_jabatan.setEnabled(false);
                     txt_alamat.setEnabled(false);
                     txt_tlp.setEnabled(false);
                     bt_Insert.setEnabled(false);
                     bt_New.setEnabled(true);
                     bt_Update.setEnabled(false);
                     bt_Delete.setEnabled(false);
                     bt_Reset.setEnabled(true);
                     
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
        jLabel9 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        tableBergulir = new javax.swing.JScrollPane();
        scrolPencarian = new javax.swing.JScrollPane();
        tabelPencarian = new com.stripbandunk.jwidget.JDynamicTable();
        bt_New = new javax.swing.JButton();
        bt_Insert = new javax.swing.JButton();
        bt_Update = new javax.swing.JButton();
        bt_Reset = new javax.swing.JButton();
        bt_Delete = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_kode = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        cb_jabatan = new javax.swing.JComboBox<>();
        txt_user = new javax.swing.JTextField();
        txt_tlp = new javax.swing.JTextField();
        txt_password = new javax.swing.JPasswordField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Pengguna");

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

        jLabel9.setText("Cari Pengguna");

        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Karyawan"));
        jPanel4.setLayout(new java.awt.BorderLayout());

        scrolPencarian.setViewportView(tabelPencarian);

        tableBergulir.setViewportView(scrolPencarian);

        jPanel4.add(tableBergulir, java.awt.BorderLayout.CENTER);

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
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE))
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
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel2.setText("Kode User");

        jLabel3.setText("Nama Pengguna");

        txt_kode.setEnabled(false);

        txt_nama.setEnabled(false);

        txt_alamat.setColumns(20);
        txt_alamat.setLineWrap(true);
        txt_alamat.setRows(5);
        txt_alamat.setWrapStyleWord(true);
        txt_alamat.setEnabled(false);
        jScrollPane1.setViewportView(txt_alamat);

        cb_jabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Petugas" }));
        cb_jabatan.setEnabled(false);

        txt_user.setEnabled(false);

        txt_tlp.setEnabled(false);

        txt_password.setEnabled(false);

        jLabel10.setText("Username");

        jLabel11.setText("Password");

        jLabel12.setText("Bagian");

        jLabel13.setText("Alamat");

        jLabel14.setText("No. Tlp");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(67, 67, 67)
                        .addComponent(txt_tlp, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cb_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_password)
                                .addComponent(txt_user)
                                .addComponent(txt_nama)
                                .addComponent(txt_kode, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(7, Short.MAX_VALUE))
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
                    .addComponent(txt_user, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cb_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_New, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_Insert, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_Update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_Reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bt_Delete, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_New)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Insert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Delete))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_NewActionPerformed
        try {
                NumberField field = new NumberField();
                field.setAwalan("ADM");
                field.setNamaField("kode_user");
                field.setNamaTabel("admin");
                field.setPanjangField(7);
                txt_kode.setText(autoNumber_interface1.getAutoNumberInt(field));
            txt_nama.setEnabled(true);
            txt_user.setEnabled(true);
            txt_password.setEnabled(true);
            cb_jabatan.setEnabled(true);
            txt_alamat.setEnabled(true);
            txt_tlp.setEnabled(true);
            bt_Insert.setEnabled(true);
            bt_New.setEnabled(false);
            bt_Reset.setEnabled(true);
        } catch (RemoteException ex) {
            Logger.getLogger(JIF_Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bt_NewActionPerformed

    private void bt_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ResetActionPerformed
            reset();
            loadawal();
    }//GEN-LAST:event_bt_ResetActionPerformed

    private void bt_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_InsertActionPerformed
        if(validasiinput()){
            Admin admin = getadmin();
            if(admin!=null){
                try {
                    if(adminDAO.insert(admin)){
                        JOptionPane.showMessageDialog(rootPane, "Data Berhasil Disimpan");
                        loadawal();
                        reset();
                    } else{
                        JOptionPane.showMessageDialog(rootPane, "Data Gagal Disimpan");
                    }
                } catch (RemoteException e) {
                    Logger.getLogger(JIF_Admin.class.getName()).log(Level.SEVERE, null, e);
                }
            }
        }
    }//GEN-LAST:event_bt_InsertActionPerformed

    private void bt_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_UpdateActionPerformed
       if(validasiinput()){
           Admin admin = getadmin();
           if(admin!=null){
               try {
                   if(adminDAO.update(admin)){
                       JOptionPane.showMessageDialog(rootPane, "Data Berhasil Diubah");
                       loadawal();
                       reset();
                   } else{
                       JOptionPane.showMessageDialog(rootPane, "Data Gagal Dihapus");
                   }
               } catch (RemoteException e) {
              java.util.logging.Logger.getLogger(JIF_Admin.class.getName()).log(Level.SEVERE, null, e);
           }
       }
       }
    }//GEN-LAST:event_bt_UpdateActionPerformed

    private void bt_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_DeleteActionPerformed
        if(validasiinput()){
            if(JOptionPane.showConfirmDialog(rootPane, "Apakah Anda Mau menghapus ?","Konfirmasi", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) {
           Admin admin = getadmin();
           if(admin!=null){
               try {
                   adminDAO.delete(admin);
                   loadawal();
                   reset();
                   
               } catch (RemoteException e) {
              java.util.logging.Logger.getLogger(JIF_Admin.class.getName()).log(Level.SEVERE, null, e);
           }
       }
       }
        }
    }//GEN-LAST:event_bt_DeleteActionPerformed

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        saring();
    }//GEN-LAST:event_txt_cariKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_Delete;
    private javax.swing.JButton bt_Insert;
    private javax.swing.JButton bt_New;
    private javax.swing.JButton bt_Reset;
    private javax.swing.JButton bt_Update;
    private javax.swing.JComboBox<String> cb_jabatan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane scrolPencarian;
    private com.stripbandunk.jwidget.JDynamicTable tabelPencarian;
    private javax.swing.JScrollPane tableBergulir;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_kode;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JPasswordField txt_password;
    private javax.swing.JTextField txt_tlp;
    private javax.swing.JTextField txt_user;
    // End of variables declaration//GEN-END:variables

    public void insertUpdate(DocumentEvent e) {
        saring();
    }

    public void removeUpdate(DocumentEvent e) {
        saring();
    }

    public void changedUpdate(DocumentEvent e) {
        saring();
    }
    
    public void saring(){
        String text=txt_cari.getText();
        if(text.length()==0){
            sorter.setRowFilter(null);
        }else{
            sorter.setRowFilter(RowFilter.regexFilter(Pattern.compile("(?i).*"+text+".*", 
                    Pattern.CASE_INSENSITIVE | Pattern.DOTALL).toString()
                   ));
        }
    }

}
