import java.util.ArrayList;
import java.util.List;

// Faculty Class (Aggregation: Faculty can exist independently)
class Faculty {
    private String name;

    public Faculty(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Department Class (Composition: Departments exist only within a University)
class Department {
    private String departmentName;

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}

// University Class (Composition with Department, Aggregation with Faculty)
class University {
    private String universityName;
    private List<Department> departments;
    private List<Faculty> facultyMembers;

    public University(String universityName) {
        this.universityName = universityName;
        this.departments = new ArrayList<>();
        this.facultyMembers = new ArrayList<>();
    }

    // Add a department (Composition: University owns the departments)
    public void addDepartment(String departmentName) {
        departments.add(new Department(departmentName));
    }

    // Add a faculty member (Aggregation: Faculty exists independently)
    public void addFaculty(Faculty faculty) {
        facultyMembers.add(faculty);
    }

    public void showDepartments() {
        System.out.println("Departments in " + universityName + ":");
        for (Department dept : departments) {
            System.out.println("- " + dept.getDepartmentName());
        }
    }

    public void showFaculty() {
        System.out.println("Faculty members associated with " + universityName + ":");
        for (Faculty faculty : facultyMembers) {
            System.out.println("- " + faculty.getName());
        }
    }

    // Simulating deletion of University (Composition: Deleting University deletes its departments)
    public void deleteUniversity() {
        System.out.println("Deleting " + universityName + "...");
        departments.clear(); // All departments are deleted
        System.out.println("All departments have been deleted.");
    }
}

// Main Class
public class UniversityManagement {
    public static void main(String[] args) {
        // Creating University
        University university = new University("Oxford University");

        // Adding Departments (Composition)
        university.addDepartment("Computer Science");
        university.addDepartment("Mechanical Engineering");

        // Creating Faculty Members (Aggregation)
        Faculty profJohn = new Faculty("Prof. John");
        Faculty profEmma = new Faculty("Prof. Emma");

        // Associating Faculty with the University
        university.addFaculty(profJohn);
        university.addFaculty(profEmma);

        // Display Departments and Faculty
        university.showDepartments();
        university.showFaculty();

        // Delete University (Departments should also be deleted)
        university.deleteUniversity();

        // Faculty members still exist independently
        System.out.println("Independent Faculty Members:");
        System.out.println("- " + profJohn.getName());
        System.out.println("- " + profEmma.getName());
    }
}
