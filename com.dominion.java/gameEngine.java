import java.util.ArrayList;

public class gameEngine {
	
	private String mode;
	private int playersCount;
	private ArrayList<player> players = new ArrayList<player>();
	
	public gameEngine(String mode, int playersCount){
		this.mode = mode;
		this.playersCount = playersCount;
	}
	
	public void initPlayers(){
		
		//create Players
		for (int i = 0; i < playersCount; i++) {
			players.add(new player("Player "+(i+1)));
		}
		
	}

}
