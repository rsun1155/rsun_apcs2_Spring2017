package textExcel;
//Ryan Sun 2nd Period 3/5/17
public class EmptyCell implements Cell {
	public EmptyCell () {
		
	}

	@Override
	public String abbreviatedCellText() {

		return "|          ";
	}

	@Override
	public String fullCellText() {
	
		return "";
	}

}
