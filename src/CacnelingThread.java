import javax.swing.*;

public class CacnelingThread implements Runnable{
    JFrame jframe;
    Ticket ticket;


    public CacnelingThread(JFrame jframe,Ticket ticket) {
        this.jframe = jframe;
        this.ticket=ticket;
    }

    @Override
    public void run() {
        System.out.println(ticket.ticketID);
        String userTicketID;
        userTicketID = JOptionPane.showInputDialog(jframe, "Enter your ticket ID: ");
        if (userTicketID.isBlank() || !userTicketID.equals(ticket.ticketID)) {
            JOptionPane.showMessageDialog(jframe, "Ticket does not exist");
        } else {
            JOptionPane.showMessageDialog(jframe, "Booking cancelled");
        }
    }
}
