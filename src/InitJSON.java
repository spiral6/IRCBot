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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.util.ArrayList;

public class InitJSON extends SelectionAdapter {
	static File f = null;
	static Button bindsButton;
	static Button add_one;
	ArrayList<Text> labels, texts;
	JSONArray thearray;
	Shell shellJSON;
	String derp;
	public static void main(String[] args) throws IOException, ParseException {

	}

	public void runDefault(File JSONGameID) throws IOException, ParseException {

		f = JSONGameID;
		FileReader fr = new FileReader(f);

		JSONParser parser = new JSONParser();
		Object obj = parser.parse(fr);

		shellJSON = new Shell(InitGUI.display);
		shellJSON.setMinimumSize(320, 400);
		shellJSON.setLayout(new GridLayout(2, false));

		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;

		thearray = (JSONArray) obj;
		labels = new ArrayList<Text>();
		texts = new ArrayList<Text>();

		for (int i = 0; i < thearray.size(); i++) {
			derp = ((JSONObject) thearray.get(i)).toString();
			derp = derp.replaceAll("(\\{)(.{1,})(\\})", "$2");
			derp = derp.replaceAll("\"", "");
			derp = derp.replaceAll(":", " ");
			Text tmp = new Text(shellJSON, SWT.BORDER);

			tmp.setLayoutData(gridData);
			tmp.setText(derp.split("\\s+")[0]);
			labels.add(tmp);

			Text tmp1 = new Text(shellJSON, SWT.BORDER);

			tmp1.setLayoutData(gridData);
			tmp1.setText(derp.split("\\s+")[1]);
			texts.add(tmp1);

		}

		bindsButton = new Button(shellJSON, SWT.NONE);
		bindsButton.setText("Submit");

		bindsButton.addSelectionListener(this);

		add_one = new Button(shellJSON, SWT.NONE);
		add_one.setText("+");
		add_one.addSelectionListener(this);

		shellJSON.pack();
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
		if (e.getSource() == bindsButton) {
			try {
				for (int i = 0; i < labels.size(); i++) {
					if(labels.get(i).getText().equals("")&&texts.get(i).getText().equals("")){
						labels.remove(i);
						texts.remove(i);
						thearray.remove(i);
						i--;
						}
					else if (!(labels.get(i).getText().equals(derp.split("\\s+")[0]))
							|| !(texts.get(i).getText().equals(derp.split("\\s+")[1]))) {
						@SuppressWarnings("rawtypes")
						Map wellds = new TreeMap();
						wellds.put(labels.get(i).getText(), texts.get(i).getText());
						JSONObject blah = new JSONObject(wellds);
						thearray.set(i, blah);
					}	
				}
				
				FileWriter jsonwriter = new FileWriter(f);
				jsonwriter.write(thearray.toJSONString());
				jsonwriter.flush();
				jsonwriter.close();
				shellJSON.close();

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else if (e.getSource() == add_one) {
			Text newlabel = new Text(shellJSON,SWT.BORDER);
			newlabel.setText("DEFAULT");
			labels.add(newlabel);
			Text newtext = new Text(shellJSON,SWT.BORDER);
			newtext.setText("DEFAULT");
			texts.add(newtext);
			@SuppressWarnings("rawtypes")
			Map wellds = new TreeMap();
			wellds.put(newlabel.getText(), newtext.getText());
			JSONObject blah = new JSONObject(wellds);
			thearray.add(blah);
			shellJSON.pack();
		}

	}

}