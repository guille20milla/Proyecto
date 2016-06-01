/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;


import Controlador.ControladorInicio;
import Vista.*;

/**
 *
 * @author Alumno
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InterfazInicio i = new InterfazInicio();
        ControladorInicio cin = new ControladorInicio(i);
    }
    
}
