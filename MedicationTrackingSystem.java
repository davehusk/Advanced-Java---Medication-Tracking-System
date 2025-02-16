package medicationtracking;

import java.util.Scanner;

// This is the main system. It will run everything.
public class MedicationTrackingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== Pharmacy System =====");
        System.out.println("1: Add Patient");
        System.out.println("2: Add Doctor");
        System.out.println("3: Exit");

        int option = scanner.nextInt();
        if (option == 1) {
            System.out.println("Feature coming soon...");
        } else if (option == 2) {
            System.out.println("Feature coming soon...");
        } else {
            System.out.println("Exiting...");
        }
    }
}
