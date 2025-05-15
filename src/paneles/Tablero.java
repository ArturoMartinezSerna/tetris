package paneles;

import piezas.Cuadrado;
import piezas.Pieza;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class Tablero extends JPanel implements KeyListener {

    int[][] tablero = new int[8][8];
    Pieza piezaActual;
    int margenX = 25;
    int margenY = 25;

    public int[][] getTablero() {
        return tablero;
    }

    public Tablero() {
        this.setFocusable(true); // Permite que pueda recibir eventos de teclado
        this.addKeyListener(this); // Añade una clase que implementa KeyListener

        generarPiezaAleatoria();

        this.repaint(); // Dibuja el tablero llamando a paintComponent(Graphics g)

        start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.darkGray);
        g.fillRect(0, 0, getWidth(), margenY);
        g.fillRect(0, margenY, margenX, getHeight());
        g.fillRect(0, getHeight() - margenY, getWidth(), margenY);
        g.fillRect(getWidth() - margenX, 0, margenX, getHeight());
        for(int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero[i].length; j++) {
                switch(tablero[i][j]) {
                    case 0: g.setColor(Color.black); break;
                    case 1: g.setColor(Color.green); break;
                    case 2: g.setColor(Color.blue); break;
                }
                g.fillRect(margenX + i*100, margenY + j*100, 100, 100);
                g.setColor(Color.black);
                g.drawRect(margenX + i*100, margenY + j*100, 100, 100);
            }
        }
    }

    public void colocar() {
        eliminaLineasCompletas();
        generarPiezaAleatoria();

        System.out.println("TABLERO:");
        for(int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void generarPiezaAleatoria() {
         this.piezaActual = new Cuadrado(this);
         piezaActual.draw();
         repaint();
    }
    
    public void eliminaLineasCompletas() {
        bucleExterno:
        for(int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero[i].length; j++) {
                if(tablero[i][j] == 0)
                    continue bucleExterno; // No se elimina
            }
            eliminarLinea(i);
            // todas las líneas completas anteriores se han eliminado
            // así que no hace falta comprobar que la línea que baja no esté completa
        }
    }
        private void eliminarLinea(int numeroLinea) {
            for(int i = numeroLinea; i >= 1; i--) {
                bajarLinea(i);
            }
            vaciarLinea(0);
        }

            private void bajarLinea(int numeroLinea) {
                for(int i = 0; i < tablero[numeroLinea].length; i++) {
                    tablero[i][numeroLinea - 1] = tablero[i][numeroLinea];
                }
            }

            private void vaciarLinea(int numeroLinea) {
                for(int i = 0; i < tablero[numeroLinea].length; i++) {
                    tablero[i][numeroLinea] = 0;
                }
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
    public void keyTyped(KeyEvent e) {

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
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
