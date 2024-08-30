package co.edu.uniquindio.programacion2.ReservaHotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Habitacion {
    private int numero;
    private String tipo;
    private double precioHabitacion;
    private List<Servicio> servicios;

    public Habitacion(int numero, String tipo, double precioHabitacion) {
        this.numero = numero;
        this.tipo = tipo;
        this.precioHabitacion = precioHabitacion;
        this.servicios = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    public List<Servicio> getServicios() {
        return servicios;
    }
}