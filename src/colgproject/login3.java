	package colgproject;
	
	import java.awt.Color;
	import java.awt.event.*;
	import java.sql.*;
	import javax.swing.*;
	
	public class login3 implements ActionListener {
	    static JTextField textField1;
	    static JPasswordField passwordField1;
	    static JLabel success;
	    static JLabel passwordError;
	    static JFrame frame;
	    static JPanel panel;
	
	    static Connection connection;
	
	    public static void main(String[] args) {
	        String errorMessage = "";
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
	        button1.addActionListener(new login3());
	
	        JButton login31 = new JButton("login");
	        login31.addActionListener(new login3());
	        login31.setBounds(120, 80, 80, 20);
	        panel.add(login31);
	
	        success = new JLabel("");
	        success.setBounds(20, 100, 200, 25);
	        panel.add(success);
	
	        passwordError = new JLabel("");
	        passwordError.setBounds(20, 120, 200, 25);
	        panel.add(passwordError);
	
	        try {
	            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
	                    "rayyan");
	            Statement st = connection.createStatement();
	
	            st.execute("CREATE TABLE IF NOT EXISTS users (email VARCHAR(255) PRIMARY KEY, password VARCHAR(255))");
	        } catch (SQLException e) {
	            System.out.print(e);
	        }
	//         bill.main(args);
	    }
	
	    public void setRegisterComponents() {
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
	
	        passwordField1 = new JPasswordField();
	        passwordField1.setBounds(100, 50, 100, 20);
	        panel.add(passwordField1);
	
	        JButton registerButton = new JButton("Register");
	        registerButton.setBounds(100, 80, 80, 20);
	        panel.add(registerButton);
	
	        registerButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                String email = emailField.getText();
	                String password = new String(passwordField1.getPassword());
	
	                String passwordValidationMessage = getPasswordValidationMessage(password);
	
	                if (passwordValidationMessage != null) {
	                    passwordError.setText(passwordValidationMessage);
	                    passwordError.setForeground(Color.RED);
	                    panel.add(passwordError);
	                } else {
	                    passwordError.setText("");
	
	                    if (registerUser(email, password)) {
	                        success.setText("Registration successful!");
	                        success.setForeground(Color.GREEN);
	
	                        setLoginComponents();
	
	                        frame.revalidate();
	                        frame.repaint();
	                    } else {
	                        System.out.println("Already exists");
	                        passwordError.setText("Email already exists!");
	                        success.setText("Email already exists!");
	                        passwordError.setForeground(Color.RED);
	                        panel.add(passwordError);
	                        panel.add(success);
	                    }
	                }
	            }
	        });
	
	        frame.revalidate(); // Revalidate the frame to update the layout
	        frame.repaint(); // Repaint the frame to reflect the changes
	    }
	
	    private boolean registerUser(String email, String password) {
	        try {
	            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE email = ?");
	            statement.setString(1, email);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next()) {
	                // Email already exists in the database
	                return false;
	            } else {
	                // Email is available, proceed with registration
	                statement = connection.prepareStatement("INSERT INTO users (email, password) VALUES (?, ?)");
	                statement.setString(1, email);
	                statement.setString(2, password);
	                int rowsInserted = statement.executeUpdate();
	                return rowsInserted > 0;
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return false;
	    }
	
	    private String getPasswordValidationMessage(String password) {
	        // Check password requirements and return the error message if any
	        if (password.length() < 8) {
	            System.out.println("At least 8 characters required");
	            passwordError.setText("Should contain at least 8 characters");
	            return "Should contain at least 8 characters.";
	        }
	
	        boolean hasCapitalLetter = false;
	        boolean hasNumericDigit = false;
	        for (char c : password.toCharArray()) {
	            if (Character.isUpperCase(c)) {
	                hasCapitalLetter = true;
	            }
	            if (Character.isDigit(c)) {
	                hasNumericDigit = true;
	            }
	        }
	
	        if (!hasCapitalLetter) {
	            passwordError.setText("Should contain at least one capital letter.");
	            System.out.println("Password should contain at least one capital letter.");
	            return "Contain at least one capital letter.";
	        }
	
	        if (!hasNumericDigit) {
	            passwordError.setText("Should contain at least one numeric digit.");
	            System.out.println("Password should contain at least one numeric digit.");
	            return "Contain at least one numeric digit.";
	        }
	
	        return null; // Return null if the password meets all requirements
	    }
	
	    public void setLoginComponents() {
	        panel.removeAll(); // Remove all components from the panel
	        panel.repaint(); // Repaint the panel to reflect the changes
	
	        JLabel label1 = new JLabel("User-Name");
	        label1.setBounds(20, 25, 80, 25);
	        panel.add(label1);
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
	        button1.addActionListener(this);
	
	        JButton login31 = new JButton("login");
	        login31.addActionListener(this);
	        login31.setBounds(120, 80, 80, 20);
	        panel.add(login31);
	
	        success.setText(""); // Clear the success message
	        passwordError.setText(""); // Clear the password error message
	
	        frame.revalidate();
	        frame.repaint();
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
	
	    @Override
	    public void actionPerformed(ActionEvent e) {
	        JButton sourceButton = (JButton) e.getSource();
	        if (sourceButton.getText().equals("login")) {
	            String user = textField1.getText();
	            String pass = passwordField1.getText();
	
	            if (authenticateUser(user, pass)) {
	                success.setText("Login successful");
	                System.out.println("Login successful");
	                success.setForeground(Color.GREEN);
	                try {
	                    if (connection != null) {
	                        connection.close();
	                    }
	                } catch (Exception f) {
	                    f.printStackTrace();
	                }
	                bill2 b1 = new bill2();
	                // bill b1 = new bill(); // Uncomment this line if required
	                b1.setDetail();
	                challan c1 = new challan();
	            } else {
	                success.setText("Invalid Username or Password");
	                success.setForeground(Color.RED);
	            }
	        } else if (sourceButton.getText().equals("New-register")) {
	            setRegisterComponents();
	        }
	    }
	}