/*     */ package Logica;
/*     */ 
/*     */ import Pojo.Arista;
/*     */ import Pojo.IGRN;
/*     */ import Pojo.Nodo;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
import vista.VentanaPrincipal;
/*     */ 
/*     */ public class DistFloyd extends Thread
/*     */   implements IDistancias
/*     */ {
/*     */   public int[][] distanciaFloyd(IGRN grn)
/*     */   {
/*  23 */     int[][] path = calculaMatrizAdy(grn);
/*     */ 
/*  25 */     int cn = grn.getListNodos().size();
/*     */ 
/*  27 */     for (int k = 0; k < cn; k++)
/*     */     {
/*  29 */       for (int i = 0; i < cn; i++)
/*     */       {
/*  31 */         for (int j = 0; j < cn; j++)
/*     */         {
/*  33 */           int dt = path[i][k] + path[k][j];
/*     */ 
/*  35 */           if (path[i][j] > dt)
/*     */           {
/*  37 */             path[i][j] = dt;
/*     */           }
/*     */         }
/*     */       }
/*     */     }
/*     */ 
/*  43 */     return path;
/*     */   }
/*     */ 
/*     */   public int[][] calculaMatrizAdy(IGRN grn)
/*     */   {
/*  49 */     int[][] m = new int[grn.getListNodos().size()][grn.getListNodos().size()];
/*     */ 
/*  52 */     for (int i = 0; i < grn.getListNodos().size(); i++)
/*     */     {
/*  55 */       List vecinos = new ArrayList();
/*     */ 
/*  58 */       for (int k = 0; k < ((Nodo)grn.getListNodos().get(i)).getIdAristas().size(); k++)
/*     */       {
/*  60 */         if (((Arista)grn.getListAristas().get(((Integer)((Nodo)grn.getListNodos().get(i)).getIdAristas().get(k)).intValue() - 1)).getDestino().compareToIgnoreCase(((Nodo)grn.getListNodos().get(i)).getNombre()) == 0)
/*     */         {
/*  62 */           vecinos.add(((Arista)grn.getListAristas().get(((Integer)((Nodo)grn.getListNodos().get(i)).getIdAristas().get(k)).intValue() - 1)).getOrigen());
/*     */         }
/*     */         else
/*     */         {
/*  66 */           vecinos.add(((Arista)grn.getListAristas().get(((Integer)((Nodo)grn.getListNodos().get(i)).getIdAristas().get(k)).intValue() - 1)).getDestino());
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*  71 */       for (int j = 0; j < grn.getListNodos().size(); j++)
/*     */       {
/*  74 */         if (i == j)
/*     */         {
/*  76 */           m[i][j] = Costantes.mismo;
/*     */         }
/*  81 */         else if (vecinos.contains(((Nodo)grn.getListNodos().get(j)).getNombre()))
/*     */         {
/*  83 */           m[i][j] = Costantes.vecino;
/*     */         }
/*     */         else
/*     */         {
/*  88 */           m[i][j] = Costantes.infinito;
/*     */         }
/*     */ 
/*     */       }
/*     */ 
/*  94 */       vecinos.clear();
/*     */     }
/*     */ 
/*  97 */     return m;
/*     */   }
/*     */ 
/*     */  
/*     */

    @Override
    public int[][] distanciaDijkstra(IGRN paramIGRN) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[][] distanciaFloyd(IGRN grn, VentanaPrincipal padre) {
        int[][] path = calculaMatrizAdy(grn);
/*     */ 
/*  25 */     int cn = grn.getListNodos().size();
/*     */     int cont = 0;
/*  27 */     for (int k = 0; k < cn; k++)
/*     */     {
/*  29 */       for (int i = 0; i < cn; i++)
/*     */       {
/*  31 */         for (int j = 0; j < cn; j++)
/*     */         {
/*  33 */           int dt = path[i][k] + path[k][j];
/*     */ 
/*  35 */           if (path[i][j] > dt)
/*     */           {
/*  37 */             path[i][j] = dt;
/*     */           }
/*     */         }
/*     */       }
                if((k%8)==0){ 
                    padre.getLog().writeLog(".",false);
                    cont++;                    
                    if (cont > 0 && (cont % 250) == 0) {
                         padre.getLog().writeLog("\n",false);
                    }
                }        
              }
/*     */ 
/*  43 */     return path;
    }
 }
