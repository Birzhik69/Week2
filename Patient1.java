public class Patient1 extends Person{
    private String BloodType;
    public Patient1(int id, String name, int age, String phoneNumber, String BloodType) {
        super(id, name, age, phoneNumber);
        this.BloodType = BloodType;}
    public String BloodType() {
        return BloodType;
    }
    public void BloodType(String BloodType) {
        this.BloodType = BloodType;
    }
    // Override method 1
    @Override
    public void work() {
        System.out.println("Patient " + name + " is receiving treatment. Blood type:" + BloodType);
    }
    // Override method 2
    @Override
    public String getRole() {
        return "Patient1";
    }
        public void requestHelp() {
            System.out.println("Patient " + name + " requested help.");
    }
    // Another new method
    public void takeMedicine(String medicine) {
        System.out.println("Patient " + name + " took: " + medicine);
    }
    @Override
    public String toString() {
        return super.toString() + " | Blood type: " + BloodType;
    }

    public String getBloodType() {
        return BloodType;
    }
}