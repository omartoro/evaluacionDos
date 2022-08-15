import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginForm extends JDialog{
    private JTextField emailTF;
    private JPasswordField passwordTF;
    private JButton OKButton;
    private JPanel loginPanel;
    private JButton cancelarButton;
    private User user;

    private void iniciarVentana(JFrame parent) {
        setTitle("MegaMarketyt");
        setContentPane(loginPanel);
        setMinimumSize(new Dimension(800,400));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
    }

    private User getAuthenticationUser(String email, String password) {
        User user =null;

        final String DB_URL="jdbc:mysql://localhost:3306/mitienda";
        final String USERNAME="root";
        final String PASSWORD="toor";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn= DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
            Statement stmt= conn.createStatement();
            String sql="SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement preparedStatement=conn.prepareStatement(sql);
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            System.out.println("conexion ok");
            ResultSet resultSet=preparedStatement.executeQuery();

            if(resultSet.next()){
                user=new User();
                user.setNombre(resultSet.getString("nombre"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
            }

            stmt.close();
            conn.close();

        }catch(Exception e){
            System.out.println("error de...");
            e.printStackTrace();
        }

        return user;
    }

    public LoginForm (JFrame parent){
        super(parent);
        iniciarVentana(parent);

        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email=emailTF.getText();
                String password=String.valueOf(passwordTF.getPassword());
                System.out.println("boton ok");
                user=getAuthenticationUser(email,password);
                farmaciaCrud vNueva = new farmaciaCrud(null);

                if (user!=null){
                    dispose();
                    vNueva.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(
                            LoginForm.this,"email o password incorrectos",
                            "intente nuevamente",
                            JOptionPane.ERROR_MESSAGE
                    );
                }

            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("boton cancel");
                dispose();
            }
        });
        setVisible(true);
    }

    public User getUser() {
        return user;
    }
}
