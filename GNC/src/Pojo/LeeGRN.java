/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pojo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import vista.VentanaPrincipal;

/**
 *
 * @author Josele
 */
public class LeeGRN {

    String ruta, nOrganismo;
    HashMap<String, Integer> hmap = new HashMap<String, Integer>();

    public LeeGRN() {
    }

    public String getnOrganismo() {
        return nOrganismo;
    }

    public void setnOrganismo(String nOrganismo) {
        this.nOrganismo = nOrganismo;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public LeeGRN(String ruta, String nOrganismo) {
        this.ruta = ruta;
        this.nOrganismo = nOrganismo;
    }

    public HashMap<String, Integer> getHmap() {
        return hmap;
    }

    public void setHmap(HashMap<String, Integer> hmap) {
        this.hmap = hmap;
    }

    public IGRN leerBD(String ruta, String nOrganismo) throws FileNotFoundException, IOException {
        /*
         * Se podria leer un directorio con todas las BBDD y que se cargaran en
         * memoria una vez al mes tras alguna actualización.
         */
        List<Arista> aristas = new ArrayList<Arista>();
        List<Nodo> nodos = new ArrayList<Nodo>();
        int idArista = 1;
        int contador = 0;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;

            while ((linea = br.readLine()) != null) {
                //Miro que no sea la palabra nodo o Arista
                if (linea.compareToIgnoreCase("Nodos") != 0 && linea.compareToIgnoreCase("Aristas") != 0 && linea.compareToIgnoreCase("") != 0 && linea.compareToIgnoreCase("﻿Nodos") != 0 && !linea.contains("Nombre") && !linea.contains("Organismo")) {
                    //Miramos que no empiece por a, es decir que sea un nodo.
                    if (!linea.startsWith("a")) {
                        //añadimos nodo
                        Nodo n = new Nodo(linea);
                        nodos.add(n);
                        this.hmap.put(n.getNombre(), contador);
                        contador++;
                    } else {
                        //En caso de que sea una arista, separo por espacios
                        String[] separar = linea.split(" ");
                        //Creo la arista correspondiente
                        Arista a = new Arista(separar[1], separar[2], idArista);
                        aristas.add(a);
                        idArista++;
                    }
                }
            }

            //Añadimos ID de Aristas a cada Nodo una vez que tenemos las listas
            for (int j = 0; j < nodos.size(); j++) {
                List<Integer> ar = new ArrayList<Integer>();

                for (int k = 0; k < aristas.size(); k++) {
                    if (nodos.get(j).getNombre().compareToIgnoreCase(aristas.get(k).getOrigen()) == 0 || nodos.get(j).getNombre().compareToIgnoreCase(aristas.get(k).getDestino()) == 0) {
                        ar.add(aristas.get(k).getIdArista());
                    }
                }

                nodos.get(j).setIdAristas(ar);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        GRNFactoria factoria = new GRNFactoria();

        if (nOrganismo == null) {
            return factoria.createGRN("RedEntrada", nodos, aristas, nOrganismo);
        } else {
            return factoria.createGRN("BBDD", nodos, aristas, nOrganismo);
        }
    }

    public IGRN leerFichero(String ruta) throws FileNotFoundException, IOException {
        /*
         * Se podria leer un directorio con todas las BBDD y que se cargaran en
         * memoria una vez al mes tras alguna actualización.
         */
        List<Arista> aristas = new ArrayList<Arista>();
        List<Nodo> nodos = new ArrayList<Nodo>();
        int idArista = 1;

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            Nodo aux, auxi;
            linea = br.readLine();
            int contador = 0;
            do {
                String[] separar = linea.split(",");
               // System.out.println("separar[0] = " + separar[0]+"|||separar[1] = " + separar[1]+"|||separar[2] = " + separar[2]);
                //Creo la arista correspondiente
                if (separar[0].contains("﻿")) {
                    aux = new Nodo(separar[0].split("﻿")[1]);
                } else {
                    aux = new Nodo(separar[0]);
                }
                //System.out.println("separar = " + separar[0] + ":" + separar[1]);
                auxi = new Nodo(separar[1]);
                if (!nodos.contains(aux)) {
                    nodos.add(aux);
                    this.hmap.put(aux.getNombre(), contador);
                    contador++;

                }
                if (!nodos.contains(auxi)) {
                    nodos.add(auxi);
                    this.hmap.put(auxi.getNombre(), contador);
                    contador++;
                }
                Arista a = new Arista(aux.getNombre(), auxi.getNombre(), idArista);
                aristas.add(a);
                idArista++;
            } while ((linea = br.readLine()) != null);

            //Añadimos ID de Aristas a cada Nodo una vez que tenemos las listas
            for (int j = 0; j < nodos.size(); j++) {
                List<Integer> ar = new ArrayList<Integer>();

                for (int k = 0; k < aristas.size(); k++) {
                    if (nodos.get(j).getNombre().compareToIgnoreCase(aristas.get(k).getOrigen()) == 0 || nodos.get(j).getNombre().compareToIgnoreCase(aristas.get(k).getDestino()) == 0) {
                        ar.add(aristas.get(k).getIdArista());
                    }
                }
                nodos.get(j).setIdAristas(ar);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                    br.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        GRNFactoria factoria = new GRNFactoria();
        if (nOrganismo == null) {
            return factoria.createGRN("RedEntrada", nodos, aristas, nOrganismo);
        } else {
            return factoria.createGRN("BBDD", nodos, aristas, nOrganismo);
        }
    }
    
    public IGRN leerFichero(String ruta,VentanaPrincipal padre,String type) throws FileNotFoundException, IOException {
        /*
         * Se podria leer un directorio con todas las BBDD y que se cargaran en
         * memoria una vez al mes tras alguna actualización.
         */
        List<Arista> aristas = new ArrayList<Arista>();
        List<Nodo> nodos = new ArrayList<Nodo>();
        int idArista = 1;

        File archivo = null;
        FileReader fr = null;
        FileReader fr2 = null;
        BufferedReader br = null;
        BufferedReader br2 = null;
        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            fr2 =new FileReader(archivo);
            br = new BufferedReader(fr);
            br2 = new BufferedReader(fr2);
            //Less than a 1 KB
            long tamFile = archivo.length();
            if (tamFile<1024) {
                padre.getLog().writeLog("The selected file is under 1 KB, the spend time to cover the whole process could be less than a minute. This time is orientative. Be patient", true);
                padre.getLog().timeF(60);
            }
            //Less thana  1 MB
            else if(tamFile>1024 && tamFile<1024*1024){
               padre.getLog().writeLog("The selected " + type + " file is under 1 Mb, the spend time to cover the whole process could be less than five minutes. This time is orientative. Be patient", true);
               padre.getLog().timeF(300);
            }
            else if(tamFile>1024*1024 && tamFile<2*1024*1024){
               padre.getLog().writeLog("The selected " + type + " file is under 2 Mb, the spend time to cover the whole process could be between 5-15 minutes. This time is orientative. Be patient", true);
               padre.getLog().timeF(900);
            }
            else if(tamFile>2*1024*1024 && tamFile<5*1024*1024){
               padre.getLog().writeLog("The selected " + type + " file is under 5 Mb, the spend time to cover the whole process could be between 30-90 minutes. This time is orientative. Be patient", true);
               padre.getLog().timeF(5400);
            }
            else {
               padre.getLog().writeLog("The selected " + type + " file is over 5 Mb, the spend time to cover the whole process could be several hours. This time is orientative. Be patient", true);
               padre.getLog().timeF(100);
            }
            
            // Lectura del fichero
            String linea;
            String linea2;
            Nodo aux, auxi;
            linea = br.readLine();
            int contador = 0;
            int numLineas = 0;
            do{
                numLineas++;
            }while ((linea2 = br2.readLine()) != null);
            padre.getLog().writeLog("Reading " + type + " file: " + numLineas + " lines",true); 
            do {
                String[] separar = linea.split(",");
               // System.out.println("separar[0] = " + separar[0]+"|||separar[1] = " + separar[1]+"|||separar[2] = " + separar[2]);
                //Creo la arista correspondiente
                if (separar[0].contains("﻿")) {
                    aux = new Nodo(separar[0].split("﻿")[1]);
                } else {
                    aux = new Nodo(separar[0]);
                }
                //System.out.println("separar = " + separar[0] + ":" + separar[1]);
                auxi = new Nodo(separar[1]);
                if (!nodos.contains(aux)) {
                    nodos.add(aux);
                    this.hmap.put(aux.getNombre(), contador);
                    contador++;

                }
                if (!nodos.contains(auxi)) {
                    nodos.add(auxi);
                    this.hmap.put(auxi.getNombre(), contador);
                    contador++;
                }
                Arista a = new Arista(aux.getNombre(), auxi.getNombre(), idArista);
                aristas.add(a);                
                padre.getBarra().setValue(padre.getBarra().getValue()+(int)((1*20)/(numLineas)));
                padre.getBarra().setString(padre.getBarra().getValue() + "%");
                padre.repaint();
                idArista++;
            } while ((linea = br.readLine()) != null);
            padre.getBarra().setValue(padre.getBarra().getValue()+(int)((1*20)/(numLineas)));
            padre.getBarra().setString(padre.getBarra().getValue() + "%");
            padre.repaint();
            
            //Añadimos ID de Aristas a cada Nodo una vez que tenemos las listas
            for (int j = 0; j < nodos.size(); j++) {
                List<Integer> ar = new ArrayList<Integer>();

                for (int k = 0; k < aristas.size(); k++) {
                    if (nodos.get(j).getNombre().compareToIgnoreCase(aristas.get(k).getOrigen()) == 0 || nodos.get(j).getNombre().compareToIgnoreCase(aristas.get(k).getDestino()) == 0) {
                        ar.add(aristas.get(k).getIdArista());
                    }
                }
                nodos.get(j).setIdAristas(ar);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                    br.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        GRNFactoria factoria = new GRNFactoria();
        if (nOrganismo == null) {
            return factoria.createGRN("RedEntrada", nodos, aristas, nOrganismo);
        } else {
            return factoria.createGRN("BBDD", nodos, aristas, nOrganismo);
        }
        
    }

    public List<String> listaBD(String ruta) {

        List<String> nombreOrganismos = new ArrayList();

        File f = new File(ruta);

        for (int i = 0; i < f.list().length; i++) {
            String nombre = f.list()[i];
            nombreOrganismos.add(nombre.split("_")[0]);
        }

        return nombreOrganismos;

    }

    public List<String> listaOrganismos(String ruta) {
        List<String> nombreBD = new ArrayList();

        File f = new File(ruta);

        for (int i = 0; i < f.list().length; i++) {
            String nombre = f.list()[i];
            if (!nombreBD.contains(nombre.split("_")[1].split(".txt")[0])) {
                nombreBD.add(nombre.split("_")[1].split(".txt")[0]);
            }
        }

        return nombreBD;
    }

    public IGRN leerFicheroChico(String ruta) throws FileNotFoundException, IOException {
        /*
         * Se podria leer un directorio con todas las BBDD y que se cargaran en
         * memoria una vez al mes tras alguna actualización.
         */
        List<Arista> aristas = new ArrayList<Arista>();
        List<Nodo> nodos = new ArrayList<Nodo>();
        int idArista = 1;
        int contador = 0;
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            Nodo aux, auxi;
            linea = br.readLine();

            do {
                if (contador > 1 && linea.length() > 13 && linea.compareToIgnoreCase("}") != 0) {
                    linea = linea.replace(";", " ");
                    linea = linea.replace("\"", " ");
                    String[] separar = linea.split("->");
                    //System.out.println("linea = " + linea);
                    //Creo la arista correspondiente
                    aux = new Nodo(separar[0].trim());
                    auxi = new Nodo(separar[1].trim());
                    //System.out.println("separar[0] = " + aux.getNombre());
                    //System.out.println("separar[1] = " + auxi.getNombre());
                    if (!nodos.contains(aux)) {
                        nodos.add(aux);
                    }
                    if (!nodos.contains(auxi)) {
                        nodos.add(auxi);
                    }
                    Arista a = new Arista(aux.getNombre(), auxi.getNombre(), idArista);
                    aristas.add(a);
                    idArista++;
                }
                contador++;
            } while ((linea = br.readLine()) != null);
            //Añadimos ID de Aristas a cada Nodo una vez que tenemos las listas
            for (int j = 0; j < nodos.size(); j++) {
                List<Integer> ar = new ArrayList<Integer>();
                for (int k = 0; k < aristas.size(); k++) {
                    if (nodos.get(j).getNombre().compareToIgnoreCase(aristas.get(k).getOrigen()) == 0 || nodos.get(j).getNombre().compareToIgnoreCase(aristas.get(k).getDestino()) == 0) {
                        ar.add(aristas.get(k).getIdArista());
                    }
                }
                nodos.get(j).setIdAristas(ar);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        GRNFactoria factoria = new GRNFactoria();

        if (nOrganismo == null) {
            return factoria.createGRN("RedEntrada", nodos, aristas, nOrganismo);
        } else {
            return factoria.createGRN("BBDD", nodos, aristas, nOrganismo);
        }
    }
    
    public boolean ficheroVacio(String ruta){
       boolean aux = false;
        /*
         * Se podria leer un directorio con todas las BBDD y que se cargaran en
         * memoria una vez al mes tras alguna actualización.
         */
        
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(ruta);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            //Less than a 1 KB
            long tamFile = archivo.length();
            if (tamFile ==0) {
                aux = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                    br.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
       return aux;
    }
}
