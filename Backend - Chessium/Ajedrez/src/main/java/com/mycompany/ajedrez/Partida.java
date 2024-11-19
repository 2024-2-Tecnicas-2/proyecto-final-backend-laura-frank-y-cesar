package com.mycompany.ajedrez;

import java.util.ArrayList;
import java.util.List;

public class Partida {

    private final Tablero tablero;
    private final Jugador jugBlancas;
    private final Jugador jugNegras;
    private Jugador jugActual;

    public Partida() {
        this.tablero = new Tablero();
        this.jugBlancas = new Jugador(true);
        this.jugNegras = new Jugador(false);
        iniciarPartida();
    }

    public void iniciarPartida() {
        for (int i = 0; i < 8; i++) {
            Peon peon = new Peon(i, 1, jugBlancas);
            tablero.obtenerCasilla(1, i).colocarPieza(peon);
        }
        for (int i = 0; i < 8; i++) {
            Peon peon = new Peon(i, 6, jugNegras);
            tablero.obtenerCasilla(i, 6).colocarPieza(peon);
        }
        Torre torre1 = new Torre(0, 0, jugBlancas);
        Torre torre2 = new Torre(7, 0, jugBlancas);
        Torre torre3 = new Torre(0, 7, jugNegras);
        Torre torre4 = new Torre(7, 7, jugNegras);
        tablero.obtenerCasilla(0, 0).colocarPieza(torre1);
        tablero.obtenerCasilla(7, 0).colocarPieza(torre2);
        tablero.obtenerCasilla(0, 7).colocarPieza(torre3);
        tablero.obtenerCasilla(7, 7).colocarPieza(torre4);

        Caballo caballo1 = new Caballo(1, 0, jugBlancas);
        Caballo caballo2 = new Caballo(6, 0, jugBlancas);
        Caballo caballo3 = new Caballo(1, 7, jugNegras);
        Caballo caballo4 = new Caballo(6, 7, jugNegras);
        tablero.obtenerCasilla(1, 0).colocarPieza(caballo1);
        tablero.obtenerCasilla(6, 0).colocarPieza(caballo2);
        tablero.obtenerCasilla(1, 7).colocarPieza(caballo3);
        tablero.obtenerCasilla(6, 7).colocarPieza(caballo4);

        Alfil alfil1 = new Alfil(2, 0, jugBlancas);
        Alfil alfil2 = new Alfil(5, 0, jugBlancas);
        Alfil alfil3 = new Alfil(2, 7, jugNegras);
        Alfil alfil4 = new Alfil(5, 7, jugNegras);
        tablero.obtenerCasilla(2, 0).colocarPieza(alfil1);
        tablero.obtenerCasilla(5, 0).colocarPieza(alfil2);
        tablero.obtenerCasilla(2, 7).colocarPieza(alfil3);
        tablero.obtenerCasilla(5, 7).colocarPieza(alfil4);

        Rey rey1 = new Rey(4, 0, jugBlancas);
        Rey rey2 = new Rey(4, 7, jugNegras);
        tablero.obtenerCasilla(4, 0).colocarPieza(rey1);
        tablero.obtenerCasilla(4, 7).colocarPieza(rey2);

        Reina reina1 = new Reina(3, 0, jugBlancas);
        Reina reina2 = new Reina(3, 7, jugNegras);
        tablero.obtenerCasilla(3, 0).colocarPieza(reina1);
        tablero.obtenerCasilla(3, 7).colocarPieza(reina2);

        jugActual = jugBlancas;
    }

    public void cambiarTurno() {
        if (jugActual.esBlancas()) {
            jugActual = jugNegras;
        } else {
            jugActual = jugBlancas;
        }
    }

    public void asignarMovimientoTipoPieza(int x, int y) {
        if (tablero.casillas[x][y].getPieza().getTipo().equals(TipoPieza.peon)) {

        } else if (tablero.casillas[x][y].getPieza().getTipo().equals(TipoPieza.caballo)) {

        } else if (tablero.casillas[x][y].getPieza().getTipo().equals(TipoPieza.alfil)) {

        } else if (tablero.casillas[x][y].getPieza().getTipo().equals(TipoPieza.torre)) {
            validarMovimientosTorre(tablero.casillas[x][y].getPieza());
        } else if (tablero.casillas[x][y].getPieza().getTipo().equals(TipoPieza.reina)) {

        } else if (tablero.casillas[x][y].getPieza().getTipo().equals(TipoPieza.rey)) {

        }

    }

    public ArrayList validarMovimientosTorre(Pieza pieza) {
        int[] posicionActual = pieza.getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        ArrayList<int[]> movimientos = new ArrayList<>();

        for (int i = x + 1; i < 8; i++) {
            if (!tablero.casillas[i][y].tienePieza()) {

                movimientos.add(new int[]{i, y});
            } else {
                if (!tablero.casillas[i][y].getPieza().getPropietario().equals(jugActual)) {
                    movimientos.add(new int[]{i, y});
                }
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if (!tablero.casillas[i][y].tienePieza()) {
                movimientos.add(new int[]{i, y});
            } else {
                if (!tablero.casillas[i][y].getPieza().getPropietario().equals(jugActual)) {
                    movimientos.add(new int[]{i, y});
                }
                break;
            }
        }
        for (int i = y + 1; i < 8; i++) {
            if (!tablero.casillas[x][i].tienePieza()) {
                movimientos.add(new int[]{x, i});
            } else {
                if (!tablero.casillas[x][i].getPieza().getPropietario().equals(jugActual)) {
                    movimientos.add(new int[]{x, i});
                }
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (!tablero.casillas[x][i].tienePieza()) {
                movimientos.add(new int[]{x, i});
            } else {
                if (!tablero.casillas[x][i].getPieza().getPropietario().equals(jugActual)) {
                    movimientos.add(new int[]{x, i});
                }
                break;
            }
        }
        return movimientos;
    }

    public ArrayList<int[]> validarMovimientosAlfil(Pieza pieza) {
        int[] posicionActual = pieza.getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        ArrayList<int[]> movimientos = new ArrayList<>();

        for (int i = 1; i < 8; i++) {
            if (x + i < 8 && y + i < 8) {
                if (!tablero.casillas[x + i][y + i].tienePieza()) {
                    movimientos.add(new int[]{x + i, y + i});
                } else {
                    if (!tablero.casillas[x + i][y + i].getPieza().getPropietario().equals(jugActual)) {
                        movimientos.add(new int[]{x + i, y + i});
                    }
                    break;
                }
            }

            if (x - i >= 0 && y + i < 8) {
                if (!tablero.casillas[x - i][y + i].tienePieza()) {
                    movimientos.add(new int[]{x - i, y + i});
                } else {
                    if (!tablero.casillas[x - i][y + i].getPieza().getPropietario().equals(jugActual)) {
                        movimientos.add(new int[]{x - i, y + i});
                    }
                    break;
                }
            }

            if (x + i < 8 && y - i >= 0) {
                if (!tablero.casillas[x + i][y - i].tienePieza()) {
                    movimientos.add(new int[]{x + i, y - i});
                } else {
                    if (!tablero.casillas[x + i][y - i].getPieza().getPropietario().equals(jugActual)) {
                        movimientos.add(new int[]{x + i, y - i});
                    }
                    break;
                }
            }

            if (x - i >= 0 && y - i >= 0) {
                if (!tablero.casillas[x - i][y - i].tienePieza()) {
                    movimientos.add(new int[]{x - i, y - i});
                } else {
                    if (!tablero.casillas[x - i][y - i].getPieza().getPropietario().equals(jugActual)) {
                        movimientos.add(new int[]{x - i, y - i});
                    }
                    break;
                }
            }
        }

        return movimientos;
    }
}
