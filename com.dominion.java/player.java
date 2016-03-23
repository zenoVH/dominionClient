
public class player {
	
	private String name;
	private	deck deck;
	
	public player(String name){
		this.name = name;
		deck = new deck();
	}
	
	public deck getDeck(){
		return deck;
	}

}
