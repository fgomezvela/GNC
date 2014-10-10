/*    */ package Pojo;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ 
/*    */ public class Nodo
/*    */ {
/*    */   private String nombre;
/* 18 */   private List<Integer> idAristas = new ArrayList();
/*    */ 
/*    */   public Nodo(String nombre, List<Integer> idAristas)
/*    */   {
/* 22 */     this.nombre = nombre;
/* 23 */     this.idAristas = idAristas;
/*    */   }
/*    */ 
/*    */   public Nodo(String nombre)
/*    */   {
/* 28 */     this.nombre = nombre;
/*    */   }
/*    */ 
/*    */   public List<Integer> getIdAristas()
/*    */   {
/* 33 */     return this.idAristas;
/*    */   }
/*    */ 
/*    */   public void setIdAristas(List<Integer> idAristas)
/*    */   {
/* 38 */     this.idAristas = idAristas;
/*    */   }
/*    */ 
/*    */   public String getNombre() {
/* 42 */     return this.nombre;
/*    */   }
/*    */ 
/*    */   public void setNombre(String nombre)
/*    */   {
/* 47 */     this.nombre = nombre;
/*    */   }
/*    */ 
/*    */   public int[] cambiar(List<Integer> idAristas)
/*    */   {
/* 52 */     int[] aux = null;
/*    */ 
/* 54 */     for (int i = 0; i < idAristas.size(); i++)
/*    */     {
/* 56 */       aux[i] = ((Integer)idAristas.get(i)).intValue();
/*    */     }
/*    */ 
/* 59 */     return aux;
/*    */   }
/*    */ 
/*    */   public boolean equals(Object obj)
/*    */   {
/* 65 */     if (obj == null)
/*    */     {
/* 67 */       return false;
/*    */     }
/* 69 */     if (getClass() != obj.getClass())
/*    */     {
/* 71 */       return false;
/*    */     }
/*    */ 
/* 74 */     Nodo other = (Nodo)obj;
/*    */ 
/* 76 */     if (this.nombre == null ? other.nombre != null : !this.nombre.equals(other.nombre))
/*    */     {
/* 78 */       return false;
/*    */     }
/* 80 */     if ((this.idAristas != other.idAristas) && ((this.idAristas == null) || (!this.idAristas.equals(other.idAristas))))
/*    */     {
/* 82 */       return false;
/*    */     }
/*    */ 
/* 85 */     return true;
/*    */   }
/*    */ 
/*    */   public int hashCode()
/*    */   {
/* 91 */     int hash = 7;
/* 92 */     hash = 59 * hash + (this.nombre != null ? this.nombre.hashCode() : 0);
/* 93 */     return hash;
/*    */   }
/*    */ 
/*    */   public void addId(Integer in)
/*    */   {
/* 98 */     this.idAristas.add(in);
/*    */   }
/*    */ }

/* Location:           C:\Users\Jose Antonio\Downloads\GNC-master\GNC-master\GNC\GNC.jar
 * Qualified Name:     Pojo.Nodo
 * JD-Core Version:    0.6.2
 */