//original not to be modified 

package colgproject;

import java.sql.*;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bill implements ActionListener {
    static JFrame frame = new JFrame("Created by sransarii");
    static JPanel panel = new JPanel();
    static JLabel pieces = new JLabel("Number of pieces");
    static JTextField piece2 = new JTextField();
    static JLabel piece = new JLabel("No of pieces");
    static JLabel meter = new JLabel("Meter (in mtr)");
    static JTextField meter2 = new JTextField();
    static JLabel rate = new JLabel("Rate ");
    static JTextField rate2 = new JTextField();
    static JLabel watao = new JLabel("deduction(%)");
    static JTextField watao2 = new JTextField();
    static JLabel hammali = new JLabel("labour(rs)");
    static JTextField hammali2 = new JTextField();
    static JLabel gst = new JLabel("GST(%)");
    static JTextField gst2 = new JTextField();
    static JLabel gstin = new JLabel("GSTIN :-");
    static JTextField gstin2 = new JTextField();
    static JButton submit = new JButton("Submit");
    static JLabel hsn = new JLabel("HSN Code");
    static JTextField hsn2 = new JTextField();
    static JLabel doc_no = new JLabel("Doc.no-");
    static JTextField doc_no2 = new JTextField();
    static String piece3 = "";
    static String meter3 = "";
    static String rate3 = "";
    static String watao3 = "";
    static String hammali3 = "";
    static String gst3 = "";
    static double piece4 = 0;
    static double meter4 = 0;
    static double rate4 = 0;
    static double watao4 = 0;
    static double hammali4 = 0;
    static double gst4 = 0;
    static String gst_no = "";
    static String code = "";
    static String storedAddress = "";
    static String storedAddressText = "";
    static Connection connection;
    static String doc_no3="";
    static String description="";
    static JLabel addressLabel = new JLabel("");
    static JLabel addressErrorLabel = new JLabel("");
    static JLabel descriptionLabel = new JLabel();
    static JLabel descriptionErrorLabel = new JLabel();
    static double btotal=0;
    static double win=0;
    static double totngst=0;
    public void setDetail() {
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.add(panel);
        panel.setLayout(null);

        piece.setText("No of pcs");
        piece.setBounds(10, 10, 100, 30);
        panel.add(piece);

        piece2.setBounds(100, 10, 70, 30);
        panel.add(piece2);

        meter.setText("meters");
        meter.setBounds(180, 10, 100, 30);
        panel.add(meter);

        meter2.setBounds(260, 10, 70, 30);
        panel.add(meter2);

        rate.setBounds(10, 50, 70, 30);
        panel.add(rate);
        rate2.setBounds(100, 50, 70, 30);
        panel.add(rate2);

        watao.setBounds(180, 50, 100, 30);
        panel.add(watao);
        watao2.setBounds(260, 50, 70, 30);
        panel.add(watao2);

        hammali.setBounds(10, 90, 70, 30);
        panel.add(hammali);
        hammali2.setBounds(100, 90, 70, 30);
        panel.add(hammali2);

        gst.setBounds(180, 90, 100, 30);
        panel.add(gst);
        gst2.setBounds(260, 90, 70, 30);
        panel.add(gst2);

        hsn.setBounds(10, 130, 70, 30);
        panel.add(hsn);
        hsn2.setBounds(100, 130, 70, 30);
        panel.add(hsn2);

        doc_no.setBounds(180, 130, 70, 30);
        panel.add(doc_no);
        doc_no2.setBounds(260, 130, 70, 30);
        panel.add(doc_no2);

        gstin.setBounds(75, 170, 170, 30);
        panel.add(gstin);
        gstin2.setBounds(145, 170, 170, 30);
        panel.add(gstin2);

        submit.setBounds(90, 210, 90, 30);
        panel.add(submit);
        
        addressLabel.setBounds(90, 250, 300, 60);
        panel.add(addressLabel);
        
        addressErrorLabel.setBounds(90, 250, 300, 60);
        panel.add(addressLabel);
        
        descriptionLabel.setBounds(90, 320, 200, 30);
        panel.add(descriptionLabel);
        panel.add(descriptionErrorLabel);
        descriptionErrorLabel.setBounds(90, 320, 200, 30);
        panel.add(descriptionLabel);
        panel.add(descriptionErrorLabel);

        submit.addActionListener(this);
    }

    public static void setProperties() {
        piece3 = piece2.getText();
        meter3 = meter2.getText();
        rate3 = rate2.getText();
        watao3 = watao2.getText();
        hammali3 = hammali2.getText();
        doc_no3 = doc_no2.getText();
        gst3=gst2.getText();

        if (!piece3.isEmpty()) {
            piece4 = Double.parseDouble(piece3);
        }
        if (!meter3.isEmpty()) {
            meter4 = Double.parseDouble(meter3);
        }
        if (!rate3.isEmpty()) {
            rate4 = Double.parseDouble(rate3);
        }
        if (!watao3.isEmpty()) {
            watao4 = Double.parseDouble(watao3);
        }
        if (!hammali3.isEmpty()) {
            hammali4 = Double.parseDouble(hammali3);
        }
        if(!gst3.isEmpty()) {
        	gst4=Double.parseDouble(gst3);
        }

        gst_no = gstin2.getText();

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "rayyan");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void setGstin() {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM gstin WHERE gst_no = ?");
            statement.setString(1, gst_no);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	addressErrorLabel.setText(null);
                storedAddress = resultSet.getString("address");
                addressLabel.setForeground(Color.GREEN);
            } else {
            	gstin2.setText(null);
            	addressLabel.setForeground(Color.RED);
            	storedAddress="no address for gstin or invalid gst no.";
//            	addressErrorLabel.setForeground(Color.RED);
            	addressErrorLabel.setForeground(Color.RED);
//                storedAddress = ""; // Handle case when no matching GST number found
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void setHsn() {
        try {
            code = hsn2.getText();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM hsncode WHERE code = ?");
            statement.setString(1, code);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	descriptionErrorLabel.setText(null);
                description = resultSet.getString("description");
                descriptionLabel.setForeground(Color.GREEN);
            } else {
            	   descriptionLabel.setForeground(Color.RED);
                description = "no hsn details found";
                hsn2.setText(null);
                descriptionErrorLabel.setForeground(Color.RED);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void calculation() {
    	try {
    	btotal=meter4*rate4;
    	if(watao4==0||Double.isNaN(watao4)) {
    		// empty because the user choosed 0 or null for deduction so it will be skipped
    	
    		
    	}else {
    		//user choosed the deduction so this part will be runned
    		win=watao4/100;
    		win=btotal*win;
    		btotal=btotal-win;
    	}
    	if(hammali4==0||Double.isNaN(hammali4)) {
    		//empty because it is too optional                                                                 user can choose the null  or 0  
    	}else {
    		btotal-=hammali4;
    		
    	}totngst=btotal;
    	//the rate4 variable is there of no use so i am using it for actual rate
    	rate4=totngst/6000;
    	if(gst4==0||Double.isNaN(gst4)) {
    		gst4=0.05;
    		gst4=btotal*gst4;
    		btotal=btotal+gst4;
    	}
    	else {
    		gst4/=100;
    		gst4=btotal*gst4;
    		btotal=btotal+gst4;
    	}
    	System.out.println("the total amount is :"+btotal);
    	System.out.println("the rate is :"+rate4);
    	}catch(Exception e) {
    		System.out.println("Invalid input");
    	}
    	
    }

    public static void main(String[] args) {
        bill billApp = new bill();
        billApp.setDetail();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            setProperties();
            setGstin();
            setHsn();
            calculation();
            addressLabel.setText("<html><br> " + storedAddress + "</html>");
            descriptionLabel.setText("Description: " + description);
          
            if((!hsn2.getText().isEmpty())&&(!(gstin2.getText().isEmpty())&&!storedAddress.isEmpty() &&!description.isEmpty())) {
            challan c1=new challan();
            c1.taxinvoice();   }  
            }
    }
}