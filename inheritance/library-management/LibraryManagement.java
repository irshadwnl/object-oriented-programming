class Book{
    String title;
    int publicationYear;

    public Book(int publicationYear, String title) {
        this.publicationYear = publicationYear;
        this.title = title;
    }

    public void displayInfo(){
        System.out.println("----------- Book Details are -----------");
        System.out.println("Book Name: "+title);
        System.out.println("Publication Year: "+publicationYear);
    }
}

class Author extends Book{
    String name;
    String bio;

    public Author(int publicationYear, String title,String name,String bio) {
        super(publicationYear, title);
        this.name=name;
        this.bio=bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo(); 
        System.out.println("Author: " + name);
        System.out.println("Bio: " + bio);
    }
}
public class LibraryManagement {
    public static void main(String[] args) {
        Author a=new Author(2020, "Java Basic", "Sam", "Basic of java");
        a.displayInfo();
    }
}
