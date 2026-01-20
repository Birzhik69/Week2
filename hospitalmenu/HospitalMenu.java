package hospitalmenu;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class HospitalMenu implements Menu {
    private Scanner scanner = new Scanner(System.in);  // Instance variable for scanner
    private boolean running = true;

    // Instance variables to store the lists
    private ArrayList<Patient> patients = new ArrayList<>();
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private ArrayList<Person> allPersons = new ArrayList<>();  // List for polymorphism demonstration

    // Constructor: Initializes some default values for allPersons (Patient1 and Doctor1)
    public HospitalMenu() {
        // Add initial values to allPersons in the constructor
        allPersons.add(new Patient1(255, "Birzhan", 18, "+77474633055", "A+"));
        allPersons.add(new Doctor1(42913, "Miras", 39, "+77474362756", "brain neurosurgery", 25));

        // Demonstrate polymorphism by calling work() on each person
        for (Person p : allPersons) {
            p.work();  // Polymorphic call
        }
    }

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
        System.out.println("8. View Patients Only (filter by type)");
        System.out.println("0. Exit");
        System.out.println("========================================");
        System.out.print("Enter your choice: ");
    }

    @Override
    public void run() {
        while (running) {
            displayMenu();  // Show the menu options
            int choice = scanner.nextInt();  // Read user input
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
                    viewPatientsOnly();
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
        System.out.print("Enter Appointment ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Patient Name: ");
        String patientName = scanner.nextLine();
        System.out.print("Enter Doctor Name: ");
        String doctorName = scanner.nextLine();
        System.out.print("Enter Date: ");
        String date = scanner.nextLine();
        Appointment newAppointment = new Appointment(id, patientName, doctorName, date);
        appointments.add(newAppointment);  // Add appointment to list
        System.out.println("\nAppointment added successfully!");
        System.out.println("Saved appointment: " + newAppointment);
    }

    // Method to view all appointments
    private void viewAllAppointments() {
        System.out.println("\n--- ALL APPOINTMENTS ---");
        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
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

    // Method to view patients only (filter by type)
    private void viewPatientsOnly() {
        System.out.println("\n========================================");
        System.out.println(" PATIENTS ONLY");
        System.out.println("========================================");

        int patientCount = 0;

        for (Person p : allPersons) {
            if (p instanceof Patient1) {          // Filter by type
                Patient1 pat = (Patient1) p;      // Downcast to access Patient1 methods
                patientCount++;

                System.out.println(patientCount + ". " + pat.getName());
                System.out.println(" Blood Type: " + pat.getBloodType());
                System.out.println(" Age: " + pat.getAge());

                if (pat.isMinor()) {
                    System.out.println(" MINOR");
                }

                System.out.println();
            }
        }

        if (patientCount == 0) {
            System.out.println("No patients found.");
        }
    }
}
