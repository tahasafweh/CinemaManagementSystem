import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class CacnelingThread implements Runnable {
    JFrame jframe;
    Ticket ticket;


    public CacnelingThread(JFrame jframe, Ticket ticket) {
        this.jframe = jframe;
        this.ticket = ticket;
    }

    @Override
    public void run() {
        String userTicketID;
        userTicketID = JOptionPane.showInputDialog(jframe, "Enter your ticket ID: ");


        System.out.println(ticket.ticketID);
        try {
            FileReader freader = new FileReader("ticketID.txt");

            Scanner scanner = new Scanner(freader);
            FileWriter writer = new FileWriter("temp.txt");
            while (scanner.hasNextLine()) {


                String line = scanner.nextLine();


                // compare the line with the ID
                if (line.equals("ID: " + userTicketID)) {
                    System.out.println("helllllo");


                    while (scanner.hasNextLine()) {
                        line = scanner.nextLine();

                        if (!line.equals("ID: " + userTicketID)) {
                            writer.write(line + "\n");
                            System.out.println("helllllo");
                        }
                    }
                    JOptionPane.showMessageDialog(jframe, "This ticket has been cancelled");
                    break;
                } else if (userTicketID.isBlank() ||!line.equals("ID: " + userTicketID)) {
                    JOptionPane.showMessageDialog(jframe, "Ticket does not exist");
                    break;

                }
            }
            scanner.close();
            writer.close();
            File file = new File("ticketID.txt");
            file.delete();


// rename the temporary file to the original file
            File temp = new File("temp.txt");
            temp.renameTo(file);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
