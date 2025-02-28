package Controllers;

import java.time.Duration;
import java.time.LocalDate;
import static java.time.temporal.ChronoUnit.DAYS;

public class RentalController {
    // Variables para llevar control de los días en que salió y entró el vehículo
    private LocalDate exitDate;
    private LocalDate estimateReturnDate;
    private LocalDate returnDate;

    // Variable para llevar el tiempo total que se prestó el vehículo
    private int totalDays;
    private int extraDays;

    // Getters y Setters
    public LocalDate getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDate exitDate) {
        this.exitDate = exitDate;
    }

    public LocalDate getEstimateReturnDate() {
        return estimateReturnDate;
    }

    public void setEstimateReturnDate(LocalDate estimateReturnDate) {
        this.estimateReturnDate = estimateReturnDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public int getTotalDays() {
        return totalDays;
    }

    public int getExtraDays() {
        return extraDays;
    }

    public void calculateTotalDays() {
        this.totalDays = Math.toIntExact(Duration.between(this.exitDate.atStartOfDay(), this.estimateReturnDate.atStartOfDay()).toDays());
    }

    public void calculateExtraDays() {
        this.extraDays = Math.toIntExact(Duration.between(this.estimateReturnDate.atStartOfDay(), this.returnDate.atStartOfDay()).toDays());
    }

    // Función para calcular el costo total del vehículo
    public double calculateBillingTotal(double pricePerDay) {
        double total = pricePerDay;

        // Calcular el costo extra por días de retraso
        if (this.extraDays > 0) {
            total += 1.00; // Cargo por un día extra
            if (this.extraDays > 3) {
                total += 5.00; // Cargo adicional si son más de 3 días
            }
            if (this.extraDays > 5) {
                total += 10.00; // Cargo adicional si son más de 5 días
            }
            if (this.extraDays > 7) {
                total += 20.00; // Cargo adicional si son más de 7 días
            }
        }

        return total;
    }
}

