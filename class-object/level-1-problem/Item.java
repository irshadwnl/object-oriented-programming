
// Program to Track Inventory of Items

class Item {
    private int itemCode;
    private String itemName;
    private int price;

    Item(int itemCode, String itemName, int price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    public void display() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: $" + price);
    }

    public int quantityTrack(int quantity) {
        return price * quantity;
    }

    public static void main(String[] args) {
        Item i = new Item(101, "Laptop", 70000);
        i.display();
        int quantity = 3;
        int total = i.quantityTrack(quantity);
        System.out.println("Total Cost for " + quantity + "quantity Rs:" + total);
    }
}
