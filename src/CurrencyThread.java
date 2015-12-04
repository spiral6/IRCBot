import org.jibble.pircbot.*;
import java.util.ArrayList;
import java.sql.*;
import javax.sql.rowset.serial.SQLInputImpl;
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
		try{
		Class.forName("com.mysql.jdbc.Driver");
		botbot=bot;
		this.start();
		Connection conn = null;
		conn = DriverManager.getConnection("jdbc:mysql://" + DBhost + "/IRCBot", DBuser, DBpass);
		connectiondb.readArray();
		}
		catch(SQLException e){
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
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
