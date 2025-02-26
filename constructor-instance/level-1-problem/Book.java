public class Book {
    private String title;
    private String author;
    private double price;
    Book() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
    }
    Book(String title,String author,double price){
        this.title=title;
        this.author=author;
        this.price=price;
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
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: Rs " + price);
    }
    public static void main(String[] args) {
        Book b1=new Book();
        b1.displayBookInfo();

        Book b2=new Book("Rich Dad Poor Dad","Elon Musk",250.0);
        b2.displayBookInfo();

    }
}
