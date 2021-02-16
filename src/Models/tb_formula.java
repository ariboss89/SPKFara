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
public class tb_formula {
    private int Id;
    private String idRiwayat;
    private String kode;
    private String gejala;
    private String hasil;
    private String kodePenyebab;
    private static String riwayatId;

    public static String getRiwayatId() {
        return riwayatId;
    }

    public static void setRiwayatId(String riwayatId) {
        tb_formula.riwayatId = riwayatId;
    }

    public String getKodePenyebab() {
        return kodePenyebab;
    }

    public void setKodePenyebab(String kodePenyebab) {
        this.kodePenyebab = kodePenyebab;
    }
    
    public String getHasil() {
        return hasil;
    }

    public void setHasil(String hasil) {
        this.hasil = hasil;
    }
    
    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getIdRiwayat() {
        return idRiwayat;
    }

    public void setIdRiwayat(String idRiwayat) {
        this.idRiwayat = idRiwayat;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getGejala() {
        return gejala;
    }

    public void setGejala(String gejala) {
        this.gejala = gejala;
    }
}
