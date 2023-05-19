package entidades;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class Inmueble {
    private int id_inmueble;
    private String NombreInmueble;
    private String apellidos;
    private int id_arrendador;
    private String EstadoInmueble;
    private String Condicion;
    private float PrecioNoche;
    private int HistorialDeArriendos;
    private int Espacios;


    public void insertarInmueble(Connection con) throws SQLException {
        String sql = "{CALL sp_insertar_inmueble(?, ?, ?, ?, ?, ?, ?)}";
        CallableStatement statement = con.prepareCall(sql);

        statement.setString(1, getNombreInmueble());
        statement.setInt(2, getId_arrendador());
        statement.setString(3, getEstadoInmueble());
        statement.setString(4, getCondicion());
        statement.setDouble(5, getPrecioNoche());
        statement.setInt(6, getHistorialDeArriendos());
        statement.setInt(7, getEspacios());

        statement.executeUpdate();

        statement.close();
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

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public float getPrecioNoche() {
        return PrecioNoche;
    }

    public void setPrecioNoche(float precioNoche) {
        PrecioNoche = precioNoche;
    }

    public int getHistorialDeArriendos() {
        return HistorialDeArriendos;
    }

    public void setHistorialDeArriendos(int historialDeArriendos) {
        HistorialDeArriendos = historialDeArriendos;
    }

    public int getEspacios() {
        return Espacios;
    }

    public void setEspacios(int espacios) {
        Espacios = espacios;
    }
}
