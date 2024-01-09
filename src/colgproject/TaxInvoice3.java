package colgproject;

import java.awt.Desktop;
import java.io.File;
import java.time.LocalDate;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class TaxInvoice3 {
static	String gstin;static String name;static String address;static String hsnCode;static  String hsnDescription;static String docno;
static 	String piece;static String quty;static String crate;static String ctotngst;static String gst;static double gst5;static String btotal;
	static LocalDate currdate = LocalDate.now();
    static String date=currdate.toString();
    static String inputFile="";
    static String outputFile="";

    // ... (other methods and code)
public  TaxInvoice3(String gstin,String name,String address,String hsnCode, String hsnDescription,String docno,
		String piece,String quty,String crate,String ctotngst,String gst,double gst5,String btotal){
		this.gstin=gstin;this.name=name;this.address=address;;this.hsnCode=hsnCode;this.hsnDescription=hsnDescription;this.docno=docno;
		this.piece=piece;this.quty=quty;this.crate=crate;this.ctotngst=ctotngst;this.gst=gst;this.gst5=gst5;this.btotal=btotal;
		System.out.println("GSTIN :"+gstin);
		System.out.println("Name :"+name);
		System.out.println("Party address :"+address);
		System.out.println("hsn code :"+hsnCode);
		System.out.println("description :"+hsnDescription);
		System.out.println("invoice no :"+docno);
		System.out.println("no of pieces(in-no):"+piece);
		System.out.println("Quantity :"+quty);
		System.out.println("Rate :"+crate);
		System.out.println("without gst total :"+ctotngst);
		System.out.println("gst rate"+gst);
		System.out.println("gst (in price) :"+gst5);
		System.out.println("total with price"+btotal);
}
    public static void main(String[] args) {
    	gstin="28";
    	if(gstin.startsWith("27")) {
        // Input and Output PDF file paths
        inputFile = "C:\\Users\\Rayyan\\Documents\\tax invoice\\originalsample" + File.separator + "gstsamp2.pdf";
        outputFile = "C:\\Users\\Rayyan\\Documents\\tax invoice" + File.separator +"myname.pdf";
    
        try {
            // Create a PdfReader for the input PDF
            PdfReader reader = new PdfReader(inputFile);

            // Create a PdfWriter with the output PDF file
            PdfWriter writer = new PdfWriter(outputFile);

            // Create a PdfDocument for both the reader and writer
            PdfDocument pdfDocument = new PdfDocument(reader, writer);

            // Create a Document to add content
            Document document = new Document(pdfDocument);

            // Add a paragraph with the text you want to insert
            Paragraph partyName = new Paragraph("Sumesh enterprises.");
            partyName.setMarginLeft(0.5f);
            partyName.setMarginTop(85);
            partyName.setFontSize(10);
            document.add(partyName);
            
            Paragraph partyGstin = new Paragraph("27AFERTYHGTERFGF");
            partyGstin.setMarginLeft(22);
            partyGstin.setMarginTop(2);
            partyGstin.setFontSize(9);
            document.add(partyGstin);
            String egs="bala compound, bhiwandi421 302, Maharashtra";
            for(String s:egs.split(",")) {
            	
            	Paragraph partyAdd = new Paragraph(s);
            	partyAdd.setMarginLeft(50);
            	partyAdd.setMarginTop(0);
            	partyAdd.setFontSize(9.5f);
            	document.add(partyAdd);
            }
            
            
            Paragraph description = new Paragraph("M x M micro");
            description.setMarginLeft(20);
            description.setMarginTop(25);
            description.setFontSize(10);
            document.add(description);

//            Paragraph invoiceNo = new Paragraph("this is ");
//            invoiceNo.setMarginLeft(185);
//            invoiceNo.setMarginTop(800);
//            invoiceNo.setFontSize(9);
//            document.add(invoiceNo);
            // Get the page canvas and set the position for the date
            PdfCanvas canvas = new PdfCanvas(pdfDocument.getFirstPage());
            float x = 440; // X-coordinate for date(on top right corner)
            float y = 774; // Y-coordinate for date
            PdfFont font = PdfFontFactory.createFont(); // You need to specify the font path or use a built-in font
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(date).endText();
            



            x = 222; // X-coordinate for hsn code
            y = 595; // Y-coordinate for hsn code
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("5407").endText();
            
            x = 27; // X-coordinate for hsn code
            y = 362; // Y-coordinate for hsn code
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("5407").endText();
        
            y = 774; // Y-coordinate for tax invoice
            x = 310; // X-coordinate for ......
            
            canvas.beginText().setFontAndSize(font, 11).moveText(x, y).showText("95").endText();
            if(gstin.startsWith("27")) {
            	 x = 307; // X-coordinate for state
                 y = 742; // Y-coordinate for...... 
                 canvas.beginText().setFontAndSize(font, 11).moveText(x, y).showText("Maharashtra ").endText();
                
            	
            }else {
            	 x = 307; // X-coordinate for state 
            	 y = 742; // Y-coordinate for state
                 canvas.beginText().setFontAndSize(font, 11).moveText(x, y).showText("Other State").endText();
                
            }
            x = 25; // X-coordinate for quantity in meter code
            y = 592; // Y-coordinate for hsn code
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("100a0").endText();
//            x = 88; // X-coordinate for quantity in meter code
//            y = 472; // Y-coordinate for
//            canvas.beginText().setFontAndSize(font, 7).moveText(x, y).showText("100").endText();
//            
            x = 108; // X-coordinate for quantity or no. of pieces
            y = 472; // Y-coordinate for ....
            canvas.beginText().setFontAndSize(font, 8).moveText(x, y).showText("100   /").endText();
            
            x = 140; // X-coordinate for quantity in meter code
            y = 472; // Y-coordinate for ....
            canvas.beginText().setFontAndSize(font, 8).moveText(x, y).showText("60500").endText();
            
            x = 330; // X-coordinate for qty in mtr
            y = 602; // Y-coordinate for qty in mtr
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("60500").endText();
          
            x = 520; // X-coordinate for total amt without gst
            y = 472; // Y-coordinate for .....
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("60000").endText();
            x = 170; // X-coordinate for total amt without gst
            y = 362; // Y-coordinate for .....
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("60000").endText();
            x = 170; // X-coordinate for total amt without gst
            y = 349; // Y-coordinate for .....
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("60000").endText();
            x = 390; // X-coordinate for total amt wiyhoutgst
            y = 598; // Y-coordinate for...
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("60000").endText();

            
            x = 280; // X-coordinate for rate 
            y = 596; // Y-coordinate for...
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("10.84").endText();

            x = 470; // X-coordinate gst in price
            y = 598; // Y-coordinate ....
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("55525").endText();
            
            double sgst=Double.parseDouble("5");
            double sgstpr=Double.parseDouble("55525");
//            double cgst=Double.parseDouble("5");
            sgst/=2;
            sgstpr/=2;
            System.out.println(sgst);
            
            x = 430; // X-coordinate for gst
            y = 458; // Y-coordinate for .....
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgst+"%")).endText();
            x = 430; // X-coordinate for  gst
            y = 448; // Y-coordinate for .....
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgst+"%")).endText();
            x = 255; // X-coordinate for total amt without gst
            y = 363; // Y-coordinate for .....
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgst+"%")).endText();
            x = 385; // X-coordinate for total amt without gst
            y = 363; // Y-coordinate for .....
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgst+"%")).endText();
           
           
            x = 525; // X-coordinate for gst half price
            y = 458; // Y-coordinate for .....
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr)).endText();
            x = 525; // X-coordinate for gst half price
            y = 447.8f; // Y-coordinate for .....
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr)).endText();
            x = 312; // X-coordinate for gst half price
            y = 363f; // Y-coordinate for .....
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr)).endText();
            x = 440; // X-coordinate for gst half price
            y = 363f; // Y-coordinate for .....
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr)).endText();

            x = 510; // X-coordinate for gst half price
            y = 362; // Y-coordinate for .....
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr+sgstpr)).endText();
            
            x = 519; // X-coordinate total with gst in price
            y = 598; // Y-coordinate ....
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(5552+60000)).endText();
            x = 519; // X-coordinate total with gst in price
            y = 420; // Y-coordinate ....
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(5552+60000)).endText();
            x = 523; // X-coordinate total with gst in price
            y = 336; // Y-coordinate ....
            canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(5552+60000)).endText();
            
           
            // Close the Document
            document.close();

            // Close the PdfDocument (this will also close the writer)
            pdfDocument.close();

            System.out.println("Text added successfully.");
            openPdf(outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }}else {
            // Input and Output PDF file paths
            inputFile = "C:\\Users\\Rayyan\\Documents\\tax invoice\\originalsample" + File.separator + "igstsamp2.pdf";
            outputFile = "C:\\Users\\Rayyan\\Documents\\tax invoice" + File.separator +"myname.pdf";
        
            try {
                // Create a PdfReader for the input PDF
                PdfReader reader = new PdfReader(inputFile);

                // Create a PdfWriter with the output PDF file
                PdfWriter writer = new PdfWriter(outputFile);

                // Create a PdfDocument for both the reader and writer
                PdfDocument pdfDocument = new PdfDocument(reader, writer);

                // Create a Document to add content
                Document document = new Document(pdfDocument);

                // Add a paragraph with the text you want to insert
                Paragraph partyName = new Paragraph("Sumesh enterprises.");
                partyName.setMarginLeft(0.5f);
                partyName.setMarginTop(85);
                partyName.setFontSize(10);
                document.add(partyName);
                
                Paragraph partyGstin = new Paragraph("27AFERTYHGTERFGF");
                partyGstin.setMarginLeft(22);
                partyGstin.setMarginTop(2);
                partyGstin.setFontSize(9);
                document.add(partyGstin);
                String egs="bala compound, bhiwandi421 302, Maharashtra";
                for(String s:egs.split(",")) {
                	
                	Paragraph partyAdd = new Paragraph(s);
                	partyAdd.setMarginLeft(50);
                	partyAdd.setMarginTop(0);
                	partyAdd.setFontSize(9.5f);
                	document.add(partyAdd);
                }
                
                
                Paragraph description = new Paragraph("M x M micro");
                description.setMarginLeft(20);
                description.setMarginTop(25);
                description.setFontSize(10);
                document.add(description);

//                Paragraph invoiceNo = new Paragraph("this is ");
//                invoiceNo.setMarginLeft(185);
//                invoiceNo.setMarginTop(800);
//                invoiceNo.setFontSize(9);
//                document.add(invoiceNo);
                // Get the page canvas and set the position for the date
                PdfCanvas canvas = new PdfCanvas(pdfDocument.getFirstPage());
                float x = 440; // X-coordinate for date(on top right corner)
                float y = 774; // Y-coordinate for date
                PdfFont font = PdfFontFactory.createFont(); // You need to specify the font path or use a built-in font
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(date).endText();
                



                x = 222; // X-coordinate for hsn code
                y = 595; // Y-coordinate for hsn code
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("5407").endText();
                
                x = 27; // X-coordinate for hsn code
                y = 373; // Y-coordinate for hsn code
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("g5407").endText();
            
                y = 774; // Y-coordinate for tax invoice
                x = 310; // X-coordinate for ......
                gstin="28";
                canvas.beginText().setFontAndSize(font, 11).moveText(x, y).showText("95").endText();
                if(gstin.startsWith("27")) {
                	 x = 307; // X-coordinate for state
                     y = 742; // Y-coordinate for...... 
                     canvas.beginText().setFontAndSize(font, 11).moveText(x, y).showText("Maharashtra ").endText();
                    
                	
                }else {
                	 x = 307; // X-coordinate for state 
                	 y = 742; // Y-coordinate for state
                     canvas.beginText().setFontAndSize(font, 11).moveText(x, y).showText("Other State").endText();
                    
                }
                x = 25; // X-coordinate for quantity in meter code
                y = 592; // Y-coordinate for hsn code
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("100a0").endText();
//                x = 88; // X-coordinate for quantity in meter code
//                y = 472; // Y-coordinate for
//                canvas.beginText().setFontAndSize(font, 7).moveText(x, y).showText("100").endText();
//                
                x = 110; // X-coordinate for quantity or no. of pieces
                y = 472; // Y-coordinate for ....
                canvas.beginText().setFontAndSize(font, 8).moveText(x, y).showText("100   /").endText();
                
                x = 141; // X-coordinate for quantity in meter code
                y = 472; // Y-coordinate for ....
                canvas.beginText().setFontAndSize(font, 8).moveText(x, y).showText("60500").endText();
                
                x = 330; // X-coordinate for qty in mtr
                y = 602; // Y-coordinate for qty in mtr
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("60500").endText();
              
                x = 526; // X-coordinate for total amt without gst
                y = 472; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("60k000").endText();
                x = 168; // X-coordinate for total amt without gst
                y = 373; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("h60000").endText();
                x = 168; // X-coordinate for total amt without gst
                y = 360; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("h60000").endText();
                
                x = 390; // X-coordinate for total amt wiyhoutgst
                y = 598; // Y-coordinate for...
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("l60000").endText();
                

                
                x = 280; // X-coordinate for rate 
                y = 596; // Y-coordinate for...
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText("10.84").endText();

                double sgst=Double.parseDouble("5");
                double sgstpr=Double.parseDouble("55525");
//                double cgst=Double.parseDouble("5");
                
                x = 460; // X-coordinate gst in price
                y = 598; // Y-coordinate ....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr)).endText();
                
                
                System.out.println(sgst);
                
                x = 430; // X-coordinate for gst
                y = 459; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgst+"e%")).endText();
                
                x = 287; // X-coordinate for total amt without gst
                y = 373; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgst+"f%")).endText();


               
               
                x = 525; // X-coordinate for gst half price
                y = 458; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr+"g")).endText();
                
                
                x = 400; // X-coordinate for gst half price
                y = 373f; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr+"fg")).endText();

                x = 510; // X-coordinate for gst half price
                y = 373; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr)).endText();
                
                x = 519; // X-coordinate total with gst in price
                y = 598; // Y-coordinate ....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(5552+60000)).endText();
                x = 519; // X-coordinate total with gst in price
                y = 430; // Y-coordinate ....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(5552+60000+"j")).endText();
                x = 523; // X-coordinate total with gst in price
                y = 346; // Y-coordinate ....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(5552+60000+"k")).endText();
                
               
                // Close the Document
                document.close();

                // Close the PdfDocument (this will also close the writer)
                pdfDocument.close();

                System.out.println("Text added successfully.");
                openPdf(outputFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        //here will be other state block
        
        }
    }
    public static void setPdf() {
    	if(gstin.startsWith("27")) {
            // Input and Output PDF file paths
            inputFile = "C:\\Users\\Rayyan\\Documents\\tax invoice\\originalsample" + File.separator + "gstsamp2.pdf";
            outputFile = "C:\\Users\\Rayyan\\Documents\\tax invoice" + File.separator +docno+".pdf";
        
            try {
                // Create a PdfReader for the input PDF
                PdfReader reader = new PdfReader(inputFile);

                // Create a PdfWriter with the output PDF file
                PdfWriter writer = new PdfWriter(outputFile);

                // Create a PdfDocument for both the reader and writer
                PdfDocument pdfDocument = new PdfDocument(reader, writer);

                // Create a Document to add content
                Document document = new Document(pdfDocument);

                // Add a paragraph with the text you want to insert
                Paragraph partyName = new Paragraph(name);
                partyName.setMarginLeft(0.5f);
                partyName.setMarginTop(85);
                partyName.setFontSize(10);
                document.add(partyName);
                
                Paragraph partyGstin = new Paragraph(gstin);
                partyGstin.setMarginLeft(22);
                partyGstin.setMarginTop(2);
                partyGstin.setFontSize(9);
                document.add(partyGstin);
//                String egs="bala compound, bhiwandi421 302, Maharashtra";
                for(String s:address.split(",")) {
                	
                	Paragraph partyAdd = new Paragraph(s);
                	partyAdd.setMarginLeft(50);
                	partyAdd.setMarginTop(0);
                	partyAdd.setFontSize(9.5f);
                	document.add(partyAdd);
                }
                
                
//                Paragraph description = new Paragraph(hsnDescription);
//                description.setMarginLeft(20);
//                description.setMarginTop(13);
//                description.setFontSize(10);
//                document.add(description);

//                Paragraph invoiceNo = new Paragraph("this is ");
//                invoiceNo.setMarginLeft(185);
//                invoiceNo.setMarginTop(800);
//                invoiceNo.setFontSize(9);
//                document.add(invoiceNo);
                // Get the page canvas and set the position for the date
                PdfCanvas canvas = new PdfCanvas(pdfDocument.getFirstPage());
                float x = 440; // X-coordinate for date(on top right corner)
                float y = 774; // Y-coordinate for date
                PdfFont font = PdfFontFactory.createFont(); // You need to specify the font path or use a built-in font
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(date).endText();
                
                x = 105; // X-coordinate for quantity in meter code
                y = 592; // Y-coordinate for hsn code
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(hsnDescription).endText();



                x = 222; // X-coordinate for hsn code
                y = 595; // Y-coordinate for hsn code
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(hsnCode).endText();
                
                x = 27; // X-coordinate for hsn code
                y = 362; // Y-coordinate for hsn code
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(hsnCode).endText();
            
                y = 774; // Y-coordinate for tax invoice
                x = 310; // X-coordinate for ......
                
                canvas.beginText().setFontAndSize(font, 11).moveText(x, y).showText(docno).endText();
                if(gstin.startsWith("27")) {
                	 x = 307; // X-coordinate for state
                     y = 742; // Y-coordinate for...... 
                     canvas.beginText().setFontAndSize(font, 11).moveText(x, y).showText("Maharashtra ").endText();
                    
                	
                }else {
                	 x = 307; // X-coordinate for state 
                	 y = 742; // Y-coordinate for state
                     canvas.beginText().setFontAndSize(font, 11).moveText(x, y).showText("Other State").endText();
                    
                }
                x = 28; // X-coordinate for quantity in meter code
                y = 592; // Y-coordinate for hsn code
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(piece).endText();
//                x = 88; // X-coordinate for quantity in meter code
//                y = 472; // Y-coordinate for
//                canvas.beginText().setFontAndSize(font, 7).moveText(x, y).showText("100").endText();
//                
                x = 110; // X-coordinate for quantity or no. of pieces
                y = 472; // Y-coordinate for ....
                canvas.beginText().setFontAndSize(font, 8).moveText(x, y).showText(piece+"    /").endText();
                
                x = 140; // X-coordinate for quantity in meter code
                y = 472; // Y-coordinate for ....
                canvas.beginText().setFontAndSize(font, 8).moveText(x, y).showText(quty).endText();
                
                x = 330; // X-coordinate for qty in mtr
                y = 602; // Y-coordinate for qty in mtr
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(quty).endText();
              
                x = 520; // X-coordinate for total amt without gst
                y = 472; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(ctotngst).endText();
                x = 170; // X-coordinate for total amt without gst
                y = 362; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(ctotngst).endText();
                x = 170; // X-coordinate for total amt without gst
                y = 349; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(ctotngst).endText();
                x = 390; // X-coordinate for total amt wiyhoutgst
                y = 598; // Y-coordinate for...
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(ctotngst).endText();

                
                x = 280; // X-coordinate for rate 
                y = 596; // Y-coordinate for...
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(crate).endText();

                x = 470; // X-coordinate gst in price
                y = 598; // Y-coordinate ....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(gst5)).endText();
                
                double sgst=Double.parseDouble(gst);
                double sgstpr=gst5;
//                double cgst=Double.parseDouble("5");
                sgst/=2;
                sgstpr/=2;
                System.out.println(sgst);
                
                x = 430; // X-coordinate for gst
                y = 458; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgst+"%")).endText();
                x = 430; // X-coordinate for  gst
                y = 448; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgst+"%")).endText();
                x = 255; // X-coordinate for total amt without gst
                y = 363; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgst+"%")).endText();
                x = 385; // X-coordinate for total amt without gst
                y = 363; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgst+"%")).endText();
               
               
                x = 525; // X-coordinate for gst half price
                y = 458; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr)).endText();
                x = 525; // X-coordinate for gst half price
                y = 447.8f; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr)).endText();
                x = 312; // X-coordinate for gst half price
                y = 363f; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr)).endText();
                x = 440; // X-coordinate for gst half price
                y = 363f; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr)).endText();

                x = 510; // X-coordinate for gst half price
                y = 362; // Y-coordinate for .....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr+sgstpr)).endText();
                
                x = 519; // X-coordinate total with gst in price
                y = 598; // Y-coordinate ....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(btotal)).endText();
                x = 519; // X-coordinate total with gst in price
                y = 420; // Y-coordinate ....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(btotal)).endText();
                x = 523; // X-coordinate total with gst in price
                y = 336; // Y-coordinate ....
                canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(btotal)).endText();
                
               
                // Close the Document
                document.close();

                // Close the PdfDocument (this will also close the writer)
                pdfDocument.close();

                System.out.println("Text added successfully.");
                openPdf(outputFile);
            } catch (Exception e) {
                e.printStackTrace();
            }}else {
                // Input and Output PDF file paths
                inputFile = "C:\\Users\\Rayyan\\Documents\\tax invoice\\originalsample" + File.separator + "igstsamp2.pdf";
                outputFile = "C:\\Users\\Rayyan\\Documents\\tax invoice" + File.separator +docno+".pdf";
            
                try {
                    // Create a PdfReader for the input PDF
                    PdfReader reader = new PdfReader(inputFile);

                    // Create a PdfWriter with the output PDF file
                    PdfWriter writer = new PdfWriter(outputFile);

                    // Create a PdfDocument for both the reader and writer
                    PdfDocument pdfDocument = new PdfDocument(reader, writer);

                    // Create a Document to add content
                    Document document = new Document(pdfDocument);

                    // Add a paragraph with the text you want to insert
                    Paragraph partyName = new Paragraph(name);
                    partyName.setMarginLeft(0.5f);
                    partyName.setMarginTop(85);
                    partyName.setFontSize(10);
                    document.add(partyName);
                    
                    Paragraph partyGstin = new Paragraph(gstin);
                    partyGstin.setMarginLeft(22);
                    partyGstin.setMarginTop(2);
                    partyGstin.setFontSize(9);
                    document.add(partyGstin);
//                    String egs="bala compound, bhiwandi421 302, Maharashtra";
                    for(String s:address.split(",")) {
                    	
                    	Paragraph partyAdd = new Paragraph(s);
                    	partyAdd.setMarginLeft(50);
                    	partyAdd.setMarginTop(0);
                    	partyAdd.setFontSize(9.5f);
                    	document.add(partyAdd);
                    }
                    
                    
//                    Paragraph description = new Paragraph(hsnDescription);
//                    description.setMarginLeft(20);
//                    description.setMarginTop(13);
//                    description.setFontSize(10);
//                    document.add(description);

//                    Paragraph invoiceNo = new Paragraph("this is ");
//                    invoiceNo.setMarginLeft(185);
//                    invoiceNo.setMarginTop(800);
//                    invoiceNo.setFontSize(9);
//                    document.add(invoiceNo);
                    // Get the page canvas and set the position for the date
                    PdfCanvas canvas = new PdfCanvas(pdfDocument.getFirstPage());
                    float x = 440; // X-coordinate for date(on top right corner)
                    float y = 774; // Y-coordinate for date
                    PdfFont font = PdfFontFactory.createFont(); // You need to specify the font path or use a built-in font
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(date).endText();
                    
                    x = 105; // X-coordinate for quantity in meter code
                    y = 592; // Y-coordinate for hsn code
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(hsnDescription).endText();


                    
                    x = 222; // X-coordinate for hsn code
                    y = 595; // Y-coordinate for hsn code
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(hsnCode).endText();
                    
                    x = 27; // X-coordinate for hsn code
                    y = 373; // Y-coordinate for hsn code
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(hsnCode).endText();
                
                    y = 774; // Y-coordinate for tax invoice
                    x = 310; // X-coordinate for ......
                    gstin="28";
                    canvas.beginText().setFontAndSize(font, 11).moveText(x, y).showText(docno).endText();
                    if(gstin.startsWith("27")) {
                    	 x = 307; // X-coordinate for state
                         y = 742; // Y-coordinate for...... 
                         canvas.beginText().setFontAndSize(font, 11).moveText(x, y).showText("Maharashtra ").endText();
                        
                    	
                    }else {
                    	 x = 307; // X-coordinate for state 
                    	 y = 742; // Y-coordinate for state
                         canvas.beginText().setFontAndSize(font, 11).moveText(x, y).showText("Other State").endText();
                        
                    }
                    x = 28; // X-coordinate for quantity in meter code
                    y = 592; // Y-coordinate for hsn code
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(piece).endText();
//                    x = 88; // X-coordinate for quantity in meter code
//                    y = 472; // Y-coordinate for
//                    canvas.beginText().setFontAndSize(font, 7).moveText(x, y).showText("100").endText();
//                    
                    x = 110; // X-coordinate for quantity or no. of pieces
                    y = 472; // Y-coordinate for ....
                    canvas.beginText().setFontAndSize(font, 8).moveText(x, y).showText(piece+"      /").endText();
                    
                    x = 141; // X-coordinate for quantity in meter code
                    y = 472; // Y-coordinate for ....
                    canvas.beginText().setFontAndSize(font, 8).moveText(x, y).showText(quty).endText();
                    
                    x = 330; // X-coordinate for qty in mtr
                    y = 602; // Y-coordinate for qty in mtr
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(quty).endText();
                  
                    x = 526; // X-coordinate for total amt without gst
                    y = 472; // Y-coordinate for .....
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(ctotngst).endText();
                    x = 168; // X-coordinate for total amt without gst
                    y = 373; // Y-coordinate for .....
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(ctotngst).endText();
                    x = 168; // X-coordinate for total amt without gst
                    y = 360; // Y-coordinate for .....
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(ctotngst).endText();
                    
                    x = 390; // X-coordinate for total amt wiyhoutgst
                    y = 598; // Y-coordinate for...
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(ctotngst).endText();
                    

                    
                    x = 280; // X-coordinate for rate 
                    y = 596; // Y-coordinate for...
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(crate).endText();

                    double sgst=Double.parseDouble(gst);
                    double sgstpr=gst5;
//                    double cgst=Double.parseDouble("5");
                    
                    x = 460; // X-coordinate gst in price
                    y = 598; // Y-coordinate ....
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr)).endText();
                    
                    
                    System.out.println(sgst);
                    
                    x = 430; // X-coordinate for gst
                    y = 459; // Y-coordinate for .....
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgst+"%")).endText();
                    
                    x = 287; // X-coordinate for total amt without gst
                    y = 373; // Y-coordinate for .....
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgst+"%")).endText();


                   
                   
                    x = 525; // X-coordinate for gst half price
                    y = 458; // Y-coordinate for .....
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr)).endText();
                    
                    
                    x = 400; // X-coordinate for gst half price
                    y = 373f; // Y-coordinate for .....
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr)).endText();

                    x = 510; // X-coordinate for gst half price
                    y = 373; // Y-coordinate for .....
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(sgstpr)).endText();
                    
                    x = 519; // X-coordinate total with gst in price
                    y = 598; // Y-coordinate ....
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(btotal)).endText();
                    x = 519; // X-coordinate total with gst in price
                    y = 430; // Y-coordinate ....
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(btotal)).endText();
                    x = 523; // X-coordinate total with gst in price
                    y = 346; // Y-coordinate ....
                    canvas.beginText().setFontAndSize(font, 10).moveText(x, y).showText(String.valueOf(btotal)).endText();
                    
                   
                    // Close the Document
                    document.close();

                    // Close the PdfDocument (this will also close the writer)
                    pdfDocument.close();

                    System.out.println("Text added successfully.");
                    openPdf(outputFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

    }

    public static void openPdf(String path) {
        try {
            File file = new File(path);
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
                Desktop.getDesktop().open(file);
            } else {
                System.out.println("CANT OPEN ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Define the openPdf method here

    // ... (other methods and code)
}