package assignments.assignment4;
import java.util.Scanner;

public class Person {
    private String newName;
    private String address;
    private String phone;

    public Person(String newName, String address, String phone) {
        this.newName = newName;
        this.address = address;
        this.phone = phone;
    }

    public Person() {
        this.newName = null;
        this.address = null;
        this.phone = null;
    }
    
    // sloppy naming
    public String getName() {
        return newName;
    }

    public void setName(String newName) {
        this.newName = newName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void getData() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name                          : ");
        this.newName = s.next();
        System.out.println("Enter address                       : ");
        this.address = s.next();
        System.out.println("Enter phone (in xxx-xxx-xxxx format): " );
        this.phone = s.next();
    }

    public String toString() {
        return "Name         : " + this.newName
        + "\nAddress      : " + this.address 
        + "\nPhone        : " + this.phone;
    }
}
