package tree.common;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import cucumber.api.java.en.Given;
import tree.Hook;

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
		if (Hook.bigmap.containsKey(name)) {
			String value = Hook.bigmap.get(name);
			Hook.world.write(name + " value is: " + value);
		} else {
			Hook.world.write("Key:[" + name + "] not exist in bigmap");
		}
	}
	
	@Given("^Wait (\\d+) seconds$")
	public void i_wait(int count) throws Exception {
		Thread.sleep(count * 1000);
	}
}