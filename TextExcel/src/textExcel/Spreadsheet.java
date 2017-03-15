package textExcel;

import java.util.Arrays;

// Ryan Sun 2nd Period 3/5/2017
// This class controls the behavior of the overall spreadsheet of the TextExcel project

public class Spreadsheet implements Grid
{
	private Cell [][] spreadsheet;
	public Spreadsheet() {
		spreadsheet = new Cell [this.getRows()][this.getCols()];
		for (int i = 0; i < spreadsheet.length; i++) {
			for (int j = 0; j < spreadsheet[0].length; j++) {
				spreadsheet[i][j] = new EmptyCell();
			}
		}
		
	}
	@Override
	public String processCommand(String command)
	{
		
		String outcome = "";
			if (command.equals("")) {
				return ""; 
			}
		String [] parseCommand = command.split(" ");
			if (parseCommand.length > 3 && (parseCommand[2].contains("+")||parseCommand[3].contains("-")||parseCommand[1].contains("*")||parseCommand[1].contains("/"))) {
				int [] dimensions = getLoc(parseCommand[0]);
				String inputText = "";
				for (int i = 2; i < parseCommand.length; i++) {
					inputText += parseCommand[i];
				}
				spreadsheet[dimensions[0]][dimensions[1]] = new FormulaCell(inputText);
				return getGridText();
			}
			else if (parseCommand.length == 3 && parseCommand[2].contains("%")){
				int [] dimensions = getLoc(parseCommand[0]);
				spreadsheet[dimensions[0]][dimensions[1]] = new PercentCell(parseCommand[2]);
				return getGridText();
			}
			else if (parseCommand.length == 3 && parseCommand[2].contains(".")) {
				int [] dimensions = getLoc(parseCommand[0]);
				spreadsheet[dimensions[0]][dimensions[1]] = new ValueCell(parseCommand[2]);
				return getGridText();
			}
			else if (parseCommand.length == 1 && !parseCommand[0].toLowerCase().contains("clear") && !parseCommand[0].equals("")) {
				int [] dimensions = getLoc(parseCommand[0]);
				
				return spreadsheet[dimensions[0]][dimensions[1]].fullCellText();
			}
			else if (parseCommand.length>2 && parseCommand[1].equals("=")) {
				int [] dimensions = getLoc(parseCommand[0]);
				String text = parseCommand[2];
				for (int count = 3; count < parseCommand.length; count++){
					text += " " + parseCommand[count];
				}
					if (!text.equals("")) {
				spreadsheet[dimensions[0]][dimensions[1]] = new TextCell(text);
					return getGridText();
					}
				else {
					return getGridText();
				}
				
			}
			else if (parseCommand[0].toLowerCase().contains("clear") && parseCommand.length == 1) {
				clearSheet();
				return getGridText();
			}
			else if (parseCommand[0].toLowerCase().equals("clear")) {
				clearCell(parseCommand[1]);
				return getGridText();
			}
			else {
			
				return outcome;
			}
	}

	@Override
	public int getRows()
	{
		
		return 20;
	}

	@Override
	public int getCols()
	{
		
		return 12;
	}

	@Override
	public Cell getCell(Location loc)
	{
		
		return spreadsheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String fauxArray = getTopRow();
		for (int i = 0; i < this.getRows(); i++) {
			if (i < 9) {
			fauxArray += i + 1 + "  ";
			}
			else {
			fauxArray += i + 1 + " ";
			}
			for (int j = 0; j < this.getCols(); j++) {
				fauxArray += "|" + spreadsheet[i][j].abbreviatedCellText().replace("\"", " ");
			}
			fauxArray += "|\n";
		}		
			return fauxArray;
		
	}
	public int [] getLoc(String command) {
		SpreadsheetLocation loc = new SpreadsheetLocation(command);
		int [] dimensions = {loc.getRow(), loc.getCol()};
		return dimensions;
	}
	public void clearSheet() {
		for (int i = 0; i < spreadsheet.length; i++) {
			for (int j = 0; j < spreadsheet[0].length; j++) {
				spreadsheet[i][j] = new EmptyCell();
			}
		}
	}
	public void clearCell(String location) {
		int [] dimensions = getLoc(location);
		this.spreadsheet[dimensions[0]][dimensions[1]] = new EmptyCell();
	}
	public String getTopRow (){
		String topRow = "   ";
		for (char i = 'A'; i <= 'L'; i++) {
			topRow += "|" + i + "         ";
		}
		topRow += "|\n";
		return topRow;
		}
	}
	
