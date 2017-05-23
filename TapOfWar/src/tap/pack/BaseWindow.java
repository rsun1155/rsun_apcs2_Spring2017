package tap.pack;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;


public class BaseWindow{

	private JFrame frame;
	private JSlider slider;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BaseWindow window = new BaseWindow();
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
		public BaseWindow() {
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
			        JLabel label2 = new JLabel(new ImageIcon(getClass().getResource("resources/tug.png")));
			         label2.setBounds(720,675,547,232);
			         frame.getContentPane().add(label2);
			         
			         JLabel background = new JLabel(new ImageIcon(getClass().getResource("resources/flowers.gif")));
			         background.setBounds(0,0,600,600);
			         frame.getContentPane().add(background); 
			         this.slider = new JSlider();
			         slider.setBackground(Color.RED);
			 		slider.setEnabled(false);
			 		frame.getContentPane().add(slider, BorderLayout.NORTH);
		
			
			
			frame.addKeyListener(new KeysInput(slider, frame, label));
			
			JButton btnHi = new JButton("HI");
			btnHi.setAction(action);
			frame.getContentPane().add(btnHi, BorderLayout.EAST);
			
			
		}

		
		public JFrame getFrame() { 
			return this.frame;
		}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	}


