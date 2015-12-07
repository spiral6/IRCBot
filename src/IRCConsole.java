import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.*;

public class IRCConsole {
	static Display d = null;
	static Label stuff;
	static Shell consoleShell;
	
	public static void main(String[] args){
		d = InitGUI.display;
		consoleShell = new Shell(d);
		consoleShell.setLayout(new GridLayout(1, false));
		
		
		stuff = new Label(consoleShell, SWT.NONE);
		stuff.setText("balhaukdsgsakjdbslajhdlksahdlksajhdklsakldhsalkdhsaldhsaalkdhlsakhd");
		
		consoleShell.pack();
		consoleShell.open();
		
		while (!consoleShell.isDisposed()) {
			if (!InitGUI.display.readAndDispatch()) {
				InitGUI.display.sleep();
			}
		}
	}
	
	
	
	
	
	
	
	
	
}
