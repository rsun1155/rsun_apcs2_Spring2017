package textExcel;

public class ValueCell extends RealCell {
	public ValueCell(String input) {
		value = input;
	}
	public double getDoubleValue() {
		double holder = Double.parseDouble(value) * 1.0;
		return holder;
	}

}
