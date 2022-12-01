package assignments.assignment4;
import java.util.Scanner;

public class MainProgram {

    public static void enterNewPerson(Persons directory) {
        // possibly need to change this to use Person.getdata() - what do I do if it's a Student or Employee?
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name                          : ");
        String newName = s.next();
        System.out.println("Enter address                       : ");
        String address = s.next();
        System.out.println("Enter phone (in xxx-xxx-xxxx format): " );
        String phone = s.next();
        System.out.println("Is the person being entered a student? (y/n)");
        char i = s.next().toLowerCase().charAt(0);
        if (i == 'y') {
            System.out.println("Enter year                      : " );
            int year = s.nextInt();
            Student p = new Student(newName, address, phone, year);
            directory.add(p);
        }
        else {
            System.out.println("Is the person being entered an employee? (y/n)");
            char j = s.next().toLowerCase().charAt(0);
            if (j == 'y') {
                System.out.println("Enter department            : " );
                String deparment = s.next();
                Employee p = new Employee(newName, address, phone, deparment);
                directory.add(p);
            }
            else {
                Person p = new Person(newName, address, phone);
                directory.add(p);
            }
        }
        System.out.println('\n');
    }

    public static void search(Persons directory) {
        System.out.println("Enter name you are searching for    : ");
        Scanner s = new Scanner(System.in);
        String name = s.next();
        Persons matched = directory.search(name);
        System.out.println('\n');
        System.out.println(matched);
    }

    public static void modify(Persons directory) {
        // possibly need to modify this to use Person.getData()
        System.out.println("Enter name you are searching for    : ");
        Scanner s = new Scanner(System.in);
        String name = s.next();
        Persons matched = directory.search(name);
        for (Person p: matched.getInternalList()) {
            System.out.println(p);
            System.out.println("Do you wish to modify this record? (y/n)");
            char j = s.next().toLowerCase().charAt(0);
            if (j == 'y') {
                System.out.println("Enter name                          : ");
                String newName = s.next();
                System.out.println("Enter address                       : ");
                String address = s.next();
                System.out.println("Enter phone (in xxx-xxx-xxxx format): " );
                String phone = s.next();
                p.setName(newName);
                p.setAddress(address);
                p.setPhone(phone);
                if (p instanceof Student) {
                    System.out.println("Enter year                      : " );
                    int year = s.nextInt();
                    // not as clean of a solution as using update methods in classes, works for now
                    ((Student)p).setGraduationYear(year);
                }
                else if (p instanceof Employee) {
                    System.out.println("Enter department            : " );
                    String department = s.next();
                    ((Employee)p).setDepartment(department);
                }
            }
        }
    }

    public static void delete(Persons directory) {
        // could add functionality to search by name here, but not for assignment
        System.out.println("Enter index you wish to delete     : ");
        Scanner s = new Scanner(System.in);
        int idx = s.nextInt();
        if (idx > directory.getSize() - 1 || idx < 0) {
            System.out.println("Not a valid index" + "\n");
        }
        else {
            System.out.println(directory.getInternalList().get(idx));
            System.out.println("Do you wish to delete this record? (y/n)");
            char j = s.next().toLowerCase().charAt(0);
            if (j == 'y') {
                directory.delete(idx);
            }
            else {
                System.out.println('\n');
            }
        }
    }

    public static void runProgram(Persons directory) {
        while (true) {
            System.out.println("Enter option from list below:");
            System.out.println("  1) Display complete directory");
            System.out.println("  2) Enter new Person");
            System.out.println("  3) Search for Person");
            System.out.println("  4) Modify Person information");
            System.out.println("  5) Delete a record");
            System.out.println("  Q) Quit");
            Scanner s = new Scanner(System.in);
            System.out.println("Enter your option: ");
            char i = s.next().toLowerCase().charAt(0);

            // Display directory
            if (i == '1') {
                System.out.println(directory);
            }

            // Enter new person
            else if (i == '2') {
                enterNewPerson(directory);
            }

            // Search for person
            else if (i == '3') {
                search(directory);
            }

            // Modify person info
            // note that you can modify object directly even though it is in matched because how things are referenced
            // I coded this so that it keeps the type of object the person being modified the same, so a student stays a student
            // This could be modified, but it wasn't said on the instructions
            else if (i == '4') {
                modify(directory);
            }

            // Delete a record
            // This is zero indexed, but could be easily modified
            else if (i == '5') {
                delete(directory);
            }

            // Quit
            else if (i == 'q') {
                break;
            }

            else {
                System.out.println("Not a valid input");
            }
        }
    }

    public static void main(String[] args) {
        // Testing Persons.add()
        Person person1 = new Person("Daniel", "Rego Park", "111-222-3333");
        Student student1 = new Student("Bob", "Van Meter", "000-111-2222", 2026);
        Employee employee1 = new Employee("Dylan", "Midtown", "444-111-2222", "sales");
        Persons directory = new Persons();
        directory.add(person1);
        directory.add(student1);
        directory.add(employee1);
        
        runProgram(directory);
    }
}

// bug when having space between values with enter name:
// e.g. enter name: Not Bob
// Not becomes Name, Bob becomes address