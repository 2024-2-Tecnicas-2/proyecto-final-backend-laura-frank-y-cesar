package com.mycompany.ajedrez;

public class Casilla {
    private Pieza pieza;

    public Casilla() {
        pieza = null;
    }

    public Pieza getPieza() {
        return pieza;
    }
    
    public boolean tienePieza(){
        return pieza != null;
    }

    public void colocarPieza(Pieza pieza) {
        this.pieza = pieza;
    }
}
