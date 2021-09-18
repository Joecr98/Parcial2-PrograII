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
public class ClsEmpleado {
    private int idEmple = -1;
    private String empleado = "";
    private int enero = -1;
    private int febrero = -1;
    private int marzo = -1;
    private int total = -1;
    private int promedio = -1;

    @Override
    public String toString() {
        return "ClsEmpleado{" + "idemple=" + idEmple + ", empleado=" + empleado + ", enero=" + enero + ", febrero=" + febrero + ", marzo=" + marzo + ", total=" + total + ", promedio=" + promedio + '}';
    }

    public int getIdemple() {
        return idEmple;
    }

    public void setIdemple(int idemple) {
        this.idEmple = idemple;
    }

    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }

    public int getEnero() {
        return enero;
    }

    public void setEnero(int enero) {
        this.enero = enero;
    }

    public int getFebrero() {
        return febrero;
    }

    public void setFebrero(int febrero) {
        this.febrero = febrero;
    }

    public int getMarzo() {
        return marzo;
    }

    public void setMarzo(int marzo) {
        this.marzo = marzo;
    }

    public int getTotal() {
        return (this.enero+this.febrero+this.marzo);
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPromedio() {
        return (this.enero+this.febrero+this.marzo)/3;
    }

    public void setPromedio(int promedio) {
        this.promedio = promedio;
    }
    
    public boolean datosMinimosLlenos(){
        boolean empleadoBool = this.empleado.length() > 0;
        boolean eneroBool = this.enero >= 0;
        boolean febreroBool = this.febrero >= 0;
        boolean marzoBool = this.marzo  >= 0;
        return (empleadoBool && eneroBool && febreroBool && marzoBool);
    }
}
