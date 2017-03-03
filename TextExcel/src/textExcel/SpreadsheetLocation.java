package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	int col = 0;
	int row = 0;
	String rowHolder = "";
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return this.row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return this.col;
    }
    
    public SpreadsheetLocation(String cellName)
    {
    	
    		col = cellName.charAt(0) - 'A';
    		for (int i = 1; i < cellName.length(); i++) {
    			rowHolder += cellName.charAt(i);
    		}
    		row = Integer.parseInt(rowHolder) - 1;
    		
    	}
    }


