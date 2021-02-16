/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Controller.Koneksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class GejalaDao {
    
    private Koneksi con;
    private Statement st;
    private ResultSet res;
    private String query;
    
    public String IdGejala() {
        
        String idGejala = "";
        
        con = new Koneksi();
        try {
            
            st = con.connect().createStatement();
            res = st.executeQuery("SELECT *FROM tb_gejala ORDER BY kode DESC");
            if (res.first() == false) {
                idGejala=("G001");
            } else {
                res.first();
                System.out.println("COT: " + res.getString("kode").substring(1, 4));
                int nokirim = Integer.valueOf(res.getString("kode").substring(1, 4)) + 1;
                System.out.println(nokirim);
                if (nokirim < 10) {
                    idGejala=("G00" + nokirim);
                } else if (nokirim >= 10 && nokirim < 100) {
                    idGejala=("G0" + nokirim);
                } else if (nokirim >= 100 && nokirim < 1000) {
                    idGejala=("G" + nokirim);
                }
            }
            res.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }
        
        return idGejala;
    }
    
    public void Save(String kode, String nama) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_gejala(kode, nama)values('" + kode + "','" + nama + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            //JOptionPane.showMessageDialog(null, "");
        } catch (SQLException e) {
        }
    }

    public void Update(String kode, String nama) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_gejala set nama ='" + nama + "' where kode = '" + kode + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {

        }
    }

    public void Delete(String kode) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_gejala where kode = '" + kode + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data di Hapus");
        } catch (SQLException e) {

        }
    }
    public String[][] Show() {

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
            data = new String[jumlahBaris][3];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("kode");
                data[r][2] = res.getString("nama");
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
