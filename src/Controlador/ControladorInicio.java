/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;

/**
 *
 * @author Alumno
 */
public class ControladorInicio {

    private Vista.InterfazInicio i;
    private BaseDeDatos bd = new BaseDeDatos();

    public ControladorInicio(Vista.InterfazInicio i) {
        this.i = i;
        this.i.addCalcularListener(new CalcularListener());

    }

    public class CalcularListener implements ActionListener {

        Object o;

        public void actionPerformed(ActionEvent ae) {

            comportamiento(ae, o);
        }

        public void comportamiento(ActionEvent ae, Object obj) {

            obj = ae.getSource();

            if (obj == i.getConectarse()) {
                Interfaz1 i = new Interfaz1();
                ControladorI1 cip = new ControladorI1(i);
            } else if(obj == i.getMostrarTablaEquipo()){
                TablaEquipos t = new TablaEquipos();
                t.pack();
                t.setVisible(true);
                t.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            }else if(obj==i.getMostrarTablaPersonas()){
                TablaPersonas t = new TablaPersonas();
                t.pack();
                t.setVisible(true);
                t.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            }else if(obj == i.getMostrarTablaVentas()){
                TablaVentas t = new TablaVentas();
                t.pack();
                t.setVisible(true);
                t.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            }else{
                InterfazConsulta i = new InterfazConsulta();
                ControladorConsulta c = new ControladorConsulta(i);
            }

        }
    }
}
