/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stokgudang.client.view;
import autonumber.autoNumber_interface;
import entity.NumberField;
import com.stripbandunk.jwidget.JDynamicTable;
import com.stripbandunk.jwidget.model.DynamicTableModel;
import entity.Customer;
import javax.swing.table.TableRowSorter;
import dao.customerDao;
import java.rmi.RemoteException;
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
/**
 *
 * @author Riki subagja
 */
public class JIF_Customer extends javax.swing.JInternalFrame implements DocumentListener{
     
    DynamicTableModel tableModel;
    private JDynamicTable tabelcustomer;
    private customerDao customerDAO;
    private autoNumber_interface autoNumber_interface1;
    private TableRowSorter<DynamicTableModel> sorter;
     
    public JIF_Customer(customerDao customerdao, autoNumber_interface autonumber_interface) {
        this.setTitle("Kelola Pelanggan atau Customer");
        this.customerDAO = customerdao;
        this.autoNumber_interface1 = autonumber_interface;
        initComponents();
    }
    
    public void loadAwal(){
        try {
            List<Customer>customer = customerDAO.getcustomer();
            if(customer!=null){
                tableModel = new DynamicTableModel<>(customer,Customer.class);
                tabelcustomer = new JDynamicTable(tableModel);
                TabelBergulir.setViewportView(tabelcustomer);
                sorter=new TableRowSorter<>(tableModel);
                tabelcustomer.setRowSorter(sorter);
                txt_cari.getDocument().addDocumentListener(this);
                tabelcustomer.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                 
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        int index=tabelcustomer.getSelectedRow();
                        if(index!=-1){
                            Customer get = (Customer) tableModel.get(tabelcustomer.convertRowIndexToModel(index));
                            txt_kode.setText(get.getkode_customer());
                            txt_nama.setText(get.getnamacustomer());
                            txt_alamat.setText(get.getAlamat());
                            txt_tlp.setText(get.getTelp());
                            txt_nama.setEnabled(true);
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
            Logger.getLogger(JIF_Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean validInput(){
        boolean valid=false;
        if(txt_kode.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Kode Masih Kosong");
        }else if(txt_nama.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Nama Masih Kosong");
        }else if(txt_alamat.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Alamat Masih Kosong");
        }else if(txt_tlp.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Telepon Masih Kosong");
        }else{
            valid=true;
        }
        return valid;
    }
    
    public Customer getCustomer(){
        Customer c = new Customer();
        c.setkode_customer(txt_kode.getText());
        c.setnamacustomer(txt_nama.getText());
        c.setAlamat(txt_alamat.getText());
        c.setTelp(txt_tlp.getText());
        return c;
    }
  
    public void reset(){
        txt_kode.setText("");
        txt_nama.setText("");
        txt_tlp.setText("");
        txt_alamat.setText("");
        txt_nama.setEnabled(false);
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
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_kode = new javax.swing.JTextField();
        txt_nama = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_alamat = new javax.swing.JTextArea();
        txt_tlp = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        ScrolTabel = new javax.swing.JScrollPane();
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

        jPanel1.setBackground(new java.awt.Color(0, 102, 255));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Data Pelanggan");

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

        jLabel2.setText("Kode Pelanggan");

        jLabel3.setText("Nama Pelanggan");

        jLabel5.setText("Alamat");

        jLabel6.setText("No. Telepon");

        txt_kode.setEnabled(false);

        txt_nama.setEnabled(false);

        txt_alamat.setColumns(20);
        txt_alamat.setLineWrap(true);
        txt_alamat.setRows(5);
        txt_alamat.setWrapStyleWord(true);
        txt_alamat.setEnabled(false);
        jScrollPane1.setViewportView(txt_alamat);

        txt_tlp.setEnabled(false);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(86, 86, 86)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(txt_tlp)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_kode, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                            .addComponent(txt_nama)))
                    .addComponent(jLabel6))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_kode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_tlp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        jLabel9.setText("Cari");

        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
        });

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Tabel Customer"));
        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel4.add(ScrolTabel, java.awt.BorderLayout.PAGE_START);

        scrolPencarian.setViewportView(tabelPencarian);

        TabelBergulir.setViewportView(scrolPencarian);

        jPanel4.add(TabelBergulir, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 663, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 677, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_New)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Insert)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_Update)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Reset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_Delete)
                        .addGap(35, 35, 35))))
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

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        saring();
    }//GEN-LAST:event_txt_cariKeyReleased

    private void bt_NewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_NewActionPerformed
        // TODO add your handling code here:
        try {
            NumberField field=new NumberField();
            field.setAwalan("CST");
            field.setNamaField("kode_customer");
            field.setNamaTabel("dbcustomer");
            field.setPanjangField(6);
            txt_kode.setText(autoNumber_interface1.getAutoNumberInt(field));
            txt_nama.setEnabled(true);
            txt_alamat.setEnabled(true);
            txt_tlp.setEnabled(true);
            bt_Insert.setEnabled(true);
            bt_New.setEnabled(false);
            bt_Reset.setEnabled(true);
        } catch (RemoteException ex) {
            Logger.getLogger(JIF_Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_bt_NewActionPerformed

    private void bt_InsertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_InsertActionPerformed
        if(validInput()){
            Customer cst = getCustomer();
            if(cst != null){
                try {
                    if(customerDAO.insert(cst)){
                        JOptionPane.showMessageDialog(rootPane, "Data Berhasil Diinput");
                        loadAwal();
                        reset();
                    } else{
                        JOptionPane.showMessageDialog(rootPane, "Data Gagal Disimpan");
                    }
                } catch (RemoteException e) {
                    Logger.getLogger(JIF_Customer.class.getName()).log(Level.SEVERE,null,e);
                }
            }
        }
    }//GEN-LAST:event_bt_InsertActionPerformed

    private void bt_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_UpdateActionPerformed
        if(validInput()){
            Customer customer = getCustomer();
            if(customer!=null){
                try {
                    if(customerDAO.update(customer)){
                       JOptionPane.showMessageDialog(rootPane, "Data berhasil diubah"); 
                        loadAwal();
                        reset();
                    }else{
                      JOptionPane.showMessageDialog(rootPane, "Data gagal disimpan");    
                    }
                    
                } catch (RemoteException ex) {
                    Logger.getLogger(JIF_Customer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_bt_UpdateActionPerformed

    private void bt_ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ResetActionPerformed
        reset();
        loadAwal();
    }//GEN-LAST:event_bt_ResetActionPerformed

    private void bt_DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_DeleteActionPerformed
       if (validInput()) {
                if (JOptionPane.showConfirmDialog(rootPane, "Apakah Anda Mau menghapus ?","Konfirmasi", JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) {
                Customer customer = getCustomer();
                if (customer != null) {
                    try {
                        customerDAO.delete(customer);
                        loadAwal();
                        reset();
                    } catch (RemoteException ex) {
                        Logger.getLogger(JIF_Customer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_bt_DeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane ScrolTabel;
    private javax.swing.JScrollPane TabelBergulir;
    private javax.swing.JButton bt_Delete;
    private javax.swing.JButton bt_Insert;
    private javax.swing.JButton bt_New;
    private javax.swing.JButton bt_Reset;
    private javax.swing.JButton bt_Update;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane scrolPencarian;
    private com.stripbandunk.jwidget.JDynamicTable tabelPencarian;
    private javax.swing.JTextArea txt_alamat;
    private javax.swing.JTextField txt_cari;
    private javax.swing.JTextField txt_kode;
    private javax.swing.JTextField txt_nama;
    private javax.swing.JTextField txt_tlp;
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
