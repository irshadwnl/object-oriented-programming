import java.util.*;

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    
    public String getItemName() {
        return itemName;
    }
    
    public double getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }
    
    public abstract double calculateTotalPrice(); // Abstract method
}


interface Discountable {
    void applyDiscount(double percentage);
    String getDiscountDetails();
}


class VegItem extends FoodItem implements Discountable {
    private double discount = 0;
    
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) - discount;
    }
    
    @Override
    public void applyDiscount(double percentage) {
        discount = (getPrice() * getQuantity()) * (percentage / 100);
    }
    
    @Override
    public String getDiscountDetails() {
        return "Discount applied: " + discount;
    }
}


class NonVegItem extends FoodItem implements Discountable {
    private double discount = 0;
    private static final double ADDITIONAL_CHARGE = 10.0;
    
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + (ADDITIONAL_CHARGE * getQuantity()) - discount;
    }
    
    @Override
    public void applyDiscount(double percentage) {
        discount = ((getPrice() * getQuantity()) + (ADDITIONAL_CHARGE * getQuantity())) * (percentage / 100);
    }
    
    @Override
    public String getDiscountDetails() {
        return "Discount applied: " + discount;
    }
}



public class FoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();
        
        VegItem vegBurger = new VegItem("Veg Burger", 50, 2);
        NonVegItem chickenPizza = new NonVegItem("Chicken Pizza", 200, 1);
        
        vegBurger.applyDiscount(10); // Applying 10% discount
        chickenPizza.applyDiscount(5); // Applying 5% discount
        
        order.add(vegBurger);
        order.add(chickenPizza);
        
        double totalOrderCost = 0;
        
        for (FoodItem item : order) {
            item.getItemDetails();
            System.out.println("Total Price: " + item.calculateTotalPrice());
            
            if (item instanceof Discountable) {
                Discountable discountableItem = (Discountable) item;
                System.out.println(discountableItem.getDiscountDetails());
            }
            System.out.println();
            totalOrderCost += item.calculateTotalPrice();
        }
        
        System.out.println("Total Order Cost: " + totalOrderCost);
    }
}
