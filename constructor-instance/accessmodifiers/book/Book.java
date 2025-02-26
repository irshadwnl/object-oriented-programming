package book;

public class Book {
    public int isbn;
    protected  String title;
    private String author;

    
    Book(int isbn,String title,String author){
        this.isbn=isbn;
        this.title=title;
        this.author=author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }
        void displayBook(){
            System.out.println("Book Details are:- ");
            System.out.println("Title: "+title);
            System.out.println("ISBN: "+isbn);
            System.out.println("Auhtor: "+author);
        }
    public static void main(String[] args) {
        Book b1=new Book(30, "Mota Bhai", "Mohit");
        b1.displayBook();
        // Ebook e1=new Ebook(20, "The Alchemist", "Irshad",400);
        // e1.displayEbook();
    }
}
