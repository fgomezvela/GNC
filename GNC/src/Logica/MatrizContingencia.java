/*    */ package Logica;
/*    */ 
/*    */ public class MatrizContingencia
/*    */ {
/*    */   private double puntoCorte;
/* 14 */   private float TP = 0.0F;
/* 15 */   private float TN = 0.0F;
/* 16 */   private float FP = 0.0F;
/* 17 */   private float FN = 0.0F;
/*    */ 
/*    */   public MatrizContingencia(double puntoCorte) {
/* 20 */     this.puntoCorte = puntoCorte;
/*    */   }
/*    */ 
/*    */   public MatrizContingencia() {
/*    */   }
/*    */ 
/*    */   public double getPuntoCorte() {
/* 27 */     return this.puntoCorte;
/*    */   }
/*    */ 
/*    */   public void setPuntoCorte(double puntoCorte) {
/* 31 */     this.puntoCorte = puntoCorte;
/*    */   }
/*    */ 
/*    */   public float getTP() {
/* 35 */     return this.TP;
/*    */   }
/*    */ 
/*    */   public void setTP(float TP) {
/* 39 */     this.TP = TP;
/*    */   }
/*    */ 
/*    */   public float getTN() {
/* 43 */     return this.TN;
/*    */   }
/*    */ 
/*    */   public void setTN(float TN) {
/* 47 */     this.TN = TN;
/*    */   }
/*    */ 
/*    */   public float getFP() {
/* 51 */     return this.FP;
/*    */   }
/*    */ 
/*    */   public void setFP(float FP) {
/* 55 */     this.FP = FP;
/*    */   }
/*    */ 
/*    */   public float getFN() {
/* 59 */     return this.FN;
/*    */   }
/*    */ 
/*    */   public void setFN(float FN) {
/* 63 */     this.FN = FN;
/*    */   }
/*    */ 
/*    */   public float calculaTruePositiveRate() {
/* 67 */     return this.TP / (this.TP + this.FN);
/*    */   }
/*    */ 
/*    */   public float calculaFalsePositiveRate() {
/* 71 */     return this.FP / (this.FP + this.TN);
/*    */   }
/*    */ 
/*    */   public void incrementaTN() {
/* 75 */     this.TN += 1.0F;
/*    */   }
/*    */ 
/*    */   public void incrementaTP() {
/* 79 */     this.TP += 1.0F;
/*    */   }
/*    */ 
/*    */   public void incrementaFP() {
/* 83 */     this.FP += 1.0F;
/*    */   }
/*    */ 
/*    */   public void incrementaFN() {
/* 87 */     this.FN += 1.0F;
/*    */   }
/*    */ }

/* Location:           C:\Users\Jose Antonio\Downloads\GNC-master\GNC-master\GNC\GNC.jar
 * Qualified Name:     Logica.MatrizContingencia
 * JD-Core Version:    0.6.2
 */