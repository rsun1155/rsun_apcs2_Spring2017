package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    // Add your command loop here
		Scanner userInput = new Scanner(System.in);
		String input = userInput.next();
		Spreadsheet excel = new Spreadsheet();
		while (!input.equals("quit")) {
			excel.processCommand(input);
			input = userInput.next();
		}
		userInput.close();
	}
}
