import Controllers.RentalController;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        // Instancia de la clase
        RentalController rentalController = new RentalController();

        // Ingresando el día de salida del vehículo
        System.out.print("Ingrese la fecha de salida del vehículo en formato YYYY-MM-DD: ");
        String exitDate = reader.nextLine();
        rentalController.setExitDate(LocalDate.parse(exitDate));

        System.out.print("Ingrese la fecha estimada a regresar el vehículo en formato YYYY-MM-DD: ");
        String estimateDate = reader.nextLine();
        rentalController.setEstimateReturnDate(LocalDate.parse(estimateDate));

        // Función para calcular el tiempo total
        rentalController.calculateTotalDays();

        // Imprimir un mensaje el número de veces que se prestó el vehículo
        for (int i = 1; i <= rentalController.getTotalDays(); i++) {
            System.out.println("Día " + i + " de " + rentalController.getTotalDays());
        }

        // Ingresando el día real de regreso del vehículo
        System.out.print("Ingrese la fecha real en la que regresó el vehículo en formato YYYY-MM-DD: ");
        String realDate = reader.nextLine();
        rentalController.setReturnDate(LocalDate.parse(realDate));

        // Función para calcular los días de retraso
        rentalController.calculateExtraDays();

        // Función para calcular el importe extra por los días de retraso
        double pricePerDay = 1.50 * rentalController.getTotalDays();
        double billingTotal = rentalController.calculateBillingTotal(pricePerDay);
        System.out.println("El total por el alquiler del vehículo es " + billingTotal);
    }
}
