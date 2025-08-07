package ui;

import java.time.LocalDate;
import java.time.Month;

public class ObtenerMesYDiaActual {
    public static void main(String[] args) {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Obtener el mes actual
        Month mesActual = fechaActual.getMonth();

        // Imprimir el nombre del mes actual
        System.out.println("El mes actual es: " + mesActual);



        // Obtener el día del mes (número del día)
        int diaDelMes = fechaActual.getDayOfMonth();

        // Imprimir el día actual
        System.out.println("El día actual es: " + diaDelMes);
    }
}
