public class Person {
    String name;
    int id;

    // public Person(String name) { //Variable shadowing
    //     name="Irshad";
    //     id=884;
    //     System.out.println("Default --> Name: "+name+" "+ "Id: "+id);
    // }
    public Person() {
        name="Irshad";
        id=884;
        System.out.println("Default --> Name: "+name+" "+ "Id: "+id);
    }
    Person(Person ref){
        name=ref.name;
        id=ref.id;
        System.out.println("Copy Constructor --> Name: "+name+" "+ "Id: "+id);
    }
    public static void main(String[] args) {
        // Person p1=new Person("NBa");
        Person p1=new Person();
        Person p2=new Person(p1);
        // System.out.println(p1.name); //Variable shadowing
    }
}
