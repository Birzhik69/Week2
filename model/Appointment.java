package model;

import java.util.Objects;
import java.util.Scanner;
public class Appointment{
    private int AppointmentID;
    private String PatientName;
    private String DoctorName;
    public String Date;
//Getters and setters
    public int getAppointmentId() {
        return AppointmentID;
    }

    public void setAppointmentId(int appointmentID) {
        if (appointmentID <= 0 || appointmentID >= 999) {
            System.out.println("Invalid model.Patient ID");
            appointmentID = 0;
        }
        AppointmentID = appointmentID;
    }

    public String getPatientName() {
        return PatientName;
    }

    public void setPatientName(String patientName) {
        if (patientName != null && !patientName.trim().isEmpty()) {
            this.PatientName = patientName;
        } else {
            System.out.println("Warning: Name cannot be empty!");
        }
    }

    public String getDoctorName() {
        return DoctorName;
    }

    public void setDoctorName(String doctorName) {
        if (doctorName != null && !doctorName.trim().isEmpty()) {
            this.DoctorName = doctorName;
        } else {
            System.out.println("Warning: Name cannot be empty!");
        }
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        if (date != null && !date.trim().isEmpty()) {
            this.Date = date;
        } else {
            System.out.println("Warning: date cannot be empty!");
        }
    }

    @Override
    public String toString() {
        return "model.Appointment{" +
                "appointmentId=" + AppointmentID +
                ", patientName='" + PatientName + '\'' +
                ", doctorName='" + DoctorName + '\'' +
                ", date=" + Date +
                '}';
    }
//Constructor
    public Appointment(int appointmentId, String patientName, String doctorName, String date) {
        setAppointmentId(appointmentId);
        setPatientName(patientName);
        setDoctorName(doctorName);
        setDate(date);
    }
    //FUNCTIONS
    public String reschedule(){ //Reschedule time
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new schedule time: ");
        String newdate = sc.nextLine();
        return ("Your new schedule time: " + newdate);
    }
    public String cancel(){ //Ask if patient wants to cancel or keep the appointment.If answer is true,clears all information
        Scanner sc = new Scanner(System.in);
        System.out.print("Do you want to cancel the appointment? ");
        String newCancel = sc.nextLine();
        if (Objects.equals(newCancel, "Yes") || Objects.equals(newCancel, "YES") || Objects.equals(newCancel, "yes")) {
            this.AppointmentID = 0;
            this.PatientName = "-";
            this.DoctorName = "-";
            this.Date = "-";
            return "model.Appointment canceled.";
        }
        else{
            return ("No changes");
        }

    }


}