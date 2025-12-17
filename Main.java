import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    Doctor Doctor1 = new Doctor(452302, "Tenma", "NeuroSurgery",20);
    Patient Patient1 = new Patient( 453218, "Johan" , 9 ,"A+");
    Appointment Appointment1 = new Appointment( 453, "Johan" , "Tenma" ,"17.12.2025");

    System.out.println(Doctor1);
    System.out.println(Doctor1.IsExperienced());
    System.out.println(Doctor1.canPerformSurgery());
    System.out.println(Patient1);
    System.out.println(Patient1.IsMinor());
    System.out.println(Patient1.getAgeCategory());
    System.out.println(Appointment1);
    System.out.println("Your schedule time:" + Appointment1.getDate());
    System.out.println(Appointment1.reschedule());
    System.out.println(Appointment1.cancel());

  }
  }
//Rukhanov Birzhan IT-2502
//Theme:Hospital