/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Joe
 */
public class ClsUsuario {

    private int idusuario;
    private String username;
    private String password;

    public ClsUsuario() {

    }

    public ClsUsuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public ClsUsuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public ClsUsuario(int id_usuario, String username, String password) {
        this.idusuario = idusuario;
        this.username = username;
        this.password = password;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id_usuario=" + idusuario + ", username=" + username + ", password=" + password + '}';
    }

    public boolean datosMinimosLlenos() {
        boolean usernameBool = this.username.length() > 0;
        boolean passwordBool = this.password.length() > 0;
        return (usernameBool && passwordBool);
    }
}
