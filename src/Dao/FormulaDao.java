/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Controller.Koneksi;
import Models.tb_formula;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class FormulaDao extends tb_formula {
    Koneksi con;
    Statement st;
    ResultSet res;
    String query;
    
    public String IdRiwayat() {
        
        String idRiwayat = "";
        
        con = new Koneksi();
        try {
            
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_riwayat ORDER BY id_riwayat DESC");
            if (res.first() == false) {
                idRiwayat=("R001");
            } else {
                res.first();
                System.out.println("COT: " + res.getString("id_riwayat").substring(1, 4));
                int nokirim = Integer.valueOf(res.getString("id_riwayat").substring(1, 4)) + 1;
                System.out.println(nokirim);
                if (nokirim < 10) {
                    idRiwayat=("R00" + nokirim);
                } else if (nokirim >= 10 && nokirim < 100) {
                    idRiwayat=("R0" + nokirim);
                } else if (nokirim >= 100 && nokirim < 1000) {
                    idRiwayat=("R" + nokirim);
                }
            }
            res.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }
        
        return idRiwayat;
    }
    
    public void Save(String idriwayat, String kode, String gejala) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_deteksi(id_riwayat, kode, gejala)values('" + idriwayat + "','" + kode + "','" + gejala + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Tambahkan !!");
        } catch (SQLException e) {
        }
    }
    
    public void Delete(String kode, String idRiwayat) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_deteksi where kode = '" + kode + "' AND id_riwayat = '"+idRiwayat+"'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Hapus");
        } catch (SQLException e) {

        }
    }
    
    public String[][] ShowGejala() {

        res = null;
        String[][] data = null;
        con = new Koneksi();
        con.connect();
        int jumlahBaris = 0;
        try {
            st = con.conn.createStatement();
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_gejala";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_gejala order by Id Asc";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][2];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("kode");
                data[r][1] = res.getString("nama");
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
    
    public String[][] ShowDetail(String Id) {

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
            query = "select *from tb_deteksi WHERE id_riwayat = '"+Id+"' ORDER BY kode ASC";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][3];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("id_riwayat");
                data[r][1] = res.getString("kode");
                data[r][2] = res.getString("gejala");
                r++;
            }
            int jmlBaris = r;
            String[][] tmpArray = data;
            data = new String[jmlBaris][3];
            for (r = 0; r < jmlBaris; r++) {
                for (int c = 0; c < 3; c++) {
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
