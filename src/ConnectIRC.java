import org.jibble.pircbot.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class ConnectIRC extends PircBot{
	public static ArrayList<String> args = new ArrayList<String>();
	//Robot robot = new Robot();
	static int xRes = 0;
	static int yRes = 0;
	static String oAuth = "";
	static String user = "";
	static String channel = "";
	static String host = "";
	File gameconfigs;

	public ConnectIRC(){
		this.setName(user);
	}
	
	@SuppressWarnings("static-access")
	public ConnectIRC(String x, String y, String host, String username, String ch, String pass, File Thisfile){
		 xRes = Integer.parseInt(x);
		 yRes = Integer.parseInt(y);
		 oAuth = pass;
		 user = username;
		 channel = ch;
		 this.host = host;
		 gameconfigs= Thisfile;
	}
	
	/*public static void message(String s){
		sendMessage(channel, s);
	}*/
	
	public void onMessage(String channel, String sender, String login, String hostname, String message){
			String[] arr = message.split("\\s+");
			for(String s: arr){  
				System.out.println(s);
				args.add(s);
			}
			new MyThread(args,gameconfigs).start();
			args.clear();
    }
	
    public static void main(String[] args) throws Exception{
    	Scanner kb = new Scanner(System.in);
    	// Now start our bot up.
        ConnectIRC bot = new ConnectIRC();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect(host, 6667, oAuth);
        // Join the #pircbot channel.
        bot.joinChannel(channel);
        
        kb.close();
    }
}