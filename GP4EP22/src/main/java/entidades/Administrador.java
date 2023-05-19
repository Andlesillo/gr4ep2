package entidades;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Administrador extends Perfil{
    private int id_administrador;
    private String nombres;
    private String apellidos;
    private int edad;
    private String TipoDocumento;
    private String NumDocumento;
    private String Celular;
    private String correo;
    private int id_perfil;


    public void obtenerAdministradorPorID(int adminID, Connection connection) {
        try {
            // Establecer la conexión con la base de datos

            // Crear el objeto CallableStatement para llamar al procedimiento almacenado
            CallableStatement callableStatement = connection.prepareCall("{CALL ObtenerAdministradorPorID(?)}");

            // Establecer el valor del parámetro de entrada
            callableStatement.setInt(1, adminID);

            // Ejecutar el procedimiento almacenado
            ResultSet resultSet = callableStatement.executeQuery();

            // Recorrer el resultado obtenido
            while (resultSet.next()) {
                // Obtener los valores de las columnas y realizar las operaciones necesarias
                int idAdministrador = resultSet.getInt("id_administrador");
                String nombres = resultSet.getString("nombres");
                String apellidos = resultSet.getString("apellidos");
                // Obtener los demás valores según corresponda

                // Realizar las operaciones necesarias con los valores obtenidos
                // ...

                // Imprimir los valores obtenidos
                System.out.println("ID Administrador: " + idAdministrador);
                System.out.println("Nombres: " + nombres);
                System.out.println("Apellidos: " + apellidos);
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

    public int getId_administrador() {
        return id_administrador;
    }

    public void setId_administrador(int id_administrador) {
        this.id_administrador = id_administrador;
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

    @Override
    public String getCorreo() {
        return correo;
    }

    @Override
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public int getId_perfil() {
        return id_perfil;
    }

    @Override
    public void setId_perfil(int id_perfil) {
        this.id_perfil = id_perfil;
    }
}
