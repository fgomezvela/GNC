package Logica;

import Pojo.IGRN;
import vista.VentanaPrincipal;

public abstract interface IDistancias
{
  public abstract int[][] distanciaDijkstra(IGRN paramIGRN);

  public abstract int[][] distanciaFloyd(IGRN paramIGRN);

    public int[][] distanciaFloyd(IGRN grnEntrada, VentanaPrincipal padre);
}

