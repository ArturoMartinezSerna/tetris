package paneles;

import piezas.Cuadrado;
import piezas.Pieza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tablero extends JPanel implements KeyListener {

    int[][] tablero = new int[8][8];
    Pieza piezaActual;
    int margenX = 25;
    int margenY = 25;

    public Tablero() {
        this.setFocusable(true); // Permite que pueda recibir eventos de teclado
        this.addKeyListener(this); // Añade una clase que implementa KeyListener

        generarPiezaAleatoria();

        start();
    }

    //TODO: Crear otras piezas, no solo cuadrados
    public void generarPiezaAleatoria() {
        this.piezaActual = new Cuadrado(this);
        piezaActual.draw();
        repaint();
    }

    public void start() {
        int msRetraso = 500;
        Timer timer = new Timer(msRetraso, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                piezaActual.moverY(1);
                repaint();
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
                    //case 2: g.setColor(Color.blue); break;
                }
                g.fillRect(margenX + j*100, margenY + i*100, 100, 100);

                // Pinta la cuadrícula entre pieza y pieza
                g.setColor(Color.black);
                g.drawRect(margenX + j*100, margenY + i*100, 100, 100);
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
        if(e.getKeyCode() == KeyEvent.VK_LEFT) {
            piezaActual.moverX(-1);
            repaint();
        }
        else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
            piezaActual.moverX(1);
            repaint();
        }
        else if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            piezaActual.moverY(1);
            repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) {}
}
