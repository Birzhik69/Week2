package model;

public class Doctor1 extends Person {
    private String specialization;
    private  int experienceYears;
    //Constructor
    public Doctor1(int id, String name, int age, String phoneNumber, String specialization, int experienceYears) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
        this.experienceYears  = experienceYears ;}
    //Getters and setters
    public String getSpecialization() {
        return specialization;
    }
    public void setSpecialization(String specialization) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Specialization cannot be empty");
        }
        this.name = name;
    }
    public int getExperienceYears() {
        return experienceYears;
    }
    public void setExperienceYears(int experienceYears) {
        if (experienceYears < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.experienceYears = experienceYears;

    }
    // Override method 1
    @Override
    public void work() {
        System.out.println("model.Doctor " + name + " is treating patients(" + specialization + ", " + experienceYears + " years).");;
    }

    // Override method 2
    @Override
    public String getRole() {
        return "model.Doctor1";
    }
    //Abstract methods
    @Override
    public void NewWork(){
        System.out.println("model.Doctor " + name + "is performing surgery and his specialization is " + specialization );
    }
    public void startTreatment() {
        System.out.println(name + " has started treatment.");
    }
    @Override
    public String getNewRole() {
        return "model.Doctor1";
    }
    //Unique method
    public void diagnosePatient(String patientName) {
        System.out.println("model.Doctor " + name + " diagnosed patient: " + patientName);
    }
    // Another unique method
    public void prescribeMedicine(String medicine) {
        System.out.println("model.Doctor " + name + " prescribed: " + medicine);
    }
    public boolean isExperienced() {
        return experienceYears >= 5;
    }

    @Override
    public String toString() {
        return super.toString() +
                " | Specialization: " + specialization +
                " | Experience: " + experienceYears + " years";
    }
}