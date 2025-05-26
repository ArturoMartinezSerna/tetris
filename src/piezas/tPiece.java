package piezas;

import paneles.Tablero;

/*

       0      1        2        3

       #      #       ###       #
      ###     ##       #       ##
              #                 #
*/
public class tPiece extends Pieza {
    int posicion;

    public tPiece(Tablero referenciaTablero) {
        super(referenciaTablero);
        color = 5;
        posicion = 0;
    }

    @Override
    public void girar() {
        if(puedeGirar()) {
            erase();
            if(posicion == 3)
                posicion = 0;
            else
                posicion++;
            draw();
        }
    }

    @Override
    public boolean puedeGirar() {
        try{
            switch(posicion) {
                case 0: {
                    if(this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 0] == 0
                    && this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 2] == 0)
                        return true;
                } break;
                case 1:{
                    if(this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 1] == 0
                        && this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 2] == 0)
                        return true;
                } break;
                case 2:{
                    if(this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 0] == 0 &&
                            this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 2] == 0)
                        return true;
                } break;
                case 3:{
                    if(this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 2] == 0)
                        return true;
                } break;
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No puede girar!");
            return false;
        }
    }

    public void draw(boolean borramos) {
        int colorDibujo = borramos ? 0 : color;

        switch(posicion) {
            case 0: {
                this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 1] = colorDibujo;
                this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 0] = colorDibujo;
                this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 1] = colorDibujo;
                this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 2] = colorDibujo;
            } break;
            case 1: {
                this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 0] = colorDibujo;
                this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 0] = colorDibujo;
                this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 1] = colorDibujo;
                this.referenciaTablero.getTablero()[this.fila + 2][this.columna + 0] = colorDibujo;
            } break;
            case 2: {
                this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 0] = colorDibujo;
                this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 1] = colorDibujo;
                this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 2] = colorDibujo;
                this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 1] = colorDibujo;
            } break;
            case 3: {
                this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 1] = colorDibujo;
                this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 0] = colorDibujo;
                this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 1] = colorDibujo;
                this.referenciaTablero.getTablero()[this.fila + 2][this.columna + 1] = colorDibujo;
            } break;
        }
        referenciaTablero.repaint();
    }

    /*

       0      1        2        3

       #      #       ###       #
      ###     ##       #       ##
              #                 #
     */

    @Override
    public void draw() {
        draw(false);
    }

    @Override
    public void erase() {
        draw(true);
    }

    @Override
    protected boolean puedeBajar() {
        try {
            switch (posicion) {
                case 0: {
                    return (this.referenciaTablero.getTablero()[this.fila + 2][this.columna + 0] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 2][this.columna + 1] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 2][this.columna + 2] == 0);
                }
                case 1: {
                    return (this.referenciaTablero.getTablero()[this.fila + 2][this.columna + 1] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 3][this.columna + 0] == 0);
                }
                case 2: {
                    return (this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 0] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 2][this.columna + 1] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 2] == 0);
                }
                case 3: {
                    return (this.referenciaTablero.getTablero()[this.fila + 2][this.columna + 0] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 3][this.columna + 1] == 0);
                }
                default: return false;
            }
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Choca con el borde del tablero!");
            return false;
        }
    }

    @Override
    protected boolean puedeMoverDerecha() {
        try {
            switch (posicion) {
                case 0: {
                    return (this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 2] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 3] == 0);
                }
                case 1: {
                    return (this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 1] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 2] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 2][this.columna + 1] == 0);
                }
                case 2: {
                    return (this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 3] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 2] == 0);
                }
                case 3: {
                    return (this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 2] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 2] == 0)
                            && this.referenciaTablero.getTablero()[this.fila + 2][this.columna + 2] == 0;
                }
                default:
                    return false;
            }
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Choca con el borde del tablero!");
            return false;
        }
    }

    /*

      0       1       2        3

       #      #       ###       #
      ###     ##       #       ##
              #                 #
     */

    @Override
    protected boolean puedeMoverIzquierda() {
        try {
            switch (posicion) {
                case 0: {
                    return (this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 0] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 1][this.columna + -1] == 0);
                }
                case 1: {
                    return (this.referenciaTablero.getTablero()[this.fila + 0][this.columna + -1] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 1][this.columna + -1] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 2][this.columna + -1] == 0);
                }
                case 2: {
                    return (this.referenciaTablero.getTablero()[this.fila + 0][this.columna + -1] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 0] == 0);
                }
                case 3: {
                    return (this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 0] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 1][this.columna + -1] == 0
                            && this.referenciaTablero.getTablero()[this.fila + 2][this.columna + 0] == 0);
                }
                default:
                    return false;
            }
        } catch(IndexOutOfBoundsException e) {
            System.out.println("Choca con el borde del tablero!");
            return false;
        }
    }

    @Override
    public boolean puedeCrearse() {
        return (this.referenciaTablero.getTablero()[this.fila + 0][this.columna + 1] == 0
        && this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 0] == 0
        && this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 1] == 0
        && this.referenciaTablero.getTablero()[this.fila + 1][this.columna + 2] == 0);
    }
}
