import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyleRange;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;

public class InitJSON extends SelectionAdapter {
	static File f = null;
	static Button submit, add_one, refresh, cancel;
	ArrayList<Text> commands, keys, argumentMAX;
	ArrayList<Button> minuses = new ArrayList<Button>();
	JSONArray thearray;
	Shell shellJSON;
	String derp;
	Composite jsonLayout, buttonLayout, c;

	public void runDefault(File JSONGameID) throws IOException, ParseException {
		f = JSONGameID;

		shellJSON = new Shell(InitGUI.display);
		shellJSON.setText(f.getName());
		shellJSON.setImage(new Image(InitGUI.display, InitGUI.icon.getPath()));
		//shellJSON.setMinimumSize(320, 400);
		
		c = new Composite(shellJSON, SWT.NONE);
		c.setLayout(new GridLayout(1,false));
		jsonLayout = new Composite(c, SWT.NONE);
		jsonLayout.setLayout(new GridLayout(4, false));
		buttonLayout = new Composite(c, SWT.NONE);
		buttonLayout.setLayout(new GridLayout(3, false));

		GridData gridData = new GridData();
		//gridData.horizontalAlignment = SWT.FILL;
		//gridData.grabExcessHorizontalSpace = true;
		gridData.minimumWidth = 500;
		
		final Label l1 = new Label(jsonLayout, SWT.NONE);
	    l1.setText("Command Name");
	    final Label l2 = new Label(jsonLayout, SWT.NONE);
	    l2.setText("Command Key");
	    final Label l3 = new Label(jsonLayout, SWT.NONE);
	    l3.setText("Time Interval");
	    final Label l4 = new Label(jsonLayout, SWT.NONE);
	    l4.setVisible(false);
	    GridData gd = new GridData();
	    gd.horizontalAlignment = GridData.CENTER;
	    //l1.setLayoutData(gd);
	    gd = new GridData();
	    gd.horizontalAlignment = GridData.CENTER;
	    l2.setLayoutData(gd);
	    gd = new GridData();
	    gd.horizontalAlignment = GridData.CENTER;
	    l3.setLayoutData(gd);
		
		
		
		GridData buttonGrid = new GridData();
		buttonGrid.horizontalAlignment = SWT.FILL;
		buttonGrid.grabExcessHorizontalSpace = true;
		
		submit = new Button(buttonLayout, SWT.NONE);
		submit.setText("Submit");
		submit.addSelectionListener(this);
		submit.setLayoutData(buttonGrid);

		add_one = new Button(buttonLayout, SWT.NONE);
		add_one.setText("+");
		add_one.addSelectionListener(this);
		add_one.setLayoutData(buttonGrid);

		refresh = new Button(buttonLayout, SWT.NONE);
		refresh.setText("Refresh");
		refresh.addSelectionListener(this);
		refresh.setLayoutData(buttonGrid);
		
		Button testsomething = new Button(buttonLayout, SWT.NONE);
		testsomething.setText("lololololol");
		testsomething.addSelectionListener(new SelectionAdapter() {
	        @Override
	        public void widgetSelected(SelectionEvent e) {
	        	testsomething.dispose();
	        }
	    });
		
		readLogic();
		
		c.pack();
		jsonLayout.pack(true);
		buttonLayout.pack(true);
		shellJSON.pack(true);
		shellJSON.open();
		
		
		while (!shellJSON.isDisposed()) {
			if (!InitGUI.display.readAndDispatch()) {
				InitGUI.display.sleep();
			}
		}
		
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public void widgetSelected(SelectionEvent e) {
		if (e.getSource() == submit) {
			try {
				submitLogic();
				FileWriter jsonwriter = new FileWriter(f);
				jsonwriter.write(thearray.toJSONString());
				jsonwriter.flush();
				jsonwriter.close();
				shellJSON.close();
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}


		} 
		else if (e.getSource() == add_one) {
			Text newlabel = new Text(jsonLayout,SWT.BORDER);
			newlabel.setText("DEFAULT");
			commands.add(newlabel);
			Text newtext = new Text(jsonLayout,SWT.BORDER);
			newtext.setText("DEFAULT");
			keys.add(newtext);
			Text newarg = new Text(jsonLayout,SWT.BORDER);
			newarg.setText("0");
			argumentMAX.add(newarg);
			Button badass = new Button(jsonLayout, SWT.NONE);
			badass.setText("-");
			badass.addSelectionListener(this);
			minuses.add(badass);
			
			@SuppressWarnings("rawtypes")
			Map wellds = new TreeMap();
			wellds.put(newlabel.getText(), newtext.getText()+" "+newarg.getText());
			JSONObject blah = new JSONObject(wellds);
			thearray.add(blah);
			
			
			jsonLayout.pack();
			c.pack();
			shellJSON.pack();
		}
		else if(e.getSource() == refresh){
			try{
				submitLogic();
				FileWriter jsonwriter = new FileWriter(f);
				jsonwriter.write(thearray.toJSONString());
				jsonwriter.flush();
				jsonwriter.close();
				
				readLogic();

				jsonLayout.pack();
				c.pack();
				shellJSON.pack();
				
				//shellJSON.close();
				//this.runDefault(f);
			}
			catch(Exception k){
				k.printStackTrace();
			}
		}
		else if(minuses.contains(e.getSource()))
		{
			removeRow(minuses.indexOf(e.getSource()));

		}
	}
	public void submitLogic(){
		System.out.println(commands.size());
		for (int i = 0; i < commands.size(); i++) {
			if(commands.get(i).getText().equals("")&&keys.get(i).getText().equals("")&&argumentMAX.get(i).getText().equals("")){
				commands.get(i).dispose();
				commands.remove(i);
				keys.get(i).dispose();
				keys.remove(i);
				argumentMAX.get(i).dispose();
				argumentMAX.remove(i);
				thearray.remove(i);
				i--;
			}
			else if (!(commands.get(i).getText().equals(derp.split("\\s+")[0]))|| !(keys.get(i).getText().equals(derp.split("\\s+")[1]))||!(argumentMAX.get(i).getText().equals(derp.split("\\s+")[2]))) {
				@SuppressWarnings("rawtypes")
				Map wellds = new TreeMap();
				wellds.put(commands.get(i).getText(), keys.get(i).getText()+" "+argumentMAX.get(i).getText());
				JSONObject blah = new JSONObject(wellds);
				thearray.set(i, blah);
			}
		}
	}
	public void removeRow(int i){
		commands.get(i).setText("");
		commands.get(i).setVisible(false);
		//commands.remove(i);
		keys.get(i).setText("");
		keys.get(i).setVisible(false);
		//keys.remove(i);
		argumentMAX.get(i).setText("");
		argumentMAX.get(i).setVisible(false);
		//argumentMAX.remove(i);
		minuses.get(i).setVisible(false);
		//minuses.remove(i);

	}
	public void readLogic() throws IOException, ParseException{

		FileReader fr = new FileReader(f);

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);
		
		thearray = (JSONArray) obj;
		commands = new ArrayList<Text>(1000);
		keys = new ArrayList<Text>(1000);
		argumentMAX = new ArrayList<Text>(1000);
		for (int i = 0; i < thearray.size(); i++) {
			derp = ((JSONObject) thearray.get(i)).toString();
			derp = derp.replaceAll("(\\{)(.{1,})(\\})", "$2");
			derp = derp.replaceAll("\"", "");
			derp = derp.replaceAll(" ", ":");
			derp = derp.replaceAll(":", " ");
			
			String[] tempderp= new String[3];
			tempderp=derp.split("\\s+");
			
			Text tmp = new Text(jsonLayout, SWT.BORDER);
			//tmp.setLayoutData(gridData);
			tmp.setText(tempderp[0]);
			try{
				if(!(commands.get(i)==null)){
					commands.set(i,tmp);
				}
				else{
					System.out.println("Added element " + i);
					commands.add(tmp);
				}
			}
			catch(IndexOutOfBoundsException ie){
				ie.printStackTrace();
				System.out.println("Doesn't exist.");
				commands.add(tmp);
			}

			Text tmp1 = new Text(jsonLayout, SWT.BORDER);
			//tmp1.setLayoutData(gridData);
			tmp1.setText(tempderp[1]);
			try{
				//keys.set(i,tmp1);
				if(!(keys.size()==0)){
					keys.set(i,tmp1);
				}
				else{
					keys.add(tmp1);
				}
			}
			catch(IndexOutOfBoundsException ie){
				keys.add(tmp);
			}

			Text tmp2 = new Text(jsonLayout, SWT.BORDER);
			//tmp2.setLayoutData(gridData);
			tmp2.setText(tempderp[2]);
			try{
				//argumentMAX.set(i,tmp2);
				if(!(argumentMAX.size()==0)){
					argumentMAX.set(i,tmp2);
				}
				else{
					argumentMAX.add(tmp2);
				}
			}
			catch(IndexOutOfBoundsException ie){
				argumentMAX.add(tmp2);
			}
			
			Button badass = new Button(jsonLayout, SWT.NONE);
			badass.setText("-");
			badass.addSelectionListener(this);
			try{
				//minuses.set(i,badass);
				if(!(minuses.size()==0)){
					minuses.set(i,badass);
				}
				else{
					minuses.add(badass);
				}
			}
			catch(IndexOutOfBoundsException ie){
				minuses.add(badass);
			}
		}
	}
	
}