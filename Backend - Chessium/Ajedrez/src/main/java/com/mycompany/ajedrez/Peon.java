package com.mycompany.ajedrez;

import java.util.ArrayList;
import java.util.List;

public class Peon extends Pieza{

    private boolean movioDoble;
    private boolean primerMovimiento;
    
    public Peon(int x, int y, Jugador propietario) {
        super(x, y, propietario);
        this.movioDoble = false;
        this.primerMovimiento = true;
    }

    public boolean isMovioDoble() {
        return movioDoble;
    }

    public void setMovioDoble(boolean movioDoble) {
        this.movioDoble = movioDoble;
    }
    
    @Override
    int[][] getMovimientos() {
        int[] posicionActual = getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        int direccion = 1;
        List<int[]> movimientos = new ArrayList<>();
        if (!super.getPropietario().esBlancas()){
            direccion = -1;
        } 
        movimientos.add(new int[]{x, y + direccion});
        if(primerMovimiento)
            movimientos.add(new int[]{x, y + (2*direccion)});
        if(x != 0)
            movimientos.add(new int[]{x - 1, y + direccion});
        if(x != 7)
            movimientos.add(new int[]{x + 1, y + direccion});
        
        return movimientos.toArray(new int[0][0]);
    }
}
