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

public class InitGUI {

  public static void main(String[] args) {
    final Display display = new Display();
    final Shell shell = new Shell(display);
    final Shell console = new Shell(display);
    File icon = new File("CSGOBotIcon.ico");
    shell.setImage(new Image(display,icon.getAbsolutePath()));
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
	
	Button button = new Button(shell, SWT.NONE);
	button.setText("Submit");
	
	button.addSelectionListener(new SelectionAdapter() {
        @Override
        public void widgetSelected(SelectionEvent e) {
        	System.out.println(resXText.getText());
        	IRCTest kek = new IRCTest(resXText.getText(), resYText.getText(), hostText.getText(), userText.getText(), channelText.getText(), oAuthText.getText());
	      	  try {
	      		kek.main(null);
	      	  } 
	      	  catch (Exception e1) {
	      		e1.printStackTrace();
	      	  } 
        	shell.close();

        	StyledText st = new StyledText(console, SWT.NONE);
        	st.setVisible(true);
        	GridData gridData = new GridData();
        	gridData.horizontalAlignment = SWT.FILL;
        	gridData.grabExcessHorizontalSpace = true;
        	st.setLayoutData(gridData);
        }
    });
	
	gridData = new GridData();
	gridData.horizontalSpan = 3;
	gridData.horizontalAlignment = SWT.CENTER;
	gridData.grabExcessHorizontalSpace = true;
	button.setLayoutData(gridData);
			
	shell.pack();
    shell.open();

	    while (!shell.isDisposed()) {
	    	if (!display.readAndDispatch()){
	    		display.sleep();
	    	}
	    }
   
  }
}