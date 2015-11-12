import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONTesterino {

	public static void main(String[] args) throws IOException, ParseException {
		File f = new File("./TESTDOC.json");
		FileReader fr = new FileReader(f);
		System.out.println(f.exists());
		
		JSONParser parser = new JSONParser();
		
		JSONObject jj = (JSONObject) parser.parse(fr);
		
		JSONObject keybind = (JSONObject) jj.get("Keybinds");
		JSONArray commands = (JSONArray) keybind.get("commands");
		
		commands.remove("!jump");
		
		//System.out.println(commands.get("!jump"));
		
		for(int i = 0; i < commands.size(); i++){
			String derp = ((JSONObject)commands.get(i)).toString();
			//System.out.print(derp + "        ");
			derp = derp.replaceAll("(\\{)(.{1,})(\\})", "$2");
			derp = derp.replaceAll("\"", "");derp = derp.replaceAll(":", " ");
			String[] arr = derp.split(" ");
			System.out.println(derp);
		}	
	}

}
