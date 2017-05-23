package swing.x;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JSlider;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class Window {

	private JFrame frame;
	protected JSlider slider;
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
		// title and size of the window
			frame.setTitle("TAP OF WAR!");
		 	frame.setSize(600,600);
		 	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 	frame.setResizable(false);
		
		
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
		
		         
		         JLabel label = new JLabel("TAP OF WAR");
		         label.setBounds(750,450,100,100);
		         label.setFont(label.getFont().deriveFont(Font.BOLD, 48));
		         label.setForeground(Color.GRAY);
		         frame.getContentPane().add(label);
		         FlowLayout flowLayout = new FlowLayout();
		         frame.getContentPane().setLayout(flowLayout);
		         this.slider = new JSlider();
		         slider.setBackground(Color.RED);
		 		slider.setEnabled(false);
		 		frame.getContentPane().add(slider, BorderLayout.NORTH);
	
		
		
		frame.addKeyListener(new KeysPrac(slider, frame, label));
		/*  JLabel label2 = new JLabel(new ImageIcon(getClass().getResource("/tugging.png")));
	        label2.setBounds(720,675,547,232);
	        add(label2);
	        
	        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/flowers.gif")));
	        background.setBounds(0,0,1920,1080);
	        add(background); */
		
	}
	

	
	public JFrame getFrame() { 
		return this.frame;
	}
}

	