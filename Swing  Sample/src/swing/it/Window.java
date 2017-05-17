package swing.it;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JSlider;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Window {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=-19,329
	 */
	private final JLabel label = new JLabel("New label");
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setFocusable
		JSlider slider = new JSlider();
		slider.setEnabled(false);
		frame.getContentPane().add(slider, BorderLayout.SOUTH);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnStart = new JMenu("Start");
		menuBar.add(mnStart);
		
		JMenuItem mntmPause = new JMenuItem("Pause");
		mnStart.add(mntmPause);
		
		JMenuItem mntmOptions = new JMenuItem("Options");
		mnStart.add(mntmOptions);
		
		JMenuItem menuItem = new JMenuItem("");
		menuBar.add(menuItem);
		
		JButton btnTest = new JButton("Test");
		btnTest.setEnabled(false);
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				moveLeft(slider);
				
			}
		});
		btnTest.setAction(action);
		frame.getContentPane().add(btnTest, BorderLayout.WEST);
	
		
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setEnabled(false);
		btnNewButton.setAction(action_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				moveRight(slider);
			}
		});
		frame.getContentPane().add(btnNewButton, BorderLayout.EAST);
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Player 1");
			putValue(SHORT_DESCRIPTION, "Player 1");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "SwingAction_1");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	public JFrame getFrame() { 
		return this.frame;
	}

	public void moveRight (JSlider slider) {
		slider.setValue(slider.getValue() + 5);
	}
	public void moveLeft (JSlider slider) {
		slider.setValue(slider.getValue() - 5);
	}
}
