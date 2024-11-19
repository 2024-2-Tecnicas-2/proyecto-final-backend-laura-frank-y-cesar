package com.mycompany.ajedrez;
import java.util.ArrayList;
import java.util.List;

public class Alfil extends Pieza{

    public Alfil(int x, int y, Jugador propietario) {
        super(x, y, propietario, TipoPieza.alfil);
    }
}
