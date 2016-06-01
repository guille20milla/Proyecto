/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Alumno
 */
public class Venta {
    private int id_equipo;
    private int id_venta;
    private Date fecha;
    
    public Venta(int i,Date fecha){
        this.id_equipo=i;
        this.fecha=fecha;
    }

    /**
     * @return the id_entrada
     */
    public int getId_equipo() {
        return id_equipo;
    }

    /**
     * @param id_entrada the id_entrada to set
     */
    public void setId_entrada(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    /**
     * @return the id_venta
     */
    public int getId_venta() {
        return id_venta;
    }

    /**
     * @param id_venta the id_venta to set
     */
    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }
    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }
}
