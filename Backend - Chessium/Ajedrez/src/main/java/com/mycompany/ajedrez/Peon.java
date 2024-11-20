package com.mycompany.ajedrez;

import java.util.ArrayList;


public class Peon extends Pieza{

    private boolean movioDoble;
    private boolean primerMovimiento;
    
    public Peon(int x, int y, Jugador propietario) {
        super(x, y, propietario, TipoPieza.peon);
        this.movioDoble = false;
        this.primerMovimiento = true;
    }

    public boolean isMovioDoble() {
        return movioDoble;
    }

    public void setMovioDoble(boolean movioDoble) {
        this.movioDoble = movioDoble;
    }

    public ArrayList<int[]> validarMovimientosPeon(Pieza pieza) {
        int[] posicionActual = pieza.getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        ArrayList<int[]> movimientos = new ArrayList<>();

        int direccion = pieza.getPropietario().esBlancas() ? 1 : -1;

        if (x + direccion >= 0 && x + direccion < 8) {
            if (!Tablero.casillas[x + direccion][y].tienePieza()) {
                movimientos.add(new int[]{x + direccion, y});
            }
        }

        if ((pieza.getPropietario().esBlancas() && x == 1) || !(pieza.getPropietario().esBlancas() && x == 6)) {
            if (!Tablero.casillas[x + direccion][y].tienePieza() && !Tablero.casillas[x + 2 * direccion][y].tienePieza()) {
                movimientos.add(new int[]{x + 2 * direccion, y});
            }
        }

        if (y - 1 >= 0 && x + direccion >= 0 && x + direccion < 8) {
            if (Tablero.casillas[x + direccion][y - 1].tienePieza()
                    && !Tablero.casillas[x + direccion][y - 1].getPieza().getPropietario().equals(pieza.getPropietario())) {
                movimientos.add(new int[]{x + direccion, y - 1});
            }
        }

        if (y + 1 < 8 && x + direccion >= 0 && x + direccion < 8) {
            if (Tablero.casillas[x + direccion][y + 1].tienePieza()
                    && !Tablero.casillas[x + direccion][y + 1].getPieza().getPropietario().equals(pieza.getPropietario())) {
                movimientos.add(new int[]{x + direccion, y + 1});
            }
        }

        return movimientos;
    }

}
