abstract class Animal {
    String name;
    int age;

    Animal(String name,int age){
        this.name=name;
        this.age=age;
    }
    public abstract void makeSound();
}
class Dog extends Animal{
    
    Dog(String name, int age) {
            super(name, age);
        }
        @Override
        public void makeSound(){
        System.out.println("bark");
    }
} 

class Cat extends Animal{

    public Cat(String name, int age) {
        super(name, age);
    }
    @Override
    public void makeSound(){
        System.out.println("meow");
    }
} 
class Bird extends Animal{

    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound(){
        System.out.println("chirp");
    }
} 
public class AnimalHierarchy{
    public static void main(String[] args) {
        Animal dog=new Dog("bulldog", 5);
        Animal cat=new Cat("pookie", 2);
        Animal bird=new Bird("pikku", 1);
        dog.makeSound();
        cat.makeSound();
        bird.makeSound();
    }
}


