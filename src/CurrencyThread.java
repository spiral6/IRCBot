import org.jibble.pircbot.*;
import java.util.ArrayList;
public class CurrencyThread extends Thread{
	static ConnectIRC botbot;
	ArrayList<String> currentusers;
	
	public static void main(String[] args) {

	}
	public void runDefault(ConnectIRC bot){
		botbot=bot;
		this.start();
	}
	public void run(){
		while(true){
			for(User a : botbot.getUsers(ConnectIRC.channel))
			currentusers.add(a.getNick());
		}
		
	}
}
