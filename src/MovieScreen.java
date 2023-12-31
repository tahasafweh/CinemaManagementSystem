
import javax.swing.JOptionPane;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class MovieScreen extends JFrame implements ListSelectionListener {
    JFrame jframe = new JFrame("Movie Screen");
    Movie movie;
    int value;
    Cinema cinema;
    Ticket ticket;
    User user;

    public MovieScreen(Cinema cinema, User user) {
        this.cinema = cinema;
        this.user = user;
    }

    public void run() {
        Container contentPane = jframe.getContentPane();
        SpringLayout layout = new SpringLayout();
        contentPane.setLayout(layout);

        JLabel title = new JLabel("Select a time: ");
        JLabel hall = new JLabel("Displaying in: ");
        JLabel hallid = new JLabel(cinema.hall);
        JLabel seats = new JLabel("Select how many seats you want: ");
        JButton book = new JButton("Book");
        JButton cancel = new JButton("Cancel booking");
        JLabel moviename = new JLabel(cinema.movies.toString());
        JButton back = new JButton("Back");
        SpinnerModel value = new SpinnerNumberModel(1, 1, 20, 1);
        JSpinner spinner = new JSpinner(value);
        back.setFont(new Font("Arial", Font.BOLD, 14));
        book.setFont(new Font("Arial", Font.BOLD, 14));
        cancel.setFont(new Font("Arial", Font.BOLD, 14));
        title.setFont(new Font("Arial", Font.BOLD, 13));
        seats.setFont(new Font("Arial", Font.BOLD, 13));
        hall.setFont(new Font("Arial", Font.BOLD, 13));
        hallid.setFont(new Font("Arial", Font.BOLD, 13));
        book.setSize(100, 50);
        cancel.setSize(100, 50);
        book.setBounds(100, 100, 100, 100);
        jframe.setSize(600, 300);
        jframe.setVisible(true);
        List<String> showtimes = cinema.movies.getShowtimes();
        JList<String> list = new JList<>(showtimes.toArray(new String[0]));
        list.addListSelectionListener(this);
        moviename.setFont(new Font("Arial", Font.BOLD, 17));
        jframe.add(book);
        jframe.add(cancel);
        jframe.add(moviename);
        jframe.add(list);
        jframe.add(title);
        jframe.add(hall);
        jframe.add(seats);
        jframe.add(hallid);
        jframe.add(back);
        jframe.add(spinner);


        layout.putConstraint(SpringLayout.WEST, moviename,
                210, SpringLayout.WEST, contentPane);


        layout.putConstraint(SpringLayout.WEST, title,
                20, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, title,
                60, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, list,
                22, SpringLayout.WEST, contentPane);

        layout.putConstraint(SpringLayout.NORTH, list,
                90, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, hall,
                200, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, hall,
                60, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, hallid,
                220, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, hallid,
                90, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, seats,
                370, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, seats,
                60, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, spinner,
                430, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, spinner,
                90, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, book,
                370, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, book,
                200, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, cancel,
                430, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, cancel,
                200, SpringLayout.NORTH, contentPane);

        layout.putConstraint(SpringLayout.WEST, back,
                22, SpringLayout.WEST, contentPane);
        layout.putConstraint(SpringLayout.NORTH, back,
                200, SpringLayout.NORTH, contentPane);



        spinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {




            }
        });


        book.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int v = (int)spinner.getValue();
                String selectedItem = list.getSelectedValue();
                if (selectedItem == null) {
                    JOptionPane.showMessageDialog(null, "Please select a time.");
                } else {
                    List<String> showt = new ArrayList<>();
                    showt.add(selectedItem);
                    cinema.movies.setShowtimes(showt);
                    Ticket ticket1=new Ticket(v,selectedItem,v*5.50,cinema.hall,"");
                    Movie moviet = new Movie(cinema.movies.getMovieId(), cinema.movies.getTitle(), cinema.movies.getGenre(), cinema.movies.getShowtimes());
                    Cinema cinemat = new Cinema(cinema.hall, moviet);
                    Ticketing ticketing = new Ticketing(cinemat,ticket1);
                    ticketing.run();
                }
            }
        }
        );
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int v = (int)spinner.getValue();
                String selectedItem = list.getSelectedValue();
                Ticket ticket1=new Ticket(v,selectedItem,v*5.50,cinema.hall,"");
                Ticketing ticketing = new Ticketing(cinema,ticket1);
                ticketing.cancelBooking();
            }
        }
        );
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.dispose();
                HomeScreen homeScreen = new HomeScreen(user);
                homeScreen.run();
            }
        });
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Add the list to the frame
//
//
    }


    @Override
    public void valueChanged(ListSelectionEvent e) {

    }
}
