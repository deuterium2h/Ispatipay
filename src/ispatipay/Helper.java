/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ispatipay;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author deuterium2h
 */
public class Helper {

    /**
     * Generates a salt that will be used in generating hash.
     * 
     * @param text A string that will be used to generate a salt for hash generation.
     * @return A salt used in generating hash.
     */
    public static String generateSalt ( String text ) {

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
     * @param text The String that will be used to generate the hash.
     * @return A String generated hash from the String received.
     */
    public static String generateHash ( String text ) {

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
        catch ( NoSuchAlgorithmException e ) {
            System.err.println(e);
        }

        return generatedHash;
    }

    /**
     * Simplified method for JOptionPane.showMessageDialog();
     * 
     * @param message A String that was passed as the message of the MessageDialog.
     * @param title A String that was passed as the title for the MessageDialog. 
     * @param icon integer that was passed.<br>
     *  0 = ERROR_MESSAGE<br>
     *  1 = INFORMATION_MESSAGE<br>
     *  2 = WARNING_MESSAGE<br>
     *  3 = QUESTION_MESSAGE<br>
     */
    public static void messageDialog( String message, String title, int icon ) {
        javax.swing.JOptionPane.showMessageDialog(null, message, title, icon);
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
     * @param pst PreparedStatement instance that was passed.
     * @param rs ResultSet instance that was passed.
     */
    public static void closeIfSqlite( PreparedStatement pst, ResultSet rs ) {

        try {
            if (Database.getDatabase().toLowerCase().equals("sqlite")) {
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            }
        }
        catch ( SQLException e ) {
            System.err.println(e);
        }
    }

    /**
     * A method that will check the length of JTextField passed.
     * 
     * @param textField JTextField object that was passed.
     * @return Returns true if the JTextField is blank. Else false.
     */
    public static boolean isTextFieldBlank( javax.swing.JTextField textField ) {
        return ( textField.getText().length() == 0 );
    }

    /**
     * 
     * @param jtable Pass the JTable to be updated.
     * @param conn Connection instance
     * @param table Pass the table that the JTable will use as a model.
     */
    public static void loadTable( javax.swing.JTable jtable, Connection conn, String table ) {

        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = ("select * from " + table).toUpperCase();

        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jtable.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch ( SQLException e ) {
                System.err.println(e);
        }
        finally {

            try {
                rs.close();
                pst.close();
            }
            catch (SQLException e) {
                System.err.println(e);
            }
        }
    }

    /**
     * Logs the activity performed to activity_log.<BR>
     * 
     * @param conn Connection instance.
     * @param params An array that contains field values that will be logged in activity_log table.
     *  params[0] = Username.<BR>
     *  params[1] = Action Performed (Add, Update, Delete, Logged in, Logged out).<BR>
     *  params[2] = Affected Table.<BR>
     *  params[3] = Affected Table item.
     */
    public static void logActivity ( Connection conn, String[] params ) {

        String sql = "INSERT INTO activity_log ( user, action, affected_table, affected_table_item, logged_at ) "
                   + "VALUES (?, ?, ?, ?, ?)";

        String currTime = Helper.getTimestamp();
        PreparedStatement pst = null;
        ResultSet rs = null;    

        try {

            pst = conn.prepareStatement(sql);

            // Loops through params[] items to populate fields
            for ( int i = 0; i < params.length; i++ ) {
                int j = i + 1;
                pst.setString(j, params[i]);
            }

            pst.setString(5, currTime);
            pst.execute();
        }
        catch ( SQLException e ) {
            e.printStackTrace();
        }
        catch ( NullPointerException e ) {
            e.printStackTrace();
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        finally {
            Helper.closeIfSqlite(pst, rs);
        }
    }
}
