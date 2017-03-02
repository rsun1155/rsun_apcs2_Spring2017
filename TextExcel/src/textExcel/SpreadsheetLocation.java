package textExcel;

//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	int col = 0;
	int row = 0;
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
    	for (int i = 0; i < cellName.length(); i++) {
    		col = cellName.charAt(0) - 'A';
    		row = Character.getNumericValue(cellName.charAt(1));
    	}
    }

}
