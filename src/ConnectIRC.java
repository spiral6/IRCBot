import org.jibble.pircbot.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class ConnectIRC extends PircBot{
	public static ArrayList<String> args = new ArrayList<String>();
	public static int xRes = 0;
	public static int yRes = 0;
	public static String oAuth = "";
	public static String user = "";
	public static String channel = "";
	public static String host = "";
	public static File gameconfigs;
	public static CurrencyThread ct;
	public static ConnectIRC bot;
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
		 gameconfigs = Thisfile;
		 ct= new CurrencyThread();
	}
	
	/*public static void message(String s){
		sendMessage(channel, s);
	}*/
	
	public void onMessage(String channel, String sender, String login, String hostname, String message){
			String[] arr = message.split("\\s+");
			for(String s: arr){  
				args.add(s);
			}
			System.out.println(args.get(0));
			new MyThread(args,gameconfigs,xRes,yRes).start();
			args.clear();
    }
	
    public static void main(String[] args) throws Exception{
    	Scanner kb = new Scanner(System.in);
    	// Now start our bot up.
        bot = new ConnectIRC();
        
        // Enable debugging output.
        bot.setVerbose(true);
        
        // Connect to the IRC server.
        bot.connect(host, 6667, oAuth);
        // Join the #pircbot channel.
        bot.joinChannel(channel);
        ct.runDefault(bot);
        kb.close();
    }
}