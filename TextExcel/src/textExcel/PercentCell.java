package textExcel;

public class PercentCell extends RealCell {

	public PercentCell(String value) {
		setValue(value);
	}
	public double getDoubleValue() {
		String cutValue = getValue().substring(0, getValue().length() - 1);
		
		return(Double.parseDouble(cutValue)/100.0);
	}

}
