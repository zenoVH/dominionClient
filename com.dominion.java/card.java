
public class card {
	
	private String type;
	private String name;
	private String description;
	private int value;
	private int cost;
	public action action;
	
	public card(String type, String name, String description, int value, int cost){
		
		this.type = type;
		this.name = name;
		this.description = description;
		this.value = value;
		this.cost = cost;
		
	}
	
	public String getType(){
		return type;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
	public int getValue(){
		return value;
	}
	
	public int getCost(){
		return cost;
	}

}
