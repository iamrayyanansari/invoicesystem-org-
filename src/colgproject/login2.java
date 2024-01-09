//THIS BILL IS NOT CORRECT 

package colgproject;
import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class login2 implements ActionListener {
    static JTextField textField1;
    static JPasswordField passwordField1;
    static JLabel success;
    static JFrame frame;
    static JPanel panel;
    static Connection connection;

    public static void main(String[] args) {
        frame = new JFrame();
        panel = new JPanel();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);
        JLabel label1 = new JLabel("User-Name");
        label1.setBounds(20, 25, 80, 25);
        panel.add(label1);
        textField1 = new JTextField();
        textField1.setBounds(100, 23, 100, 20);
        panel.add(textField1);

        JLabel label2 = new JLabel("Password");
        label2.setBounds(20, 50, 80, 25);
        panel.add(label2);
        passwordField1 = new JPasswordField();
        passwordField1.setBounds(100, 50, 100, 20);
        panel.add(passwordField1);

        JButton button1 = new JButton("New-register");
        button1.setBounds(15, 80, 100, 20);
        panel.add(button1);
        button1.addActionListener(new login2());

        JButton login21 = new JButton("login");
        login21.addActionListener(new login2());
        login21.setBounds(120, 80, 80, 20);
        panel.add(login21);

        success = new JLabel("");
        success.setBounds(20, 100, 200, 25);
        panel.add(success);

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
                    "rayyan");
            Statement st = connection.createStatement();

            st.execute("CREATE TABLE IF NOT EXISTS users (email VARCHAR(255) PRIMARY KEY, password VARCHAR(255))");
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
        if (sourceButton.getText().equals("login")) {
            // Handle login button action
            String user = textField1.getText();
            String pass = passwordField1.getText();

            if (authenticateUser(user, pass)) {
                success.setText("Login successfully");
                System.out.println("Login successfully");
                success.setForeground(Color.GREEN);
            } else {
                success.setText("Invalid Username or Password");
                success.setForeground(Color.RED);
            }
        } else if (sourceButton.getText().equals("New-register")) {
            // Handle new register button action
            panel.removeAll(); // Remove all components from the panel
            panel.repaint(); // Repaint the panel to reflect the changes

            JLabel emailLabel = new JLabel("Email:");
            emailLabel.setBounds(20, 25, 80, 25);
            panel.add(emailLabel);

            JTextField emailField = new JTextField();
            emailField.setBounds(100, 23, 100, 20);
            panel.add(emailField);

            JLabel passwordLabel = new JLabel("Password:");
            passwordLabel.setBounds(20, 50, 80, 25);
            panel.add(passwordLabel);

            JPasswordField passwordField = new JPasswordField();
            passwordField.setBounds(100, 50, 100, 20);
            panel.add(passwordField);

            JButton registerButton = new JButton("Register");
            registerButton.setBounds(100, 80, 80, 20);
            panel.add(registerButton);
            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String email = emailField.getText();
                    String password = new String(passwordField.getPassword());

                    if (registerUser(email, password)) {
                        success.setText("Registration successful!");
                        success.setForeground(Color.GREEN);
                    } else {
                        success.setText("Email already exists!");
                        success.setForeground(Color.RED);
                    }
                }
            });

            frame.revalidate(); // Revalidate the frame to update the layout
            frame.repaint(); // Repaint the frame to reflect the changes
        }
    }

    private boolean authenticateUser(String email, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                return password.equals(storedPassword);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean registerUser(String email, String password) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (email, password) VALUES (?, ?)");
            statement.setString(1, email);
            statement.setString(2, password);
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}