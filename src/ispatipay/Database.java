/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ispatipay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author deuterium2h
 */
public class Database {

    /**
     * A static connection variable.
     */
    static Connection conn = null;

    /**
     * A static String variable for database name.
     */
    static String db = "";

    /**
     * A static String array for database parameters.
     */
    static String[] options = {"",""};

    /**
     * A method that will get the current database name.
     * 
     * @return Database name
     */
    public static String getDatabase() {
        return db;
    }

    /**
     * A method that will get the current connection instance.
     * 
     * @return Returns the connection instance if defined. Else set a new connection instance.
     */
    public static Connection getConnection() {
        return ( conn != null ) ? conn : getConnection(db, options);
    }

    /**
     * A method that will set the database name and username/path, and password.
     * This will also set the static variables.
     * 
     * @param database Variable that contains the database used.
     * @param params   Array that contains either path or username, and password.
     * @return         Returns the connection string used to initiate a database connection.
     */
    public static Connection getConnection( String database, String[] params ) {

        db = database;
        options = params;

        try {

            if ((database.toLowerCase()).equals("oracle")) {

                Class.forName("oracle.jdbc.driver.OracleDriver");
                conn = DriverManager.getConnection(
                        "jdbc:oracle:thin:@con02:1521:old1", params[0], params[1]); // old1 -> ispatipay
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

            return conn;
        }
        catch ( SQLException e ) {
            System.err.println(e.getMessage());
        }
        catch ( NullPointerException e ) {
            System.err.println("npe sa database class");
        }
        catch ( ClassNotFoundException e ) {
            System.err.println("cnf exception sa database class");
        }
        catch ( InstantiationException e ) {
            System.err.println("instantiation exception sa database class");
        }
        catch ( IllegalAccessException e ) {
            System.err.println("iae exception sa database class");
        }

        return null;
    }
}
