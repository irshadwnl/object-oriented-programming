import java.util.*;
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    
    public String getVehicleNumber() {
        return vehicleNumber;
    }
    
    public String getType() {
        return type;
    }
    
    public double getRentalRate() {
        return rentalRate;
    }
    
    public abstract double calculateRentalCost(int days);
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private double insuranceRate = 0.02; // 2% of rental cost
    
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    
    @Override
    public double calculateInsurance() {
        return calculateRentalCost(1) * insuranceRate;
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Car insurance rate: " + (insuranceRate * 100) + "% of rental cost";
    }
}

class Bike extends Vehicle implements Insurable {
    private double insuranceRate = 0.01; // 1% of rental cost
    
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    
    @Override
    public double calculateInsurance() {
        return calculateRentalCost(1) * insuranceRate;
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Bike insurance rate: " + (insuranceRate * 100) + "% of rental cost";
    }
}

class Truck extends Vehicle implements Insurable {
    private double insuranceRate = 0.05; // 5% of rental cost
    
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    
    @Override
    public double calculateInsurance() {
        return calculateRentalCost(1) * insuranceRate;
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Truck insurance rate: " + (insuranceRate * 100) + "% of rental cost";
    }
}


public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        
        vehicles.add(new Car("C123", 2000));
        vehicles.add(new Bike("B456", 500));
        vehicles.add(new Truck("T789", 5000));
        
        int rentalDays = 5;
        
        for (Vehicle vehicle : vehicles) {
            double rentalCost = vehicle.calculateRentalCost(rentalDays);
            System.out.println("Vehicle: " + vehicle.getType() + " (" + vehicle.getVehicleNumber() + ")");
            System.out.println("Rental Cost for " + rentalDays + " days: " + rentalCost);
            
            if (vehicle instanceof Insurable) {
                System.out.println(((Insurable) vehicle).getInsuranceDetails());
                System.out.println("Insurance Cost: " + ((Insurable) vehicle).calculateInsurance());
            }
            System.out.println();
        }
    }
}
