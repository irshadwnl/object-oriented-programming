import java.util.*;

abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }
    
    public String getVehicleId() {
        return vehicleId;
    }
    
    public String getDriverName() {
        return driverName;
    }
    
    public double getRatePerKm() {
        return ratePerKm;
    }
    
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm);
    }
    
    public abstract double calculateFare(double distance); // Abstract method
}


interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}


class Car extends Vehicle implements GPS {
    private String currentLocation;
    
    public Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }
    
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }
    
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}


class Bike extends Vehicle implements GPS {
    private String currentLocation;
    
    public Bike(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }
    
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.9; // 10% discount for bikes
    }
    
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}


class Auto extends Vehicle implements GPS {
    private String currentLocation;
    
    public Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }
    
    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 1.1; // 10% extra charge for autos
    }
    
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }
    
    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}



public class RideHailingApp {
    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();
        
        Car carRide = new Car("C001", "John Doe", 15, "Downtown");
        Bike bikeRide = new Bike("B001", "Jane Smith", 10, "Uptown");
        Auto autoRide = new Auto("A001", "Mike Johnson", 12, "City Center");
        
        rides.add(carRide);
        rides.add(bikeRide);
        rides.add(autoRide);
        
        double distance = 10.0; // Example distance
        
        for (Vehicle ride : rides) {
            ride.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: " + ride.calculateFare(distance));
            
            if (ride instanceof GPS) {
                GPS gpsEnabledVehicle = (GPS) ride;
                System.out.println("Current Location: " + gpsEnabledVehicle.getCurrentLocation());
            }
            System.out.println();
        }
    }
}
