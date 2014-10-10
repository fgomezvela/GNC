/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import Pojo.IGRN;
import Pojo.LeeGRN;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import vista.VentanaPrincipal;
import vista.resultado.Resultado;

/**
 *
 * @author JoseAntonio
 */
public class HiloGNC extends Thread {

    private IGRN grnBD, grnEntrada;
    private LeeGRN leeBD,leeInput;
    private String input, bd;
    private int genesComunes;
    private String rutaComparaciones;
    private VentanaPrincipal padre;
    private String rutaMatrices;

    public HiloGNC(IGRN grnBD, IGRN grnEntrada, LeeGRN leeBD, LeeGRN leeInput, String bd, String input, String rutaComparaciones, VentanaPrincipal padre, String rutaMatrices) {
        this.rutaMatrices = rutaMatrices;
        this.grnBD = grnBD;
        this.grnEntrada = grnEntrada;
        this.leeBD = leeBD;
        this.leeInput = leeInput;
        this.bd = bd;
        this.input = input;
        this.rutaComparaciones = rutaComparaciones;
        this.padre = padre;
        this.padre.getBarra().setValue(0);
        this.padre.getBarra().setStringPainted(true);
        this.padre.getBarra().setString(0 + "%");
        this.padre.repaint();

        /////////////////////////////////////////////////
        try {
            padre.getLog().writeLog("Loading Database",true);
            this.grnBD = this.leeBD.leerFichero(padre.getRutaFicheroDB(),padre,"database");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "I can not find the Database file", "ERROR", 0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "I can not read Database file", "ERROR", 0);
        }
        padre.getBarra().setValue((int)(20));
        padre.getBarra().setString(padre.getBarra().getValue() + "%");
        try {
            padre.getLog().writeLog("Loading Input Network",true);
            this.grnEntrada = this.leeInput.leerFichero(padre.getRutaFicheroInput(),padre,"input network");           
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "I can not find the Input Network file", "ERROR", 0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "I can not read Input Network file", "ERROR", 0);
        }
        padre.getBarra().setValue((int)(20));
        padre.getBarra().setString(padre.getBarra().getValue() + "%");
        ////////////////////////////////////////////////////////////////////////////////////
      
    }

    public void run() {
        float[] mCoherencia;
        mCoherencia = null;
        try {
            mCoherencia = calcularCoherenciaRed();
        } catch (IOException ex) {
            Logger.getLogger(HiloGNC.class.getName()).log(Level.SEVERE, null, ex);
        }
        int nodosIn = this.grnEntrada.getListNodos().size();
        int nodosDB = this.grnBD.getListNodos().size();
        int arIn = this.grnEntrada.getListAristas().size();
        int arDB = this.grnBD.getListAristas().size();
        Resultado resultadosBDatos = new Resultado(this.input, mCoherencia[0],mCoherencia[1],mCoherencia[2], this.bd, genesComunes, nodosIn, nodosDB, arIn, arDB, this.rutaComparaciones, padre);
        resultadosBDatos.setVisible(true);
        clean();        
        
    }

    public float[] calcularCoherenciaRed() throws IOException {
        DistanciaFactoria f = DistanciaFactoria.getInstance();        
        IDistancias d = f.createGRN("Floyd");
        CalculaMetricas calculaMetricas = new CalculaMetricas();
        int mBD[][] = null;
        padre.getLog().writeLog("Converting Database into matrix",true);
        padre.getLog().writeLog("This process may take several minutes",true);
        if (!encontrado(bd, rutaMatrices)) {
            mBD = d.distanciaFloyd(grnBD);
        } else {               
            mBD = Volcar.volcarMatriz(rutaMatrices + System.getProperty("file.separator") + bd + ".txt",padre);            
        }
        padre.getBarra().setValue(padre.getBarra().getValue()+(int)(20));
        padre.getBarra().setString(padre.getBarra().getValue() + "%");
        padre.getLog().writeLog("Database has been loaded",true);
        padre.getLog().writeLog("Converting Input Network into matrix",true);
        padre.getLog().writeLog("This process may take several minutes",true);
        int[][] mEntrada = null;
        if (!encontrado(input, rutaMatrices)) {
            mEntrada = d.distanciaFloyd(grnEntrada);
        } else {
            mEntrada = Volcar.volcarMatriz(rutaMatrices + System.getProperty("file.separator") + input + ".txt",padre);
        }
        padre.getBarra().setValue(padre.getBarra().getValue()+(int)(20));
        padre.getBarra().setString(padre.getBarra().getValue() + "%");
        padre.getLog().writeLog("Input Network has been loaded",true);
        padre.getLog().writeLog("Stablish the comparision",true);
        float[] mCoherencia = calculaMetricas.calculaInterseccion(grnEntrada, mBD, mEntrada, this.leeBD.getHmap(),grnBD,padre);
        this.genesComunes = calculaMetricas.getGenesComunes();
        padre.getBarra().setString("100 %");
        padre.getBarra().setValue(100);
        return mCoherencia;
    }

    private boolean encontrado(String bd, String rutaMatrices) {
        boolean encontrado = false;
        File directorioM = new File(rutaMatrices);
        String[] lista = directorioM.list();
        for (int i = 0; i < lista.length; i++) {
            if (bd.compareToIgnoreCase(lista[i]) == 0) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
    
     private void clean() {
        File f = new File(System.getProperty("user.dir"));
        String[] lista = f.list();
        for (int i = 0; i < lista.length; i++) {
            File borrar = new File(f + lista[i]);
            if (lista[i].endsWith(".txt") && borrar.isFile() && borrar.length()==0) {
                borrar.delete();
            }
        }

    }
}
