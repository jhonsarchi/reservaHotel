package co.edu.uniquindio.programacion2.ReservaHotel;

public abstract class Servicio {
    protected double precio;
    protected String nombre; 

    public Servicio(double precio, String nombre) {
        this.precio = precio;
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }
}