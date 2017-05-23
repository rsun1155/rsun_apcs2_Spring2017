

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

public class KeysInput implements KeyListener{
	private JSlider slider;
	private ArrayList<KeyEvent> moves;
	private Frame frame;
	private JLabel label;
	private boolean done = false;
	public KeysInput(JSlider slider, Frame frame, JLabel label) {
		this.slider = slider;
		 moves = new ArrayList<KeyEvent>();
		 this.frame = frame;
		 this.label = label;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!done)
		this.moves.add(e);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub 
		if (!done)
		move();
		if (done) 
		finishSequence();
		
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
		moves = new ArrayList<KeyEvent>();
		if (slider.getValue() >= 100 || slider.getValue() <= 0) {
			done = true;
		}
	}
	public boolean isDone() {
		return done;
	}
	public void finishSequence () {
		 JButton playAgain = new JButton("Play Again?");
	        playAgain.setEnabled(true);
	        playAgain.setSize(250, 250);
	        playAgain.setLocation(627, 238);
	        playAgain.setFont(new Font("Times New Roman", Font.PLAIN, 35));
	        playAgain.setHorizontalAlignment(SwingConstants.LEFT);
			JButton close = new JButton("Done?");
			close.setEnabled(true);
			close.setSize(250, 250);
			close.setFont(new Font("Times New Roman", Font.PLAIN, 35));
			close.setLocation(1059, 238);
			close.setOpaque(true);
			playAgain.setOpaque(true);
			playAgain.addActionListener(new PlayAgain(frame));
			close.addActionListener(new DoneButton(frame, close));
			this.label.add(playAgain, BorderLayout.WEST);
			this.label.add(close, BorderLayout.EAST);
			
	}		
	}


