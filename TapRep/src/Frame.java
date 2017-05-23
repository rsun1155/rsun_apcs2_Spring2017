import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;

public class Frame extends JFrame {
		public static void main(String[] args){
			new Frame();
		}
		
		public Frame(){
			
			// title and size of the window
			setTitle("TAP OF WAR!");
			setSize(1920,1080);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			
			init();

		}
		
		public void init(){
			//placing the images and scene on the frame
			getContentPane().setLayout(null);
			
			JButton button = new JButton("START");
	        button.setBounds(910,470,100,30);
	        button.setEnabled(true);
	        button.setVisible(true);
	        getContentPane().add(button);
	        this.setFocusable(true);
	       
	        
	        JLabel label = new JLabel("TAP OF WAR");
	        label.setFont(label.getFont().deriveFont(Font.BOLD, 24));
	        label.setForeground(Color.GRAY);
	        label.setBounds(884,500,160,100);
	        getContentPane().add(label);
	       
	       
			

	        
	       
	        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/flowers.gif")));
	        background.setHorizontalAlignment(SwingConstants.LEFT);
	        background.setBounds(0,0,1920,1080);
	        background.setOpaque(false);
	        getContentPane().add(background);
	        JSlider slider = new JSlider();
			slider.setLocation(883, 799);
			slider.setSize(169, 26);
			slider.setEnabled(false);
	        slider.setBackground(Color.RED);
			background.add(slider, BorderLayout.NORTH);
			KeysInput keys = new KeysInput(slider, this, background);
			this.addKeyListener(keys);
			 JLabel label2 = new JLabel(new ImageIcon(getClass().getResource("/tug.png")));
		        label2.setBounds(720,675,480,305);
		        background.add(label2);
		        
	       
			
			setVisible(true);
			



			
		}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
	}

