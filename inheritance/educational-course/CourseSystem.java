
class Course {
    protected String courseName;
    protected int duration; 
    
    public Course(String courseName, int duration) {
        this.courseName = courseName;
        this.duration = duration;
    }
    
    public String getCourseDetails() {
        return "Course: " + courseName + ", Duration: " + duration + " weeks";
    }
}

class OnlineCourse extends Course {
    protected String platform;
    protected boolean isRecorded;
    
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }
    
    @Override
    public String getCourseDetails() {
        return super.getCourseDetails() + ", Platform: " + platform + ", Recorded: " + (isRecorded ? "Yes" : "No");
    }
}

class PaidOnlineCourse extends OnlineCourse {
    protected double fee;
    protected double discount; 
    
    public PaidOnlineCourse(String courseName, int duration, String platform, boolean isRecorded, double fee, double discount) {
        super(courseName, duration, platform, isRecorded);
        this.fee = fee;
        this.discount = discount;
    }
    
    public double getFinalPrice() {
        return fee - (fee * discount / 100);
    }
    
    @Override
    public String getCourseDetails() {
        return super.getCourseDetails() + ", Fee: $" + fee + ", Discount: " + discount + "%" + ", Final Price: $" + getFinalPrice();
    }
}


public class CourseSystem {
    public static void main(String[] args) {
        Course course = new Course("Java Basics", 4);
        System.out.println(course.getCourseDetails());
        
        OnlineCourse onlineCourse = new OnlineCourse("Advanced Java", 6, "Udemy", true);
        System.out.println(onlineCourse.getCourseDetails());
        
        PaidOnlineCourse paidCourse = new PaidOnlineCourse("Full Stack Development", 12, "Coursera", true, 500, 20);
        System.out.println(paidCourse.getCourseDetails());
    }
}
