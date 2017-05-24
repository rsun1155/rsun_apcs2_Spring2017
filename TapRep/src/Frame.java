//Tap of War: Hannah Ku, Brandon Nguyen, Ryan Sun 2nd period
//This is the frame and client code for our tug of war game.
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.PopupMenu;

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
import javax.swing.JTextField;
import java.awt.TextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class Frame extends JFrame {
		public static void main(String[] args){ //Main method
			new Frame();
		}
		
		public Frame(){
			
			// title and size of the window
			setTitle("TAP OF WAR! Ku, Nguyen, Sun, 2nd period APCS");
			setSize(1920,1080);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setResizable(false);
			JButton button = new JButton("TAP OF WAR: TAP TO START!");
			button.setBackground(Color.PINK);
			button.setForeground(Color.RED);
			button.setFont(new Font("Sylfaen", Font.PLAIN, 50));
	        button.setBounds(910,470,100,30);
	        button.setEnabled(true);
	        button.setVisible(true);
	        getContentPane().add(button);
	        this.setVisible(true);
	        this.setFocusable(true); 
			button.addActionListener(new Start(this, button)); //makes the START button visible first
		
			
			
			
		}
		
		public void init(){
			//placing the images and scene on the frame
			getContentPane().setLayout(null);
			 JLabel label = new JLabel("TAP OF WAR"); //Title label
	        label.setFont(label.getFont().deriveFont(Font.BOLD, 24));
	        label.setForeground(Color.GRAY);
	        label.setBounds(640,310,160,100);
	        getContentPane().add(label);
	        JSlider slider = new JSlider(); //initializes and customizes slider. User cannot directly move slider
			slider.setLocation(631, 540);
			slider.setSize(169, 26);
			slider.setEnabled(false);
	        slider.setBackground(Color.RED);
			getContentPane().add(slider, BorderLayout.NORTH);
			
			//Tug image. Source: http://search.coolclips.com/m/vector/vc103505/tug-of-war/
			 JLabel label2 = new JLabel(new ImageIcon(getClass().getResource("/tug.png"))); 
		        label2.setBounds(480,410,480,305);
		        getContentPane().add(label2);
		        //Background image. Source: http://www.fubiz.net/2015/08/05/everyday-life-in-japan-8-bit-gifs/
		        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/flowers.gif")));
		        background.setHorizontalAlignment(SwingConstants.LEFT);
		        background.setBounds(0,0,1440,720);
		        background.setOpaque(false);
		        getContentPane().add(background);
		        KeysInput keys = new KeysInput(slider, this, background); //Sets slider to respond to keyboard input
		        this.addKeyListener(keys);
			



			
		}

	}

