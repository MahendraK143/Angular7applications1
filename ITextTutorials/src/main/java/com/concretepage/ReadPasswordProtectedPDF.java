package com.concretepage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class ReadPasswordProtectedPDF {
	public static void main(String[] args) throws FileNotFoundException, DocumentException, IOException {
	   PdfReader reader = new PdfReader("PDFwithPasswordOne.pdf", "cp123".getBytes());
	   PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("NoPasswordPDF.pdf"));
	   stamper.close();
	   reader.close();
	   System.out.println("Done");
	}
}
