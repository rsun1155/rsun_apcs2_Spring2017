//Ryan Sun 2/8/17 2nd period
public class StudentAdvanceTicket extends AdvanceTicket {

	public StudentAdvanceTicket(int n, int days) {
		super(n, days);
	}
	public double getPrice() {
		return (super.getPrice())/2.0;
	}

}
