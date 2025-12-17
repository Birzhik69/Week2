import java.util.Scanner;
public class Patient{
    private int patientId;
    private String fullName;
    private int age;
    private String BloodType;
//Getters and Setters
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBloodType() {
        return BloodType;
    }

    public void setBloodType(String bloodType) {
        BloodType = bloodType;
    }
//To string
    @Override
    public String toString() {
        return "Patient{" +
                "patientId=" + patientId +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", BloodType='" + BloodType + '\'' +
                '}';
    }
//Constructor
    public Patient(int patientId, String fullName, int age, String bloodType) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
        BloodType = bloodType;
    }
    public String IsMinor(){ //Check if patient is minor or not
        if (age > 18){
            return ("Not a minor");
        }
        else{
            return ("Minor");
        }
    }
    public String getAgeCategory(){  //Checks age category of patient
        if (age < 18){
            return ("Minor");
        }
        if (age > 18 && age < 30){
            return ("Adult");
        }
        else{
            return ("Elders");

        }
    }

}