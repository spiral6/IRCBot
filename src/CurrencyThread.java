import org.jibble.pircbot.*;
import java.util.ArrayList;
import java.sql.*;
import javax.sql.rowset.serial.SQLInputImpl;
public class CurrencyThread extends Thread{
	static ConnectIRC botbot;
	ArrayList<String> currentusers;
	static DriverManager conndriver;
	static SQLInputImpl connectiondb;
	public static void main(String[] args) {

	}
	public void runDefault(ConnectIRC bot){
		botbot=bot;
		this.start();
		conndriver = null;
		conndriver.getConnection(sdf,adsf,sdaf);
		connectiondb.readArray();
		
	}
	public void run(){
		while(true){
			for(User a : botbot.getUsers(ConnectIRC.channel)){
			currentusers.add(a.getNick());
			}
		}
	}
}
