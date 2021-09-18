/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.sql.*;

/**
 *
 * @author Joe
 */
public class ClsConexion {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/dbcomisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
    private static final String JDBC_USER = "root";
    private static final String JDB_PWD = "root";

    //CREAR EL METODO DE CONEXION
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDB_PWD);
    }

    public static void close(ResultSet rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(PreparedStatement rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public static void close(Connection rs) {
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
