import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class BookingThread implements Runnable {
    JFrame jframe;
    Ticket ticket;


    public BookingThread(JFrame jframe, Ticket ticket) {
        this.jframe = jframe;
        this.ticket = ticket;
    }

    @Override
    public void run() {
        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream("ticketID.txt"));

            for (int j = 0; j < ticket.seatNum; j++) {
                String alphabet = "ABCDEFGH0123456789";

                StringBuilder sb = new StringBuilder();

                Random random = new Random();

                int length = 5;
                StringBuilder userTicketID = new StringBuilder();

                for (int i = 0; i < length; i++) {
                    int index = random.nextInt(alphabet.length());

                    char randomChar = alphabet.charAt(index);

                    sb.append(randomChar);
                    if (sb.length() == 5) {
                        userTicketID.append(sb);
                        writer.println("ID: " + userTicketID);
                        System.out.println(userTicketID);

                    }


                }


                JOptionPane.showMessageDialog(jframe, "Your ticket's ID is: " + userTicketID);


                jframe.dispose();
            }




            writer.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }





    }
}
