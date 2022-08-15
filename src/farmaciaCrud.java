import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class farmaciaCrud extends JFrame
{
    private JPanel mainPanel;
    private JTextField nombreTF;
    private JTextField IdTF;
    private JTextField cantidadTF;
    private JTextField precioTF;
    private JButton crearButton;
    private JButton actualizarButton;
    private JButton borrarButton;
    private JLabel nombre;

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

            }
        });
    }
}
