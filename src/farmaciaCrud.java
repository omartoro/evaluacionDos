import javax.swing.*;

public class farmaciaCrud extends JFrame
{
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton crearButton;
    private JButton actualizarButton;
    private JButton borrarButton;

    public farmaciaCrud(JFrame parent) {
        setTitle("MegaMarketyt");
        setContentPane(mainPanel);
        setSize(800,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
