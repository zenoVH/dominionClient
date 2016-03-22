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

public class gui extends JFrame implements ActionListener{
	
	public JFrame frame;
	public Container window;
	
	//Menu Objects
	
	JPanel jpLogo = new JPanel();	
	JLabel jlLogo = new JLabel("<html><div style='text-align: center;'>" + "Dominion" + "</html>");
	JLabel jlSubLogo = new JLabel("by: Madman Studios");
	
	JButton play = new JButton("Play");
	
	//Fonts
	Font logoFont = new Font("Verdana", Font.BOLD, 100);
	
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
		window.setLayout(new FlowLayout());
		window.setBackground(UIManager.getColor("InternalFrame.borderLight"));
		
		//draw logo
		jlLogo.setFont(logoFont);
		jlLogo.setPreferredSize(new Dimension(1190, 140));
		jpLogo.add(jlLogo);
		jpLogo.add(jlSubLogo);
		jpLogo.setPreferredSize(new Dimension(1190, 160));
		window.add(jpLogo);
		
		
		play.setPreferredSize(new Dimension(300, 150));
		play.setBackground(Color.RED);
		window.add(play);
		
	}

	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
