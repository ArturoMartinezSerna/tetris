package piezas;

public abstract class Pieza {

    int x, y, color;

    public Pieza() {
        this.x = 4;
        this.y = 0;
    }

    public abstract int[][] mover(int[][] tablero, int x, int y);
    public abstract int[][] girar(int[][] tablero);
    public abstract int[][] draw(int[][] tablero);
    public abstract int[][] erase(int[][] tablero);
}
