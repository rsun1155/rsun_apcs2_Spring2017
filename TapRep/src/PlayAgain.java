import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlayAgain implements ActionListener {
	private Frame frame;
	public PlayAgain (Frame frame) {
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.frame.dispose();
		Frame reset = new Frame();
		reset.init();

	}

}
