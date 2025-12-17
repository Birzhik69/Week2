
import java.util.Objects;
import java.util.Scanner;
public class Appointment{
    private int appointmentId;
    private String patientName;
    private String doctorName;
    public String date;
//Getters and setters
    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "appointmentId=" + appointmentId +
                ", patientName='" + patientName + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", date=" + date +
                '}';
    }
//Constructor
    public Appointment(int appointmentId, String patientName, String doctorName, String date) {
        this.appointmentId = appointmentId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.date = date;
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
            this.appointmentId = 0;
            this.patientName = "-";
            this.doctorName = "-";
            this.date = "-";
            return "Appointment canceled.";
        }
        else{
            return ("No changes");
        }

    }


}