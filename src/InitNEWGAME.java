
import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class InitNEWGAME extends SelectionAdapter {
	static Button NEWButton;
	static Shell shellNEW;
	static Text newText;
	@SuppressWarnings("static-access")
	public static void main(String[] args){
		runDefault();
	}
	@SuppressWarnings("static-access")
	public static void runDefault(){
		shellNEW = new Shell(InitGUI.display);
		shellNEW.setMinimumSize(320, 50);
		shellNEW.setLayout(new GridLayout(3, false));

		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		
		Label newLabel = new Label(shellNEW, SWT.NONE);
		newLabel.setText("Game Title: ");
		newText = new Text(shellNEW, SWT.BORDER);
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		newText.setLayoutData(gridData);
		
		Button buttonNew = new Button(shellNEW, SWT.NONE);
		buttonNew.setText("Submit");
		
		shellNEW.pack();
		shellNEW.open();
		
		buttonNew.addSelectionListener(new SelectionAdapter() {
	        @Override
	        public void widgetSelected(SelectionEvent e) {
		      	  try {
		      	  		JSONArray newarray = new JSONArray();
		      	  		Map wellds = new TreeMap();
						wellds.put("Default","Default"+" "+"0");
						JSONObject blah = new JSONObject(wellds);
						newarray.add(blah);
		    			File newgame = new File("../config/"+newText.getText()+".json"); 
						if(newgame.createNewFile()==true){
							newgame.createNewFile();
							FileWriter jsonwriter = new FileWriter(newgame);
							jsonwriter.write(newarray.toJSONString());
							jsonwriter.flush();
							jsonwriter.close();
							shellNEW.close();
						}
						else{
							InitTOOLTIP.runDefault();
						}
		      		  } 
		      	  catch (Exception e1) {
		      		e1.printStackTrace();
		      	  } 
	        }
	    });
		while (!shellNEW.isDisposed()) {
			if (!InitGUI.display.readAndDispatch()) {
				InitGUI.display.sleep();
			}
		
	}
	}
}