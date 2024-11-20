package com.mycompany.ajedrez;
import java.util.Scanner;

public class ControladorDePartida {
    private Partida partida;
    private Scanner scanner;
    public ControladorDePartida() {
        this.partida = new Partida();  
        scanner = new Scanner(System.in);
    }
    
    public void Juego(){
        mostrarEstadoJuego();
        while (!partida.isJuegoTerminado()) {
            pedirJugada();
            partida.cambiarTurno();
            mostrarEstadoJuego();
        }

        // Cuando el juego termina
        System.out.println("El juego ha terminado.");
    }  
    
     private void mostrarEstadoJuego() {
        System.out.println("\nEstado del tablero:");
        mostrarTablero();
        obtenerEstadoJuego();
    }
     
    public void moverPieza(int xOrigen, int yOrigen, int xDestino, int yDestino) {
        if (partida.esMovimientoValido(xOrigen, yOrigen, xDestino, yDestino)) {
            partida.realizarMovimiento(xOrigen, yOrigen, xDestino, yDestino);
            System.out.println("Movimiento realizado de (" + xOrigen + ", " + yOrigen + ") a (" + xDestino + ", " + yDestino + ")");
        } else {
            System.out.println("Movimiento no válido. Intente de nuevo.");
        }
    }
    
    public void cambiarTurno() {
        partida.cambiarTurno();
    }
    
    public boolean esJuegoTerminado() {
        return partida.isJuegoTerminado();
    }
    
    public void obtenerEstadoJuego() {
        Jugador jugadorActual = partida.getJugActual();
        System.out.println("Es el turno de: " + (jugadorActual.esBlancas() ? "Blancas" : "Negras"));
    }
    
    public void finalizarJuego() {
        partida.setJuegoTerminado(true);
        System.out.println("El juego ha terminado.");
    }
    
    private void mostrarTablero() {     
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Pieza pieza = Tablero.obtenerCasilla(i, j).getPieza();
                if (pieza != null) {
                    System.out.print(pieza.getTipo().toString().charAt(0) + " "); 
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
    
    private void pedirJugada() {
        int xOrigen, yOrigen, xDestino, yDestino;
        System.out.println("Ingrese la jugada (origen y destino):");
        System.out.print("Origen (x, y): ");
        xOrigen = scanner.nextInt() - 1;
        yOrigen = scanner.nextInt() - 1;

        System.out.print("Destino (x, y): ");
        xDestino = scanner.nextInt() - 1;
        yDestino = scanner.nextInt() - 1;

        partida.realizarMovimiento(xOrigen, yOrigen, xDestino, yDestino);
    }
}
