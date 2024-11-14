package com.mycompany.ajedrez;

public class Jugador {
    
    private final boolean esBlancas;

    public Jugador(boolean esBlancas) {
        this.esBlancas = esBlancas;
    }

    public boolean esBlancas() {
        return esBlancas;
    }
}