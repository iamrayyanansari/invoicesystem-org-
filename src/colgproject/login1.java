
package colgproject;

import java.awt.Color;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class login1 implements ActionListener {
    static JTextField textField1;
    static JPasswordField passwordField1;
    static JLabel success;
    static boolean condition1 = true;
    static   JFrame frame = new JFrame();
    
    static     JLabel label1 = new JLabel("User-Name");
    static JLabel label2 = new JLabel("Password");
    static   JButton login1 = new JButton("Login");
    static    JButton button1 = new JButton("New-register");

static JPanel panel = new JPanel();
    public static void main(String[] args) {
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);
        label1.setBounds(20, 25, 80, 25);
        panel.add(label1);
        textField1 = new JTextField();
        textField1.setBounds(100, 23, 100, 20);
        panel.add(textField1);

        label2.setBounds(20, 50, 80, 25);
        panel.add(label2);
        passwordField1 = new JPasswordField();
        passwordField1.setBounds(100, 50, 100, 20);
        panel.add(passwordField1);

        button1.setBounds(15, 80, 100, 20);
        panel.add(button1);
        button1.addActionListener(new login1());

        login1.addActionListener(new login1());
        login1.setBounds(120, 80, 80, 20);
        panel.add(login1);

        success = new JLabel("");
        success.setBounds(20, 100, 200, 25);
        panel.add(success);

        try {
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres",
                    "rayyan");
            Statement st = con.createStatement();

            st.execute("Insert into student values(5,'rafdfdthhtytyyab');");
        } catch (SQLException e) {
            System.out.print(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton sourceButton = (JButton) e.getSource();
        String user = textField1.getText();
        String pass = passwordField1.getText();

        if (sourceButton.getText().equals("Login")) {
            if (user.equals("123") && pass.equals("123")) {
                success.setText("Login successfully");
                System.out.println("login successfully");
                success.setForeground(Color.GREEN);
            } else if (user.equals("123") && !pass.equals("123")) {
                success.setText("Invalid Password!");
                success.setForeground(Color.RED);
            } else if (!user.equals("123") && pass.equals("123") || !user.equals("123") && !pass.equals("123")) {
                success.setText("Invalid Username! ");
                success.setForeground(Color.RED);
            } else {
                System.out.println("nothing");
            }
        } else if (sourceButton.getText().equals("New-register")) {
            // Handle the action for the "New-register" button
        	
            System.out.println("New-register button click"
            		
            		+ "ed!");
            // Add your code here to perform the desired action
        }
    }
}