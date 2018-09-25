/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ispatipay;

import java.security.*;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Timestamp;

/**
 *
 * @author DANEM682
 */
public class Helper {

    /**
     * Generates a salt that will be used in generating hash.
     * 
     * @param String text
     * @return A salt used in generating hash.
     */
    public static String generateSalt (String text) {

        String salt = "";
        char median;
        int position;
        int length;

        if ( text.length() % 2 == 0 ) {

            position = text.length() / 2 - 1;
            length = 2;
        }
        else {
            position = text.length() / 2;
            length = 1;
        }

        median = (text.substring(position, position + length)).charAt(0);

        int ascii = median;
        String t = text.substring(0, 4) + Integer.toString(ascii) + text.substring(text.length() - 1);

        StringBuilder sb = new StringBuilder(t);
        salt = sb.reverse().toString();

        return salt.substring(0, 8);
    }

    /**
     * Generates a hash of the text.
     * 
     * @param String text
     * @return A String generated hash from the String received.
     */
    public static String generateHash (String text) {

        String generatedHash = null;
        String salt = generateSalt(text);
        
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(text.getBytes());
            StringBuilder sb = new StringBuilder();

            for ( int i = 0; i < bytes.length; i++ ) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            generatedHash = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            System.err.println(e);
        }

        return generatedHash;
    }

    /**
     * Simplified method for JOptionPane.showMessageDialog();
     * 
     * @param String message
     * @param String title
     * @param int icon
     *  0 = QUESTION_MESSAGE
     *  1 = INFORMATION_MESSAGE
     *  2 = WARNING_MESSAGE
     *  4 = ERROR_MESSAGE
     */
    public static void messageDialog(String message, String title, int icon) {
        JOptionPane.showMessageDialog(null, message, title, icon);
    }

    /**
     * Returns a string of the current date/time (timestamp).
     * 
     * @return Timestamp in String format.
     */
    public static String getTimestamp() {

        Timestamp ts = new Timestamp((new java.util.Date()).getTime());
        return ts.toString();
    }

    /**
     * Closes the PreparedStatement, and ResultSet Instance if the database is SQLite.
     * 
     * @param PreparedStatement pst
     * @param ResultSet rs
     * @throws SQLException Throws SQLException if both are not Instantiated/Defined.
     */
    public static void closeIfSqlite(java.sql.PreparedStatement pst, java.sql.ResultSet rs) throws SQLException {

        if ( Database.getDatabase().toLowerCase().equals("sqlite") ) {
            if ( pst != null ) pst.close();
            if ( rs != null ) rs.close();
        }
    }
}
