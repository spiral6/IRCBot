import org.jibble.pircbot.*;
import java.awt.*;
import java.util.ArrayList;

public class IRCTest extends PircBot{
	public static ArrayList<String> args = new ArrayList<String>();
	MyThread lookthread = new MyThread(1,"#spiral6");
    MyThread movethread = new MyThread(2,"#spiral6");
    MyThread actionthread = new MyThread(3,"#spiral6");
	//Robot robot = new Robot();

	public IRCTest(){
		this.setName("spiral6");
	}
	
	public void message(String channel, String s){
		sendMessage(channel, s);
	}
	
	public void onMessage(String channel, String sender, String login, String hostname, String message){
		Robot robot;
		try{
			robot = new Robot();
			String[] arr = message.split("\\s+");
			for(String s: arr){  
				System.out.println(s);
				args.add(s);
			}
			switch(args.get(0)){
			case "!forward":movethread.start();break;
			case "!backward":movethread.start();break;
			case "!up":lookthread.start();break;
			
			
			
			
			
			}
			
			if (args.get(0).equalsIgnoreCase("!time")) {
	            String time = new java.util.Date().toString();
	            sendMessage(channel, sender + ": The time is now " + time);
				robot.mouseMove(1200, 400);
	        }
		
		}
		catch(AWTException e1){
			e1.printStackTrace();
		}
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