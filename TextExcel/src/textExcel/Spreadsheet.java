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
		
			if (!command.equals("")) {
		String [] parseCommand = command.split(" ");
				if (parseCommand.length == 1) { //clear whole spreadsheet
					if (parseCommand[0].toLowerCase().equals("clear")) {
						clearSheet();
						return getGridText();
					}
					else { //Display Cell
						SpreadsheetLocation loc = getLoc(parseCommand[0]);
						return getCell(loc).fullCellText();
					}
			}
				else if (parseCommand.length == 2) { //clear a single cell
					SpreadsheetLocation loc = getLoc(parseCommand[1]);
					spreadsheet[loc.getRow()][loc.getCol()] = new EmptyCell();
					return getGridText();
				}
				else if (parseCommand.length >= 3) {
					SpreadsheetLocation loc = getLoc(parseCommand[0]);
					String longString = parseCommand[2];
					for (int i = 3; i < parseCommand.length; i++) {
						longString += " " + parseCommand[i];
					}
					if (parseCommand[2].contains("%") && !parseCommand[2].contains("\"")) { //Percent Cell
						
						spreadsheet[loc.getRow()][loc.getCol()] = new PercentCell(parseCommand[2]);
						
					}
					else if (parseCommand.length > 3 && parseCommand[2].equals("+") || parseCommand[2].equals("-") || parseCommand[2].equals("*") ||parseCommand[2].equals("/")) {
						spreadsheet[loc.getRow()][loc.getCol()] = new FormulaCell(longString);
						//Formula Cell
					}
					else if (!parseCommand[2].contains("\"")) {
						spreadsheet[loc.getRow()][loc.getCol()] = new ValueCell(parseCommand[2]);
						//Value Cell
					}
					else {
						spreadsheet[loc.getRow()][loc.getCol()] = new TextCell(longString);
					} //Text Cell
					return getGridText();
				}
				else {
					return "";
				}
			}
			else {
				return "";
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
				if (spreadsheet[i][j].abbreviatedCellText().contains("\"")) {
				fauxArray += "|" + spreadsheet[i][j].abbreviatedCellText().replace("\"", " ");
				}
				else {
					fauxArray += "|" + spreadsheet[i][j].abbreviatedCellText();
					}
			}
			fauxArray += "|\n";
		}		
			return fauxArray;
		
	}
	public SpreadsheetLocation getLoc(String command) {
		SpreadsheetLocation loc = new SpreadsheetLocation(command);
		return loc;
	}
	public void clearSheet() {
		for (int i = 0; i < spreadsheet.length; i++) {
			for (int j = 0; j < spreadsheet[0].length; j++) {
				spreadsheet[i][j] = new EmptyCell();
			}
		}
	}
	public void clearCell(Location location) {
		this.spreadsheet[location.getRow()][location.getCol()] = new EmptyCell();
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
	
