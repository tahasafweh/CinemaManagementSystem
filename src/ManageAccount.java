import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManageAccount extends JFrame{
    JFrame jframe = new JFrame("Manage Account");
    User user;
    String newUserName;
    String newAccountDetails;
    public ManageAccount(User user) {
        this.user = user;
    }
    public void run() {
        jframe.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // padding
        JLabel username = new JLabel("Username");
        gbc.gridx = 0;
        gbc.gridy = 0;
        jframe.add(username, gbc);
        JLabel usernameField = new JLabel(user.getUsername());
        gbc.gridy = 1;
        jframe.add(usernameField, gbc);
        JLabel accountDetails = new JLabel("Account Details");
        gbc.gridy = 2;
        jframe.add(accountDetails,gbc);
        JLabel accountDetailsField = new JLabel(user.getAccountDetails());
        gbc.gridy = 3;
        jframe.add(accountDetailsField, gbc);

        JButton edit = new JButton("Edit");
        edit.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridy = 4;

        jframe.add(edit, gbc);

        // Attach an ActionListener to the button
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newUserName = JOptionPane.showInputDialog(jframe, "Enter your new username: ");
                newAccountDetails = JOptionPane.showInputDialog(jframe, "Enter your new account details: ");
                user = new User(newUserName, newAccountDetails);
                jframe.dispose();
                HomeScreen home = new HomeScreen(user);
                home.run();
            }
        });

        // Add the button to the frame

        jframe.setSize(500,250);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
