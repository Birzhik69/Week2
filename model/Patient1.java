package model;

public class Patient1 extends Person {
    private String BloodType;
    public Patient1(int id, String name, int age, String phoneNumber, String BloodType) {
        super(id, name, age, phoneNumber);
        this.BloodType = BloodType;}
    public String BloodType() {
        return BloodType;
    }
    public void setBloodType(String BloodType) {
        if (BloodType == null  || getBloodType().isEmpty()) {
            throw new IllegalArgumentException("BloodType cannot be empty");
        }
        this.BloodType = BloodType;
    }
    // Override method 1
    @Override
    public void work() {
        System.out.println("model.Patient " + name + " is receiving treatment. Blood type:" + BloodType);
    }
    // Override method 2
    @Override
    public String getRole() {
        return "model.Patient1";
    }
        public void requestHelp() {
            System.out.println("model.Patient " + name + " requested help.");
    }
    // Another new method
    public void takeMedicine(String medicine) {
        System.out.println("model.Patient " + name + " took: " + medicine);
    }
    @Override
    public String toString() {
        return super.toString() + " | Blood type: " + BloodType;
    }

    public String getBloodType() {
        return BloodType;
    }
    //Abstract methods
    @Override
    public void NewWork(){
        System.out.println("model.Patient " + name + " got brain cancer at age" + age);
    }
    @Override
    public String getNewRole(){
        return "model.Patient1";
    }
}