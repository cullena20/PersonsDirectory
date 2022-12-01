package assignments.assignment4;

public class Test {
    public static void main(String[] args) {
        Person person1 = new Person("Daniel", "Rego Park", "111-222-3333");
        System.out.println(person1 + "\n");
        Student student1 = new Student("Bob", "Van Meter", "000-111-2222", 2026);
        System.out.println(student1 + "\n");
        Employee employee1 = new Employee("Dylan", "Midtown", "444-111-2222", "sales");
        System.out.println(employee1 + "\n");

        Persons directory = new Persons();
        System.out.println(directory.getSize());
        directory.add(person1);
        System.out.println(directory.getSize());
        directory.add(student1);
        System.out.println(directory.getSize());
        directory.add(employee1);
        System.out.println(directory.getSize());
        // using Person p here works since all other objects inherit from it
        for (Person p : directory.getInternalList()) {
            System.out.println(p);
        }

        // Testing Persons.add()
        System.out.println(directory); // this should print nothing
        System.out.println("Empty directory has been printed");
        directory.add(person1);
        directory.add(student1);
        directory.add(employee1);
        System.out.println(directory); 
        // this should print the three objects added to the directory, following toString()
        // it should print person1, student1, and employee1 in that order

        // Testing Persons.delete()
        directory.delete(3);
        directory.delete(-1);
        // this should print out "Not a valid index" since only indexes between 0 and 2 are valid here for a list of size 3
        directory.delete(0);
        System.out.println(directory); 
        System.out.println("person1 has been deleted");
        // this should print out student1 (Bob) and employee1 (Dylan) and not Daniel since Daniel is deleted
        directory.delete(1);
        System.out.println(directory); 
        // this should print out student1 (Bob) but not employee 1 (Dylan) since Dylan is deleted
    }
}
