import org.jibble.pircbot.*;
import java.util.ArrayList;
import java.sql.*;
import java.sql.Connection;

import javax.sql.rowset.serial.SQLInputImpl;
import com.mysql.jdbc.*;

public class CurrencyThread extends Thread{
	static ConnectIRC botbot;
	ArrayList<String> currentusers;
	static SQLInputImpl connectiondb;
	String DBhost, DBuser, DBpass;
	public static void main(String[] args) {

	}
	
	public CurrencyThread(String DBhost, String DBuser, String DBpass){
		this.DBhost = DBhost;
		this.DBuser = DBuser;
		this.DBpass = DBpass;
	}
	
	
	public void runDefault(ConnectIRC bot){
		Connection conn = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			botbot=bot;
			this.start();
			System.out.println(DBhost + " " + DBuser + " " + DBpass);
			conn = DriverManager.getConnection("jdbc:mysql://" + DBhost + "/IRCBot", DBuser, DBpass);
			System.out.println("Trying to connect to database IRCBot with username " + DBuser + "...");
			connectiondb.readArray();
		}

		catch(SQLException e){
			e.printStackTrace();
		} 
		catch (Exception e) {
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
		while(true){
			for(User a : botbot.getUsers(ConnectIRC.channel)){
			currentusers.add(a.getNick());
			}
		}
	}
}
