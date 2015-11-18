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
	String Kappa;
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
		Kappa=derp.split("\\s+")[1];   //gets the actual key its bound to
				Robot robot;
					switch(Kappa){
						case "A":
							Keepo=java.awt.event.KeyEvent.VK_A;
							break;
						case "B":
							Keepo=java.awt.event.KeyEvent.VK_B;
							break;
						case "C":
							Keepo=java.awt.event.KeyEvent.VK_C;
							break
						case "D":
							Keepo=java.awt.event.KeyEvent.VK_D;
							break;
						case "E":
							Keepo=java.awt.event.KeyEvent.VK_E;
							break;
						case "F":
							Keepo=java.awt.event.KeyEvent.VK_F;
							break;
						case "G":
							Keepo=java.awt.event.KeyEvent.VK_G;
							break;
						case "H":
							Keepo=java.awt.event.KeyEvent.VK_H;
							break;
						case "I":
							Keepo=java.awt.event.KeyEvent.VK_I;
							break;
						case "J":
							Keepo=java.awt.event.KeyEvent.VK_J;
							break;
						case "K":
							Keepo=java.awt.event.KeyEvent.VK_K;
							break;
						case "L":
							Keepo=java.awt.event.KeyEvent.VK_L;
							break;
						case "M":
							Keepo=java.awt.event.KeyEvent.VK_M;
							break;
						case "N":
							Keepo=java.awt.event.KeyEvent.VK_N;
							break;
						case "O":
							Keepo=java.awt.event.KeyEvent.VK_O;
							break;
						case "P":
							Keepo=java.awt.event.KeyEvent.VK_P;
							break;
						case "Q":
							Keepo=java.awt.event.KeyEvent.VK_Q;
							break;
						case "R":
							Keepo=java.awt.event.KeyEvent.VK_R;
							break;
						case "S":
							Keepo=java.awt.event.KeyEvent.VK_S;
							break;
						case "T":
							Keepo=java.awt.event.KeyEvent.VK_T;
							break;
						case "U":
							Keepo=java.awt.event.KeyEvent.VK_U;
							break;
						case "V":
							Keepo=java.awt.event.KeyEvent.VK_V;
							break;
						case "W":
							Keepo=java.awt.event.KeyEvent.VK_W;
							break;
						case "X":
							Keepo=java.awt.event.KeyEvent.VK_X;
							break;
						case "Y":
							Keepo=java.awt.event.KeyEvent.VK_Y;
							break;
						case "Z":
							Keepo=java.awt.event.KeyEvent.VK_Z;
							break;
						case "SHIFT":
							Keepo=java.awt.event.KeyEvent.VK_SHIFT;
							break;
						case "TAB":
							Keepo=java.awt.event.KeyEvent.VK_TAB;
							break;
						case "CAPS_LOCK":
							Keepo=java.awt.event.KeyEvent.VK_CAPS_LOCK;
							break;
						case "ESCAPE":
							Keepo=java.awt.event.KeyEvent.VK_ESCAPE;
							break;
						case "TILDE":
							Keepo=java.awt.event.KeyEvent.VK_DEAD_TILDE;
							break;
						case "CTRL":
							Keepo=java.awt.event.KeyEvent.VK_CTRL;
							break;
						case "ALT":
							Keepo=java.awt.event.KeyEvent.VK_ALT;
							break;
						case "1":
							Keepo=java.awt.event.KeyEvent.VK_1;
							break;
						case "2":
							Keepo=java.awt.event.KeyEvent.VK_2;
							break;
						case "3":
							Keepo=java.awt.event.KeyEvent.VK_3;
							break;
						case "4":
							Keepo=java.awt.event.KeyEvent.VK_4;
							break;
						case "5":
							Keepo=java.awt.event.KeyEvent.VK_5;
							break;
						case "6":
							Keepo=java.awt.event.KeyEvent.VK_6;
							break;
						case "7":
							Keepo=java.awt.event.KeyEvent.VK_7;
							break;
						case "8":
							Keepo=java.awt.event.KeyEvent.VK_8;
							break;
						case "9":
							Keepo=java.awt.event.KeyEvent.VK_9;
							break;
						case "0":
							Keepo=java.awt.event.KeyEvent.VK_0;
							break;
						case "-":
							Keepo=java.awt.event.KeyEvent.VK_MINUS;
							break;
						case "=":
							Keepo=java.awt.event.KeyEvent.VK_EQUALS;
							break;
						case "BACK_SPACE":
							Keepo=java.awt.event.KeyEvent.VK_BACK_SPACE;
							break;
						case "BACK_SLASH":
							Keepo=java.awt.event.KeyEvent.VK_BACK_SLASH;
							break;
						case "SLASH":
							Keepo=java.awt.event.KeyEvent.VK_SLASH;
							break;
						case "ENTER":
							Keepo=java.awt.event.KeyEvent.VK_ENTER;
							break;
						case "RIGHT":
							Keepo=java.awt.event.KeyEvent.VK_RIGHT;
							break;
						case "UP":
							Keepo=java.awt.event.KeyEvent.VK_UP;
							break;
						case "LEFT":
							Keepo=java.awt.event.KeyEvent.VK_LEFT;
							break;
						case "DOWN":
							Keepo=java.awt.event.KeyEvent.VK_DOWN;
							break;
						case "SPACE":
							Keepo=java.awt.event.KeyEvent.VK_SPACE;
							break;
						case "RIGHT_CLICK":
							Keepo=java.awt.event.InputEvent.BUTTON3_DOWN_MASK;
							break;
						case "LEFT_CLICK":
							Keepo=java.awt.event.InputEvent.BUTTON1_DOWN_MASK;
							break;
						case "MIDDLE_CLICK":
							Keepo=java.awt.event.InputEvent.BUTTON2_DOWN_MASK;
							break;
					}
		}
		}
					try {
						robot = new Robot();
						if(Kappa.substring(0,7).equals("BUTTON")){
							if(arr.size()>1){
							float length = Float.parseFloat(arr.get(1));
							robot.mousePress(Keepo);
							this.sleep((long) (length*1000));
							robot.mouseRelease(Keepo);
							}
							else{
								robot.mousePress(Keepo);
								this.sleep(5);
								robot.mouseRelease(Keepo);
							}
						}
						else{
							if(arr.size()>1){
								float length = Float.parseFloat(arr.get(1));
								robot.keyPress(Keepo);
								this.sleep((long) (length*1000));
								robot.keyRelease(Keepo);
							}
							else{
								robot.keyPress(Keepo);
								this.sleep(5);
								robot.keyRelease
							}
							}
							/*if(arr.get(0).equalsIgnoreCase("!lookleft")){
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
						*/
					}
					
					catch (AWTException | InterruptedException | NumberFormatException e) {
						e.printStackTrace();
					}
	}
				
	}
	
}