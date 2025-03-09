class Person {
    protected String name;
    protected int id;
    
    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

interface Worker {
    void performDuties();
}

// Subclass Chef implementing Worker interface
class Chef extends Person implements Worker {
    private String specialty;
    
    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }
    
    @Override
    public void performDuties() {
        System.out.println(name + " is preparing " + specialty + " dishes.");
    }
}

// Subclass Waiter implementing Worker interface
class Waiter extends Person implements Worker {
    private int tablesAssigned;
    
    public Waiter(String name, int id, int tablesAssigned) {
        super(name, id);
        this.tablesAssigned = tablesAssigned;
    }
    
    @Override
    public void performDuties() {
        System.out.println(name + " is serving " + tablesAssigned + " tables.");
    }
}

// Main class to test the hybrid inheritance
public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon", 101, "Italian");
        chef.displayInfo();
        chef.performDuties();
        
        Waiter waiter = new Waiter("John", 202, 5);
        waiter.displayInfo();
        waiter.performDuties();
    }
}
