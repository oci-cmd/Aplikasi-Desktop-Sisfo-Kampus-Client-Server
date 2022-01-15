/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rosidin
 */
public class SHAHashing {
    // Cara pertama
    public static String convertToHex1(String password) {        
        StringBuilder sb = new StringBuilder();
        try {
            // kalau mau ubah ke SHA-384 atau 512 ganti aja angkanya
            MessageDigest md = MessageDigest.getInstance("SHA-256");  
            md.update(password.getBytes());
            byte byteData[] = md.digest();                        
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SHAHashing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }
    // Cara kedua
    public static String convertToHex2(String password) {
        StringBuilder sb = new StringBuilder();
        try {
            // kalau mau ubah ke SHA-384 atau 512 ganti aja angkanya
            MessageDigest md = MessageDigest.getInstance("SHA-256"); 
            md.update(password.getBytes());
            byte byteData[] = md.digest();
            for (int i=0;i<byteData.length;i++) {
                String hex=Integer.toHexString(0xff & byteData[i]);
                if(hex.length()==1) sb.append('0');
                sb.append(hex);
            }            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SHAHashing.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sb.toString();
    }
}


