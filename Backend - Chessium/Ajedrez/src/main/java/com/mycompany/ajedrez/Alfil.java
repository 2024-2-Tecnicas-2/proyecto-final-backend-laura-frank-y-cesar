package com.mycompany.ajedrez;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frank
 */
public class Alfil extends Pieza{

    public Alfil(int x, int y, Jugador propietario) {
        super(x, y, propietario);
    }
 
    @Override
    int[][] getMovimientos() {
        int[] posicionActual = getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        List<int[]> movimientos = new ArrayList<>();
        
        int l = 1;
        while (x + l <= 7 && y + l <= 7) {
            movimientos.add(new int[]{x + l, y + l});
            l++;
        }

        int k = 1;
            while (x + k <= 7 && y - k >= 0) {
            movimientos.add(new int[]{x + k, y - k});
            k++;
        }

        int h = 1;
            while (h < 8 && x - h >= 0 && y + h <= 7)  {
            movimientos.add(new int[]{x - h, y + h});
            h++;
        }
        
        int j = 1;
        while (x - j >= 0 && y - j >= 0) {
            movimientos.add(new int[]{x - j, y - j});
            j++;
        }
        
        return movimientos.toArray(new int[0][0]);
    } 
}
