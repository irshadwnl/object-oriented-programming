public class Course {
    String courseName;
    int duration;
    int fee;
    static String instituteName="Chitkara University";

    public Course(String courseName, int duration, int fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails(){
        System.out.println("Course Details Are: ");
        System.out.println("CourseName: "+courseName);
        System.out.println("Duration: "+duration);
        System.out.println("Fee: "+fee);
        System.out.println("Institute: "+instituteName);
    }

    static void  updateInstituteName(String newInstitute){
        instituteName =newInstitute;
    }
    public static void main(String[] args) {
        Course c1=new Course("Cse", 4, 700000);
        Course c2=new Course("Cse", 4, 700000);

        c1.displayCourseDetails();
        Course.updateInstituteName("Deccan University");
        c2.displayCourseDetails();

    }
}
