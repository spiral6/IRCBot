import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import java.util.*;
import java.io.*;


public class JSONTesterino {

	public static void main(String[] args) throws IOException, ParseException { 
		
	}
	public static void runDefault(String JSONGameID) throws IOException, ParseException{
		File f = null;
		  f = new File("../TESTDOC.json");
   		 if(!f.exists()){
        	f = new File("TESTDOC.json");
  			  }
		FileReader fr = new FileReader(f);
		
		JSONParser parser = new JSONParser();
		
		JSONObject jj = (JSONObject) parser.parse(fr);
		
		JSONArray keybind =  (JSONArray) (jj.get("gameid"));
		JSONObject rng = (JSONObject) keybind.get(0);
		JSONArray commands =  (JSONArray) rng.get(JSONGameID);
		System.out.println(rng);//object
		System.out.println(commands);//array
		//commands.remove("!jump");
		
		//System.out.println(commands.get("!jump"));
		
   		Shell shellJSON = new Shell(InitGUI.display);
   		shellJSON.setLayout(new GridLayout(2, false));
   		
   		
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		
		String[] comar = new String[commands.size()];
		Text[] labels = new Text[commands.size()];
		Text[] texts = new Text[commands.size()];
		
		for(int i = 0; i < commands.size(); i++){
			String derp = ((JSONObject)commands.get(i)).toString();
			derp = derp.replaceAll("(\\{)(.{1,})(\\})", "$2");
			derp = derp.replaceAll("\"", "");derp = derp.replaceAll(":", " ");
			labels[i] = new Text(shellJSON, SWT.BORDER);
			labels[i].setLayoutData(gridData);
			labels[i].setText(derp.split("\\s+")[0]);
			texts[i] = new Text(shellJSON, SWT.BORDER);
			texts[i].setLayoutData(gridData);
			texts[i].setText(derp.split("\\s+")[1]);
			System.out.println(derp);
		}
  	 	shellJSON.pack();
   		shellJSON.open();
    	    while (!shellJSON.isDisposed()) {
	    	if (!InitGUI.display.readAndDispatch()){
	    		InitGUI.display.sleep();
	    	}
	    }
	}
	private static void writejson(Text[] name,Text[] assignment){
		
		//name[i].getText()
		
		
		
	}

}