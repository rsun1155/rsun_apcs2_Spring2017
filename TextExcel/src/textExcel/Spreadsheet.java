package textExcel;

import java.util.Arrays;

// Ryan Sun 2nd Period 3/5/2017
// This class controls the behavior of the overall spreadsheet of the TextExcel project

public class Spreadsheet implements Grid
{
	private Cell [][] chart;
	public Spreadsheet() {
		chart = new Cell [20][12];
		for (int i = 0; i < chart.length; i++) {
			for (int j = 0; j < chart[0].length; j++) {
				chart[i][j] = new EmptyCell();
			}
		}
		
	}
	@Override
	public String processCommand(String command)
	{
		
		String outcome = "";
		String [] parseCommand = command.split(" ");
				SpreadsheetLocation c = new SpreadsheetLocation(parseCommand[0]);
			//Remember to return here
			
				return outcome;
	}

	@Override
	public int getRows()
	{
		
		return chart.length;
	}

	@Override
	public int getCols()
	{
		
		return chart[0].length;
	}

	@Override
	public Cell getCell(Location loc)
	{
		
		return ((SpreadsheetLocation)loc).getCellHere();
	}

	@Override
	public String getGridText()
	{
		for (int i = 0; i < chart.length; i++) {
			for (int j = 0; j < chart[0].length; j++) {
		
			}
		}
		
		return Arrays.deepToString(chart);
	}

}
