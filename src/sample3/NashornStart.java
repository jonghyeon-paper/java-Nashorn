package sample3;

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
		String filePath = path + "test.js";
		se.eval(new FileReader(filePath));
		
		// call inside function
		Invocable invocable = (Invocable) se;
		Object test = se.eval("test");
		Object result = invocable.invokeMethod(test, "hello", "");
		System.out.println(result);
	}

}
