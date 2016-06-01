/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.AccesoBase;
import Modelo.BaseDeDatos;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Alumno
 */
public class TablaVentas extends JFrame{
     ResultSet rs = null;
    BaseDeDatos db = new BaseDeDatos();

    public TablaVentas() {
        db.abrirConexion();
        rs = AccesoBase.consultaTablaVentas();
        MyTableModel myModel = new MyTableModel();
        JTable table = new JTable(myModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        db.cerrarConexion();

    }

    class MyTableModel extends AbstractTableModel {

        BaseDeDatos db = new BaseDeDatos();

        final String[] columNames = {"Id", "Equipo", "Fecha"};
        String[][] data = null;

        public MyTableModel() {

            db.abrirConexion();

            try {
                data = rellenarTabla();
            } catch (SQLException sqle) {
                sqle.getMessage();
            }
            db.cerrarConexion();
        }

        public int calcularFilas() {
            int num = 0;
            try {

                rs.last();
                num = rs.getRow();
                rs.beforeFirst();
            } catch (SQLException sqle) {
                sqle.getMessage();
            }

            return num;

        }

        public String[][] rellenarTabla() throws SQLException {

            int numFilas = calcularFilas();
            int numColumns = getColumnCount();
            int i = 0;
            String[][] data = new String[numFilas][numColumns];
            while (rs.next()) {
                for (int j = 0; j < numColumns; j++) {
                    data[i][j] = rs.getString(j + 1);
                }
                i++;
            }

            return data;
        }

        //Cuenta las columnas
        public int getColumnCount() {
            return columNames.length;
        }

        //Cuenta las filas
        public int getRowCount() {
            return data.length;
        }

        //devuelve el nombre de la columna
        public String getColumnName(int col) {
            return columNames[col];
        }

        //Devuelve los datos d ela tabla
        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

    }
}
