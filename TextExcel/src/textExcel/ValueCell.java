package textExcel;

public class ValueCell extends RealCell {
	public ValueCell(String input) {
		setValue(input);
	}
	public double getDoubleValue() {
		double holder = Double.parseDouble(getValue()) * 1.0;
		return holder;
	}

}
