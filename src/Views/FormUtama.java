/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Models.tb_admin;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class FormUtama extends javax.swing.JFrame {

    /**
     * Creates new form FormUtama
     */
    public FormUtama() {
        initComponents();
        menu_login.setVisible(true);
        menu_utama.setVisible(false);
        menu_deteksi.setVisible(true);
        menu_logout.setVisible(false);
        menuRules.setVisible(false);
        menu_exit.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background1 = new Image.Background();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu_login = new javax.swing.JMenu();
        menu_utama = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuRules = new javax.swing.JMenuItem();
        menuPengguna = new javax.swing.JMenuItem();
        menu_deteksi = new javax.swing.JMenu();
        menu_exit = new javax.swing.JMenu();
        menu_logout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        javax.swing.GroupLayout background1Layout = new javax.swing.GroupLayout(background1);
        background1.setLayout(background1Layout);
        background1Layout.setHorizontalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1364, Short.MAX_VALUE)
        );
        background1Layout.setVerticalGroup(
            background1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 745, Short.MAX_VALUE)
        );

        menu_login.setText("LOGIN");
        menu_login.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menu_login.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_loginMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_login);

        menu_utama.setText("MENU");
        menu_utama.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jMenuItem1.setText("GEJALA");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menu_utama.add(jMenuItem1);

        jMenuItem3.setText("PENYEBAB");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menu_utama.add(jMenuItem3);

        jMenuItem4.setText("SOLUSI");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menu_utama.add(jMenuItem4);

        menuRules.setText("RULES");
        menuRules.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRulesActionPerformed(evt);
            }
        });
        menu_utama.add(menuRules);

        menuPengguna.setText("PENGGUNA");
        menuPengguna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPenggunaActionPerformed(evt);
            }
        });
        menu_utama.add(menuPengguna);

        jMenuBar1.add(menu_utama);

        menu_deteksi.setText("DETEKSI");
        menu_deteksi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menu_deteksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_deteksiMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_deteksi);

        menu_exit.setText("EXIT APP");
        menu_exit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menu_exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_exitMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_exit);

        menu_logout.setText("LOG OUT");
        menu_logout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        menu_logout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menu_logoutMouseClicked(evt);
            }
        });
        jMenuBar1.add(menu_logout);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        new FormGejala().show();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        new FormPenyebab().show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        new FormSolusi().show();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void menu_exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_exitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_menu_exitMouseClicked

    private void menu_deteksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_deteksiMouseClicked
        // TODO add your handling code here:
        new FormDeteksi().show();
    }//GEN-LAST:event_menu_deteksiMouseClicked

    private void menu_loginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_loginMouseClicked
        // TODO add your handling code here:
        new FormLogin().show();
    }//GEN-LAST:event_menu_loginMouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        String username = tb_admin.getUsername();
        String role = tb_admin.getRole();

        if (username != null && role.equals("ADMIN")) {
            menuRules.setVisible(true);
            menu_login.setVisible(false);
            menu_utama.setVisible(true);
            menu_deteksi.setVisible(false);
            menu_logout.setVisible(true);
            menu_exit.setVisible(false);
            menuPengguna.setVisible(false);
        }else if (username != null && role.equals("SUPERADMIN")) {
            menuRules.setVisible(true);
            menu_login.setVisible(false);
            menu_utama.setVisible(true);
            menu_deteksi.setVisible(false);
            menu_logout.setVisible(true);
            menu_exit.setVisible(false);
            menuPengguna.setVisible(true);
        }
    }//GEN-LAST:event_formWindowActivated

    private void menu_logoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menu_logoutMouseClicked
        // TODO add your handling code here:
        int n = JOptionPane.showConfirmDialog(null, "APAKAH ANDA INGIN KELUAR ?", null, JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            tb_admin.setUsername(null);
            menu_login.setVisible(true);
            menu_utama.setVisible(false);
            menu_deteksi.setVisible(true);
            menu_logout.setVisible(false);
            menu_exit.setVisible(true);
            JOptionPane.showMessageDialog(null, "SAMPAI JUMPA LAGI !!");
        }
    }//GEN-LAST:event_menu_logoutMouseClicked

    private void menuRulesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRulesActionPerformed
        // TODO add your handling code here:
        new FormRules().show();
    }//GEN-LAST:event_menuRulesActionPerformed

    private void menuPenggunaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPenggunaActionPerformed
        // TODO add your handling code here:
        new FormAdmin().show();
    }//GEN-LAST:event_menuPenggunaActionPerformed

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
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Image.Background background1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem menuPengguna;
    private javax.swing.JMenuItem menuRules;
    private javax.swing.JMenu menu_deteksi;
    private javax.swing.JMenu menu_exit;
    private javax.swing.JMenu menu_login;
    private javax.swing.JMenu menu_logout;
    private javax.swing.JMenu menu_utama;
    // End of variables declaration//GEN-END:variables
}
