package medicationtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Main system to manage the pharmacy
public class MedicationTrackingSystem {
    private List<Patient> patients = new ArrayList<>(); // List of patients
    private List<Doctor> doctors = new ArrayList<>(); // List of doctors
    private List<Medication> medications = new ArrayList<>(); // List of medications
    private List<Prescription> prescriptions = new ArrayList<>(); // List of prescriptions
    private static int idCounter = 1; // Counter to generate unique IDs

    // Main method to run the system
    public static void main(String[] args) {
        MedicationTrackingSystem system = new MedicationTrackingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            system.clearScreen();
            System.out.println("=======================================");
            System.out.println("     * PHARMACY MANAGEMENT SYSTEM *     ");
            System.out.println("=======================================");
            System.out.println("1 -> Add Patient");
            System.out.println("2 -> Add Doctor");
            System.out.println("3 -> Add Medication");
            System.out.println("4 -> Add Prescription");
            System.out.println("5 -> Search Medication");
            System.out.println("6 -> Check Expired Medications");
            System.out.println("7 -> Print All Prescriptions for a Doctor");
            System.out.println("8 -> List All Patients");
            System.out.println("9 -> List All Doctors");
            System.out.println("10 -> List All Medications");
            System.out.println("11 -> List All Prescriptions");
            System.out.println("12 -> Exit");
            System.out.println("=======================================");
            System.out.print("Select an option: ");

            if (!scanner.hasNextInt()) {
                scanner.next();
                System.out.println("Invalid input! Please enter a number.");
                system.waitForEnter(scanner);
                continue;
            }

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> system.addPatient(scanner);
                case 2 -> system.addDoctor(scanner);
                case 3 -> system.addMedication(scanner);
                case 4 -> system.addPrescription(scanner);
                case 5 -> system.searchMedication(scanner);
                case 6 -> system.checkExpiredMedications();
                case 7 -> system.printPrescriptionsForDoctor(scanner);
                case 8 -> system.listAllPatients();
                case 9 -> system.listAllDoctors();
                case 10 -> system.listAllMedications();
                case 11 -> system.listAllPrescriptions();
                case 12 -> {
                    System.out.println("\nExiting... Thank you for using the system!");
                    return;
                }
                default -> {
                    System.out.println("Invalid option! Please try again.");
                    system.waitForEnter(scanner);
                }
            }
        }
    }

    // Add a new patient
    private void addPatient(Scanner scanner) {
        System.out.println("\n[+] ADD NEW PATIENT");
        System.out.println("---------------------------");
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();

        patients.add(new Patient(idCounter++, name, age, phone));
        System.out.println("✅ Patient added successfully!");
        waitForEnter(scanner);
    }

    // Add a new doctor
    private void addDoctor(Scanner scanner) {
        System.out.println("\n[+] ADD NEW DOCTOR");
        System.out.println("---------------------------");
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Phone Number: ");
        String phone = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        doctors.add(new Doctor(idCounter++, name, age, phone, specialization));
        System.out.println("✅ Doctor added successfully!");
        waitForEnter(scanner);
    }

    // Add a new medication
    private void addMedication(Scanner scanner) {
        System.out.println("\n[+] ADD NEW MEDICATION");
        System.out.println("---------------------------");
        System.out.print("Enter Medication Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Dosage (mg): ");
        int dosage = scanner.nextInt();
        System.out.print("Enter Quantity in Stock: ");
        int quantity = scanner.nextInt();

        medications.add(new Medication(idCounter++, name, dosage, quantity));
        System.out.println("✅ Medication added successfully!");
        waitForEnter(scanner);
    }

    // Add a new prescription
    private void addPrescription(Scanner scanner) {
        System.out.println("\n[+] ADD NEW PRESCRIPTION");
        System.out.println("---------------------------");

        if (doctors.isEmpty() || patients.isEmpty() || medications.isEmpty()) {
            System.out.println("⚠️ You need at least one doctor, patient, and medication to create a prescription.");
            waitForEnter(scanner);
            return;
        }

        System.out.println("[*] Select a Doctor:");
        listAllDoctors();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("[*] Select a Patient:");
        listAllPatients();
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("[*] Select a Medication:");
        listAllMedications();
        System.out.print("Enter Medication ID: ");
        int medicationId = scanner.nextInt();
        scanner.nextLine();

        Doctor doctor = findDoctorById(doctorId);
        Patient patient = findPatientById(patientId);
        Medication medication = findMedicationById(medicationId);

        if (doctor == null || patient == null || medication == null) {
            System.out.println("⚠️ Invalid ID(s) entered. Please try again.");
            waitForEnter(scanner);
            return;
        }

        prescriptions.add(new Prescription(idCounter++, doctor, patient, medication));
        System.out.println("✅ Prescription added successfully!");
        waitForEnter(scanner);
    }

    // Search for a medication (partial match search)
    private void searchMedication(Scanner scanner) {
        System.out.println("\n[*] AVAILABLE MEDICATIONS");
        System.out.println("---------------------------");
        if (medications.isEmpty()) {
            System.out.println("No medications in the system.");
            waitForEnter(scanner);
            return;
        }

        for (Medication med : medications) {
            System.out.println("- " + med.getName());
        }

        System.out.println("\n[*] SEARCH MEDICATION");
        System.out.print("Enter Medication Name (partial allowed): ");
        String searchName = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Medication med : medications) {
            if (med.getName().toLowerCase().contains(searchName)) {
                System.out.println("Found: " + med);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No medications found matching '" + searchName + "'.");
        }
        waitForEnter(scanner);
    }

    // Check for expired medications
    private void checkExpiredMedications() {
        System.out.println("\n[*] CHECK EXPIRED MEDICATIONS");
        System.out.println("---------------------------");

        boolean expiredFound = false;
        for (Medication med : medications) {
            if (med.isExpired()) {
                System.out.println("⚠️ EXPIRED: " + med);
                expiredFound = true;
            }
        }
        if (!expiredFound) {
            System.out.println("✅ No expired medications found.");
        }
        waitForEnter(new Scanner(System.in));
    }

    // Search for a doctor and print prescriptions
    private void printPrescriptionsForDoctor(Scanner scanner) {
        System.out.println("\n[*] AVAILABLE DOCTORS");
        System.out.println("---------------------------");
        if (doctors.isEmpty()) {
            System.out.println("No doctors in the system.");
            waitForEnter(scanner);
            return;
        }

        for (Doctor doc : doctors) {
            System.out.println("- " + doc.getName());
        }

        System.out.println("\n[*] SEARCH PRESCRIPTIONS FOR A DOCTOR");
        System.out.print("Enter Doctor's Name (partial allowed): ");
        String searchName = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Prescription prescription : prescriptions) {
            if (prescription.getDoctor().getName().toLowerCase().contains(searchName)) {
                System.out.println("📄 " + prescription);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No prescriptions found for doctors matching '" + searchName + "'.");
        }
        waitForEnter(scanner);
    }

    // List all patients
    private void listAllPatients() {
        System.out.println("\n[*] LIST OF PATIENTS");
        System.out.println("---------------------------");
        if (patients.isEmpty()) {
            System.out.println("No patients in the system.");
        } else {
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
        waitForEnter(new Scanner(System.in));
    }

    // List all doctors
    private void listAllDoctors() {
        System.out.println("\n[*] LIST OF DOCTORS");
        System.out.println("---------------------------");
        if (doctors.isEmpty()) {
            System.out.println("No doctors in the system.");
        } else {
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
            }
        }
        waitForEnter(new Scanner(System.in));
    }

    // List all medications
    private void listAllMedications() {
        System.out.println("\n[*] LIST OF MEDICATIONS");
        System.out.println("---------------------------");
        if (medications.isEmpty()) {
            System.out.println("No medications in the system.");
        } else {
            for (Medication med : medications) {
                System.out.println(med);
            }
        }
        waitForEnter(new Scanner(System.in));
    }

    // List all prescriptions
    private void listAllPrescriptions() {
        System.out.println("\n[*] LIST OF PRESCRIPTIONS");
        System.out.println("---------------------------");
        if (prescriptions.isEmpty()) {
            System.out.println("No prescriptions in the system.");
        } else {
            for (Prescription prescription : prescriptions) {
                System.out.println(prescription);
            }
        }
        waitForEnter(new Scanner(System.in));
    }

    // Utility function: Press Enter to continue
    private void waitForEnter(Scanner scanner) {
        System.out.println("\nPress ENTER to continue...");
        scanner.nextLine();
    }

    // Utility function: Clear the screen (only works in terminals)
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    // Helper method to find a doctor by ID
    private Doctor findDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }

    // Helper method to find a patient by ID
    private Patient findPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    // Helper method to find a medication by ID
    private Medication findMedicationById(int id) {
        for (Medication med : medications) {
            if (med.getId() == id) {
                return med;
            }
        }
        return null;
    }
}