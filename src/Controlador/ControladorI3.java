/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.AccesoBase;
import Modelo.BaseDeDatos;
import Modelo.Persona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                
            } else if(obj==i3.getBtncancelar()){
                
            }else if (obj == i3.getBtnaceptarEquipo()){
            
            }else if (obj == i3.getBtnaceptarDirec()){
            
            }else{
                
            }
        }

    }
}
