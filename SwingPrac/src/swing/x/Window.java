package swing.x;

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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class Window {

	private JFrame frame;
	protected JSlider slider;
	
	/**
	 * @wbp.nonvisual location=-19,329
	 */
	private final JLabel label = new JLabel("New label");
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
		frame.setFocusable(true);
		
		
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
		
		this.slider = new JSlider();
		slider.setEnabled(false);
		frame.getContentPane().add(slider, BorderLayout.SOUTH);
	
		
		
		frame.addKeyListener(new KeysPrac(slider));
		
	}

	
	public JFrame getFrame() { 
		return this.frame;
	}
}

	