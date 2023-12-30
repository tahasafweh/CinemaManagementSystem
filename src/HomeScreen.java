import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import javax.swing.border.EmptyBorder;


public class HomeScreen extends JFrame implements ListSelectionListener{

    JFrame jframe = new JFrame("Home Screen");
    User user;
    private JList<Movie> list;

    public HomeScreen(User user) {
        this.user = user;
    }
    public void run() {
        List<String> showtimes = new ArrayList<>();
        showtimes.add("1");
        Movie movie1 = new Movie(1, "The Godfather", "Drama", showtimes);
        Movie movie2 = new Movie(2, "The Avengers", "Action", showtimes);
        Movie movie3 = new Movie(3, "Chucky", "Horror", showtimes);
        Movie movie4 = new Movie(4, "Se7en", "Drama", showtimes);
        Movie movie5 = new Movie(5, "Leon The Professional", "Action", showtimes);
        List<Movie> movies = new ArrayList<>();
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);

        // Create the "Manage Account" button
        JButton manageAccountButton = new JButton("Manage Account");

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
        });

        // Add the button to the frame

        JLabel title = new JLabel("Please select a movie:");

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        title.setFont(new Font("Arial", Font.BOLD, 40));
        titlePanel.add(title);

        // Add the label to the frame
        jframe.add(titlePanel, BorderLayout.NORTH);
        list = new JList<>(movies.toArray(new Movie[0]));
        list.addListSelectionListener(this);
        list.setFont(new Font("Arial", Font.PLAIN, 25));
        jframe.add(new JScrollPane(list));
        jframe.add(list);
        DefaultListCellRenderer renderer = (DefaultListCellRenderer) list.getCellRenderer();

        // Set the horizontal alignment to center
        renderer.setHorizontalAlignment(JLabel.CENTER);
        list.setBorder(new EmptyBorder(20, 0, 20, 0));

        // Set the size of the frame
        jframe.setSize(700, 350);

        // Make the frame visible
        jframe.setVisible(true);
    }
    @Override
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            Movie selectedItem = list.getSelectedValue();
            Movie movie = new Movie(selectedItem.getMovieId(), selectedItem.getTitle(), selectedItem.getGenre(), selectedItem.getShowtimes());
            System.out.println("You selected: " + selectedItem);
            jframe.dispose();
        }
    }
}
