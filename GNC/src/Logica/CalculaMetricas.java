package Logica;

import Pojo.Arista;
import Pojo.IGRN;
import java.util.HashMap;
import java.util.Set;
import vista.VentanaPrincipal;

public class CalculaMetricas {

    HashMap<Integer, Posicion> posiciones = new HashMap();
    int genesComunes = 0;
    private static final int inf = Costantes.infinito;

    public int getGenesComunes() {
        return genesComunes;
    }

    public void setGenesComunes(int genesComunes) {
        this.genesComunes = genesComunes;
    }

    public Integer buscarNodo(String nombreNodo, HashMap<String, Integer> hashmap) {
        if (nombreNodo.contains("﻿")) {
            String[] a = nombreNodo.split("﻿");
            return (Integer) hashmap.get(a[1]);
        }
        return (Integer) hashmap.get(nombreNodo);
    }

    public HashMap<Integer, Posicion> getPosiciones() {
        return this.posiciones;
    }

    public float[] calculaInterseccion(IGRN entrada, int[][] bDatos, int[][] mEntrada, HashMap<String, Integer> hashmap,IGRN BD) {
        float[][] result;
        int contadorComun = 0;
        Integer contadorBD = 0;
        float alfa = 0, beta = 0;
        float total = 0;
        float sumaDiagonalSup = 0;
        float coherencePPV = 0, coherenceF = 0, coherenceRecall = 0;
        int TP = 0, FP = 0, TN = 0, FN = 0;

        float[] coherence = new float[3];

        for (int i = 0; i < entrada.getListNodos().size(); i++) {
            contadorBD = hashmap.get(entrada.getListNodos().get(i).getNombre());
            if (contadorBD != null) {
                if (contadorBD >= 0) {
                    Posicion aux = new Posicion(i, entrada.getListNodos().get(i).getNombre());
                    posiciones.put(contadorComun, aux);
                    contadorComun++;
                }
            }
        }
        result = new float[contadorComun][contadorComun];
        int n = result.length;
        this.setGenesComunes(n);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                if (i == j) {
                    result[i][j] = 0;
                } else {
                    alfa = mEntrada[posiciones.get(i).getPosicionReal()][posiciones.get(j).getPosicionReal()];
                    beta = bDatos[hashmap.get(posiciones.get(i).getNombreNodo())][hashmap.get(posiciones.get(j).getNombreNodo())];
                    if (alfa < inf && beta < inf && (Math.abs(alfa - beta)==0)) {
                        TP++;
                    }else if(alfa < inf && beta < inf && alfa!=beta){
                        TN++;
                    }
                    total = 1 / (((Math.abs(alfa - beta)) * Math.min(alfa, beta)) + 1);
                    result[i][j] = total;

                }
            }
        }

        //recorro la diagonal sup para sumar resultados
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    sumaDiagonalSup += result[i][j];
                }
            }
        }

        sumaDiagonalSup = (float) sumaDiagonalSup / ((float) ((float) ((float) n * ((float) n - (float) 1)) / (float) 2));

        for (int i = 0; i < entrada.getListAristas().size(); i++) {
            boolean enc = false;
            for (int j = 0; j < BD.getListAristas().size(); j++) {                
                Arista inA = entrada.getListAristas().get(i);
                Arista bdA = BD.getListAristas().get(j);                
                if (inA.getOrigen().compareToIgnoreCase(bdA.getOrigen())==0 && inA.getDestino().compareToIgnoreCase(bdA.getDestino())==0 ) {
                    enc = true;
                    break;
                }             
            }
            if (!enc) {
                FP++;
            }
        }
        for (int i = 0; i < BD.getListAristas().size(); i++) {
            boolean enc = false;
            for (int j = 0; j < entrada.getListAristas().size(); j++) {                
                Arista inA = entrada.getListAristas().get(j);
                Arista bdA = BD.getListAristas().get(i);                
                if (inA.getOrigen().compareToIgnoreCase(bdA.getOrigen())==0 && inA.getDestino().compareToIgnoreCase(bdA.getDestino())==0 ) {
                    enc = true;
                    break;
                }             
            }
            if (!enc) {
                FN++;
            }
        }       
        coherencePPV = ((float) TP / ((float) TP + (float) FP));
        coherenceRecall = ((float) TP / ((float) TP + (float) FN));
        coherenceF = (1 - (((float) 2 * (float) coherencePPV * (float) coherenceRecall) / ((float) coherencePPV + (float) coherenceRecall)));
        if (Double.isNaN(coherencePPV)) {
            coherencePPV = 0;
        }       
        if (Double.isNaN(coherenceF)) {
            coherenceF = 0;
        }
        if (Double.isNaN(sumaDiagonalSup)) {
            sumaDiagonalSup = 0;
        }
        coherence[0] = sumaDiagonalSup;
        coherence[1] = coherencePPV;
        coherence[2] = coherenceF;
        return coherence;
    }
    
     public float[] calculaInterseccion(IGRN entrada, int[][] bDatos, int[][] mEntrada, HashMap<String, Integer> hashmap,IGRN BD,VentanaPrincipal padre) {
        float[][] result;
        int contadorComun = 0;
        Integer contadorBD = 0;
        float alfa = 0, beta = 0;
        float total = 0;
        float sumaDiagonalSup = 0;
        float coherencePPV = 0, coherenceF = 0, coherenceRecall = 0;
        int TP = 0, FP = 0, TN = 0, FN = 0;

        float[] coherence = new float[3];
        padre.getLog().writeLog("Getting common genes",true);

        for (int i = 0; i < entrada.getListNodos().size(); i++) {
            contadorBD = hashmap.get(entrada.getListNodos().get(i).getNombre());
            if (contadorBD != null) {
                if (contadorBD >= 0) {
                    Posicion aux = new Posicion(i, entrada.getListNodos().get(i).getNombre());
                    posiciones.put(contadorComun, aux);
                    contadorComun++;
                }
            }
        }
        padre.getLog().writeLog("Number of common genes:" + contadorComun,true);
        padre.getLog().writeLog("Final Step: Obtaining measures",true);
        result = new float[contadorComun][contadorComun];
        int n = result.length;
        this.setGenesComunes(n);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                
                if (i == j) {
                    result[i][j] = 0;
                } else {
                    alfa = mEntrada[posiciones.get(i).getPosicionReal()][posiciones.get(j).getPosicionReal()];
                    beta = bDatos[hashmap.get(posiciones.get(i).getNombreNodo())][hashmap.get(posiciones.get(j).getNombreNodo())];
                    if (alfa < inf && beta < inf && (Math.abs(alfa - beta)==0)) {
                        TP++;
                    }else if(alfa < inf && beta < inf && alfa!=beta){
                        TN++;
                    }
                    total = 1 / (((Math.abs(alfa - beta)) * Math.min(alfa, beta)) + 1);
                    result[i][j] = total;
                }
                
                padre.getBarra().setValue(padre.getBarra().getValue()+(int)((int)20/(int)(contadorComun*contadorComun)));
                padre.getBarra().setString(padre.getBarra().getValue() + "%");
                padre.repaint();
            }
        }

        //recorro la diagonal sup para sumar resultados
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    sumaDiagonalSup += result[i][j];
                }
            }
        }

        sumaDiagonalSup = (float) sumaDiagonalSup / ((float) ((float) ((float) n * ((float) n - (float) 1)) / (float) 2));

        for (int i = 0; i < entrada.getListAristas().size(); i++) {
            boolean enc = false;
            for (int j = 0; j < BD.getListAristas().size(); j++) {                
                Arista inA = entrada.getListAristas().get(i);
                Arista bdA = BD.getListAristas().get(j);                
                if (inA.getOrigen().compareToIgnoreCase(bdA.getOrigen())==0 && inA.getDestino().compareToIgnoreCase(bdA.getDestino())==0 ) {
                    enc = true;
                    break;
                }             
            }
            if (!enc) {
                FP++;
            }
        }
        for (int i = 0; i < BD.getListAristas().size(); i++) {
            boolean enc = false;
            for (int j = 0; j < entrada.getListAristas().size(); j++) {                
                Arista inA = entrada.getListAristas().get(j);
                Arista bdA = BD.getListAristas().get(i);                
                if (inA.getOrigen().compareToIgnoreCase(bdA.getOrigen())==0 && inA.getDestino().compareToIgnoreCase(bdA.getDestino())==0 ) {
                    enc = true;
                    break;
                }             
            }
            if (!enc) {
                FN++;
            }
        }       
        coherencePPV = ((float) TP / ((float) TP + (float) FP));
        coherenceRecall = ((float) TP / ((float) TP + (float) FN));
        coherenceF = (1 - (((float) 2 * (float) coherencePPV * (float) coherenceRecall) / ((float) coherencePPV + (float) coherenceRecall)));
        padre.getLog().writeLog("GNC measure:" + sumaDiagonalSup,true);
        padre.getLog().writeLog("F-Measure :" + coherenceF,true);
        padre.getLog().writeLog("PPV measure:" + coherencePPV,true);
        coherence[0] = sumaDiagonalSup;
        coherence[1] = coherencePPV;
        coherence[2] = coherenceF;
        return coherence;
    }

    private boolean hayGenesComunes(HashMap<Integer, Posicion> posiciones, HashMap<String, Integer> hashmap) {
        boolean encontrado = false;
        Set claves = hashmap.keySet();
        for (int i = 0; i < posiciones.size(); i++) {
            String pos = ((Posicion) posiciones.get(Integer.valueOf(i))).getNombreNodo();
            if (claves.contains(pos)) {
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
}
