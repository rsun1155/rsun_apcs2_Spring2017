//Ryan Sun 2/8/17 2nd period
public class TicketRunner {

	public static void main(String[] args) {
		WalkupTicket ryan = new WalkupTicket(1140);
		System.out.println(ryan.toString());
		System.out.println(ryan.getPrice());
		AdvanceTicket ferb = new AdvanceTicket(2130, 20);
		System.out.println(ferb.toString());
		AdvanceTicket bulb = new AdvanceTicket(3410, 4);
		System.out.println(bulb.toString());
		StudentAdvanceTicket red = new StudentAdvanceTicket(4251, 4);
		StudentAdvanceTicket bmo = new StudentAdvanceTicket(3140, 12);
		System.out.println(red.toString() + " " + bmo.toString());
		
	}

}
