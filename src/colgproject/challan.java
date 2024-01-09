
//original not to be modified
package colgproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class challan implements ActionListener{
	
    static JFrame frame;
    static JPanel  panel;
    static JLabel comp_name;
    static JLabel comp_gstin = new JLabel("27AFBPA9344R1Z0");
    static JLabel Name= new JLabel("Name");
    static JLabel manu =new JLabel("Manufactures of :ART SILK & COTTON FABRICS");
    static JLabel comp_add=new JLabel("1272,Shandar Compound,Auchit Pada,Bhiwandi-421302(Thane)");
    static LocalDate currdate = LocalDate.now();
    static JLabel currdate1=new JLabel("DATE :");
    static JLabel currdate3=new JLabel(currdate.toString());
    static JLabel doc_no4= new JLabel("Tax invoice no:");
    static JLabel doc_no5 =new JLabel();
    static JLabel name = new JLabel("Name:");
    private JLabel addr = new JLabel("Address:");
    static JLabel gstin4=new JLabel("GSTIN:");
    static JLabel gstin5=new JLabel();
    static JLabel description4 =new JLabel("DESCRIPTION");
    static JLabel description5;
   
    javax.swing.JLabel nam_add;
    public challan() {
    	nam_add=new javax.swing.JLabel();
    }
    public void taxinvoice() {
        frame = new JFrame("Invoice Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(530, 790);

        panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK); // Set the line color
                g.drawLine(0, 100, getWidth(), 100); // Draw a line at y=100 (adjust this value as needed)
            }
        };

        panel.setLayout(null); // Using null layout for manual positioning of components
        comp_name = new JLabel("H.L.Textiles");
        comp_name.setFont(new Font("Arial", Font.BOLD, 20));
        comp_name.setBounds(200, 1, 200, 30); // Adjusted the bounds for better positioning
        comp_gstin.setBounds(185,23, 250, 30);
        comp_gstin.setFont(new Font("Arial", Font.BOLD, 15));// Adjusted the bounds for better positioning
        panel.add(comp_gstin);
        panel.add(comp_name);
        manu.setBounds(120,46,290,20);//        manu.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(manu);
        
        comp_add.setBounds(5,70,480,20);
        comp_add.setFont(new Font("Arial", Font.BOLD, 15));
        panel.add(comp_add);
        
        currdate1.setFont(new Font("Arial", Font.BOLD, 15));
        currdate1.setBounds(10,98,55,30);
        panel.add(currdate1);
        currdate3.setBounds(65,93,60,40);
        panel.add(currdate3);
        bill b2=new bill();
        
        
        doc_no4.setFont(new Font("Arial", Font.BOLD, 15));
        doc_no4.setBounds(260,98,115,30);
        panel.add(doc_no4);
        doc_no5.setText(b2.doc_no3);
        doc_no5.setBounds(380,88,60,50);
        panel.add(doc_no5);
        
        name.setFont(new Font("Arial", Font.BOLD, 15));
        name.setBounds(30,128,60,40);
        panel.add(name);
        
        addr.setFont(new Font("Arial", Font.BOLD, 15));
        addr.setBounds(10,146,80,50);
        panel.add(addr);
        
        
        this.nam_add.setBounds(78,128,60,40);
        nam_add.setText("hi"+b2.storedAddress);
        panel.add(nam_add);
//        nam_add.setBounds();
        gstin4.setFont(new Font("Arial", Font.BOLD, 15));
        gstin4.setBounds(260,130,53,40);
        panel.add(gstin4);

        gstin5.setText(b2.gst_no);
        gstin5.setBounds(315,127,110,45);
        panel.add(gstin5);
        
        description4.setFont(new Font("Arial", Font.BOLD, 13));
        description4.setBounds(25,180,110,40);
        panel.add(description4);
        

        
//        description5.setBounds(null);
        
        frame.add(panel); // Add the panel to the frame
        frame.setVisible(true); // Set the frame to be visible
    }
    public void pdftaxinvoice() {
    	
    }

    public static void main(String[] args) {
        System.out.println("hello");
        challan c1 = new challan();
        c1.taxinvoice();
        System.out.println("hello");
    }
	@Override
	public void actionPerformed(ActionEvent e) {
	
		// TODO Auto-generated method stub
		
	}
}