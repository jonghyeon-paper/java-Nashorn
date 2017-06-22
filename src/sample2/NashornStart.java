package sample2;

import java.io.FileNotFoundException;
import java.io.FileReader;

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
		Object result = invocable. invokeFunction("hello1", "nashorn!");
		System.out.println(result);
		
		result = invocable. invokeFunction("hello2", "Paul");
		System.out.println(result);
	}

}
