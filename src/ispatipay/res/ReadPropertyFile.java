/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ispatipay.res;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;

/**
 *
 * @author DANEM682
 */

public class ReadPropertyFile {

    public static void main( String[] args ) {

        FileOutputStream outFile = null;

        try {
            Properties prop = new Properties();
            File file = new File("src/ispatipay/res/ispatipay.properties");
            FileInputStream inFile = new FileInputStream(file);
            prop.load(inFile);
            prop.setProperty("database", "oracle");
            prop.setProperty("username", "ora1");
            prop.setProperty("password", "ora2");
            prop.setProperty("path", "sds");
            outFile = new FileOutputStream(file);
            prop.store(outFile, "ispatipay config");
            String dbPath = prop.getProperty("database");
            System.out.println(dbPath);
            
//            BufferedReader br = new BufferedReader(new FileReader(dbPath));
//            String line = null;
//            while ( (line = br.readLine()) != null ) {
//                System.out.println(line);
//            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                outFile.close();
            }
            catch ( Exception e ) {
                System.err.println(e.getMessage());
            }
        }
    }
}
