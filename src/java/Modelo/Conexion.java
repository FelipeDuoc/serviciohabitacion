/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Felipe
 */
public class Conexion {
    private static final Logger logger = Logger.getLogger(Conexion.class.getName());
    private Connection con;
    private static String url;
    private static String user;
    private static String pass;
    private final String driver = "oracle.jdbc.OracleDriver";
    
    public Conexion() {
    try {
        Class.forName(driver);
    } catch (ClassNotFoundException ex) {
    logger.log(Level.CONFIG, "No se puede cargar el Driver: {0}", ex.getMessage());
    }

    url = "jdbc:oracle:thin:@veranumdb.cijknbcu5koi.us-east-2.rds.amazonaws.com:1521:ORCL"; //nuestra base de datos
    user = "sysdba"; //usuario
    pass = "123456789+"; //contraseña
    try 
    {
        con = DriverManager.getConnection(url, user, pass);
    } catch (SQLException ex) {
    logger.log(Level.CONFIG, "Error al establecer la conexion: {0}", ex.getMessage());
    }
    }
    
    public Connection getCon() {
        return con;
    }
    
    public void desonectarBD() {
        try {
            this.getCon().close();
        } catch (SQLException ee) {
            System.out.println(ee.getMessage());
        }

    }
}
