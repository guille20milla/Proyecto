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
public class ControladorI2 {

    private Vista.Interfaz2 i2;
    private BaseDeDatos bd = new BaseDeDatos();

    public ControladorI2(Vista.Interfaz2 i2) {
        this.i2 = i2;
        this.i2.addCalcularListener(new CalcularListener());

    }

    public class CalcularListener implements ActionListener {

        Object obj;

        public void actionPerformed(ActionEvent ae) {

            comportamiento(ae, obj);
        }

        public void comportamiento(ActionEvent ae, Object obj) {

            obj = ae.getSource();

            if (obj == i2.getBotonCancelar()) {

            } else {

                String cat = String.valueOf(i2.getTcategoria().getSelectedItem());
                String pass = new String(i2.getTcontrasenia().getPassword());
                Persona persona = new Persona(i2.getTnombre().getText(), i2.getTapellido().getText(), cat, pass);
                AccesoBase.crearPersona(persona, bd);
            }
        }

    }

}
