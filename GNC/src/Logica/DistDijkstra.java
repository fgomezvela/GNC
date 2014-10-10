/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import Pojo.Arista;
/*     */ import Pojo.IGRN;
/*     */ import Pojo.Nodo;
import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;

/**
 *
 * @author JoseAntonio
 */
public class DistDijkstra implements IDistancias{

    @Override
    public int[][] distanciaDijkstra(IGRN grn) {
        
    int[][] m = new int[grn.getListNodos().size()][grn.getListNodos().size()];
   
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m.length; j++) {
                m[i][j] = Costantes.infinito;             
            }
            m[i][i] = 0;
            List<Nodo> q = grn.getListNodos();
            while(!q.isEmpty()){                              
                Iterator it = q.iterator();
                Nodo u = (Nodo)it.next(); 
                int indice = q.indexOf(u);
                if (m[i][indice] == Costantes.infinito) {
                    break;
                }
                q.remove(u);
                
                List<Nodo> vecinos = buscarVecinos(u.getIdAristas());
                for (int l = 0; l < vecinos.size(); l++) {
                    int alt = (m[i][indice] + m[i][indice+1]);
                    if (alt < m[i][indice+1]) {
                        m[i][indice+1] = alt;
                    }                  
                }                
            }        
        }    
        return m;
    }

    @Override
    public int[][] distanciaFloyd(IGRN paramIGRN) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List<Nodo> buscarVecinos(List<Integer> idAristas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
