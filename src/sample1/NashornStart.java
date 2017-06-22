package sample1;
import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NashornStart {

	public static void main(String[] args) {
		
		ScriptEngine se = new ScriptEngineManager().getEngineByName("nashorn");
		try {
			se.eval("print('java nashorn test!');");
		} catch (ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String path = NashornStart.class.getResource("").getPath();
		String filePath = path + "test.js";
		try {
			se.eval(new FileReader(filePath));
		} catch (FileNotFoundException | ScriptException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
