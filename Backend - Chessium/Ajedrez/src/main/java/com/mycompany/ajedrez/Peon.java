package com.mycompany.ajedrez;

import java.util.ArrayList;
import java.util.List;

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
    
    
}
