# Pharmacy Management System

## Overview
This is a **Pharmacy Management System** built using Java. It allows users to manage patients, doctors, medications, and prescriptions. The system is designed to help pharmacies track patient information, prescriptions, and medication stock, including checking for expired medications.

## Features
- Add, edit, and delete patients, doctors, and medications.
- Create and manage prescriptions.
- Search for medications, patients, and doctors.
- Check for expired medications.
- Generate reports for prescriptions, medications, and more.

## Documentation
- **[User Documentation](USER_DOCUMENTATION.md)**: Explains the application, classes, and how to use it.
- **[Development Documentation](DEVELOPMENT_DOCUMENTATION.md)**: Covers the build process, directory structure, and database design.
- **[Deployment Documentation](DEPLOYMENT_DOCUMENTATION.md)**: Provides installation and setup instructions.
- **[Demo of Usage](DEMO.md)**: Shows example workflows and menu interactions.

## How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/davehusk/Advanced-Java---Medication-Tracking-System.git
   ```
2. Navigate to the project directory:
   ```bash
   ls
   cd <directory>
   ```
3. Compile the project:
   ```bash
   javac medicationtracking/*.java
   ```
4. Run the application:
   ```bash
   java medicationtracking.MedicationTrackingSystem
   ```

## Class Diagram
```
+-----------------+       +-----------------+       +-----------------+
|     Person      |       |    Medication   |       |  Prescription   |
+-----------------+       +-----------------+       +-----------------+
| - id: int       |       | - id: int       |       | - id: int       |
| - name: String  |       | - name: String  |       | - doctor: Doctor|
| - age: int      |       | - dosage: int   |       | - patient: Patient
| - phone: String |       | - stock: int    |       | - medication: Medication
+-----------------+       | - expiry: LocalDate|    +-----------------+
       ^                  +-----------------+       | - expiry: LocalDate|
       |                        ^                  +-----------------+
       |                        |
+-----------------+       +-----------------+
|    Patient      |       |     Doctor      |
+-----------------+       +-----------------+
| (inherits Person)|      | - specialization: String|
+-----------------+       +-----------------+
```

## License
This project is licensed under the MIT License.

---

Developed by **David Husk** as part of the **Advanced Java Sprint SOLO Project**.
