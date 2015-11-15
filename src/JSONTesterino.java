import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Button;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;



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
		Object obj = parser.parse(fr);
		
		Shell shellJSON = new Shell(InitGUI.display);
   		shellJSON.setLayout(new GridLayout(2, false));
   		
   		
		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		
		JSONObject jsonObject = (JSONObject) obj;
		JSONArray gameid = (JSONArray) jsonObject.get("gameid");
		@SuppressWarnings("rawtypes")
		Iterator iterator = gameid.iterator();
			JSONObject game = (JSONObject) iterator.next();
			JSONArray thegame = (JSONArray) game.get(JSONGameID);
			Text[] labels = new Text[thegame.size()];
			Text[] texts = new Text[thegame.size()];
			for(int i = 0; i < thegame.size(); i++){
				String derp = ((JSONObject)thegame.get(i)).toString();
				derp = derp.replaceAll("(\\{)(.{1,})(\\})", "$2");
				derp = derp.replaceAll("\"", "");derp = derp.replaceAll(":", " ");
				labels[i] = new Text(shellJSON, SWT.BORDER);
				labels[i].setLayoutData(gridData);
				labels[i].setText(derp.split("\\s+")[0]);
				texts[i] = new Text(shellJSON, SWT.BORDER);
				texts[i].setLayoutData(gridData);
				texts[i].setText(derp.split("\\s+")[1]);
				
			}
		
		Button bindsButton = new Button(shellJSON, SWT.NONE);
		bindsButton.setText("Submit");
		
		bindsButton.addSelectionListener(new SelectionAdapter() {
        @Override @SuppressWarnings("unchecked") 
        public void widgetSelected(SelectionEvent e) {
	      	  try {
	      	  	for(int i=0;i<labels.length;i++){
	      	  		jsonObject(labels[i].getText(),texts[i].getText());
	      	  	}
	      		System.out.println(jsonObject.toString());
	      		
	      	/*	FileWriter jsonwriter = new FileWriter("../TESTDOC.json");
 				jsonwriter.write(jsonObject.toJSONString());
 				jsonwriter.flush();
 				jsonwriter.close();
	      		
	      		*/ 
	      	  } 
	      	  catch (Exception e1) {
	      		e1.printStackTrace();
	      	  } 
        }
   		});

	
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