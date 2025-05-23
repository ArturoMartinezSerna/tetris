package paneles;

import javax.swing.*;

public class Tetris extends JFrame {

    public Tetris() {
        setTitle("Tetris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para aplicacion al cerrar
        setSize(564, 883); // 64 por margenes laterales, 83 por margenes verticales
        setLocationRelativeTo(null); // Centra el elemento en la pantalla
        setResizable(false);
        this.add(new Tablero());
        setVisible(true);
    }


}
