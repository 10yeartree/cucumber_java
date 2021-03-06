package tree.common;

import java.util.Set;
import java.util.TreeSet;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import cucumber.api.java.en.Given;
import tree.Hook;

public class Common {
	@Given("^Verify \\((.*?)\\)$")
	public void i_verify(String str) throws Exception {
		Set<String> sortSet = new TreeSet<String>((o1, o2) -> (o1.length() < o2.length() ? 1 : -1));
		sortSet.addAll(Hook.bigmap.keySet());
		for (String key : sortSet) {
			if (str.contains(key)) {
				Object value = Hook.bigmap.get(key);
				if (value instanceof String) {
					str = str.replace(key, "\"" + Hook.bigmap.get(key) + "\"");
				} else if (value instanceof Integer) {
					str = str.replace(key, Hook.bigmap.get(key).toString());
				} else if (value instanceof Long) {
					str = str.replace(key, Hook.bigmap.get(key).toString());
				} else if (value instanceof Double) {
					str = str.replace(key, Hook.bigmap.get(key).toString());
				} else if (value instanceof Float) {
					str = str.replace(key, Hook.bigmap.get(key).toString());
				} else {
					throw new Exception("Not supported bigmap value type");
				}
			}
		}

		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine se = manager.getEngineByName("js");
		Boolean result = (Boolean) se.eval(str);

		if (result) {
			Hook.world.write(str + " Result: True");
		} else {
			throw new Exception(str + " Result: Flase");
		}
	}

	@Given("^AssignExp \\((.*?)\\) to (.*?)$")
	public void i_assign_expression(String expression, String name) throws Exception {
		Set<String> sortSet = new TreeSet<String>((o1, o2) -> (o1.length() < o2.length() ? 1 : -1));
		sortSet.addAll(Hook.bigmap.keySet());
		for (String key : sortSet) {
			if (expression.contains(key)) {
				Object value = Hook.bigmap.get(key);
				
				if (value instanceof String) {
					expression = expression.replace(key, "\"" + Hook.bigmap.get(key) + "\"");
				} else if (value instanceof Integer) {
					expression = expression.replace(key, Hook.bigmap.get(key).toString());
				} else if (value instanceof Long) {
					expression = expression.replace(key, Hook.bigmap.get(key).toString());
				} else if (value instanceof Double) {
					expression = expression.replace(key, Hook.bigmap.get(key).toString());
				} else if (value instanceof Float) {
					expression = expression.replace(key, Hook.bigmap.get(key).toString());
				} else {
					throw new Exception("Not supported bigmap value type");
				}
			}
		}
		
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine se = manager.getEngineByName("js");

		Object result = se.eval(expression);
		Hook.bigmap.put(name, result);		
		Hook.world.write("Key:[" + name + "] assigned value is: " + result);
	}

	@Given("^Assign (.*?) to (.*?)$")
	public void i_assign(String value, String name) throws Exception {
		if (value.startsWith("\"") && value.endsWith("\"")) {
			String result = value.substring(1, value.length() - 1);
			Hook.bigmap.put(name, result);
			Hook.world.write("Key:[" + name + "] assigned value is: " + result);
		} else {
			ScriptEngineManager manager = new ScriptEngineManager();
			ScriptEngine se = manager.getEngineByName("js");

			Object result = se.eval(value);
			Hook.bigmap.put(name, result);
			Hook.world.write("Key:[" + name + "] assigned value is: " + result);
		}
	}

	@Given("^Print (.*?)$")
	public void i_print(String name) throws Exception {
		if (Hook.bigmap.containsKey(name)) {
			Object value = Hook.bigmap.get(name);
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