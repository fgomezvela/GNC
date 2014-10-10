/*     */ package Logica;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Objects;
/*     */ 
/*     */ public class Tupla
/*     */ {
/*     */   public String baseDatos;
/*     */   public String input;
/*     */   public float coherencia;
/*     */   private List<Float> coherenciaRandomsPuras;
/*     */   private List<Float> coherenciaRandomsSF;
/*     */   private int numNodos;
/*     */   private int numAristas;
/*     */ 
/*     */   public Tupla(String baseDatos, String input, float coherencia, int numNodos, int numAristas)
/*     */   {
/*  25 */     this.baseDatos = baseDatos;
/*  26 */     this.input = input;
/*  27 */     this.coherencia = coherencia;
/*  28 */     this.coherenciaRandomsSF = new ArrayList();
/*  29 */     this.coherenciaRandomsPuras = new ArrayList();
/*  30 */     this.numNodos = numNodos;
/*  31 */     this.numAristas = numAristas;
/*     */   }
/*     */ 
/*     */   public int getNumNodos() {
/*  35 */     return this.numNodos;
/*     */   }
/*     */ 
/*     */   public void setNumNodos(int numNodos) {
/*  39 */     this.numNodos = numNodos;
/*     */   }
/*     */ 
/*     */   public int getNumAristas() {
/*  43 */     return this.numAristas;
/*     */   }
/*     */ 
/*     */   public void setNumAristas(int numAristas) {
/*  47 */     this.numAristas = numAristas;
/*     */   }
/*     */ 
/*     */   public List<Float> getCoherenciaRandomsPuras() {
/*  51 */     return this.coherenciaRandomsPuras;
/*     */   }
/*     */ 
/*     */   public void setCoherenciaRandomsPuras(List<Float> coherenciaRandomsPuras) {
/*  55 */     this.coherenciaRandomsPuras = coherenciaRandomsPuras;
/*     */   }
/*     */ 
/*     */   public List<Float> getCoherenciaRandomsSF() {
/*  59 */     return this.coherenciaRandomsSF;
/*     */   }
/*     */ 
/*     */   public void setCoherenciaRandomsSF(List<Float> coherenciaRandomsSF) {
/*  63 */     this.coherenciaRandomsSF = coherenciaRandomsSF;
/*     */   }
/*     */   public String getBaseDatos() {
/*  66 */     return this.baseDatos;
/*     */   }
/*     */ 
/*     */   public void setBaseDatos(String baseDatos) {
/*  70 */     this.baseDatos = baseDatos;
/*     */   }
/*     */ 
/*     */   public String getInput() {
/*  74 */     return this.input;
/*     */   }
/*     */ 
/*     */   public void setInput(String input) {
/*  78 */     this.input = input;
/*     */   }
/*     */ 
/*     */   public float getCoherencia() {
/*  82 */     return this.coherencia;
/*     */   }
/*     */ 
/*     */   public void setCoherencia(float coherencia) {
/*  86 */     this.coherencia = coherencia;
/*     */   }
/*     */ 
/*     */   public int hashCode()
/*     */   {
/*  91 */     int hash = 5;
/*  92 */     hash = 89 * hash + Objects.hashCode(this.baseDatos);
/*  93 */     hash = 89 * hash + Objects.hashCode(this.input);
/*  94 */     hash = 89 * hash + Float.floatToIntBits(this.coherencia);
/*  95 */     return hash;
/*     */   }
/*     */ 
/*     */   public boolean equals(Object obj)
/*     */   {
/* 100 */     if (obj == null) {
/* 101 */       return false;
/*     */     }
/* 103 */     if (getClass() != obj.getClass()) {
/* 104 */       return false;
/*     */     }
/* 106 */     Tupla other = (Tupla)obj;
/* 107 */     if (!Objects.equals(this.baseDatos, other.baseDatos)) {
/* 108 */       return false;
/*     */     }
/* 110 */     return true;
/*     */   }
/*     */ 
/*     */   public String toString()
/*     */   {
/* 115 */     String coe = String.format("%.4f", new Object[] { Float.valueOf(this.coherencia) });
/* 116 */     return this.baseDatos + "_" + this.input + "_" + coe;
/*     */   }
/*     */ }

/* Location:           C:\Users\Jose Antonio\Downloads\GNC-master\GNC-master\GNC\GNC.jar
 * Qualified Name:     Logica.Tupla
 * JD-Core Version:    0.6.2
 */