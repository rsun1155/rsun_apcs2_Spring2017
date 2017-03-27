package textExcel;
//Ryan Sun 2nd period 3/20/17 This class represents a arithmetic expression passed into the spreadsheet
public class FormulaCell extends RealCell {
	public FormulaCell (String text) {
		 setValue(text);
	}

	
	double getDoubleValue() {
		String value = this.getValue().substring(2, getValue().length() - 2);
		String [] expression = value.split(" ");
		double standingValue = Double.parseDouble(expression[0]);
		for (int i = 1; i < expression.length; i++) {
			if (expression[i].equals("*")) 
				standingValue *= Double.parseDouble(expression[i + 1]);
			else if (expression[i].equals("/")) 
				standingValue /= Double.parseDouble(expression[i + 1]);
			else if (expression[i].equals("+"))
				standingValue += Double.parseDouble(expression[i + 1]);
			else if (expression[i].equals("-"))
				standingValue -= Double.parseDouble(expression[i + 1]);
			else {
				
			}
		}
				
			return standingValue;
		}
	
	public String abbreviatedCellText() {
		String value = getDoubleValue() + "";
		if (value.length() > 10) {
			return value.substring(0, 10);
		}
		else {
			for (int i = value.length(); i < 10; i++) {
				value += " ";
			}
		return value;
		}
	}
	public String fullCellText() {
		return getValue();
	}
}
