package assignments.assignment4;

public class Student extends Person {
    private int year;

    public Student(String newName, String address, String phone, int year) {
        super(newName, address, phone);
        this.year = year;
    }

    // sloppy naming here
    public int getGraduationYear() {
        return year;
    }

    public void setGraduationYear(int year) {
        this.year = year;
    }
    
    @Override
    public String toString() {
        return "Name         : " + this.getName()
        + "\nAddress      : " + this.getAddress()
        + "\nPhone        : " + this.getPhone()
        + "\nYear         : " + this.year;
    }

    // may need to add a getData() method with @Override
}
