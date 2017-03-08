package textExcel;

public class TextCell implements Cell {
	String value;
	public TextCell(String text) {
		this.value = text;
	}

	@Override
	public String abbreviatedCellText() {
		if (value.length() >= 10) {
			return "|" + value.substring(0, 10) + "|";
		}
		else { //This is padToTen
			for (int i = value.length(); i < 10; i++) {
				value += " ";
			}
			return "|" + value + "|";
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
