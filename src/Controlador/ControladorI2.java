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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

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
                vaciar();
            } else {
                if (!datosRellenos()) {
                    JOptionPane.showMessageDialog(i2.getFrame(), "Faltan por meter datos", "Error insertar", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (!contraseñaCorrecta()) {
                        JOptionPane.showMessageDialog(i2.getFrame(), "La contraseña no es correcta,deberá empezar por una o "
                                + "varias mayúsculas, dos minúsculas, 0 o más caracteres alfanuméricos, 2 o más"
                                + " dígitos y terminar con el símbolo del dólar.Además por lo menos debe tener 8 caracteres.", "Error contraseña", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (!comprobarContraseñas()) {
                            JOptionPane.showMessageDialog(i2.getFrame(), "Las contraseñas no coinciden", "Error contraseñas", JOptionPane.ERROR_MESSAGE);
                        } else {
                            String cat = String.valueOf(i2.getTcategoria().getSelectedItem());
                            String pass = new String(i2.getTcontrasenia().getPassword());
                            Persona persona = new Persona(i2.getTnombre().getText(), i2.getTapellido().getText(), cat, pass);
                            AccesoBase.crearPersona(persona, bd);
                            JOptionPane.showMessageDialog(i2.getFrame(), "Persona insertada", "Insertado", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                }
            }
        }

    }

    public boolean datosRellenos() {
        boolean estado = false;
        String nombre, apellido, categoria, c1, c2;
        nombre = i2.getTnombre().getText();
        apellido = i2.getTapellido().getText();
        categoria = String.valueOf(i2.getTcategoria().getSelectedItem());
        c1 = new String(i2.getTcontrasenia().getPassword());
        c2 = new String(i2.getTcontrasenia2().getPassword());
        if (nombre.contentEquals("") | apellido.contentEquals("") | categoria.contentEquals("") | c1.contentEquals("") | c2.contentEquals("")) {
            estado = false;
        } else {
            estado = true;
        }
        return estado;
    }

    public void vaciar() {
        i2.getTnombre().setText("");
        i2.getTapellido().setText("");
        i2.getTcontrasenia().setText("");
        i2.getTcontrasenia2().setText("");
    }

    public boolean comprobarContraseñas() {
        boolean estado = false;
        String c1, c2;
        c1 = new String(i2.getTcontrasenia().getPassword());
        c2 = new String(i2.getTcontrasenia2().getPassword());
        if (c1.contentEquals(c2)) {
            estado = true;
        }
        return estado;
    }

    public boolean contraseñaCorrecta() {
        boolean estado = false;
        String p = "[A-Z]+[a-z]{2}\\w*\\d{2,}\\$";
        String c1;
        c1 = new String(i2.getTcontrasenia().getPassword());
        Pattern p1 = Pattern.compile(p);
        Matcher m = p1.matcher(c1);
        if (m.matches() && c1.length()>7) {
            estado = true;
        }
        return estado;
    }

}
