package NetworkEngine;
import java.io.Serializable;

public class friend implements Serializable {
	
	private String name;
	private boolean online;
	
	public friend(String name, boolean online){
		this.name = name;
		this.online = online;
	}
	
	public String name(){return name;}
	public boolean online(){return online;}

}
