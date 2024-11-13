package com.mycompany.ajedrez;

/**
 *
 * @author frank
 */
public class Jugador {
    
    private final boolean esBlancas;

    public Jugador(boolean esBlancas) {
        this.esBlancas = esBlancas;
    }

    public boolean esBlancas() {
        return esBlancas;
    }
}