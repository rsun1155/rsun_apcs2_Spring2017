package textExcel;
//Ryan Sun 2nd period 3/20/17 this class represents a real numeric value not stored as a percent value nor a aritmetic expression
public class ValueCell extends RealCell {
	public ValueCell(String input) {
		setValue(input);
	}
	public double getDoubleValue() {
		double holder = Double.parseDouble(this.getValue());
		return holder;
	}

}
