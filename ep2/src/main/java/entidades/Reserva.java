package entidades;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private int id_reserva;
    private int id_inmueble;
    private int id_usuario;
    private String FechaReserva;
    private String FechaIngreso;
    private String FechaSalida;
    private BigDecimal PrecioTotal;

    public static List<Reserva> listarReservas(Connection con) throws SQLException {
        List<Reserva> reservas = new ArrayList<>();

        // Crear el objeto CallableStatement y ejecutar el procedimiento almacenado
        try (CallableStatement statement = con.prepareCall("{ CALL listarReservas() }");
             ResultSet resultSet = statement.executeQuery()) {

            // Iterar sobre los resultados y crear objetos Reserva
            while (resultSet.next()) {
                int id_reserva = resultSet.getInt("id_reserva");
                int id_inmueble = resultSet.getInt("id_inmueble");
                int id_usuario = resultSet.getInt("id_usuario");
                String fechaReserva = resultSet.getString("FechaReserva");
                String fechaIngreso = resultSet.getString("FechaIngreso");
                String fechaSalida = resultSet.getString("FechaSalida");
                BigDecimal precioTotal = resultSet.getBigDecimal("PrecioTotal");

                Reserva reserva = new Reserva();
                reserva.setId_reserva(id_reserva);
                reserva.setId_inmueble(id_inmueble);
                reserva.setId_usuario(id_usuario);
                reserva.setFechaReserva(fechaReserva);
                reserva.setFechaIngreso(fechaIngreso);
                reserva.setFechaSalida(fechaSalida);
                reserva.setPrecioTotal(precioTotal);

                reservas.add(reserva);
            }
            imprimirReservas(reservas);
        }

        return reservas;
    }

    public static void imprimirReservas(List<Reserva> reservas) {
        for (Reserva reserva : reservas) {
            System.out.print(reserva.getId_reserva() + " | " + reserva.getId_inmueble() + " | "
                    + reserva.getId_usuario() + " | " + reserva.getFechaReserva() + " | "
                    + reserva.getFechaIngreso() + " | " + reserva.getFechaSalida() + " | "
                    + reserva.getPrecioTotal());
            System.out.println("-------------------------------------");
        }
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_inmueble() {
        return id_inmueble;
    }

    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getFechaReserva() {
        return FechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        FechaReserva = fechaReserva;
    }

    public String getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        FechaIngreso = fechaIngreso;
    }

    public String getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        FechaSalida = fechaSalida;
    }

    public BigDecimal getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(BigDecimal precioTotal) {
        PrecioTotal = precioTotal;
    }
}
