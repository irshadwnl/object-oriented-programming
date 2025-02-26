public class Product{
    String productName;
    int price;
    static int totalProducts=0;

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;
    }
    
    void displayProductDetails(){
        System.out.println("Product Details are:- ");
        System.out.println("Product Name: "+productName);
        System.out.println("Price: "+price);
    }
    static void displayTotalProducts(){
        System.out.println("Total Products: "+totalProducts);
    }
    public static void main(String[] args) {
        Product p1=new Product("Mobile", 19000);
        Product p2=new Product("Laptop",40000);

        p1.displayProductDetails();
        p2.displayProductDetails();
        Product.displayTotalProducts();
    }
}