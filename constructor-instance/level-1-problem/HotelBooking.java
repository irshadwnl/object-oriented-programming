public class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;

    HotelBooking(){
        guestName="Unknown";
        roomType="Normal";
        nights=1;
    }

    HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
    HotelBooking(HotelBooking ref){
        guestName=ref.guestName;
        roomType=ref.roomType;
        nights=ref.nights;
    }

    void display(){
        System.out.println("Your Booking Details are :-");
        System.out.println("Name: "+guestName);
        System.out.println("Room Type: "+roomType);
        System.out.println("No of Night Stay: "+nights);
    }
    public static void main(String[] args) {
        HotelBooking h1=new HotelBooking();
        System.out.println("Default Booking:-");
        h1.display();
        HotelBooking h3=new HotelBooking("Irshad", "Deluxe", 1);
        System.out.println("\nParameterized Booking:-");
        h3.display();
        HotelBooking h2=new HotelBooking(h1);
        System.out.println("\nCopied Booking:-");
        h2.display();
    }
}
