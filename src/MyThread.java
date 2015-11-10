import java.awt.*;
import java.util.ArrayList;

import org.jibble.pircbot.PircBot;

public class MyThread extends Thread{
	
	//String CHANNEL = "#spiral6";
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
								float degrees= Float.parseFloat(arr.get(1));
								if(degrees<=180){
									for(int i=0;i<(degrees*5.6);i++){ //5.6 pixels per degree
										robot.mouseMove(IRCTest.xRes/2+2,IRCTest.yRes/2);
										sleep(10);
									}
								}
							}	
						}
						
						else if(arr.get(0).equalsIgnoreCase("!left")){
							if(arr.size()>1){
								float degrees= Float.parseFloat(arr.get(1));
								if(degrees<=180){
									for(int i=0;i<(degrees*5.6);i++){ //5.6 pixels per degree
										robot.mouseMove(IRCTest.xRes/2-2,IRCTest.yRes/2);
										sleep(10);
									}
								}
							}	
						}
						
						else if(arr.get(0).equalsIgnoreCase("!down")){ //up goes down?
							if(arr.size()>1){
								float degrees= Float.parseFloat(arr.get(1));
								if(degrees<=90){
									for(int i=0;i<(degrees*5.6);i++){ //13 pixels per degree
										robot.mouseMove(IRCTest.xRes/2,IRCTest.yRes/2+2);
										sleep(10);
									}
								}
							}	
						}
						
						else if(arr.get(0).equalsIgnoreCase("!up")){ //down goes up?
							if(arr.size()>1){
								float degrees= Float.parseFloat(arr.get(1));
								if(degrees<=90){
									for(int i=0;i<(degrees*5.6);i++){ //13 pixels per degree
										robot.mouseMove(IRCTest.xRes/2,IRCTest.yRes/2-2);
										sleep(10);
									}
								}
							}
						}
						
						else if(arr.get(0).equalsIgnoreCase("!forward")){
							if(arr.size() > 1){
								
								float length = Float.parseFloat(arr.get(1));
								if(length<=10 && length>=0){
									robot.keyPress(java.awt.event.KeyEvent.VK_W);
<<<<<<< HEAD
=======
									System.out.println("rofl");
>>>>>>> f296413f8cb1af142ee31ecff29f86f1ac98f602
									
									this.sleep((long) (length*1000));
									robot.keyRelease(java.awt.event.KeyEvent.VK_W);
								}
							}
						}

						else if(arr.get(0).equalsIgnoreCase("!backward")){
							if(arr.size() > 1){
								
								float length = Float.parseFloat(arr.get(1));
								if(length<=10 && length>=0){
									robot.keyPress(java.awt.event.KeyEvent.VK_S);
									
									this.sleep((long) (length*1000));
									robot.keyRelease(java.awt.event.KeyEvent.VK_S);
								}
							}
						}
						
						else if(arr.get(0).equalsIgnoreCase("!strafeleft")){
							if(arr.size() > 1){
								
								float length = Float.parseFloat(arr.get(1));
								if(length<=10 && length>=0){
									robot.keyPress(java.awt.event.KeyEvent.VK_A);
									
									this.sleep((long) (length*1000));
									robot.keyRelease(java.awt.event.KeyEvent.VK_A);
								}
							}
						}
						
						else if(arr.get(0).equalsIgnoreCase("!straferight")){
							if(arr.size() > 1){
								
								float length = Float.parseFloat(arr.get(1));
								if(length<=10 && length>=0){
									robot.keyPress(java.awt.event.KeyEvent.VK_D);
									
									this.sleep((long) (length*1000));
									robot.keyRelease(java.awt.event.KeyEvent.VK_D);
								}
							}
						}
						
						else if(arr.get(0).equalsIgnoreCase("!fire")){
							if(arr.size() > 1){
								
								float length = Float.parseFloat(arr.get(1));
								if(length<=5 && length>=0){
									robot.mousePress(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
									
									this.sleep((long) (length*1000));
									robot.mouseRelease(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
								}
							}
							else{
								robot.mousePress(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
								this.sleep(1);
								robot.mouseRelease(java.awt.event.InputEvent.BUTTON1_DOWN_MASK);
							}
						}
						
						else if(arr.get(0).equalsIgnoreCase("!altfire")){
								robot.mousePress(java.awt.event.InputEvent.BUTTON3_DOWN_MASK);
								this.sleep(100);
								robot.mouseRelease(java.awt.event.InputEvent.BUTTON3_DOWN_MASK);
						}
						
						else if(arr.get(0).equalsIgnoreCase("!jump")){
<<<<<<< HEAD
							robot.keyPress(java.awt.event.KeyEvent.VK_V);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_V);
						}
					
						else if(arr.get(0).equalsIgnoreCase("!inspect")){
							robot.keyPress(java.awt.event.KeyEvent.VK_V);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_V);
=======
							robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_SPACE);
						}
					
						else if(arr.get(0).equalsIgnoreCase("!inspect")){
							robot.keyPress(java.awt.event.KeyEvent.VK_7);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_7);
>>>>>>> f296413f8cb1af142ee31ecff29f86f1ac98f602
						}
						
						else if(arr.get(0).equalsIgnoreCase("!scoreboard")){
							robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
							this.sleep(5000);
							robot.keyRelease(java.awt.event.KeyEvent.VK_TAB);
						}
						
						else if(arr.get(0).equalsIgnoreCase("!bomb")){
<<<<<<< HEAD
							robot.keyPress(java.awt.event.KeyEvent.VK_F);
							this.sleep(11000);
							robot.keyRelease(java.awt.event.KeyEvent.VK_F);
						}
						
						else if(arr.get(0).equalsIgnoreCase("!door")){
							robot.keyPress(java.awt.event.KeyEvent.VK_F);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_F);
=======
							robot.keyPress(java.awt.event.KeyEvent.VK_E);
							this.sleep(11000);
							robot.keyRelease(java.awt.event.KeyEvent.VK_E);
						}
						
						else if(arr.get(0).equalsIgnoreCase("!door")){
							robot.keyPress(java.awt.event.KeyEvent.VK_E);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_E);
>>>>>>> f296413f8cb1af142ee31ecff29f86f1ac98f602
						}
						
						else if(arr.get(0).equalsIgnoreCase("!drop")){
							robot.keyPress(java.awt.event.KeyEvent.VK_G);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_G);
						}
						
						else if(arr.get(0).equalsIgnoreCase("!reload")){
							robot.keyPress(java.awt.event.KeyEvent.VK_R);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_R);
						}
						
						else if(arr.get(0).equalsIgnoreCase("!crouch")){
							if(arr.size() > 1){	
								float length = Float.parseFloat(arr.get(1));
								if(length<=10 && length>=0){
									robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
<<<<<<< HEAD
=======
									System.out.println("rofl");
>>>>>>> f296413f8cb1af142ee31ecff29f86f1ac98f602
									this.sleep((long) (length*1000));
									robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
								}
							}
						}
						
						else if(arr.get(0).equalsIgnoreCase("!walk")){
							if(arr.size() > 1){	
								float length = Float.parseFloat(arr.get(1));
								if(length<=10 && length>=0){
									robot.keyPress(java.awt.event.KeyEvent.VK_SHIFT);
<<<<<<< HEAD
=======
									System.out.println("rofl");
>>>>>>> f296413f8cb1af142ee31ecff29f86f1ac98f602
									this.sleep((long) (length*1000));
									robot.keyRelease(java.awt.event.KeyEvent.VK_SHIFT);
								}
							}
						}
						
						else if(arr.get(0).equalsIgnoreCase("!1")){
							robot.keyPress(java.awt.event.KeyEvent.VK_1);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_1);
						}
						
						else if(arr.get(0).equalsIgnoreCase("!2")){
							robot.keyPress(java.awt.event.KeyEvent.VK_2);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_2);
						}
						
						else if(arr.get(0).equalsIgnoreCase("!3")){
							robot.keyPress(java.awt.event.KeyEvent.VK_3);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_3);
						}
						
						else if(arr.get(0).equalsIgnoreCase("!4")){
							robot.keyPress(java.awt.event.KeyEvent.VK_4);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_4);
						}
						
						else if(arr.get(0).equalsIgnoreCase("!5")){
							robot.keyPress(java.awt.event.KeyEvent.VK_5);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_5);
						}
						
						else if(arr.get(0).equalsIgnoreCase("!6")){
							robot.keyPress(java.awt.event.KeyEvent.VK_6);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_6);
						}
						
					}
					catch (AWTException | InterruptedException | NumberFormatException e) {
						// TODO Auto-generated catch block
						
						e.printStackTrace();
					}
				
	}
	
}