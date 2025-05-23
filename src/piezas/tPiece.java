package piezas;

import paneles.Tablero;

/*
     *   *   ***   *
    ***  **   *   **
         *         *
 */
public class tPiece extends Pieza {
    boolean miraArriba;

    public tPiece(Tablero referenciaTablero) {
        super(referenciaTablero);
        color = 5;
        miraArriba = true;
    }

    @Override
    public void girar() {
        if(puedeGirar()) {
            erase();
            if(!isHorizontal) {
                miraArriba = !miraArriba;
            }
            isHorizontal = !isHorizontal;
            draw();
        }
    }

    @Override
    public boolean puedeGirar() {
        return false;
    }

    @Override
    public void draw() {

    }

    @Override
    public void erase() {

    }

    @Override
    protected boolean puedeBajar() {
        return false;
    }

    @Override
    protected boolean puedeMoverDerecha() {
        return false;
    }

    @Override
    protected boolean puedeMoverIzquierda() {
        return false;
    }

    @Override
    public boolean puedeCrearse() {
        return false;
    }
}
