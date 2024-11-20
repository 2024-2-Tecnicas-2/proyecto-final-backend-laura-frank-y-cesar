package com.mycompany.ajedrez;

import java.util.ArrayList;
import java.util.List;

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

        boolean esBlanco = super.getPropietario().esBlancas();
        int direccion = esBlanco ? -1 : 1;

        int nuevaX = x + direccion;
        if (nuevaX >= 0 && nuevaX < 8) {

            if (!Tablero.casillas[nuevaX][y].tienePieza()) {
                movimientos.add(new int[]{nuevaX, y});
            }

            if ((esBlanco && x == 6) || (!esBlanco && x == 1)) {
                nuevaX = x + 2 * direccion;
                if (!Tablero.casillas[nuevaX][y].tienePieza()) {
                    movimientos.add(new int[]{nuevaX, y});
                }
            }
        }

        for (int i = -1; i <= 1; i += 2) {
            int nuevaY = y + i;
            if (nuevaY >= 0 && nuevaY < 8) {
                if (nuevaX >= 0 && nuevaX < 8 && Tablero.casillas[nuevaX][nuevaY].tienePieza()) {
                    Pieza piezaAdyacente = Tablero.casillas[nuevaX][nuevaY].getPieza();
                    if (!piezaAdyacente.getPropietario().equals(pieza.getPropietario())) {
                        movimientos.add(new int[]{nuevaX, nuevaY});
                    }
                }
            }
        }

        if (x == 4 && (esBlanco || !esBlanco)) {

            if (y > 0 && Tablero.casillas[x][y - 1].tienePieza()) {
                Pieza piezaIzquierda = Tablero.casillas[x][y - 1].getPieza();
                if (piezaIzquierda.getPropietario().equals(esBlanco ? "negro" : "blanco")
                        && piezaIzquierda.getPosicion()[0] == x && piezaIzquierda.getPosicion()[1] == y - 1) {
                    movimientos.add(new int[]{x + direccion, y - 1});
                }
            }
            if (y < 7 && Tablero.casillas[x][y + 1].tienePieza()) {
                Pieza piezaDerecha = Tablero.casillas[x][y + 1].getPieza();
                if (piezaDerecha.getPropietario().equals(esBlanco ? "negro" : "blanco")
                        && piezaDerecha.getPosicion()[0] == x && piezaDerecha.getPosicion()[1] == y + 1) {
                    movimientos.add(new int[]{x + direccion, y + 1});
                }
            }
        }

        return movimientos;
    }

}
