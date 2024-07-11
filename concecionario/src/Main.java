import VEHICULOS.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame registro = new JFrame("Registro de Vehiculos");
        registro.setContentPane(new registro().registro);
        registro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registro.pack();
        registro.setSize(500, 500);
        registro.setLocationRelativeTo(null);
        registro.setVisible(true);
    }
}