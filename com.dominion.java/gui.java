import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;

import com.sun.prism.Image;
import com.sun.prism.paint.Color;

import java.awt.Container;


public class gui extends JFrame implements ActionListener{
	
	public JFrame frame;
	public Container window;
	
	//Fonts
	Font logoFont = new Font("Verdana", Font.BOLD, 100);

	//Menu Objects
	JLabel lblDominion = new JLabel("Dominion");
	JButton btnPlay = new JButton("Play");
	JButton btnChallenge = new JButton("Challenge");
	JButton btnExit = new JButton("EXIT");
	JButton btnSignIn = new JButton("Sign in");
	JButton btnSignUp = new JButton("Sign up");
	JButton btnLeaderbord = new JButton("Leaderbord");
	JButton btnSettings = new JButton("Settings\r\n");
	
	//Screens
	gameSetupGUI setupScreen;
	
	
	public gui(){
		
		//Setup JFrame
		frame = this;
		frame.setSize(new Dimension(1200,800));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		drawMenu();
		frame.setVisible(true);
		
		//Init Screens
		setupScreen = new gameSetupGUI(window,this);
		
	}
	
	public void drawMenu(){
		
		//Load window
		window = frame.getContentPane();
		window.setBackground(UIManager.getColor("InternalFrame.borderLight"));
		window.setLayout(null);
		
		
		lblDominion.setBounds(342, 43, 477, 120);
		lblDominion.setFont(new Font("Tahoma", Font.BOLD, 99));
		window.add(lblDominion);
		
		JLabel lblByMadmanProductions = new JLabel("By: Madman Productions");
		lblByMadmanProductions.setBounds(481, 156, 220, 25);
		lblByMadmanProductions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		window.add(lblByMadmanProductions);

		btnPlay.setBounds(131, 313, 238, 69);
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 50));
		window.add(btnPlay);

		btnChallenge.setBounds(131, 406, 238, 69);
		btnChallenge.setFont(new Font("Tahoma", Font.PLAIN, 40));
		window.add(btnChallenge);

		btnExit.setBounds(131, 498, 238, 69);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 40));
		window.add(btnExit);

		btnSignIn.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSignIn.setBounds(761, 313, 138, 69);
		window.add(btnSignIn);

		btnSignUp.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnSignUp.setBounds(909, 313, 138, 69);
		window.add(btnSignUp);
		
		btnLeaderbord.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnLeaderbord.setBounds(761, 406, 286, 69);
		window.add(btnLeaderbord);
		
		btnSettings.setFont(new Font("Tahoma", Font.PLAIN, 40));
		btnSettings.setBounds(761, 498, 286, 69);
		window.add(btnSettings);
		
		//ActionListeners
		btnPlay.addActionListener(this);
		btnExit.addActionListener(this);
		

		
		
	}
	
	public void resetScreen(){
		
		window.removeAll();
		window.revalidate();
		window.repaint();
		
	}

	public void actionPerformed(ActionEvent e) {
		Object input = e.getSource();
		
		if(input == btnExit){
			System.exit(1);
		}else if(input == btnPlay){
			resetScreen();
			setupScreen.draw("local");
		}else if (input == setupScreen.exit){
			resetScreen();
			drawMenu();
		}else if (input == setupScreen.jbPlay){
			resetScreen();
		}
		
	}
}