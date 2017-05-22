package swing.x;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class KeysPrac extends JFrame implements KeyListener {
	protected JSlider slider;
	private ArrayList<KeyEvent> moves;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public KeysPrac(JSlider slider) {
		this.slider = slider;
		 moves = new ArrayList<KeyEvent>();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		this.moves.add(e);
			
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		move();
		
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void move () {
		for (KeyEvent e: moves) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				slider.setValue(slider.getValue() + 5);
			}
			else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				slider.setValue(slider.getValue()-5);
			}
		}
	}

}
