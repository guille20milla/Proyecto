/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Alumno
 */
public class ControladorI1 {

    private Vista.Interfaz1 i1;
    private BaseDeDatos bd = new BaseDeDatos();

    public ControladorI1(Vista.Interfaz1 i1) {
        this.i1 = i1;
        this.i1.addCalcularListener(new CalcularListener());

    }

    public class CalcularListener implements ActionListener {

        Object o;

        public void actionPerformed(ActionEvent ae) {

            comportamiento(ae, o);
        }

        public void comportamiento(ActionEvent ae, Object obj) {

            obj = ae.getSource();

            if (obj == i1.getBotonConectar()) {
                String pass = new String(i1.getTcontrasenia().getPassword());
                String cat;
                cat = AccesoBase.obtenerCategoria(i1.getTnombre().getText(), pass);
                if (cat.contentEquals("Presidente")) {
                    Interfaz3 i3 = new Interfaz3();
                    ControladorI3 ci3 = new ControladorI3(i3);
                } else if (cat.contentEquals("Director Comercial")) {
                    Interfaz4 i4 = new Interfaz4();
                    ControladorI4 ci4 = new ControladorI4(i4);
                } else {
                    JOptionPane.showMessageDialog(i1.getFrame(), "El usuario o la contraseña no existen", "Error identificacion", JOptionPane.ERROR_MESSAGE);
                }
                i1.getTnombre().setText("");
                i1.getTcontrasenia().setText("");
            } else {
                if (obj == i1.getBotonRegistrar()) {
                    Interfaz2 i2 = new Interfaz2();
                    ControladorI2 ci2 = new ControladorI2(i2);
                }
            }

        }
    }
}
