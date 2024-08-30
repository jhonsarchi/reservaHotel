package co.edu.uniquindio.programacion2.ReservaHotel;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Crear el hotel
        Hotel hotel = new Hotel();

        // Crear un cliente
        Cliente cliente = new Cliente("Juan Pérez", "12345678");
        hotel.agregarCliente(cliente);

        // Crear una habitación
        Habitacion habitacion = new Habitacion(101, "Doble", 150.0);
        hotel.agregarHabitacion(habitacion);

        // Crear servicios generales del hotel
        Servicio spa = new ServicioDeHabitacion(80.0, "Spa");
        Servicio restaurante = new ServicioDeHabitacion(60.0, "Restaurante");
        Servicio limpieza = new ServicioDeHabitacion(40.0, "Limpieza");

        // Agregar los servicios generales al hotel
        hotel.agregarServicio(spa);
        hotel.agregarServicio(restaurante);
        hotel.agregarServicio(limpieza);

        // Crear y agregar servicios de habitación
        ServicioDeHabitacion servicioHabitacion1 = new ServicioDeHabitacion(30.0, "Servicio de desayuno");
        ServicioDeHabitacion servicioHabitacion2 = new ServicioDeHabitacion(50.0, "Servicio de cena");

        habitacion.agregarServicio(servicioHabitacion1);
        habitacion.agregarServicio(servicioHabitacion2);

        // Crear fechas de entrada y salida
        LocalDate fechaEntrada = LocalDate.of(2024, 8, 27);
        LocalDate fechaSalida = LocalDate.of(2024, 8, 30);

        // Crear una reserva
        Reserva reserva = new Reserva(habitacion, cliente, fechaEntrada, fechaSalida);
        hotel.agregarReserva(reserva);

        // Calcular el costo total de la reserva
        System.out.println("Costo total de la reserva: " + hotel.calcularCostoTotal(reserva));

        // Ejercicio 2: Listar todas las reservas activas de un cliente
        System.out.println("Reservas activas del cliente: " + cliente.getReservasActivas().size());

        // Ejercicio 3: Verificar disponibilidad de la habitación
        LocalDate fechaConsulta = LocalDate.of(2024, 8, 29);
        boolean disponible = hotel.verificarDisponibilidadHabitacion(101, fechaConsulta);
        System.out.println("Habitación disponible el 29/08/2024: " + disponible);
    }
}