public class Person {
    protected int id;
    protected String name;
    protected int age;
    protected String phoneNumber;

    public Person(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }
    // Getters
    public int getId() {return id;}
    public String getName() { return name; }
    public double getAge() { return age; }
    public String phoneNumber() { return phoneNumber; }
    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(int age) {
        if (age >= 0) this.age = age;
        else System.out.println("Invalid age");
    }
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
            this.phoneNumber = phoneNumber.trim();
        }
    }
    public void work() {
        System.out.println(name + " is in the hospital.");
    }
    public String getRole() {
        return "Patient";
    }
    public boolean isMinor() {
        return age >= 0 && age < 18;
    }
    @Override
    public String toString() {
        return "[" + getRole() + "] " + name + " (ID: " + id + ")";
    }
}