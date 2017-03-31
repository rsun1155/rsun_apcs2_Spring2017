package textExcel;
//Ryan Sun 2nd Period 3/20/2017 TextExcel 
//This program accepts user input from the console and incorporates that data into the spreadsheet.
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;



public class TextExcel
{

	public static void main(String[] args)
	{
	
		Scanner userInput = new Scanner(System.in);
		String input = userInput.nextLine();
		Spreadsheet excel = new Spreadsheet();
		while (!(input.toLowerCase()).equals("quit")) {
			System.out.println(excel.processCommand(input));
			input = userInput.nextLine();
		}
		userInput.close(); 

	
	}
}
