package com.mycompany.ajedrez;

public  abstract class Pieza {
    private int x;
    private int y;
    private final Jugador propietario;
    private final TipoPieza tipo;

    public Pieza(int x, int y, Jugador propietario, TipoPieza tipo) {
        this.x = x;
        this.y = y;
        this.propietario = propietario;
        this.tipo = tipo;
    }

    public void setPosicion(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int[] getPosicion() {
        return new int[]{x,y};
    }

    public Jugador getPropietario() {
        return propietario;
    }
    
    abstract int[][] getMovimientos();
}
