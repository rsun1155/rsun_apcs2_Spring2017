package textExcel;

import java.util.Arrays;
import java.util.*;
import java.io.*;
// Ryan Sun 2nd Period 3/5/2017
// This class controls the behavior of the overall spreadsheet of the TextExcel project

public class Spreadsheet implements Grid {
	private Cell[][] spreadsheet;

	public Spreadsheet() {
		spreadsheet = new Cell[this.getRows()][this.getCols()];
		for (int i = 0; i < spreadsheet.length; i++) {
			for (int j = 0; j < spreadsheet[0].length; j++) {
				spreadsheet[i][j] = new EmptyCell();
			}
		}

	}

	@Override
	public String processCommand(String command) {

		if (!command.equals("")) {
			String[] parseCommand = command.split(" ");
			if (parseCommand.length == 1) { // clear whole spreadsheet
				if (parseCommand[0].toLowerCase().equals("clear")) {
					clearSheet();
					return getGridText();
				} else { // Display Cell
					SpreadsheetLocation loc = getLoc(parseCommand[0]);
					return getCell(loc).fullCellText();
				}
			} else if (parseCommand.length == 2) { // clear a single cell
				if (parseCommand[0].equals("save")) {
					return saveFile(parseCommand[1]);
				} else if (parseCommand[0].equals("open")) {
					return openFile(parseCommand[1]);
				}
				SpreadsheetLocation loc = getLoc(parseCommand[1]);
				spreadsheet[loc.getRow()][loc.getCol()] = new EmptyCell();
				return getGridText();
			} else if (parseCommand.length >= 3) {
				SpreadsheetLocation loc = getLoc(parseCommand[0]);
				String longString = parseCommand[2];
				for (int i = 3; i < parseCommand.length; i++) {
					longString += " " + parseCommand[i];
				}

				if (parseCommand[2].contains("%") && !parseCommand[2].contains("\"")) { // Percent
																						// Cell

					spreadsheet[loc.getRow()][loc.getCol()] = new PercentCell(parseCommand[2]);

				} else if (parseCommand.length > 3 && parseCommand[2].equals("+") || parseCommand[2].equals("-")
						|| parseCommand[2].equals("*") || parseCommand[2].equals("/")) {
					spreadsheet[loc.getRow()][loc.getCol()] = new FormulaCell(longString);
					// Formula Cell
				} else if (!parseCommand[2].contains("\"")) {
					spreadsheet[loc.getRow()][loc.getCol()] = new ValueCell(parseCommand[2]);
					// Value Cell
				} else {
					spreadsheet[loc.getRow()][loc.getCol()] = new TextCell(longString);
				} // Text Cell
				return getGridText();
			} else {
				return "";
			}
		} else {
			return "";
		}

	}

	@Override
	public int getRows() {

		return 20;
	}

	@Override
	public int getCols() {

		return 12;
	}

	@Override
	public Cell getCell(Location loc) {

		return spreadsheet[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText() {
		String fauxArray = getTopRow();
		for (int i = 0; i < this.getRows(); i++) {
			if (i < 9) {
				fauxArray += i + 1 + "  ";
			} else {
				fauxArray += i + 1 + " ";
			}
			for (int j = 0; j < this.getCols(); j++) {
				if (spreadsheet[i][j].abbreviatedCellText().contains("\"")) {
					fauxArray += "|" + spreadsheet[i][j].abbreviatedCellText().replace("\"", " ");
				} else {
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

	public String getTopRow() {
		String topRow = "   ";
		for (char i = 'A'; i <= 'L'; i++) {
			topRow += "|" + i + "         ";
		}
		topRow += "|\n";
		return topRow;
	}

	public String saveFile(String filename) {
		PrintStream outputFile;
		try {
			outputFile = new PrintStream(new File(filename));
		} catch (FileNotFoundException e) {
			return "File not found: " + filename;
		}
		for (int i = 0; i < this.getRows(); i++) {
			for (int j = 0; i < this.getCols(); i++) {
				Cell cell = spreadsheet[i][j];
				if (! (cell instanceof EmptyCell)) {
				String location = String.valueOf(j + 'A') + String.valueOf(i);
				outputFile.println(location + "," + getCellType(cell) + "," + cell.fullCellText());
				}
			}
		}
		outputFile.close();
		return "Done saving?";
	}

	public String openFile(String filename) {
		Scanner inputFile;
		try {
			inputFile = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			return "File not found: " + filename;
		}
		while (inputFile.hasNextLine()) {
			String input = inputFile.nextLine();
			String[] command = input.split(" ");
			SpreadsheetLocation loc = getLoc(command[0]);
			Cell cell = new EmptyCell(); // Just to get Java to initialize it
			if (command[1].equals("TextCell")) {
				cell = new TextCell(command[2]);

			} else if (command[1].equals("ValueCell")) {
				cell = new ValueCell(command[2]);
			} else if (command[1].equals("FormulaCell")) {
				cell = new FormulaCell(command[2]);
			} else if (command[1].equals("PercentCell")) {
				cell = new PercentCell("command[2]");
			}
			spreadsheet[loc.getRow()][loc.getCol()] = cell;

		}
		inputFile.close();
		return "All done!";
	}

	public String getCellType(Cell cell) {
		if (cell instanceof TextCell) {
			return "TextCell";
		} else if (cell instanceof FormulaCell) {
			return "FormulaCell";
		} else if (cell instanceof ValueCell) {
			return "ValueCell";
		} else if (cell instanceof PercentCell) {
			return "PercentCell";
		} else {
			return "";
		}
	}
}
