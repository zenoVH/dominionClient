import java.util.ArrayList;

public class player {
	
	private String name;
	private	deck deck;
	private int currentCoins = 0;
	private ArrayList<card> handCards = new ArrayList<card>();
	private ArrayList<card> playedCards = new ArrayList<card>();
	
	public player(String name){
		this.name = name;
		deck = new deck();
	}
	
	//Getters
	
	public deck getDeck(){
		return deck;
	}
	
	public ArrayList<card> getHandCards(){
		return handCards;
	}
	
	public ArrayList<card> getPlayedCards(){
		return playedCards;
	}
	
	public int getCurrentCoins(){
		return currentCoins;
	}
	
	//Setters
	public void addHandCard(card card){
		handCards.add(card);
		System.out.println(name+" received "+card.getName()+" in hand");
	}
	
	public void addPlayedCard(card card){
		playedCards.add(card);
		System.out.println(name+" played "+card.getName());
	}
	
	public void addCoins(int c){
		currentCoins += c; 
	}
}
