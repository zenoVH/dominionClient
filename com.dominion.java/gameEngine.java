import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class gameEngine implements ActionListener,MouseListener {
	
	//Engine
	private graphicsEngine graphicsEngine;
	private Container window;
	
	//logic
	private String mode;
	private int playersCount;
	private ArrayList<player> players = new ArrayList<player>();
	
	private int currentPlayer = 1;
	
	
	
	public gameEngine(Container window, String mode, int playersCount){
		this.window = window;
		this.mode = mode;
		this.playersCount = playersCount;
	}
	
	public void start(){
		initPlayers();
		graphicsEngine = new graphicsEngine();
		graphicsEngine.init(window, this);
		graphicsEngine.localSetup(this);
		
		fillHand();
	}
	
	public void initPlayers(){
		
		//create Players
		for (int i = 0; i < playersCount; i++) {
			players.add(new player("Player "+(i+1)));
		}
	}
	
	public void fillHand(){
		
		for (int i = 0; i < 5; i++) {
			players.get(currentPlayer - 1).addHandCard(players.get(currentPlayer - 1).getDeck().getCards().get(0));
			players.get(currentPlayer - 1).getDeck().getCards().remove(0);
		}
		
		graphicsEngine.drawHandCards(players.get(currentPlayer - 1).getHandCards());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	//GETTERS & Setters
	public graphicsEngine getGraphicsEngine(){
		return graphicsEngine;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object source = e.getSource();
		int index;
		
		for (int i = 0; i < graphicsEngine.getHandSlots().size(); i++) {
			if(source == graphicsEngine.getHandSlots().get(i)){
				index = i;
				System.out.println(players.get(currentPlayer - 1).getHandCards().get(index).getName());
				
				//if money add it
				if(players.get(currentPlayer - 1).getHandCards().get(index).getType().equals("coin")){
					players.get(currentPlayer - 1).addCoins(players.get(currentPlayer - 1).getHandCards().get(index).getValue());
					graphicsEngine.setMoney(players.get(currentPlayer - 1).getCurrentCoins());
				}
				
				//add card to played cards
				players.get(currentPlayer - 1).addPlayedCard(players.get(currentPlayer - 1).getHandCards().get(index));
				
				//remove from deck
				players.get(currentPlayer - 1).getHandCards().remove(index);
				
				//draw hand/played
				graphicsEngine.drawHandCards(players.get(currentPlayer - 1).getHandCards());
				graphicsEngine.drawPlayedCards(players.get(currentPlayer - 1).getPlayedCards());
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
