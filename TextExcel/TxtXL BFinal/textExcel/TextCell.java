package textExcel;
// Ryan Sun 2nd period  3/20/17   this class represents literal text passed into the spreadsheet
public class TextCell implements Cell {
	String value;
	public TextCell(String text) {
		this.value = text;
	}

	@Override
	public String abbreviatedCellText() {
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

	@Override
	public String fullCellText() {
		return value;
	}
	public void setValue(String text) {
		value = text;
	}

}
