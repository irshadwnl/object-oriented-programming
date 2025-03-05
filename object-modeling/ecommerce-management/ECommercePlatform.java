import java.util.ArrayList;
import java.util.List;

// Product Class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

// Order Class (Aggregation with Products)
class Order {
    private static int orderCounter = 1; // Unique order ID counter
    private int orderId;
    private List<Product> products;
    private Customer customer;

    public Order(Customer customer) {
        this.orderId = orderCounter++;
        this.products = new ArrayList<>();
        this.customer = customer;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId + " | Customer: " + customer.getName());
        System.out.println("Products in Order:");
        for (Product p : products) {
            System.out.println("- " + p.getName() + " ($" + p.getPrice() + ")");
        }
        System.out.println("Total Price: $" + calculateTotal());
    }
}

// Customer Class (Association with Orders)
class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
    }

    public void showOrders() {
        System.out.println("Orders placed by " + name + ":");
        for (Order o : orders) {
            o.showOrderDetails();
            System.out.println("----------------------------");
        }
    }
}

// Main Class
public class ECommercePlatform {
    public static void main(String[] args) {
        // Creating Products
        Product laptop = new Product("Laptop", 1200);
        Product phone = new Product("Smartphone", 800);
        Product headphones = new Product("Headphones", 150);

        // Creating Customer
        Customer john = new Customer("John Doe");

        // Creating and Placing Order 1
        Order order1 = new Order(john);
        order1.addProduct(laptop);
        order1.addProduct(phone);
        john.placeOrder(order1);

        // Creating and Placing Order 2
        Order order2 = new Order(john);
        order2.addProduct(headphones);
        john.placeOrder(order2);

        // Display Orders
        john.showOrders();
    }
}
