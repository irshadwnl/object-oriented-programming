import java.util.ArrayList;

public class Library {

  private final String libraryName;
  private ArrayList<Book> books;

  Library(String libraryName) {
    this.libraryName = libraryName;
    this.books = new ArrayList<>();
  }

  void addBook(Book book) {
    books.add(book);
  }

  public void displayBooks() {
    System.out.println("Library: " + libraryName);
    for (Book book : books) {
      System.out.println(book);
    }
  }

  public void deleteBook(String title) {
    for (Book book : books) {
      if (book.getTitle().equalsIgnoreCase(title)) {
        books.remove(book);
        System.out.println("Book Deleted successfully: " + book);
        return;
      }
    }
    System.out.println(title + " is not available in the library.");
  }

  public static void main(String[] args) {
    Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
    Book book2 = new Book("1984", "George Orwell");
    Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");

    Library library1 = new Library("City Library");
    Library library2 = new Library("Chitkara Library");

    library1.addBook(book1);
    library1.addBook(book2);

    library2.addBook(book3);
    library2.addBook(book1);

    library1.deleteBook("1984");
    library1.displayBooks();
    System.out.println();
    library2.displayBooks();
  }
}

class Book {

  private String title;
  private String author;

  Book(String title, String author) {
    this.title = title;
    this.author = author;
  }

  public String getAuthor() {
    return author;
  }

  public String getTitle() {
    return title;
  }

  @Override
  public String toString() {
    return "Book{title='" + title + "', author='" + author + "'}";
  }
}
