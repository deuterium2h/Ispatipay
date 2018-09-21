/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ispatipay;

import java.security.MessageDigest;
import java.sql.*;

/**
 *
 * @author DANEM682
 */
public class Ispatipay {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    String[] credentials = {"username/path","password"};

    public Ispatipay() {
        conn = dbConnector.connectTo("Oracle", credentials);
        System.out.println(System.getProperty("user.name"));
    }

    private void getSomeInfo(String bgroup) {
        String sql = "SELECT * FROM pensioner_detail WHERE bgroup = ? AND rownum = '1'";
        
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, bgroup);
            rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println(rs.getString("REFNO") + " " + rs.getDate("PN01D"));
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static String encryptPassword(String password) {

        String encryptedPassword = null;

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();

            for ( int i = 0; i < bytes.length; i ++ ) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            encryptedPassword = sb.toString();
            return encryptedPassword;
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ispatipay isptpy = new Ispatipay();
        isptpy.getSomeInfo("XOM");
        String encrypted = Ispatipay.encryptPassword("password");//"";

        if (encrypted.equals("5f4dcc3b5aa765d61d8327deb882cf99")) {
            System.out.println("Correct!!");
        }
        else {
            System.err.println("SAD!");
        }
    }
    
}
