
// Program to Handle Mobile Phone Details

class MobilePhone {
    private String brand;
    private String model;
    private int price;

    public MobilePhone(String brand, String model, int price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public void displayPhoneDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        MobilePhone phone1 = new MobilePhone("Apple", "iPhone 14", 120000);
        MobilePhone phone2 = new MobilePhone("Samsung", "Galaxy S23", 85000);
        phone1.displayPhoneDetails();
        System.out.println("----------------");
        phone2.displayPhoneDetails();
    }
}
