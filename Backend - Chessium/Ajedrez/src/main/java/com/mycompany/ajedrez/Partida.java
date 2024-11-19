package com.mycompany.ajedrez;

import java.util.ArrayList;
import java.util.List;

public class Partida {

    private final Jugador jugBlancas;
    private final Jugador jugNegras;
    private Jugador jugActual;

    public Partida() {
        Tablero.inicializar();
        this.jugBlancas = new Jugador(true);
        this.jugNegras = new Jugador(false);
        iniciarPartida();
    }

    public void iniciarPartida() {
        for (int i = 0; i < 8; i++) {
            Peon peon = new Peon(i, 1, jugBlancas);
            Tablero.obtenerCasilla(1, i).colocarPieza(peon);
        }
        for (int i = 0; i < 8; i++) {
            Peon peon = new Peon(i, 6, jugNegras);
            Tablero.obtenerCasilla(i, 6).colocarPieza(peon);
        }
        Torre torre1 = new Torre(0, 0, jugBlancas);
        Torre torre2 = new Torre(7, 0, jugBlancas);
        Torre torre3 = new Torre(0, 7, jugNegras);
        Torre torre4 = new Torre(7, 7, jugNegras);
        Tablero.obtenerCasilla(0, 0).colocarPieza(torre1);
        Tablero.obtenerCasilla(7, 0).colocarPieza(torre2);
        Tablero.obtenerCasilla(0, 7).colocarPieza(torre3);
        Tablero.obtenerCasilla(7, 7).colocarPieza(torre4);

        Caballo caballo1 = new Caballo(1, 0, jugBlancas);
        Caballo caballo2 = new Caballo(6, 0, jugBlancas);
        Caballo caballo3 = new Caballo(1, 7, jugNegras);
        Caballo caballo4 = new Caballo(6, 7, jugNegras);
        Tablero.obtenerCasilla(1, 0).colocarPieza(caballo1);
        Tablero.obtenerCasilla(6, 0).colocarPieza(caballo2);
        Tablero.obtenerCasilla(1, 7).colocarPieza(caballo3);
        Tablero.obtenerCasilla(6, 7).colocarPieza(caballo4);

        Alfil alfil1 = new Alfil(2, 0, jugBlancas);
        Alfil alfil2 = new Alfil(5, 0, jugBlancas);
        Alfil alfil3 = new Alfil(2, 7, jugNegras);
        Alfil alfil4 = new Alfil(5, 7, jugNegras);
        Tablero.obtenerCasilla(2, 0).colocarPieza(alfil1);
        Tablero.obtenerCasilla(5, 0).colocarPieza(alfil2);
        Tablero.obtenerCasilla(2, 7).colocarPieza(alfil3);
        Tablero.obtenerCasilla(5, 7).colocarPieza(alfil4);

        Rey rey1 = new Rey(4, 0, jugBlancas);
        Rey rey2 = new Rey(4, 7, jugNegras);
        Tablero.obtenerCasilla(4, 0).colocarPieza(rey1);
        Tablero.obtenerCasilla(4, 7).colocarPieza(rey2);

        Reina reina1 = new Reina(3, 0, jugBlancas);
        Reina reina2 = new Reina(3, 7, jugNegras);
        Tablero.obtenerCasilla(3, 0).colocarPieza(reina1);
        Tablero.obtenerCasilla(3, 7).colocarPieza(reina2);

        jugActual = jugBlancas;
    }

    public void cambiarTurno() {
        if (jugActual.esBlancas()) {
            jugActual = jugNegras;
        } else {
            jugActual = jugBlancas;
        }
    }

    public ArrayList<int[]> asignarMovimientoTipoPieza(int x, int y) {
        Pieza pieza = Tablero.casillas[x][y].getPieza();
        if (pieza == null) {
            return null;
        } else if (Tablero.casillas[x][y].getPieza().getTipo().equals(TipoPieza.peon)) {
            return null;
        } else if (Tablero.casillas[x][y].getPieza().getTipo().equals(TipoPieza.caballo)) {
            return null;
        } else if (Tablero.casillas[x][y].getPieza().getTipo().equals(TipoPieza.alfil)) {
            return validarMovimientosAlfil(Tablero.casillas[x][y].getPieza());
        } else if (Tablero.casillas[x][y].getPieza().getTipo().equals(TipoPieza.torre)) {
            return ((Torre)pieza).validarMovimientosTorre(Tablero.casillas[x][y].getPieza());
        } else if (Tablero.casillas[x][y].getPieza().getTipo().equals(TipoPieza.reina)) {
            return validarMovimientosReina(Tablero.casillas[x][y].getPieza());
        } else {
            return null;
        }
    }

    public boolean esMovimientoValido(int xOrigen, int yOrigen, int xDestino, int yDestino) {
        Pieza pieza = Tablero.obtenerCasilla(xOrigen, yOrigen).getPieza();
        if (pieza == null || !pieza.getPropietario().equals(jugActual)) {
            return false;
        }

        ArrayList<int[]> movimientosPosibles = asignarMovimientoTipoPieza(xOrigen, yOrigen);
        for (int[] movimiento : movimientosPosibles) {
            if (movimiento[0] == xDestino && movimiento[1] == yDestino) {
                return true;
            }
        }
        return false;
    }

    public void realizarMovimiento(int xOrigen, int yOrigen, int xDestino, int yDestino) {
        if (esMovimientoValido(xOrigen, yOrigen, xDestino, yDestino)) {
            Pieza pieza = Tablero.obtenerCasilla(xOrigen, yOrigen).getPieza();
            Tablero.obtenerCasilla(xDestino, yDestino).colocarPieza(pieza);
            pieza.setPosicion(xDestino, yDestino);
            Tablero.obtenerCasilla(xOrigen, yOrigen).colocarPieza(null);
            cambiarTurno();
        } else {
            System.out.println("Movimiento no válido");
        }
    }

    public ArrayList<int[]> validarMovimientosAlfil(Pieza pieza) {
        int[] posicionActual = pieza.getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        ArrayList<int[]> movimientos = new ArrayList<>();

        for (int i = 1; i < 8; i++) {
            if (x + i < 8 && y + i < 8) {
                if (!Tablero.casillas[x + i][y + i].tienePieza()) {
                    movimientos.add(new int[]{x + i, y + i});
                } else {
                    if (!Tablero.casillas[x + i][y + i].getPieza().getPropietario().equals(jugActual)) {
                        movimientos.add(new int[]{x + i, y + i});
                    }
                    break;
                }
            }

            if (x - i >= 0 && y + i < 8) {
                if (!Tablero.casillas[x - i][y + i].tienePieza()) {
                    movimientos.add(new int[]{x - i, y + i});
                } else {
                    if (!Tablero.casillas[x - i][y + i].getPieza().getPropietario().equals(jugActual)) {
                        movimientos.add(new int[]{x - i, y + i});
                    }
                    break;
                }
            }

            if (x + i < 8 && y - i >= 0) {
                if (!Tablero.casillas[x + i][y - i].tienePieza()) {
                    movimientos.add(new int[]{x + i, y - i});
                } else {
                    if (!Tablero.casillas[x + i][y - i].getPieza().getPropietario().equals(jugActual)) {
                        movimientos.add(new int[]{x + i, y - i});
                    }
                    break;
                }
            }

            if (x - i >= 0 && y - i >= 0) {
                if (!Tablero.casillas[x - i][y - i].tienePieza()) {
                    movimientos.add(new int[]{x - i, y - i});
                } else {
                    if (!Tablero.casillas[x - i][y - i].getPieza().getPropietario().equals(jugActual)) {
                        movimientos.add(new int[]{x - i, y - i});
                    }
                    break;
                }
            }
        }

        return movimientos;
    }

    public ArrayList<int[]> validarMovimientosReina(Pieza pieza) {
        int[] posicionActual = pieza.getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        ArrayList<int[]> movimientos = new ArrayList<>();

        for (int i = x + 1; i < 8; i++) {
            if (!Tablero.casillas[i][y].tienePieza()) {
                movimientos.add(new int[]{i, y});
            } else {
                if (!Tablero.casillas[i][y].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{i, y});
                }
                break;
            }
        }
        for (int i = x - 1; i >= 0; i--) {
            if (!Tablero.casillas[i][y].tienePieza()) {
                movimientos.add(new int[]{i, y});
            } else {
                if (!Tablero.casillas[i][y].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{i, y});
                }
                break;
            }
        }
        for (int i = y + 1; i < 8; i++) {
            if (!Tablero.casillas[x][i].tienePieza()) {
                movimientos.add(new int[]{x, i});
            } else {
                if (!Tablero.casillas[x][i].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{x, i});
                }
                break;
            }
        }
        for (int i = y - 1; i >= 0; i--) {
            if (!Tablero.casillas[x][i].tienePieza()) {
                movimientos.add(new int[]{x, i});
            } else {
                if (!Tablero.casillas[x][i].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{x, i});
                }
                break;
            }
        }

        for (int i = 1; x + i < 8 && y + i < 8; i++) {
            if (!Tablero.casillas[x + i][y + i].tienePieza()) {
                movimientos.add(new int[]{x + i, y + i});
            } else {
                if (!Tablero.casillas[x + i][y + i].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{x + i, y + i});
                }
                break;
            }
        }
        for (int i = 1; x - i >= 0 && y + i < 8; i++) {
            if (!Tablero.casillas[x - i][y + i].tienePieza()) {
                movimientos.add(new int[]{x - i, y + i});
            } else {
                if (!Tablero.casillas[x - i][y + i].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{x - i, y + i});
                }
                break;
            }
        }
        for (int i = 1; x + i < 8 && y - i >= 0; i++) {
            if (!Tablero.casillas[x + i][y - i].tienePieza()) {
                movimientos.add(new int[]{x + i, y - i});
            } else {
                if (!Tablero.casillas[x + i][y - i].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{x + i, y - i});
                }
                break;
            }
        }
        for (int i = 1; x - i >= 0 && y - i >= 0; i++) {
            if (!Tablero.casillas[x - i][y - i].tienePieza()) {
                movimientos.add(new int[]{x - i, y - i});
            } else {
                if (!Tablero.casillas[x - i][y - i].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{x - i, y - i});
                }
                break;
            }
        }

        return movimientos;
    }

    public Jugador getJugBlancas() {
        return jugBlancas;
    }

    public Jugador getJugNegras() {
        return jugNegras;
    }
   

    public ArrayList<int[]> validarMovimientosRey(Pieza pieza) {
        int[] posicionActual = pieza.getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        ArrayList<int[]> movimientos = new ArrayList<>();

        
        int[][] posiblesMovimientos = {
            {-1, -1}, {-1, 0}, {-1, 1}, 
            {0, -1}, {0, 1}, 
            {1, -1}, {1, 0}, {1, 1} 
        };

       
        for (int[] movimiento : posiblesMovimientos) {
            int nuevaX = x + movimiento[0];
            int nuevaY = y + movimiento[1];

            
            if (nuevaX >= 0 && nuevaX < 8 && nuevaY >= 0 && nuevaY < 8) {
                
                if (!Tablero.casillas[nuevaX][nuevaY].tienePieza()
                        || !Tablero.casillas[nuevaX][nuevaY].getPieza().getPropietario().equals(pieza.getPropietario())) {
                    movimientos.add(new int[]{nuevaX, nuevaY});
                }
            }
        }

        return movimientos;
    }

    public ArrayList<int[]> validarMovimientosPeon(Pieza pieza) {
        int[] posicionActual = pieza.getPosicion();
        int x = posicionActual[0];
        int y = posicionActual[1];
        ArrayList<int[]> movimientos = new ArrayList<>();

        boolean esBlanco = pieza.getPropietario().equals("blanco");
        int direccion = esBlanco ? -1 : 1;  // El peón blanco se mueve hacia arriba (menos en Y), el negro hacia abajo (más en Y)

        // Movimiento normal de un casillero
        int nuevaX = x + direccion;
        if (nuevaX >= 0 && nuevaX < 8) {
            // Verificar si la casilla está vacía para mover
            if (!Tablero.casillas[nuevaX][y].tienePieza()) {
                movimientos.add(new int[]{nuevaX, y});
            }

            // Movimiento doble (si el peón está en su casilla inicial)
            if ((esBlanco && x == 6) || (!esBlanco && x == 1)) {
                nuevaX = x + 2 * direccion;
                if (!Tablero.casillas[nuevaX][y].tienePieza()) {
                    movimientos.add(new int[]{nuevaX, y});
                }
            }
        }

        // Captura en diagonal
        for (int i = -1; i <= 1; i += 2) {  // i = -1 o 1 para mover en diagonal
            int nuevaY = y + i;
            if (nuevaY >= 0 && nuevaY < 8) {
                if (nuevaX >= 0 && nuevaX < 8 && Tablero.casillas[nuevaX][nuevaY].tienePieza()) {
                    Pieza piezaAdyacente = Tablero.casillas[nuevaX][nuevaY].getPieza();
                    if (!piezaAdyacente.getPropietario().equals(pieza.getPropietario())) {
                        movimientos.add(new int[]{nuevaX, nuevaY});
                    }
                }
            }
        }

        // Captura al paso (en passant)
        if (x == 4 && (esBlanco || !esBlanco)) {
            // Verificar captura al paso, solo ocurre en ciertas condiciones
            if (y > 0 && Tablero.casillas[x][y - 1].tienePieza()) {
                Pieza piezaIzquierda = Tablero.casillas[x][y - 1].getPieza();
                if (piezaIzquierda.getPropietario().equals(esBlanco ? "negro" : "blanco")
                        && piezaIzquierda.getPosicion()[0] == x && piezaIzquierda.getPosicion()[1] == y - 1) {
                    movimientos.add(new int[]{x + direccion, y - 1});
                }
            }
            if (y < 7 && Tablero.casillas[x][y + 1].tienePieza()) {
                Pieza piezaDerecha = Tablero.casillas[x][y + 1].getPieza();
                if (piezaDerecha.getPropietario().equals(esBlanco ? "negro" : "blanco")
                        && piezaDerecha.getPosicion()[0] == x && piezaDerecha.getPosicion()[1] == y + 1) {
                    movimientos.add(new int[]{x + direccion, y + 1});
                }
            }
        }

        return movimientos;
    }

}

    

