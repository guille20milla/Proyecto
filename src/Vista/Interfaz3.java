/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Alumno
 */
public class Interfaz3 {
    JFrame frame;
    JPanel panel1;
    JLabel nombre;
    JTextField Tnombre;
    JLabel telefono;
    JTextField Ttelefono;
    JLabel presi;
    JComboBox Tpresi;
    JLabel direc;
    JComboBox Tdirec;
    JLabel precioEntrada;
    JTextField TprecioEntrada;
    JButton btnaniadir;
    JButton btncancelar;
    JPanel panel2;
    JLabel equipo;
    JComboBox Tequipo;
    JButton btnaceptarEquipo;
    JPanel panel3;
    JLabel direc2;
    JComboBox Tdirec2;
    JButton btnaceptarDirec;
    JPanel panel4;
    JLabel nombreEquipo;
    JComboBox TnombreEquipo;
    JLabel fecha;
    JDateChooser Tfecha;
    JLabel precio;
    JLabel Tprecio;
    JButton aceptarVenta;
    JTabbedPane pestañas;
    
    public Interfaz3(){
        frame = new JFrame();
        panel1= new JPanel();
        panel2= new JPanel();
        panel3= new JPanel();
        panel4= new JPanel();
        pestañas= new JTabbedPane();
        ImageIcon escudo = new ImageIcon("fotoEscudo.gif");
        ImageIcon escudoTachado = new ImageIcon("fotoEscudoTachado.gif");
        
        panel1.setLayout(new GridLayout(6,2,5,5));
        panel1.setSize(100,100);
        nombre = new JLabel("Nombre");
        Tnombre = new JTextField(15);
        telefono = new JLabel("Telefono");
        Ttelefono = new JTextField(15);
        presi = new JLabel("Presidente");
        Tpresi=new JComboBox();
        direc = new JLabel("Director de Marketing");
        Tdirec=new JComboBox();
        precioEntrada = new JLabel("Precio entradas");
        TprecioEntrada = new JTextField(15);
        btnaniadir = new JButton("Añadir");
        btncancelar = new JButton("Cancelar");
        
        panel1.add(nombre);
        panel1.add(Tnombre);
        panel1.add(telefono);
        panel1.add(Ttelefono);
        panel1.add(presi);
        panel1.add(Tpresi);
        panel1.add(direc);
        panel1.add(Tdirec);
        panel1.add(precioEntrada);
        panel1.add(TprecioEntrada);
        panel1.add(btnaniadir);
        panel1.add(btncancelar);
        
        panel2.setLayout(new GridLayout(5,2,5,5));
        equipo = new JLabel("Elegir equipo: ");
        Tequipo = new JComboBox();
        btnaceptarEquipo = new JButton("Aceptar");
        
        panel2.add(equipo);
        panel2.add(Tequipo);
        panel2.add(btnaceptarEquipo);
        
        panel3.setLayout(new GridLayout(5,3,5,5));
        nombreEquipo = new JLabel("Nombre equipo");
        TnombreEquipo = new JComboBox();
        fecha = new JLabel("Fecha");
        Tfecha= new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
        precio = new JLabel("Precio");
        Tprecio = new JLabel();
        aceptarVenta = new JButton("Vender");
        
        
        panel3.add(nombreEquipo);
        panel3.add(TnombreEquipo);
        panel3.add(fecha);
        panel3.add(Tfecha);
        panel3.add(precio);
        panel3.add(Tprecio);
        panel3.add(aceptarVenta);
        
        panel4.setLayout(new GridLayout(5,2,5,5));
        direc2 = new JLabel("Elegir director: ");
        Tdirec2 = new JComboBox();
        btnaceptarDirec = new JButton("Aceptar");
        
        panel4.add(direc2);
        panel4.add(Tdirec2);
        panel4.add(btnaceptarDirec);
        
        
        pestañas.addTab("Alta equipo",escudo, panel1);
        pestañas.addTab("Baja equipo",escudoTachado, panel2);
        pestañas.addTab("Vender entrada", panel3);
        pestañas.addTab("Modificar director", panel4);
        
        
        
        frame.add(pestañas);
        
        
        
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        frame.setSize(700, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * @return the Tfecha
     */
    public Date getTfecha() {
        return Tfecha.getDate();
    }
}
