import java.util.*;
abstract class Employee {
    private int employeeId;
    private String name;
    private double baseSalary;
    
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    
    public int getEmployeeId() {
        return employeeId;
    }
    
    public String getName() {
        return name;
    }
    
    public double getBaseSalary() {
        return baseSalary;
    }
    
    public abstract double calculateSalary();
    
    public void displayDetails() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Salary: " + calculateSalary());
    }
}


interface Department {
    void assignDepartment(String department);
    String getDepartmentDetails();
}


class FullTimeEmployee extends Employee implements Department {
    private String department;
    private double bonus;
    
    public FullTimeEmployee(int employeeId, String name, double baseSalary, double bonus) {
        super(employeeId, name, baseSalary);
        this.bonus = bonus;
    }
    
    @Override
    public double calculateSalary() {
        return getBaseSalary() + bonus;
    }
    
    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}


class PartTimeEmployee extends Employee implements Department {
    private String department;
    private int hoursWorked;
    private double hourlyRate;
    
    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
    
    @Override
    public void assignDepartment(String department) {
        this.department = department;
    }
    
    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }
}




public class EmployeeManagementSystem {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        FullTimeEmployee fte = new FullTimeEmployee(101, "Alice", 50000, 10000);
        fte.assignDepartment("HR");
        
        PartTimeEmployee pte = new PartTimeEmployee(102, "Bob", 0, 20, 50);
        pte.assignDepartment("IT Support");
        
        employees.add(fte);
        employees.add(pte);
        
        for (Employee emp : employees) {
            emp.displayDetails();
            if (emp instanceof Department) {
                System.out.println(((Department) emp).getDepartmentDetails());
            }
        }
    }
}
