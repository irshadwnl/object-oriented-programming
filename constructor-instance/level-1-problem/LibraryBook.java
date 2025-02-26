class Boook {

  private String title;
  private String author;
  private double price;
  private boolean availability;

  public Boook(String title, String author, double price, boolean availability) {
    this.title = title;
    this.author = author;
    this.price = price;
    this.availability = availability;
  }

  public String getAuthor() {
    return author;
  }

  public double getPrice() {
    return price;
  }

  public String getTitle() {
    return title;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setAvailability(boolean availability) {
    this.availability = availability;
  }

  void borrowBook() {
    if (availability) {
      System.out.println("Book Borrowed: " + title);
      availability = false;
    } else {
      System.out.println(title + " Book is Not Available");
    }
  }

  void display() {
    System.out.println("------------ Book Details are ----------");
    System.out.println("Name: " + title);
    System.out.println("Author: " + author);
    System.out.println("Price Rs " + price);
  }
}

public class LibraryBook {

  public static void main(String[] args) {
    Boook b1 = new Boook("Rich Dad Poor Dad", "Robert Kiyosak", 255, true);
    Boook b2 = new Boook("The Alchemist", "Paulo Coelho", 350, true);
    b1.borrowBook();
    b1.display();
    b2.borrowBook();
    b2.display();
    b1.borrowBook();
  }
}
