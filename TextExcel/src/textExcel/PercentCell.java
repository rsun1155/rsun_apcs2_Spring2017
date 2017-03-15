package textExcel;

public class PercentCell extends RealCell {

	public PercentCell(String value) {
		this.value = value;
	}
	public double getDoubleValue() {
		String cutValue = value.substring(0, value.length() - 1);
		
		return(Double.parseDouble(cutValue)/100.0);
	}

}
