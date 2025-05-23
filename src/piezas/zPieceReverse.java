package piezas;

import paneles.Tablero;

/*
     --
    --
 */
public class zPieceReverse extends Pieza {

    public zPieceReverse(Tablero referenciaTablero) {
        super(referenciaTablero);
        color = 4;
    }

    @Override
    public void girar() {

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
