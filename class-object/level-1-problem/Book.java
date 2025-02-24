
// ---------- Program to Handle Book Details ---------

import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private int price;

    Book(String title,String author, int price){
        this.title=title;
        this.author=author;
        this.price=price;
    }

    public void display(){
        if(price>0){
            System.out.println("Book Title: "+this.title);
            System.out.println("Book Author: "+this.author);
            System.out.println("Book Price: "+this.price);
        }else{
            System.out.println("Invalid Price");
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Book Title: ");
        String title=sc.nextLine();
        System.out.println("Enter Book Author: ");
        String author=sc.nextLine();
        System.out.println("Enter Book Price: ");
        int price=sc.nextInt();
        Book b=new Book(title, author, price);
        b.display();
    }
}
