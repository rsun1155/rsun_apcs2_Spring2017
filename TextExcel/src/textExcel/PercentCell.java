package textExcel;

public class PercentCell extends RealCell {
	private String value;
	public PercentCell(String value) {
		this.value = value;
	}
	public double getDoubleValue() {
		String cutValue = value.substring(0, value.length() - 1);
		
		return(Double.parseDouble(cutValue)/100.0);
	}
	@Override
	public String fullCellText() {
		return getDoubleValue();
	}
}
