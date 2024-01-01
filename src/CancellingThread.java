import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class CancellingThread implements Runnable {
    JFrame jframe;
    Ticket ticket;

    public CancellingThread(JFrame jframe, Ticket ticket) {
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
            boolean ticketExists = false;

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                if (!line.equals("ID: " + userTicketID)) {
                    writer.write(line + "\n");
                } else {
                    ticketExists = true;
                }
            }

            scanner.close();
            writer.close();

            if (ticketExists) {
                JOptionPane.showMessageDialog(jframe, "This ticket has been cancelled");
            } else {
                JOptionPane.showMessageDialog(jframe, "Ticket does not exist");
            }

            File file = new File("ticketID.txt");
            file.delete();

            File temp = new File("temp.txt");
            temp.renameTo(file);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}