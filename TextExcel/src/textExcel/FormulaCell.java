package textExcel;
//Ryan Sun 2nd period 3/20/17 This class represents a arithmetic expression passed into the spreadsheet
public class FormulaCell extends RealCell {
	public FormulaCell (String text) {
		 setValue(text);
	}

	
	double getDoubleValue() {
		return 0;
	}
	
	public String abbreviatedCellText() {
		return getValue();
	}
	public String fullCellText() {
		return getValue();
	}
}
