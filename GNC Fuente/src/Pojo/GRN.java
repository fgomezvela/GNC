/*    */ package Pojo;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashSet;
/*    */ import java.util.List;
/*    */ 
/*    */ public class GRN
/*    */   implements IGRN
/*    */ {
/* 20 */   private List<Nodo> listNodos = new ArrayList();
/* 21 */   private List<Arista> listAristas = new ArrayList();
/* 22 */   private HashSet<String> nodos = new HashSet();
/* 23 */   private HashSet<Arista> aristas = new HashSet();
/*    */ 
/*    */   public GRN() {
/*    */   }
/*    */ 
/*    */   public HashSet<String> getNodos() {
/* 29 */     return this.nodos;
/*    */   }
/*    */ 
/*    */   public void setNodos(HashSet<String> nodos) {
/* 33 */     this.nodos = nodos;
/*    */   }
/*    */ 
/*    */   public HashSet<Arista> getAristas() {
/* 37 */     return this.aristas;
/*    */   }
/*    */ 
/*    */   public void setAristas(HashSet<Arista> aristas) {
/* 41 */     this.aristas = aristas;
/*    */   }
/*    */ 
/*    */   public GRN(List<Nodo> listNodos, List<Arista> listAristas) {
/* 45 */     this.listNodos = listNodos;
/* 46 */     this.listAristas = listAristas;
/*    */   }
/*    */ 
/*    */   public List<Arista> getListAristas()
/*    */   {
/* 51 */     return this.listAristas;
/*    */   }
/*    */ 
/*    */   public void setListAristas(List<Arista> listAristas)
/*    */   {
/* 56 */     this.listAristas = listAristas;
/*    */   }
/*    */ 
/*    */   public List<Nodo> getListNodos()
/*    */   {
/* 61 */     return this.listNodos;
/*    */   }
/*    */ 
/*    */   public void setListNodos(List<Nodo> listNodos)
/*    */   {
/* 66 */     this.listNodos = listNodos;
/*    */   }
/*    */ 
/*    */   public void addArista(Arista a)
/*    */   {
/* 71 */     this.listAristas.add(a);
/*    */   }
/*    */ 
/*    */   public void addNodo(Nodo n)
/*    */   {
/* 76 */     this.listNodos.add(n);
/*    */   }
/*    */ 
/*    */   public Nodo buscarNombre(String nombre)
/*    */   {
/* 81 */     Nodo aux = null;
/* 82 */     for (int i = 0; i < this.listNodos.size(); i++) {
/* 83 */       if (nombre.compareToIgnoreCase(((Nodo)this.listNodos.get(i)).getNombre()) == 0) {
/* 84 */         aux = (Nodo)this.listNodos.get(i);
/*    */       }
/*    */     }
/* 87 */     return aux;
/*    */   }
/*    */ }

/* Location:           C:\Users\Jose Antonio\Downloads\GNC-master\GNC-master\GNC\GNC.jar
 * Qualified Name:     Pojo.GRN
 * JD-Core Version:    0.6.2
 */