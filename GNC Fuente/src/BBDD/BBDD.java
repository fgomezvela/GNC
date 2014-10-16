/*    */ package BBDD;
/*    */ 
/*    */ import Pojo.Arista;
/*    */ import Pojo.GRN;
/*    */ import Pojo.Nodo;
/*    */ import java.util.List;
/*    */ 
/*    */ public class BBDD extends GRN
/*    */ {
/*    */   private String nOrganismo;
/*    */ 
/*    */   public BBDD(List<Nodo> listNodos, List<Arista> listAristas, String nOrganismo)
/*    */   {
/* 22 */     super(listNodos, listAristas);
/* 23 */     this.nOrganismo = nOrganismo;
/*    */   }
/*    */ 
/*    */   public String getnOrganismo()
/*    */   {
/* 28 */     return this.nOrganismo;
/*    */   }
/*    */ }

/* Location:           C:\Users\Jose Antonio\Downloads\GNC-master\GNC-master\GNC\GNC.jar
 * Qualified Name:     BBDD.BBDD
 * JD-Core Version:    0.6.2
 */