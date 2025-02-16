package medicationtracking;

import java.time.LocalDate;
import java.util.Random;

// Represents a medication with an expiry date
public class Medication {
    private int id; // Unique identifier for the medication
    private String name; // Name of the medication
    private int dosage; // Dosage in mg
    private int quantityInStock; // Quantity available in stock
    private LocalDate expiryDate; // Expiry date of the medication

    // Constructor to initialize a Medication object
    public Medication(int id, String name, int dosage, int quantityInStock) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.quantityInStock = quantityInStock;
        this.expiryDate = generateRandomExpiry(); // Generate a random expiry date
    }

    // Generate a random expiry date (between 2 years ago and 2 years from now)
    private LocalDate generateRandomExpiry() {
        Random random = new Random();
        return LocalDate.now().plusYears(random.nextInt(4) - 2);
    }

    // Check if the medication is expired
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    // Getter for medication name
    public String getName() {
        return name;
    }

    // Getter for ID
    public int getId() {
        return id;
    }

    // Override toString to display medication details
    @Override
    public String toString() {
        return "Medication ID: " + id + " | Name: " + name + " | Dosage: " + dosage + "mg | Stock: " + quantityInStock + " | Expires: " + expiryDate;
    }
}