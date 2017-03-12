package textExcel;

public class TextCell implements Cell {
	String value;
	public TextCell(String text) {
		this.value = text;
	}

	@Override
	public String abbreviatedCellText() {
		String fauxValue = value;
		if (value.length() >= 10) {
			return value.substring(0, 11);
		}
		else { //This is padToTen
			for (int i = value.length(); i < 10; i++) {
				fauxValue += " ";
			}
			return fauxValue;
		}
	}

	@Override
	public String fullCellText() {
		return value;
	}
	public void setValue(String text) {
		value = text;
	}

}
