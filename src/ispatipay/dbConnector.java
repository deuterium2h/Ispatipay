/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ispatipay;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DANEM682
 */
public class dbConnector {

    public static Connection connectTo(String database, String[] params){

        try {

            Connection conn = null;

            if ((database.toLowerCase()).equals("oracle")) {

                Class.forName("oracle.jdbc.driver.OracleDriver"); //.newInstance();
                conn = DriverManager.getConnection(
                        "jdbc:oracle:thin:@con02:1521:old1", params[0], params[1]);
            }
            else if ((database.toLowerCase()).equals("mysql")) {
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/isatipay", params[0], params[1]);
            }
            else if ((database.toLowerCase()).equals("sqlite")) {
                Class.forName("org.sqlite.JDBC");
                params[0] = params[0].replace("\\", "/");
                conn = DriverManager.getConnection("jdbc:sqlite:" + params[0]);
            }

            System.out.println("Connected to " + database + " Database!");
            return conn;
        }
        catch (Exception e) {
            System.err.println("Cannot connect to " + database + " Database..");
        }

        return null;
    }
}
