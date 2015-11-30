import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Integer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MyThread extends Thread{
	static ArrayList<String> arr;
	static File gameconfigs;
	int Keepo = 0;
	JSONArray thearray;
	String Kappa,derp,newderp;
	Robot robot;
	static FileReader fr = null;
	static Object obj = null;
	int PogChamp,x,y;
	
	public MyThread(ArrayList<String> lol,File rekt,int xc,int yc){
		arr = new ArrayList<String>();
		arr.addAll(lol);
		gameconfigs = rekt;
		x=xc;
		y=yc;
		try {
			fr = new FileReader(gameconfigs);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		JSONParser parser = new JSONParser();
		try {
			obj = parser.parse(fr);
		} catch (IOException | ParseException e1) {
			e1.printStackTrace();
		}
		thearray = (JSONArray)obj;
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		for(int i=0;i<thearray.size();i++){
		derp = ((JSONObject)thearray.get(i)).toString();
		derp = derp.replaceAll("(\\{)(.{1,})(\\})", "$2");
		derp = derp.replaceAll("\"", "");derp = derp.replaceAll(":", " ");
		if(derp.split("\\s+")[0].equalsIgnoreCase(arr.get(0))){
		Kappa=derp.split("\\s+")[1];
		newderp=derp;
					switch(Kappa){
						case "A":
							Keepo=java.awt.event.KeyEvent.VK_A;
							break;
						case "B":
							Keepo=java.awt.event.KeyEvent.VK_B;
							break;
						case "C":
							Keepo=java.awt.event.KeyEvent.VK_C;
							break;
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
							Keepo=java.awt.event.KeyEvent.VK_CONTROL;
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
				try{
					robot = new Robot();
					if(Keepo!=0){
						if(Kappa.contains("CLICK")){
							PogChamp=Integer.parseInt(newderp.split("\\s+")[2]);
							if(arr.size()>1&&Integer.parseInt(arr.get(1))<=PogChamp&&PogChamp!=0){
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
							PogChamp=Integer.parseInt(newderp.split("\\s+")[2]);
							if(arr.size()>1&&Integer.parseInt(arr.get(1))<=PogChamp&&PogChamp!=0){
								float length = Float.parseFloat(arr.get(1));
								robot.keyPress(Keepo);
								this.sleep((long) (length*1000));
								robot.keyRelease(Keepo);
							}
							else{
								robot.keyPress(Keepo);
								this.sleep(5);
								robot.keyRelease(Keepo);
							}
						}
						
					}
							if(arr.get(0).equalsIgnoreCase("!lookleft")){
								if(arr.size()>1){	
								float degrees= Float.parseFloat(arr.get(1));
									if(degrees<=180){
										for(int i=0;i<(degrees*2.8);i++){ 
											robot.mouseMove(x/2-5,y/2);
											sleep(10);
										}
									}
								}
							}
							if(arr.get(0).equalsIgnoreCase("!lookright")){
								if(arr.size()>1){
									float degrees= Float.parseFloat(arr.get(1));
									if(degrees<=180){
										for(int i=0;i<(degrees*2.8);i++){ 
											robot.mouseMove(x/2+5,y/2);
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
											robot.mouseMove(x/2,y/2-5);
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
											robot.mouseMove(x/2,y/2+5);
											sleep(10);
										}
									}
								}
							}
			}
				catch (AWTException | InterruptedException | NumberFormatException e) {
						e.printStackTrace();
					}
	}
				
	}
