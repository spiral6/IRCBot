import org.jibble.pircbot.*;
import java.awt.*;

public class IRCTest extends PircBot{

	//Robot robot = new Robot();

	public IRCTest(){
		this.setName("spiral6");
	}
	
	public void onMessage(String channel, String sender, String login, String hostname, String message){
        if (message.equalsIgnoreCase("!time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + ": The time is now " + time);
            Robot robot;
			try {
				robot = new Robot();
				robot.mouseMove(1200, 400);
			} catch (AWTException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
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