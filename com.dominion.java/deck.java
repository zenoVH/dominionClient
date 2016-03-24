import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class deck {
	
	private ArrayList<card> cards;
	
	public deck(){
		cards = new ArrayList<card>();
		
		//add 7 copper cards
		for (int i = 0; i < 7; i++) {
			cards.add(new card("coin","copper","Coin with Value 1",1,0));
		}
		
		//add 3 estate cards
		for (int i = 0; i < 3; i++) {
			cards.add(new card("victory","estate","",1,2));
		}
		
		shuffleDeck();
	}
	
	public void shuffleDeck(){
		
		long seed = System.nanoTime();
		Collections.shuffle(cards, new Random(seed));
		
	}
	
	public ArrayList<card> getCards(){
		return cards;
	}

}
