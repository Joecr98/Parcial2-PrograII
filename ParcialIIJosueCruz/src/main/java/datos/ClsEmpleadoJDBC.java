/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.ClsEmpleado;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Joe
 */
public class ClsEmpleadoJDBC {

    private static final String SQL_SELECT = "select * from tbempleados";
    private static final String SQL_INSERT = "insert into tbempleados(empleado,enero,febrero,marzo) values (?,?,?,?)";
    private static final String SQL_UPDATE = "update tbempleados set empleado = ?,enero=?,febrero=?,marzo=? where idEmple=?";
    private static final String SQL_DELETE = "delete from tbempleados where idEmple=?";
    private static final String SQL_MAX = "select * from tbempleados where idEmple = (select MAX(idEmple) from tbempleados)";
   // private static final String SQL_BYID = "select * from tbempleados where idEmple = ";

    //seleccionar información
    public List<ClsEmpleado> seleccion() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ClsEmpleado emple = null;
        List<ClsEmpleado> emples = new ArrayList<ClsEmpleado>();

        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idEmple = rs.getInt("idEmple");
                String empleado = rs.getString("empleado");
                int enero = rs.getInt("enero");
                int febrero = rs.getInt("febrero");
                int marzo = rs.getInt("marzo");
                emple = new ClsEmpleado();
                emple.setIdemple(idEmple);
                emple.setEmpleado(empleado);
                emple.setEnero(enero);
                emple.setFebrero(febrero);
                emple.setMarzo(marzo);
                emples.add(emple);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);

        }
        return emples;
    }

    public ClsEmpleado obtenerUltimo() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ClsEmpleado emple = new ClsEmpleado();

        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_MAX);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idEmple = rs.getInt("idEmple");
                String empleado = rs.getString("empleado");
                int enero = rs.getInt("enero");
                int febrero = rs.getInt("febrero");
                int marzo = rs.getInt("marzo");
                emple = new ClsEmpleado();
                emple.setIdemple(idEmple);
                emple.setEmpleado(empleado);
                emple.setEnero(enero);
                emple.setFebrero(febrero);
                emple.setMarzo(marzo);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);

        }
        return emple;
    }

    public int insert(ClsEmpleado emple) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, emple.getEmpleado());
            stmt.setInt(2, emple.getEnero());
            stmt.setInt(3, emple.getFebrero());
            stmt.setInt(4, emple.getMarzo());

            System.out.println("ejecutando query:" + SQL_INSERT);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }

        return rows;
    }

    public int editar(ClsEmpleado emple) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);

            stmt.setString(1, emple.getEmpleado());
            stmt.setInt(2, emple.getEnero());
            stmt.setInt(3, emple.getFebrero());
            stmt.setInt(4, emple.getMarzo());
            stmt.setInt(5, emple.getIdemple());

            System.out.println("ejecutando query:" + SQL_UPDATE);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }

        return rows;
    }

    public int borrar(int idEmple) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);

            stmt.setInt(1, idEmple);

            System.out.println("ejecutando query:" + SQL_DELETE);
            rows = stmt.executeUpdate();
            System.out.println("Registros afectados:" + rows);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }

        return rows;
    }
}
