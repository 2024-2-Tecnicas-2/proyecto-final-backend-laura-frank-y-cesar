package com.mycompany.ajedrez;
import java.util.ArrayList;
/**
 *
 * @author frank
 */
public class Caballo extends Pieza {

    public Caballo(int x, int y, Jugador propietario) {
        super(x, y, propietario);
    }

    @Override
    int[][] getMovimientos() {
        int[] posicionActual = getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        
        int[][] posibleMovimiento = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };

        int[][] movimientos = new int[8][2];
        
        for (int i = 0; i < posibleMovimiento.length; i++) {
            movimientos[i][0] = x + posibleMovimiento[i][0];
            movimientos[i][1] = y + posibleMovimiento[i][1];
        }
        
        return movimientos;
    }
  
}
