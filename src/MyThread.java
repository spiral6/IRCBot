import java.awt.*;

import org.jibble.pircbot.PircBot;

public class MyThread extends Thread{
	PircBot MHandler;
	boolean ending=false;
	int ID=0;
	static String CHANNEL = "";
	public MyThread(int id, String channel){
		ID=id;
		CHANNEL = channel;
	}
	public void run(){
		//ending=false;
		while(ending!=true){
			if(ID==1){ //lookthread
				Robot robot;
				try {
					robot = new Robot();
					if(IRCTest.args.get(0).equalsIgnoreCase("!up")){
						robot.mouseMove(434, 443);
					}
				}
				catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ID==2){//movethread
				Robot robot;
				try {
					robot = new Robot();
					
					if(IRCTest.args.get(0).equalsIgnoreCase("forward")){
						if(IRCTest.args.size() > 1){
							long length = Long.parseLong(IRCTest.args.get(1));
							robot.keyPress(java.awt.event.KeyEvent.VK_W);
							System.out.println("roflsfsz");
							
							this.sleep(length*100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_W);
							
							MHandler.sendMessage(CHANNEL, "lol it'no t fa");
							ending=true;
						}
					}
					else{
					robot.keyPress(java.awt.event.KeyEvent.VK_W);
					this.sleep(0);
					robot.keyRelease(java.awt.event.KeyEvent.VK_W);
					ending=true;
					}
				
				
				
				
				}
				
				catch (AWTException | InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		if(ID==3){//actionthread
			
		}
	}
	
	}
}
