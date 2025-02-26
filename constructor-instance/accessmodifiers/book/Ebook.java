package book;

public class Ebook extends Book{
    private int price;
    Ebook(int isbn, String title, String author,int price) {
            super(isbn,title,author);
            this.price=price;
            //TODO Auto-generated constructor stub
        }
    void displayEbook(){
        System.out.println("Ebook Details are:- ");
        System.out.println("Title: "+title);
        System.out.println("isbn: "+isbn);
        System.out.println("author: "+getAuthor());
        System.out.println("Price: "+price);

    }
}
