import java.util.*;
// Abstract class Product
abstract class Product {
    private int productId;
    private String name;
    private double price;
    
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    
    public int getProductId() {
        return productId;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
        this.price = price;
    }
    
    public abstract double calculateDiscount();
}

// Interface Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Subclass Electronics implementing Taxable
class Electronics extends Product implements Taxable {
    private double discountRate = 0.10;
    private double taxRate = 0.18;
    
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }
    
    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }
    
    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + (taxRate * 100) + "%";
    }
}

// Subclass Clothing implementing Taxable
class Clothing extends Product implements Taxable {
    private double discountRate = 0.15;
    private double taxRate = 0.05;
    
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }
    
    @Override
    public double calculateTax() {
        return getPrice() * taxRate;
    }
    
    @Override
    public String getTaxDetails() {
        return "Tax Rate: " + (taxRate * 100) + "%";
    }
}

// Subclass Groceries (no tax, different discount)
class Groceries extends Product {
    private double discountRate = 0.05;
    
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * discountRate;
    }
}

// Main class to test polymorphism

public class EcommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        
        products.add(new Electronics(101, "Laptop", 70000));
        products.add(new Clothing(102, "T-Shirt", 1500));
        products.add(new Groceries(103, "Rice", 500));
        
        for (Product product : products) {
            double discount = product.calculateDiscount();
            double tax = (product instanceof Taxable) ? ((Taxable) product).calculateTax() : 0;
            double finalPrice = product.getPrice() + tax - discount;
            
            System.out.println("Product: " + product.getName() + ", Final Price: " + finalPrice);
            if (product instanceof Taxable) {
                System.out.println(((Taxable) product).getTaxDetails());
            }
        }
    }
}
