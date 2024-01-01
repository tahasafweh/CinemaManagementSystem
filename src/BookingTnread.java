import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class BookingTnread implements Runnable {
    JFrame jframe;
    Ticket ticket;


    public BookingTnread(JFrame jframe, Ticket ticket) {
        this.jframe = jframe;
        this.ticket = ticket;
    }

    @Override
    public void run() {
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream("ticketID.txt"));

            for (int j = 0; j < ticket.seatNum; j++) {
                String alphabet = "ABCDEFGH0123456789";

                // create random string builder
                StringBuilder sb = new StringBuilder();

                // create an object of Random class
                Random random = new Random();

                // specify length of random string
                int length = 5;
                StringBuilder userTicketID = new StringBuilder();

                for (int i = 0; i < length; i++) {
                    // generate random index number
                    int index = random.nextInt(alphabet.length());

                    // get character specified by index
                    // from the string
                    char randomChar = alphabet.charAt(index);

                    // append the character to string builder
                    sb.append(randomChar);
                    if (sb.length() == 5) {
                        userTicketID.append(sb);
                        writer.println("ID: " + userTicketID);
                        System.out.println(userTicketID);

                    }


                }


                JOptionPane.showMessageDialog(jframe, "Your ticket's ID is: " + userTicketID);


                jframe.dispose();
            }                // create a string of all characters




            writer.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }





    }
}
