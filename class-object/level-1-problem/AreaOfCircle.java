//  ------------ Area Of Circle ------------------

// package AssignMentWeek2Day1;
import java.util.*;
public  class AreaOfCircle {
    public  class Circle {
        int radius;

        Circle(int radius){
            this.radius=radius;
        }
        public double areaOfCircle(){
            double area=Math.PI*radius*radius;
            return area;
        }

        public double circumference(){
            double circ=2*Math.PI*radius;
            return circ;
        }

        public void display(){
            System.out.println("Area of Circle: "+areaOfCircle());
            System.out.println("Circumference of circle: "+circumference());
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int radius=sc.nextInt();
        AreaOfCircle c=new AreaOfCircle();
        Circle c1=c.new Circle(radius);
        c1.display();

    }
}
