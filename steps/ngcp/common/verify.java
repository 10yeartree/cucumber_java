package ngcp.common;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import ngcp.hook;
import cucumber.api.java.en.Given;

public class verify {
	@Given("^Verify \\((.*?)\\)$")
	public void i_verify(String str) throws Exception {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine se = manager.getEngineByName("js");
		Boolean result = (Boolean) se.eval(str);
		if (result) {
			hook.world.write(str + "Result: True");
		} else {
			throw new Exception(str + "Result: Flase");
		}
	}
}