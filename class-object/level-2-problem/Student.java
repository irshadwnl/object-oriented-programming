
// Program to Simulate Student Report

public class Student {
    private String name;
    private int rollNumber;
    private int marks;
    Student(String name,int rollNumber,int marks){
        this.name=name;
        this.rollNumber=rollNumber;
        this.marks=marks;
    }
    static char  calculateGrade(int marks){
        if(marks>80){
            return 'O';
        }else if(marks >70){
            return 'A';
        }else if(marks >60){
            return 'B';
        }else if(marks >50){
            return 'C';
        }else if(marks >40){
            return 'D';
        }
        return 'F';
    } 

    void display(){
        System.out.println("Name: "+name);
        System.out.println("Roll Number: "+rollNumber);
        System.out.println("Marks: "+marks);
        System.out.println("Grade: "+calculateGrade(marks));
    }
    public static void main(String[] args) {
        Student s1=new Student("Irshad", 20, 85);
        s1.display();
    }
    
}
