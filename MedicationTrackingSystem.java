package medicationtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Prescription {
      private int id;
      private int patientId;
      private int doctorId;
      private String medication;
      private String dosage;

      public Prescription(int id, int patientId, int doctorId, String medication, String dosage) {
            this.id = id;
            this.patientId = patientId;
            this.doctorId = doctorId;
            this.medication = medication;
            this.dosage = dosage;
      }

      // Getters and setters can be added here if needed
}

// This is the main system. Now it can add patients, doctors, and prescriptions.
public class MedicationTrackingSystem {
      private List<Patient> patients = new ArrayList<>();
      private List<Doctor> doctors = new ArrayList<>();
      private List<Prescription> prescriptions = new ArrayList<>();

      public static void main(String[] args) {
            MedicationTrackingSystem system = new MedicationTrackingSystem();
            Scanner scanner = new Scanner(System.in);

            while (true) {
                  System.out.println("\n===== Pharmacy System =====");
                  System.out.println("1: Add Patient");
                  System.out.println("2: Add Doctor");
                  System.out.println("3: Add Prescription");
                  System.out.println("4: Exit");

                  int option = scanner.nextInt();
                  scanner.nextLine();

                  if (option == 1) {
                        system.addPatient(scanner);
                  } else if (option == 2) {
                        system.addDoctor(scanner);
                  } else if (option == 3) {
                        system.addPrescription(scanner);
                  } else {
                        System.out.println("Exiting...");
                        break;
                  }
            }
      }

      private void addPatient(Scanner scanner) {
            System.out.print("Enter Patient Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Phone: ");
            String phone = scanner.nextLine();

            patients.add(new Patient(patients.size() + 1, name, age, phone));
            System.out.println("Patient added!");
      }

      private void addDoctor(Scanner scanner) {
            System.out.print("Enter Doctor Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Phone: ");
            String phone = scanner.nextLine();

            doctors.add(new Doctor(doctors.size() + 1, name, age, phone));
            System.out.println("Doctor added!");
      }

      private void addPrescription(Scanner scanner) {
            System.out.print("Enter Patient ID: ");
            int patientId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Doctor ID: ");
            int doctorId = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter Medication: ");
            String medication = scanner.nextLine();
            System.out.print("Enter Dosage: ");
            String dosage = scanner.nextLine();

            prescriptions.add(new Prescription(prescriptions.size() + 1, patientId, doctorId, medication, dosage));
            System.out.println("Prescription added!");
      }
}
