package textExcel;

public class FormulaCell extends RealCell {
	public FormulaCell (String text) {
		 setValue(text);
	}

	
	double getDoubleValue() {
		return 0;
	}
}
