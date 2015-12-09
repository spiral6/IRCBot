import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class InitGUI extends SelectionAdapter {

	static final Display display = new Display();
	static File json, gui, icon;
	static Text resXText, resYText, hostText, userText, channelText, oAuthText,DBHostText,DBUserText,DBPassText;
	static Shell shell;
	static JSONObject jsonObject;
	static ArrayList<File> fileSelect;
	static Combo gameDropDown;
	static GridData gridData;
	@SuppressWarnings({ "unchecked" })
	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		
		/*Below lies the folder finding 
		 * and default config implementation */
		
		File folder = null;
		folder = new File("../config");
		if (!folder.exists()) {
			folder = new File("./config");
		}
		if(!folder.exists()){
			(new File("../config")).mkdir();
			folder = new File("../config");
		}
		File[] listOfFiles = folder.listFiles();
		FileReader fr = null;
		gui = null;
		if(listOfFiles!=null){
			for (File b : listOfFiles) {
				System.out.println(b.getName());
				if (b.getName().equals("GUI.json")) {
					fr = new FileReader(b);
					gui = b;
				}
			}
		}
		if(gui==null){
			File newgui = new File("../config/GUI.json");
			newgui.createNewFile();
			JSONObject newjsonObject = new JSONObject();
			newjsonObject.putIfAbsent("resolutionX","1920");
			newjsonObject.putIfAbsent("resolutionY","1080");
			newjsonObject.putIfAbsent("Host","irc.twitch.tv");
			newjsonObject.putIfAbsent("User","Username");
			newjsonObject.putIfAbsent("Channel","#Username");
			newjsonObject.putIfAbsent("Authkey","Found in README");
			newjsonObject.putIfAbsent("DBUser","Database Username");
			newjsonObject.putIfAbsent("DBHost","Database Host");
			FileWriter newGUIwriter = new FileWriter(newgui);
			newGUIwriter.write(newjsonObject.toJSONString());
			newGUIwriter.flush();
			newGUIwriter.close();
			gui=newgui;
			fr=new FileReader(gui);
		}
		listOfFiles = folder.listFiles();
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		jsonObject = (JSONObject) obj;

		
		/*Below lies the shell initialization 
		 * with icon setting and string setting */
		
		
		shell = new Shell(display);

		icon = null;
		icon = new File("CSGOBotIcon.ico");
		if (!icon.exists()) {
			icon = new File("src/CSGOBotIcon.ico");
		}
		shell.setImage(new Image(display, icon.getPath()));

		shell.setText("Connection Settings");
		shell.setLayout(new GridLayout(3, false));

		Label resLabel = new Label(shell, SWT.NONE);
		resLabel.setText("Resolution:");
		resXText = new Text(shell, SWT.BORDER);
		resXText.setText(jsonObject.get("resolutionX").toString());
		resYText = new Text(shell, SWT.BORDER);
		resYText.setText(jsonObject.get("resolutionY").toString());
		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		resXText.setLayoutData(gridData);
		resYText.setLayoutData(gridData);

		Label hostLabel = new Label(shell, SWT.NONE);
		hostLabel.setText("Host:");
		hostText = new Text(shell, SWT.BORDER);
		hostText.setText(jsonObject.get("Host").toString());
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		hostText.setLayoutData(gridData);

		Label userLabel = new Label(shell, SWT.LEFT | SWT.BOTTOM);
		userLabel.setText("User:");
		userText = new Text(shell, SWT.BORDER);
		userText.setText(jsonObject.get("User").toString());
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		userText.setLayoutData(gridData);

		Label channelLabel = new Label(shell, SWT.RIGHT);
		channelLabel.setText("Channel:");
		channelText = new Text(shell, SWT.BORDER);
		channelText.setText(jsonObject.get("Channel").toString());
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		channelText.setLayoutData(gridData);

		Label oAuthLabel = new Label(shell, SWT.NONE);
		oAuthLabel.setText("oAuth Password:");
		oAuthText = new Text(shell, SWT.PASSWORD | SWT.BORDER);
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

		gameDropDown = new Combo(shell, SWT.DROP_DOWN | SWT.BORDER);
		fileSelect = new ArrayList<File>(listOfFiles.length - 1);
		for (File d : listOfFiles) {
			if (!(d.equals(gui))) {
				gameDropDown.add(d.getName().split("\\.")[0]);
				fileSelect.add(d);
			}
		}
		gameDropDown.add("+");
		gameDropDown.setLayoutData(gridData);

		Button CurrencyBox = new Button(shell, SWT.CHECK); 
		CurrencyBox.setText("Enable In-Chat-Currency");
		gridData= new GridData();
		gridData.horizontalSpan = 3;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		CurrencyBox.setLayoutData(gridData);


		Label DBHostLabel = new Label(shell, SWT.NONE);
		DBHostLabel.setText("DBHost:");
		DBHostText = new Text(shell, SWT.BORDER);
		DBHostText.setText(jsonObject.get("DBHost").toString());
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		DBHostText.setLayoutData(gridData);

		Label DBUserLabel = new Label(shell, SWT.NONE);
		DBUserLabel.setText("DBUser:");
		DBUserText = new Text(shell, SWT.BORDER);
		DBUserText.setText(jsonObject.get("DBUser").toString());
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		DBUserText.setLayoutData(gridData);

		Label DBPassLabel = new Label(shell,SWT.NONE);
		DBPassLabel.setText("DBPass:");
		DBPassText = new Text(shell,SWT.PASSWORD| SWT.BORDER);
		DBPassText.setText("");
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		DBPassText.setLayoutData(gridData);
		DBHostText.setVisible(false);
		DBHostLabel.setVisible(false);
		DBUserText.setVisible(false);
		DBUserLabel.setVisible(false);
		DBPassText.setVisible(false);
		DBPassLabel.setVisible(false);

		CurrencyBox.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					if(CurrencyBox.getSelection()){
						DBHostText.setVisible(true);
						DBHostLabel.setVisible(true);
						DBUserText.setVisible(true);
						DBUserLabel.setVisible(true);
						DBPassText.setVisible(true);
						DBPassLabel.setVisible(true);
					}
					else{
						DBHostText.setVisible(false);
						DBHostLabel.setVisible(false);
						DBUserText.setVisible(false);
						DBUserLabel.setVisible(false);
						DBPassText.setVisible(false);
						DBPassLabel.setVisible(false);
					}
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				} 
			}
		});

		Button button = new Button(shell, SWT.NONE);
		button.setText("Submit");
		button.addSelectionListener(new InitGUI());

		Button buttonJSON = new Button(shell, SWT.NONE);
		buttonJSON.setText("Game Config");

		buttonJSON.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					for(File temp: fileSelect){
						if(((String)temp.getName().split("\\.")[0]).equals(gameDropDown.getText().toString())){
							json = temp;
						}
					}

					new InitJSON().runDefault(json);
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
		
		Button testsomething = new Button(shell, SWT.VERTICAL);
		testsomething.setText("lololololol");
		testsomething.addSelectionListener(new SelectionAdapter() {
	        @Override
	        public void widgetSelected(SelectionEvent e) {
	        	testsomething.dispose();
	        	shell.pack();
	        }
	    });
		
		shell.pack();
		shell.open();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

	}
	
	
	public void loadCurrencyLayout(){
		/*pack only if checked, dispose if not checked, reload if checked again, etc.*/
		
		
		
		
		
		
		
	}
	
	
	/*Below lies the button listener implementation.
	 *When done, it saves the config to the .json file. */

	
	@SuppressWarnings({ "unchecked", "static-access" })
	public void widgetSelected(SelectionEvent e) {
		
		if(gameDropDown.getText().toString().equals("+")){
			new InitNEWGAME().runDefault();
			shell.close();
			try{
				new InitGUI().main(null);
			}
			catch (Exception ee){
				ee.printStackTrace();
			}
		}
		
		
		else{

			jsonObject.put("resolutionX", resXText.getText());
			jsonObject.put("resolutionY", resYText.getText());
			jsonObject.put("Host", hostText.getText());
			jsonObject.put("User", userText.getText());
			jsonObject.put("Channel", channelText.getText());
			jsonObject.put("Authkey", oAuthText.getText());

			try {
				for (File temp : fileSelect) {
					if (((String) temp.getName().split("\\.")[0]).equals(gameDropDown.getText().toString())) {
						json = temp;
					}
				}

				FileWriter GUIwriter = new FileWriter(gui);
				GUIwriter.write(jsonObject.toJSONString());
				GUIwriter.flush();
				GUIwriter.close();
				if(!(resXText.getText().equals("")||resYText.getText().equals("")||hostText.getText().equals("")||userText.getText().equals("")||channelText.getText().equals(""))){

					final ConnectIRC kek = new ConnectIRC(resXText.getText(), resYText.getText(), hostText.getText(), userText.getText(), channelText.getText(), oAuthText.getText(), json);
					shell.close();
					shell.dispose();
					kek.main(null);

				}
				else{
					InitTOOLTIP.runDefault();
				}

			} catch (Exception w) {
				w.printStackTrace();
			}

		}
		
		
	}

}