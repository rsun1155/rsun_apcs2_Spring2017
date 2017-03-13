package textExcel;

abstract class RealCell implements Cell
{
	String value;

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
	public String fullCellText(double value) {
		return this.value;
	}
	abstract double getDoubleValue();

}
