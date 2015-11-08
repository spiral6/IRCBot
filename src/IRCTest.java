import org.jibble.pircbot.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IRCTest extends PircBot{
	public static ArrayList<String> args = new ArrayList<String>();
	//Robot robot = new Robot();
	static int xRes = 0;
	static int yRes = 0;

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
    	Scanner kb = new Scanner(System.in);
    	System.out.println("What is the value of your xResolution?");
    	xRes = kb.nextInt();
    	System.out.println("What is the value of your yResolution?");
    	yRes = kb.nextInt();
    	
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