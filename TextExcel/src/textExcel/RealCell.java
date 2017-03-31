package textExcel;
//Ryan Sun 3/20/17 2nd period     class that overarches over any numeric value.
abstract class RealCell implements Cell
{
	private String value;
	
	public String abbreviatedCellText()
	{
		String fauxValue = value;
		if (value.contains("%") && value.contains(".")) {
			fauxValue =	value.replace(value.substring(value.indexOf(".")), "%");
		}
		else if (!value.contains("%")) { 
			fauxValue = Double.parseDouble(value) + "";
		}
	
	
		if (fauxValue.length() > 10) {
			return fauxValue.substring(0, 10);
		}
		else { //This is padToTen
			
			for (int i = fauxValue.length(); i < 10; i++) {
				fauxValue += " ";
			}
			return fauxValue;
		}
	}
	public String fullCellText() {
		String value = getDoubleValue() + "";
			if(getValue().equals("0")) {
				return getValue();
			}
			else if (!value.contains("%") && value.contains(".0") 
					&& isDecimalEqualToZero(value)
					&& value.replace("-", "").length() > 3) {
				return value.substring(0, value.indexOf("."));
			}
			else if (!value.contains("%") && !value.contains(".")) {
				value += ".0";
			}
		return value;
	}
	public String getValue() {
		return this.value;
	}
	public void setValue(String text) {
		this.value = text;
	}
	private boolean isDecimalEqualToZero(String doubleValue) {
		if (doubleValue.contains("%")) {
			return false;
		}
		String[] n = doubleValue.split("\\.");
		if(n.length > 1) {
			// get the value to right of decimal point
			int d = Integer.parseInt(n[1]);
			return d == 0;
		}
		else {
			return true;
		}
		
	}
	abstract double getDoubleValue();

}
