package textExcel;

//Ryan Sun 2nd period 3/5/2017

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
    	
    		col = cellName.charAt(0) - 'A';
    		row = Integer.parseInt(cellName.substring(1)) - 1;
    		
    	}

    }


