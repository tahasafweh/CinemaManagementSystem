import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import javax.swing.border.EmptyBorder;


public class HomeScreen extends JFrame implements ListSelectionListener {

    JFrame jframe = new JFrame("Home Screen");
    User user;
    private JList<Cinema> list;

    public HomeScreen(User user) {
        this.user = user;
    }

    public void run() {
        List<String> showtimes = new ArrayList<>();
        showtimes.add("10:00");
        showtimes.add("12:30");
        showtimes.add("15:00");
        showtimes.add("17:30");
        showtimes.add("20:00");
        List<String> showtimes1 = new ArrayList<>();
        showtimes1.add("10:00");
        showtimes1.add("12:30");
        showtimes1.add("15:00");
        showtimes1.add("17:30");
        showtimes1.add("20:00");
        List<String> showtimes2 = new ArrayList<>();
        showtimes2.add("10:00");
        showtimes2.add("12:30");
        showtimes2.add("15:00");
        showtimes2.add("17:30");
        showtimes2.add("20:00");
        List<String> showtimes3 = new ArrayList<>();
        showtimes3.add("10:00");
        showtimes3.add("12:30");
        showtimes3.add("15:00");
        showtimes3.add("17:30");
        showtimes3.add("20:00");
        List<String> showtimes4 = new ArrayList<>();
        showtimes4.add("10:00");
        showtimes4.add("12:30");
        showtimes4.add("15:00");
        showtimes4.add("17:30");
        showtimes4.add("20:00");

        Movie movie1 = new Movie(1, "The Godfather", "Drama", showtimes);
        Movie movie2 = new Movie(2, "The Avengers", "Action", showtimes1);
        Movie movie3 = new Movie(3, "Chucky", "Horror", showtimes2);
        Movie movie4 = new Movie(4, "Se7en", "Drama", showtimes3);
        Movie movie5 = new Movie(5, "Leon The Professional", "Action", showtimes4);

        try {
            PrintWriter writer = new PrintWriter(new FileOutputStream("movies.txt"));

            // Write movie1 properties to file
            writer.println("ID: " + movie1.getMovieId());
            writer.println("Title: " + movie1.getTitle());
            writer.println("Genre: " + movie1.getGenre());
            writer.println("Showtimes: " + movie1.getShowtimes());

            // Write movie2 properties to file
            writer.println("ID: " + movie2.getMovieId());
            writer.println("Title: " + movie2.getTitle());
            writer.println("Genre: " + movie2.getGenre());
            writer.println("Showtimes: " + movie2.getShowtimes());

            // Write movie3 properties to file
            writer.println("ID: " + movie3.getMovieId());
            writer.println("Title: " + movie3.getTitle());
            writer.println("Genre: " + movie3.getGenre());
            writer.println("Showtimes: " + movie3.getShowtimes());

            // Write movie4 properties to file
            writer.println("ID: " + movie4.getMovieId());
            writer.println("Title: " + movie4.getTitle());
            writer.println("Genre: " + movie4.getGenre());
            writer.println("Showtimes: " + movie4.getShowtimes());

            // Write movie5 properties to file
            writer.println("ID: " + movie5.getMovieId());
            writer.println("Title: " + movie5.getTitle());
            writer.println("Genre: " + movie5.getGenre());
            writer.println("Showtimes: " + movie5.getShowtimes());

            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        Cinema cinema = new Cinema("Hall 1", movie1);
        Cinema cinema1 = new Cinema("Hall 2", movie2);
        Cinema cinema2 = new Cinema("Hall 3", movie3);
        Cinema cinema3 = new Cinema("Hall 4", movie4);
        Cinema cinema4 = new Cinema("Hall 5", movie5);

        List<Cinema> cinemas = new ArrayList<>();
        cinemas.add(cinema);
        cinemas.add(cinema1);
        cinemas.add(cinema2);
        cinemas.add(cinema3);
        cinemas.add(cinema4);




        // Create the "Manage Account" button
        JButton manageAccountButton = new JButton("Manage Account");
        manageAccountButton.setFont(new Font("Arial", Font.BOLD,25));

        // Set bounds for the button (x, y, width, height)
        manageAccountButton.setBounds(50, 50, 200, 30);

        jframe.setLayout(new BorderLayout());
        jframe.add(manageAccountButton, BorderLayout.SOUTH);

        // Attach an ActionListener to the button
        manageAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.dispose();
                ManageAccount manageAccount = new ManageAccount(user);
                manageAccount.run();
            }
        }
        );

        // Add the button to the frame

        JLabel title = new JLabel("Please select a movie:");

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        title.setFont(new Font("Arial", Font.BOLD, 40));
        titlePanel.add(title);

        // Add the label to the frame
        jframe.add(titlePanel, BorderLayout.NORTH);
        list = new JList<>(cinemas.toArray(new Cinema[0]));
        list.addListSelectionListener(this);
        list.setFont(new Font("Arial", Font.PLAIN, 25));
        jframe.add(new JScrollPane(list));
        jframe.add(list);
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();

        // Set the horizontal alignment to center
        renderer.setHorizontalAlignment(JLabel.CENTER);
        list.setBorder(new EmptyBorder(20, 0, 5, 0));

        // Set the size of the frame
        jframe.setSize(700, 350);

        // Make the frame visible
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            Cinema selectedItem = list.getSelectedValue();
            Movie movie = new Movie(selectedItem.movies.getMovieId(), selectedItem.movies.getTitle(), selectedItem.movies.getGenre(), selectedItem.movies.getShowtimes());
            Cinema cinema = new Cinema(selectedItem.hall, movie);
            jframe.dispose();
            MovieScreen moviescreen = new MovieScreen(cinema,user);
            moviescreen.run();
        }
    }
}
