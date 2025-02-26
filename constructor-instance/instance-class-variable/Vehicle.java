class Vehicle {
    private static int registrationFee = 5000; 
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: " + registrationFee);
    }

    public static void updateRegistrationFee(int newFee) {
        registrationFee = newFee;
    }

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Irshad", "Car");
        v1.displayVehicleDetails();
        Vehicle.updateRegistrationFee(6000);
        Vehicle v2 = new Vehicle("Saif", "Bike");
        v2.displayVehicleDetails();
    }
}
