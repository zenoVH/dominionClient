import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class graphicsEngine {
	
	ActionListener action;
	private int players;
	private String mode;
	
	//JButtons
	JButton quit = new JButton("Quit");
	JButton save = new JButton("Save and Quit");
	
	//JLabels
	JLabel currentPlayer = new JLabel("Player 1");
	JLabel actions = new JLabel("Actions");
	JLabel buys = new JLabel("Buys");
	JLabel money = new JLabel("Coins");
	
	public graphicsEngine(String mode,int players){
		this.players = players;
		this.mode = mode;
	}
	
	public void init(Container window, ActionListener action){
		this.action = action;
		if(mode.equals("local")){
			localSetup(window);
		}else if(mode.equals("online")){
			
		}
	}
	
	public void localSetup(Container window){
		
		window.setLayout(new FlowLayout());
		window.setBackground(Color.GREEN);
		
			//JPanels
			JPanel Column1 = new JPanel();
			Column1.setPreferredSize(new Dimension(150, 760));
			Column1.setBackground(Color.CYAN);
			window.add(Column1);
			
			JPanel Column2 = new JPanel();
			Column2.setPreferredSize(new Dimension(150, 760));
			Column2.setBackground(Color.CYAN);
			window.add(Column2);
			
			JPanel Column3 = new JPanel();
			Column3.setPreferredSize(new Dimension(665, 760));
			Column3.setBackground(Color.CYAN);
			window.add(Column3);
			
			JPanel Column4 = new JPanel();
			Column4.setPreferredSize(new Dimension(200, 760));
			Column4.setBackground(Color.CYAN);
			window.add(Column4);
			
			//Save and Quit
			quit.setPreferredSize(new Dimension(130, 80));
			quit.setBackground(Color.WHITE);
			save.setPreferredSize(new Dimension(130, 80));
			save.setBackground(Color.WHITE);
			Column1.add(quit);
			Column1.add(save);
			
			//spacer
			JPanel spacer = new JPanel();
			spacer.setPreferredSize(new Dimension(130, 400));
			spacer.setBackground(Color.gray);
			Column1.add(spacer);
			
			//currentPlayer
			JPanel curPlayer = new JPanel();
			curPlayer.setPreferredSize(new Dimension(130, 170));
			curPlayer.setBackground(Color.white);
			curPlayer.add(currentPlayer);
			Column1.add(curPlayer);
			
			//spacer
			spacer = new JPanel();
			spacer.setPreferredSize(new Dimension(140, 180));
			spacer.setBackground(Color.gray);
			Column2.add(spacer);
			
			//Trash
			JPanel jpTrash = new JPanel();
			jpTrash.setPreferredSize(new Dimension(140, 180));
			jpTrash.setBackground(Color.gray);
			jpTrash.add(new JLabel("Trash"));
			Column2.add(jpTrash);
			
			//action,buys,money
			JPanel jpActions = new JPanel();
			jpActions.setPreferredSize(new Dimension(140, 375));
			jpActions.setBackground(Color.gray);
			Column2.add(jpActions);
			
			actions.setPreferredSize(new Dimension(100, 50));
			buys.setPreferredSize(new Dimension(100, 50));
			money.setPreferredSize(new Dimension(100, 50));
			
			jpActions.add(actions);
			jpActions.add(buys);
			jpActions.add(money);
			
			//To buy action cards
			JPanel jpActionStore = new JPanel();
			jpActionStore.setPreferredSize(new Dimension(655, 365));
			jpActionStore.setBackground(Color.gray);
			Column3.add(jpActionStore);
			
			//playedCards
			JPanel jpPlayedCards = new JPanel();
			jpPlayedCards.setPreferredSize(new Dimension(655, 185));
			jpPlayedCards.setBackground(Color.gray);
			Column3.add(jpPlayedCards);
			
			//hand
			JPanel jpHand = new JPanel();
			jpHand.setPreferredSize(new Dimension(655, 185));
			jpHand.setBackground(Color.gray);
			Column3.add(jpHand);
			
			//store
			JPanel jpStore = new JPanel();
			jpStore.setPreferredSize(new Dimension(190, 555));
			jpStore.setBackground(Color.gray);
			Column4.add(jpStore);
			
			//deck
			JPanel jpDeck = new JPanel();
			jpDeck.setPreferredSize(new Dimension(190, 185));
			jpDeck.setBackground(Color.gray);
			Column4.add(jpDeck);
			
			
			window.revalidate();
			window.repaint();
			
			//ActionListeners
			quit.addActionListener(action);
		
	}
}
