package Logica;

import Pojo.IGRN;

public abstract interface IDistancias
{
  public abstract int[][] distanciaDijkstra(IGRN paramIGRN);

  public abstract int[][] distanciaFloyd(IGRN paramIGRN);
}

