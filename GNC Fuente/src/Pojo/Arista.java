/*    */ package Pojo;
/*    */ 
/*    */ public class Arista
/*    */ {
/*    */   private String origen;
/*    */   private String destino;
/*    */   private int idArista;
/*    */ 
/*    */   public Arista(String origen, String destino, int idArista)
/*    */   {
/* 19 */     this.origen = origen;
/* 20 */     this.destino = destino;
/* 21 */     this.idArista = idArista;
/*    */   }
/*    */ 
/*    */   public Arista(String origen, String destino) {
/* 25 */     this.origen = origen;
/* 26 */     this.destino = destino;
/*    */   }
/*    */ 
/*    */   public String getDestino()
/*    */   {
/* 31 */     return this.destino;
/*    */   }
/*    */ 
/*    */   public int getIdArista()
/*    */   {
/* 36 */     return this.idArista;
/*    */   }
/*    */ 
/*    */   public void setOrigen(String origen) {
/* 40 */     this.origen = origen;
/*    */   }
/*    */ 
/*    */   public void setDestino(String destino) {
/* 44 */     this.destino = destino;
/*    */   }
/*    */ 
/*    */   public String getOrigen()
/*    */   {
/* 49 */     return this.origen;
/*    */   }
/*    */ }

/* Location:           C:\Users\Jose Antonio\Downloads\GNC-master\GNC-master\GNC\GNC.jar
 * Qualified Name:     Pojo.Arista
 * JD-Core Version:    0.6.2
 */