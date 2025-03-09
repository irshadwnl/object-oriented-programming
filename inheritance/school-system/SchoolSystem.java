class Person {
    protected String name;
    protected int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Teacher extends Person {
    private String subject;
    
    public Teacher(String name, int age, String subject) {
        super(name, age);
        this.subject = subject;
    }
    
    public void displayRole() {
        System.out.println(name + " is a Teacher of " + subject);
    }
}

class Student extends Person {
    private int grade;
    
    public Student(String name, int age, int grade) {
        super(name, age);
        this.grade = grade;
    }
    
    public void displayRole() {
        System.out.println(name + " is a Student in Grade " + grade);
    }
}

class Staff extends Person {
    private String department;
    
    public Staff(String name, int age, String department) {
        super(name, age);
        this.department = department;
    }
    
    public void displayRole() {
        System.out.println(name + " is a Staff member in " + department + " department");
    }
}

public class SchoolSystem {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Alice", 35, "Mathematics");
        teacher.displayInfo();
        teacher.displayRole();
        
        Student student = new Student("Bob", 16, 10);
        student.displayInfo();
        student.displayRole();
        
        Staff staff = new Staff("Charlie", 40, "Administration");
        staff.displayInfo();
        staff.displayRole();
    }
}
