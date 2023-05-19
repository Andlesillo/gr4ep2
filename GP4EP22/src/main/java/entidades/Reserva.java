package entidades;

import java.util.Date;

public class Reserva {
    private int id_reserva;
    private int id_usuario;
    private String EstadoReserva;
    private Date FechaReserva;
    private Date FechaIngreso;
    private Date FechaSalida;
    private double PrecioTotal;

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getEstadoReserva() {
        return EstadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        EstadoReserva = estadoReserva;
    }

    public Date getFechaReserva() {
        return FechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        FechaReserva = fechaReserva;
    }

    public Date getFechaIngreso() {
        return FechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        FechaIngreso = fechaIngreso;
    }

    public Date getFechaSalida() {
        return FechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        FechaSalida = fechaSalida;
    }

    public double getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(double precioTotal) {
        PrecioTotal = precioTotal;
    }
}

