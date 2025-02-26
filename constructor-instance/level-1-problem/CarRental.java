public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;

    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    } 

    int calculateCost(){
        return rentalDays*1000;
    }

    public void display() {
        System.out.println("---------- Car Rental Details ----------");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: Rs " + calculateCost());
    }
    public static void main(String[] args) {
        CarRental c1=new CarRental("Irshad", "Maruti Ertiga", 7);
        CarRental c2=new CarRental("Sam", "Mahindra Scorpio", 15);
        
        c1.display();
        c2.display();
    }
}
