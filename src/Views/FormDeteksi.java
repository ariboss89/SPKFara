/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.Koneksi;
import Dao.DeteksiDao;
import Dao.FormulaDao;
import Dao.ReportDao;
import Models.tb_formula;
import Models.tb_model;
import Models.tb_pelanggan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class FormDeteksi extends javax.swing.JFrame {

    String hasil;
    Koneksi con;
    Statement st;
    ResultSet res;

    tb_model tbl = new tb_model();
    FormulaDao frd = new FormulaDao();
    ReportDao rpd = new ReportDao();
    DeteksiDao dtd = new DeteksiDao();

    private String rs[][];
    String[] namaKolom = {"Kode Gejala", "Nama"};
    int jmlKolom = namaKolom.length;
    int[] lebar = {50, 400};

    private String rs2[][];
    String[] namaKolom2 = {"Id Riwayat", "Kode Gejala", "Nama Gejala"};
    int jmlKolom2 = namaKolom2.length;
    int[] lebar2 = {100, 100, 400};

    ArrayList<String> listKode = new ArrayList<String>() {
    };

    public FormDeteksi() {
        initComponents();
        setLocationRelativeTo(this);
        Refresh();
    }

    private void CheckSolusi(String Id){
        con = new Koneksi();
        try{
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_solusi WHERE Id = '"+Id+"'");
            while(res.next()){
                tb_pelanggan.setSolusi(res.getString("solusi"));
            }
        }catch(SQLException ex){
            
        }
    }
    
    private void Refresh() {
        frd.setIdRiwayat(frd.IdRiwayat());
        frd.setKode("");
        frd.setGejala("");
        btnHapus.setEnabled(false);
        btnLanjutkan.setEnabled(true);
        btnCancel.setEnabled(false);
        tb_pelanggan.setSolusi("Tidak Ada");
        tb_pelanggan.setIdriwayat("");
    }

    private void CheckHasil() {
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_rules WHERE ket = '" + hasil + "'");
            if (res.next()) {
                frd.setKodePenyebab(res.getString("kode_penyebab"));
                txtKesimpulan.setText(res.getString("nama_penyebab"));
            } else {
                txtKesimpulan.setText("Gejala Yang di Pilih Tidak Jelas, Silahkan Pilih Kembali !!");
            }
        } catch (SQLException ex) {

        }
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
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGejala = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPilihan = new javax.swing.JTable();
        btnPilih = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnLanjutkan = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtKesimpulan = new javax.swing.JTextArea();
        btnCetak = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("SILAHKAN PILIH GEJALA YANG DIALAMI");

        tblGejala.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblGejala.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGejalaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblGejala);

        tblPilihan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPilihan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPilihanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPilihan);

        btnPilih.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnPilih.setText("PILIH");
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });

        btnHapus.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnHapus.setText("HAPUS");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnLanjutkan.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnLanjutkan.setText("LANJUTKAN");
        btnLanjutkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLanjutkanActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("KESIMPULAN");

        txtKesimpulan.setEditable(false);
        txtKesimpulan.setColumns(20);
        txtKesimpulan.setLineWrap(true);
        txtKesimpulan.setRows(5);
        jScrollPane3.setViewportView(txtKesimpulan);

        btnCetak.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCetak.setText("CETAK");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCetak)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnCancel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCancel.setText("CANCEL");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE)
                        .addGap(486, 486, 486))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnPilih, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnLanjutkan, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPilih)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnHapus)
                            .addComponent(btnLanjutkan)
                            .addComponent(btnCancel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        rs = frd.ShowGejala();
        tbl.SetTabel(tblGejala, rs, namaKolom, jmlKolom, lebar);

        rs2 = frd.ShowDetail(frd.getIdRiwayat());
        tbl.SetTabel(tblPilihan, rs2, namaKolom2, jmlKolom2, lebar2);
    }//GEN-LAST:event_formWindowActivated

    private void tblGejalaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGejalaMouseClicked
        // TODO add your handling code here:
        int row = tblGejala.getSelectedRow();
        frd.setKode(tblGejala.getValueAt(row, 0).toString());
        frd.setGejala(tblGejala.getValueAt(row, 1).toString());
        
    }//GEN-LAST:event_tblGejalaMouseClicked

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        // TODO add your handling code here:
        if (frd.getKode().equals("")) {
            JOptionPane.showMessageDialog(null, "Silahkan Pilih Gejala Dahulu !!");
            tblGejala.requestFocus();
        } else {
            con = new Koneksi();
            try {
                st = con.connect().createStatement();
                res = st.executeQuery("SELECT *FROM tb_deteksi WHERE id_riwayat = '" + frd.getIdRiwayat() + "' AND kode = '" + frd.getKode() + "' ");
                if (res.next()) {
                    JOptionPane.showMessageDialog(null, "Gejala Telah di Tambahkan, Silahkan di Ganti !!");
                    tblGejala.requestFocus();
                } else {
                    frd.Save(frd.getIdRiwayat(), frd.getKode(), frd.getGejala());
                    Refresh();
                }
            } catch (SQLException ex) {

            }
        }
    }//GEN-LAST:event_btnPilihActionPerformed

    private void btnLanjutkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLanjutkanActionPerformed
        // TODO add your handling code here:
        int size = tblPilihan.getRowCount();
        for (int a = 0; a < size; a++) {
            listKode.add(tblPilihan.getValueAt(a, 1).toString());
        }

        hasil = "";
        int listCount = listKode.size();
        for (int i = 0; i < listCount; i++) {
            hasil = hasil + listKode.get(i) + ", ";

        }

        CheckHasil();
        btnLanjutkan.setEnabled(false);
        btnCancel.setEnabled(false);
    }//GEN-LAST:event_btnLanjutkanActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        if (txtKesimpulan.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kesimpulan Kosong !!");
        } else {
            dtd.SaveRiwayat(frd.getIdRiwayat(), tblPilihan.getRowCount(),frd.getKodePenyebab());
            tb_pelanggan.setIdriwayat(frd.getIdRiwayat());
            tb_pelanggan.setKerusakan(txtKesimpulan.getText().trim());
            CheckSolusi(frd.getKodePenyebab());
            new FormDataPelanggan().show();
            Refresh();
            dispose();
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void tblPilihanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPilihanMouseClicked
        // TODO add your handling code here:
        int getRow = tblPilihan.getSelectedRow();
        frd.setIdRiwayat(tblPilihan.getValueAt(getRow, 0).toString());
        frd.setKode(tblPilihan.getValueAt(getRow, 1).toString());
        btnHapus.setEnabled(true);
        btnLanjutkan.setEnabled(false);
        btnCancel.setEnabled(true);
    }//GEN-LAST:event_tblPilihanMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        frd.Delete(frd.getKode(), frd.getIdRiwayat());
        Refresh();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        Refresh();
    }//GEN-LAST:event_btnCancelActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormDeteksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormDeteksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormDeteksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormDeteksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormDeteksi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnLanjutkan;
    private javax.swing.JButton btnPilih;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblGejala;
    private javax.swing.JTable tblPilihan;
    private javax.swing.JTextArea txtKesimpulan;
    // End of variables declaration//GEN-END:variables
}
