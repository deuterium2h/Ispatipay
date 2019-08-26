/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ispatipay.res;

import com.sun.mail.util.BASE64DecoderStream;
import com.sun.mail.util.BASE64EncoderStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64; 
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author DANEM682
 */
public class EncryptDecryptStringWithDES {

    private static Cipher ecipher;
    private static Cipher dcipher;

    private static SecretKey key;

    public static void main( String[] args ) {

        try {

            // create new key
            SecretKey secretKey = KeyGenerator.getInstance("DES").generateKey();

            // get base64 encoded version of the key
            String encodedKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());

            
            // decode the base64 encoded string
            byte[] decodedKey = Base64.getDecoder().decode(encodedKey);

            // rebuild key using SecretKeySpec
            SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "DES");

            // Generate secret key using DES algorithm
            key = KeyGenerator.getInstance("DES").generateKey();
            String strKey = Base64.getEncoder().encodeToString(key.getEncoded());
            System.err.println("Key to String: " + strKey);
            byte[] origKey = Base64.getDecoder().decode(strKey);
            SecretKey properKey = new SecretKeySpec(origKey, 0, origKey.length, "DES");
            System.err.println("String to Key: " + properKey.toString());

            ecipher = Cipher.getInstance("DES");
            dcipher = Cipher.getInstance("DES");

            // initialize the ciphers with the given key
            ecipher.init(Cipher.ENCRYPT_MODE, key);

            dcipher.init(Cipher.DECRYPT_MODE, key);
            String encrypted = encrypt("This is a classified message!");
            String decrypted = decrypt(encrypted);
            // com.sun.crypto.provider.DESKey@18689
            // B2AgK0FHu2Yg1E6ZAkTGJjaWnwSptGd91mCyLcNvQnw=
            String[] keyArr = key.toString().split("@");
            
            System.out.println("Key: " + key + "\nProper key: " + keyArr[1]);
            System.out.println("Encrypted: " + encrypted);
            System.out.println("Decrypted: " + decrypted);
        }
        catch ( NoSuchAlgorithmException e ) {

            System.out.println("No Such Algorithm:" + e.getMessage());
            return;
        }
        catch ( NoSuchPaddingException e ) {

            System.out.println("No Such Padding:" + e.getMessage());
            return;
        }
        catch ( InvalidKeyException e ) {

            System.out.println("Invalid Key:" + e.getMessage());
            return;
        }

    }

    public static String encrypt( String str ) {

        try {

            // encode the string into a sequence of bytes using the named charset
            // storing the result into a new byte array. 
            byte[] utf8 = str.getBytes("UTF8");
            byte[] enc = ecipher.doFinal(utf8);

            // encode to base64
            enc = BASE64EncoderStream.encode(enc);
            return new String(enc);
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }

        return null;
    }

    public static String decrypt( String str ) {

        try {

            // decode with base64 to get bytes
            byte[] dec = BASE64DecoderStream.decode(str.getBytes());
            byte[] utf8 = dcipher.doFinal(dec);

            // create new string based on the specified charset
            return new String(utf8, "UTF8");
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }

        return null;
    }
}
