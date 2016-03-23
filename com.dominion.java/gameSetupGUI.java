import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class gameSetupGUI implements ActionListener{
	
	ActionListener action;
	
	//Menu Objects
	Container window;
	JButton exit = new JButton("Exit");
	JButton jb2PL = new JButton("2 Players");
	JButton jb3PL = new JButton("3 Players");
	JButton jb4PL = new JButton("4 Players");
	JButton jbPlay = new JButton("Play");
	
	//logic
	int playersAmount = 2;
	
	public gameSetupGUI(Container window, ActionListener action){
		this.window = window;
		this.action = action;
	}
	
	public void draw(String mode){
		if(mode.equals("local")){
			drawLocal();
		}else if(mode.equals("online")){
			
		}
	}

	public void drawLocal(){
		
		exit.setBounds(975,700,200,50);
		exit.setFont(new Font("Tahoma", Font.BOLD, 30));
		window.add(exit);
		
		JLabel jlTitle = new JLabel("Local"); 
		jlTitle.setBounds(131, 100, 477, 120);
		jlTitle.setFont(new Font("Tahoma", Font.BOLD, 50));
		window.add(jlTitle);
		
		JLabel jlPlayers = new JLabel("Players");
		jlPlayers.setBounds(150, 250, 200, 50);
		jlPlayers.setFont(new Font("Tahoma",Font.PLAIN, 30));
		window.add(jlPlayers);
		
		jb2PL.setBounds(300, 250, 150, 50);
		jb2PL.setBackground(Color.CYAN);
		window.add(jb2PL);
		
		jb3PL.setBounds(500, 250, 150, 50);
		jb3PL.setBackground(Color.WHITE);
		window.add(jb3PL);
		
		jb4PL.setBounds(700, 250, 150, 50);
		jb4PL.setBackground(Color.WHITE);
		window.add(jb4PL);
		
		jbPlay.setBounds(150,350,700,100);
		jbPlay.setFont(new Font("Tahoma", Font.BOLD, 50));
		window.add(jbPlay);
		
		window.revalidate();
		window.repaint();
		
		//actionListeners
		exit.addActionListener(action);
		jbPlay.addActionListener(action);
		jb2PL.addActionListener(this);
		jb3PL.addActionListener(this);
		jb4PL.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object input = arg0.getSource();
		
		if (input == jb2PL){
			playersAmount =2;
			jb2PL.setBackground(Color.CYAN);
			jb3PL.setBackground(Color.WHITE);
			jb4PL.setBackground(Color.WHITE);
		}else if (input == jb3PL){
			playersAmount =3;
			jb3PL.setBackground(Color.CYAN);
			jb2PL.setBackground(Color.WHITE);
			jb4PL.setBackground(Color.WHITE);
		}else if (input == jb4PL){
			playersAmount =4;
			jb2PL.setBackground(Color.WHITE);
			jb4PL.setBackground(Color.CYAN);
			jb3PL.setBackground(Color.WHITE);
		}
		
	}

}
