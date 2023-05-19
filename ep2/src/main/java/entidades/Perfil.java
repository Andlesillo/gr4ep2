package entidades;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;
public class Perfil {
    private int id_perfil;
    private String nombreUsuario;
    private String clave;
    private String correo;
    private String EleccionInput;
    private String tipoRegistro;



    public void validarPerfil(Connection con) throws SQLException {
        Scanner scannerNombre = new Scanner(System.in);
        System.out.println("Ingrese su usuario:");
        String usuarioInput = scannerNombre.nextLine();

        Scanner scannerClave = new Scanner(System.in);
        System.out.println("Ingrese clave:");
        String claveInput = scannerClave.nextLine();

        String callProcedure = "{ CALL sp_VerificarRegistro(?, ?, ?, ?) }";
        CallableStatement statement = con.prepareCall(callProcedure);

        // Establecer valores de parámetros de entrada
        statement.setString(1, claveInput);
        statement.setString(2, usuarioInput);

        // Definir parámetros de salida
        statement.registerOutParameter(3, Types.VARCHAR);
        statement.registerOutParameter(4, Types.BOOLEAN);

        // Ejecutar el stored procedure
        statement.execute();

        // Obtener los valores de los parámetros de salida
        String tipoRegistro = statement.getString(3);
        boolean verificacionExitosa = statement.getBoolean(4);

        // Imprimir mensaje según el tipo de registro y la verificación exitosa
        if (verificacionExitosa) {
            if (tipoRegistro.equals("Administrador")) {

                System.out.println(" ------------------------- ");
                System.out.println("Hola administrador. ¿Qué desea hacer?");
                System.out.println(" ");

                Administrador administrador = new Administrador();
                administrador.accionAdministrador(con);

            } else if (tipoRegistro.equals("Arrendador")) {
                System.out.println(" ------------------------- ");
                System.out.println("Hola arrendador. ¿Qué desea hacer?");
                System.out.println(" ");

                Arrendador arrendador = new Arrendador();
                arrendador.accionArrendador(con);
            } else if (tipoRegistro.equals("Cliente")) {
                System.out.println(" ------------------------- ");
                System.out.println("Hola cliente. ¿Qué desea hacer?");
                System.out.println(" ");

                Usuario usuario = new Usuario();
                usuario.obtenerUsuarioPorNombre(con);
            } else {
                System.out.println(" ------------------------- ");
                System.out.println("Tipo de registro desconocido. Ingrese de nuevo");
                System.out.println(" ");

            }
        } else {
            System.out.println(" ------------------------- ");
            System.out.println("No se encontró coincidencia");
            System.out.println(" ------------------------- ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println(" ");

            validarPerfil(con);
        }
    }


}
