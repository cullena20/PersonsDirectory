package assignments.assignment4;
import java.util.ArrayList;

public class Persons {
    // ArrayList<Person> can work with any object that inherits from Person
    // so if you wanted an array that can hold anything, you can have ArrayList<Object>
    ArrayList<Person> people = new ArrayList<Person>();
    int size = 0;

    public ArrayList<Person> getInternalList() {
        return this.people;
    }

    // code still works with only one add method using Person p
    public void add(Person p) {
        this.people.add(p);
        this.size += 1;
    }

    public void delete(int i) {
        if (i > this.size - 1 || i < 0) {
            System.out.println("Not a valid index" + "\n");
        }
        else {
            this.people.remove(i);
            this.size -= 1;
        }
        
    }

    public int getSize() {
        return this.size;
    }

    public Persons search(String name) {
        Persons matched = new Persons();
        for (Person p : this.people) {
            if (p.getName().toLowerCase().equals(name.toLowerCase())) {
                matched.add(p);
            }
        }
        return matched;
    }

    public String toString() {
        String toReturn = "";
        for (Person p : this.people) {
            toReturn += p.toString() + '\n';
            toReturn += "===================\n";
        }
        return toReturn;
    }
}

// interesting stuff with how Java treats subclasses when we declare variable types