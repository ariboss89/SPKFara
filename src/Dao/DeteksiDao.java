/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Controller.Koneksi;
import Models.tb_deteksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class DeteksiDao{
    private Koneksi con;
    private Statement st;
    private ResultSet res;
    private String query;
    
    public void Save(String idriwayat, String kode, String gejala, String jawaban) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_deteksi(idriwayat, kode, gejala, jawaban)values('" + idriwayat + "','" + kode + "','" + gejala + "','" + jawaban + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
        } catch (SQLException e) {
        }
    }
    
    public void SaveRiwayat(String idriwayat, int totalgejala, String solusi) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_riwayat(id_riwayat, total_gejala, solusi)values('" + idriwayat + "','" + totalgejala + "','" + solusi + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
        } catch (SQLException e) {
        }
    }
    
    public String[][] Show(String idriwayat) {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_deteksi";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_deteksi WHERE idriwayat = '"+idriwayat+"'";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][2];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("gejala");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][2];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 2; c++) {
                    data[r][c] = tmpArray[r][c];
                }
            }
            st.close();
            con.conn.close();
        } catch (SQLException e) {
            System.err.println("SQLException : " + e.getMessage());
        }
        return data;
    }
}
