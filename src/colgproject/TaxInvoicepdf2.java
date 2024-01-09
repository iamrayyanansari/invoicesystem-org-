package colgproject;
import javax.swing.*;
import java.awt.Desktop;
import java.io.File;
import java.time.LocalDate;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

public class TaxInvoicepdf2 {
static	String name;
static	String gstin;
static	String address;
static	String hsnCode; 
static String hsnDescription;
static	String docno;
static	String pieces;
static	String quty;
static	String crate;
static	String ctotngst;
static	String gst;
static	double gst5;
static	String btotal;
static LocalDate currdate = LocalDate.now();
static String date=currdate.toString();



public void setData(String gstin,String name,String address,String hsnCode, String hsnDescription,String docno,
		String piece,String quty,String crate,String ctotngst,String gst,double gst5,String btotal) {
	this.gstin=gstin;
	this.name=name;
	this.address=address;
	this.hsnCode=hsnCode;
	this.hsnDescription=hsnDescription;
	this.docno=docno;
	this.pieces=pieces;
	this.quty=quty;
	this.crate=crate;
	this.ctotngst=ctotngst;
	this.gst=gst;
	this.gst5=gst5;
	this.btotal=btotal;
	
	System.out.println("GSTIN :"+gstin);
System.out.println("Name :"+name);
System.out.println("Party address :"+address);
System.out.println("hsn code :"+hsnCode);
System.out.println("description :"+hsnDescription);
System.out.println("invoice no :"+docno);
System.out.println("no of pieces(in-no):"+pieces);
System.out.println("Quantity :"+quty);
System.out.println("Rate :"+crate);
System.out.println("without gst total :"+ctotngst);
System.out.println("gst rate"+gst);
System.out.println("gst (in price) :"+gst5);
System.out.println("total with price"+btotal);
}    
public static void main(String[] args) {
        // Input and Output PDF file paths
        String inputFile ="C:\\Users\\Rayyan\\Documents\\tax invoice\\originalsample"+File.separator+"gstsamp2.pdf";
        String outputFile = "C:\\Users\\Rayyan\\Documents\\tax invoice"+File.separator+docno+".pdf";
        
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
            Paragraph paragraph = new Paragraph("Sumesh enterprises.");
            paragraph.setMarginLeft(10);
            paragraph.setMarginTop(80);
            paragraph.setFontSize(10);
            document.add(paragraph);
            

            Paragraph datee= new Paragraph(date);
//            datee.setAb
            datee.setMarginLeft(400);
            datee.setMarginTop(1f);
            datee.setFontSize(10);
            document.add(datee);
            
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
    
    public void setPdf() {
    	if(gstin.startsWith("27")) {
//    		file:///C:/Users/Rayyan/OneDrive/Documents/tax%20invoice/orgs/gstSample.pdf
    	String inputFile ="C:\\Users\\Rayyan\\OneDrive\\Documents\\tax invoice\\orgs"+File.separator+"gstSample.pdf";
    	String outputFile = "C:\\Users\\Rayyan\\OneDrive\\Documents\\tax invoice"+File.separator+docno+".pdf";
        
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
            Paragraph paragraph = new Paragraph("Sumesh enterprises.");
            paragraph.setMarginLeft(10);
            paragraph.setMarginTop(80);
            paragraph.setFontSize(10);
            document.add(paragraph);
            
            Paragraph datee= new Paragraph();
            datee.setMarginLeft(10);
            datee.setMarginTop(80);
            datee.setFontSize(10);
            document.add(datee);
           
            
            // Close the Document
            document.close();
            
            // Close the PdfDocument (this will also close the writer)
            pdfDocument.close();
            
            System.out.println("Text added successfully.");
            openPdf(outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    	}else {
    		String inputFile ="C:\\Users\\Rayyan\\OneDrive\\Documents\\tax invoice\\orgs"+File.separator+"igstSample.pdf";
        	String outputFile = "C:\\Users\\Rayyan\\OneDrive\\Documents\\tax invoice"+File.separator+docno+".pdf";
            
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
                Paragraph datee= new Paragraph();
                datee.setMarginLeft(10);
                datee.setMarginTop(80);
                datee.setFontSize(10);
                document.add(datee);
               
                
                Paragraph partyName = new Paragraph("Sumesh enterprises.");
                partyName.setMarginLeft(10);
                partyName.setMarginTop(80);
                partyName.setFontSize(10);
                document.add(partyName);
                document.add(partyName);
                
                Paragraph partyGst = new Paragraph("08AQFHGTYIOJUYRG");
                partyGst.setMarginLeft(10);
                partyGst.setMarginTop(80);
                partyGst.setFontSize(10);
                document.add(partyGst);
               
                Paragraph partyAdd = new Paragraph(" bala compound , bhiwandi -421 302,Maharashtra");
                partyAdd.setMarginLeft(10);
                partyAdd.setMarginTop(80);
                partyAdd.setFontSize(10);
                document.add(partyAdd);
               
                // Close the Document
                
                document.close();
                
                // Close the PdfDocument (this will also close the writer)
                pdfDocument.close();
                
                System.out.println("Text added successfully.");
                openPdf(outputFile);
            } catch (Exception e) {
                e.printStackTrace();
            }	}
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
}