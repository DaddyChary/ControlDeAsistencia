/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DaddyChary
 */
public class Conexion {

    private Connection conn;
    private Statement sen;
    private static Conexion conexion = null;

    private Conexion(String db) throws SQLException {
        String url = "jdbc:mysql://localhost/" + db + "?user=root&password=";
        conn = DriverManager.getConnection(url);
    }

    public ResultSet execute(String query) throws SQLException {
        sen = conn.createStatement();
        if (query.toLowerCase().startsWith("insert")
                || query.toLowerCase().startsWith("update")
                || query.toLowerCase().startsWith("delete")) {
            sen.executeUpdate(query);
            close();
            return null;
        } else {
            ResultSet rs = sen.executeQuery(query);
            return rs;
        }
    }

    public static Conexion getConexion() throws SQLException {
        if (conexion == null) {
            conexion = new Conexion("control_de_asistencia");
        }
        return conexion;
    }

    public void close() throws SQLException {
        sen.close();
    }

}
