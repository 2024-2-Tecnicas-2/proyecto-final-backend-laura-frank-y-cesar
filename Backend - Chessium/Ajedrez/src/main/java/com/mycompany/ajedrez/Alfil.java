package com.mycompany.ajedrez;
import java.util.ArrayList;

public class Alfil extends Pieza{

    public Alfil(int x, int y, Jugador propietario) {
        super(x, y, propietario, TipoPieza.alfil);
    }
    
    public ArrayList<int[]> validarMovimientosAlfil(Pieza pieza) {
        int[] posicionActual = pieza.getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        ArrayList<int[]> movimientos = new ArrayList<>();

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
