package textExcel;

abstract class RealCell implements Cell
{
	private String value;
	
	public String abbreviatedCellText()
	{
		String fauxValue = value.replace("\"", "");
		if (value.length() >= 11) {
			return value.substring(1, 11);
		}
		else { //This is padToTen
			for (int i = value.length(); i < 12; i++) {
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
	public void setValue(String text)
	abstract double getDoubleValue();

}
