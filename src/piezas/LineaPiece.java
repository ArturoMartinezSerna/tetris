package piezas;

import paneles.Tablero;

public class LineaPiece extends Pieza {

    public LineaPiece(Tablero referenciaTablero) {
        super(referenciaTablero);
        color = 2;
        isHorizontal = false;
    }

    @Override
    public boolean puedeCrearse() {
        if(referenciaTablero.getTablero()[this.fila][this.columna] != 0 ||
                referenciaTablero.getTablero()[this.fila + 1][this.columna] != 0 ||
                referenciaTablero.getTablero()[this.fila + 2][this.columna] != 0 ||
                referenciaTablero.getTablero()[this.fila + 3][this.columna] != 0) {
            return false;
        }
        return true;
    }

    @Override
    public void girar() {
        if(puedeGirar()) {
            erase();
            isHorizontal = !isHorizontal;
            draw();
        }
    }

    public boolean puedeGirar() {
        try {
            if (isHorizontal) {
                for (int i = fila + 1; i <= fila + 3; i++) {
                    if (referenciaTablero.getTablero()[i][columna] != 0) {
                        return false;
                    }
                }
                return true;
            } else {
                for (int i = columna + 1; i <= columna + 3; i++) {
                    if (referenciaTablero.getTablero()[fila][i] != 0) {
                        return false;
                    }
                }
                return true;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No puede girar!");
            return false;
        }
    }

    @Override
    public void draw() {
        if(isHorizontal) {
            for(int i = columna; i <= columna + 3 ; i++) {
                referenciaTablero.getTablero()[this.fila][i] = color;
            }
        }
        else {
            for(int i = fila; i <= fila + 3 ; i++) {
                referenciaTablero.getTablero()[i][this.columna] = color;
            }
        }
        referenciaTablero.repaint();
    }

    @Override
    public void erase() {
        if(isHorizontal) {
            for(int i = columna; i <= columna + 3 ; i++) {
                referenciaTablero.getTablero()[this.fila][i] = 0;
            }
        }
        else {
            for(int i = fila; i <= fila + 3 ; i++) {
                referenciaTablero.getTablero()[i][this.columna] = 0;
            }
        }
    }

    @Override
    protected boolean puedeBajar() {
        if(isHorizontal) {
            for(int i = columna; i <= columna + 3 ; i++) {
                if(referenciaTablero.getTablero()[this.fila + 1][i] != 0) {
                    return false;
                }
            }
            return true;
        }
        else {
            return referenciaTablero.getTablero()[fila + 4][columna] == 0;
        }
    }

    @Override
    protected boolean puedeMoverDerecha() {
        if(isHorizontal) {
            return referenciaTablero.getTablero()[this.fila][columna + 4] == 0;
        }
        else {
            for(int i = fila; i <= fila + 3 ; i++) {
                if(referenciaTablero.getTablero()[i][columna + 1] != 0) {
                    System.out.println("Informacion!");
                    return false;
                }
            }
            return true;
        }
    }

    @Override
    protected boolean puedeMoverIzquierda() {
        if(isHorizontal) {
            return referenciaTablero.getTablero()[this.fila][columna -1] == 0;
        }
        else {
            for(int i = fila; i <= fila + 3 ; i++) {
                if(referenciaTablero.getTablero()[i][columna - 1] != 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
