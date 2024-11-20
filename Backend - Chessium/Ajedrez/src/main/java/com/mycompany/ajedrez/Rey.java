package com.mycompany.ajedrez;

import java.util.ArrayList;

public class Rey extends Pieza {

    public Rey(int x, int y, Jugador propietario) {
        super(x, y, propietario, TipoPieza.rey);
    }

    public ArrayList<int[]> validarMovimientosRey(Pieza pieza) {
        int[] posicionActual = pieza.getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        ArrayList<int[]> movimientos = new ArrayList<>();

        int[][] posiblesMovimientos = {
            {-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}
        };

        for (int[] movimiento : posiblesMovimientos) {
            int nuevaX = x + movimiento[0];
            int nuevaY = y + movimiento[1];

            if (nuevaX >= 0 && nuevaX < 8 && nuevaY >= 0 && nuevaY < 8) {

                if (!Tablero.casillas[nuevaX][nuevaY].tienePieza()
                        || !Tablero.casillas[nuevaX][nuevaY].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{nuevaX, nuevaY});
                }
            }
        }

        return movimientos;
    }

}
