import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class InitTOOLTIP {
	static Button TOOLButton;
	static Shell shellTOOL;
	static Text TOOLText;
	public static void main(String[] args) {
		
	}
	public static void runDefault(){
		shellTOOL = new Shell(InitGUI.display);
		shellTOOL.setMinimumSize(320, 200);
		shellTOOL.setLayout(new GridLayout(3, false));

		GridData gridData = new GridData();
		gridData.horizontalAlignment = SWT.FILL;
		gridData.grabExcessHorizontalSpace = true;
		
		Label newLabel = new Label(shellTOOL, SWT.NONE);
		newLabel.setText("You are dumb");
		
		shellTOOL.pack();
		shellTOOL.open();
		while (!shellTOOL.isDisposed()) {
			if (!InitGUI.display.readAndDispatch()) {
				InitGUI.display.sleep();
			}
		
	}
	}
}
