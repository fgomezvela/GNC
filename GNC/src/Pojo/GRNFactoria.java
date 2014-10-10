/*    */ package Pojo;
/*    */ 
/*    */ import BBDD.BBDD;
/*    */ import Entrada.RedEntrada;
/*    */ import java.util.List;
/*    */ 
/*    */ public class GRNFactoria
/*    */ {
/*    */   public IGRN createGRN(String grn, List<Nodo> listNodos, List<Arista> listAristas, String organismo)
/*    */   {
/* 22 */     if (grn.compareTo("BBDD") == 0)
/*    */     {
/* 24 */       return new BBDD(listNodos, listAristas, organismo);
/*    */     }
/* 26 */     if (grn.compareTo("RedEntrada") == 0)
/*    */     {
/* 28 */       return new RedEntrada(listNodos, listAristas);
/*    */     }
/*    */ 
/* 32 */     return null;
/*    */   }
/*    */ }

/* Location:           C:\Users\Jose Antonio\Downloads\GNC-master\GNC-master\GNC\GNC.jar
 * Qualified Name:     Pojo.GRNFactoria
 * JD-Core Version:    0.6.2
 */