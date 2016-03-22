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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{131, 243, 477, 89, 45, 128, 0};
		gridBagLayout.rowHeights = new int[]{143, 93, 56, 2, 25, 39, 23, 77, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		lblDominion.setFont(new Font("Tahoma", Font.BOLD, 99));
		
		GridBagConstraints gbc_lblDominion = new GridBagConstraints();
		gbc_lblDominion.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblDominion.insets = new Insets(0, 0, 5, 5);
		gbc_lblDominion.gridx = 2;
		gbc_lblDominion.gridy = 0;
		getContentPane().add(lblDominion, gbc_lblDominion);
		
		JLabel lblByMadmanProductions = new JLabel("By: Madman Productions");
		lblByMadmanProductions.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblByMadmanProductions = new GridBagConstraints();
		gbc_lblByMadmanProductions.anchor = GridBagConstraints.SOUTH;
		gbc_lblByMadmanProductions.insets = new Insets(0, 0, 5, 5);
		gbc_lblByMadmanProductions.gridx = 2;
		gbc_lblByMadmanProductions.gridy = 0;
		getContentPane().add(lblByMadmanProductions, gbc_lblByMadmanProductions);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setFont(new Font("Tahoma", Font.PLAIN, 50));
		GridBagConstraints gbc_btnPlay = new GridBagConstraints();
		gbc_btnPlay.anchor = GridBagConstraints.NORTH;
		gbc_btnPlay.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPlay.insets = new Insets(0, 0, 5, 5);
		gbc_btnPlay.gridheight = 2;
		gbc_btnPlay.gridx = 1;
		gbc_btnPlay.gridy = 2;
		getContentPane().add(btnPlay, gbc_btnPlay);
		
		JLabel lblLogInTo = new JLabel("Log in");
		lblLogInTo.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLogInTo.setBackground(new Color(240, 240, 240));
		GridBagConstraints gbc_lblLogInTo = new GridBagConstraints();
		gbc_lblLogInTo.anchor = GridBagConstraints.SOUTH;
		gbc_lblLogInTo.insets = new Insets(0, 0, 5, 0);
		gbc_lblLogInTo.gridwidth = 3;
		gbc_lblLogInTo.gridx = 3;
		gbc_lblLogInTo.gridy = 2;
		getContentPane().add(lblLogInTo, gbc_lblLogInTo);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.anchor = GridBagConstraints.NORTH;
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 0, 5, 0);
		gbc_separator.gridwidth = 3;
		gbc_separator.gridx = 3;
		gbc_separator.gridy = 3;
		getContentPane().add(separator, gbc_separator);
		
		JButton button = new JButton("Challenge");
		button.setFont(new Font("Tahoma", Font.PLAIN, 40));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.anchor = GridBagConstraints.SOUTH;
		gbc_button.fill = GridBagConstraints.HORIZONTAL;
		gbc_button.insets = new Insets(0, 0, 5, 5);
		gbc_button.gridheight = 2;
		gbc_button.gridx = 1;
		gbc_button.gridy = 4;
		getContentPane().add(button, gbc_button);
		
		JLabel lblUsername = new JLabel("username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.anchor = GridBagConstraints.NORTH;
		gbc_lblUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 3;
		gbc_lblUsername.gridy = 4;
		getContentPane().add(lblUsername, gbc_lblUsername);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 5;
		gbc_textField.gridy = 4;
		getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("password");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.NORTH;
		gbc_label.fill = GridBagConstraints.HORIZONTAL;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 3;
		gbc_label.gridy = 5;
		getContentPane().add(label, gbc_label);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.anchor = GridBagConstraints.NORTH;
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField.gridx = 5;
		gbc_passwordField.gridy = 5;
		getContentPane().add(passwordField, gbc_passwordField);
		
		JButton btnLogIn = new JButton("Log in");
		GridBagConstraints gbc_btnLogIn = new GridBagConstraints();
		gbc_btnLogIn.anchor = GridBagConstraints.NORTH;
		gbc_btnLogIn.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLogIn.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogIn.gridx = 5;
		gbc_btnLogIn.gridy = 6;
		getContentPane().add(btnLogIn, gbc_btnLogIn);
		
		JButton button_1 = new JButton("EXIT");
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.fill = GridBagConstraints.BOTH;
		gbc_button_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_1.gridx = 1;
		gbc_button_1.gridy = 7;
		getContentPane().add(button_1, gbc_button_1);
		
		JButton button_2 = new JButton("Register");
		GridBagConstraints gbc_button_2 = new GridBagConstraints();
		gbc_button_2.anchor = GridBagConstraints.NORTH;
		gbc_button_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_button_2.gridx = 5;
		gbc_button_2.gridy = 7;
		getContentPane().add(button_2, gbc_button_2);
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
