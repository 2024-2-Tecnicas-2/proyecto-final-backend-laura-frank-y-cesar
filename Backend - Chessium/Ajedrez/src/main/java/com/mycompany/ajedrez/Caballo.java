package com.mycompany.ajedrez;
import java.util.ArrayList;
import java.util.List;

public class Caballo extends Pieza {

    public Caballo(int x, int y, Jugador propietario) {
        super(x, y, propietario, TipoPieza.caballo);
    }

    @Override
    int[][] getMovimientos() {
        int[] posicionActual = getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        List<int[]> movimientos = new ArrayList<>();
        
        int[][] posibleMovimiento = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };

        
        for (int i = 0; i < posibleMovimiento.length; i++) {
            if(x + posibleMovimiento[i][0] < 8 && x + posibleMovimiento[i][0] >= 0 && y + posibleMovimiento[i][1] < 8 && y + posibleMovimiento[i][1] >= 0)
                movimientos.add(new int[]{x + posibleMovimiento[i][0], y + posibleMovimiento[i][1]});
        }
        return movimientos.toArray(new int[0][0]);
    }
  
}
