class Vehicle{
    int maxSpeed;
    String fuelType;
    
    Vehicle(int maxSpeed,String fuelType){
        this.maxSpeed=maxSpeed;
        this.fuelType=fuelType;
    }
    void displayInfo(){
        System.out.println("Max Speed: "+maxSpeed);
        System.out.println("Fuel Type: "+fuelType);
    }
}
class Car extends Vehicle{
    String seatType;
    Car(int maxSpeed, String fuelType,String seatType) {
            super(maxSpeed, fuelType);
            this.seatType=seatType;
        }
    void displayInfo(){
        System.out.println("Car Details are: ");
        super.displayInfo();
        System.out.println("Seat type: "+seatType);

    }
    
}
class Truck extends Vehicle{
    String seatType;
    public Truck(int maxSpeed, String fuelType,String seatType) {
        super(maxSpeed, fuelType);
        this.seatType=seatType;
    }
    void displayInfo(){
        System.out.println("Truck Details are: ");
        super.displayInfo();
        System.out.println("Seat type: "+seatType);

    }
    
}

class MotorBike extends Vehicle{
    String seatType;
    public MotorBike(int maxSpeed, String fuelType,String seatType) {
        super(maxSpeed, fuelType);
        this.seatType=seatType;
    }
    void displayInfo(){
        System.out.println("MotorBike Details are: ");
        super.displayInfo();
        System.out.println("Seat type: "+seatType);

    }
    
} 

public class VehicleHierarchy {
    public static void main(String[] args) {
        Vehicle vehicle[]=new Vehicle[]{
            new Car(120, "Petrol","4 seater"),
            new Truck(100, "Diesel", "6 Seater"),
            new MotorBike(140, "petrol", "2 seater"),
        };
        for(Vehicle v:vehicle){
            v.displayInfo();
            System.out.println();
        }
    }
}
