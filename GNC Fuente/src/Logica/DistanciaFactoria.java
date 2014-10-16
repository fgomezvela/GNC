/*    */ package Logica;
/*    */ 
/*    */ public class DistanciaFactoria
/*    */ {
/* 16 */   private static DistanciaFactoria INSTANCE = null;
/*    */ 
/*    */   private static void createInstance()
/*    */   {
/* 20 */     if (INSTANCE == null)
/*    */     {
/* 22 */       INSTANCE = new DistanciaFactoria();
/*    */     }
/*    */   }
/*    */ 
/*    */   public static DistanciaFactoria getInstance()
/*    */   {
/* 28 */     if (INSTANCE == null)
/*    */     {
/* 30 */       createInstance();
/*    */     }
/*    */ 
/* 33 */     return INSTANCE;
/*    */   }
/*    */ 
/*    */   public IDistancias createGRN(String tipo)
/*    */   {
/* 38 */     if (tipo.compareTo("Floyd") == 0)
/*    */     {
/* 40 */       return new DistFloyd();
/*    */     }
/*    */ 
/* 44 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\Jose Antonio\Downloads\GNC-master\GNC-master\GNC\GNC.jar
 * Qualified Name:     Logica.DistanciaFactoria
 * JD-Core Version:    0.6.2
 */