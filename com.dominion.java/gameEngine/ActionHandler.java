package gameEngine;

public class ActionHandler {
	
	private GameEngine game;
	
	public ActionHandler(GameEngine game){
		this.game = game;
	}
	
	public void actionCard(card c){
		
		player player = game.getPlayer();
		
		switch (c.getName()) {
		case "Market":
			
			player.addCard(1);
			player.addActions(1);
			player.addBuys(1);
			player.addCoins(1);
			
			break;
			
		case "Workshop":
			player.addCoins(4);
			break;
			
		case "Bureaucrat":
			player.addSpecificCard(cardtype.SILVER.add(), 0);
			break;
			
		case "Adventurer":
			player.addSpecificCard(cardtype.ESTATE.add(), 0);
			player.addSpecificCard(cardtype.ESTATE.add(), 0);
			break;	
			
		case "Cellar":
			//TODO
			break;	
			
		case "Chancellor":
			//TODO
			break;	
			
		case "Chapel":
			//TODO
			break;		
		
		case "Council room":
			for (int i = 0; i < game.getPlayers().size(); i++) {
				game.getPlayers().get(i).addCard(1);
			}
			break;	
			
		case "Feast":
			player.addCoins(5);
			break;	
			
		case "Festival":
			player.addActions(2);
			player.addBuys(1);
			player.addCoins(2);
			break;	
		
		case "Gardens":
			int amount = player.getDeck().getCards().size() / 10;
			player.victoryPoints += amount;
			break;	
			
		case "Laboratory":
			player.addActions(1);
			player.addCard(2);
			break;	
			
		case "Library":
			int cards = 7 - player.getHandCards().size();
			if(cards > 0) player.addCard(cards);
			break;
			
		case "Militia":
			//TODO
			break;
			
		case "Mine":
			//TODO
			break;	
			
		case "Moat":
			//TODO
			break;	
			
		case "Moneylender":
			//TODO
			break;	
			
		case "Remodel":
			//TODO
			break;		
			
		case "Smithy":
			//TODO
			break;		

		default:
			break;
		}
	}

}
