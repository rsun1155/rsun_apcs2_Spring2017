package textExcel;

abstract class RealCell implements Cell
{
	private String value;
	
	public String abbreviatedCellText()
	{
		
		value = getDoubleValue() + "";
		if (value.length() > 10) {
			return value.substring(0, 10);
		}
		else { //This is padToTen
			String fauxValue = value;
			for (int i = value.length(); i < 10; i++) {
				fauxValue += " ";
			}
			return fauxValue;
		}
	}
	public String fullCellText() {
		return "" + getDoubleValue();
	}
	public String getValue() {
		return this.value;
	}
	public void setValue(String text) {
		this.value = text;
	}
	abstract double getDoubleValue();

}
