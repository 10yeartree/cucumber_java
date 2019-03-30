package ngcp.common;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import ngcp.Hook;
import cucumber.api.java.en.Given;

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
	public void i_print(String str) throws Exception {
		Hook.world.write("Value is: " + str);
	}
}