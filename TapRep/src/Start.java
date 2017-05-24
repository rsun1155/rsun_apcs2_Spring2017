import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
//Tap of War: Hannah Ku, Brandon Nguyen, Ryan Sun 2nd period
//Action class responsible for the start screen
public class Start implements ActionListener {
	private Frame frame;
	private JButton button;
	public Start(Frame frame, JButton button) {
		this.frame = frame;
		this.button = button;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		frame.init();
		button.setVisible(false);

	}

}
