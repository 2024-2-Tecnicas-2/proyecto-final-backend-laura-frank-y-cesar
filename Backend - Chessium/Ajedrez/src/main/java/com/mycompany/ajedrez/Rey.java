package com.mycompany.ajedrez;

public class Rey extends Pieza{

    public Rey(int x, int y, Jugador propietario) {
        super(x, y, propietario, TipoPieza.rey);
    }

    int[][] getMovimientos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
