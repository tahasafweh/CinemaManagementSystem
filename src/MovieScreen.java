
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class MovieScreen extends JFrame implements ListSelectionListener {
    JFrame jframe = new JFrame("Movie Screen");
    Movie movie;

    public MovieScreen(Movie movie) {
        this.movie = movie;
    }

    public void run() {
        Container contentPane = jframe.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        JLabel title = new JLabel("Select a time: ");
        JLabel hall = new JLabel("Displaying in hall: ");
        JLabel seats = new JLabel("Select your seat number: ");
        JButton book = new JButton("Book");
        JButton cancel = new JButton("Cancel booking");
        JLabel timeLabel = new JLabel(movie.toString());

        jframe.setSize(600, 300);
        jframe.setVisible(true);
        List<String> showtimes = movie.getShowtimes();
        JList<String> list = new JList<>(showtimes.toArray(new String[0]));
        list.addListSelectionListener(this);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 17));
        jframe.add(book);
        jframe.add(cancel);
        jframe.add(timeLabel);
        jframe.add(list);
        jframe.add(title);
        jframe.add(hall);
        jframe.add(seats);

        layout.putConstraint(SpringLayout.WEST, timeLabel,
                210, SpringLayout.WEST, contentPane);


        layout.putConstraint(SpringLayout.WEST, title,
                20, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, title,
                60, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, list,
                22, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.EAST, list,
                -500, SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, list,
                90, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, hall,
                220, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.EAST, hall,
                100, SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, hall,
                60, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, seats,
                350, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.EAST, seats,
                100, SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, seats,
                60, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, book,
                350, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.EAST, book,
                -150, SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, book,
                200, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, cancel,
                450, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.EAST, cancel,
                -100, SpringLayout.EAST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, cancel,
                200, SpringLayout.NORTH, contentPane);


        book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ticketing ticketing = new Ticketing();
                ticketing.run();
            }
        }
        );
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ticketing ticketing = new Ticketing();
                ticketing.cancelBooking();
            }
        }
        );



        // Add the list to the frame
//
//        groupLayout.setHorizontalGroup(groupLayout.createSequentialGroup()
//                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(timeLabel).addComponent(title).addComponent(list))
//                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)).addComponent(genra));
//
//        groupLayout.setVerticalGroup(groupLayout.createSequentialGroup()
//                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER).addComponent(timeLabel))
//                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(title)
//                        .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(list).addComponent(genra))));
//        addGroup(groupLayout.createParallelGroup(LEADING).addComponent(b1))
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
