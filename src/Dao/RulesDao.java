/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dao;

import Controller.Koneksi;
import Models.tb_rules;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class RulesDao extends tb_rules {
    
    Koneksi con;
    ResultSet rs;
    Statement st;
    String query;
    
    
    public String IdRules() {
        String id="";
        con = new Koneksi();
        try {
            st = con.connect().createStatement();
            rs = st.executeQuery("SELECT *FROM tb_rules ORDER BY kode_rules DESC");
            if (rs.first() == false) {
                id = ("R001");
            } else {
                rs.first();
                System.out.println("COT: " + rs.getString("kode_rules").substring(1, 4));
                int nokirim = Integer.valueOf(rs.getString("kode_rules").substring(1, 4)) + 1;
                System.out.println(nokirim);
                if (nokirim < 10) {
                    id = ("R00" + nokirim);
                } else if (nokirim >= 10 && nokirim < 100) {
                    id = ("R0" + nokirim);
                } else if (nokirim >= 100 && nokirim < 1000) {
                    id = ("R" + nokirim);
                }
            }
            rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }
        
        return id;
    }
    
     public void SaveRules(String kodeRules, String ket, String kodePenyebab, String namaPenyebab) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "insert into tb_rules(kode_rules, ket, kode_penyebab, nama_penyebab)values('" + kodeRules + "','" + ket + "','" + kodePenyebab + "','" + namaPenyebab + "')";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
            JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan");
        } catch (SQLException e) {
        }
    }
     
     public void UpdateRules(String kode, String ket) {
        con = new Koneksi();
        con.connect();
        try {
            st = con.conn.createStatement();
            query = "update tb_rules set ket ='" + ket + "' where kode_penyebab = '" + kode + "'";
            st.executeUpdate(query);
            st.close();
            con.conn.close();
        } catch (SQLException e) {

        }
    }
}
