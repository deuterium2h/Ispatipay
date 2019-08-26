/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ispatipay;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import static ispatipay.res.EncryptDecryptStringWithDES.decrypt;
import static ispatipay.res.EncryptDecryptStringWithDES.encrypt;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Base64;
import java.util.Properties;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import net.proteanit.sql.DbUtils;


/**
 *
 * @author deuterium2h
 */
public class Helper {

    static String propertiesFile = "src/ispatipay/res/ispatipay.properties"; // Change value when in production

    // Variables required for encrypting/decrypting text
    static Cipher ecipher;
    static Cipher dcipher;
    static String cipherAlgo;
    static SecretKey key;

    /**
     * Generates a salt that will be used in generating hash.
     * 
     * @param text A string that will be used to generate a salt for hash generation.
     * @return     Returns a salt used in generating hash.
     */
    public static String generateSalt( String text ) {

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
     * @return     Returns a string generated hash from the String received.
     */
    public static String generateHash( String text ) {

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
     * @param title   A String that was passed as the title for the MessageDialog. 
     * @param icon    Integer that was passed.<br>
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
     * @param rs  ResultSet instance that was passed.
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
     * @return          Returns true if the JTextField is blank. Else false.
     */
    public static boolean isTextFieldBlank( javax.swing.JTextField textField ) {
        return ( textField.getText().length() == 0 );
    }

    /**
     * 
     * @param jtable Pass the JTable to be updated.
     * @param conn   Connection instance
     * @param table  Pass the table that the JTable will use as a model.
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
     * @param conn   Connection instance.
     * @param params An array that contains field values that will be logged in activity_log table.
     *  params[0] = Username.<BR>
     *  params[1] = Action Performed. (Add, Update, Delete, Logged in, Logged out)<BR>
     *  params[2] = Affected Table.<BR>
     *  params[3] = Affected Table item.
     */
    public static void logActivity( Connection conn, String[] params ) {

        String sql = "INSERT INTO activity_log ( user, action, affected_table, affected_table_item, logged_at ) "
                   + "VALUES (?, ?, ?, ?, ?)";

        String currTime = Helper.getTimestamp();
        PreparedStatement pst = null;
        ResultSet rs = null;    

        try {

            // Prepares the statement using the current Connection
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

    /**
     * Gets the property value of the specified key.
     * 
     * @param key Refer to ispatipay.properties file for the list of valid keys
     * @return    Returns the value in the 'key-value' pair
     */
    public static String getProperty( String key ) {

        String value = null;

        try {

            // Initialize a Properties() instance
            Properties p = new Properties();

            // Load the .properties file
            FileInputStream ip = new FileInputStream(propertiesFile);
            p.load(ip);

            // Store the value of the property specified in 'value' variable
            value = p.getProperty(key);
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }

        return value;
    }

    /**
     * Sets the property of the specified key-value pair
     * 
     * @param key   The 'name' of the property desired
     * @param value Any value passed here should be a string
     */
    public static void setProperty ( String key, String value ) {

        // Initialize the FileOutputStream here to be closed later.
        FileOutputStream outFile = null;

        try {

            // Initialize a Properties() instance
            Properties prop = new Properties();

            // Open the .properties file
            File file = new File(propertiesFile);
            FileInputStream inFile = new FileInputStream(file);

            // Load .properties file that will be written/modified
            prop.load(inFile);

            // Write/modify the current property mentioned
            value = value.replace("\\", "/");
            prop.setProperty(key, value);

            // Stores the property in the .properties file
            outFile = new FileOutputStream(file);
            prop.store(outFile, "Ispatipay Properties");
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        finally {

            // Always close the file after modifying to prevent errors
            try {
                outFile.close();
            }
            catch ( Exception e ) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static String encryptStr( String str ) {

        byte[] enc = null;

        try {

            // Encode the string into a sequence of bytes using the named charset
            // Storing the result into a new byte array. 
            byte[] utf8 = str.getBytes("UTF8");
            enc = ecipher.doFinal(utf8);

            // Encode to Base64
            enc = BASE64EncoderStream.encode(enc);
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }

        return new String(enc);
    }

    public static String decryptStr( String str ) {

        byte[] utf8 = null;

        try {

            // Decode with base64 to get bytes
            byte[] dec = BASE64DecoderStream.decode(str.getBytes());
            utf8 = dcipher.doFinal(dec);
            return new String(utf8, "UTF8");
        }
        catch ( IllegalBlockSizeException e ) {
            System.err.println("IBSE at Helper class");
        }
        catch ( BadPaddingException e ) {
            System.err.println("BPE at Helper class");
        }
        catch ( UnsupportedEncodingException e ) {
            System.err.println("UEE at Helper class");
        }

        // Create new string based on the specified charset
        return null;
    }

    public static void setCipher() {

        try {
            ecipher = Cipher.getInstance(cipherAlgo);
            dcipher = Cipher.getInstance(cipherAlgo);
            ecipher.init(Cipher.ENCRYPT_MODE, key);
            dcipher.init(Cipher.DECRYPT_MODE, key);
        }
        catch ( NoSuchAlgorithmException e ) {
            
        }
        catch ( NoSuchPaddingException e ) {
            
        }
        catch ( InvalidKeyException e ) {
            
        }
    }

    public static String getCipher() {

        String str = "";
        return str;
    }

    public static void setKey( String str, String cipher ) {

        // Set the key currently stored in .properties file
        byte[] origKey = Base64.getDecoder().decode(str);
        key = new SecretKeySpec(origKey, 0, origKey.length, cipher);
        cipherAlgo = cipher;
    }

    public static void setKeyCipher( String strKey, String cipher ) {
        
        byte[] origKey = Base64.getDecoder().decode(strKey);
        key = new SecretKeySpec(origKey, 0, origKey.length, cipher);
        SecretKey locKey = new SecretKeySpec(origKey, 0, origKey.length, cipher);

        try {
            cipherAlgo = cipher;
            ecipher = Cipher.getInstance(cipher);
            dcipher = Cipher.getInstance(cipher);
            ecipher.init(Cipher.ENCRYPT_MODE, locKey);
            dcipher.init(Cipher.DECRYPT_MODE, locKey);
        }
        catch ( NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException e ) {
            
        }
    }

    public static String getKey( String str ) {

        // Returns the currently used key
        String[] strArr = str.split("~");
        return strArr[1];
    }

    public static String getPassword( String str ) {

        String[] strArr = str.split("~");
        String pass = Helper.decryptStr(strArr[0]);
        return pass;
    }
    public static String generateKey( String cipher ) {

        String strKey = null;

        try {
            SecretKey genKey = KeyGenerator.getInstance(cipher).generateKey();
            strKey = Base64.getEncoder().encodeToString(genKey.getEncoded());
        }
        catch ( NoSuchAlgorithmException e ) {
            e.printStackTrace();
        }

        return strKey;
    }
}
