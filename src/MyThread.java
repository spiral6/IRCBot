import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.io.File;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MyThread extends Thread{
	ArrayList<String> arr;
	File gameconfigs;
	int Keepo = 0;
	JSONArray thearray;
	
	public MyThread(ArrayList<String> lol,File rekt){
		arr = new ArrayList<String>();
		arr.addAll(lol);
		gameconfigs = rekt;
	}
	
	@SuppressWarnings("static-access")
	public void run(){
		FileReader fr = new FileReader(gameconfigs);
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		thearray = (JSONArray)obj;
		for(int i=0;i<thearray.size();i++){
		String derp = ((JSONObject)thearray.get(i)).toString();
		derp = derp.replaceAll("(\\{)(.{1,})(\\})", "$2");
		derp = derp.replaceAll("\"", "");derp = derp.replaceAll(":", " ");
		if(derp.split("\\s+")[0].equalsIgnoreCase(arr.get(0))){
		String Kappa=derp.split("\\s+")[1];   //gets the actual key its bound to
				Robot robot;
					switch(Kappa){
						case "A":
							Keepo=VK_A;
							break;
						case "B":
							Keepo=VK_B;
							break;
						case "C":
							Keepo=VK_C;
							break
						case "D":
							Keepo=VK_D;
							break;
						case "E":
							Keepo=VK_E;
							break;
						case "F":
							Keepo=VK_F;
							break;
						case "G":
							Keepo=VK_G;
							break;
						case "H":
							Keepo=VK_H;
							break;
						case "I":
							Keepo=VK_I;
							break;
						case "J":
							Keepo=VK_J;
							break;
						case "K":
							Keepo=VK_K;
							break;
						case "L":
							Keepo=VK_L;
							break;
						case "M":
							Keepo=VK_M;
							break;
						case "N":
							Keepo=VK_N;
							break;
						case "O":
							Keepo=VK_O;
							break;
						case "P":
							Keepo=VK_P;
							break;
						case "Q":
							Keepo=VK_Q;
							break;
						case "R":
							Keepo=VK_R;
							break;
						case "S":
							Keepo=VK_S;
							break;
						case "T":
							Keepo=VK_T;
							break;
						case "U":
							Keepo=VK_U;
							break;
						case "V":
							Keepo=VK_V;
							break;
						case "W":
							Keepo=VK_W;
							break;
						case "X":
							Keepo=VK_X;
							break;
						case "Y":
							Keepo=VK_Y;
							break;
						case "Z":
							Keepo=VK_Z;
							break;
						case "SHIFT":
							Keepo=VK_SHIFT;
							break;
						case "TAB":
							Keepo=VK_TAB;
							break;
						case "CAPS_LOCK":
							Keepo=VK_CAPS_LOCK;
							break;
						case "ESCAPE":
							Keepo=VK_ESCAPE;
							break;
						case "TILDE":
							Keepo=VK_DEAD_TILDE;
							break;
						case "CTRL":
							Keepo=VK_CTRL;
							break;
						case "ALT":
							Keepo=VK_ALT;
							break;
						case "1":
							Keepo=VK_1;
							break;
						case "2":
							Keepo=VK_2;
							break;
						case "3":
							Keepo=VK_3;
							break;
						case "4":
							Keepo=VK_4;
							break;
						case "5":
							Keepo=VK_5;
							break;
						case "6":
							Keepo=VK_6;
							break;
						case "7":
							Keepo=VK_7;
							break;
						case "8":
							Keepo=VK_8;
							break;
						case "9":
							Keepo=VK_9;
							break;
						case "0":
							Keepo=VK_0;
							break;
						case "-":
							Keepo=VK_MINUS;
							break;
						case "=":
							Keepo=VK_EQUALS;
							break;
						case "BACK_SPACE":
							Keepo=VK_BACK_SPACE;
							break;
						case "BACK_SLASH":
							Keepo=VK_BACK_SLASH;
							break;
						case "SLASH":
							Keepo=VK_SLASH;
							break;
						case "ENTER":
							Keepo=VK_ENTER;
							break;
						case "RIGHT":
							Keepo=VK_RIGHT;
							break;
						case "UP":
							Keepo=VK_UP;
							break;
						case "LEFT":
							Keepo=VK_LEFT;
							break;
						case "DOWN":
							Keepo=VK_DOWN;
							break;
						case "SPACE":
							Keepo=VK_SPACE;
							break;
						case "RIGHT_CLICK":
							Keepo=VK_;       //ENDED HERE
							break;
						case "LEFT_CLICK":
							Keepo=VK_B;
							break;
						case "MIDDLE_CLICK":
							Keepo=VK_B;
							break;
					}
		}
		}
					}
					try {
						robot = new Robot();
							if(arr.get(0).equalsIgnoreCase("!lookleft")){
								if(arr.size()>1){
								float degrees= Float.parseFloat(arr.get(1));
									if(degrees<=180){
										for(int i=0;i<(degrees*2.8);i++){ 
											robot.mouseMove(ConnectIRC.xRes/2-5,ConnectIRC.yRes/2);
											sleep(10);
										}
									}
								}
							}
							if(arr.get(0.equalsIgnoreCase("!lookright")){
								if(arr.size()>1){
									float degrees= Float.parseFloat(arr.get(1));
									if(degrees<=180){
										for(int i=0;i<(degrees*2.8);i++){ 
											robot.mouseMove(ConnectIRC.xRes/2+5,ConnectIRC.yRes/2);
											sleep(10);
										}
									}
								}		
							}
							if(arr.get(0).equalsIgnoreCase("!lookup")){//Opposite?
								if(arr.size()>1){
								float degrees= Float.parseFloat(arr.get(1));
									if(degrees<=90){
										for(int i=0;i<(degrees*2.8);i++){
											robot.mouseMove(ConnectIRC.xRes/2,ConnectIRC.yRes/2-5);
											sleep(10);
										}
									}
								}
							}
							if(arr.get(0).equalsIgnoreCase("!lookdown")){//Opposite?
								if(arr.size()>1){
								float degrees= Float.parseFloat(arr.get(1));
									if(degrees<=90){
										for(int i=0;i<(degrees*2.8);i++){
											robot.mouseMove(ConnectIRC.xRes/2,ConnectIRC.yRes/2+5);
											sleep(10);
										}
									}
								}
							}
						
						
							if(arr.get(0).equalsIgnoreCase("!moveleft")){
								if(arr.size() > 1){
								float length = Float.parseFloat(arr.get(1));
									if(length<=10 && length>=0){
										robot.keyPress(java.awt.event.KeyEvent.VK_A);
										this.sleep((long) (length*1000));
										robot.keyRelease(java.awt.event.KeyEvent.VK_A);
									}
								}
							}
							if(arr.get(0).equalsIgnoreCase("!moveright")){
								if(arr.size() > 1){
								float length = Float.parseFloat(arr.get(1));
									if(length<=10 && length>=0){
										robot.keyPress(java.awt.event.KeyEvent.VK_D);
										this.sleep((long) (length*1000));
										robot.keyRelease(java.awt.event.KeyEvent.VK_D);
									}
								}
							}
							if(arr.get(0).equalsIgnoreCase("!moveforwards")||(arr.get(0).equalsIgnoreCase("!moveforward"))){
								if(arr.size() > 1){
								float length = Float.parseFloat(arr.get(1));
									if(length<=10 && length>=0){
										robot.keyPress(java.awt.event.KeyEvent.VK_W);
										this.sleep((long) (length*1000));
										robot.keyRelease(java.awt.event.KeyEvent.VK_W);
									}
								}
							}
							if(arr.get(0).equalsIgnoreCase("!movebackwards")||(arr.get(0).equalsIgnoreCase("!movebackward"))){
								if(arr.size() > 1){
								float length = Float.parseFloat(arr.get(1));
									if(length<=10 && length>=0){
										robot.keyPress(java.awt.event.KeyEvent.VK_S);
										this.sleep((long) (length*1000));
										robot.keyRelease(java.awt.event.KeyEvent.VK_S);
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

							robot.keyPress(java.awt.event.KeyEvent.VK_SPACE);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_SPACE);
						}
					
						else if(arr.get(0).equalsIgnoreCase("!inspect")){
							robot.keyPress(java.awt.event.KeyEvent.VK_V);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_V);
						}
						
						else if(arr.get(0).equalsIgnoreCase("!scoreboard")){
							robot.keyPress(java.awt.event.KeyEvent.VK_TAB);
							this.sleep(5000);
							robot.keyRelease(java.awt.event.KeyEvent.VK_TAB);
						}
						
						else if(arr.get(0).equalsIgnoreCase("!bomb")){

							robot.keyPress(java.awt.event.KeyEvent.VK_F);
							this.sleep(11000);
							robot.keyRelease(java.awt.event.KeyEvent.VK_F);
						}
						
						else if(arr.get(0).equalsIgnoreCase("!door")){
							robot.keyPress(java.awt.event.KeyEvent.VK_F);
							this.sleep(100);
							robot.keyRelease(java.awt.event.KeyEvent.VK_F);
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
						e.printStackTrace();
					}
				
	}
	
}