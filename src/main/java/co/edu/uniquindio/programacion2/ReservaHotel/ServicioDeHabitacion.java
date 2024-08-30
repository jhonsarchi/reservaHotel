package co.edu.uniquindio.programacion2.ReservaHotel;

public class ServicioDeHabitacion extends Servicio implements IConsumible {
    public ServicioDeHabitacion(double precio, String nombre) {
        super(precio, nombre);
    }

    @Override
    public void consumir() {
        System.out.println(nombre + " consumido.");
    }
}