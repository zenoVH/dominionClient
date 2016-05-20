package SwingEngine;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameEngine.*;

public class SwingEngine implements MouseListener, ActionListener {
	
	ActionListener action;
	Container window;
	
	//JButtons
	public JButton quit = new JButton("Quit");
	JButton save = new JButton("Save and Quit");
	
	private JButton buyCopper = new JButton("Buy a Copper Card");
	private JButton buySilver = new JButton("Buy a Silver Card");
	private JButton buyGold = new JButton("Buy a Gold Card");
	private JButton buyEstate = new JButton("Buy a Estate Card");
	private JButton buyDutchy = new JButton("Buy a Dutchy Card");
	private JButton buyProvince = new JButton("Buy a Province Card");
	private JButton endTurn = new JButton("End your Turn");
	
	//JLabels
	JLabel currentPlayer = new JLabel();
	JLabel round = new JLabel();
	JLabel actions = new JLabel();
	JLabel buys = new JLabel();
	JLabel money = new JLabel();
	
	//Jpanels
	JPanel jpHand = new JPanel();
	JPanel jpPlayedCards = new JPanel();
	JPanel jpActionStore = new JPanel();
	ArrayList<JLabel> handSlots = new ArrayList<JLabel>();
	ArrayList<JLabel> actionSlots = new ArrayList<JLabel>();
	
	//Engine
	GameEngine game = new GameEngine();
	
	public SwingEngine(){}
	
	public void init(Container window, ActionListener action){
		
		this.window = window;
		this.action = action;
		
	}
	
	public void localSetup(){
		
		window.setLayout(new FlowLayout());
		window.setBackground(Color.gray);
		
			//JPanels
			JPanel Column1 = new JPanel();
			Column1.setPreferredSize(new Dimension(150, 760));
			Column1.setBackground(Color.WHITE);
			window.add(Column1);
			
			JPanel Column2 = new JPanel();
			Column2.setPreferredSize(new Dimension(150, 760));
			Column2.setBackground(Color.WHITE);
			window.add(Column2);
			
			JPanel Column3 = new JPanel();
			Column3.setPreferredSize(new Dimension(665, 760));
			Column3.setBackground(Color.GRAY);
			window.add(Column3);
			
			JPanel Column4 = new JPanel();
			Column4.setPreferredSize(new Dimension(200, 760));
			Column4.setBackground(Color.WHITE);
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
			spacer.setBackground(Color.WHITE);
			Column1.add(spacer);
			
			//currentPlayer
			JPanel curPlayer = new JPanel();
			curPlayer.setPreferredSize(new Dimension(130, 170));
			curPlayer.setBackground(Color.white);
			curPlayer.add(currentPlayer);
			curPlayer.add(round);
			Column1.add(curPlayer);
			
			//spacer
			spacer = new JPanel();
			spacer.setPreferredSize(new Dimension(140, 180));
			spacer.setBackground(Color.WHITE);
			Column2.add(spacer);
			
			//Trash
			JPanel jpTrash = new JPanel();
			jpTrash.setPreferredSize(new Dimension(140, 180));
			jpTrash.setBackground(Color.WHITE);
			jpTrash.add(new JLabel("Trash"));
			Column2.add(jpTrash);
			
			//action,buys,money
			JPanel jpActions = new JPanel();
			jpActions.setPreferredSize(new Dimension(140, 375));
			jpActions.setBackground(Color.WHITE);
			Column2.add(jpActions);
			
			actions.setPreferredSize(new Dimension(100, 50));
			buys.setPreferredSize(new Dimension(100, 50));
			money.setPreferredSize(new Dimension(100, 50));
			
			jpActions.add(actions);
			jpActions.add(buys);
			jpActions.add(money);
			
			//To buy action cards
			jpActionStore.setPreferredSize(new Dimension(655, 365));
			jpActionStore.setBackground(Color.WHITE);
			Column3.add(jpActionStore);
			
			//playedCards
			jpPlayedCards.setPreferredSize(new Dimension(655, 185));
			jpPlayedCards.setBackground(Color.WHITE);
			Column3.add(jpPlayedCards);
			
			//hand
			jpHand.setPreferredSize(new Dimension(655, 185));
			jpHand.setBackground(Color.WHITE);
			Column3.add(jpHand);
			
			//store
			JPanel jpStore = new JPanel();
			jpStore.setPreferredSize(new Dimension(190, 555));
			jpStore.setBackground(Color.WHITE);
			Column4.add(jpStore);
			
			buyCopper.setPreferredSize(new Dimension(180, 60));
			buyCopper.addActionListener(this);
			jpStore.add(buyCopper);
			buySilver.setPreferredSize(new Dimension(180, 60));
			buySilver.addActionListener(this);
			jpStore.add(buySilver);
			buyGold.setPreferredSize(new Dimension(180, 60));
			buyGold.addActionListener(this);
			jpStore.add(buyGold);
			buyEstate.setPreferredSize(new Dimension(180, 60));
			buyEstate.addActionListener(this);
			jpStore.add(buyEstate);
			buyDutchy.setPreferredSize(new Dimension(180, 60));
			buyDutchy.addActionListener(this);
			jpStore.add(buyDutchy);
			buyProvince.setPreferredSize(new Dimension(180, 60));
			buyProvince.addActionListener(this);
			jpStore.add(buyProvince);
			
			endTurn.setPreferredSize(new Dimension(180, 155));
			endTurn.setBackground(Color.white);
			endTurn.addActionListener(this);
			jpStore.add(endTurn);
			
			//deck
			JPanel jpDeck = new JPanel();
			jpDeck.setPreferredSize(new Dimension(190, 185));
			jpDeck.setBackground(Color.WHITE);
			Column4.add(jpDeck);
			
			JLabel deckImage = new JLabel();
			deckImage.setIcon(loadImage.load(SwingEngine.class, "cards/back.png"));
			jpDeck.add(deckImage);
			
			window.revalidate();
			window.repaint();
			
			//ActionListeners
			quit.addActionListener(action);
		
	}

	public void startGame(int players){
		
		game.init(players);
		refreshScreen();
		drawActionCards();
		
	}
	
	public void drawHandCards(ArrayList<card> hand){
		
		jpHand.removeAll();
		handSlots.clear();
		
		for (int i = 0; i < hand.size(); i++) {
						
			JLabel cardPanel = new JLabel();
			cardPanel.addMouseListener(this);
			cardPanel.setIcon(loadImage.load(SwingEngine.class, hand.get(i).getUrl()));
			jpHand.add(cardPanel);
			
			handSlots.add(cardPanel);
			
		}
		
		jpHand.revalidate();
		jpHand.repaint();

	}
	
	public void drawPlayedCards(ArrayList<card> hand){
		
		jpPlayedCards.removeAll();
		
		for (int i = 0; i < hand.size(); i++) {
		
			drawCard(jpPlayedCards, hand.get(i));
			
		}
		
		jpPlayedCards.revalidate();
		jpPlayedCards.repaint();

	}
	
	public void drawActionCards(){
		
		jpActionStore.removeAll();
		
		for (int i = 0; i < game.getActionCards().size(); i++) {
			
			JLabel background = new JLabel();
	        background.setIcon(loadImage.load(SwingEngine.class, game.getActionCards().get(i).getUrl()));
	        background.addMouseListener(this);
	        jpActionStore.add(background);
			
	        actionSlots.add(background);
			
		}
		
		jpActionStore.revalidate();
		jpActionStore.repaint();
		
	}
	
	public void drawCard(JPanel dest, card card){
		
		JLabel background = new JLabel();
		background.setPreferredSize(new Dimension(110, 175));
        background.setIcon(loadImage.load(SwingEngine.class, card.getUrl()));
        background.setBackground(Color.BLACK);
        dest.add(background);
		
	}
	
	public ImageIcon getImageURL(String url) {
        try {
            return new ImageIcon(ImageIO.read(new URL(url)));
        } catch (IOException e) {
            return null;
        }
    }

	private void refreshScreen(){
		
		//update stats
		money.setText("Coins: "+game.getPlayer().getCurrentCoins());
		buys.setText("Buys: "+game.getPlayer().getBuys());
		actions.setText("Actions: "+game.getPlayer().getActions());
		currentPlayer.setText(game.getPlayer().getName());
		round.setText("Round: "+game.getRound());
		
		
		drawHandCards(game.getPlayer().getHandCards());
		drawPlayedCards(game.getPlayer().getPlayedCards());
		
	}

	
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------
	//									CLICK EVENTS
	// ---------------------------------------------------------------------------------------------------------------------------------------------------------------------

	@Override
	public void mouseClicked(MouseEvent arg0) {
		
		Object source = arg0.getSource();
		
		for (int i = 0; i < handSlots.size(); i++) {
			
			if(source == handSlots.get(i)){
				
				game.cardInHandClicked(i);
				refreshScreen();
				
			}
			
		}
		
		for (int ii = 0; ii < actionSlots.size(); ii++) {
			
			if(source == actionSlots.get(ii)){
				
				game.buyCard(game.getActionCards().get(ii));
				refreshScreen();
				
			}
			
		}
		
		
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		
		if(source == buyCopper){
			game.buyCard(cardtype.COPPER.add());
		}
		else if(source == buySilver){
			game.buyCard(cardtype.SILVER.add());
		}
		else if(source == buyGold){
			game.buyCard(cardtype.GOLD.add());
		}
		else if(source == buyEstate){
			game.buyCard(cardtype.ESTATE.add());
		}
		else if(source == buyDutchy){
			game.buyCard(cardtype.DUTCHY.add());
		}
		else if(source == buyProvince){
			game.buyCard(cardtype.PROVINCE.add());
		}else if (source == endTurn){
			
			game.nextTurn();
			
		}
		
		refreshScreen();
		
		
		
	}
}
