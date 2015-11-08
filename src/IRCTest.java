import org.jibble.pircbot.*;
import java.awt.*;
import java.util.ArrayList;

public class IRCTest extends PircBot{
	public static ArrayList<String> args = new ArrayList<String>();
	//Robot robot = new Robot();

	public IRCTest(){
		this.setName("spiral6");
	}
	
	public void message(String channel, String s){
		sendMessage(channel, s);
	}
	
	public void onMessage(String channel, String sender, String login, String hostname, String message){
			String[] arr = message.split("\\s+");
			for(String s: arr){  
				System.out.println(s);
				args.add(s);
			}
			new MyThread(args).start();
			args.clear();
    }
	
    public static void main(String[] args) throws Exception{
    	 // Now start our bot up.
        IRCTest bot = new IRCTest();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect("irc.twitch.tv", 6667, "oauth:a5ajv9ufw0ek72qbix3t8zpri64t64");

        // Join the #pircbot channel.
        bot.joinChannel("#spiral6"); 
    }
}