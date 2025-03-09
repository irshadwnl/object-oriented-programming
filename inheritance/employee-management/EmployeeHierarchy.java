abstract class Employee{
    String name;
    int id;
    int salary;

    public Employee(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    
    public abstract void displayDetails();
    
}
class Manager extends Employee{
    int teamSize;
    public Manager(String name, int id, int salary,int teamSize) {
            super(name, id, salary);
            this.teamSize=teamSize;
        }
    public void displayDetails(){
        System.out.println("Manager Details:-----");
        System.out.println("Name: "+name);
        System.out.println("ID: "+id);
        System.out.println("Salary: "+salary);
        System.out.println("Team Size: "+teamSize);
    }
}
class Developer extends  Employee{
    String programmingLanguage;
    public Developer(String name, int id, int salary,String programmingLanguage) {
            super(name, id, salary);
            this.programmingLanguage=programmingLanguage;
        }
        public void displayDetails(){
            System.out.println("Developer Details:-----");
            System.out.println("Name: "+name);
            System.out.println("ID: "+id);
            System.out.println("Salary: "+salary);
            System.out.println("Programming Language: "+programmingLanguage);
        }

}
class Intern extends Employee{

    public Intern(String name, int id, int salary) {
        super(name, id, salary);
    }

    @Override
    public void displayDetails() {
        System.out.println("Intern Details:-----");
            System.out.println("Name: "+name);
            System.out.println("ID: "+id);
            System.out.println("Salary: "+salary);
    }

}
public class EmployeeHierarchy {
    public static void main(String[] args) {
        Employee e1=new Manager("Irshad", 884, 3000000, 5);
        Employee e2=new Developer("Mohit", 887, 100000, "java");
        Employee e3=new Intern("Saif", 872, 100000);
        e1.displayDetails();
        e2.displayDetails();
        e3.displayDetails();
    }
}
