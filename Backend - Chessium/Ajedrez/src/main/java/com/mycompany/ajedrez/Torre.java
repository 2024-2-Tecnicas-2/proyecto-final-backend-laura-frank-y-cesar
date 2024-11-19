package com.mycompany.ajedrez;

import java.util.ArrayList;
import java.util.List;


public class Torre extends Pieza{

    
    public Torre(int x, int y, Jugador propietario) {
        super(x, y, propietario, TipoPieza.torre);
    }

}
