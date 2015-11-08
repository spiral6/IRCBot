import java.awt.*;
import java.util.ArrayList;

import org.jibble.pircbot.PircBot;

public class MyThread extends Thread{
	
	String CHANNEL = "#spiral6";
	ArrayList<String> arr;
	
	public MyThread(ArrayList<String> lol){
		arr = new ArrayList<String>();
		arr.addAll(lol);
	}
	
	public void run(){
					Robot robot;
					
					try {
						robot = new Robot();
						if(arr.get(0).equalsIgnoreCase("!up")){
							
							robot.mouseMove(434, 443);
							System.out.print("fshfhsfs");
							
						}
						
						else if(arr.get(0).equalsIgnoreCase("!forward")){
							if(arr.size() > 1){
								
								long length = Long.parseLong(arr.get(1));
								robot.keyPress(java.awt.event.KeyEvent.VK_W);
								System.out.println("rofl");
								
								this.sleep(length*1000);
								robot.keyRelease(java.awt.event.KeyEvent.VK_W);
								
								
								//MHandler.sendMessage(CHANNEL, "lol it'no t fa");
							}
							else{
								IRCTest.args.clear();
								robot.keyPress(java.awt.event.KeyEvent.VK_W);
								this.sleep(0);
								robot.keyRelease(java.awt.event.KeyEvent.VK_W);
							}
						}
						
						
					
						
					}
					catch (AWTException | InterruptedException | NumberFormatException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
	}
	
}