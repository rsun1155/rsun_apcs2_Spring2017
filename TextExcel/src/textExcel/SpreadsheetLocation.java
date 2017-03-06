package textExcel;

//Ryan Sun 2nd period 3/5/2017

public class SpreadsheetLocation implements Location
{
	int col = 0;
	int row = 0;
	Cell cellHere;
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


