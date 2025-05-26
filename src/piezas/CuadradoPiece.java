package piezas;

import paneles.Tablero;

public class CuadradoPiece extends Pieza {

    public CuadradoPiece(Tablero referenciaTablero) {
        super(referenciaTablero);
        color = 1;
    }

    @Override
    public boolean puedeCrearse() {
        if(referenciaTablero.getTablero()[this.fila][this.columna] != 0 ||
        referenciaTablero.getTablero()[this.fila + 1][this.columna] != 0 ||
        referenciaTablero.getTablero()[this.fila][this.columna + 1] != 0 ||
        referenciaTablero.getTablero()[this.fila + 1][this.columna + 1] != 0) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean puedeBajar()  {
    if(referenciaTablero.getTablero()[this.fila + 2][this.columna] == 0 &&
                referenciaTablero.getTablero()[this.fila + 2][this.columna + 1] == 0) {
            return true;
        }
        return false;
    }

    @Override
    protected boolean puedeMoverIzquierda() {
        if(referenciaTablero.getTablero()[this.fila][this.columna -1] != 0 ||
                referenciaTablero.getTablero()[this.fila + 1][this.columna - 1] != 0) {
            return false;
        }
        return true;
    }

    @Override
    protected boolean puedeMoverDerecha() {
        if(referenciaTablero.getTablero()[this.fila][this.columna + 2] != 0 ||
                referenciaTablero.getTablero()[this.fila + 1][this.columna + 2] != 0) {
            return false;
        }
        return true;
    }

    @Override
    public void girar() {
        ;
    }

    @Override
    public boolean puedeGirar() { return false;}

    @Override
    public void draw() {
        referenciaTablero.getTablero()[this.fila][this.columna] = color;
        referenciaTablero.getTablero()[this.fila][this.columna + 1] = color;
        referenciaTablero.getTablero()[this.fila + 1][this.columna] = color;
        referenciaTablero.getTablero()[this.fila + 1][this.columna + 1] = color;
        referenciaTablero.repaint();
    }

    @Override
    public void erase() {
        referenciaTablero.getTablero()[this.fila][this.columna] = 0;
        referenciaTablero.getTablero()[this.fila + 1][this.columna] = 0;
        referenciaTablero.getTablero()[this.fila][this.columna + 1] = 0;
        referenciaTablero.getTablero()[this.fila + 1][this.columna + 1] = 0;
    }
}
