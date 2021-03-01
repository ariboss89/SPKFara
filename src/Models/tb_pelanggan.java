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
    public static String alamat;
    public static String kerusakan;
    public static String idPetugas;
    public static String namaPetugas;
    public static String rayon;

    public static String getAlamat() {
        return alamat;
    }

    public static void setAlamat(String alamat) {
        tb_pelanggan.alamat = alamat;
    }

    public static String getIdPetugas() {
        return idPetugas;
    }

    public static void setIdPetugas(String idPetugas) {
        tb_pelanggan.idPetugas = idPetugas;
    }

    public static String getNamaPetugas() {
        return namaPetugas;
    }

    public static void setNamaPetugas(String namaPetugas) {
        tb_pelanggan.namaPetugas = namaPetugas;
    }

    public static String getRayon() {
        return rayon;
    }

    public static void setRayon(String rayon) {
        tb_pelanggan.rayon = rayon;
    }
    
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
