import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Tablero extends JPanel implements KeyListener {

    int[][] tablero = new int[10][10];
    Pieza pieza;


    public Tablero() {

        this.pieza = crearPiezaAleatoria();

        this.setFocusable(true); // Permite que pueda recibir eventos de teclado
        this.addKeyListener(this); // Añade una clase que implementa KeyListener
        this.repaint(); // Dibuja el tablero llamando a paintComponent(Graphics g)
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.cyan);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.white);
        g.drawString("Aquí irá nuestra pieza:", 20, 20);
        g.drawRect(400, 400, 100, 100);
        g.setColor(Color.blue);
        g.fillRect(400, 400, 100, 100);
    }

    private Pieza crearPiezaAleatoria() {
        Pieza pieza = new Pieza(5, 5);
        return pieza;
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
