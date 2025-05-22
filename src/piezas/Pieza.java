package piezas;

import paneles.Tablero;

public abstract class Pieza {

    int columna, fila, color;
    boolean isHorizontal;
    paneles.Tablero referenciaTablero;

    public Pieza(Tablero referenciaTablero){
        this.columna = 3;
        this.fila = 0;
        this.referenciaTablero = referenciaTablero;
    }

    public abstract void girar();
    public abstract boolean puedeGirar();
    public abstract void draw();
    public abstract void erase();
    protected abstract boolean puedeBajar();
    protected abstract boolean puedeMoverDerecha();
    protected abstract boolean puedeMoverIzquierda();
    public abstract boolean puedeCrearse();

    public void moverY(int fila) {
        try {
            if(puedeBajar()) {
                erase();
                this.fila += fila;
                draw();
            }
            else {
                referenciaTablero.colocar(); // Choca con otra pieza
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            referenciaTablero.colocar(); // Choca con el borde inferior
        }
    }

    public void moverX(int columna) {
        try {
            if(columna > 0) {
                if (puedeMoverDerecha()) {
                    erase();
                    this.columna += columna;
                    draw();
                }
            }
            else {
                if(puedeMoverIzquierda()) {
                    erase();
                    this.columna += columna;
                    draw();
                }
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Fuera de rango X!");
        }
    }
}