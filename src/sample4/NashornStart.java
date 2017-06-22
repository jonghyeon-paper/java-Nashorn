package sample4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornStart {

	public static void main(String[] args) throws FileNotFoundException, ScriptException, NoSuchMethodException {
		
		ScriptEngine se = new ScriptEngineManager().getEngineByName("nashorn");
		String path = NashornStart.class.getResource("").getPath();
		se.eval(new FileReader(path + "test.js"));
		
		// pass parameters
		Invocable invocable = (Invocable) se;
		Object result = invocable. invokeFunction("test1", "{\"first\": \"first value\", \"second\": \"second value\"}");
		System.out.println(result);
		result = invocable. invokeFunction("test2", "{\"first\": \"first value\", \"second\": \"second value\"}");
		System.out.println(result);
		
		Map<String, String> map = new HashMap<>();
		map.put("object1", "object1 value");
		map.put("object2", "object2 value");
		result = invocable.invokeFunction("test1", map);
		System.out.println(result);
		result = invocable.invokeFunction("test2", map);
		System.out.println(result);
	}

}
