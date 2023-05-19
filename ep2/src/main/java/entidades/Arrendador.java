package entidades;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Arrendador extends Perfil{
    private int id_arrendador;
    private String nombres;
    private String apellidos;
    private int edad;
    private String TipoDocumento;
    private String NumDocumento;
    private String Celular;
    private String correo;
    private int id_perfil;

    // Constructor y otros métodos de la clase

        public void accionArrendador(Connection con) throws SQLException {

            System.out.println("1) Insertar inmueble        2) ");
            System.out.println(" ");


            Scanner scannerEleccion = new Scanner(System.in);
            System.out.println(" --------------------- ");
            int EleccionInput = scannerEleccion.nextInt();

            if (EleccionInput == 1){
                insertarInmueble(con);
            }
        }
        public void insertarArrendador(Connection con) throws SQLException {
            Scanner scanner = new Scanner(System.in);

            // Obtener los valores ingresados en los setters
        String nombres = getNombres();
        String apellidos = getApellidos();
        int edad = getEdad();
        String tipoDocumento = getTipoDocumento();
        String numDocumento = getNumDocumento();
        String celular = getCelular();
        String correo = getCorreo();

            System.out.print("Nombre de usuario: ");
            String INnombreUsuario = scanner.nextLine();

            System.out.print("Contraseña: ");
            String INclave = scanner.nextLine();


        String nombreUsuario = INnombreUsuario; // Agrega el nombre de usuario deseado
        String clave = INclave; // Agrega la clave deseada
        String correoPerfil = ""; // Agrega el correo de perfil deseado

        // Llamar al stored procedure InsertarArrendador
        String callProcedure = "{ CALL InsertarArrendador(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";
        CallableStatement statement = con.prepareCall(callProcedure);

        // Establecer valores de parámetros
        statement.setString(1, nombres);
        statement.setString(2, apellidos);
        statement.setInt(3, edad);
        statement.setString(4, tipoDocumento);
        statement.setString(5, numDocumento);
        statement.setString(6, celular);
        statement.setString(7, correo);
        statement.setString(8, nombreUsuario);
        statement.setString(9, clave);
        statement.setString(10, correoPerfil);

        // Ejecutar el stored procedure
        statement.execute();

        System.out.println("Arrendador insertado exitosamente.");
    }

        public void insertarInmueble(Connection con) throws  SQLException{
            Inmueble inmueble = new Inmueble();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese los datos del nuevo arrendador:");

            System.out.print("Nombre del inmueble: ");
            String nombre = scanner.nextLine();
            inmueble.setNombreInmueble(nombre);


            System.out.print("id del arrendador: ");
            int id_arrendador = scanner.nextInt();
            inmueble.setId_arrendador(id_arrendador);

            String asdf = scanner.nextLine();

            System.out.print("Estado actual: ");
            String EstadoActual = scanner.nextLine();
            inmueble.setEstadoInmueble(EstadoActual);

            System.out.print("Condicion: ");
            String Condicion = scanner.nextLine();
            inmueble.setCondicion(Condicion);

            System.out.print("Precio por noche: ");
            BigDecimal PrecioNoche = scanner.nextBigDecimal();
            inmueble.setPrecioNoche(PrecioNoche);

            System.out.print("Historial de Arriendos: ");
            int HistorialDeArriendos = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente
            inmueble.setHistorialDeArriendos(HistorialDeArriendos);

            inmueble.insertarInmueble(con);

            scanner.close();
        }
    // Otros métodos y setters de la clase


    public int getId_arrendador() {
        return id_arrendador;
    }

    public void setId_arrendador(int id_arrendador) {
        this.id_arrendador = id_arrendador;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        TipoDocumento = tipoDocumento;
    }

    public String getNumDocumento() {
        return NumDocumento;
    }

    public void setNumDocumento(String numDocumento) {
        NumDocumento = numDocumento;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String celular) {
        Celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }
}
