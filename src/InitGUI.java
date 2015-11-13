import java.io.File;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class InitGUI {
 static final Display display  = new Display();
  public static void main(String[] args) {
    
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
	final Text resYText = new Text(shell, SWT.BORDER);
	GridData gridData = new GridData();
	gridData.horizontalAlignment = SWT.FILL;
	gridData.grabExcessHorizontalSpace = true;
	resXText.setLayoutData(gridData);
	resYText.setLayoutData(gridData);
	
	Label hostLabel = new Label(shell, SWT.NONE);
	hostLabel.setText("Host:");
	final Text hostText = new Text(shell, SWT.BORDER);
	gridData = new GridData();
	gridData.horizontalSpan = 2;
	gridData.horizontalAlignment = SWT.FILL;
	gridData.grabExcessHorizontalSpace = true;
	hostText.setLayoutData(gridData);
	hostText.setText("irc.twitch.tv");
	
	Label userLabel = new Label(shell, SWT.LEFT | SWT.BOTTOM);
	userLabel.setText("User:");
	final Text userText = new Text(shell, SWT.BORDER);
	gridData = new GridData();
	gridData.horizontalSpan = 2;
	gridData.horizontalAlignment = SWT.FILL;
	gridData.grabExcessHorizontalSpace = true;
	userText.setLayoutData(gridData);
	userText.setText("spiral6");
	
	Label channelLabel = new Label(shell, SWT.RIGHT);
	channelLabel.setText("Channel:");
	final Text channelText = new Text(shell, SWT.BORDER);
	gridData = new GridData();
	gridData.horizontalSpan = 2;
	gridData.horizontalAlignment = SWT.FILL;
	gridData.grabExcessHorizontalSpace = true;
	channelText.setLayoutData(gridData);
	channelText.setText("#spiral6");
	
	Label oAuthLabel = new Label(shell, SWT.NONE);
	oAuthLabel.setText("oAuth Password:");
	final Text oAuthText = new Text(shell, SWT.BORDER);
	gridData = new GridData();
	gridData.horizontalSpan = 2;
	gridData.horizontalAlignment = SWT.FILL;
	gridData.grabExcessHorizontalSpace = true;
	oAuthText.setLayoutData(gridData);
	oAuthText.setText("oauth:9dnk5o5x9xuw610givlwhiaflwhbxc");
	
	Label gameID = new Label(shell, SWT.NONE);
	gameID.setText("Game ID: ");
	final Text gameIDText = new Text(shell, SWT.BORDER);
	gridData = new GridData();
	gridData.horizontalSpan = 2;
	gridData.horizontalAlignment = SWT.FILL;
	gridData.grabExcessHorizontalSpace = true;
	gameIDText.setLayoutData(gridData);
	gameIDText.setText("INSERT DEFAULT FROM JSON");
	
	Button button = new Button(shell, SWT.NONE);
	button.setText("Submit");
	
	button.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
        	IRCTest kek = new IRCTest(resXText.getText(), resYText.getText(), hostText.getText(), userText.getText(), channelText.getText(), oAuthText.getText());
	      	  try {
	      		kek.main(null);
	      	  } 
	      	  catch (Exception e1) {
	      		e1.printStackTrace();
	      	  } 
        	shell.close();
        }
    });
    
	Button buttonJSON = new Button(shell, SWT.NONE);
	buttonJSON.setText("Game Config");
	
	buttonJSON.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
	      	  try {
	      	  	if(gameIDText.getText().length()>0){
	      		new JSONTesterino().runDefault(gameIDText.getText());
	      	  	}
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