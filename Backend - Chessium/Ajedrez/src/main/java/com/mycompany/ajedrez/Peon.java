package com.mycompany.ajedrez;

import java.util.ArrayList;


public class Peon extends Pieza{

    private boolean movioDoble;
    private boolean primerMovimiento;
    
    public Peon(int x, int y, Jugador propietario) {
        super(x, y, propietario, TipoPieza.peon);
        this.movioDoble = false;
        this.primerMovimiento = true;
    }

    public ArrayList<int[]> validarMovimientosPeon(Pieza pieza) {
    int[] posicionActual = pieza.getPosicion();
    int x = posicionActual[0];
    int y = posicionActual[1];
    ArrayList<int[]> movimientos = new ArrayList<>();
    boolean esBlanco = pieza.getPropietario().esBlancas();

    if (esBlanco) {
        if (y < 7 && !Tablero.casillas[x][y+1].tienePieza()) {
            movimientos.add(new int[]{x, y+1});
        }

        if (y == 1 && !Tablero.casillas[x][y+1].tienePieza() && !Tablero.casillas[x][y+2].tienePieza()) {
            movimientos.add(new int[]{x, y + 2});
        }

        if (y < 7 && x - 1 >= 0) {
            if (Tablero.casillas[x - 1][y + 1].tienePieza() &&
                !Tablero.casillas[x - 1][y + 1].getPieza().getPropietario().equals(pieza.getPropietario())) {
                movimientos.add(new int[]{x - 1, y + 1});
            }
        }

        if (y < 7 && x + 1 <= 8) {
            if (Tablero.casillas[x + 1][y + 1].tienePieza() &&
                !Tablero.casillas[x + 1][y + 1].getPieza().getPropietario().equals(pieza.getPropietario())) {
                movimientos.add(new int[]{x + 1, y + 1});
            }
        }
    } else {
        if (y  > 0 && !Tablero.casillas[x][y - 1].tienePieza()) {
            movimientos.add(new int[]{x, y - 1});
        }

        if (y == 6 && !Tablero.casillas[x][y - 1].tienePieza() && !Tablero.casillas[x][y - 2].tienePieza()) {
            movimientos.add(new int[]{x, y - 2});
        }

        
        if (x > 0 && y - 1 >= 0) {
            if (Tablero.casillas[x - 1][y - 1].tienePieza() &&
                !Tablero.casillas[x - 1][y - 1].getPieza().getPropietario().equals(pieza.getPropietario())) {
                movimientos.add(new int[]{x - 1, y - 1});
            }
        }

        if (x  < 7 && y - 1 >= 0) {
            if (Tablero.casillas[x + 1][y - 1].tienePieza() &&
                !Tablero.casillas[x + 1][y - 1].getPieza().getPropietario().equals(pieza.getPropietario())) {
                movimientos.add(new int[]{x + 1, y - 1});
            }
        }
    }

    return movimientos;
}
}
