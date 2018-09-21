/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ispatipay;

import java.nio.charset.StandardCharsets;
import java.security.*;

/**
 *
 * @author DANEM682
 */
public class Hash {

    public static String generateHash (String passwordToHash, String salt) {

        String generatedPassword = null;
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchProviderException {
        String passwordToHash = "nowerd";

        String securePassword = generateHash(passwordToHash, "azin");
        System.out.println(securePassword); //Prints 83ee5baeea20b6c21635e4ea67847f66

        String regeneratedPassowrdToVerify = generateHash(passwordToHash, "azsin");
        System.out.println(regeneratedPassowrdToVerify); //Prints 83ee5baeea20b6c21635e4ea67847f66
    }
}
