import java.io.File;

import org.json.*;

public class JSONTesterino {

	public static void main(String[] args) {
		File f = new File("./TESTDOC.json");
		System.out.println(f.exists());
		
		JSONObject jj = new JSONObject();
		jj.put("lol", "rofl");
		jj.put("lol", "derp");
		System.out.println(jj.get("lol"));
		System.out.println(jj.names());
		System.out.println(jj.toString());
		
		
	}

}
