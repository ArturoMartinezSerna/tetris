package piezas;

import paneles.Tablero;
/*
    **      *
     **    **
           *
 */
public class zPiece extends Pieza {

    public zPiece(Tablero referenciaTablero) {
        super(referenciaTablero);
        color = 3;
    }

    @Override
    public void girar() {
        if(puedeGirar()) {
            erase();
            isHorizontal = !isHorizontal;
            draw();
        }
        else {
            System.out.println("No puede girar!");
        }
    }

    @Override
    public boolean puedeGirar() {
        boolean puedeGirar;
        try {
            if(isHorizontal) {
                puedeGirar = referenciaTablero.getTablero()[this.fila+1][this.columna] == 0 && referenciaTablero.getTablero()[this.fila+2][this.columna] == 0;
            }
            else {
                puedeGirar = referenciaTablero.getTablero()[this.fila][this.columna] == 0 && referenciaTablero.getTablero()[this.fila+1][this.columna+2] == 0;
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
            referenciaTablero.getTablero()[this.fila][this.columna] = color;
            referenciaTablero.getTablero()[this.fila][this.columna + 1] = color;
            referenciaTablero.getTablero()[this.fila+1][this.columna + 1] = color;
            referenciaTablero.getTablero()[this.fila+1][this.columna + 2] = color;
        }
        else {
            referenciaTablero.getTablero()[this.fila][this.columna+1] = color;
            referenciaTablero.getTablero()[this.fila+1][this.columna] = color;
            referenciaTablero.getTablero()[this.fila+1][this.columna+1] = color;
            referenciaTablero.getTablero()[this.fila+2][this.columna] = color;
        }

        referenciaTablero.repaint();
    }

    // Erase hace lo mismo que draw. reordenar todos los metodos de todas las piezas
    @Override
    public void erase() {
        int color = 0;
        if(isHorizontal) {
            referenciaTablero.getTablero()[this.fila][this.columna] = color;
            referenciaTablero.getTablero()[this.fila][this.columna + 1] = color;
            referenciaTablero.getTablero()[this.fila+1][this.columna + 1] = color;
            referenciaTablero.getTablero()[this.fila+1][this.columna + 2] = color;
        }
        else {
            referenciaTablero.getTablero()[this.fila][this.columna+1] = color;
            referenciaTablero.getTablero()[this.fila+1][this.columna] = color;
            referenciaTablero.getTablero()[this.fila+1][this.columna+1] = color;
            referenciaTablero.getTablero()[this.fila+2][this.columna] = color;
        }

        referenciaTablero.repaint();
    }

    @Override
    protected boolean puedeBajar() {
        boolean puede;
        if(isHorizontal) {
            if(referenciaTablero.getTablero()[this.fila+1][this.columna] != 0)
                puede = false;
            else if(referenciaTablero.getTablero()[this.fila + 2][this.columna+1] != 0)
                puede = false;
            else if(referenciaTablero.getTablero()[this.fila + 2][this.columna + 2] != 0)
                puede = false;
            else
                puede = true;
        }
        else {
            if(referenciaTablero.getTablero()[this.fila+3][this.columna] != 0)
                puede = false;
            else if(referenciaTablero.getTablero()[this.fila+2][this.columna+1] != 0)
                puede = false;
            else
                puede = true;
        }

        return puede;
    }

    @Override
    protected boolean puedeMoverDerecha() {
        boolean puedeMoverDerecha;
        try {
            if (isHorizontal) {
                puedeMoverDerecha = referenciaTablero.getTablero()[this.fila][this.columna + 2] == 0 &&
                        referenciaTablero.getTablero()[this.fila + 1][this.columna + 3] == 0;
            } else {
                puedeMoverDerecha = referenciaTablero.getTablero()[this.fila][this.columna+2] == 0 &&
                        referenciaTablero.getTablero()[this.fila+1][this.columna+2] == 0 &&
                        referenciaTablero.getTablero()[this.fila+2][this.columna+1] == 0;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            puedeMoverDerecha = false;
            System.out.println("Fuera de rango X!");
        }
        return puedeMoverDerecha;
    }

    @Override
    protected boolean puedeMoverIzquierda() {
        boolean puedeMoverIzquierda;
        try {
            if(isHorizontal) {
                puedeMoverIzquierda = referenciaTablero.getTablero()[this.fila][this.columna-1] == 0 &&
                        referenciaTablero.getTablero()[this.fila+1][this.columna] == 0;
            }
            else {
                puedeMoverIzquierda = referenciaTablero.getTablero()[this.fila][this.columna] == 0 &&
                        referenciaTablero.getTablero()[this.fila + 1][this.columna-1] == 0 &&
                        referenciaTablero.getTablero()[this.fila + 2][this.columna-1] == 0;
            }
        } catch(ArrayIndexOutOfBoundsException e) {
            puedeMoverIzquierda = false;
            System.out.println("Fuera de rango X!");
        }
        return puedeMoverIzquierda;
    }

    @Override
    public boolean puedeCrearse() {
        return (referenciaTablero.getTablero()[this.fila][this.columna+1] == 0 &&
                referenciaTablero.getTablero()[this.fila+1][this.columna] == 0 &&
                referenciaTablero.getTablero()[this.fila+1][this.columna+1] == 0 &&
                referenciaTablero.getTablero()[this.fila+2][this.columna] == 0);

    }
}
