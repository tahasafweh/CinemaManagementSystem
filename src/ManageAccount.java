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
        username.setFont(new Font("Arial", Font.BOLD, 25));
        gbc.gridx = 0;
        gbc.gridy = 0;
        jframe.add(username, gbc);
        JLabel usernameField = new JLabel(user.getUsername());
        usernameField.setFont(new Font("Arial", Font.PLAIN, 20));
        gbc.gridy = 1;
        jframe.add(usernameField, gbc);
        JLabel accountDetails = new JLabel("Account Details");
        accountDetails.setFont(new Font("Arial", Font.BOLD, 25));
        gbc.gridy = 2;
        jframe.add(accountDetails,gbc);
        JLabel accountDetailsField = new JLabel(user.getAccountDetails());
        accountDetailsField.setFont(new Font("Arial", Font.PLAIN, 20));
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

        JButton back = new JButton("Back");
        back.setFont(new Font("Arial", Font.BOLD, 14));
        gbc.gridy = 5;
        jframe.add(back, gbc);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframe.dispose();
                HomeScreen homeScreen = new HomeScreen(user);
                homeScreen.run();
            }
        });
        // Add the button to the frame

        jframe.setSize(500,400);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
