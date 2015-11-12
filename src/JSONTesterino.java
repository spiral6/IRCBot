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
		File f = null;
		  f = new File("../TESTDOC.json");
   		 if(!f.exists()){
        	f = new File("TESTDOC.json");
  			  }
		FileReader fr = new FileReader(f);
		System.out.println(f.exists());
		
		JSONParser parser = new JSONParser();
		
		JSONObject jj = (JSONObject) parser.parse(fr);
		
		JSONObject keybind = (JSONObject) jj.get("Keybinds");
		JSONArray commands = (JSONArray) keybind.get("commands");
		
		commands.remove("!jump");
		
		//System.out.println(commands.get("!jump"));
		
		for(int i = 0; i < commands.size(); i++){
			String derp = ((JSONObject)commands.get(i)).toString();
			derp = derp.replaceAll("(\\{)(.{1,})(\\})", "$2");
			derp = derp.replaceAll("\"", "");derp = derp.replaceAll(":", " ");
			System.out.println(derp);
		}	
   		Shell shellJSON = new Shell(InitGUI.display);
   		
   		Label Bind1 = new Label(shellJSON, SWT.NONE);
		Bind1.setText((JSONObject)commands.get(i).toString()) ;
		final Text Bind1Text = new Text(shell, SWT.BORDER);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		resXText.setLayoutData(gridData);
		resYText.setLayoutData(gridData);
		
  	 	shellJSON.pack();
   		shellJSON.open();
    	    while (!shellJSON.isDisposed()) {
	    	if (!InitGUI.display.readAndDispatch()){
	    		InitGUI.display.sleep();
	    	}
	    }
	}

}
