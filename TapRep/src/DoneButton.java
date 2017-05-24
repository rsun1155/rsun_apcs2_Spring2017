import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//Tap of War: Hannah Ku, Brandon Nguyen, Ryan Sun 2nd period
//Action class representing the option to exit the game at the end of a round.
public class DoneButton implements ActionListener {

	private Frame frame;
	public DoneButton (Frame frame, JButton button) {
		this.frame = frame;
		button.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.frame.dispose();
		
	}

}
