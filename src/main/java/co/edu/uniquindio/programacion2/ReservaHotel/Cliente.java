package co.edu.uniquindio.programacion2.ReservaHotel;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String dni;
    private List<Reserva> reservasActivas;

    public Cliente(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
        this.reservasActivas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public void agregarReserva(Reserva reserva) {
        reservasActivas.add(reserva);
    }

    public List<Reserva> getReservasActivas() {
        return reservasActivas;
    }
}