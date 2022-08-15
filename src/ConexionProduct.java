import java.sql.*;
import java.util.Scanner;

public class ConexionProduct
{
    private static Connection conexion;
    private static ConexionProduct instancia;
    private final String URL = "jdbc:mysql://localhost:3306/mitienda";
    private final String USER = "root";
    private final String PASSWORD = "toor";

    private ConexionProduct() {

    }

    public Connection conectarBasedeDatos() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            return conexion;
        }catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }

    public void cerrarBasedeDatos() throws SQLException {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
            conexion.close();
        }
    }

    public static ConexionProduct getInstancia() {
        if (instancia == null) {
            instancia = new ConexionProduct();
        }
        return instancia;
    }

    public void insetarDatos(String nombre, String cantidad, String precio) {
        try {
            PreparedStatement insert = conexion.prepareStatement("INSERT INTO productos VALUES(?, ?, ?, ?)");
            insert.setString(1, null);
            insert.setString(2, nombre);
            insert.setString(3, cantidad);
            insert.setString(4, precio);
            insert.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void eliminarDatos(String id) {
        try {
            PreparedStatement eliminar = conexion.prepareStatement("DELETE from productos WHERE id = ?");
            eliminar.setString(1, id);
            eliminar.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actualizarDatos(String nombre, String cantidad, String precio, String id) {
        try {
            PreparedStatement modificar = conexion.prepareStatement("UPDATE productos SET nombre = ?, cantidad = ?, precio = ? WHERE id =  " + id);
            modificar.setString(1, nombre);
            modificar.setString(2, cantidad);
            modificar.setString(3, precio);
            modificar.executeUpdate();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
