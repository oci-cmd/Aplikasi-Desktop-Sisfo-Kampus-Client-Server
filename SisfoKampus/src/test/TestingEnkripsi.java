/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import tools.AeSimpleMD5;
import tools.SHAHashing;

/**
 *
 * @author Rosidin
 */
public class TestingEnkripsi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //enkripsiMD5("coba");  // c3ec0f7b054e729c5a716c8125839829
        
        // 132e80d3caf4e1327ff9ad906aa5084ebdc5e625088b9133fcef2e38a58206cc
        //enkripsiSHA("coba");
        System.out.println(textMD5("coba"));
    }
    
    private static String textMD5(String text) {
        text = AeSimpleMD5.MD5(text);  // enkrip 1
        text = AeSimpleMD5.MD5(text);  // enkrip 2
        text = AeSimpleMD5.MD5(text);  // enkrip 3
        return text;
    }
    
    private static void enkripsiMD5(String text) {
        text = AeSimpleMD5.MD5(text);
        System.out.println(text);
    }
    
    private static void enkripsiSHA(String text) {
        text = SHAHashing.convertToHex1(text);
        System.out.println(text);
    }
    
}
