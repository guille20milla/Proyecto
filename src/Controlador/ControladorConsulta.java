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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Guille
 */
public class ControladorConsulta {

    private Vista.InterfazConsulta ic;
    private BaseDeDatos bd = new BaseDeDatos();

    public ControladorConsulta(Vista.InterfazConsulta ic) {
        this.ic = ic;
        this.ic.addCalcularListener(new CalcularListener());

    }

    public class CalcularListener implements ActionListener {

        Object obj;

        public void actionPerformed(ActionEvent ae) {

            comportamiento(ae, obj);
        }

        public void comportamiento(ActionEvent ae, Object obj) {

            obj = ae.getSource();

            if (obj == ic.getAceptar()) {
                Date fecha = ic.getTfecha();
                java.sql.Date f = convertirFecha(fecha);
                Date fecha1 = ic.getTfecha2();
                java.sql.Date f1 = convertirFecha(fecha1);
                int precio = AccesoBase.consultaTotal(f, f1);
                ic.getTprecio().setText(String.valueOf(precio)+" $");
            }else{
                Date fecha = ic.getTfecha3();
                java.sql.Date f = convertirFecha(fecha);
                Date fecha1 = ic.getTfecha4();
                java.sql.Date f1 = convertirFecha(fecha1);
                int id = AccesoBase.obtenerIdEquipo(String.valueOf(ic.getTequipo().getSelectedItem()));
                int precio = AccesoBase.consultaTotalEquipo(id,f, f1);
                ic.getTprecio1().setText(String.valueOf(precio)+" $");
            }

        }

    }
    public java.sql.Date convertirFecha(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }

}
