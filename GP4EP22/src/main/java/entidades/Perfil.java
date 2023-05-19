package entidades;

import java.sql.*;
import java.util.Scanner;

public class Perfil {
    private int id_perfil;
    private String nombreUsuario;
    private String clave;
    private String correo;
    private String EleccionInput;
    private String tipoRegistro; // Nueva variable para almacenar el tipo de registro

    public static void llamarObtenerPerfiles(Connection connection) throws SQLException {
        String storedProcedure = "{call ObtenerPerfiles()}";

        try (CallableStatement statement = connection.prepareCall(storedProcedure)) {
            statement.execute();

            // Obtener y procesar los resultados según sea necesario
        }
    }

    public static void llamarObtenerAdministradorPorID(Connection connection, int adminID) throws SQLException {
        String storedProcedure = "{call ObtenerAdministradorPorID(?)}";

        try (CallableStatement statement = connection.prepareCall(storedProcedure)) {
            statement.setInt(1, adminID);
            statement.execute();

            // Obtener y procesar los resultados según sea necesario
        }
    }

    public static void llamarObtenerUsuariosPorRangoEdad(Connection connection, int minEdad, int maxEdad) throws SQLException {
        String storedProcedure = "{call ObtenerUsuariosPorRangoEdad(?, ?)}";

        try (CallableStatement statement = connection.prepareCall(storedProcedure)) {
            statement.setInt(1, minEdad);
            statement.setInt(2, maxEdad);
            statement.execute();

            // Obtener y procesar los resultados según sea necesario
        }
    }

    public int validarPerfil(Connection con) throws SQLException {
        Scanner scannerNombre = new Scanner(System.in);
        System.out.println("Ingrese su usuario:");
        String usuarioInput = scannerNombre.nextLine();

        Scanner scannerClave = new Scanner(System.in);
        System.out.println("Ingrese clave:");
        String claveInput = scannerClave.nextLine();

        try (CallableStatement stmt = con.prepareCall("{CALL sp_VerificarRegistro(?, ?, ?, ?)}")) {
            stmt.setString(1, claveInput);
            stmt.setString(2, usuarioInput);
            stmt.registerOutParameter(3, Types.VARCHAR);
            stmt.registerOutParameter(4, Types.BOOLEAN);

            stmt.execute();

            tipoRegistro = stmt.getString(3); // Asignar el valor a la variable de instancia
            boolean verificacionExitosa = stmt.getBoolean(4);

            if (!verificacionExitosa){
                System.exit(0);
            }

            System.out.println("Bienvenido " + tipoRegistro + " ¿qué deseas hacer?");
            //System.out.println("Verificación Exitosa: " + verificacionExitosa);

            int loop = 1;
            while (loop == 1) {
                System.out.println(" ");
                System.out.println("1) ObtenerPerfiles       2) ObtenerAdministradorPorID ");
                System.out.println("3) ObtenerAdministradorXD       4) ObtenerUsuariosPorRangoEdad");
                System.out.println("5) InsertarInmueble       6) ActualizarEstadoReserva");

                Scanner scannerEleccion = new Scanner(System.in);
                System.out.println(" --------------------- ");
                int EleccionInput = scannerEleccion.nextInt();

                if (tipoRegistro.equals("Administrador")) {
                    if (EleccionInput == 1){
                        obtenerPerfiles(con);
                    }
                    if (EleccionInput == 2){
                        Scanner scannerAdministrador = new Scanner(System.in);
                        System.out.println("ingresa el id del Administrativo que buscas...");
                        System.out.println(" --------------------- ");
                        int AdministradorInput = scannerAdministrador.nextInt();

                        Administrador admin = new Administrador();
                        admin.obtenerAdministradorPorID(AdministradorInput, con);
                    }
                    if (EleccionInput == 3){

                    }
                    if (EleccionInput == 4){

                    }
                    if (EleccionInput == 5){
                        Inmueble inmueble = new Inmueble();
                        inmueble.insertarInmueble(con);
                    }
                    if (EleccionInput == 6){

                    }
                    loop ++;
                }
                if (tipoRegistro.equals("Arrendador") && EleccionInput == 5){
                    loop ++;
                }
                if (tipoRegistro.equals("Cliente") && EleccionInput == 6){
                    loop ++;
                }
            }
            return 1; // O cualquier valor que desees devolver según la lógica de tu aplicación
        } catch (SQLException e) {
            e.printStackTrace();
        }

        finally {
            scannerNombre.close();
            scannerClave.close();
        }

        return -1; // Valor de retorno predeterminado o manejo de error específico
    }

    public void obtenerPerfiles(Connection connection) {
        try {

            // Crear el objeto CallableStatement para llamar al procedimiento almacenado
            CallableStatement callableStatement = connection.prepareCall("{CALL ObtenerPerfiles()}");

            // Ejecutar el procedimiento almacenado
            ResultSet resultSet = callableStatement.executeQuery();

            // Recorrer el resultado obtenido
            while (resultSet.next()) {
                // Obtener los valores de las columnas y realizar las operaciones necesarias
                int idPerfil = resultSet.getInt("id_perfil");
                String clave = resultSet.getString("clave");
                String nombreUsuario = resultSet.getString("nombreUsuario");
                String correo = resultSet.getString("correo");

                // Realizar las operaciones necesarias con los valores obtenidos
                // ...

                // Imprimir los valores obtenidos
                System.out.println("ID Perfil: " + idPerfil);
                System.out.println("Clave: " + clave);
                System.out.println("Nombre de usuario: " + nombreUsuario);
                System.out.println("Correo: " + correo);
                System.out.println("--------------------------------");
            }

            // Cerrar los recursos
            resultSet.close();
            callableStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones SQL
        }
    }


    public String getTipoRegistro() {
        return tipoRegistro;
    }

    public String getEleccion() {
        return EleccionInput;
    }
    @Override
    public String toString() {
        return "Perfil{" +
                "id_perfil=" + id_perfil +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", clave='" + clave + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }

    public int getId_perfil() {
        return id_perfil;
    }

    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTipoRegistro(String tipoRegistro) {
        this.tipoRegistro = tipoRegistro;
    }
}
