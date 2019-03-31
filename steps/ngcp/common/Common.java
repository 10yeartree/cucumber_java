package ngcp.common;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import ngcp.Hook;
import cucumber.api.java.en.Given;

import wabi.core.Load;

public class Common {
	@Given("^Verify \\((.*?)\\)$")
	public void i_verify(String str) throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine se = manager.getEngineByName("js");
		Boolean result = (Boolean) se.eval(str);
		if (result) {
			Hook.world.write(str + "Result: True");
		} else {
			throw new Exception(str + "Result: Flase");
		}
	}

	@Given("^Print (.*?)$")
	public void i_print(String name) throws Exception {
		if (Load.bigmap.containsKey(name)) {
			String value = Load.bigmap.get(name);
			Hook.world.write(name + " value is: " + value);
		} else {
			Hook.world.write("Key:[" + name + "] not exist in bigmap");
		}
	}
}