//Ryan Sun 2/8/17 2nd Period. BJP Textbook Exercise 5 "Tickets"
//Superclass Ticket (abstract)
abstract class Ticket { 
	private int number; //Declaring field for the ticket number
	public Ticket (int n) { //Constructor
		this.number = n;
	}
	public double getPrice() { //getPrice, but since ticket isn't purchasable there is no price for now
		//This method is overridden in all of the subclasses anyway.
		return 0.0;
	}
	public String toString() { //toString
		return "Number: " + this.number + " Price: " + this.getPrice();
	
	}
}
