package NetworkEngine;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

import org.gnet.server.ClientModel;

public class user implements Serializable{
	
	private UUID id;
	private ClientModel client;
	private String nickName;
	private ArrayList<user> friends = new ArrayList<user>();
	private boolean online = false;
	
	public user(ClientModel c, String nick){
		
		id = UUID.randomUUID();
		client = c;
		nickName = nick;
		
	}
	
	public UUID uuid(){return id;}
	public ClientModel client(){return client;}
	public String nickName(){return nickName;}
	public ArrayList<user> friends(){return friends;};
	public boolean online(){return online;}
	
	public void setOnline(boolean b){online = b;}

}
