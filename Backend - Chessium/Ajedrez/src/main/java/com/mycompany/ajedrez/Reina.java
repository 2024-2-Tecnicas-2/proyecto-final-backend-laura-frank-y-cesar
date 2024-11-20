package com.mycompany.ajedrez;

import java.util.ArrayList;

public class Reina extends Pieza{

    public Reina(int x, int y, Jugador propietario) {
        super(x, y, propietario, TipoPieza.reina);
    }

    public ArrayList<int[]> validarMovimientosReina(Pieza pieza) {
        int[] posicionActual = pieza.getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        ArrayList<int[]> movimientos = new ArrayList<>();

        for (int i = x + 1; i < 8; i++) {
            if (!Tablero.casillas[i][y].tienePieza()) {
                movimientos.add(new int[]{i, y});
            } else {
                if (!Tablero.casillas[i][y].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{i, y});
                }
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if (!Tablero.casillas[i][y].tienePieza()) {
                movimientos.add(new int[]{i, y});
            } else {
                if (!Tablero.casillas[i][y].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{i, y});
                }
                break;
            }
        }
        for (int i = y + 1; i < 8; i++) {
            if (!Tablero.casillas[x][i].tienePieza()) {
                movimientos.add(new int[]{x, i});
            } else {
                if (!Tablero.casillas[x][i].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{x, i});
                }
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (!Tablero.casillas[x][i].tienePieza()) {
                movimientos.add(new int[]{x, i});
            } else {
                if (!Tablero.casillas[x][i].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{x, i});
                }
                break;
            }
        }

        for (int i = 1; x + i < 8 && y + i < 8; i++) {
            if (!Tablero.casillas[x + i][y + i].tienePieza()) {
                movimientos.add(new int[]{x + i, y + i});
            } else {
                if (!Tablero.casillas[x + i][y + i].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{x + i, y + i});
                }
                break;
            }
        }
        for (int i = 1; x - i >= 0 && y + i < 8; i++) {
            if (!Tablero.casillas[x - i][y + i].tienePieza()) {
                movimientos.add(new int[]{x - i, y + i});
            } else {
                if (!Tablero.casillas[x - i][y + i].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{x - i, y + i});
                }
                break;
            }
        }
        for (int i = 1; x + i < 8 && y - i >= 0; i++) {
            if (!Tablero.casillas[x + i][y - i].tienePieza()) {
                movimientos.add(new int[]{x + i, y - i});
            } else {
                if (!Tablero.casillas[x + i][y - i].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{x + i, y - i});
                }
                break;
            }
        }
        for (int i = 1; x - i >= 0 && y - i >= 0; i++) {
            if (!Tablero.casillas[x - i][y - i].tienePieza()) {
                movimientos.add(new int[]{x - i, y - i});
            } else {
                if (!Tablero.casillas[x - i][y - i].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{x - i, y - i});
                }
                break;
            }
        }

        return movimientos;
    }
}
