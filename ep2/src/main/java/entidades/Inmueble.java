package entidades;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Inmueble {
    private int id_inmueble;
    private String NombreInmueble;
    private int id_arrendador;
    private String EstadoInmueble;
    private String Condicion;
    private BigDecimal PrecioNoche; // Utilizar BigDecimal en lugar de Double
    private int HistorialDeArriendos;
    private String Espacios;


    public void insertarInmueble(Connection con) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        // Obtener los valores ingresados en los setters
        String nombreInmueble = getNombreInmueble();
        int idArrendador = getId_arrendador();
        String estadoInmueble = getEstadoInmueble();
        String condicion = getCondicion();
        BigDecimal precioNoche = getPrecioNoche();
        int historialDeArriendos = getHistorialDeArriendos();
        String espacios = getEspacios();

        // Llamar al stored procedure insertarInmueble
        String callProcedure = "{ CALL insertarInmueble(?, ?, ?, ?, ?, ?, ?) }";
        CallableStatement statement = con.prepareCall(callProcedure);

        // Establecer valores de parámetros
        statement.setString(1, nombreInmueble);
        statement.setInt(2, idArrendador);
        statement.setString(3, estadoInmueble);
        statement.setString(4, condicion);
        statement.setBigDecimal(5, precioNoche);
        statement.setInt(6, historialDeArriendos);
        statement.setString(7, espacios);

        // Ejecutar el stored procedure
        statement.execute();

        System.out.println("Inmueble insertado exitosamente.");
    }

    public int getId_inmueble() {
        return id_inmueble;
    }

    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }

    public String getNombreInmueble() {
        return NombreInmueble;
    }

    public void setNombreInmueble(String nombreInmueble) {
        NombreInmueble = nombreInmueble;
    }

    public int getId_arrendador() {
        return id_arrendador;
    }

    public void setId_arrendador(int id_arrendador) {
        this.id_arrendador = id_arrendador;
    }

    public String getEstadoInmueble() {
        return EstadoInmueble;
    }

    public void setEstadoInmueble(String estadoInmueble) {
        EstadoInmueble = estadoInmueble;
    }

    public String getCondicion() {
        return Condicion;
    }

    public void setCondicion(String condicion) {
        Condicion = condicion;
    }

    public BigDecimal getPrecioNoche() {
        return PrecioNoche;
    }

    public void setPrecioNoche(BigDecimal precioNoche) {
        PrecioNoche = precioNoche;
    }

    public int getHistorialDeArriendos() {
        return HistorialDeArriendos;
    }

    public void setHistorialDeArriendos(int historialDeArriendos) {
        HistorialDeArriendos = historialDeArriendos;
    }

    public String getEspacios() {
        return Espacios;
    }

    public void setEspacios(String espacios) {
        Espacios = espacios;
    }
}
