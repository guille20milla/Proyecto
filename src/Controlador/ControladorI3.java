/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AccesoBase;
import Modelo.BaseDeDatos;
import Modelo.Equipo;
import Modelo.Persona;
import Modelo.Venta;
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
public class ControladorI3 {

    private Vista.Interfaz3 i3;
    private BaseDeDatos bd = new BaseDeDatos();

    public ControladorI3(Vista.Interfaz3 i3) {
        this.i3 = i3;
        this.i3.addCalcularListener(new CalcularListener());

    }

    public class CalcularListener implements ActionListener {

        Object obj;

        public void actionPerformed(ActionEvent ae) {

            comportamiento(ae, obj);
        }

        public void comportamiento(ActionEvent ae, Object obj) {

            obj = ae.getSource();

            if (obj == i3.getBtnaniadir()) {
                if (!datosRellenos()) {
                    JOptionPane.showMessageDialog(i3.getFrame(), "Faltan por meter datos", "Error insertar", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (!comprobarDatos()) {
                        JOptionPane.showMessageDialog(i3.getFrame(), "El nombre no es correcto, solo debe tener caracteres", "Error insertar", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (!comprobarTelefono()) {
                            JOptionPane.showMessageDialog(i3.getFrame(), "El telefono no es correcto, debe contener 9 dígitos", "Error insertar", JOptionPane.ERROR_MESSAGE);
                        } else {
                            if (!comprobarPrecio()) {
                                JOptionPane.showMessageDialog(i3.getFrame(), "El precio debe estar compuesto de numeros y ser entero", "Error insertar", JOptionPane.ERROR_MESSAGE);
                            } else {
                                String[] presi = String.valueOf(i3.getTpresi().getSelectedItem()).split(" ");
                                String[] direc = String.valueOf(i3.getTdirec().getSelectedItem()).split(" ");
                                int idP = AccesoBase.obtenerIdPersona(presi[0], presi[1]);
                                int idD = AccesoBase.obtenerIdPersona(direc[0], direc[1]);
                                int precio = Integer.parseInt(i3.getTprecioEntrada().getText());
                                Equipo equipo = new Equipo(i3.getTnombre().getText(), i3.getTtelefono().getText(), idP, idD, precio);
                                AccesoBase.crearEquipo(equipo);
                                i3.getTequipo().addItem(AccesoBase.consultaEquipos()[AccesoBase.consultaEquipos().length - 1]);
                                i3.getTequipo2().addItem(AccesoBase.consultaEquipos()[AccesoBase.consultaEquipos().length - 1]);
                                i3.getTnombreEquipo().addItem(AccesoBase.consultaEquipos()[AccesoBase.consultaEquipos().length - 1]);
                                JOptionPane.showMessageDialog(i3.getFrame(), "Equipo insertado", "Insertado", JOptionPane.INFORMATION_MESSAGE);

                            }
                        }
                    }
                }
            } else if (obj == i3.getBtncancelar()) {
                vaciar();
            } else if (obj == i3.getBtnaceptarEquipo()) {
                String nom = String.valueOf(i3.getTequipo().getSelectedItem());
                AccesoBase.eliminarEquipo(nom);
                i3.getTnombreEquipo().removeItem(i3.getTequipo().getSelectedItem());
                i3.getTequipo2().removeItem(i3.getTequipo().getSelectedItem());
                i3.getTequipo().removeItem(i3.getTequipo().getSelectedItem());
                JOptionPane.showMessageDialog(i3.getFrame(), "Equipo eliminado", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
            } else if (obj == i3.getBtnaceptarDirec()) {
                String[] direc = String.valueOf(i3.getTdirec2().getSelectedItem()).split(" ");
                int idD = AccesoBase.obtenerIdPersona(direc[0], direc[1]);
                String nom = String.valueOf(i3.getTequipo2().getSelectedItem());
                AccesoBase.modificarDirector(nom, idD);
                JOptionPane.showMessageDialog(i3.getFrame(), "Director modificado", "Modificado", JOptionPane.INFORMATION_MESSAGE);
            } else if (obj == i3.getSeleccionEquipo()) {
                String nom = String.valueOf(i3.getTnombreEquipo().getSelectedItem());
                int precio = AccesoBase.obtenerPrecio(nom);
                i3.getTprecio().setText(String.valueOf(precio) + " $");
            } else {
                if (!comprobarSeleccion()) {
                    JOptionPane.showMessageDialog(i3.getFrame(), "Debe seleccionar un equipo", "Error venta", JOptionPane.ERROR_MESSAGE);
                } else {
                    Date fecha = i3.getTfecha();
                    java.sql.Date fecha1 = convertirFecha(fecha);
                    int id = AccesoBase.obtenerIdEquipo(String.valueOf(i3.getTnombreEquipo().getSelectedItem()));
                    Venta v = new Venta(id,fecha1);
                    AccesoBase.crearEVenta(v);
                    JOptionPane.showMessageDialog(i3.getFrame(), "Venta almacenada", "Venta", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }

    }

    public boolean datosRellenos() {
        boolean estado = false;
        String nombre, presi, director, telefono, precio;
        nombre = i3.getTnombre().getText();
        telefono = i3.getTtelefono().getText();
        presi = String.valueOf(i3.getTpresi().getSelectedItem());
        director = String.valueOf(i3.getTdirec().getSelectedItem());
        precio = i3.getTprecioEntrada().getText();
        if (nombre.contentEquals("") | telefono.contentEquals("") | presi.contentEquals("") | director.contentEquals("") | precio.contentEquals("")) {
            estado = false;
        } else {
            estado = true;
        }
        return estado;
    }

    public void vaciar() {
        i3.getTnombre().setText("");
        i3.getTtelefono().setText("");
        i3.getTprecioEntrada().setText("");
    }

    public boolean comprobarDatos() {
        boolean estado = false;
        String p = "([A-Z]|[a-z])*";
        String nom = i3.getTnombre().getText();
        Pattern p1 = Pattern.compile(p);
        Matcher m = p1.matcher(nom);
        if (m.matches()) {
            estado = true;
        }
        return estado;
    }

    public boolean comprobarTelefono() {
        boolean estado = false;
        String p = "\\d{9}";
        String tel = i3.getTtelefono().getText();
        Pattern p1 = Pattern.compile(p);
        Matcher m = p1.matcher(tel);
        if (m.matches()) {
            estado = true;
        }
        return estado;
    }

    public boolean comprobarPrecio() {
        boolean estado = false;
        String p = "\\d*";
        String precio = i3.getTprecioEntrada().getText();
        Pattern p1 = Pattern.compile(p);
        Matcher m = p1.matcher(precio);
        if (m.matches()) {
            estado = true;
        }
        return estado;
    }

    public boolean comprobarSeleccion() {
        boolean estado = false;
        String p = i3.getTprecio().getText();
        if (!p.contentEquals("")) {
            estado = true;
        }
        return estado;
    }
    
    public java.sql.Date convertirFecha(java.util.Date date) {
        return new java.sql.Date(date.getTime());
    }
}
