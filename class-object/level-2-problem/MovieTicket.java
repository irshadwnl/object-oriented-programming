

public class MovieTicket {
    String movieName;
    int seatNumber;
    int price;
    boolean isBooked;

    MovieTicket(String movieName,int seatNumber,int price,boolean isBooked){
        this.movieName=movieName;
        this.seatNumber=seatNumber;
        this.price=price;
        this.isBooked=false;
    }

    void bookTicket(){
        if(!isBooked){
            isBooked=true;
            System.out.println("Seat Booked for Movie "+movieName + " Your Seat number: "+seatNumber);  
        }else{
            System.out.println("Seat Already Booked");
        }
    }
    void display(){
        System.out.println("Movie: "+movieName);
        System.out.println("Seat Number: "+seatNumber);
        System.out.println("Price: "+price);
        System.out.println("Booking Status: " + (isBooked ? "Booked" : "Available"));
    }
    public static void main(String[] args) {
        MovieTicket mt=new MovieTicket("Dabangg", 30, 350, false);
        mt.bookTicket();
        mt.display();
    }
}
