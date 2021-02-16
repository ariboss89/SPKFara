/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Controller.Koneksi;
import Models.tb_pengetahuan;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class PengetahuanDao extends tb_pengetahuan{
    private Koneksi con;
    private Statement st;
    private ResultSet res;
    private String query;
    
    public void SaveRules(String kodeGejala, String namaGejala, String kodePenyebab, String namaPenyebab) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_pengetahuan(kode_gejala, nama_gejala, kode_penyebab, nama_penyebab)values('" + kodeGejala + "','" + namaGejala + "','" + kodePenyebab + "','" + namaPenyebab + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }

    public void Update(int Id, String kodeGejala, String namaGejala, String kodePenyebab, String namaPenyebab) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_pengetahuan set kode_gejala ='" + kodeGejala + "',nama_gejala ='" + namaGejala + "',kode_penyebab ='" + kodePenyebab + "',nama_penyebab ='" + namaPenyebab + "' where Id = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {

        }
    }

    public void Delete(int Id) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_rules where Id = '" + Id + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Hapus");
        } catch (SQLException e) {

        }
    }
    
    public String[][] Show(String kode) {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_pengetahuan";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_pengetahuan WHERE kode_penyebab = '"+kode+"' ORDER BY kode_gejala Asc";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][5];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("kode_gejala");
                data[r][2] = res.getString("nama_gejala");
                data[r][3] = res.getString("kode_penyebab");
                data[r][4] = res.getString("nama_penyebab");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][5];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 5; c++) {
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
