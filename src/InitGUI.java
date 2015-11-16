import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class InitGUI {
 static final Display display  = new Display();
 
  public static void main(String[] args) throws FileNotFoundException, IOException, ParseException{
	  File folder = new File("./config");
	  System.out.println(folder.exists());
	  File[] listOfFiles = folder.listFiles();
	  FileReader fr = null;
	  File gui = null;
	  for(File b: listOfFiles){
		  System.out.println(b.getName());
		  if(b.getName().equals("GUI.json")){
			  fr = new FileReader(b);
			  gui = b;
		  }
	  }
	  
	  
	  JSONParser parser = new JSONParser();
	  Object obj = parser.parse(fr);
	  JSONObject jsonObject = (JSONObject) obj;
    
    final Shell shell = new Shell(display);
    
    File icon = null;
    icon = new File("CSGOBotIcon.ico");
    if(!icon.exists()){
        	icon = new File("src/CSGOBotIcon.ico");
    }
    shell.setImage(new Image(display,icon.getPath()));
    
    shell.setText("Connection Settings");
	shell.setLayout(new GridLayout(3, false));
	
	Label resLabel = new Label(shell, SWT.NONE);
	resLabel.setText("Resolution:");
	final Text resXText = new Text(shell, SWT.BORDER);
	resXText.setText(jsonObject.get("resolutionX").toString());
	final Text resYText = new Text(shell, SWT.BORDER);
	resYText.setText(jsonObject.get("resolutionY").toString());
	GridData gridData = new GridData();
	gridData.horizontalAlignment = SWT.FILL;
	gridData.grabExcessHorizontalSpace = true;
	resXText.setLayoutData(gridData);
	resYText.setLayoutData(gridData);
	
	Label hostLabel = new Label(shell, SWT.NONE);
	hostLabel.setText("Host:");
	final Text hostText = new Text(shell, SWT.BORDER);
	hostText.setText(jsonObject.get("Host").toString());
	gridData = new GridData();
	gridData.horizontalSpan = 2;
	gridData.horizontalAlignment = SWT.FILL;
	gridData.grabExcessHorizontalSpace = true;
	hostText.setLayoutData(gridData);
	
	Label userLabel = new Label(shell, SWT.LEFT | SWT.BOTTOM);
	userLabel.setText("User:");
	final Text userText = new Text(shell, SWT.BORDER);
	userText.setText(jsonObject.get("User").toString());
	gridData = new GridData();
	gridData.horizontalSpan = 2;
	gridData.horizontalAlignment = SWT.FILL;
	gridData.grabExcessHorizontalSpace = true;
	userText.setLayoutData(gridData);

	
	Label channelLabel = new Label(shell, SWT.RIGHT);
	channelLabel.setText("Channel:");
	final Text channelText = new Text(shell, SWT.BORDER);
	channelText.setText(jsonObject.get("Channel").toString());
	gridData = new GridData();
	gridData.horizontalSpan = 2;
	gridData.horizontalAlignment = SWT.FILL;
	gridData.grabExcessHorizontalSpace = true;
	channelText.setLayoutData(gridData);
	
	Label oAuthLabel = new Label(shell, SWT.NONE);
	oAuthLabel.setText("oAuth Password:");
	final Text oAuthText = new Text(shell, SWT.BORDER);
	oAuthText.setText(jsonObject.get("Authkey").toString());
	gridData = new GridData();
	gridData.horizontalSpan = 2;
	gridData.horizontalAlignment = SWT.FILL;
	gridData.grabExcessHorizontalSpace = true;
	oAuthText.setLayoutData(gridData);
	
	Label gameID = new Label(shell, SWT.NONE);
	gameID.setText("Game ID: ");
	gridData = new GridData();
	gridData.horizontalSpan = 2;
	gridData.horizontalAlignment = SWT.FILL;
	gridData.grabExcessHorizontalSpace = true;
	final Combo comboDropDown = new Combo(shell, SWT.DROP_DOWN | SWT.BORDER);
	final ArrayList<File> fileSelect = new ArrayList<File>(listOfFiles.length-1);
	for(File d: listOfFiles){
		if(d.equals(gui)){
			
		}
		else{
		comboDropDown.add(d.getName());	
		fileSelect.add(d);
		}
	}
	
	comboDropDown.setLayoutData(gridData);
	
	Button button = new Button(shell, SWT.NONE);
	button.setText("Submit");
	
	button.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
        		
        	final IRCTest kek = new IRCTest(resXText.getText(), resYText.getText(), hostText.getText(), userText.getText(), channelText.getText(), oAuthText.getText());
	      	  try {
	      	  	Thread t = new Thread(new Runnable() {
		public void run()
         {
              try {
	      	  				
	      	  		kek.main(null);	
	      	  			}catch(Exception w){
	      	  				w.printStackTrace();
	      	  			}
         }
		});
		t.start();
	      	  } 
	      	  catch (Exception e1) {
	      		e1.printStackTrace();
	      	  } 
        //	shell.close();
        }
    });
    
	Button buttonJSON = new Button(shell, SWT.NONE);
	buttonJSON.setText("Game Config");
	
	buttonJSON.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
	      	  try {
	      		  File json = null;
	      		  for(File temp: fileSelect){
	      			if(temp.getName().equals(comboDropDown.getText().toString())){
	      				json = temp;
	      			}
	      		  }
	      		new JSONTesterino().runDefault(json);
	      	  } 
	      	  catch (Exception e1) {
	      		e1.printStackTrace();
	      	  } 
        }
    });
	
	gridData = new GridData();
	gridData.horizontalSpan = 3;
	gridData.horizontalAlignment = SWT.CENTER;
	gridData.grabExcessHorizontalSpace = true;
	button.setLayoutData(gridData);
	buttonJSON.setLayoutData(gridData);
	shell.pack();
    shell.open();

	    while (!shell.isDisposed()) {
	    	if (!display.readAndDispatch()){
	    		display.sleep();
	    	}
	    }

  }
}