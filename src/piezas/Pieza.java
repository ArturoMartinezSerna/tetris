package piezas;

import paneles.Tablero;

public abstract class Pieza {

    int x, y, color;
    paneles.Tablero referenciaTablero;

    public Pieza(Tablero referenciaTablero){
        this.x = 3;
        this.y = 0;
        this.referenciaTablero = referenciaTablero;
    }

    public abstract void moverX(int x);
    public abstract void moverY(int y);
    public abstract void girar();
    public abstract void draw();
    public abstract void erase();
    public abstract void colocar();
}
