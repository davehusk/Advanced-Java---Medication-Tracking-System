# Pharmacy Management System - User Documentation

## Overview
This application is a **Pharmacy Management System** designed to manage patients, doctors, medications, and prescriptions. It allows users to add, search, and manage data related to a pharmacy, including checking for expired medications and generating reports.

## Classes and Their Functionality
1. **Person**: Base class for `Patient` and `Doctor`. Stores basic information like ID, name, age, and phone number.
2. **Patient**: Represents a patient. Inherits from `Person`.
3. **Doctor**: Represents a doctor. Inherits from `Person` and includes a specialization.
4. **Medication**: Represents a medication. Includes details like ID, name, dosage, stock quantity, and expiry date.
5. **Prescription**: Links a doctor, patient, and medication. Tracks prescription details.
6. **MedicationTrackingSystem**: Main system class. Manages all functionalities like adding, searching, and listing data.

## How to Start/Access the Application
1. Compile the project:
   ```bash
   javac medicationtracking/*.java
   ```
2. Run the application:
   ```bash
   java medicationtracking.MedicationTrackingSystem
   ```
3. Follow the menu prompts to interact with the system.

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

