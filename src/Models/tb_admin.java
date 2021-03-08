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
public class tb_admin {
    public static String username;
    public static String password;
    public static String Id;
    public static String nama;
    public static String role;

    public static String getRole() {
        return role;
    }

    public static void setRole(String role) {
        tb_admin.role = role;
    }

    public static String getId() {
        return Id;
    }

    public static void setId(String Id) {
        tb_admin.Id = Id;
    }

    public static String getNama() {
        return nama;
    }

    public static void setNama(String nama) {
        tb_admin.nama = nama;
    }
    
    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        tb_admin.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        tb_admin.password = password;
    }
    
}
