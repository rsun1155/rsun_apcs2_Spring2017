package textExcel;

import java.util.Arrays;

// Ryan Sun 2nd Period 3/5/2017
// This class controls the behavior of the overall spreadsheet of the TextExcel project

public class Spreadsheet implements Grid
{
	private Cell [][] spreadsheet;
	public Spreadsheet() {
		spreadsheet = new Cell [20][12];
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
		String [] parseCommand = command.split(" ");
			if (parseCommand.length == 1) {
				int [] dimensions = getLoc(parseCommand[0]);
				
				return spreadsheet[dimensions[0]][dimensions[1]].fullCellText();
			}
			else if (parseCommand.length>1 && parseCommand[1].equals("=")) {
				int [] dimensions = getLoc(parseCommand[0]);
				String text = parseCommand[2];
				for (int count = 3; count < parseCommand.length; count++){
					text += " " + parseCommand[count];
				}
				spreadsheet[dimensions[0]][dimensions[1]] = new TextCell(text);
				return getGridText();
				
			}
			else if (parseCommand[0].contains("clear") && parseCommand.length == 1) {
				clearSheet();
				return getGridText();
			}
			else if (parseCommand[0].equals("clear")) {
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
		
		return spreadsheet.length;
	}

	@Override
	public int getCols()
	{
		
		return spreadsheet[0].length;
	}

	@Override
	public Cell getCell(Location loc)
	{
		
		return spreadsheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String [][] fauxArray = new String [20][12];
		for (int i = 0; i < spreadsheet.length; i++) {
			for (int j = 0; j < spreadsheet[0].length; j++) {
				fauxArray[i][j] = (spreadsheet[i][j].abbreviatedCellText());
		
			}
		}
		
		return Arrays.deepToString(fauxArray);
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
	}
