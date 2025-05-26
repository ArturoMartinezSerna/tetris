package piezas;

import paneles.Tablero;

/*
     --   *
    --    **
           *
 */
public class ZPieceReverse extends Pieza {

    public ZPieceReverse(Tablero referenciaTablero) {
        super(referenciaTablero);
        color = 4;
    }

    @Override
    public void girar() {
        if(puedeGirar()) {
            erase();
            isHorizontal = !isHorizontal;
            draw();
        }
    }

    @Override
    public boolean puedeGirar() {
        boolean puedeGirar;
        try {
            if (isHorizontal) {
                puedeGirar = referenciaTablero.getTablero()[this.fila][this.columna] == 0 && referenciaTablero.getTablero()[this.fila + 2][this.columna + 1] == 0;
            } else {
                puedeGirar = referenciaTablero.getTablero()[this.fila][this.columna + 1] == 0 && referenciaTablero.getTablero()[this.fila][this.columna + 2] == 0;
            }

            return puedeGirar;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No puede girar!");
            return false;
        }
    }

    @Override
    public void draw() {
        if(isHorizontal) {
            referenciaTablero.getTablero()[this.fila][this.columna+1] = color;
            referenciaTablero.getTablero()[this.fila][this.columna+2] = color;
            referenciaTablero.getTablero()[this.fila+1][this.columna] = color;
            referenciaTablero.getTablero()[this.fila+1][this.columna+1] = color;
        }
        else {
            referenciaTablero.getTablero()[this.fila][this.columna] = color;
            referenciaTablero.getTablero()[this.fila+1][this.columna] = color;
            referenciaTablero.getTablero()[this.fila+1][this.columna+1] = color;
            referenciaTablero.getTablero()[this.fila+2][this.columna+1] = color;
        }
        referenciaTablero.repaint();
    }

    @Override
    public void erase() {
        if(isHorizontal) {
            referenciaTablero.getTablero()[this.fila][this.columna+1] = 0;
            referenciaTablero.getTablero()[this.fila][this.columna+2] = 0;
            referenciaTablero.getTablero()[this.fila+1][this.columna] = 0;
            referenciaTablero.getTablero()[this.fila+1][this.columna+1] = 0;
        }
        else {
            referenciaTablero.getTablero()[this.fila][this.columna] = 0;
            referenciaTablero.getTablero()[this.fila+1][this.columna] = 0;
            referenciaTablero.getTablero()[this.fila+1][this.columna+1] = 0;
            referenciaTablero.getTablero()[this.fila+2][this.columna+1] = 0;
        }
    }

    @Override
    protected boolean puedeBajar() {
        boolean puedeBajar;

        if(isHorizontal) {
            puedeBajar = referenciaTablero.getTablero()[this.fila+2][this.columna] == 0 &&
                    referenciaTablero.getTablero()[this.fila+2][this.columna+1] == 0 &&
                    referenciaTablero.getTablero()[this.fila+1][this.columna+2] == 0;
        }
        else {
            puedeBajar = referenciaTablero.getTablero()[this.fila+2][this.columna] == 0 &&
                    referenciaTablero.getTablero()[this.fila+3][this.columna+1] == 0;
        }
        return puedeBajar;
    }

    @Override
    protected boolean puedeMoverDerecha() {
        if(isHorizontal) {
            return referenciaTablero.getTablero()[this.fila][this.columna+3] == 0 &&
                    referenciaTablero.getTablero()[this.fila+1][this.columna+2] == 0;
        }
        else {
            return referenciaTablero.getTablero()[this.fila][this.columna+1] == 0 &&
                    referenciaTablero.getTablero()[this.fila+1][this.columna+2] == 0 &&
                    referenciaTablero.getTablero()[this.fila+2][this.columna+2] == 0;
        }
    }

    @Override
    protected boolean puedeMoverIzquierda() {
        if(isHorizontal) {
            return referenciaTablero.getTablero()[this.fila][this.columna] == 0 &&
                    referenciaTablero.getTablero()[this.fila+1][this.columna-1] == 0;
        }
        else {
            return referenciaTablero.getTablero()[this.fila][this.columna-1] == 0 &&
                    referenciaTablero.getTablero()[this.fila+1][this.columna-1] == 0 &&
                    referenciaTablero.getTablero()[this.fila+2][this.columna] == 0;
        }
    }

    @Override
    public boolean puedeCrearse() {
        return (referenciaTablero.getTablero()[this.fila][this.columna+1] == 0 &&
                referenciaTablero.getTablero()[this.fila][this.columna+2] == 0 &&
                referenciaTablero.getTablero()[this.fila+1][this.columna] == 0 &&
                referenciaTablero.getTablero()[this.fila+1][this.columna+1] == 0);
    }
}
