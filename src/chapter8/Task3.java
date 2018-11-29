package chapter8;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Task3 {
	
	public static final String INPUT_FILE_PATH = "/test.java";
	public static final String OUTPUT_FILE_PATH = "/nocomment.java";
	
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		Scanner ioScanner = new Scanner(new File(INPUT_FILE_PATH));
		ioScanner.useDelimiter("");
		
		PrintWriter writer = new PrintWriter(OUTPUT_FILE_PATH, "UTF-8");

		int state = 0;
		char lastChar = 0;
		
		while(ioScanner.hasNext()) {
			char currentChar = ioScanner.next().charAt(0);
			
				
			switch(state) {
				case 0:
					if(currentChar == '/') state = 1;
					else writer.print(currentChar);
					break;
				case 1:
					if(currentChar == '/') state = 2;
					else if(currentChar == '*') state = 3;
					else {
						state = 0;
						writer.print(lastChar + "" + currentChar);
					}
					break;
				case 2:
					if(currentChar == '\n') state = 0;
					break;
				case 3:
					if(lastChar == '*' && currentChar == '/') state = 0;
					break;
			}
			
			lastChar = currentChar;
		}
		
		ioScanner.close();
		writer.close();
		
		System.out.println("Transcripited file '" + INPUT_FILE_PATH + "' to '" + OUTPUT_FILE_PATH + "'.");
	}
}
