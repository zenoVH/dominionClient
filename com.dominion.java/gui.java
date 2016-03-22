import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Container;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class gui extends JFrame implements ActionListener{
	
	public JFrame frame;
	public Container window;
	
	//Fonts
	Font logoFont = new Font("Verdana", Font.BOLD, 100);
	private final JLabel lblDominion = new JLabel("Dominion");
	private JTextField textField;
	private JPasswordField passwordField;
	
	public gui(){
		
		//Setup JFrame
		frame = this;
		frame.setSize(new Dimension(1200,800));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		drawMenu();
		frame.setVisible(true);
		
	}
	
	public void drawMenu(){
		
		//Load window
		window = frame.getContentPane();
		window.setBackground(UIManager.getColor("InternalFrame.borderLight"));
		getContentPane().setLayout(null);
		lblDominion.setBounds(384, 5, 477, 120);
		lblDominion.setFont(new Font("Tahoma", Font.BOLD, 99));
		
		getContentPane().add(lblDominion);
		
		JLabel lblByMadmanProductions = new JLabel("By: Madman Productions");
		lblByMadmanProductions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblByMadmanProductions.setBounds(511, 123, 220, 25);
		getContentPane().add(lblByMadmanProductions);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnPlay.setBounds(131, 241, 243, 69);
		getContentPane().add(btnPlay);
		
		JButton button = new JButton("Challenge");
		button.setFont(new Font("Tahoma", Font.PLAIN, 40));
		button.setBounds(131, 358, 243, 69);
		getContentPane().add(button);
		
		JButton button_1 = new JButton("EXIT");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		button_1.setBounds(131, 482, 243, 69);
		getContentPane().add(button_1);
		
		JLabel lblLogInTo = new JLabel("Log in");
		lblLogInTo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLogInTo.setBackground(new Color(240, 240, 240));
		lblLogInTo.setBounds(941, 252, 89, 45);
		getContentPane().add(lblLogInTo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(864, 308, 262, 2);
		getContentPane().add(separator);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(864, 339, 89, 25);
		getContentPane().add(lblUsername);
		
		JLabel label = new JLabel("password");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(864, 388, 89, 25);
		getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(998, 339, 128, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnLogIn = new JButton("Log in");
		btnLogIn.setBounds(998, 440, 128, 23);
		getContentPane().add(btnLogIn);
		
		JButton button_2 = new JButton("Register");
		button_2.setBounds(998, 474, 128, 23);
		getContentPane().add(button_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(998, 388, 128, 25);
		getContentPane().add(passwordField);
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
