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
						
						
						
						
						
						if(arr.get(0).equalsIgnoreCase("!right")){
							if(arr.size()>1){
								long degrees= Long.parseLong(arr.get(1));
								for(int i=0;i<(degrees*5.6);i++){ //5.6 pixels per degree
									robot.mouseMove(802,450);
									sleep(10);
								}	
							}	
						}
						
						else if(arr.get(0).equalsIgnoreCase("!left")){
							if(arr.size()>1){
								long degrees= Long.parseLong(arr.get(1));
								for(int i=0;i<(degrees*5.6);i++){ //5.6 pixels per degree
									robot.mouseMove(798,450);
									sleep(10);
								}	
							}	
						}
						
						else if(arr.get(0).equalsIgnoreCase("!down")){ //up goes down?
							if(arr.size()>1){
								long degrees= Long.parseLong(arr.get(1));
								for(int i=0;i<(degrees*5.6);i++){ //13 pixels per degree
									robot.mouseMove(800,452);
									sleep(10);
								}
							}	
						}
						
						else if(arr.get(0).equalsIgnoreCase("!up")){ //down goes up?
							if(arr.size()>1){
								long degrees= Long.parseLong(arr.get(1));
								for(int i=0;i<(degrees*5.6);i++){ //13 pixels per degree
									robot.mouseMove(800,448);
									sleep(10);
								}
							}
						}
						
						else if(arr.get(0).equalsIgnoreCase("!forward")){
							if(arr.size() > 1){
								
								long length = Long.parseLong(arr.get(1));
								robot.keyPress(java.awt.event.KeyEvent.VK_W);
								System.out.println("rofl");
								
								this.sleep(length*1000);
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