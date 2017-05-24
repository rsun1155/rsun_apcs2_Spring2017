import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Tap of War: Hannah Ku, Brandon Nguyen, Ryan Sun 2nd period
//Action class representing the action to continue after the round is done.
public class PlayAgain implements ActionListener {
	private Frame frame;
	public PlayAgain (Frame frame) {
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame.dispose(); //Causes frame to exit and clean up.
		Frame reset = new Frame();
		reset.init(); //Resets the process;

	}

}
