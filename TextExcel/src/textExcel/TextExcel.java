package textExcel;
//Ryan Sun 2nd Period 3/5/2017 TextExcel 
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;



public class TextExcel
{

	public static void main(String[] args)
	{
	
		/*Scanner userInput = new Scanner(System.in);
		String input = userInput.next();
		Spreadsheet excel = new Spreadsheet();
		while (!input.equals("quit")) {
			System.out.println(excel.processCommand(input));
			input = userInput.next();
		}
		userInput.close();*/
		Spreadsheet excel = new Spreadsheet();
		Cell tester = new TextCell("meow");
		System.out.println(excel.getGridText());
		int [] [] ten ={{1}, {2, 3}};
		System.out.println(Arrays.deepToString(ten));
	}
}
