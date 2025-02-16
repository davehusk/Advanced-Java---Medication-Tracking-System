package medicationtracking;

// This is the medication class. It stores drug info.
public class Medication {
    private int id;
    private String name;
    private int dosage;
    private int quantityInStock;

    public Medication(int id, String name, int dosage, int quantityInStock) {
        this.id = id;
        this.name = name;
        this.dosage = dosage;
        this.quantityInStock = quantityInStock;
    }
}
