package textExcel;

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
