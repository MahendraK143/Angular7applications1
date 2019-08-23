package com.file;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageReadAndWrite {
	public static void main(String args[]) throws IOException {
		int width = 963; // width of the image
		int height = 640; // height of the image
		BufferedImage image = null;
		File f = null;

		// read image
		try {
			
			//f = new File("D:\\Image\\Taj.jpg");
      			//image = ImageIO.read(f);
			//or
			f = new File("C://Users//698675//Documents/mahendra.jpg"); // image file path
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			image = ImageIO.read(f);
			System.out.println("Reading complete.");
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}

		// write image
		try {
			f = new File("D://Examples/Java8fFeatures/src/images/mahendra.jpg"); // output file path
			ImageIO.write(image, "jpg", f);
			System.out.println("Writing complete.");
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}// main() ends here
}// class ends here
