import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class farmaciaCrud extends JFrame
{
    private ConexionProduct conn = ConexionProduct.getInstancia();
    private JPanel mainPanel;
    private JTextField nombreTF;
    private JTextField IdTF;
    private JTextField cantidadTF;
    private JTextField precioTF;
    private JButton crearButton;
    private JButton actualizarButton;
    private JButton borrarButton;
    private JLabel nombre;

    private void limpiarPantalla() {
        cantidadTF.setText("");
        nombreTF.setText("");
        precioTF.setText("");
        IdTF.setText("");
    }

    public farmaciaCrud(JFrame parent) {
        setTitle("MegaMarketyt");
        setContentPane(mainPanel);
        setSize(800,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreTF.getText();
                String cantidad = cantidadTF.getText();
                String precio = precioTF.getText();
                try {
                    conn.conectarBasedeDatos();
                    conn.insetarDatos(nombre, cantidad, precio);
                    System.out.println("InSerccion Exitosa");;
                    conn.cerrarBasedeDatos();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                limpiarPantalla();
            }
        });

        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = IdTF.getText();
                try {
                    conn.conectarBasedeDatos();
                    conn.eliminarDatos(id);
                    System.out.println("Elimnacion Exitosa");;
                    conn.cerrarBasedeDatos();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                limpiarPantalla();
            }
        });
        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = IdTF.getText();
                String nombre = nombreTF.getText();
                String cantidad = cantidadTF.getText();
                String precio = precioTF.getText();
                try {
                    conn.conectarBasedeDatos();
                    conn.actualizarDatos(nombre, cantidad, precio, id);
                    System.out.println("Modificacion Exitosa");;
                    conn.cerrarBasedeDatos();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                limpiarPantalla();
            }
        });
    }
}
