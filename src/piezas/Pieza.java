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
    public abstract void girar();
    public abstract void draw();
    public abstract void erase();
    public abstract void colocar();
    protected abstract boolean puedeBajar();

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
}
