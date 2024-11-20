package com.mycompany.ajedrez;

public class Tablero {
    public static Casilla[][] casillas;
    public static Jugador jugActual;

    public static void inicializar() {
        casillas = new Casilla[8][8];
        for (int i = 0; i < 8; i++){
            for (int j = 0; j < 8; j++){
                casillas[i][j] = new Casilla();
            }
        } 
    }
    
    public static Casilla obtenerCasilla(int x, int y){
        return casillas[x][y];
    }
    
    public static void ColocarPieza(){
        
    }
            
}
