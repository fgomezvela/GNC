package Pojo;

import java.util.List;

public abstract interface IGRN
{
  public abstract void addArista(Arista paramArista);

  public abstract void addNodo(Nodo paramNodo);

  public abstract List<Arista> getListAristas();

  public abstract List<Nodo> getListNodos();

  public abstract void setListAristas(List<Arista> paramList);

  public abstract void setListNodos(List<Nodo> paramList);

  public abstract Nodo buscarNombre(String paramString);
}

/* Location:           C:\Users\Jose Antonio\Downloads\GNC-master\GNC-master\GNC\GNC.jar
 * Qualified Name:     Pojo.IGRN
 * JD-Core Version:    0.6.2
 */