
package com.mycompany.ajedrez;

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
        int[][] movimientos = new int[28][2];
        int con = 0;
        
        for (int i = 1; i < 8; i++) {
        movimientos[con][0] = x + i;
        movimientos[con][1] = y + i;
        con++;
        }

        for (int i = 1; i < 8; i++) {
        movimientos[con][0] = x + i;
        movimientos[con][1] = y - i;
        con++;
        }

        for (int i = 1; i < 8; i++) {
        movimientos[con][0] = x - i;
        movimientos[con][1] = y + i;
        con++;
        }

        for (int i = 1; i < 8; i++) {
        movimientos[con][0] = x - i;
        movimientos[con][1] = y - i;
        con++;
        }
        
        return movimientos;
    } 
}