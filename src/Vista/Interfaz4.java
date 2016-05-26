/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.toedter.calendar.JDateChooser;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Alumno
 */
public class Interfaz4 {
    
    JFrame frame;
    JPanel panel;
    JLabel nombreEquipo;
    JComboBox TnombreEquipo;
    JLabel fecha;
    JDateChooser Tfecha;
    JLabel precio;
    JLabel Tprecio;
    JButton aceptarVenta;
    
    public Interfaz4(){
        frame = new JFrame();
        panel= new JPanel();
        
        panel.setLayout(new GridLayout(5,3,5,5));
        nombreEquipo = new JLabel("Nombre equipo");
        TnombreEquipo = new JComboBox();
        fecha = new JLabel("Fecha");
        Tfecha= new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
        precio = new JLabel("Precio");
        Tprecio = new JLabel();
        aceptarVenta = new JButton("Vender");
        
        
        panel.add(nombreEquipo);
        panel.add(TnombreEquipo);
        panel.add(fecha);
        panel.add(Tfecha);
        panel.add(precio);
        panel.add(Tprecio);
        panel.add(aceptarVenta);
        
        frame.add(panel);
        
        
        frame.setTitle("Venta de entradas");
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setSize(700, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
