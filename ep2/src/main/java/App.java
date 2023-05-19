import entidades.Perfil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        System.out.println("¡HOLA! Identifícate");
        System.out.println(" ");

        // Cargar el driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Datos de conexión
        String database = "RoomMateEP22";
        String user = "root";
        String password = "root";

        // Concatenar datos de conexión en la URL
        String url = "jdbc:mysql://localhost:3306/" + database + "?user=" + user + "&password=" + password;

        // Establecer conexión con la base de datos
        Connection con = DriverManager.getConnection(url);

        Perfil perfil = new Perfil();
        perfil.validarPerfil(con);




        // Cerrar la conexión
        con.close();
    }
}
