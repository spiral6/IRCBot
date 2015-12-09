import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Composite;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;

public class InitJSON extends SelectionAdapter {
	static File f = null;
	static Button submitButton;
	static Button add_one;
	static Button refresh;
	static Button cancel;
	ArrayList<Text> labels, texts, argumentMAX;
	ArrayList<Button> minuses = new ArrayList<Button>();
	JSONArray thearray;
	Shell shellJSON;
	String derp;
	Object obj;
	GridData gridData;
	Composite c,jsonLayout,buttonLayout;
	public static void main(String[] args) throws IOException, ParseException {

	}

	public void runDefault(File JSONGameID) throws IOException, ParseException {

		f = JSONGameID;
		FileReader fr = new FileReader(f);

		JSONParser parser = new JSONParser();
		obj = parser.parse(fr);

		shellJSON = new Shell(InitGUI.display);
		shellJSON.setMinimumSize(320, 400);
		shellJSON.setLayout(new GridLayout(4, false));

		gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		
		c = new Composite(shellJSON, SWT.NONE);
		c.setLayout(new GridLayout(1,false));
		jsonLayout = new Composite(c, SWT.NONE);
		jsonLayout.setLayout(new GridLayout(4, false));
		buttonLayout = new Composite(c, SWT.NONE);
		buttonLayout.setLayout(new GridLayout(3, false));

		GridData gridData = new GridData();
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
	    
		readLogic();
		
		submitButton = new Button(buttonLayout, SWT.NONE);
		submitButton.setText("Submit");

		submitButton.addSelectionListener(this);

		add_one = new Button(buttonLayout, SWT.NONE);
		add_one.setText("+");
		add_one.addSelectionListener(this);
		
		refresh = new Button(buttonLayout, SWT.NONE);
		refresh.setText("Refresh");
		refresh.addSelectionListener(this);

		packLogic();
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
		if (e.getSource() == submitButton) {
			try {
				submitLogic();
				}
				catch (Exception e1) {
				e1.printStackTrace();
				}
				
				
			} 
		else if (e.getSource() == add_one) {
			Text newlabel = new Text(jsonLayout,SWT.BORDER);
			newlabel.setText("DEFAULT");
			labels.add(newlabel);
			Text newtext = new Text(jsonLayout,SWT.BORDER);
			newtext.setText("DEFAULT");
			texts.add(newtext);
			Text newarg = new Text(jsonLayout,SWT.BORDER);
			newarg.setText("0");
			argumentMAX.add(newarg);
			Button newminus = new Button(jsonLayout,SWT.NONE);
			newminus.setText("-");
			minuses.add(newminus);
			@SuppressWarnings("rawtypes")
			Map wellds = new TreeMap();
			wellds.put(newlabel.getText(), newtext.getText()+" "+newarg.getText());
			JSONObject blah = new JSONObject(wellds);
			thearray.add(blah);
			packLogic();
		}
		else if(e.getSource() == refresh){
			try{
				submitLogic();
				this.runDefault(f);
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
			for (int i = 0; i < labels.size(); i++) {
					if(labels.get(i).getText().equals("")&&texts.get(i).getText().equals("")&&argumentMAX.get(i).getText().equals("")){
						labels.remove(i);
						texts.remove(i);
						argumentMAX.remove(i);
						thearray.remove(i);
						i--;
					}
					else if (!(labels.get(i).getText().equals(derp.split("\\s+")[0]))|| !(texts.get(i).getText().equals(derp.split("\\s+")[1]))||!(argumentMAX.get(i).getText().equals(derp.split("\\s+")[2]))) {
						@SuppressWarnings("rawtypes")
						Map wellds = new TreeMap();
						wellds.put(labels.get(i).getText(), texts.get(i).getText()+" "+argumentMAX.get(i).getText());
						JSONObject blah = new JSONObject(wellds);
						thearray.set(i, blah);
					}
			}
			try{
			FileWriter jsonwriter = new FileWriter(f);
			jsonwriter.write(thearray.toJSONString());
			jsonwriter.flush();
			jsonwriter.close();
			shellJSON.close();
			}
			catch(IOException lmao){
				lmao.printStackTrace();
			}
	}
	public void removeRow(int i){
		labels.get(i).dispose();
		labels.remove(i);
		texts.get(i).dispose();
		texts.remove(i);
		argumentMAX.get(i).dispose();
		argumentMAX.remove(i);
		minuses.get(i).dispose();
		minuses.remove(i);
	
	}
	public void readLogic(){
		thearray = (JSONArray) obj;
		labels = new ArrayList<Text>();
		texts = new ArrayList<Text>();
		argumentMAX = new ArrayList<Text>();
		for (int i = 0; i < thearray.size(); i++) {
			derp = ((JSONObject) thearray.get(i)).toString();
			derp = derp.replaceAll("(\\{)(.{1,})(\\})", "$2");
			derp = derp.replaceAll("\"", "");
			derp = derp.replaceAll(" ", ":");
			derp = derp.replaceAll(":", " ");
			Text tmp = new Text(jsonLayout, SWT.BORDER);
			String[] tempderp= new String[3];
			tempderp=derp.split("\\s+");
			tmp.setLayoutData(gridData);
			tmp.setText(tempderp[0]);
			labels.add(tmp);

			Text tmp1 = new Text(jsonLayout, SWT.BORDER);

			tmp1.setLayoutData(gridData);
			tmp1.setText(tempderp[1]);
			texts.add(tmp1);
			
			Text tmp2 = new Text(jsonLayout, SWT.BORDER);
			tmp2.setLayoutData(gridData);
			tmp2.setText(tempderp[2]);
			argumentMAX.add(tmp2);
			Button badass = new Button(jsonLayout, SWT.NONE);
			badass.setText("-");
			badass.addSelectionListener(this);
		}
	}
	public void packLogic()
	{
		jsonLayout.pack();
		buttonLayout.pack();
		c.pack();
		shellJSON.pack();
	}
}