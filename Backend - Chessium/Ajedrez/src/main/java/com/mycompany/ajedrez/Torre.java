package com.mycompany.ajedrez;


public class Torre extends Pieza{

    public Torre(int x, int y, Jugador propietario) {
        super(x, y, propietario);
    }

    @Override
    int[][] getMovimientos() {
        int[] posicionActual = getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        int[][] movimientos = new int[28][2];
        int con = 0;

        for (int i = x + 1; i < 8; i++) {
            movimientos[con][0] = i;
            movimientos[con][1] = y;
            con++;
        }

        for (int i = x - 1; i >= 0; i--) {
            movimientos[con][0] = i;
            movimientos[con][1] = y;
            con++;
        }

        for (int i = 1; i < 8; i++) {
            movimientos[con][0] = x;
            movimientos[con][1] = y + i;
            con++;
        }

        for (int i = y - 1; i >= 0; i--) {
            movimientos[con][0] = x;
            movimientos[con][1] = i;
            con++;
        }

        return movimientos;
    }

}
