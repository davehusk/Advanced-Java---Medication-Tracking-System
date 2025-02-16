import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MedicationTrackingSystemApp {
    private static MedicationTrackingSystem system = new MedicationTrackingSystem();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            clearScreen();
            showMenu();
            int choice = getValidChoice();

            switch (choice) {
                case 1:
                    addPatient();  // Calls addPatient method
                    break;
                case 2:
                    addDoctor();  // Calls addDoctor method
                    break;
                case 3:
                    addMedication();  // Calls addMedication method
                    break;
                case 4:
                    addPrescription();  // Calls addPrescription method
                    break;
                case 5:
                    searchPatient();  // Calls searchPatient method
                    break;
                case 6:
                    searchDoctor();  // Calls searchDoctor method
                    break;
                case 7:
                    searchMedication();  // Calls searchMedication method
                    break;
                case 8:
                    listExpiredMedications();  // Calls listExpiredMedications method
                    break;
                case 9:
                    listAllPatients();  // Calls listAllPatients method
                    break;
                case 10:
                    listAllDoctors();  // Calls listAllDoctors method
                    break;
                case 11:
                    listAllMedications();  // Calls listAllMedications method
                    break;
                case 12:
                    listAllPrescriptions();  // Calls listAllPrescriptions method
                    break;
                case 13:
                    System.out.println("Exiting the program... Goodbye!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a valid option.");
            }

            // Ensure the screen only clears after results are shown
            if (running) {
                pauseForInput();  // Pause before going back to menu
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("===== Medication Tracking System =====");
        System.out.println("Select an option by entering the corresponding number:");
        System.out.println();
        System.out.println("[1] Add Patient");
        System.out.println("[2] Add Doctor");
        System.out.println("[3] Add Medication");
        System.out.println("[4] Add Prescription");
        System.out.println("[5] Search Patient by ID");
        System.out.println("[6] Search Doctor by ID");
        System.out.println("[7] Search Medication by ID");
        System.out.println("[8] List Expired Medications");
        System.out.println("[9] List All Patients");
        System.out.println("[10] List All Doctors");
        System.out.println("[11] List All Medications");
        System.out.println("[12] List All Prescriptions");
        System.out.println("[13] Exit");
        System.out.println();
    }

    private static int getValidChoice() {
        System.out.print("Enter your choice: ");
        while (!scanner.hasNextInt()) {
            scanner.nextLine();  // Consume invalid input
            System.out.print("Invalid input. Please enter a number: ");
        }
        return scanner.nextInt();
    }

    private static void addPatient() {
        System.out.println("===== Add New Patient =====");
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Patient Contact: ");
        String contact = scanner.nextLine();

        Patient patient = new Patient(id, name, age, contact);
        system.addPatient(patient);
        System.out.println("\nPatient added successfully!");
    }

    private static void addDoctor() {
        System.out.println("===== Add New Doctor =====");
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Doctor Specialization: ");
        String specialization = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, specialization);
        system.addDoctor(doctor);
        System.out.println("\nDoctor added successfully!");
    }

    private static void addMedication() {
        System.out.println("===== Add New Medication =====");
        System.out.print("Enter Medication ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Medication Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Medication Expiration Date (yyyy-mm-dd): ");
        String dateStr = scanner.nextLine();
        Date expirationDate = java.sql.Date.valueOf(dateStr);

        Medication medication = new Medication(id, name, expirationDate);
        system.addMedication(medication);
        System.out.println("\nMedication added successfully!");
    }

    private static void addPrescription() {
        System.out.println("===== Add New Prescription =====");
        System.out.print("Enter Patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter Doctor ID: ");
        int doctorId = scanner.nextInt();
        System.out.print("Enter Medication ID: ");
        int medicationId = scanner.nextInt();

        Patient patient = system.searchPatientById(patientId);
        Doctor doctor = system.searchDoctorById(doctorId);
        Medication medication = system.searchMedicationById(medicationId);

        if (patient != null && doctor != null && medication != null) {
            Prescription prescription = new Prescription(patient, doctor, medication);
            system.addPrescription(prescription);
            System.out.println("\nPrescription added successfully!");
        } else {
            System.out.println("\nInvalid IDs. Prescription could not be added.");
        }
    }

    private static void searchPatient() {
        System.out.println("===== Search for Patient =====");
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        Patient patient = system.searchPatientById(id);
        if (patient != null) {
            System.out.println("\nPatient Found: " + patient);
        } else {
            System.out.println("\nPatient not found.");
        }
    }

    private static void searchDoctor() {
        System.out.println("===== Search for Doctor =====");
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        Doctor doctor = system.searchDoctorById(id);
        if (doctor != null) {
            System.out.println("\nDoctor Found: " + doctor);
        } else {
            System.out.println("\nDoctor not found.");
        }
    }

    private static void searchMedication() {
        System.out.println("===== Search for Medication =====");
        System.out.print("Enter Medication ID: ");
        int id = scanner.nextInt();
        Medication medication = system.searchMedicationById(id);
        if (medication != null) {
            System.out.println("\nMedication Found: " + medication);
        } else {
            System.out.println("\nMedication not found.");
        }
    }

    private static void listExpiredMedications() {
        System.out.println("===== Expired Medications =====");
        boolean foundExpired = false;
        for (Medication medication : system.getMedications()) {
            if (medication.isExpired()) {
                System.out.println(medication);
                foundExpired = true;
            }
        }
        if (!foundExpired) {
            System.out.println("\nNo expired medications found.");
        }
    }

    private static void listAllPatients() {
        System.out.println("===== List All Patients =====");
        List<Patient> patients = system.getPatients();
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
        } else {
            for (Patient patient : patients) {
                System.out.println(patient);
            }
        }
    }

    private static void listAllDoctors() {
        System.out.println("===== List All Doctors =====");
        List<Doctor> doctors = system.getDoctors();
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
        } else {
            for (Doctor doctor : doctors) {
                System.out.println(doctor);
            }
        }
    }

    private static void listAllMedications() {
        System.out.println("===== List All Medications =====");
        List<Medication> medications = system.getMedications();
        if (medications.isEmpty()) {
            System.out.println("No medications found.");
        } else {
            for (Medication medication : medications) {
                System.out.println(medication);
            }
        }
    }

    private static void listAllPrescriptions() {
        System.out.println("===== List All Prescriptions =====");
        List<Prescription> prescriptions = system.getPrescriptions();
        if (prescriptions.isEmpty()) {
            System.out.println("No prescriptions found.");
        } else {
            for (Prescription prescription : prescriptions) {
                System.out.println(prescription);
            }
        }
    }

    private static void pauseForInput() {
        System.out.println("\nPress Enter to return to the main menu...");
        scanner.nextLine();  // Wait for user to press enter
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
