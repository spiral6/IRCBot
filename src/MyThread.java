import java.awt.AWTException;
import java.awt.Robot;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
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
	Robot robot;
	Object obj;
	
	public MyThread(ArrayList<String> lol,File rekt){
		arr = new ArrayList<String>();
		arr.addAll(lol);
		gameconfigs = rekt;
	}
	
	@SuppressWarnings("static-access")
	public void run() {
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
					try {
						robot = new Robot();
						if(Kappa.contains("CLICK")){
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
								robot.keyRelease(Keepo);
							}
							}
							
					}
					
					catch (AWTException | InterruptedException | NumberFormatException e) {
						e.printStackTrace();
					}
	}
				
	}

	
