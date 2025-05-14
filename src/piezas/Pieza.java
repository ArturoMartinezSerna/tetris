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

    public abstract void girar();
    public abstract void draw();
    public abstract void erase();
    public abstract void colocar();
    protected abstract boolean puedeBajar();
    protected abstract boolean puedeMoverDerecha();
    protected abstract boolean puedeMoverIzquierda();

    public void moverY(int y) {
        try {
            if(puedeBajar()) {
                erase();
                this.y += y;
                draw();
            }
            else {
                colocar(); // Choca con otra pieza
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            colocar(); // Choca con el borde inferior
        }
    }

    public void moverX(int x) {
        try {
            if(x > 0) {
                if (puedeMoverDerecha()) {
                    erase();
                    this.x += x;
                    draw();
                }
            }
            else {
                if(puedeMoverIzquierda()) {
                    erase();
                    this.x += x;
                    draw();
                }
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Fuera de rango X!");
        }
    }
}
