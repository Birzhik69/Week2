package hospitalmenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import database.PatientDAO;
import model.*;

public class HospitalMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);  // Instance variable for scanner
    private boolean running = true;
    private PatientDAO patientDAO;  // PatientDAO instance variable
    //private ArrayList<Patient> patients = new ArrayList<>();
    //private ArrayList<Doctor> doctors = new ArrayList<>();
    //private ArrayList<Appointment> appointments = new ArrayList<>();
    //private ArrayList<Person> allPersons = new ArrayList<>();  // List for polymorphism demonstration



    // Constructor: Initializes some default values for allPersons (Patient1 and Doctor1)
    public HospitalMenu() {
        this.patientDAO = new PatientDAO();
        // Add initial values to allPersons in the constructor
        //allPersons.add(new Patient1(255, "Birzhan", 18, "+77474633055", "A+"));
        //allPersons.add(new Doctor1(42913, "Miras", 39, "+77474362756", "brain neurosurgery", 25));

        // Demonstrate polymorphism by calling work() on each person
        for (Person p : allPersons) {
            p.work();  // Polymorphic call
        }
    }
  //Override method for displayMenu
    @Override
    public void displayMenu() {
        System.out.println("\n========================================");
        System.out.println(" HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("========================================");
        System.out.println("1. Add Patient");
        System.out.println("2. View all Patients");
        System.out.println("3. Add Doctor");
        System.out.println("4. View All Doctors");
        System.out.println("5. Add Appointment");
        System.out.println("6. View All Appointments");
        System.out.println("7. Polymorphism Demonstration");
        System.out.println("8. Update Patient");
        System.out.println("9. Delete Patient");
        System.out.println("10. SearchPatientByName");
        System.out.println("11. searchPatientByAgeRange");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }
//Override method for run
    @Override
    public void run() {
        while (running) {
            displayMenu();  // Show the menu options
            int choice = scanner.nextInt(); // Read user input
            scanner.nextLine();  // Consume the newline character
            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewAllPatients();
                    break;
                case 3:
                    addDoctor();
                    break;
                case 4:
                    viewAllDoctors();
                    break;
                case 5:
                    addAppointment();
                    break;
                case 6:
                    viewAllAppointments();
                    break;
                case 7:
                    demonstratePolymorphism();
                    break;
                case 8:
                    updatePatient();
                    break;
                case 9:
                    deletePatient();
                    break;
                case 10:
                    searchPatientByName();
                    break;
                case 11:
                    searchPatientByAgeRange();
                    break;
                case 0:
                    System.out.println("\nGoodbye!");
                    running = false;  // Exit the loop
                    break;
                default:
                    System.out.println("\nInvalid choice! Please try again.");
            }
        }
        scanner.close();  // Close the scanner after use
    }
    // Method to add a patient
    private void addPatient() {
        System.out.println("\n--- ADD PATIENT ---");
        System.out.print("Enter Patient ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Patient name: ");
        String name = scanner.nextLine();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Blood Type: ");
        String bloodType = scanner.nextLine();
        Patient newPatient = new Patient(id, name, age, bloodType);
        patients.add(newPatient);  // Add patient to list
        System.out.println("\nPatient added successfully!");
        System.out.println("Saved patient: " + newPatient);
    }
    // Method to view all patients
    private void viewAllPatients() {
        System.out.println("\n--- ALL PATIENTS ---");
        if (patients.isEmpty()) {
            System.out.println("No patients found.");
            return;
        }
        for (int i = 0; i < patients.size(); i++) {
            System.out.println((i + 1) + ") " + patients.get(i));
        }
    }
    // Method to add a doctor
    private void addDoctor() {
        System.out.println("\n--- ADD DOCTOR ---");
        System.out.print("Enter Doctor ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Doctor name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter years of experience: ");
        int years = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        Doctor newDoctor = new Doctor(id, name, specialization, years);
        doctors.add(newDoctor);  // Add doctor to list
        System.out.println("\nDoctor added successfully!");
        System.out.println("Saved doctor: " + newDoctor);
    }
    // Method to view all doctors
    private void viewAllDoctors() {
        System.out.println("\n--- ALL DOCTORS ---");
        if (doctors.isEmpty()) {
            System.out.println("No doctors found.");
            return;
        }
        for (int i = 0; i < doctors.size(); i++) {
            System.out.println((i + 1) + ") " + doctors.get(i));
        }
    }
    // Method to add an appointment
    private void addAppointment() {
        System.out.println("\n--- ADD APPOINTMENT ---");
        System.out.println('\n' + "--- ADD APPOINTMENT ---");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter patient name: ");
        String PatientName = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter Doctor name: ");
        String DoctorName = scanner.nextLine();
        scanner.nextLine();
        System.out.print("Enter Date: ");
        String date = scanner.nextLine();
        scanner.nextLine();
        Appointment newAppointment = new Appointment(id, PatientName,DoctorName, date);
        appointments.add(newAppointment);
        System.out.println("Appoinment added successfully!");
    }
    // Method to view all appointments
    private void viewAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No patients found.");
        }
        for (int i = 0; i < appointments.size(); i++) {
            System.out.println((i + 1) + ") " + appointments.get(i));
        }
    }
    // Method to demonstrate polymorphism
    private void demonstratePolymorphism() {
        System.out.println("\n========================================");
        System.out.println(" POLYMORPHISM DEMONSTRATION");
        System.out.println("========================================");
        System.out.println("Calling work() on all persons:");
        System.out.println();

        if (allPersons.isEmpty()) {
            System.out.println("No persons found.");
            return;
        }

        for (Person p : allPersons) {
            p.work(); // Same method call, different output depending on real object type
        }

        System.out.println();
        System.out.println("Notice: Same method name (work), different output!");
        System.out.println("This is POLYMORPHISM in action!");
    }
    // Method to Update Patient
    private void updatePatient() {
        System.out.println("Enter Patient ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        // Directly ask for the new data to update
        System.out.print("New Name: ");
        String newName = scanner.nextLine();
        System.out.print("New Age: ");
        int newAge = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        System.out.print("New BloodType: ");
        String newBloodType = scanner.nextLine();
        // Create a new Patient object with the updated values
        Patient updatedPatient = new Patient(id, newName, newAge, newBloodType);
        // Call the updatePatient method to save changes
        boolean success = patientDAO.UpdatePatient(updatedPatient);
        if (success) {
            System.out.println("Patient updated successfully!");
        } else {
            System.out.println("Update failed!");
        }
    }
    // Method to Delete Patient
    private void deletePatient() {
        System.out.println("Enter Patient ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        // 1. First, load and show who will be deleted
        Patient patient = PatientDAO.getPatientById(id);
        if (patient == null) {
            System.out.println(" No staff found with ID: " + id);
            return;
        }
        // 2. Display staff details
        System.out.println("Staff to delete:");
        System.out.println(patient.toString());
        // 3. Ask for confirmation
        System.out.print(" Are you sure? (yes/no): ");
        String confirmation = scanner.nextLine();
        // 4. Delete only if confirmed
        if (confirmation.equalsIgnoreCase("yes")) {
            PatientDAO.DeletePatient(id);
        } else {
            System.out.println(" Deletion cancelled.");
        }
    }
    // Method to Search Patient by name
    private void searchPatientByName() {
        System.out.print("Enter Patient name to search: ");
        String name = scanner.nextLine();  // Read the name input from user

        // Call the search method from PatientDAO
        List<Patient> foundPatients = patientDAO.searchPatientByName(name);

        // Display the results
        if (foundPatients.isEmpty()) {
            System.out.println("No patients found with the name: " + name);
        } else {
            System.out.println("\n--- Found Patients ---");
            for (Patient patient : foundPatients) {
                System.out.println("ID: " + patient.getPatientId());
                System.out.println("Name: " + patient.getFullName());
                System.out.println("Age: " + patient.getAge());
                System.out.println("Blood Type: " + patient.getBloodType());
                System.out.println("---");
            }
        }
    }
    // Method to Search Patient by age range
    private void searchPatientByAgeRange() {
        System.out.print("Enter minimum age: ");
        int minAge = scanner.nextInt();

        System.out.print("Enter maximum age: ");
        int maxAge = scanner.nextInt();

        // Call the search method from PatientDAO
        List<Patient> foundPatients = patientDAO.searchPatientByAgeRange(minAge, maxAge);

        // Display the results
        if (foundPatients.isEmpty()) {
            System.out.println("No patients found in the age range: " + minAge + " - " + maxAge);
        } else {
            System.out.println("\n--- Found Patients ---");
            for (Patient patient : foundPatients) {
                System.out.println("ID: " + patient.getPatientId());
                System.out.println("Name: " + patient.getFullName());
                System.out.println("Age: " + patient.getAge());
                System.out.println("Blood Type: " + patient.getBloodType());
                System.out.println("---");
            }
        }
    }
    }



