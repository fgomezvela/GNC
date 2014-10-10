/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.resultado;

import java.util.Objects;

/**
 *
 * @author JoseAntonio
 */
public class Comparacion {
    private String nombreInput,nombreDB;
    private int nodosIN,nodosDB,arIN,arDB,genesComunes;
    private float densidadIn,densidadDB, coherencia,coherenciaPPV,coherenciaF;

    public Comparacion(String nombreInput, String nombreDB, int nodosIN, int nodosDB, int arIN, int arDB, float coherencia,float coherenciaF,float coherenciaPPV, float densidadIn, float densidadDB,int genesComunes) {
        this.nombreInput = nombreInput;
        this.nombreDB = nombreDB;
        this.nodosIN = nodosIN;
        this.nodosDB = nodosDB;
        this.arIN = arIN;
        this.arDB = arDB;
        this.coherencia = coherencia;
        this.coherenciaPPV = coherenciaPPV;
        this.coherenciaF = coherenciaF;
        this.densidadIn = densidadIn;
        this.densidadDB = densidadDB;
        this.genesComunes = genesComunes;
    }

    public int getGenesComunes() {
        return genesComunes;
    }

    public void setGenesComunes(int genesComunes) {
        this.genesComunes = genesComunes;
    }

    public String getNombreInput() {
        return nombreInput;
    }

    public void setNombreInput(String nombreInput) {
        this.nombreInput = nombreInput;
    }

    public String getNombreDB() {
        return nombreDB;
    }

    public void setNombreDB(String nombreDB) {
        this.nombreDB = nombreDB;
    }

    public int getNodosIN() {
        return nodosIN;
    }

    public void setNodosIN(int nodosIN) {
        this.nodosIN = nodosIN;
    }

    public int getNodosDB() {
        return nodosDB;
    }

    public void setNodosDB(int nodosDB) {
        this.nodosDB = nodosDB;
    }

    public int getArIN() {
        return arIN;
    }

    public void setArIN(int arIN) {
        this.arIN = arIN;
    }

    public int getArDB() {
        return arDB;
    }

    public void setArDB(int arDB) {
        this.arDB = arDB;
    }

    public float getCoherencia() {
        return coherencia;
    }

    public float getCoherenciaPPV() {
        return coherenciaPPV;
    }

    public float getCoherenciaF() {
        return coherenciaF;
    }

    public void setCoherencia(float coherencia) {
        this.coherencia = coherencia;
    }

    public void setCoherenciaPPV(float coherenciaPPV) {
        this.coherenciaPPV = coherenciaPPV;
    }

    public void setCoherenciaF(float coherenciaF) {
        this.coherenciaF = coherenciaF;
    }  

    public float getDensidadIn() {
        return densidadIn;
    }

    public void setDensidadIn(float densidadIn) {
        this.densidadIn = densidadIn;
    }

    public float getDensidadDB() {
        return densidadDB;
    }

    public void setDensidadDB(float densidadDB) {
        this.densidadDB = densidadDB;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Comparacion other = (Comparacion) obj;
        if (!Objects.equals(this.nombreInput, other.nombreInput)) {
            return false;
        }
        if (!Objects.equals(this.nombreDB, other.nombreDB)) {
            return false;
        }
        if (this.nodosIN != other.nodosIN) {
            return false;
        }
        if (this.nodosDB != other.nodosDB) {
            return false;
        }
        if (this.arIN != other.arIN) {
            return false;
        }
        if (this.arDB != other.arDB) {
            return false;
        }        
        return true;
    }    
}
