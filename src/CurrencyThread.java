import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class CurrencyThread extends Thread{
	static ConnectIRC botbot;
	ArrayList<String> currentusers;
	//static SQLInputImpl connectiondb;
	String DBhost, DBuser, DBpass;
	
	static Display d = null;
	static Text textBox;
	static Text output;
	static Text input;
	static Button submit;
	static Shell consoleShell;
	
	
	public static void main(String[] args) {

	}

	public CurrencyThread(String DBhost, String DBuser, String DBpass){
		this.DBhost = DBhost;
		this.DBuser = DBuser;
		this.DBpass = DBpass;
	}


	public void runDefault(ConnectIRC bot) throws InterruptedException{
		Connection conn = null;
		Statement stmnt = null;

		d = InitGUI.display;
		consoleShell = new Shell(d);
		consoleShell.setLayout(new GridLayout(1, false));
		consoleShell.setText("CurrencyThread");
		consoleShell.setImage(new Image(InitGUI.display, InitGUI.icon.getPath()));
		
		output = new Text(consoleShell, SWT.MULTI | SWT.BORDER | SWT.READ_ONLY);
		output.setBackground(d.getSystemColor(SWT.COLOR_BLACK));
		output.setForeground(d.getSystemColor(SWT.COLOR_WHITE));
		
		input = new Text(consoleShell, SWT.BORDER | SWT.CENTER);
		
		submit = new Button(consoleShell, SWT.CENTER);
		submit.setText("Submit");
		submit.addSelectionListener(new SelectionAdapter(){
			
			public void widgetSelected(SelectionEvent e){
				if (e.getSource() == submit) {
					String msg = input.getText();
					botbot.message(msg);
					input.setText("");
					printConsole("Sent message: " + msg);
				}
			}
			
		});
		
		consoleShell.pack();
		consoleShell.open();
		
		
		try{
			botbot=bot;
			botbot.message("CurrencyThread initialized.");
			Class.forName("com.mysql.jdbc.Driver");
			printConsole("Attempting connection to database...");
			conn = DriverManager.getConnection("jdbc:mysql://" + DBhost, DBuser, DBpass);
			printConsole("Connection successful.");

			stmnt = conn.createStatement();
			stmnt.executeUpdate("CREATE DATABASE IRCbot");
			printConsole("Created database successfully.");
		}

		
		catch(SQLException e){
			String error = e.getMessage();
			
			if(error.substring(error.length()-6).equals("exists")){
				printConsole("Unable to create database. This is ok because it already exists. Using existing database...");
			}
			else{
				if(error.indexOf("java.net.ConnectException")>0){
					printConsole("Error, failed to connect to database.");
				}
			}
			
		}
		
		
		catch (Exception e) {
			printConsole("Regular exception.");
			printConsole(e.getMessage());
		}
		
		
		finally{
			try{
				if(conn!=null){
					conn.close();
				}
			} 
			catch (SQLException e) {
				printConsole(e.getMessage());
			}
		}
		
		while (!consoleShell.isDisposed()) {
			if (!InitGUI.display.readAndDispatch()) {
				InitGUI.display.sleep();
			}
		}
		
		
	}
	
	public void run(){
		/*while(true){
			for(User a : botbot.getUsers(ConnectIRC.channel)){
			currentusers.add(a.getNick());
			}
		}*/
		while(true){
			
			
			
			
			
			
			
			
			
			
			
			
		}
	}
	
	public void printConsole(String s){
		if(output.getText().equals("")){
			output.setText(s);
		}
		else{
			output.append("\n" + s);
			consoleShell.pack();
		}
	}
	
	
	
	
	
	
	
	
}