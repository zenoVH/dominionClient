package NetworkEngine;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.UUID;

import org.gnet.client.ClientEventListener;
import org.gnet.client.GNetClient;
import org.gnet.client.ServerModel;
import org.gnet.packet.Packet;

public class netEngineClient {
	
	//Server info
	private ServerModel server;
	private boolean connectedToPublicServer = false;
	private String host = "178.116.35.75";
	private int port = 6001;
	private GNetClient networkedClient;
	public boolean updated = false;
		
	//User Info
	private UUID id;
	private String username;
	private ArrayList<String> invites = new ArrayList<String>();
	private ArrayList<String> friendsName = new ArrayList<String>();
	private ArrayList<Boolean> friendsStatus = new ArrayList<Boolean>();
	
	public netEngineClient(){
		
		loadSetting();
		
		networkedClient = new GNetClient(host, port);
		
		networkedClient.setDebugging(false);
		networkedClient.addEventListener(new ClientEventListener() {

		protected void clientConnected(ServerModel s) {
			   
			   connectedToPublicServer = true;
			   server = s;
			   authenticate();
			   
		}

		protected void clientDisconnected(ServerModel server) {
			   
			   connectedToPublicServer = false;

		}

		protected void packetReceived(ServerModel server, Packet packet) {
			   
			   switch (packet.getPacketName()) {
			   
			   		case "authconfirm":	id = (UUID) packet.getEntry("uuid");	break;
			   		
			   		case "authdeny":	break;
			   		
			   		case "invites": invites = (ArrayList<String>) packet.getEntry("invites"); updated = true;	break;
			   		
			   		case "friends": friendsName = (ArrayList<String>) packet.getEntry("friendsName"); friendsStatus = (ArrayList<Boolean>) packet.getEntry("friendsStatus"); updated = true;	break;
					
				default:
					break;
				}
			   
		}

		protected void debugMessage(String msg) {}
		protected void errorMessage(String msg) {}
		
		});

		connectToServer();
		
	}
	
	//Private functions
	
	private void loadSetting(){
		Properties prop = new Properties();
		InputStream input = null;
		
		try {
			
			input = new FileInputStream("settings.properties");
			prop.load(input);
			
			host = prop.getProperty("ip");
			port = (int) Integer.parseInt(prop.getProperty("port"));
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
	//Public functions
	
	public void authenticate(){
		
		if(username != null){
			Packet packet = new Packet("auth", 2);
			packet.addEntry("username", username);
			//TODO password
			server.sendPacket(packet);
		}
	}
	
	public void connectToServer(){
		networkedClient.bind();
		networkedClient.start();
	}
	
	public void sendFriendInvite(String username){
		
		Packet packet = new Packet("friendinvite", 2);
		packet.addEntry("uuid", id);
		packet.addEntry("username", username);
		server.sendPacket(packet);
		
	}
	
	public void sendInvitesRequest(){
		
		Packet packet = new Packet("getinvites", 1);
		packet.addEntry("uuid", id);
		server.sendPacket(packet);
		
	}
	
	public void sendFriendRequest(){
		
		Packet packet = new Packet("getfriends", 1);
		packet.addEntry("uuid", id);
		server.sendPacket(packet);
		
	}
	
	public void acceptinvite(String username){
		
		Packet packet = new Packet("acceptinvite",2);
		packet.addEntry("uuid", id);
		packet.addEntry("username", username);
		server.sendPacket(packet);
		
	}
	
	// Setters
	
	public void setUsername(String username){this.username = username;}

	
	//Getters
	
	public boolean online(){return connectedToPublicServer;}
	public ArrayList<String> invites(){return invites;}
	public ArrayList<String> friendsName(){return friendsName;}
	public ArrayList<Boolean> friendsStatus(){return friendsStatus;}
}
