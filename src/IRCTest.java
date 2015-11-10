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
	static String host = "";

	public IRCTest(){
		this.setName(user);
	}
	
	public IRCTest(String x, String y, String host, String username, String ch, String pass){
		 xRes = Integer.parseInt(x);
		 yRes = Integer.parseInt(y);
		 oAuth = pass;
		 user = username;
		 channel = ch;
		 this.host = host;
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
    	// Now start our bot up.
        IRCTest bot = new IRCTest();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect(host, 6667, oAuth);

        // Join the #pircbot channel.
        bot.joinChannel(channel);
        
        kb.close();
    }
}