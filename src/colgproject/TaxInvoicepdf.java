package colgproject;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfCopy;
import com.lowagie.text.pdf.PdfImportedPage;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
//import com.itextpdf.layout.Document;
//import com.lowagie.text.pdf.PdfWriter;
//import com.itextpdf.text.Paragraph;


public class TaxInvoicepdf {
    public static void main(String[] args) {
//        PdfWriter pdfwriter=new PdfWriter();
    	try {
    		String ogpath="C:\\Users\\Rayyan\\Documents\\tax invoice\\originalsample"+File.separator+"gstsamp2.pdf";
    		String dppath="C:\\Users\\Rayyan\\Documents\\tax invoice"+File.separator+"notedited.pdf";
    		Document doc=new Document();
//    		PdfReader originalPdf=new PdfReader(ogpath);//original pdf
    		PdfCopy pdfcopy=new PdfCopy(doc,new FileOutputStream(dppath));
    		doc.open();
    		PdfReader originalPdf=new PdfReader(ogpath);//original pdf
    		int numpage=originalPdf.getNumberOfPages();
    		PdfImportedPage page =pdfcopy.getImportedPage(originalPdf, 1);
    		pdfcopy.addPage(page);
    		
//        PdfStamper pdfcopy=new PdfStamper(originalPdf,new FileOutputStream("edited3.pdf"));
//        OutputStream outputstream=new FileOutputStream("C:\\Users\\Rayyan\\Documents\\tax invoice"+File.separator+"edited3.pdf");
//        PdfWriter.getInstance(doc, outputstream);
        Paragraph paragraph=new Paragraph("hello world"); 
        doc.add( paragraph);
        doc.close();
        System.out.print("createwd....");
        openPdf(dppath);
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
        
    }
    private static void openPdf(String path) {
    	try {
    		File file =new File (path);
    		if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
    			Desktop.getDesktop().open(file);
    			
    		}else {
    			System.out.println("CANT OPEN ");
    		}
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}