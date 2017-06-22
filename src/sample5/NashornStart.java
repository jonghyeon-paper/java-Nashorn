package sample5;

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
		
		// pass java object
		Invocable invocable = (Invocable) se;
		Test test = new Test();
		test.setFiest("1 value");
		test.setSecond("2 value");
		Object result = invocable.invokeFunction("test1", test);
		System.out.println(result); // fail
		result = invocable.invokeFunction("test2", test);
		System.out.println(result); // fail
	}

}
