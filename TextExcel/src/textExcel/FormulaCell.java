package textExcel;

public class FormulaCell extends RealCell {
	public FormulaCell (String text) {
		value = text;
	}

	
	double getDoubleValue() {
		return 0;
	}
}
