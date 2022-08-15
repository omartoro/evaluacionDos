import javax.swing.*;

public class Programa
{
    public static void main(String[] args) {
        LoginForm loginForm = new LoginForm(null);
        User user = loginForm.getUser();

        if( user != null ) {
            System.out.println("Autenticacion correcta:"+user.getNombre());
            System.out.println("email: "+user.getEmail());
            System.out.println("clave: "+user.getPassword());
        }
        else {
            System.out.println("Autenticacion fallida");
        }
    }
}
