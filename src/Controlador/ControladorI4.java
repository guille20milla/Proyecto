/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumno
 */
public class ControladorI4 {

    private Vista.Interfaz4 i4;
    private BaseDeDatos bd = new BaseDeDatos();

    public ControladorI4(Vista.Interfaz4 i4) {
        this.i4 = i4;
        this.i4.addCalcularListener(new CalcularListener());

    }

    public class CalcularListener implements ActionListener {

        Object obj;

        public void actionPerformed(ActionEvent ae) {

            comportamiento(ae, obj);
        }

        public void comportamiento(ActionEvent ae, Object obj) {

            obj = ae.getSource();

            if (obj == i4.getSeleccionEquipo()) {
                String nom = String.valueOf(i4.getTnombreEquipo().getSelectedItem());
                int precio = AccesoBase.obtenerPrecio(nom);
                i4.getTprecio().setText(String.valueOf(precio) + " $");
            } else {
                if (!comprobarSeleccion()) {
                    JOptionPane.showMessageDialog(i4.getFrame(), "Debe seleccionar un equipo", "Error venta", JOptionPane.ERROR_MESSAGE);
                } else {
                    Date fecha = i4.getTfecha();
                    java.sql.Date fecha1 = convertirFecha(fecha);
                    int id = AccesoBase.obtenerIdEquipo(String.valueOf(i4.getTnombreEquipo().getSelectedItem()));
                    Venta v = new Venta(id, fecha1);
                    AccesoBase.crearEVenta(v);
                    JOptionPane.showMessageDialog(i4.getFrame(), "Venta almacenada", "Venta", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

    }
    
     public boolean comprobarSeleccion() {
        boolean estado = false;
        String p = i4.getTprecio().getText();
        if (!p.contentEquals("")) {
            estado = true;
        }
        return estado;
    }
    
    public java.sql.Date convertirFecha(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }
}
