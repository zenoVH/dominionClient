import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.sun.xml.internal.ws.api.pipe.Engine;

import NetworkEngine.friend;
import NetworkEngine.netEngineClient;
import java.awt.Color;
import java.awt.Container;
import SwingEngine.*;


public class gui extends JFrame implements ActionListener{
	
	public JFrame frame;
	public Container window;
	
	String name;
	
	//Menu Objects
	gameSetupGUI setupScreen;
	
	JButton JButton_Play = new JButton("Play");
	JLabel JLabel_AvatarIcon = new JLabel("");
	JLabel JLabel_NickName = new JLabel("Zeno");
	JLabel JLabel_Points = new JLabel("IP: 420");
	JButton JButton_Profile = new JButton("Profile");
	JLabel JLabel_NetworkStatus = new JLabel("connecting...");
	JLabel JLabel_NickName2 = new JLabel("Zeno");
	JButton JButton_addPlayer = new JButton("+");
	JLabel JLabel_AvatarIcon2 = new JLabel("");
	JPanel JPanel_SetupPanel = new JPanel();
	JButton JButton_PlayLocal = new JButton("Local");
	JPanel Jpanel_CenterWindow = new JPanel();
	JTextField JTextField_AddFriend = new JTextField();
	JPanel JPanel_SideBar = new JPanel();
	JPanel panel_2 = new JPanel();
	
	
	//Engines
	SwingEngine swing = new SwingEngine();
	netEngineClient server;
	
	ArrayList<JButton> acceptButtons = new ArrayList<JButton>();

	public gui(){
		
		//Login Screen
		name = (String)JOptionPane.showInputDialog("Enter a username");
		
		//Setup JFrame
		frame = this;
		frame.setSize(new Dimension(1200,790));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		drawMenu();
		frame.setVisible(true);
		
		//Load User data
		JLabel_NickName.setText(name);
		JLabel_NickName2.setText(name);
		
		//Init Screens
		setupScreen = new gameSetupGUI(JPanel_SetupPanel,this);
		
		//connectToServer
		
		try {
			server = new netEngineClient();
			server.setUsername(name);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		//Gui loop
		while (true) {
			
			try {Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
			update();
			
		}
	}
	
	public void update(){
		
		//Update friend info
		server.sendInvitesRequest();
		server.sendFriendRequest();
		
		//Online indicator
		if(server.online()){
			JLabel_NetworkStatus.setText("Online");
			JLabel_NetworkStatus.setForeground(Color.green);
		}else{
			JLabel_NetworkStatus.setText("Offline");
			JLabel_NetworkStatus.setForeground(Color.red);
			server.connectToServer();
		}
		JPanel_SetupPanel.revalidate();
		JPanel_SetupPanel.repaint();
		
		//Invites
		if (server.updated) {
			panel_2.removeAll();
			
			for (int i = 0; i < server.invites().size(); i++) {
				drawInvite(server.invites().get(i));
			}
			
			for (int i = 0; i < server.friendsName().size(); i++) {
				drawFriend(server.friendsName().get(i),server.friendsStatus().get(i));
			}
			panel_2.revalidate();
			panel_2.repaint();
		}
		
		
		
	}
	
	public void drawMenu(){
		
		window = getContentPane();
		
		getContentPane().setBackground(new Color(0, 0, 0));
		setBackground(new Color(0, 0, 0));
		getContentPane().setLayout(null);
		
		JPanel JPanel_TopBar = new JPanel();
		JPanel_TopBar.setBackground(new Color(102, 102, 102));
		JPanel_TopBar.setBounds(0, 0, 1200, 100);
		getContentPane().add(JPanel_TopBar);
		JPanel_TopBar.setLayout(null);
		
		
		JButton_Play.setForeground(new Color(255, 255, 255));
		JButton_Play.setBackground(new Color(204, 0, 51));
		JButton_Play.setFont(new Font("Yu Gothic", Font.PLAIN, 30));
		JButton_Play.setBounds(492, 15, 200, 70);
		JButton_Play.setOpaque(true);
		JPanel_TopBar.add(JButton_Play);
		
		JPanel JPanel_Userinfo = new JPanel();
		JPanel_Userinfo.setBackground(new Color(102, 102, 102));
		JPanel_Userinfo.setBounds(746, 15, 428, 70);
		JPanel_TopBar.add(JPanel_Userinfo);
		JPanel_Userinfo.setLayout(null);
		
		
		JLabel_AvatarIcon.setIcon(new ImageIcon("icon.png"));
		JLabel_AvatarIcon.setBackground(Color.BLACK);
		JLabel_AvatarIcon.setBounds(0, 0, 70, 70);
		JPanel_Userinfo.add(JLabel_AvatarIcon);
		
		
		JLabel_NickName.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		JLabel_NickName.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_NickName.setBounds(80, 0, 150, 35);
		JPanel_Userinfo.add(JLabel_NickName);
		

		JLabel_Points.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_Points.setFont(new Font("Yu Gothic", Font.PLAIN, 15));
		JLabel_Points.setBounds(240, 0, 150, 35);
		JPanel_Userinfo.add(JLabel_Points);
		
		JButton btnNewButton = new JButton("Store");
		btnNewButton.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		btnNewButton.setBackground(new Color(0, 204, 204));
		btnNewButton.setBounds(90, 40, 150, 30);
		JPanel_Userinfo.add(btnNewButton);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setBounds(90, 32, 310, 3);
		JPanel_Userinfo.add(separator);
		

		JButton_Profile.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		JButton_Profile.setBackground(new Color(0, 204, 204));
		JButton_Profile.setBounds(250, 40, 150, 30);
		JPanel_Userinfo.add(JButton_Profile);
		
		JLabel JLabel_GameLogo = new JLabel("Dominion");
		JLabel_GameLogo.setFont(new Font("Magneto", Font.PLAIN, 45));
		JLabel_GameLogo.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel_GameLogo.setBounds(28, 0, 300, 100);
		JPanel_TopBar.add(JLabel_GameLogo);
		

		JPanel_SideBar.setBackground(new Color(153, 153, 153));
		JPanel_SideBar.setBounds(934, 100, 260, 661);
		getContentPane().add(JPanel_SideBar);
		JPanel_SideBar.setLayout(null);
		

		JLabel_AvatarIcon2.setIcon(new ImageIcon("icon.png"));
		JLabel_AvatarIcon2.setBounds(10, 10, 70, 70);
		JLabel_AvatarIcon2.setBackground(Color.BLACK);
		JPanel_SideBar.add(JLabel_AvatarIcon2);
		

		JLabel_NickName2.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		JLabel_NickName2.setBounds(85, 10, 155, 35);
		JPanel_SideBar.add(JLabel_NickName2);
		

		JLabel_NetworkStatus.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
		JLabel_NetworkStatus.setBounds(85, 45, 155, 35);
		JPanel_SideBar.add(JLabel_NetworkStatus);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(10, 78, 230, 2);
		JPanel_SideBar.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(new Color(0, 0, 0));
		separator_2.setBounds(10, 602, 230, 2);
		JPanel_SideBar.add(separator_2);
		
		JLabel lblFriendList = new JLabel("Friend List");
		lblFriendList.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		lblFriendList.setBounds(10, 91, 230, 25);
		JPanel_SideBar.add(lblFriendList);
		
		JTextField_AddFriend.setBounds(10, 615, 165, 35);
		JPanel_SideBar.add(JTextField_AddFriend);
		JTextField_AddFriend.setColumns(10);
		

		JButton_addPlayer.setBackground(new Color(255, 255, 255));
		JButton_addPlayer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		JButton_addPlayer.setBounds(185, 615, 54, 35);
		JPanel_SideBar.add(JButton_addPlayer);
		
		Jpanel_CenterWindow.setBounds(0, 100, 933, 661);
		getContentPane().add(Jpanel_CenterWindow);
		Jpanel_CenterWindow.setLayout(null);
		
		JLabel JLabel_Background = new JLabel("");
		JLabel_Background.setIcon(new ImageIcon("background.png"));
		JLabel_Background.setBounds(0, 0, 933, 661);
		Jpanel_CenterWindow.add(JLabel_Background);
		
		panel_2.setBackground(new Color(153, 153, 153));
		panel_2.setBounds(10, 127, 230, 468);
		panel_2.setLayout(new FlowLayout());
		JPanel_SideBar.add(panel_2);
		
		//ActionListeners
		JButton_Play.addActionListener(this);
		JButton_addPlayer.addActionListener(this);
		
	}
	
	public void drawlocalOrOnline(){
		
		JPanel_SetupPanel.setBackground(new Color(112, 128, 144));
		JPanel_SetupPanel.setBounds(216, 155, 500, 350);
		Jpanel_CenterWindow.add(JPanel_SetupPanel);
		JPanel_SetupPanel.setLayout(null);
		
		JButton_PlayLocal.setBounds(150, 120, 200, 50);
		JPanel_SetupPanel.add(JButton_PlayLocal);
		JButton_PlayLocal.setBackground(new Color(0, 128, 128));
		JButton_PlayLocal.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		
		JButton_Play.setEnabled(false);
		
		//ActionListeners
		JButton_PlayLocal.addActionListener(this);
		
	}
	
	public void reDrawSetupScreen(){
		
		JPanel_SetupPanel.revalidate();
		JPanel_SetupPanel.repaint();
		
	}
	
	public void drawInvite(String friend){
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 128));
		panel_1.setPreferredSize(new Dimension(230, 95));
		panel_2.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblYouReceivedA = new JLabel("You received a friend request from");
		lblYouReceivedA.setBounds(10, 5, 220, 20);
		panel_1.add(lblYouReceivedA);
		
		JLabel lblUser = new JLabel(friend);
		lblUser.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		lblUser.setBounds(10, 25, 125, 25);
		panel_1.add(lblUser);
		
		JButton JButton_Decline = new JButton("X");
		JButton_Decline.setBounds(90, 61, 45, 23);
		panel_1.add(JButton_Decline);
		
		JButton JButton_Accept = new JButton("Accept");
		JButton_Accept.setName(friend);
		JButton_Accept.setBounds(140, 61, 80, 23);
		panel_1.add(JButton_Accept);
		
		JButton_Accept.addActionListener(this);
		
		acceptButtons.add(JButton_Accept);
		
		
		
	}
	
	public void drawFriend(String name, boolean online){
		
		JPanel Jpanel_friend = new JPanel();
		Jpanel_friend.setBackground(new Color(128, 128, 128));
		Jpanel_friend.setPreferredSize(new Dimension(210, 50));
		panel_2.add(Jpanel_friend);
		Jpanel_friend.setLayout(null);
		
		JLabel JLabel_friendIcon = new JLabel("");
		JLabel_friendIcon.setBounds(5, 5, 40, 40);
		Jpanel_friend.add(JLabel_friendIcon);
		
		JLabel JLabel_friendUsername = new JLabel(name);
		JLabel_friendUsername.setFont(new Font("Yu Gothic", Font.PLAIN, 16));
		JLabel_friendUsername.setBounds(55, 5, 145, 20);
		Jpanel_friend.add(JLabel_friendUsername);
		
		if (online) {
			
			JLabel JLabel_friendOnline = new JLabel("Online");
			JLabel_friendOnline.setForeground(new Color(0, 128, 0));
			JLabel_friendOnline.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
			JLabel_friendOnline.setBounds(55, 25, 60, 25);
			Jpanel_friend.add(JLabel_friendOnline);
			
		} else {
			
			JLabel JLabel_friendOnline = new JLabel("Offline");
			JLabel_friendOnline.setForeground(Color.red);
			JLabel_friendOnline.setFont(new Font("Yu Gothic", Font.PLAIN, 12));
			JLabel_friendOnline.setBounds(55, 25, 60, 25);
			Jpanel_friend.add(JLabel_friendOnline);
			
		}
		
		
		
	}

	public void actionPerformed(ActionEvent e) {
		Object input = e.getSource();
		
		if(input == JButton_Play){
			JPanel_SetupPanel.removeAll();
			drawlocalOrOnline();
			reDrawSetupScreen();
		}else if(input == JButton_PlayLocal){
			JPanel_SetupPanel.removeAll();
			setupScreen.draw();
			reDrawSetupScreen();
		}else if (input == setupScreen.Jbutton_back){
			JPanel_SetupPanel.removeAll();
			drawlocalOrOnline();
			reDrawSetupScreen();
		}else if (input == swing.quit){
			window.removeAll();
			swing = new SwingEngine();
			drawMenu();	
			JButton_Play.setEnabled(true);
		}else if (input == setupScreen.JButton_play){
			window.removeAll();
			
			swing.init(window, this, setupScreen.getMaxRounds());
			swing.localSetup();
			swing.startGame(setupScreen.playersAmount);
			
		}else if (input == JButton_addPlayer){
			
			server.sendFriendInvite(JTextField_AddFriend.getText());
			JTextField_AddFriend.setText("");
			
		}else if (input.getClass().toString().equals("class javax.swing.JButton")){
			
			JButton jb = (JButton) input;
			jb.setEnabled(false);
			server.acceptinvite(jb.getName());
			
			
		}
		
		
		
		
		
		
		
		
	}
}