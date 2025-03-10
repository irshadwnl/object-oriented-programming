import java.util.*;
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }
    
    public String getItemId() {
        return itemId;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
    
    public abstract int getLoanDuration(); // Abstract method
}


interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}


class Book extends LibraryItem implements Reservable {
    private boolean isAvailable = true;
    
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    @Override
    public int getLoanDuration() {
        return 14; // Books can be borrowed for 14 days
    }
    
    @Override
    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Book reserved successfully.");
        } else {
            System.out.println("Book is already reserved.");
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}


class Magazine extends LibraryItem implements Reservable {
    private boolean isAvailable = true;
    
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    @Override
    public int getLoanDuration() {
        return 7; // Magazines can be borrowed for 7 days
    }
    
    @Override
    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Magazine reserved successfully.");
        } else {
            System.out.println("Magazine is already reserved.");
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}


class DVD extends LibraryItem implements Reservable {
    private boolean isAvailable = true;
    
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    @Override
    public int getLoanDuration() {
        return 5; // DVDs can be borrowed for 5 days
    }
    
    @Override
    public void reserveItem() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("DVD reserved successfully.");
        } else {
            System.out.println("DVD is already reserved.");
        }
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable;
    }
}



public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        
        items.add(new Book("B001", "The Java Handbook", "John Doe"));
        items.add(new Magazine("M001", "Tech Monthly", "Jane Smith"));
        items.add(new DVD("D001", "Java Programming Basics", "Alice Brown"));
        
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                System.out.println("Availability: " + (reservableItem.checkAvailability() ? "Available" : "Not Available"));
                reservableItem.reserveItem();
            }
            System.out.println();
        }
    }
}
