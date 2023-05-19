package entidades;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Usuario {
    private int id_usuario;
    private String nombres;
    private String apellidos;
    private int edad;
    private String TipoDocumento;
    private String NumDocumento;
    private String Celular;
    private String correo;
    private int id_perfil;

    public static Usuario obtenerUsuarioPorNombre(Connection con) throws SQLException {
        System.out.println("Consulta a otro usuario        ");
        System.out.println(" ");

        Usuario usuario = null;

        // Obtener el nombre de usuario desde la entrada estándar
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();

        // Crear el objeto CallableStatement y ejecutar el procedimiento almacenado
        try (CallableStatement statement = con.prepareCall("{ CALL obtenerUsuarioPorNombre(?) }")) {
            statement.setString(1, nombreUsuario);
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se obtuvo un resultado
            if (resultSet.next()) {
                usuario = new Usuario();
                usuario.setId_usuario(resultSet.getInt("id_usuario"));
                usuario.setNombres(resultSet.getString("nombres"));
                usuario.setApellidos(resultSet.getString("apellidos"));
                usuario.setEdad(resultSet.getInt("edad"));
                usuario.setTipoDocumento(resultSet.getString("TipoDocumento"));
                usuario.setNumDocumento(resultSet.getString("NumDocumento"));
                usuario.setCelular(resultSet.getString("Celular"));
                usuario.setCorreo(resultSet.getString("correo"));
                usuario.setId_perfil(resultSet.getInt("id_perfil"));




                System.out.println("Datos del usuario:");
                System.out.println("ID de usuario: " + usuario.getId_usuario());
                System.out.println("Nombres: " + usuario.getNombres());
                System.out.println("Apellidos: " + usuario.getApellidos());
                System.out.println("Edad: " + usuario.getEdad());
                System.out.println("Tipo de documento: " + usuario.getTipoDocumento());
                System.out.println("Número de documento: " + usuario.getNumDocumento());
                System.out.println("Celular: " + usuario.getCelular());
                System.out.println("Correo electrónico: " + usuario.getCorreo());
                System.out.println("ID de perfil: " + usuario.getId_perfil());
            }

            resultSet.close();
        }

        scanner.close();

        return usuario;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
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
