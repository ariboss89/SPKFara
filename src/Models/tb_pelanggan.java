/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

/**
 *
 * @author User
 */
public class tb_pelanggan {
    public static String idriwayat;
    public static String idmeter;
    public static String nama;
    public static String solusi;
    public static String kerusakan;

    public static String getKerusakan() {
        return kerusakan;
    }

    public static void setKerusakan(String kerusakan) {
        tb_pelanggan.kerusakan = kerusakan;
    }
    
    public static String getSolusi() {
        return solusi;
    }

    public static void setSolusi(String solusi) {
        tb_pelanggan.solusi = solusi;
    }
    
    public static String getIdriwayat() {
        return idriwayat;
    }

    public static void setIdriwayat(String idriwayat) {
        tb_pelanggan.idriwayat = idriwayat;
    }

    public static String getIdmeter() {
        return idmeter;
    }

    public static void setIdmeter(String idmeter) {
        tb_pelanggan.idmeter = idmeter;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        tb_pelanggan.nama = nama;
    }
}
