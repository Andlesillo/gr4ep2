import entidades.Administrador;
import entidades.Inmueble;
import entidades.Perfil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        System.out.println("¡HOLA! Identifícate");
        System.out.println(" ");

        // Cargar el driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Datos de conexión
        String database = "RoomMateEP2";
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



        /* ------------------------------------ GETTERS AND SETTERS ------------------------------------ */

        // Crear una instancia de la clase Inmueble
        Inmueble inmueble = new Inmueble();

        // Establecer los valores utilizando los setters
        inmueble.setNombreInmueble("Apartamento en Miraflores");
        inmueble.setId_arrendador(1);
        inmueble.setEstadoInmueble("Disponible");
        inmueble.setCondicion("Excelente");
        inmueble.setPrecioNoche(100.00F);
        inmueble.setHistorialDeArriendos(10);
        inmueble.setEspacios(8);

        // Guardar los datos en la base de datos utilizando los getters
        String nombreInmueble = inmueble.getNombreInmueble();
        int idArrendador = inmueble.getId_arrendador();
        String estadoInmueble = inmueble.getEstadoInmueble();
        String condicion = inmueble.getCondicion();
        double precioNoche = inmueble.getPrecioNoche();
        int historialDeArriendos = inmueble.getHistorialDeArriendos();
        int espacios = inmueble.getEspacios();


    }
}