class Order{
    int orderId;
    String orderDate;
    public Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    public String getOrderStatus(){
        return "Order placed";
    }
}
class ShippedOrder extends Order{
    String trackingNumber;

    public ShippedOrder(int orderId, String orderDate,String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber=trackingNumber;
    }
    @Override
    public String getOrderStatus(){
        return "Order Shipped with tracking number : "+trackingNumber;
    }
}

class DeliveredOrder extends ShippedOrder{
    String deliveryDate;

    public DeliveredOrder(int orderId, String orderDate, String trackingNumber,String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate=deliveryDate;
    }
    @Override
    public String getOrderStatus(){
        return "Order Delivered on : "+deliveryDate;
    }

}
public class OnlineRetail {
    public static void main(String[] args) {
        Order order = new Order(101, "2025-03-09");
        System.out.println(order.getOrderStatus());
        
        ShippedOrder shippedOrder = new ShippedOrder(102, "2025-03-08", "TRK12345");
        System.out.println(shippedOrder.getOrderStatus());
        
        DeliveredOrder deliveredOrder = new DeliveredOrder(103, "2025-03-07", "TRK67890", "2025-03-09");
        System.out.println(deliveredOrder.getOrderStatus());
    }
    
}