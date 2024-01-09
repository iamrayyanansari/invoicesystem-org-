package colgproject;

import javax.swing.*;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.time.LocalDate;
//import com.itextpdf.text.Document;

public class challan2 implements  ActionListener{
    static JFrame frame;
    static JPanel panel;
    static JLabel comp_name;
    static JLabel comp_gstin = new JLabel("27AFBPA9344R1Z0");
//    static JLabel Name = new JLabel("Name");
    static JLabel manu = new JLabel("Manufacturers of: ART SILK & COTTON FABRICS");
    static JLabel comp_add = new JLabel("1272, Shandar Compound, Auchit Pada, Bhiwandi-421302(Thane)");
    static LocalDate currdate = LocalDate.now();
    static JLabel currdate1 = new JLabel("DATE:");
    static JLabel currdate3 = new JLabel(currdate.toString());
    static JLabel doc_no4 = new JLabel("Tax invoice no:");
    static JLabel doc_no5 = new JLabel();
    static JLabel name = new JLabel("Name:");
    private JLabel addr = new JLabel("Address:");
    static JLabel gstin4 = new JLabel("GSTIN:");
    static JLabel gstin5 = new JLabel();
    static JLabel description4 = new JLabel("DESCRIPTION");
    static JLabel description5;
    static JLabel hsnCode4=new JLabel("HSN Code");
    static JLabel hsnCode5=new JLabel();
    static JLabel pieces4=new JLabel("No.of pcs");
    static JLabel  pieces5=new JLabel();
    static JLabel quty4=new JLabel("Quantity(mtr)");
    static JLabel  quty5=new JLabel();
    static JLabel  crate4=new JLabel("Rate/mtr");
    static JLabel  crate5=new JLabel();
    static JLabel  ctotngst4=new JLabel("Amount");
    static JLabel  ctotngst5=new JLabel();
    
    static JLabel  ctotngst6=new JLabel("Total₹");
    static JLabel  ctotngst7=new JLabel();
    
    static JLabel sgst1=new JLabel("SGST @");
    static JLabel sgst2=new JLabel();
    static JLabel cgst1=new JLabel("CGST @");
    static JLabel cgst2=new JLabel();
    static JLabel igst1=new JLabel("IGST @");
    static JLabel igst2=new JLabel();
    
    static JLabel btotal1=new JLabel("G. Total ₹");
    static JLabel btotal2=new JLabel();
    
    javax.swing.JLabel nam_add;

    private String named;
    private String address;
    static String hsnCode;
    private String hsnDescription;
    private String gstin;
    private String docno; 
    private String pieces; 
    private String crate; 
    private String ctotngst;
    private String gst;
    private String btotal;
    private String quty;
    private String storedName;
    static JButton continuee =new JButton("Continue..");
    
    private double gst5;
    private double cgst;
    private double sgst;
    double val=0;
//    private double cgst3;
//    private double sgst3;
    
    

    public challan2() {
        nam_add = new javax.swing.JLabel();
        description5 = new JLabel();
    }

    public void setNameAddress(String name,String Address) {
        this.named = name;
        this.address=Address;
    }

    public void setHsnAndDescription(String hsnCode, String hsnDescription,String docno,String pieces,String quty,
    		String crate,String ctotngst,String gst,double gst5,String btotal) {
        this.hsnCode = hsnCode;
        this.hsnDescription = hsnDescription;
        this.docno=docno;
        this.pieces=pieces;
        this.crate=crate;
        this.ctotngst=ctotngst;
        this.gst=gst;
        this.gst5=gst5;
        this.btotal=btotal;
        this.quty=quty;
        val=Double.parseDouble(crate);
        this.crate=String.format("%.2f", val);
    }

    public void setGstin(String gstin) {
        this.gstin = gstin;
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
//                g.drawLine(110, 100, 110, 320);
//                g.drawLine(265, 100, 265, 320);
                g.drawLine(0, 100, getWidth(), 100); // Draw a line at y=100 (adjust this value as needed)
            }
        };

        panel.setLayout(null); // Using null layout for manual positioning of components
        comp_name = new JLabel("H.L.Textiles");
        comp_name.setFont(new Font("Arial", Font.BOLD, 20));
        comp_name.setBounds(200, 1, 200, 30); // Adjusted the bounds for better positioning
        comp_gstin.setBounds(185, 23, 250, 30);
        comp_gstin.setFont(new Font("Arial", Font.BOLD, 15)); // Adjusted the bounds for better positioning
        panel.add(comp_gstin);
        panel.add(comp_name);
        manu.setBounds(120, 46, 290, 20); // manu.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(manu);
        comp_add.setBounds(5,70,480,20);
        panel.add(comp_add);
        
        currdate1.setFont(new Font("Arial", Font.BOLD, 15));
        currdate1.setBounds(10,98,55,30);
        panel.add(currdate1);
        currdate3.setBounds(65,93,60,40);
        panel.add(currdate3);
        
        
        doc_no4.setFont(new Font("Arial", Font.BOLD, 15));
        doc_no4.setBounds(260,98,115,30);
        panel.add(doc_no4);
        doc_no5.setBounds(380, 88, 60, 50);
        panel.add(doc_no5);
//        Name.setBounds(5, 150, 80, 30);
//        panel.add(Name);
        name.setFont(new Font("Arial", Font.BOLD, 15));
        name.setBounds(30,128,60,40);
        panel.add(name);
        
        addr.setFont(new Font("Arial", Font.BOLD, 15));
        addr.setBounds(10,140,80,50);
        panel.add(addr);
        //thus is the address of chaallan
        nam_add.setText("<html><b><br>"+named+address+"</b></html>");
        nam_add.setBounds(78, 65, 175, 150);
        panel.add(nam_add);
        
        gstin4.setFont(new Font("Arial", Font.BOLD, 15));
        gstin4.setBounds(260,130,53,40);
        panel.add(gstin4);
        
        gstin5.setText(gstin);
        gstin5.setBounds(315, 135, 300, 30);
        panel.add(gstin5);
        
        description4.setFont(new Font("Arial", Font.BOLD, 13));
        description4.setBounds(5,180,110,40);
        panel.add(description4);
        description5.setText(/*hsnCode + ": " + */hsnDescription);
        description5.setBounds(10, 205, 90, 30);
        panel.add(description5);

        // Other components and calculations...
        doc_no5.setBounds(378,92,130,40);
        doc_no5.setText(docno);
        panel.add(doc_no5);
        
        hsnCode4.setFont(new Font("Arial", Font.BOLD, 13));
        hsnCode4.setBounds(100,180,65,40);
        panel.add(hsnCode4);

        hsnCode5.setBounds(100,205,90,30);
        hsnCode5.setText(hsnCode);
        panel.add(hsnCode5);
        
        pieces4.setFont(new Font("Arial", Font.BOLD, 13));
        pieces4.setBounds(175,180,60,40);
        panel.add(pieces4);
        
        pieces5.setBounds(175,205,90,30);
        pieces5.setText(pieces);
        panel.add(pieces5);
        
        quty4.setFont(new Font("Arial", Font.BOLD, 13));
        quty4.setBounds(240,180,80,40);
        panel.add(quty4);
        
        quty5.setBounds(240,205,90,30);
        quty5.setText(quty);
        panel.add(quty5);
        
        //here
        
        crate4.setFont(new Font("Arial", Font.BOLD, 13));
        crate4.setBounds(330,180,60,40);
        panel.add(crate4);
        
        crate5.setBounds(330,205,90,30);
        crate5.setText(crate);
        panel.add(crate5);
        
        
        ctotngst4.setFont(new Font("Arial", Font.BOLD, 13));
        ctotngst4.setBounds(410,181,60,40);
        panel.add(ctotngst4);
        
        ctotngst5.setBounds(410,205,90,30);
        ctotngst5.setText(ctotngst);
        panel.add(ctotngst5);
        
        ctotngst6.setFont(new Font("Arial", Font.BOLD, 13));
        ctotngst6.setBounds(330,480,60,40);
        panel.add(ctotngst6);
        
        ctotngst7.setBounds(410,483,90,30);
        ctotngst7.setText(ctotngst);
        panel.add(ctotngst7);
    
        
        frame.add(panel);
        frame.setVisible(true);
        continuee.addActionListener(this);
        continuee.setBounds(50,700,100,20);
        panel.add(continuee);
        
    }
    public void taxinvoicetopdf() {
    	String path="invoice.pdf";

//    	Document document=new Document();
    
    }
    public void setGst() {
    	cgst1.setFont(new Font("Arial", Font.BOLD, 13));
		cgst1.setText("CGST @"+String.valueOf(cgst));
		  cgst1.setBounds(302,505,120,40);
		  panel.add(cgst1);
		sgst1.setFont(new Font("Arial", Font.BOLD, 13));
		sgst1.setText("SGST @"+String.valueOf(cgst));
		sgst1.setBounds(302,523,120,40);
        panel.add(sgst1);
        igst1.setFont(new Font("Arial", Font.BOLD, 13));
		igst1.setText("IGST @"+String.valueOf(gst));
        igst1.setBounds(302,544,120,40);
        panel.add(igst1);
        btotal1.setFont(new Font("Arial", Font.BOLD, 13));
        btotal1.setBounds(302,564,60,40);
        panel.add(btotal1);
//    	try {
    	if(gstin.startsWith("27")) {
    		sgst=Double.parseDouble(gst);
    		sgst=sgst/2;
    		cgst=sgst;
//    		sgst=;
    	
          
            cgst2.setText(String.valueOf(gst5/2));
            cgst2.setBounds(410,505,120,40);
            panel.add(cgst2);
            
        	
            
            sgst2.setText(String.valueOf(gst5/2));
            sgst2.setBounds(410,523,120,40);
            panel.add(sgst2);
            
    		
    	}else{
        igst2.setText(String.valueOf(gst5));
        igst2.setBounds(410,546,120,40);
        panel.add(igst2);
        
    		
    	}
    	
    	
         
         btotal2.setBounds(410,570,90,30);
         btotal2.setText(btotal);
         panel.add(btotal2);
//    }catch(Exception e) {
//    System.out.println("this error");	
//    }
    	}

    public static void main(String[] args) {
//    	
        challan2 c2 = new challan2();
        c2.taxinvoice();
        c2.setGst();
       
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==continuee) {
			System.out.println("hello world");
//			TaxInvoice3 tc =new TaxInvoice3();
			
//		taxinvoicetopdf();
			TaxInvoice3 pdf =new TaxInvoice3(gstin,named,address,hsnCode,hsnDescription,docno,pieces,quty,crate,ctotngst,gst,gst5,btotal);
//			pdf.setData(gstin,named,address,hsnCode,hsnDescription,docno,pieces,quty,crate,ctotngst,gst,gst5,btotal);
//			pdf.setPdf();
			pdf.setPdf();
		}
		// TODO Auto-generated method stub
		
	}
}