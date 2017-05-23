import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

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
