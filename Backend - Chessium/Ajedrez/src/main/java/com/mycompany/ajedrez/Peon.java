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

    public boolean isMovioDoble() {
        return movioDoble;
    }

    public void setMovioDoble(boolean movioDoble) {
        this.movioDoble = movioDoble;
    }

    public ArrayList<int[]> validarMovimientosPeon(Pieza pieza) {
        int[] posicionActual = pieza.getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        ArrayList<int[]> movimientos = new ArrayList<>();

        if (pieza.getPropietario().esBlancas()) {

            if (x + 1 < 8) {
                if (!Tablero.casillas[x + 1][y].tienePieza()) {
                    movimientos.add(new int[]{x + 1, y});
                }
            }

            if (x == 1) {
                if (!Tablero.casillas[x + 1][y].tienePieza() && !Tablero.casillas[x + 2][y].tienePieza()) {
                    movimientos.add(new int[]{x + 2, y});
                }
            }

            if (y - 1 >= 0 && x + 1 < 8) {
                if (Tablero.casillas[x + 1][y - 1].tienePieza()
                        && !Tablero.casillas[x + 1][y - 1].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{x + 1, y - 1});
                }
            }

            if (y + 1 < 8 && x + 1 < 8) {
                if (Tablero.casillas[x + 1][y + 1].tienePieza()
                        && !Tablero.casillas[x + 1][y + 1].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{x + 1, y + 1});
                }
            }
        } else if (!pieza.getPropietario().esBlancas()) {

            if (x - 1 >= 0) {
                if (!Tablero.casillas[x - 1][y].tienePieza()) {
                    movimientos.add(new int[]{x - 1, y});
                }
            }

            if (x == 6) {
                if (!Tablero.casillas[x - 1][y].tienePieza() && !Tablero.casillas[x - 2][y].tienePieza()) {
                    movimientos.add(new int[]{x - 2, y});
                }
            }

            if (y - 1 >= 0 && x - 1 >= 0) {
                if (Tablero.casillas[x - 1][y - 1].tienePieza()
                        && !Tablero.casillas[x - 1][y - 1].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{x - 1, y - 1});
                }
            }

            if (y + 1 < 8 && x - 1 >= 0) {
                if (Tablero.casillas[x - 1][y + 1].tienePieza()
                        && !Tablero.casillas[x - 1][y + 1].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{x - 1, y + 1});
                }
            }
        }

        return movimientos;
    }
}
