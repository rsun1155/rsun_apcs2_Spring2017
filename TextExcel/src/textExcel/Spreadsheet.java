package textExcel;

// Update this file with your own code.

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
		// TODO Auto-generated method stub
		String outcome = "";
		String [] parseCommand = command.split(" ");
		for (int i = 0; i<parseCommand.length; i++) {
			SpreadsheetLocation here = new SpreadsheetLocation(parseCommand[0]);
			System.out.println(here.getCol());
		}
		return outcome;
	}

	@Override
	public int getRows()
	{
		// TODO Auto-generated method stub
		return chart.length;
	}

	@Override
	public int getCols()
	{
		// TODO Auto-generated method stub
		return chart[0].length;
	}

	@Override
	public Cell getCell(Location loc)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getGridText()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
