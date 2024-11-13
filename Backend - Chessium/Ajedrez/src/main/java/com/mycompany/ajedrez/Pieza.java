package com.mycompany.ajedrez;

/**
 *
 * @author frank
 */
public  abstract class Pieza {
    private int x;
    private int y;
    private final Jugador propietario;

    public Pieza(int x, int y, Jugador propietario) {
        this.x = x;
        this.y = y;
        this.propietario = propietario;
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
