/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Controller.Koneksi;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class AdminDao {
     private Koneksi con;
    private Statement st;
    private ResultSet res;
    private String query;
       
    public void Save(String Id, String nama, String username, String password, String role) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_admin(Id, nama, username, password, role)values('" + Id + "','" + nama + "','" + username + "','" + password + "','" + role + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Tambahkan !!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Di Tambahkan");
        }
    }

    public void Update(String Id, String nama, String username, String password, String role) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_admin set Id ='" + Id + "', nama ='" + nama + "', password ='" + password + "', role ='" + role + "' where username = '" + username + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
        } catch (SQLException e) {

        }
    }

    public void Delete(String username) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "delete from tb_admin where username = '" + username + "'";
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
            query = "SELECT COUNT(Id) AS Jumlah FROM tb_admin";
            res = st.executeQuery(query);
            if (res.next()) {
                jumlahBaris = res.getInt("Jumlah");
            }
            query = "select *from tb_admin order by Id Asc";
            res = st.executeQuery(query);
            data = new String[jumlahBaris][5];
            int r = 0;
            while (res.next()) {
                data[r][0] = res.getString("Id");
                data[r][1] = res.getString("nama");
                data[r][2] = res.getString("username");
                data[r][3] = res.getString("password");
                data[r][4] = res.getString("role");
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
