
//Ryan Sun 2nd period 2/8/17
public class AdvanceTicket extends Ticket {
	private int days; //field to determine how many days before the event
	public AdvanceTicket(int n, int days) {
		super(n);
		this.days = days;
	}
	public double getPrice()  { //AdvanceTicket prices are dependent on how far in advance the ticket is purchased.
		if (days >= 10) //If the ticket is bought ten days or earlier the price is $30
			return 30.0;
		else 
			return 40.0; //If the ticket is bought later than ten days before the event, the price is $40
	}

}
