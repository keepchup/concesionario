package VEHICULOS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class registro{
    public JPanel registro;
    private JButton ingresarDatosButton;
    private JButton limpiarFormularioButton;
    private JTextField propietariotext;
    private JTextField placatext;
    private JTextField maracatext;
    private JTextField colortext;
    private JTextField combustibletext;
    private JTextField cilindrajetext;
    private JLabel propietario;
    private JLabel color;
    private JLabel combustible;
    private JLabel cilindraje;
    private JLabel marca;
    private JLabel placa;
    private JButton buscarButton;

    String url = "jdbc:mysql://localhost:3306/concesionario";
    String usuario = "root";
    String password = "123456";
    String sql = "INSERT INTO vehiculos (placa, marca, cilindraje, combustible, color, propietario) values (?,?,?,?,?,?)";

    public registro() {
        ingresarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                vehiculos car1 = new vehiculos();
                if (placa.getText().isEmpty() || marca.getText().isEmpty() || cilindrajetext.getText().isEmpty() || combustible.getText().isEmpty() || color.getText().isEmpty() || propietario.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Los campos deben estar llenos");
                    return;
                } else if (placatext.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ingrese un numero de placa valido");
                }

                car1.setPlaca(placatext.getText());
                car1.setMarca(maracatext.getText());
                car1.setCilindraje(Double.parseDouble(cilindrajetext.getText()));
                car1.setCombustible(combustibletext.getText());
                car1.setColor(colortext.getText());
                car1.setPropietario(propietariotext.getText());

                try {
                    System.out.println("Conexion exitosa");
                    Connection connection = DriverManager.getConnection(url, usuario, password);
                    PreparedStatement declarar = connection.prepareStatement(sql);
                    declarar.setString(1, placatext.getText());
                    declarar.setString(2, maracatext.getText());
                    declarar.setString(3, cilindrajetext.getText());
                    declarar.setString(4, combustibletext.getText());
                    declarar.setString(5, colortext.getText());
                    declarar.setString(6, propietariotext.getText());
                    declarar.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Vehiculo registrado correctamente");

                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null,"Error al registrar el vehiculo");
                    ex.printStackTrace();
                }
            }
        });
        limpiarFormularioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                placatext.setText(null);
                maracatext.setText(null);
                cilindrajetext.setText(null);
                combustibletext.setText(null);
                colortext.setText(null);
                propietariotext.setText(null);
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new busqueda();
            }
        });
    }
}
