import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.jibble.pircbot.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CurrencyThread extends Thread{
	static ConnectIRC botbot;
	ArrayList<String> currentusers;
	//static SQLInputImpl connectiondb;
	String DBhost, DBuser, DBpass;
	
	static Display d = null;
	static Label output;
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
		
		output = new Label(consoleShell, SWT.BORDER);
		
		consoleShell.pack();
		consoleShell.open();
		
		
		try{
			botbot=bot;

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
			output.setText(output.getText() + "\n" + s);
			consoleShell.pack();
		}
	}
	
	
	
	
	
	
	
	
}
