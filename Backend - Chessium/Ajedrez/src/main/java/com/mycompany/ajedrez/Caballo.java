package com.mycompany.ajedrez;
import java.util.ArrayList;

public class Caballo extends Pieza {

    public Caballo(int x, int y, Jugador propietario) {
        super(x, y, propietario, TipoPieza.caballo);
    }
    public ArrayList<int[]> validarMovimientosCaballo(Pieza pieza) {
        int[] posicionActual = pieza.getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        ArrayList<int[]> movimientos = new ArrayList<>();

        
        int[][] direcciones = {
            {2, 1}, {2, -1}, {-2, 1}, {-2, -1},
            {1, 2}, {1, -2}, {-1, 2}, {-1, -2}
        };

        
        for (int[] direccion : direcciones) {
            int nuevaX = x + direccion[0];
            int nuevaY = y + direccion[1];

            
            if (nuevaX >= 0 && nuevaX < 8 && nuevaY >= 0 && nuevaY < 8) {
               
                if (!Tablero.casillas[nuevaX][nuevaY].tienePieza()
                        || !Tablero.casillas[nuevaX][nuevaY].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    
                    movimientos.add(new int[]{nuevaX, nuevaY});
                }
            }
        }

        return movimientos;
    }

   
}
