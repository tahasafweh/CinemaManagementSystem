import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageAccount extends JFrame{
    JFrame jframe = new JFrame("Manage Account");
    User user;
    public ManageAccount(User user) {
        this.user = user;
    }
    public void run() {
        jframe.setLayout(new GridLayout(3, 2));
        JLabel username = new JLabel("Username");
        jframe.add(username);
        JLabel usernameField = new JLabel(user.getUsername());
        jframe.add(usernameField);
        JLabel accountDetails = new JLabel("Account Details");
        jframe.add(accountDetails);
        JLabel accountDetailsField = new JLabel(user.getAccountDetails());
        jframe.add(accountDetailsField);

        JButton edit = new JButton("Edit");

        // Set bounds for the button (x, y, width, height)
        edit.setBounds(50, 50, 200, 30);

        jframe.add(edit);

        // Attach an ActionListener to the button
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.dispose();
                ManageAccount manageAccount = new ManageAccount(user);
                manageAccount.run();
            }
        });

        // Add the button to the frame

        JLabel title = new JLabel("Please select a movie:");

        jframe.setSize(500,500);
        jframe.setVisible(true);
    }

}
