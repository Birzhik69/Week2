//Rukhanov Birzhan IT-2502
//Theme:Hospital
import java.util.ArrayList;
import java.util.Scanner;
public class  Main {
  private static ArrayList<Patient> patient = new ArrayList<>();
  private static ArrayList<Person> allPersons = new ArrayList<>();

  private static ArrayList<Doctor> doctor = new ArrayList<>();
  private static ArrayList<Appointment> appointment = new ArrayList<>();
  // Scanner for reading user input
  private static Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) {
    allPersons.add(new Patient1(255, "Birzhan", 18,"+77474633055", "A+"));
    allPersons.add(new Doctor1(42913, "Miras", 39, "+77474362756", "brain neurosurgery ",25));
    for  (Person p : allPersons) {
      p.work();
    }
    //patient.add(new Patient(453218, "Johan" , 9 ,"A+"));
    //doctor.add(new Doctor(452302, "Tenma", "NeuroSurgery",20));
    //appointment.add(new Appointment( 453, "Johan" , "Tenma" ,"17.12.2025"));
    // Menu loop - continues until user exits
    boolean running = true;
    while (running) {
      display();
      int choice = scanner.nextInt();
      scanner.nextLine();
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
          NewDoctor();
          break;
        case 5:
          viewAllDoctors();
          break;
        case 6:
          viewDoctorsOnly();
          break;
        case 7:
          addAppointment();
        case 8:
          viewAllAppointments();
        case 9:
          demonstratePolymorphism();
        case 10:
          viewPatientsOnly();
        case 0:
          System.out.println("\nGoodbye! ");
          running = false;
          break;
        default:
          System.out.println("\n Invalid choice!");
      }
      if (running) {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
      }
    }
    scanner.close();

  }
  private static void display() {
    System.out.println("\n========================================");
    System.out.println(" HOSPITAL MANAGEMENT SYSTEM");
    System.out.println("========================================");
    System.out.println("1. Add Patient");
    System.out.println("2. View all Patients");
    System.out.println("3. Add Doctor");
    System.out.println("4. Add Doctor(polymorphics)");
    System.out.println("5. View All Doctors");
    System.out.println("6. View All Doctors(polymorphics)");
    System.out.println("7. Add Appointment");
    System.out.println("8. View All Appointments");
    System.out.println("9. POLYMORPHISM DEMONSTRATION");
    System.out.println("10.viewPatientsOnly(filter by Type)");
    System.out.println("0. Exit");
    System.out.println("========================================");
    System.out.print("Enter your choice: ");
  }
  private static void addPatient() {
    System.out.println("\n--- ADD PATIENT ---");
    System.out.print("Enter Patient ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter Patient name: ");
    String name = scanner.nextLine();
    System.out.print("Enter age: ");
    int age = scanner.nextInt();
    scanner.nextLine(); // consume newline
    System.out.print("Blood Type: ");
    String bloodType = scanner.nextLine();
    Patient newPatient = new Patient(id, name, age, bloodType);
    patient.add(newPatient);
    System.out.println("\nPatient added successfully!");
    System.out.println("Saved patient: " + newPatient);
  }
  private static void viewAllPatients() {
    System.out.println("\n--- ALL PATIENTS ---");
    if (patient.isEmpty()) {
      System.out.println("No patients found.");
      return;
    }
    for (int i = 0; i < patient.size(); i++) {
      System.out.println((i + 1) + ") " + patient.get(i));
    }
  }
  private static void addDoctor() {
    System.out.println("\n--- ADD DOCTOR ---");
    System.out.print("Enter DOCTOR ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter Doctor name: ");
    String name = scanner.nextLine();
    System.out.print("Enter Specialization: ");
    String Specialization = scanner.nextLine();
    System.out.print("Enter experience years: ");
    int years = scanner.nextInt();
    scanner.nextLine();
    Doctor newDoctor = new Doctor(id, name, Specialization, years);
    doctor.add(newDoctor);
    System.out.println("\nDoctor added successfully!");
    System.out.println("Saved doctor: " + newDoctor);
  }
  private static void viewAllDoctors() {
    System.out.println("\n--- ALL DOCTORS ---");
    if (patient.isEmpty()) {
      System.out.println("No patients found.");
      return;
    }
    for (int i = 0; i < doctor.size(); i++) {
      System.out.println((i + 1) + ") " + doctor.get(i));
    }
  }
  private static void addAppointment() {
    System.out.println("\n--- ADD APPOINTMENT ---");
    System.out.print("Enter AppointmentID: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter Patient Name: ");
    String name = scanner.nextLine();
    System.out.print("Enter Doctor Name: ");
    String name2 = scanner.nextLine();
    System.out.print("Enter Date: ");
    String date = scanner.nextLine();
    Appointment newAppointment = new Appointment(id, name, name2, date);
    appointment.add(newAppointment);
    System.out.println("\nDoctor added successfully!");
    System.out.println("Saved doctor: " + newAppointment);
  }
  private static void viewAllAppointments() {
    System.out.println("\n--- ALL APPOINTMENT ---");
    if (appointment.isEmpty()) {
      System.out.println("No patients found.");
      return;
    }
    for (int i = 0; i < appointment.size(); i++) {
      System.out.println((i + 1) + ") " + appointment.get(i));
    }
  }
  private static void NewDoctor() {
    System.out.println("\n--- ADD DOCTOR ---");
    System.out.print("Enter ID: ");
    int id = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter name: ");
    String name = scanner.nextLine();

    System.out.print("Enter age: ");
    int age = scanner.nextInt();
    scanner.nextLine();
    System.out.print("Enter phone number: ");
    String phone = scanner.nextLine();

    System.out.print("Enter specialization: ");
    String specialization = scanner.nextLine();

    System.out.print("Enter experience years: ");
    int exp = scanner.nextInt();
    scanner.nextLine();

    Person p = new Doctor1(id, name, age, phone, specialization, exp);
    allPersons.add(p);
    System.out.println("Saved: " + p);
  }
  private static void viewDoctorsOnly() {
    System.out.println("\n========================================");
    System.out.println(" DOCTORS ONLY");
    System.out.println("========================================");

    int doctorCount = 0;

    for (Person p : allPersons) {
      if (p instanceof Doctor1) {          // Filter by type
        Doctor1 d = (Doctor1) p;         // Downcast to access Doctor1 methods
        doctorCount++;

        System.out.println(doctorCount + ". " + d.getName());
        System.out.println(" Specialization: " + d.getSpecialization());
        System.out.println(" Experience: " + d.getExperienceYears() + " years");

        if (d.isExperienced()) {
          System.out.println(" Experienced Doctor!");
        }

        System.out.println();
      }
    }

    if (doctorCount == 0) {
      System.out.println("No doctors found.");
    }
  }
  private static void demonstratePolymorphism() {
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
  private static void viewPatientsOnly() {
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


