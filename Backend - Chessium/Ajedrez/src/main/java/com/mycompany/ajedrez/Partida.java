package com.mycompany.ajedrez;

import java.util.ArrayList;
import java.util.List;

public class Partida {

    private final Jugador jugBlancas;
    private final Jugador jugNegras;
    private Jugador jugActual;
    private boolean juegoTerminado;
    private boolean cambioPosicion;

    public Jugador getJugActual() {
        return jugActual;
    }

    public void setJugActual(Jugador jugActual) {
        this.jugActual = jugActual;
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }

    public void setJuegoTerminado(boolean juegoTerminado) {
        this.juegoTerminado = juegoTerminado;
    }
    
    public Partida() {
        Tablero.inicializar();
        this.jugBlancas = new Jugador(true);
        this.jugNegras = new Jugador(false);
        this.juegoTerminado = false;   
        this.cambioPosicion = false;
        iniciarPartida();
    }

    public void iniciarPartida() {
        for (int i = 0; i < 8; i++) {
            Peon peon = new Peon(i, 1, jugBlancas);
            Tablero.obtenerCasilla(i, 1).colocarPieza(peon);
        }
        for (int i = 0; i < 8; i++) {
            Peon peon = new Peon(i, 6, jugNegras);
            Tablero.obtenerCasilla(i, 6).colocarPieza(peon);
        }
        Torre torre1 = new Torre(0, 0, jugBlancas);
        Torre torre2 = new Torre(7, 0, jugBlancas);
        Torre torre3 = new Torre(0, 7, jugNegras);
        Torre torre4 = new Torre(7, 7, jugNegras);
        Tablero.obtenerCasilla(0, 0).colocarPieza(torre1);
        Tablero.obtenerCasilla(7, 0).colocarPieza(torre2);
        Tablero.obtenerCasilla(0, 7).colocarPieza(torre3);
        Tablero.obtenerCasilla(7, 7).colocarPieza(torre4);

        Caballo caballo1 = new Caballo(1, 0, jugBlancas);
        Caballo caballo2 = new Caballo(6, 0, jugBlancas);
        Caballo caballo3 = new Caballo(1, 7, jugNegras);
        Caballo caballo4 = new Caballo(6, 7, jugNegras);
        Tablero.obtenerCasilla(1, 0).colocarPieza(caballo1);
        Tablero.obtenerCasilla(6, 0).colocarPieza(caballo2);
        Tablero.obtenerCasilla(1, 7).colocarPieza(caballo3);
        Tablero.obtenerCasilla(6, 7).colocarPieza(caballo4);

        Alfil alfil1 = new Alfil(2, 0, jugBlancas);
        Alfil alfil2 = new Alfil(5, 0, jugBlancas);
        Alfil alfil3 = new Alfil(2, 7, jugNegras);
        Alfil alfil4 = new Alfil(5, 7, jugNegras);
        Tablero.obtenerCasilla(2, 0).colocarPieza(alfil1);
        Tablero.obtenerCasilla(5, 0).colocarPieza(alfil2);
        Tablero.obtenerCasilla(2, 7).colocarPieza(alfil3);
        Tablero.obtenerCasilla(5, 7).colocarPieza(alfil4);

        Rey rey1 = new Rey(4, 0, jugBlancas);
        Rey rey2 = new Rey(4, 7, jugNegras);
        Tablero.obtenerCasilla(4, 0).colocarPieza(rey1);
        Tablero.obtenerCasilla(4, 7).colocarPieza(rey2);

        Reina reina1 = new Reina(3, 0, jugBlancas);
        Reina reina2 = new Reina(3, 7, jugNegras);
        Tablero.obtenerCasilla(3, 0).colocarPieza(reina1);
        Tablero.obtenerCasilla(3, 7).colocarPieza(reina2);

        jugActual = jugBlancas;
    }

    public void cambiarTurno() {
        if (jugActual.esBlancas()) {
            jugActual = jugNegras;
        } else {
            jugActual = jugBlancas;
        }
    }

    public ArrayList<int[]> asignarMovimientoTipoPieza(int x, int y) {
        Pieza pieza = Tablero.casillas[x][y].getPieza();
        if (pieza == null) {
            return null;
        } else if (Tablero.casillas[x][y].getPieza().getTipo().equals(TipoPieza.peon)) {
            return ((Peon)pieza).validarMovimientosPeon(Tablero.casillas[x][y].getPieza());
        } else if (Tablero.casillas[x][y].getPieza().getTipo().equals(TipoPieza.caballo)) {
            return ((Caballo)pieza).validarMovimientosCaballo(Tablero.casillas[x][y].getPieza());
        } else if (Tablero.casillas[x][y].getPieza().getTipo().equals(TipoPieza.alfil)) {
            return ((Alfil)pieza).validarMovimientosAlfil(Tablero.casillas[x][y].getPieza());
        } else if (Tablero.casillas[x][y].getPieza().getTipo().equals(TipoPieza.torre)) {
            return ((Torre)pieza).validarMovimientosTorre(Tablero.casillas[x][y].getPieza());
        } else if (Tablero.casillas[x][y].getPieza().getTipo().equals(TipoPieza.reina)) {
            return ((Reina)pieza).validarMovimientosReina(Tablero.casillas[x][y].getPieza());
        } else {
            return ((Rey)pieza).validarMovimientosRey(Tablero.casillas[x][y].getPieza());
        }
    }

    public boolean esMovimientoValido(int xOrigen, int yOrigen, int xDestino, int yDestino) {
        Pieza pieza = Tablero.obtenerCasilla(xOrigen, yOrigen).getPieza();
        if (pieza == null || !pieza.getPropietario().equals(jugActual)) {
            return false;
        }
        
        ArrayList<int[]> movimientosPosibles = asignarMovimientoTipoPieza(xOrigen, yOrigen);
        for (int[] movimiento : movimientosPosibles) {
            if (movimiento[0] == xDestino && movimiento[1] == yDestino) {
                return true;
            }
        }
        return false;
    }

    public void realizarMovimiento(int xOrigen, int yOrigen, int xDestino, int yDestino) {
        if (esMovimientoValido(xOrigen, yOrigen, xDestino, yDestino)) {
            Pieza pieza = Tablero.obtenerCasilla(xOrigen, yOrigen).getPieza();
            Tablero.obtenerCasilla(xDestino, yDestino).colocarPieza(pieza);
            pieza.setPosicion(xDestino, yDestino);
            Tablero.obtenerCasilla(xOrigen, yOrigen).colocarPieza(null);
            cambiarTurno();
        } else {
            System.out.println("Movimiento no válido");
        }
    }

    public void setCambioPosicion(boolean cambioPosicion) {
        this.cambioPosicion = cambioPosicion;
    }

    public boolean CambioPosicion() {
        return cambioPosicion;
    }

    public Jugador getJugBlancas() {
        return jugBlancas;
    }

    public Jugador getJugNegras() {
        return jugNegras;
    }
}

    

