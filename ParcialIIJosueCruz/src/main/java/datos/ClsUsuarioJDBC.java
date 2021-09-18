/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import dominio.ClsUsuario;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Joe
 */
public class ClsUsuarioJDBC {
    
    private static final String SQL_SELECT = "select * from tbusuarios";
    private static final String SQL_UPDATE = "update tbusuarios set username= ?,password=? where idusuario=?";
    private static final String SQL_INSERT = "insert into tbusuarios(username,password) values (?,?)";
    private static final String SQL_DELETE = "delete from tbusuarios where idusuario=?";

    public List<ClsUsuario> select() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ClsUsuario usuario = null;
        List<ClsUsuario> usuarios = new ArrayList<ClsUsuario>();

        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int idusuario = rs.getInt("id_usuario");
                String username = rs.getString("username");
                String password = rs.getString("password");

                usuario = new ClsUsuario();
                usuario.setUsername(username);
                usuario.setPassword(password);
                usuario.setIdusuario(idusuario);

                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return usuarios;
    }

    public boolean select_validacion(ClsUsuario datos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ClsUsuario usuario = new ClsUsuario();
        boolean tiene_permiso = false;

        try {
            String condicion = SQL_SELECT + " where username='" + datos.getUsername()+ "' and password ='" + datos.getPassword() + "'";
            
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(condicion);
            rs = stmt.executeQuery();
            System.out.println("condicion = " + condicion);
            
            while (rs.next()) {
                tiene_permiso = true;
                int idusuario = rs.getInt("idusuario");
                String username = rs.getString("username");
                String password = rs.getString("password");

                usuario = new ClsUsuario();
                usuario.setUsername(username);
                usuario.setPassword(password);
                usuario.setIdusuario(idusuario);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(rs);
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return tiene_permiso;
    }
    
    public int insert(ClsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
       
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            System.out.println("Ejecutando cuerito="+ SQL_INSERT);
            
            rows = stmt.executeUpdate();
            System.out.println("Se procesaron "+ rows);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return rows;
    }

    public int actualizar(ClsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
       
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsername());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getIdusuario());
            System.out.println("Ejecutando cuerito="+ SQL_UPDATE);
            
            rows = stmt.executeUpdate();
            System.out.println("Se procesaron "+ rows);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return rows;
    }
    
    public int borrar(ClsUsuario usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
       
        try {
            conn = ClsConexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdusuario());
            System.out.println("Ejecutando cuerito="+ SQL_DELETE);
            
            rows = stmt.executeUpdate();
            System.out.println("Se procesaron "+ rows);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            ClsConexion.close(stmt);
            ClsConexion.close(conn);
        }
        return rows;
    }
    
}//FIN CLASE
