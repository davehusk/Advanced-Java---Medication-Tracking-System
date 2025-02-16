package medicationtracking;

import java.time.LocalDate;
import java.util.Random;

// Now it has expiry dates.
public class Medication {
    private int id;
    private String name;
    private int dosage;
    private int quantityInStock;
    private LocalDate expiryDate;

    public Medication(int id, String name, int dosage, int quantityInStock) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.quantityInStock = quantityInStock;
        this.expiryDate = generateRandomExpiry();
    }

    private LocalDate generateRandomExpiry() {
        Random random = new Random();
        return LocalDate.now().plusYears(random.nextInt(4) - 2);
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}
