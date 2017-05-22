package swing.x;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.PopupMenu;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class KeysPrac extends JFrame implements KeyListener {
	private JSlider slider;
	private ArrayList<KeyEvent> moves;
	private JFrame frame;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public KeysPrac(JSlider slider, JFrame frame, JLabel label) {
		this.slider = slider;
		 moves = new ArrayList<KeyEvent>();
		 this.frame = frame;
		 this.label = label;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.moves.add(e);
			
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		check(); 
		move();
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void move () {
		
		for (KeyEvent e: moves) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				slider.setValue(slider.getValue() + 2);
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				slider.setValue(slider.getValue()-2);
			}
		}
	}
	public void check() { //ensures that people don't just hold the key down.
		if (slider.getValue() >= 100 || slider.getValue() <= 0) {
		
			
		}
	}

}
