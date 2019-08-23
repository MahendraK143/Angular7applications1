package com.concretepage;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

public class ReadPDFtoAddPassword {
	public static void main(String[] args) throws FileNotFoundException, DocumentException, IOException {
		  PdfReader reader = new PdfReader("NoPasswordPDF.pdf");
	      PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("PDFwithPasswordTwo.pdf"));
	      stamper.setEncryption("pwd123".getBytes(), "cp123".getBytes(),PdfWriter.ALLOW_COPY, PdfWriter.ENCRYPTION_AES_256);
	      stamper.close();
	      reader.close();
	      System.out.println("Done");
	}
}
