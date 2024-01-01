import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ticketing extends JFrame {
    JFrame jframe = new JFrame("Book a ticket");
    Cinema cinema;
    Ticket ticket;

    public Ticketing(Cinema cinema,Ticket ticket) {
        this.cinema = cinema;
        this.ticket=ticket;
    }

    public void run() {

        jframe.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        JLabel time = new JLabel("Selected time:");
        time.setFont(new Font("Arial", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 0;
        jframe.add(time, gbc);


        JLabel selectedTime = new JLabel(cinema.movies.getShowtimes().get(0));
        selectedTime.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridy = 1;
        jframe.add(selectedTime, gbc);

        JLabel hall = new JLabel("Hall:");
        hall.setFont(new Font("Arial", Font.BOLD, 25));
        gbc.gridy = 2;
        jframe.add(hall, gbc);

        JLabel hallName = new JLabel(cinema.hall);
        hallName.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridy = 3;
        jframe.add(hallName, gbc);

        JLabel seat = new JLabel("Selected seat:");
        seat.setFont(new Font("Arial", Font.BOLD, 25));
        gbc.gridy = 4;
        jframe.add(seat, gbc);

        JLabel selectedSeat = new JLabel(String.valueOf(ticket.seatNum));
        selectedSeat.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridy = 5;
        jframe.add(selectedSeat, gbc);

        JLabel ticketPrice = new JLabel("Ticket price:");
        ticketPrice.setFont(new Font("Arial", Font.BOLD, 25));
        gbc.gridy = 6;
        jframe.add(ticketPrice, gbc);

        JLabel price = new JLabel("$"+ticket.seatNum*5.50);
        price.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridy = 7;
        jframe.add(price, gbc);

        JButton book = new JButton("Book");
        book.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridy = 8;
        jframe.add(book, gbc);


        book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookingThread book=new BookingThread(jframe,ticket);
                Thread th2=new Thread(book);
                th2.start();

            }
        });

        JButton cancel = new JButton("Cancel");
        cancel.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridy = 9;
        jframe.add(cancel, gbc);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.dispose();
            }
        });


        jframe.setSize(300, 500);
        jframe.pack();
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void cancelBooking() {
        CancellingThread cancel=new CancellingThread(jframe,ticket);
        Thread th1=new Thread(cancel);
        th1.start();

    }
}
