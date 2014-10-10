/*    */ package Logica;
/*    */ 
/*    */ public class Posicion
/*    */ {
/*    */   int posicionReal;
/*    */   String nombreNodo;
/*    */ 
/*    */   public Posicion(int posicionReal, String nombreNodo)
/*    */   {
/* 16 */     this.posicionReal = posicionReal;
/* 17 */     this.nombreNodo = nombreNodo;
/*    */   }
/*    */ 
/*    */   public String getNombreNodo() {
/* 21 */     return this.nombreNodo;
/*    */   }
/*    */ 
/*    */   public void setNombreNodo(String nombreNodo) {
/* 25 */     this.nombreNodo = nombreNodo;
/*    */   }
/*    */ 
/*    */   public int getPosicionReal() {
/* 29 */     return this.posicionReal;
/*    */   }
/*    */ 
/*    */   public void setPosicionReal(int posicionReal) {
/* 33 */     this.posicionReal = posicionReal;
/*    */   }
/*    */ }

/* Location:           C:\Users\Jose Antonio\Downloads\GNC-master\GNC-master\GNC\GNC.jar
 * Qualified Name:     Logica.Posicion
 * JD-Core Version:    0.6.2
 */