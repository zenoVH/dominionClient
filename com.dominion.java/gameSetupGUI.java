import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class gameSetupGUI implements ActionListener{
	
	ActionListener action;
	
	//Menu Objects
	Container window;
	JButton JButton_play = new JButton("Play");
	JButton JButton_Players4 = new JButton("4");
	JButton Jbutton_back = new JButton("Back");
	JButton JButton_Players3 = new JButton("3");
	JButton JButton_Players2 = new JButton("2");
	JTextField JTextField_maxRounds = new JTextField("10");
	
	
	JTextField inviteField = new JTextField();
	JButton btnInvite = new JButton("Invite");
	
	//logic
	int playersAmount = 2;
	
	public gameSetupGUI(Container window, ActionListener action){
		this.window = window;
		this.action = action;
	}
	
	public void draw(){
		drawLocal();
	}

	public void drawLocal(){
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocal.setFont(new Font("Yu Gothic", Font.BOLD, 30));
		lblLocal.setBounds(17, 11, 465, 60);
		window.add(lblLocal);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(29, 69, 442, 2);
		window.add(separator_3);
		

		JButton_Players2.setFont(new Font("Tahoma", Font.PLAIN, 50));
		JButton_Players2.setBounds(135, 108, 70, 70);
		window.add(JButton_Players2);
		

		JButton_Players3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		JButton_Players3.setBounds(215, 108, 70, 70);
		window.add(JButton_Players3);
		

		JButton_Players4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		JButton_Players4.setBounds(295, 108, 70, 70);
		window.add(JButton_Players4);
		
		JTextField_maxRounds.setBounds(215, 200, 70, 30);
		window.add(JTextField_maxRounds);
		

		Jbutton_back.setBounds(135, 254, 89, 23);
		window.add(Jbutton_back);
		

		JButton_play.setBounds(276, 254, 89, 23);
		JButton_play.setEnabled(false);
		window.add(JButton_play);
		
		window.revalidate();
		window.repaint();
		
		//actionListeners
		Jbutton_back.addActionListener(action);
		JButton_play.addActionListener(action);
		JButton_Players2.addActionListener(this);
		JButton_Players3.addActionListener(this);
		JButton_Players4.addActionListener(this);
	}
	
	
	public int getMaxRounds(){
		
		int r = Integer.parseInt(JTextField_maxRounds.getText());;
		if(r > 1) return r;
		return 10;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object input = arg0.getSource();
		
		if (input == JButton_Players2){
			playersAmount =2;
			JButton_play.setEnabled(true);
			JButton_Players2.setBackground(Color.CYAN);
			JButton_Players3.setBackground(Color.WHITE);
			JButton_Players4.setBackground(Color.WHITE);
		}else if (input == JButton_Players3){
			playersAmount =3;
			JButton_play.setEnabled(true);
			JButton_Players3.setBackground(Color.CYAN);
			JButton_Players2.setBackground(Color.WHITE);
			JButton_Players4.setBackground(Color.WHITE);
		}else if (input == JButton_Players4){
			playersAmount =4;
			JButton_play.setEnabled(true);
			JButton_Players2.setBackground(Color.WHITE);
			JButton_Players4.setBackground(Color.CYAN);
			JButton_Players3.setBackground(Color.WHITE);
		}
		
	}

}
