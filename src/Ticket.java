public class Ticket {
    int seatNum;
    String showtime;
    double ticketPrice;
    String hall;
    String ticketID;

    public Ticket(int seatNum, String showtime, double ticketPrice, String hall,String ticketID) {
        this.seatNum = seatNum;
        this.showtime = showtime;
        this.ticketPrice = ticketPrice;
        this.hall = hall;
        this.ticketID = ticketID;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public String getShowtime() {
        return showtime;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
    public String getHall(){
        return hall;
    }

    public String getTicketID() {
        return ticketID;
    }
}
