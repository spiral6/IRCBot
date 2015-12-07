import org.eclipse.swt.widgets.Label;
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
		//IRCConsole console = new IRCConsole();
		//console.main(null);
		sleep(100);
		
		try{
			botbot=bot;

			Class.forName("com.mysql.jdbc.Driver");
			//console.stuff.setText(IRCConsole.stuff.getText() + "\nAttempting connection to database...");
			//console.consoleShell.pack();
			//console.consoleShell.open();
			System.out.println("\nAttempting connection to database...");
			conn = DriverManager.getConnection("jdbc:mysql://" + DBhost, DBuser, DBpass);
			System.out.println("Connection successful.");

			stmnt = conn.createStatement();
			stmnt.executeUpdate("CREATE DATABASE IRCbot");
			System.out.println("Created database successfully.");
		}

		
		catch(SQLException e){
			String error = e.getMessage();
			
			if(error.substring(error.length()-6).equals("exists")){
				System.out.println("Unable to create database. This is ok because it already exists. Using existing database...");
			}
			else{
				if(error.indexOf("java.net.ConnectException")>0){
					System.out.println("Error, failed to connect to database.");
				}
			}
		}
		
		
		catch (Exception e) {
			System.out.println("Regular exception.");
			e.printStackTrace();
		}
		
		
		finally{
			try{
				if(conn!=null){
					conn.close();
				}
			} 
			catch (SQLException e) {
				e.printStackTrace();
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
}
