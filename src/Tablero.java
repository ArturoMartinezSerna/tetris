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

    int[][] tablero = new int[10][10];
    Pieza piezaActual;
    int margenX = 25;
    int margenY = 25;

    public Tablero() {
        Random r = new Random();

        this.piezaActual = new Cuadrado();

        this.setFocusable(true); // Permite que pueda recibir eventos de teclado
        this.addKeyListener(this); // Añade una clase que implementa KeyListener
        this.repaint(); // Dibuja el tablero llamando a paintComponent(Graphics g)

        /*for(int i = 0; i < 10; i++) {
            for(int j = 0; j < 10; j++) {
                tablero[i][j] = r.nextInt(3);
            }
        }*/
        tablero = piezaActual.draw(tablero);
        tablero = piezaActual.draw(tablero);
        this.repaint();
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

    private Pieza crearPiezaAleatoria() {
        // piezas.Pieza piezaActual = new PiezaTipoPieza();
        return piezaActual;
    }

    public void start() {
        int msRetraso = 1000;
        Timer timer = new Timer(msRetraso, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tablero = piezaActual.mover(tablero, 0, 1);
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

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
