package textExcel;

public class TextCell implements Cell {
	String value;
	public TextCell(String text) {
		this.value = text;
	}

	@Override
	public String abbreviatedCellText() {
		
		return value.substring(0, 10);
	}

	@Override
	public String fullCellText() {
		
		return value;
	}
	public void setValue(String text) {
		value = text;
	}

}
