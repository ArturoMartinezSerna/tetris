package piezas;

public class Cuadrado extends Pieza {

    public Cuadrado() {
        super();
        color = 1;
    }

    @Override
    public int[][] mover(int[][] tablero, int x, int y) {
        tablero = erase(tablero);
        this.x += x;
        this.y += y;
        tablero = draw(tablero);
        return tablero;
    }

    @Override
    public int[][] girar(int[][] tablero) {
        return tablero;
    }

    @Override
    public int[][] draw(int[][] tablero) {
        tablero[this.x][this.y] = color;
        tablero[this.x + 1][this.y] = color;
        tablero[this.x][this.y + 1] = color;
        tablero[this.x + 1][this.y + 1] = color;
        return tablero;
    }

    @Override
    public int[][] erase(int[][] tablero) {
        tablero[this.x][this.y] = 0;
        tablero[this.x + 1][this.y] = 0;
        tablero[this.x][this.y + 1] = 0;
        tablero[this.x + 1][this.y + 1] = 0;
        return tablero;
    }
}
