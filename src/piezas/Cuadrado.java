package piezas;

import paneles.Tablero;

public class Cuadrado extends Pieza {

    public Cuadrado(Tablero referenciaTablero) {
        super(referenciaTablero);
        color = 1;
    }



    @Override
    protected boolean puedeBajar()  {
    if(referenciaTablero.getTablero()[this.x][this.y + 2] == 0 &&
                referenciaTablero.getTablero()[this.x+1][this.y + 2] == 0) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean puedeMoverIzquierda() {
        if(referenciaTablero.getTablero()[this.x-1][this.y] != 0 ||
                referenciaTablero.getTablero()[this.x-1][this.y + 1] != 0) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean puedeMoverDerecha() {
        if(referenciaTablero.getTablero()[this.x+2][this.y] != 0 ||
                referenciaTablero.getTablero()[this.x+2][this.y + 1] != 0) {
            return false;
        }
        return true;
    }

    @Override
    public void colocar() {
        referenciaTablero.generarPiezaAleatoria();
    }

    @Override
    public void girar() {
        ;
    }

    @Override
    public void draw() {
        referenciaTablero.getTablero()[this.x][this.y] = color;
        referenciaTablero.getTablero()[this.x + 1][this.y] = color;
        referenciaTablero.getTablero()[this.x][this.y + 1] = color;
        referenciaTablero.getTablero()[this.x + 1][this.y + 1] = color;
    }

    @Override
    public void erase() {
        referenciaTablero.getTablero()[this.x][this.y] = 0;
        referenciaTablero.getTablero()[this.x + 1][this.y] = 0;
        referenciaTablero.getTablero()[this.x][this.y + 1] = 0;
        referenciaTablero.getTablero()[this.x + 1][this.y + 1] = 0;
    }
}
