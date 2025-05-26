package piezas;

import paneles.Tablero;

import java.util.Scanner;

/*
     0     1    2     3
     ###   #      #   ##
     #     #    ###    #
           ##          #

 */

public class LPiece extends Pieza {
    int posicion;

    public LPiece(Tablero referenciaTablero) {
        super(referenciaTablero);
        color = 6;
        posicion = 0;
    }

    @Override
    public void girar() {
        if(puedeGirar()) {
            erase();
            if (posicion == 3)
                posicion = 0;
            else
                posicion++;
            draw();
        }
        else {
            System.out.println("No puede girar!");
        }
    }

    @Override
    public boolean puedeGirar() {
        try {
            switch (posicion) {
                case 0: {
                    return referenciaTablero.getTablero()[this.fila + 2][this.columna] == 0
                            && referenciaTablero.getTablero()[this.fila + 2][this.columna + 1] == 0;
                }
                case 1: {
                    return referenciaTablero.getTablero()[this.fila + 0][this.columna + 2] == 0
                            && referenciaTablero.getTablero()[this.fila + 1][this.columna + 1] == 0
                            && referenciaTablero.getTablero()[this.fila + 1][this.columna + 2] == 0;
                }
                case 2: {
                    return referenciaTablero.getTablero()[this.fila][this.columna] == 0
                            && referenciaTablero.getTablero()[this.fila][this.columna + 1] == 0
                            && referenciaTablero.getTablero()[this.fila + 2][this.columna + 1] == 0;
                }
                case 3: {
                    return referenciaTablero.getTablero()[this.fila][this.columna + 2] == 0
                            && referenciaTablero.getTablero()[this.fila + 1][this.columna] == 0;
                }
                default:
                    return false;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No puede girar!");
            return false;
        }
    }

    @Override
    public void draw() {
        draw(false);

        for(int i = 0; i < referenciaTablero.getTablero().length; i++) {
            for(int j = 0; j < referenciaTablero.getTablero()[0].length; j++) {
                System.out.print(referenciaTablero.getTablero()[i][j]);
            }
            System.out.println();
        }

        this.referenciaTablero.repaint();
    }

    /*
     0     1    2     3
     ###   #      #   ##
     #     #    ###    #
           ##          #

     */

    @Override
    public void erase() {
        draw(true);
    }
        private void draw(boolean borramos) {
            int colorDibujo = borramos ? 0 : this.color;
            switch (posicion) {
                case 0: {
                    referenciaTablero.getTablero()[this.fila][this.columna] = colorDibujo;
                    referenciaTablero.getTablero()[this.fila][this.columna + 1] = colorDibujo;
                    referenciaTablero.getTablero()[this.fila][this.columna + 2] = colorDibujo;
                    referenciaTablero.getTablero()[this.fila+1][this.columna] = colorDibujo;
                } break;
                case 1: {
                    referenciaTablero.getTablero()[this.fila][this.columna] = colorDibujo;
                    referenciaTablero.getTablero()[this.fila+1][this.columna] = colorDibujo;
                    referenciaTablero.getTablero()[this.fila+2][this.columna] = colorDibujo;
                    referenciaTablero.getTablero()[this.fila+2][this.columna+1] = colorDibujo;
                } break;
                case 2: {
                    referenciaTablero.getTablero()[this.fila][this.columna + 2] = colorDibujo;
                    referenciaTablero.getTablero()[this.fila+1][this.columna] = colorDibujo;
                    referenciaTablero.getTablero()[this.fila+1][this.columna + 1] = colorDibujo;
                    referenciaTablero.getTablero()[this.fila+1][this.columna + 2] = colorDibujo;
                } break;
                case 3: {
                    referenciaTablero.getTablero()[this.fila][this.columna] = colorDibujo;
                    referenciaTablero.getTablero()[this.fila][this.columna + 1] = colorDibujo;
                    referenciaTablero.getTablero()[this.fila + 1][this.columna + 1] = colorDibujo;
                    referenciaTablero.getTablero()[this.fila+2][this.columna+1] = colorDibujo;
                } break;
            }
        }
    @Override
    protected boolean puedeBajar() {
        try {
            System.out.println("¿PODRA BAJAR?");
            switch (posicion) {
                case 0: {
                    return referenciaTablero.getTablero()[this.fila+2][this.columna] == 0
                            && referenciaTablero.getTablero()[this.fila+1][this.columna+1] == 0
                            && referenciaTablero.getTablero()[this.fila+1][this.columna+2] == 0;
                }
                case 1: {
                    return referenciaTablero.getTablero()[this.fila+3][this.columna] == 0
                            && referenciaTablero.getTablero()[this.fila+3][this.columna+1] == 0;
                }
                case 2: {
                    return referenciaTablero.getTablero()[this.fila+2][this.columna] == 0
                            && referenciaTablero.getTablero()[this.fila+2][this.columna+1] == 0
                            && referenciaTablero.getTablero()[this.fila+2][this.columna+2] == 0;
                }
                case 3: {
                    return referenciaTablero.getTablero()[this.fila+1][this.columna] == 0
                            && referenciaTablero.getTablero()[this.fila+3][this.columna+1] == 0;
                }
                default: return false;
            }
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Chocado con el borde del tablero!");
            return false;
        }
    }

    @Override
    protected boolean puedeMoverDerecha() {
        try {
            switch (posicion) {
                case 0: {
                    return referenciaTablero.getTablero()[this.fila][this.columna+3] == 0
                            && referenciaTablero.getTablero()[this.fila+1][this.columna+1] == 0;
                }
                case 1: {
                    return referenciaTablero.getTablero()[this.fila][this.columna+1] == 0
                            && referenciaTablero.getTablero()[this.fila+1][this.columna+1] == 0
                            && referenciaTablero.getTablero()[this.fila+2][this.columna+2] == 0;
                }
                case 2: {
                    return referenciaTablero.getTablero()[this.fila][this.columna+3] == 0
                            && referenciaTablero.getTablero()[this.fila+1][this.columna+3] == 0;
                }
                case 3: {
                    return referenciaTablero.getTablero()[this.fila][this.columna+2] == 0
                            && referenciaTablero.getTablero()[this.fila+1][this.columna+2] == 0
                            && referenciaTablero.getTablero()[this.fila+2][this.columna+2] == 0;
                }
                default: return false;
            }
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Chocado con el borde del tablero!");
            return false;
        }
    }

    /*
     0     1    2     3
     ###   #      #   ##
     #     #    ###    #
           ##          #

     */

    @Override
    protected boolean puedeMoverIzquierda() {
        try {
            switch (posicion) {
                case 0: {
                    return referenciaTablero.getTablero()[this.fila][this.columna-1] == 0
                            && referenciaTablero.getTablero()[this.fila+1][this.columna-1] == 0;
                }
                case 1: {
                    return referenciaTablero.getTablero()[this.fila][this.columna-1] == 0
                            && referenciaTablero.getTablero()[this.fila+1][this.columna-1] == 0
                            && referenciaTablero.getTablero()[this.fila+2][this.columna-1] == 0;
                }
                case 2: {
                    return referenciaTablero.getTablero()[this.fila][this.columna+1] == 0
                            && referenciaTablero.getTablero()[this.fila+1][this.columna-1] == 0;
                }
                case 3: {
                    return referenciaTablero.getTablero()[this.fila][this.columna-1] == 0
                            && referenciaTablero.getTablero()[this.fila+1][this.columna] == 0
                            && referenciaTablero.getTablero()[this.fila+2][this.columna] == 0;
                }
                default: return false;
            }
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Chocado con el borde del tablero!");
            return false;
        }
    }

    @Override
    public boolean puedeCrearse() {
        return referenciaTablero.getTablero()[this.fila][this.columna] == 0 &&
        referenciaTablero.getTablero()[this.fila][this.columna + 1] == 0 &&
        referenciaTablero.getTablero()[this.fila][this.columna + 2] == 0 &&
        referenciaTablero.getTablero()[this.fila+1][this.columna] == 0;
    }
}
