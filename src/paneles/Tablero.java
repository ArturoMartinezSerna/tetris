package paneles;

import piezas.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Tablero extends JPanel implements KeyListener {

    int[][] tablero = new int[16][10];
    Pieza piezaActual;
    int margenX = 25;
    int margenY = 25;
    Timer timer;

    public Tablero() {
        this.setFocusable(true); // Permite que pueda recibir eventos de teclado
        this.addKeyListener(this); // Añade una clase que implementa KeyListener

        generarPiezaAleatoria();

        start();
    }

    public void generarPiezaAleatoria() {
        Random random = new Random();
        int tipoPieza = random.nextInt(4);

        switch(tipoPieza) {
            case 0: piezaActual = new Cuadrado(this); break;
            case 1: piezaActual = new Linea(this); break;
            case 2: piezaActual = new zPiece(this); break;
            case 3: piezaActual = new zPieceReverse(this); break;
        }

        if(piezaActual.puedeCrearse())
            piezaActual.draw();
        else {
            piezaActual = null;
            timer.stop();
        }
    }

    public void start() {
        int msRetraso = 500;
        timer = new Timer(msRetraso, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                piezaActual.moverY(1);
            }
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Pintamos los márgenes grises de los lados
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, getWidth(), margenY);
        g.fillRect(0, margenY, margenX, getHeight());
        g.fillRect(0, getHeight() - margenY, getWidth(), margenY);
        g.fillRect(getWidth() - margenX, 0, margenX, getHeight());

        // Pintamos el tablero
        for(int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero[i].length; j++) {
                switch(tablero[i][j]) {
                    case 0: g.setColor(Color.black); break;
                    case 1: g.setColor(Color.green); break;
                    case 2: g.setColor(Color.blue); break;
                    case 3: g.setColor(Color.red); break;
                    case 4: g.setColor(Color.yellow); break;
                    default: g.setColor(Color.white); break;
                }
                g.fillRect(margenX + j*50, margenY + i*50, 50, 50);

                // Pinta la cuadrícula entre pieza y pieza
                g.setColor(Color.black);
                g.drawRect(margenX + j*50, margenY + i*50, 50, 50);
            }
        }
    }

    public void colocar() {
        eliminaLineasCompletas();
        generarPiezaAleatoria();

        /*
        System.out.println("TABLERO:");
        for(int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        */
    }

    public void eliminaLineasCompletas() {

        bucleExterno:
        for(int fila = 0; fila < tablero.length; fila++) { // Recorre FILAS
            for(int columna = 0; columna < tablero[fila].length; columna++) {
                if(tablero[fila][columna] == 0)
                    continue bucleExterno; // No se elimina
            }
            eliminarFila(fila);
            // todas las líneas completas anteriores se han eliminado
            // así que no hace falta comprobar que la línea que baja no esté completa
        }
    }
        private void eliminarFila(int filaBorrar) {
            for(int fila = filaBorrar; fila >= 1; fila--) {
                bajarFila(fila);
            }
            vaciarFila(0);
        }

            private void bajarFila(int filaBorrar) {
                for(int columna = 0; columna < tablero[filaBorrar].length; columna++) {
                    tablero[filaBorrar][columna] = tablero[filaBorrar - 1][columna];
                }
            }

            private void vaciarFila(int numeroLinea) {
                for(int j = 0; j < tablero[numeroLinea].length; j++) {
                    tablero[numeroLinea][j] = 0;
                }
            }

    public int[][] getTablero() {
        return tablero;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                piezaActual.moverX(-1);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                piezaActual.moverX(1);
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                piezaActual.moverY(1);
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                piezaActual.girar();
            }
        } catch(NullPointerException ex) {
            System.out.println("El juego ha terminado! No puedes moverte!");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}
