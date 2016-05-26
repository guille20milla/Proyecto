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

/**
 *
 * @author Alumno
 */
public class ControladorI1 {

    private Vista.Interfaz1 i1;
    private Vista.Interfaz2 i2;

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
                //llamamos a la consulta que nos devuelve la persona con ese nombre y contraseña
                String nombre = i1.getTnombre().getText();
                String contrasenia = i1.getTcontrasenia().getSelectedText();

            } else {
                if (obj == i1.getBotonRegistrar()) {
                    Interfaz2 i2 = new Interfaz2();
                    ControladorI2 ci2 = new ControladorI2(i2);
                }
            }

        }
    }
}
