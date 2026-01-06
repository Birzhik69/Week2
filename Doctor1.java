public class Doctor1 extends Person{
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
        this.specialization = specialization;
    }
    public int getExperienceYears() {
        return experienceYears;
    }
    public void setExperienceYears(int experienceYears) {
        if (experienceYears >= 0) {
            this.experienceYears = experienceYears;
        }
    }
    // Override method 1
    @Override
    public void work() {
        System.out.println("Doctor " + name + " is treating patients(" + specialization + ", " + experienceYears + " years).");;
    }
    // Override method 2
    @Override
    public String getRole() {
        return "Doctor1";
    }
    //Unique method
    public void diagnosePatient(String patientName) {
        System.out.println("Doctor " + name + " diagnosed patient: " + patientName);
    }
    // Another unique method
    public void prescribeMedicine(String medicine) {
        System.out.println("Doctor " + name + " prescribed: " + medicine);
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