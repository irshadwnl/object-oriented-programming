import java.util.HashSet;
import java.util.Set;

// Student Class (Association with Course)
class Student {
    private String name;
    private Set<Course> enrolledCourses;

    public Student(String name) {
        this.name = name;
        this.enrolledCourses = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
        course.addStudent(this); // Establish bidirectional association
        System.out.println(name + " has enrolled in " + course.getCourseName());
    }

    public void showEnrolledCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course c : enrolledCourses) {
            System.out.println("- " + c.getCourseName());
        }
    }
}

// Professor Class (Aggregation with Course)
class Professor {
    private String name;

    public Professor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Course Class (Association with Student, Aggregation with Professor)
class Course {
    private String courseName;
    private Set<Student> students;
    private Professor professor;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new HashSet<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println("Professor " + professor.getName() + " is assigned to " + courseName);
    }

    public void showStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }

    public void showProfessor() {
        if (professor != null) {
            System.out.println(courseName + " is taught by Professor " + professor.getName());
        } else {
            System.out.println(courseName + " has no assigned professor yet.");
        }
    }
}

// Main Class
public class UniversitySystem {
    public static void main(String[] args) {
        // Creating Students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Creating Professors
        Professor drSmith = new Professor("Dr. Smith");
        Professor drJones = new Professor("Dr. Jones");

        // Creating Courses
        Course math = new Course("Mathematics");
        Course cs = new Course("Computer Science");

        // Enrolling Students in Courses
        alice.enrollCourse(math);
        alice.enrollCourse(cs);
        bob.enrollCourse(cs);

        // Assigning Professors to Courses
        math.assignProfessor(drSmith);
        cs.assignProfessor(drJones);

        // Display Data
        math.showStudents();
        math.showProfessor();
        
        cs.showStudents();
        cs.showProfessor();
        
        alice.showEnrolledCourses();
        bob.showEnrolledCourses();
    }
}
