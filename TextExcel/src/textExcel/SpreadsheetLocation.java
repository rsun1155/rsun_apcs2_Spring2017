package textExcel;

//Ryan Sun 2nd period 3/20/2017 class that represents a location on the spreadsheet storing the row and the column.

public class SpreadsheetLocation implements Location
{
	
	private int col = 0;
	private int row = 0;
    @Override
    public int getRow()
    {
  
        return this.row;
    }

    @Override
    public int getCol()
    {
   
        return this.col;
    }
    
    public SpreadsheetLocation(String cellName)
    {
    		cellName = cellName.toUpperCase();
    		col = cellName.charAt(0) - 'A';
    		row = Integer.parseInt(cellName.substring(1)) - 1;
    		
    	}
    
    }


