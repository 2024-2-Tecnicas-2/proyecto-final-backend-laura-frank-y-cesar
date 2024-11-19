package com.mycompany.ajedrez;

import java.util.ArrayList;
import java.util.List;


public class Torre extends Pieza{

    
    public Torre(int x, int y, Jugador propietario) {
        super(x, y, propietario, TipoPieza.torre);
    }

    @Override
    int[][] getMovimientos() {
        int[] posicionActual = getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        List<int[]> movimientos = new ArrayList<>();

        for (int i = x + 1; i < 8 ; i++) {
            movimientos.add(new int[]{i, y});
        }
        for (int i = x - 1; i >= 0; i--) {
            movimientos.add(new int[]{i, y});
        }

        for (int i = 1; i < 8; i++) {
            movimientos.add(new int[]{x, i});
        }

        for (int i = y - 1; i >= 0; i--) {
            movimientos.add(new int[]{x, i});
        }
        return movimientos.toArray(new int[0][0]);
    }
}
