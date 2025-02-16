# Pharmacy Management System - Demo of Usage


## Menu Options

```

=======================================

    * PHARMACY MANAGEMENT SYSTEM *

=======================================

1 -> Add Patient

2 -> Add Doctor

3 -> Add Medication

4 -> Add Prescription

5 -> Search Medication

6 -> Check Expired Medications

7 -> Print All Prescriptions for a Doctor

8 -> List All Patients

9 -> List All Doctors

10 -> List All Medications

11 -> List All Prescriptions

12 -> Exit

=======================================

```


## Example Workflow

1. **Add a Patient**:

```

   Select an option: 1

   Enter Patient Name: David Husk

   Enter Age: 41

   Enter Phone Number: 7097771234

   ✅ Patient added successfully!

```


2. **Add a Doctor**:

```

   Select an option: 2

   Enter Doctor Name: Smith

   Enter Age: 45

   Enter Phone Number: 7097775678

   Enter Specialization: Cardio

   ✅ Doctor added successfully!

```


3. **Add a Medication**:

```

   Select an option: 3

   Enter Medication Name: Ritalin

   Enter Dosage (mg): 20

   Enter Quantity in Stock: 100

   ✅ Medication added successfully!

```


4. **Add a Prescription**:

```

   Select an option: 4

   Enter Doctor ID: 2

   Enter Patient ID: 1

   Enter Medication ID: 3

   ✅ Prescription added successfully!

```


5. **List All Prescriptions**:

```

   Select an option: 11

   Prescription ID: 4 | Doctor: Smith | Patient: David Husk | Medication: Ritalin

```


6. **Check Expired Medications**:

```

   Select an option: 6

   ⚠️ EXPIRED: Medication ID: 3 | Name: Ritalin | Dosage: 20mg | Stock: 100 | Expires: 2023-02-16

```


7. **Search for a Doctor's Prescriptions**:

```

   Select an option: 7

   Enter Doctor's Name (partial allowed): smi

   📄 Prescription ID: 4 | Doctor: Smith | Patient: David Husk | Medication: Ritalin

```
