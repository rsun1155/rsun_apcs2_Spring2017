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
		String input = userInput.nextLine();
		Spreadsheet excel = new Spreadsheet();
		while (!(input.toLowerCase()).equals("quit")) {
			System.out.println(excel.processCommand(input));
			input = userInput.nextLine();
		}
		userInput.close(); */

		PercentCell hi = new PercentCell("89.00%");
		System.out.println(hi.fullCellText());
		ValueCell value = new ValueCell("8.000");
		System.out.println(value.fullCellText());
	}
}
