import javax.swing.*;
import java.util.Random;

public class BookingTnread implements Runnable{
    JFrame jframe;
    Ticket ticket;


    public BookingTnread(JFrame jframe,Ticket ticket) {
        this.jframe = jframe;
        this.ticket=ticket;
    }

    @Override
    public void run() {

        for (int j=0;j<ticket.seatNum;j++) {String alphabet = "ABCDEFGH0123456789";

            // create random string builder
            StringBuilder sb = new StringBuilder();

            // create an object of Random class
            Random random = new Random();

            // specify length of random string
            int length = 5;

            for (int i = 0; i < length; i++) {
                // generate random index number
                int index = random.nextInt(alphabet.length());

                // get character specified by index
                // from the string
                char randomChar = alphabet.charAt(index);

                // append the character to string builder
                sb.append(randomChar);
            }
            ticket.ticketID = sb.toString();
            JOptionPane.showMessageDialog(jframe, "Your ticket's ID is: " + ticket.ticketID);

            jframe.dispose();
        }                // create a string of all characters
    }
}
