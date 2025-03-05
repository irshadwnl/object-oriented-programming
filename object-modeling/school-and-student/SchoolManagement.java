import java.util.HashSet;
import java.util.Set;

// Course Class
class Course {
    private String courseName;
    private Set<Student> enrolledStudents;

    public Course(String courseName) {
        this.courseName = courseName;
        this.enrolledStudents = new HashSet<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public void enrollStudent(Student student) {
        enrolledStudents.add(student);
        student.addCourse(this);
    }

    public void showEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
    }
}

// Student Class
class Student {
    private String name;
    private Set<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void viewEnrolledCourses() {
        System.out.println(name + " is enrolled in:");
        for (Course course : courses) {
            System.out.println("- " + course.getCourseName());
        }
    }
}

// School Class (Aggregation)
class School {
    private String schoolName;
    private Set<Student> students;

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.students = new HashSet<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showAllStudents() {
        System.out.println("Students at " + schoolName + ":");
        for (Student student : students) {
            System.out.println("- " + student.getName());
        }
    }
}

// Main Class
public class SchoolManagement {
    public static void main(String[] args) {
        // Creating School
        School school = new School("Greenwood High");

        // Creating Students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Creating Courses
        Course math = new Course("Mathematics");
        Course science = new Course("Science");

        // Enrolling students in courses
        math.enrollStudent(alice);
        science.enrollStudent(alice);
        science.enrollStudent(bob);

        // Adding students to the school
        school.addStudent(alice);
        school.addStudent(bob);

        // Display enrolled courses for students
        alice.viewEnrolledCourses();
        bob.viewEnrolledCourses();

        // Display enrolled students in courses
        math.showEnrolledStudents();
        science.showEnrolledStudents();

        // Display all students in the school
        school.showAllStudents();
    }
}
