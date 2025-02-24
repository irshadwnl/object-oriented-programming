
//---------- Program to Display Employee Details -------


public class Employee {
    String name;
    int id;
    int salary;
    void Display(){
        System.out.println("Name is: "+name);
        System.out.println("Id is: "+id);
        System.out.println("Salary is: "+salary);
    }
    public static void main(String[] args) {
        Employee e1=new Employee();
        e1.name="Irshad";
        e1.id=123;
        e1.salary=550000;
        e1.Display();
    }
}
