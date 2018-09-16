package script.javascript;

import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import world.matter.macro.life.animal.bird.CommonBird;

public class JavaScriptHelper {
	public static void eval(String code) {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		try {
			engine.eval(code);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
	}
	
	public static void test() throws ScriptException {
		ScriptEngineManager factory = new ScriptEngineManager();
		ScriptEngine engine = factory.getEngineByName("JavaScript");
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("bird", new CommonBird());
		engine.put("map", map);
		engine.eval("print(Packages.world.matter.macro.life.animal.bird.CommonBird);");
	}
}
