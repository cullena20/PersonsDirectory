package assignments.assignment4;

public class Employee extends Person {
    private String department;

    public Employee(String newName, String address, String phone, String department) {
        super(newName, address, phone);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Name         : " + this.getName()
        + "\nAddress      : " + this.getAddress()
        + "\nPhone        : " + this.getPhone()
        + "\nDepartment   : " + this.department;
    }
}
