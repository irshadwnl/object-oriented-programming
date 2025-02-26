
import java.util.Scanner;

public class Circle {
    private double radius;
    
    public Circle() {
        System.out.println("Default Constructor called using constructor chaining");
    }

    public Circle(double radius){
        this();
        System.out.println("Paramterized Constructor");
        this.radius=radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
    void display(){
        System.out.println("Radius is: "+radius);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double r=sc.nextDouble();
        Circle c2=new Circle(r);
        c2.display();
    }
}
