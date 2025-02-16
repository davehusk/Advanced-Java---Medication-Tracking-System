# Pharmacy Management System - Development Documentation


## Javadocs

Javadocs are available for all classes. Run the following command to generate them:

```bash

javadoc-ddocsmedicationtracking/*.java

```

## Source Code Directory Structure

```

pharmacy-management-system/

├── medicationtracking/

│   ├── Doctor.java

│   ├── Medication.java

│   ├── Patient.java

│   ├── Person.java

│   ├── Prescription.java

│   └── MedicationTrackingSystem.java

└── README.md

```

## Build Process

1. Compile the project:

   ```bash

   javac medicationtracking/*.java

   ```
2. Run the application:

   ```bash

   java medicationtracking.MedicationTrackingSystem

   ```

## Compiler-Time Dependencies

-**Java Development Kit (JDK)**: Version 11 or higher.

-**Terminal/Command Prompt**: To compile and run the application.

## Development Standards

- Follow **Java Coding Conventions**.
- Use meaningful variable and method names.
- Include comments for complex logic.
- Write unit tests for critical functionality (not implemented in this project).

## Database Design (Theoretical)

### Entity Relationships

```

+-----------------+       +-----------------+       +-----------------+

|    Patient      |       |  Prescription   |       |    Doctor       |

+-----------------+       +-----------------+       +-----------------+

| - id (PK)       |<------| - patient_id (FK)|      | - id (PK)       |

| - name          |       | - doctor_id (FK) |------| - name          |

| - age           |       | - medication_id (FK)|   | - specialization|

| - phone         |       +-----------------+       +-----------------+

+-----------------+               ^

                                  |

                          +-----------------+

                          |   Medication    |

                          +-----------------+

                          | - id (PK)       |

                          | - name          |

                          | - dosage        |

                          | - stock         |

                          | - expiry_date   |

                          +-----------------+

```

## GitHub Repository

1. Clone the repository:

   ```bash

   git clone https://github.com/davehusk/Advanced-Java---Medication-Tracking-System.git

   ```
2. Navigate to the project directory:

   ```bash

   ls
   cd <directory>

   ```
