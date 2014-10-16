/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.busqueda;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

/**
 *
 * @author JoseAntonio
 */
public class ListModelBuscaArchivos implements ListModel{

    private String[]contenido;

    public ListModelBuscaArchivos(String[] contenido) {
        this.contenido = contenido;
    }   
    
    @Override
    public int getSize() {
        return this.contenido.length;
    }

    @Override
    public Object getElementAt(int index) {
        return (String)contenido[index];
    }

    @Override
    public void addListDataListener(ListDataListener l) {
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
    }
    
}
