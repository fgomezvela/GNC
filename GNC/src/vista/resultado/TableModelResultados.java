/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.resultado;

import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author JoseAntonio
 */
public class TableModelResultados extends AbstractTableModel {

    private String[] columnNames = {"Input Network", "Biological Database", "GNC","PPV","F-measure"};
    private List<Comparacion> listado;

    public TableModelResultados(List<Comparacion> listado) {
        this.listado = listado;
    }

    @Override
    public int getRowCount() {
        return this.listado.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object resp = null;
        switch (columnIndex) {
            case 0:
                resp = listado.get(rowIndex).getNombreInput();
                break;
            case 1:
                resp = listado.get(rowIndex).getNombreDB();
                break;
            case 2:
                resp = String.format("%.5f",listado.get(rowIndex).getCoherencia());
                break;
            case 3:
                resp = String.format("%.5f",listado.get(rowIndex).getCoherenciaPPV());
                break;
            case 4:
                resp = String.format("%.5f",listado.get(rowIndex).getCoherenciaF());
                break;
        }
        centrarDatos();
        return resp;
    }

    public void centrarDatos() {
        DefaultTableCellRenderer modelocentrar = new DefaultTableCellRenderer();
        modelocentrar.setHorizontalAlignment(SwingConstants.CENTER);
    }

    @Override
    public String getColumnName(int columnIndex) {
        String name = null;
        switch (columnIndex) {
            case 0:
                name = columnNames[0];
                break;
            case 1:
                name = columnNames[1];
                break;
            case 2:
                name = columnNames[2];
                break;
            case 3:
                name = columnNames[3];
                break;
            case 4:
                name = columnNames[4];
                break;
        }
        return name;
    }
}
