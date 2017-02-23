//Ryan Sun 2nd Period Weather Assignment 2/22/17
import java.io.*;
import java.util.*;

public class TempDifference {
	public static void main (String [] args) throws FileNotFoundException {
		Scanner value = new Scanner(new File("./resources/weather"));
		double prevValue = value.nextDouble();
		while (value.hasNextDouble()) {
			double nextValue = value.nextDouble();
			int difference = (int)(Math.round((nextValue - prevValue) * 10)); //Rounding values to the tenths place
			double trueChange = (double)difference/10.0; 
			System.out.println((prevValue + " to " + nextValue + ", change = " + trueChange));
			prevValue = nextValue;
		
		}
		value.close();
	}
}
