/*     */ package Logica;
/*     */
/*     */ import Pojo.Nodo;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.BufferedWriter;
/*     */ import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.FileReader;
/*     */ import java.io.FileWriter;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
import vista.VentanaPrincipal;
/*     */
/*     */ public class Volcar /*     */ {
    /*     */ public static void volcarFichero(int[][] m, String ruta, String nombre)
            /*     */ throws IOException /*     */ {
        /*  25 */ String sFichero = nombre;
        /*     */
        /*  27 */ FileWriter fichero = new FileWriter(ruta);
        /*  28 */ BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
        /*     */
        /*  30 */ for (int x = 0; x < m.length; x++) {
            /*  31 */ for (int y = 0; y < m.length; y++) {
                /*  32 */ fichero.write(m[x][y] + " ");
                /*     */            }
            /*  34 */ fichero.write("\r\n");
            /*     */        }
        /*     */
        /*  37 */ fichero.close();
                    bw.close();
        /*     */    }
    /*     */
    /*     */ public static void volcarFichero(int[][] m, String ruta, String nombre, List<Nodo> listaNodos) throws IOException {
        /*  41 */ String sFichero = nombre;
        /*     */
        /*  43 */ FileWriter fichero = new FileWriter(ruta + System.getProperty("file.separator") + sFichero);
        /*  44 */ BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
        /*     */
        /*  46 */ fichero.write("\t");
        /*  47 */ for (int i = 0; i < listaNodos.size(); i++) {
            /*  48 */ fichero.write(((Nodo) listaNodos.get(i)).getNombre() + " \t");
            /*     */        }
        /*  50 */ fichero.write("\r\n");
        /*     */
        /*  52 */ for (int x = 0; x < m.length; x++) {
            /*  53 */ fichero.write(((Nodo) listaNodos.get(x)).getNombre() + " \t");
            /*  54 */ for (int y = 0; y < m.length; y++) {
                /*  55 */ fichero.write(m[x][y] + " \t");
                /*     */            }
            /*  57 */ fichero.write("\r\n");
            /*     */        }
        /*     */
        /*  60 */ fichero.close();
        /*     */    }
    /*     */
    /*     */ public static int[][] volcarMatriz(String ruta) throws FileNotFoundException, IOException {
        /*  64 */ File archivo = new File(ruta);
        /*  65 */ FileReader fr = new FileReader(archivo);
        /*  66 */ BufferedReader br = new BufferedReader(fr);
        /*     */
        /*  68 */ int contI = 0;
        /*  69 */ int contJ = 0;
        /*     */ String linea;
        /*  72 */ while ((linea = br.readLine()) != null) {
            /*  73 */ String[] aux = linea.split(" ");
            /*  74 */ contI = aux.length;
            /*  75 */ contJ++;
            /*     */        }
        /*     */
        /*  78 */ fr.close();
        /*  79 */ br.close();
        /*     */
        /*  81 */ archivo = new File(ruta);
        /*  82 */ fr = new FileReader(archivo);
        /*  83 */ br = new BufferedReader(fr);
        /*     */
        /*  85 */ int cont = 0;
        /*     */
        /*  88 */ int[][] m = new int[contI][contJ];
        /*     */
        /*  90 */ while ((linea = br.readLine()) != null) {
            /*  91 */ String[] aux = linea.split(" ");
            /*     */
            /*  93 */ for (int i = 0; i < aux.length; i++) {
                /*  94 */ m[cont][i] = Integer.parseInt(aux[i]);
                /*     */            }
            /*     */
            /*  97 */ cont++;
            /*     */        }
        /*     */
        /* 100 */ fr.close();
        /* 101 */ br.close();
        /*     */
        /* 103 */ return m;
        /*     */    }
    
    public static int[][] volcarMatriz(String ruta, VentanaPrincipal padre) throws FileNotFoundException, IOException {
        /*  64 */ File archivo = new File(ruta);
        /*  65 */ FileReader fr = new FileReader(archivo);
        /*  66 */ BufferedReader br = new BufferedReader(fr);
        /*     */
        /*  68 */ int contI = 0;
        /*  69 */ int contJ = 0;
        /*     */ String linea;
        /*  72 */ while ((linea = br.readLine()) != null) {
            /*  73 */ String[] aux = linea.split(" ");
            /*  74 */ contI = aux.length;
            /*  75 */ contJ++;
            /*     */        }
        /*     */
        /*  78 */ fr.close();
        /*  79 */ br.close();
        /*     */
        /*  81 */ archivo = new File(ruta);
        /*  82 */ fr = new FileReader(archivo);
        /*  83 */ br = new BufferedReader(fr);
        /*     */
        /*  85 */ int cont = 0;
        /*     */
        /*  88 */ int[][] m = new int[contI][contJ];
        /*     
        /*  90 */ while ((linea = br.readLine()) != null) {
            /*  91 */ String[] aux = linea.split(" ");
            /*     */ 
            /*  93 */ for (int i = 0; i < aux.length; i++) {
                /*  94 */ m[cont][i] = Integer.parseInt(aux[i]);
                /*     */            }
            /*     */
            /*  97 */ cont++;
            /*     */        }
        /*     */
        /* 100 */ fr.close();
        /* 101 */ br.close();
        /*     */
        /* 103 */ return m;
        /*     */    }
    /*     */
    /*     */ public static void volcarFicheroCoherencia(int[][] m, String ruta, String nombre, HashMap<Integer, Posicion> hmap) throws IOException {
        /* 107 */ String sFichero = nombre;
        /*     */
        /* 109 */ FileWriter fichero = new FileWriter(ruta + System.getProperty("file.separator") + sFichero);
        /* 110 */ BufferedWriter bw = new BufferedWriter(new FileWriter(sFichero));
        /*     */
        /* 112 */ fichero.write("\t");
        /* 113 */ for (int i = 0; i < m.length; i++) {
            /* 114 */ fichero.write(((Posicion) hmap.get(Integer.valueOf(i))).getNombreNodo() + " \t");
            /*     */        }
        /* 116 */ fichero.write("\r\n");
        /*     */
        /* 118 */ for (int x = 0; x < m.length; x++) {
            /* 119 */ fichero.write(((Posicion) hmap.get(Integer.valueOf(x))).getNombreNodo() + " \t");
            /* 120 */ for (int y = 0; y < m.length; y++) /*     */ {
                /* 122 */ fichero.write(m[x][y] + " \t");
                /*     */            }
            /* 124 */ fichero.write("\r\n");
            /*     */        }
        /*     */
        /* 127 */ fichero.close();
        /*     */    }
    /*     */
    /*     */ public static void volcarFicheroCoherencia(float[][] m, float mediaMatrix, String ruta, String nombre, HashMap<Integer, Posicion> hmap) throws IOException {
        /* 131 */ String sFichero = nombre;
        /* 132 */ float iteraccionesTotales = m.length * m.length;
        /* 133 */ FileWriter fichero = new FileWriter(ruta + System.getProperty("file.separator") + sFichero);
        /* 134 */ float aux = 0.0F;
        /*     */
        /* 136 */ float mediaGen = 0.0F;
        /*     */
        /* 138 */ fichero.write("\t");
        /* 139 */ for (int i = 0; i < m.length; i++) {
            /* 140 */ fichero.write(((Posicion) hmap.get(Integer.valueOf(i))).getNombreNodo() + " \t");
            /*     */        }
        /* 142 */ fichero.write("\r\n");
        /*     */
        /* 144 */ for (int x = 0; x < m.length; x++) {
            /* 145 */ fichero.write(((Posicion) hmap.get(Integer.valueOf(x))).getNombreNodo() + " \t");
            /* 146 */ for (int y = 0; y < m.length; y++) {
                /* 147 */ aux += m[x][y];
                /* 148 */ fichero.write(String.format("%.7f", new Object[]{Float.valueOf(m[x][y])}));
                /* 149 */ fichero.write("\t");
                /*     */            }
            /* 151 */ fichero.write("\r\n");
            /*     */        }
        /*     */
        /* 157 */ fichero.write("Total Matriz: \t");
        /* 158 */ fichero.write(String.format("%.7f", new Object[]{Float.valueOf(mediaMatrix)}));
        /* 159 */ fichero.close();
        /*     */    }
    /*     */ }

/* Location:           C:\Users\Jose Antonio\Downloads\GNC-master\GNC-master\GNC\GNC.jar
 * Qualified Name:     Logica.Volcar
 * JD-Core Version:    0.6.2
 */