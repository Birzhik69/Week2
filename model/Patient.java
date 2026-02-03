package model;
import hospitalmenu.Manageable;
public class Patient implements Manageable {
    private int PatientID;
    private String FullName;
    private int Age;
    private String BloodType;
//Getters and Setters
    public int getPatientId() {
        return PatientID;
    }
    public void setPatientID(int patientID) {
        if (patientID <= 0 || patientID >= 9999999) {
            System.out.println("Invalid model.Patient ID");
            patientID = 0;
        }
        PatientID = patientID;
    }
    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        if (fullName != null && !fullName.trim().isEmpty()) {
            this.FullName = fullName;
        } else {
            System.out.println("Warning: Name cannot be empty!");
        }
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        if (age >= 0) {
            this.Age = age;
        } else {
            System.out.println("Age cannot be negative! Setting to 0.");
            this.Age = 0;
        }
    }

    public String getBloodType() {
        return BloodType;
    }

    public void setBloodType(String bloodType) {
        if (bloodType != null && !bloodType.trim().isEmpty()) {
            this.BloodType = bloodType;
        } else {
            System.out.println("Warning: BloodType cannot be empty!");
        }
    }
//To string
    @Override
    public String toString() {
        return "model.Patient{" +
                "patientId=" + PatientID +
                ", fullName='" + FullName + '\'' +
                ", age=" + Age +
                ", BloodType='" + BloodType + '\'' +
                '}';
    }
    //Abstract methods
    @Override
    public void startTreatment() {
        System.out.println(FullName + " has started treatment.");
    }
    @Override
    public void finishTreatment() {
        System.out.println(FullName + " has completed treatment.");
    }

    //Constructor
public Patient(int patientId, String fullName, int age, String bloodType) {
    setPatientID(patientId);
    setFullName(fullName);
    setAge(age);
    setBloodType(bloodType);
}
    public String IsMinor(){ //Check if patient is minor or not
        if (Age < 18){
            return ("Minor");
        }
        else{
            return ("Not Minor");
        }
    }
    public String getAgeCategory(){  //Checks age category of patient
        if (Age < 18){
            return ("Minor");
        }
        if (Age < 30){
            return ("Adult");
        }
        else{
            return ("Elders");

        }
    }

    public String getName() {
        return null;
    }
}
