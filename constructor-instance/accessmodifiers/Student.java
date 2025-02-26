
public class Student {
    public int rollNumber;
    protected String name;
    private float cgpa;

    public Student(int rollNumber, String name, float cgpa) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.cgpa = cgpa;
    }

    public float getCgpa() {
        return cgpa;
    }
    void modifyCgpa(float c){
        if(c>=0.0f && c<=100.0f){
            cgpa=c;
        }else{
            System.out.println("Invalid CGPA");
        }
    }

    void display(){
        System.out.println("Studen Details:-");
        System.out.println("Name: "+name);
        System.out.println("Roll: "+rollNumber);
        System.out.println("CGPA: "+cgpa);
    }
    public static void main(String[] args) {
        Student s1=new Student(19, "Mohit", 8.53f);
        s1.display();
        System.out.println("Cgpa is :"+s1.getCgpa());
        s1.modifyCgpa(8.98f);
        System.out.println("CGPA after updating: "+s1.getCgpa());

        PostgraduateStudent pg=new PostgraduateStudent(56, "Sonu", 8.45f,"Btech");
        pg.displayPost();
    }
}
class PostgraduateStudent extends Student{
    private String stream;
    PostgraduateStudent(int rollNumber,String name,float cgpa,String stream){
        super(rollNumber,name,cgpa);
        this.stream=stream;
    }    
    void displayPost(){
        System.out.println("Studen Details:-");
        System.out.println("Name: "+name);
        System.out.println("Roll: "+rollNumber);
        System.out.println("Stream: "+stream);
    }
}
