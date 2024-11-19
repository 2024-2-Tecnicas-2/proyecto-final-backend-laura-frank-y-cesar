package com.mycompany.ajedrez;

import java.util.ArrayList;
import java.util.List;


public class Torre extends Pieza{

    
    public Torre(int x, int y, Jugador propietario) {
        super(x, y, propietario, TipoPieza.torre);
    }

    public ArrayList validarMovimientosTorre(Pieza pieza) {
        int[] posicionActual = pieza.getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        ArrayList<int[]> movimientos = new ArrayList<>();

        for (int i = x + 1; i < 8; i++) {
            if (!Tablero.casillas[i][y].tienePieza()) {

                movimientos.add(new int[]{i, y});
            } else {
                if (!Tablero.casillas[i][y].getPieza().getPropietario().equals(Tablero.jugActual)) {
                    movimientos.add(new int[]{i, y});
                }
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if (!Tablero.casillas[i][y].tienePieza()) {
                movimientos.add(new int[]{i, y});
            } else {
                if (!Tablero.casillas[i][y].getPieza().getPropietario().equals(Tablero.jugActual)) {
                    movimientos.add(new int[]{i, y});
                }
                break;
            }
        }
        for (int i = y + 1; i < 8; i++) {
            if (!Tablero.casillas[x][i].tienePieza()) {
                movimientos.add(new int[]{x, i});
            } else {
                if (!Tablero.casillas[x][i].getPieza().getPropietario().equals(Tablero.jugActual)) {
                    movimientos.add(new int[]{x, i});
                }
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (!Tablero.casillas[x][i].tienePieza()) {
                movimientos.add(new int[]{x, i});
            } else {
                if (!Tablero.casillas[x][i].getPieza().getPropietario().equals(Tablero.jugActual)) {
                    movimientos.add(new int[]{x, i});
                }
                break;
            }
        }
        return movimientos;
    }

}
