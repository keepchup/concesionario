package VEHICULOS;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class busqueda {
    private JPanel busqueda;
    private JButton BuscarButton;
    private JTextField placa;
    private JButton registroButton;
    private JLabel marcaText;
    private JLabel cilindrajeText;
    private JLabel combustibleText;
    private JLabel colorText;
    private JLabel propietarioText;

    String url = "jdbc:mysql://localhost:3306/concesionario";
    String usuario = "root";
    String password = "123456";
    String sql = "select * from vehiculos where placa = ?";

    public busqueda() {
        JFrame frame = new JFrame("Busqueda");
        frame.setContentPane(busqueda);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        BuscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (placa.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(busqueda, "Ingrese una placa");
                    return;
                } else if(placa.getText().length() != 8){
                    JOptionPane.showMessageDialog(busqueda,"La placa debe tener 8 caracteres");
                    return;
                }

                try {
                    Connection connection = DriverManager.getConnection(url, usuario, password);
                    System.out.println("Conexion exitosa");
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, placa.getText());
                    ResultSet rs = statement.executeQuery();

                    if (rs.next()) {
                        String marca = rs.getString("marca");
                        String cilindraje = rs.getString("cilindraje");
                        String combustible = rs.getString("combustible");
                        String color = rs.getString("color");
                        String propietario = rs.getString("propietario");

                        marcaText.setText(marca);
                        cilindrajeText.setText(cilindraje);
                        combustibleText.setText(combustible);
                        colorText.setText(color);
                        propietarioText.setText(propietario);
                    } else{
                        JOptionPane.showMessageDialog(busqueda, "El placa no existe");
                    }

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame registro = new JFrame("Registro de Vehiculos");
                registro.setContentPane(new registro().registro);
                registro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                registro.pack();
                registro.setSize(500, 500);
                registro.setLocationRelativeTo(null);
                registro.setVisible(true);
                frame.dispose();
                new registro();
            }
        });
    }
}
