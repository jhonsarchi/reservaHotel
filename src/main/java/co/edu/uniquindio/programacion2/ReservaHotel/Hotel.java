package co.edu.uniquindio.programacion2.ReservaHotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Habitacion> habitaciones;
    private List<Cliente> clientes;
    private List<Reserva> reservas;
    private List<Servicio> servicios;

    public Hotel() {
        this.habitaciones = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.servicios = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
        reserva.getCliente().agregarReserva(reserva);
    }

    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public Habitacion buscarHabitacion(int numero) {
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumero() == numero) {
                return habitacion;
            }
        }
        return null;
    }

    public Cliente buscarCliente(String dni) {
        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dni)) {
                return cliente;
            }
        }
        return null;
    }

    public boolean verificarDisponibilidadHabitacion(int numeroHabitacion, LocalDate fecha) {
        Habitacion habitacion = buscarHabitacion(numeroHabitacion);
        if (habitacion != null) {
            return estaDisponibleEnFecha(habitacion, fecha);
        }
        return false;
    }

    public boolean estaDisponibleEnFecha(Habitacion habitacion, LocalDate fecha) {
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().getNumero() == habitacion.getNumero() &&
                !fecha.isBefore(reserva.getFechaEntrada()) && 
                !fecha.isAfter(reserva.getFechaSalida())) {
                return false;
            }
        }
        return true;
    }

    // Asegúrate de que este método sea público
    public double calcularCostoTotal(Reserva reserva) {
        long diferenciaDias = reserva.getFechaSalida().toEpochDay() - reserva.getFechaEntrada().toEpochDay();
        double costoHabitacion = diferenciaDias * reserva.getHabitacion().getPrecioHabitacion();
        double costoServicios = 0.0;

        // Calcular el costo de los servicios de la habitación
        for (Servicio servicio : reserva.getHabitacion().getServicios()) {
            costoServicios += servicio.getPrecio();
        }

        // Calcular el costo de los servicios generales del hotel
        for (Servicio servicio : this.servicios) {
            costoServicios += servicio.getPrecio();
        }

        return costoHabitacion + costoServicios;
    }
}