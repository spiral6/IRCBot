import org.jibble.pircbot.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class IRCTest extends PircBot{
	public static ArrayList<String> args = new ArrayList<String>();
	//Robot robot = new Robot();
	static int xRes = 0;
	static int yRes = 0;
	static String oAuth = "";
	static String user = "";
	static String channel = "";

	public IRCTest(){
		this.setName("spiral6");
	}
	
	public void message(String s){
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
    	System.out.println("What is the channel you're connecting to? (include #)");
    	channel = kb.next();
    	System.out.println("What is your username?");
    	user = kb.next();
    	System.out.println("What is your oAuth password?");
    	oAuth = kb.next();
    	
    	// Now start our bot up.
        IRCTest bot = new IRCTest();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect("irc.twitch.tv", 6667, oAuth);

        // Join the #pircbot channel.
        bot.joinChannel(channel);
    }
}