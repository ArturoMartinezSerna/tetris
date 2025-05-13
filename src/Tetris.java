import javax.swing.*;

public class Tetris extends JFrame {

    public Tetris() {
        setTitle("Tetris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para aplicacion al cerrar
        setSize(1064, 1083);
        setLocationRelativeTo(null); // Centra el elemento en la pantalla
        setResizable(false);
        this.add(new Tablero());
        setVisible(true);
    }


}
