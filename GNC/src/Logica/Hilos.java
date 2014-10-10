/*    */ package Logica;
/*    */ 
/*    */ import Pojo.LeeGRN;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.IOException;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
/*    */ 
/*    */ public class Hilos extends Thread
/*    */ {
/*    */   private String ruta;
/*    */   private String nOrganismo;
/*    */   private String nombTXT;
/*    */   private String rutaMatrices;
/*    */ 
/*    */   public Hilos(String ruta, String nOrganismo, String nombTXT, String rutaMatrices)
/*    */   {
/* 28 */     this.ruta = ruta;
/* 29 */     this.nOrganismo = nOrganismo;
/* 30 */     this.nombTXT = nombTXT;
/* 31 */     this.rutaMatrices = rutaMatrices;
/*    */   }
/*    */ 
/*    */   public void run()
/*    */   {
/* 36 */     DistanciaFactoria f = DistanciaFactoria.getInstance();
/* 37 */     IDistancias d = f.createGRN("Floyd");
/* 38 */     LeeGRN l = new LeeGRN(this.ruta, this.nOrganismo);
/*    */     try {
/* 40 */       int[][] m = d.distanciaFloyd(l.leerBD(this.ruta, this.nOrganismo));
/* 41 */       Volcar.volcarFichero(m, this.rutaMatrices, this.nombTXT);
/*    */     } catch (FileNotFoundException ex) {
/* 43 */       Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
/*    */     } catch (IOException ex) {
/* 45 */       Logger.getLogger(Hilos.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\Users\Jose Antonio\Downloads\GNC-master\GNC-master\GNC\GNC.jar
 * Qualified Name:     Logica.Hilos
 * JD-Core Version:    0.6.2
 */