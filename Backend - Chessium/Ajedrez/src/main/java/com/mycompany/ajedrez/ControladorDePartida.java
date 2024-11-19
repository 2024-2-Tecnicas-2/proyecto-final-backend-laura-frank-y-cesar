package com.mycompany.ajedrez;

public class ControladorDePartida {
    private Partida partida;
    private Jugador jugBlancas;
    private Jugador jugNegras;
    private Jugador jugActual;
    private boolean juegoTerminado;
    
    public ControladorDePartida() {
        this.partida = new Partida();
        this.jugBlancas = partida.getJugBlancas();
        this.jugNegras = partida.getJugNegras();
        this.jugActual = jugBlancas;
        this.juegoTerminado = false;
    }
    
    
}
