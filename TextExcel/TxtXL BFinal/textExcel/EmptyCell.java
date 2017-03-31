package textExcel;
//Ryan Sun 2nd Period 3/20/17 class that represents a blank cell in the spreadsheet.
public class EmptyCell implements Cell {
	public EmptyCell () {
		
	}

	@Override
	public String abbreviatedCellText() {

		return "          ";
	}

	@Override
	public String fullCellText() {
	
		return "";
	}

}
