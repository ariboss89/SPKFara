/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controller.Koneksi;
import Dao.DeteksiDao;
import Dao.ReportDao;
import Models.tb_deteksi;
import Models.tb_pelanggan;
import java.awt.Dimension;
import java.awt.List;
import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class FormDeteksi extends javax.swing.JFrame {

    private Koneksi con;
    private Statement st;
    private ResultSet res;
    tb_deteksi dtk = new tb_deteksi();
    tb_pelanggan tbp = new tb_pelanggan();
    ReportDao rpt = new ReportDao();
    private int Id;
    private String g1, g2, g3, g4, g5, g6, g7, g8, g9, g10, g11, g12;

    public FormDeteksi() {
        initComponents();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (dim.width - getWidth()) / 2;
        int y = (dim.height - getHeight()) / 2;
        setLocation(x, y);
        String KodeGejala = "G001";
        ShowGejala(KodeGejala);
        Id = 1;
        ShowPertanyaan(Id);
        IdRiwayat();
    }

    void ShowGejala(String Kode) {
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_gejala WHERE kode = '" + Kode + "' ");
            while (res.next()) {
                lblPertanyaan.setText("Apakah " + res.getString("nama") + " ?");
                dtk.setGejala(res.getString("kode"));
            }
        } catch (SQLException e) {

        }
    }

    void ShowPertanyaan(int Id) {
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_gejala WHERE Id = '" + Id + "' ");
            while (res.next()) {
                lblPertanyaan.setText("Apakah " + res.getString("nama") + " ?");
                dtk.setGejala(res.getString("kode"));
                Id++;
            }
        } catch (SQLException e) {

        }
    }

    void ShowKesimpulan(String Id) {
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_solusi WHERE Id = '" + dtk.getKesimpulan() + "'");
            while (res.next()) {
                jTextArea1.setText(res.getString("solusi") +" dan termasuk dalam kategori kerusakan "+ dtk.getNamaPenyebab());
            }
        } catch (SQLException e) {

        }
    }
    
    void ShowPenyebab(String kode) {
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_penyebab WHERE Id = '" + dtk.getPenyebab() + "'");
            while (res.next()) {
                dtk.setNamaPenyebab(res.getString("nama"));
                tb_pelanggan.setKerusakan(res.getString("nama"));
            }
        } catch (SQLException e) {

        }
    }

    void TambahData(String gejala) {
        DefaultTableModel dataModel = (DefaultTableModel) jTable1.getModel();
        ArrayList list = new ArrayList<>();
        jTable1.setAutoCreateColumnsFromModel(true);
        list.add(dtk.getKodeGejala());
        list.add(gejala);
        list.add(dtk.getJawaban());
        dataModel.addRow(list.toArray());
    }

    void DeleteRow() {
        DefaultTableModel dataModel = (DefaultTableModel) jTable1.getModel();
        int rowCount = jTable1.getRowCount();
        for (int i = rowCount - 1; i > -1; i--) {
            dataModel.removeRow(i);
        }

        jTextArea1.setText("");
    }

    void EnabledBtn() {
        btnYa.setEnabled(true);
        btnTidak.setEnabled(true);
    }

    void DisabledBtn() {
        btnYa.setEnabled(false);
        btnTidak.setEnabled(false);
    }

    private void IdRiwayat() {
        con = new Koneksi();
        try {
            Statement st = con.connect().createStatement();
            ResultSet rs = st.executeQuery("select *from tb_riwayat ORDER BY idriwayat DESC");
            if (rs.first() == false) {
                dtk.setIdriwayat("R001");
            } else {
                rs.first();
                System.out.println("COT: " + rs.getString("idriwayat").substring(1, 4));
                int nokirim = Integer.valueOf(rs.getString("idriwayat").substring(1, 4)) + 1;
                System.out.println(nokirim);
                if (nokirim < 10) {
                    dtk.setIdriwayat("R00" + nokirim);
                } else if (nokirim >= 10 && nokirim < 100) {
                    dtk.setIdriwayat("R0" + nokirim);
                } else if (nokirim >= 100 && nokirim < 1000) {
                    dtk.setIdriwayat("R" + nokirim);
                }
            }
            rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }
    }

    void ShowNamaGejala(String gejala){
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_gejala WHERE kode = '" + gejala + "' ");
            while (res.next()) {
                dtk.setKodeGejala(gejala);
                dtk.setNamaGejala(res.getString("nama"));
            }
        } catch (SQLException e) {

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
        lblPertanyaan = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnYa = new javax.swing.JButton();
        btnTidak = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnCetak = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnUlang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SILAHKAN JAWAB PERTANYAAN DIBAWAH INI DENGAN MENGKLIK PILIHAN YA / TIDAK");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(51, 102, 255));

        lblPertanyaan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPertanyaan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPertanyaan.setText("PERTANYAAN");
        lblPertanyaan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("KESIMPULAN DAN SOLUSI");

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        btnYa.setBackground(new java.awt.Color(51, 255, 51));
        btnYa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnYa.setText("YA");
        btnYa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnYaActionPerformed(evt);
            }
        });

        btnTidak.setBackground(new java.awt.Color(255, 0, 0));
        btnTidak.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnTidak.setText("TIDAK");
        btnTidak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTidakActionPerformed(evt);
            }
        });

        btnCetak.setBackground(new java.awt.Color(0, 0, 0));
        btnCetak.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCetak.setForeground(new java.awt.Color(51, 51, 255));
        btnCetak.setText("CETAK");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Gejala", "Jawaban"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        btnUlang.setBackground(new java.awt.Color(255, 255, 0));
        btnUlang.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUlang.setText("ULANG");
        btnUlang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUlangActionPerformed(evt);
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
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(430, 430, 430))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnCetak, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnUlang, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnYa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnTidak))
                            .addComponent(jSeparator1)
                            .addComponent(lblPertanyaan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPertanyaan, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTidak)
                    .addComponent(btnYa))
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCetak)
                            .addComponent(btnUlang)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnYaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnYaActionPerformed

        String Id = dtk.getGejala();
        g1 = dtk.getGejala1();
        g2 = dtk.getGejala2();
        g3 = dtk.getGejala3();
        g4 = dtk.getGejala4();
        g5 = dtk.getGejala5();
        g6 = dtk.getGejala6();
        g7 = dtk.getGejala7();
        g8 = dtk.getGejala8();
        g9 = dtk.getGejala9();
        g10 = dtk.getGejala10();
        g11 = dtk.getGejala11();
        g12 = dtk.getGejala12();

        //rules3
        if (Id.equals("G001")) {
            dtk.setJawaban("YA");
            dtk.setGejala1("G001");
            ShowNamaGejala(dtk.getGejala1());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G002");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G002") && g1 == ("G001")) {
            dtk.setJawaban("YA");
            dtk.setGejala2("G002");
            ShowNamaGejala(dtk.getGejala2());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G003");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G003") && g1 == ("G001") && g2 == ("G002")) {
            dtk.setJawaban("YA");
            dtk.setGejala3("G003");
            ShowNamaGejala(dtk.getGejala3());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G004");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G004") && g1 == ("G001") && g2 == ("G002") && g3 == ("G003")) {
            dtk.setJawaban("YA");
            dtk.setGejala4("G004");
            ShowNamaGejala(dtk.getGejala4());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G008");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G008") && g1 == ("G001") && g2 == ("G002") && g3 == ("G003") && g4 == ("G004")) {
            dtk.setJawaban("YA");
            dtk.setGejala5("G008");
            ShowNamaGejala(dtk.getGejala5());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G012");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G012") && g1 == ("G001") && g2 == ("G002") && g3 == ("G003") && g4 == ("G004") && g5 == ("G008")) {
            dtk.setJawaban("YA");
            dtk.setGejala6("G012");
            ShowNamaGejala(dtk.getGejala6());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G014");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G014") && g1 == ("G001") && g2 == ("G002") && g3 == ("G003") && g4 == ("G004") && g5 == ("G008") && g6 == ("G012")) {
            dtk.setJawaban("YA");
            dtk.setGejala7("G014");
            ShowNamaGejala(dtk.getGejala7());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G015");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G015") && g1 == ("G001") && g2 == ("G002") && g3 == ("G003") && g4 == ("G004") && g5 == ("G008") && g6 == ("G012") && g7 == ("G014")) {
            dtk.setJawaban("YA");
            dtk.setGejala8("G015");
            ShowNamaGejala(dtk.getGejala8());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G016");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G016") && g1 == ("G001") && g2 == ("G002") && g3 == ("G003") && g4 == ("G004") && g5 == ("G008") && g6 == ("G012") && g7 == ("G014") && g8 == ("G015")) {
            dtk.setJawaban("YA");
            dtk.setGejala9("G016");
            ShowNamaGejala(dtk.getGejala9());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G017");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G017") && g1 == ("G001") && g2 == ("G002") && g3 == ("G003") && g4 == ("G004") && g5 == ("G008") && g6 == ("G012") && g7 == ("G014") && g8 == ("G015") && g9 == ("G016")) {
            dtk.setJawaban("YA");
            dtk.setGejala10("G017");
            ShowNamaGejala(dtk.getGejala10());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G018");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G018") && g1 == ("G001") && g2 == ("G002") && g3 == ("G003") && g4 == ("G004") && g5 == ("G008") && g6 == ("G012") && g7 == ("G014") && g8 == ("G015") && g9 == ("G016") && g10 == ("G017")) {
            dtk.setJawaban("YA");
            dtk.setGejala11("G018");
            ShowNamaGejala(dtk.getGejala11());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G019");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G019") && g1 == ("G001") && g2 == ("G002") && g3 == ("G003") && g4 == ("G004") && g5 == ("G008") && g6 == ("G012") && g7 == ("G014") && g8 == ("G015") && g9 == ("G016") && g10 == ("G017") && g11 == ("G018")) {
            dtk.setJawaban("YA");
            dtk.setGejala12("G019");
            ShowNamaGejala(dtk.getGejala12());
            TambahData(dtk.getNamaGejala());
            dtk.setKesimpulan("P03");
            dtk.setPenyebab("P03");
            ShowPenyebab(dtk.getPenyebab());
            ShowKesimpulan(dtk.getKesimpulan());
            
            DisabledBtn();
        } 

        //rules 1
        else if (Id.equals("G005") && g1 == ("G001") && g2 == null) {
            dtk.setJawaban("YA");
            dtk.setGejala2("G005");
            ShowNamaGejala(dtk.getGejala2());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G006");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G006") && g1 == ("G001") && g2 == ("G005")) {
            dtk.setJawaban("YA");
            dtk.setGejala3("G006");
            ShowNamaGejala(dtk.getGejala3());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G007");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G007") && g1 == ("G001") && g2 == ("G005") && g3 == ("G006")) {
            dtk.setJawaban("YA");
            dtk.setGejala4("G007");
            ShowNamaGejala(dtk.getGejala4());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G009");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G009") && g1 == ("G001") && g2 == ("G005") && g3 == ("G006") && g4 == ("G007")) {
            dtk.setJawaban("YA");
            dtk.setGejala5("G009");
            ShowNamaGejala(dtk.getGejala5());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G010");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G010") && g1 == ("G001") && g2 == ("G005") && g3 == ("G006") && g4 == ("G007") && g5 == ("G009")) {
            dtk.setJawaban("YA");
            dtk.setGejala6("G010");
            ShowNamaGejala(dtk.getGejala6());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G013");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G013") && g1 == ("G001") && g2 == ("G005") && g3 == ("G006") && g4 == ("G007") && g5 == ("G009") && g6 == ("G010")) {
            dtk.setJawaban("YA");
            dtk.setGejala7("G013");
            ShowNamaGejala(dtk.getGejala7());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G018");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G018") && g1 == ("G001") && g2 == ("G005") && g3 == ("G006") && g4 == ("G007") && g5 == ("G009") && g6 == ("G010") && g7 == ("G013")) {
            dtk.setJawaban("YA");
            dtk.setGejala8("G018");
            ShowNamaGejala(dtk.getGejala8());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G020");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G020") && g1 == ("G001") && g2 == ("G005") && g3 == ("G006") && g4 == ("G007") && g5 == ("G009") && g6 == ("G010") && g7 == ("G013") && g8 == ("G018")) {
            dtk.setJawaban("YA");
            dtk.setGejala9("G020");
            ShowNamaGejala(dtk.getGejala9());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G026");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G026") && g1 == ("G001") && g2 == ("G005") && g3 == ("G006") && g4 == ("G007") && g5 == ("G009") && g6 == ("G010") && g7 == ("G013") && g8 == ("G018") && g9 == ("G020")) {
            dtk.setJawaban("YA");
            dtk.setGejala10("G026");
            ShowNamaGejala(dtk.getGejala10());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G029");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G029") && g10 == ("G026")) {
            dtk.setJawaban("YA");
            dtk.setGejala11("G029");
            ShowNamaGejala(dtk.getGejala11());
            TambahData(dtk.getNamaGejala());
            dtk.setKesimpulan("P01");
            dtk.setPenyebab("P01");
            ShowPenyebab(dtk.getPenyebab());
            ShowKesimpulan(dtk.getKesimpulan());
            DisabledBtn();
        } 

        //rules 2
        else if (Id.equals("G004") && g1 == ("G001") && g2 == ("G002")) {
            dtk.setJawaban("YA");
            dtk.setGejala3("G004");
            ShowNamaGejala(dtk.getGejala3());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G008");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G008") && g1 == ("G001") && g2 == ("G002") && g3 == ("G004")) {
            dtk.setJawaban("YA");
            dtk.setGejala4("G008");
            ShowNamaGejala(dtk.getGejala4());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G009");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G009") && g1 == ("G001") && g2 == ("G002") && g3 == ("G004") && g4 == ("G008")) {
            dtk.setJawaban("YA");
            dtk.setGejala5("G009");
            ShowNamaGejala(dtk.getGejala5());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G010");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G010") && g1 == ("G001") && g2 == ("G002") && g3 == ("G004") && g4 == ("G008") && g5 == ("G009")) {
            dtk.setJawaban("YA");
            dtk.setGejala6("G010");
            ShowNamaGejala(dtk.getGejala6());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G011");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G011") && g1 == ("G001") && g2 == ("G002") && g3 == ("G004") && g4 == ("G008") && g5 == ("G009") && g6 == ("G010")) {
            dtk.setJawaban("YA");
            dtk.setGejala7("G011");
            ShowNamaGejala(dtk.getGejala7());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G023");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G023") && g1 == ("G001") && g2 == ("G002") && g3 == ("G004") && g4 == ("G008") && g5 == ("G009") && g6 == ("G010") && g7 == ("G011")) {
            dtk.setJawaban("YA");
            dtk.setGejala8("G023");
            ShowNamaGejala(dtk.getGejala8());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G027");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G027") && g1 == ("G001") && g2 == ("G002") && g3 == ("G004") && g4 == ("G008") && g5 == ("G009") && g6 == ("G010") && g7 == ("G011") && g8 == ("G023")) {
            dtk.setJawaban("YA");
            dtk.setGejala9("G027");
            ShowNamaGejala(dtk.getGejala9());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G029");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G029") && g1 == ("G001") && g2 == ("G002") && g3 == ("G004") && g4 == ("G008") && g5 == ("G009") && g6 == ("G010") && g7 == ("G011") && g8 == ("G023") && g9 == ("G027")) {
            dtk.setJawaban("YA");
            dtk.setGejala10("G029");
            ShowNamaGejala(dtk.getGejala10());
            TambahData(dtk.getNamaGejala());
            dtk.setKesimpulan("P02");
            dtk.setPenyebab("P02");
            ShowPenyebab(dtk.getPenyebab());
            ShowKesimpulan(dtk.getKesimpulan());
            DisabledBtn();
        } 

        //rules 4
        else if (Id.equals("G007") && g1 == ("G001") && g2 != "G003") {
            dtk.setJawaban("YA");
            dtk.setGejala2("G007");
            ShowNamaGejala(dtk.getGejala2());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G020");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G020") && g1 == ("G001") && g2 == ("G007")) {
            dtk.setJawaban("YA");
            dtk.setGejala3("G020");
            ShowNamaGejala(dtk.getGejala3());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G021");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G021") && g1 == ("G001") && g2 == ("G007") && g3 == ("G020")) {
            dtk.setJawaban("YA");
            dtk.setGejala4("G021");
            ShowNamaGejala(dtk.getGejala4());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G024");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G024") && g1 == ("G001") && g2 == ("G007") && g3 == ("G020") && g4 == ("G021")) {
            dtk.setJawaban("YA");
            dtk.setGejala5("G024");
            ShowNamaGejala(dtk.getGejala5());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G029");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G029") && g1 == ("G001") && g2 == ("G007") && g3 == ("G020") && g4 == ("G021") && g5 == ("G024")) {
            dtk.setJawaban("YA");
            dtk.setGejala6("G029");
            ShowNamaGejala(dtk.getGejala6());
            TambahData(dtk.getNamaGejala());
            dtk.setKesimpulan("P04");
            dtk.setPenyebab("P024");
            ShowPenyebab(dtk.getPenyebab());
            ShowKesimpulan(dtk.getKesimpulan());            
            DisabledBtn();
        } 

        //rules5
        else if (Id.equals("G020") && g1 == ("G001") && g2 == null) {
            dtk.setJawaban("YA");
            dtk.setGejala2("G020");
            ShowNamaGejala(dtk.getGejala2());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G022");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G022") && g1 == ("G001") && g2 == ("G020")) {
            dtk.setJawaban("YA");
            dtk.setGejala3("G022");
            ShowNamaGejala(dtk.getGejala3());
            TambahData(dtk.getNamaGejala());
            dtk.setKesimpulan("P05");
            dtk.setPenyebab("P05");
            ShowPenyebab(dtk.getPenyebab());
            ShowKesimpulan(dtk.getKesimpulan());            
            DisabledBtn();
        } 

        //rules 6
        else if (Id.equals("G004") && g1 == ("G001")) {
            dtk.setJawaban("YA");
            dtk.setGejala2("G004");
            ShowNamaGejala(dtk.getGejala2());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G023");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G023") && g1 == ("G001") && g2 == ("G004")) {
            dtk.setJawaban("YA");
            dtk.setGejala3("G023");
            ShowNamaGejala(dtk.getGejala3());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G025");
            dtk.setPenyebab("K02");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G025") && g1 == ("G001") && g2 == ("G004") && g3 == ("G023")) {
            dtk.setJawaban("YA");
            dtk.setGejala4("G025");
            ShowNamaGejala(dtk.getGejala4());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G028");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G028") && g1 == ("G001") && g2 == ("G004") && g3 == ("G023") && g4 == ("G025")) {
            dtk.setJawaban("YA");
            dtk.setGejala5("G028");
            ShowNamaGejala(dtk.getGejala5());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G030");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G030") && g1 == ("G001") && g2 == ("G004") && g3 == ("G023") && g4 == ("G025") && g5 == ("G028")) {
            dtk.setJawaban("YA");
            dtk.setGejala6("G030");
            ShowNamaGejala(dtk.getGejala6());
            TambahData(dtk.getNamaGejala());
            dtk.setKesimpulan("P06");
            dtk.setPenyebab("P06");
            ShowPenyebab(dtk.getPenyebab());
            ShowKesimpulan(dtk.getKesimpulan());
            DisabledBtn();
        } //rules7
        else if (Id.equals("G027") && g1 == null) {
            dtk.setJawaban("YA");
            dtk.setGejala1("G027");
            ShowNamaGejala(dtk.getGejala1());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G028");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G028") && g1 == ("G027")) {
            dtk.setJawaban("YA");
            dtk.setGejala2("G028");
            ShowNamaGejala(dtk.getGejala2());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G031");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G031") && g1 == ("G027") && g2 == ("G028")) {
            dtk.setJawaban("YA");
            dtk.setGejala3("G031");
            ShowNamaGejala(dtk.getGejala3());
            TambahData(dtk.getNamaGejala());
            dtk.setKesimpulan("P07");
            dtk.setPenyebab("P07");
            ShowPenyebab(dtk.getPenyebab());
            ShowKesimpulan(dtk.getKesimpulan());
            DisabledBtn();
        } //rules8
        else if (Id.equals("G003") && g1 == ("G001")) {
            dtk.setJawaban("YA");
            dtk.setGejala2("G003");
            ShowNamaGejala(dtk.getGejala2());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G005");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G005") && g1 == ("G001") && g2 != (null)) {
            dtk.setJawaban("YA");
            dtk.setGejala3("G005");
            ShowNamaGejala(dtk.getGejala3());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G007");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G007") && g1 == ("G001") && g2 == ("G003") && g3 == ("G005")) {
            dtk.setJawaban("YA");
            dtk.setGejala4("G007");
            ShowNamaGejala(dtk.getGejala4());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G008");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G008") && g4 == ("G007")) {
            dtk.setJawaban("YA");
            dtk.setGejala5("G008");
            ShowNamaGejala(dtk.getGejala5());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G012");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G012") && g5 == ("G008")) {
            dtk.setJawaban("YA");
            dtk.setGejala6("G012");
            ShowNamaGejala(dtk.getGejala6());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G013");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G013") && g6 == ("G012")) {
            dtk.setJawaban("YA");
            dtk.setGejala7("G013");
            ShowNamaGejala(dtk.getGejala7());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G014");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G014") && g7 == ("G013")) {
            dtk.setJawaban("YA");
            dtk.setGejala8("G014");
            ShowNamaGejala(dtk.getGejala8());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G015");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G015") && g8 == ("G014")) {
            dtk.setJawaban("YA");
            dtk.setGejala9("G015");
            ShowNamaGejala(dtk.getGejala9());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G017");
            ShowGejala(dtk.getGejala());;
        } else if (Id.equals("G017") && g9 == ("G015")) {
            dtk.setJawaban("YA");
            dtk.setGejala10("G017");
            ShowNamaGejala(dtk.getGejala10());
            TambahData(dtk.getNamaGejala());
            dtk.setKesimpulan("P08");
            dtk.setPenyebab("P08");
            ShowPenyebab(dtk.getPenyebab());
            ShowKesimpulan(dtk.getKesimpulan());
            DisabledBtn();
        } else {
            dtk.setJawaban("YA");
            TambahData(dtk.getGejala());
            jTextArea1.setText("KERUSAKAN YANG ANDA PILIH TIDAK JELAS, SILAHKAN ULANGI ");
            btnCetak.setEnabled(false);
            DisabledBtn();
        }
    }//GEN-LAST:event_btnYaActionPerformed

    private void btnTidakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTidakActionPerformed
        // TODO add your handling code here:
        String Id = dtk.getGejala();
        g1 = dtk.getGejala1();
        g2 = dtk.getGejala2();
        g3 = dtk.getGejala3();
        g4 = dtk.getGejala4();
        g5 = dtk.getGejala5();
        g6 = dtk.getGejala6();
        g7 = dtk.getGejala7();
        g8 = dtk.getGejala8();
        g9 = dtk.getGejala9();
        g10 = dtk.getGejala10();
        g11 = dtk.getGejala11();
        g12 = dtk.getGejala12();

        if (Id.equals("G001")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G002");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G002")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G003");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G003")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G004");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G004")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G005");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G005")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G006");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G006")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G007");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G007")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G008");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G008")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G009");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G009")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G010");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G010")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G011");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G011")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G012");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G012")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G013");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G013")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G014");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G014")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G015");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G015")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G016");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G016")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G017");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G017")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G018");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G018")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G019");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G019")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G020");
            ShowGejala(dtk.getGejala());
        } else if (Id.equals("G020")) {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            dtk.setGejala("G027");
            ShowGejala(dtk.getGejala());
        } else {
            dtk.setJawaban("TIDAK");
            ShowNamaGejala(dtk.getGejala());
            TambahData(dtk.getNamaGejala());
            jTextArea1.setText("KERUSAKAN YANG ANDA PILIH TIDAK JELAS, SILAHKAN ULANGI ");
            btnCetak.setEnabled(false);
            DisabledBtn();
        }

    }//GEN-LAST:event_btnTidakActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:

    }//GEN-LAST:event_formWindowActivated

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        int rowCount = jTable1.getRowCount();

        if (rowCount == 0) {
            JOptionPane.showMessageDialog(null, "Silahkan Jawab Dahulu Pertanyaan di Atas");
        } else {
            for (int i = 0; i < rowCount; i++) {
                String idRiwayat = dtk.getIdriwayat();
                String kode = (String) jTable1.getValueAt(i, 0);
                String gejala = (String) jTable1.getValueAt(i, 1);
                String jawaban = (String) jTable1.getValueAt(i, 2);

                dtk.Save(idRiwayat,kode, gejala, jawaban);
            }

            tb_pelanggan.setIdriwayat(dtk.getIdriwayat());
            dtk.SaveRiwayat(dtk.getIdriwayat(), rowCount, dtk.getKesimpulan());
            tb_pelanggan.setSolusi(jTextArea1.getText().trim());
            new FormDataPelanggan().show();
            dispose();
//            rpt.CetakLaporan(dtk.getIdriwayat(), jTextArea1.getText().trim());
            
            IdRiwayat();
            DeleteRow();
            ShowGejala("G001");
            btnCetak.setEnabled(true);
            EnabledBtn();

        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnUlangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUlangActionPerformed
        // TODO add your handling code here:
        DeleteRow();
        ShowGejala("G001");
        dtk.setGejala1(null);
        dtk.setGejala2(null);
        dtk.setGejala3(null);
        dtk.setGejala4(null);
        dtk.setGejala5(null);
        dtk.setGejala6(null);
        dtk.setGejala7(null);
        dtk.setGejala8(null);
        dtk.setGejala9(null);
        dtk.setGejala10(null);
        dtk.setGejala11(null);
        dtk.setGejala12(null);
        btnCetak.setEnabled(true);
        EnabledBtn();
    }//GEN-LAST:event_btnUlangActionPerformed

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
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnTidak;
    private javax.swing.JButton btnUlang;
    private javax.swing.JButton btnYa;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblPertanyaan;
    // End of variables declaration//GEN-END:variables
}
