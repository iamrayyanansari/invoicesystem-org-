package colgproject;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileOutputStream;

public class pdf {
    public static void main(String[] args) {
        // Create a Document object
        Document document = new Document();

        try {
            // Specify the file path where you want to save the PDF
            PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));

            // Open the document for writing
            document.open();

            // Add "Hello, World!" as a paragraph to the document
            document.add(new Paragraph("Hello, World!"));

            // Close the document
            document.close();

            System.out.println("PDF created successfully.");
        } catch (DocumentException | java.io.IOException e) {
            e.printStackTrace();
        }
    }
}