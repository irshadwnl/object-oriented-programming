import java.util.ArrayList;
import java.util.List;

// Employee class (part of a Department)
class Employee {
    private String name;
    
    public Employee(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
}

// Department class (part of a Company)
class Department {
    private String name;
    private List<Employee> employees;
    
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }
    
    public void addEmployee(String employeeName) {
        employees.add(new Employee(employeeName));
    }
    
    public void showEmployees() {
        System.out.println("Employees in " + name + " department:");
        for (Employee emp : employees) {
            System.out.println("- " + emp.getName());
        }
    }
}

// Company class containing multiple departments
class Company {
    private String name;
    private List<Department> departments;
    
    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }
    
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }
    
    public Department getDepartment(int index) {
        return departments.get(index);
    }
    
    public void showCompanyStructure() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.showEmployees();
        }
    }
    
    // When the company is deleted, all departments and employees are also deleted
}

public class CompanySystem {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");
        
        company.addDepartment("IT");
        company.addDepartment("HR");
        
        company.getDepartment(0).addEmployee("Alice");
        company.getDepartment(0).addEmployee("Bob");
        company.getDepartment(1).addEmployee("Charlie");
        
        company.showCompanyStructure();
        
        // Deleting company (in actual implementation, Java's garbage collector will handle memory cleanup)
        company = null;
        System.gc(); // Request garbage collection (not guaranteed immediate execution)
    }
}
