import java.io.*;
import java.util.*;

public class TempDifference {
	public static void main (String [] args) throws FileNotFoundException {
		Scanner value = new Scanner(new File("./resources/weather"));
		double prevValue = value.nextDouble();
		while (value.hasNextDouble()) {
			double nextValue = value.nextDouble();
			int difference = (int)((nextValue - prevValue) * 10);
			double trueChange = (double)difference/10.0; 
			System.out.println((prevValue + " to " + nextValue + ", change = " + trueChange));
			prevValue = nextValue;
		
		}
		value.close();
	}
}
