package entidades;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Administrador {
    private int id_administrador;
    private String nombres;
    private String apellidos;
    private int edad;
    private String TipoDocumento;
    private String NumDocumento;
    private String Celular;
    private String correo;
    private int id_perfil;

    public void accionAdministrador(Connection con) throws SQLException {
        Reserva reserva = new Reserva();

        System.out.println("1) Insertar arrendador        2) Listar reservas ");
        System.out.println(" ");


        Scanner scannerEleccion = new Scanner(System.in);
        System.out.println(" --------------------- ");
        int EleccionInput = scannerEleccion.nextInt();

        if (EleccionInput == 1){
            insertarArrendador(con);
        }
        if (EleccionInput == 2){
            reserva.listarReservas(con);
        }
    }
    public void insertarArrendador(Connection con) throws SQLException {
        Arrendador arrendador = new Arrendador();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del nuevo arrendador:");


        System.out.print("Nombres: ");
        String nombres = scanner.nextLine();
        arrendador.setNombres(nombres);


        System.out.print("Apellidos: ");
        String apellidos = scanner.nextLine();
        arrendador.setApellidos(apellidos);


        System.out.print("Edad: ");
        int edad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente
        arrendador.setEdad(edad);

        System.out.print("Tipo de Documento: ");
        String tipoDocumento = scanner.nextLine();
        arrendador.setTipoDocumento(tipoDocumento);

        System.out.print("Número de Documento: ");
        String numDocumento = scanner.nextLine();
        arrendador.setNumDocumento(numDocumento);

        System.out.print("Celular: ");
        String celular = scanner.nextLine();
        arrendador.setCelular(celular);

        System.out.print("Correo: ");
        String correo = scanner.nextLine();
        arrendador.setCorreo(correo);


        arrendador.insertarArrendador(con);

        scanner.close();
    }
}
