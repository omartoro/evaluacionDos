import javax.swing.*;

public class farmaciaCrud {
    private JPanel mainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton crearButton;
    private JButton actualizarButton;
    private JButton borrarButton;


    public static void main(String[] args) {
        JFrame frame = new JFrame("evaluacionDos");
        frame.setContentPane(new farmaciaCrud().mainPanel);
        frame.setTitle("INVENTARIO 1");
        frame.setSize(600,300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
