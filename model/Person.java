package model;

public abstract class Person {
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
    public void displayInfo(){
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
    public abstract void NewWork();
    public abstract String getNewRole();
    // Getters
    public int getId() {return id;}
    public String getName() { return name; }
    public double getAge() { return age; }
    public String phoneNumber() { return phoneNumber; }
    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) {
            if (name == null || name.trim().isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }
            this.name = name;
    }
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Salary cannot be negative");
        }
        this.age = age;

    }
    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("PhoneNumber cannot be empty");
        }
        this.phoneNumber = phoneNumber;
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