package wabi.core;

import java.io.File;
import java.io.FileReader;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import au.com.bytecode.opencsv.CSVReader;
import cucumber.api.java.en.Given;
import tree.Hook;

public class Load {
	@Given("^Load value (.*?)$")
	public void i_load_value(String fileName) throws Exception {
		String path = "resource/" + fileName;
		File file = new File(path);
		if (!file.exists()) {
			throw new Exception("[" + path + "]" + " not exist");
		}

		FileReader reader = new FileReader(file);
		CSVReader csvReader = new CSVReader(reader);
		List<String[]> arr = csvReader.readAll();

		for (String[] i : arr) {
			if (i.length == 2) {
				Hook.bigmap.put(i[0], i[1]);
			}
		}
	}

	@Given("^Modify bigmap (.*?) value to (.*?)$")
	public void i_modify_value(String name, String value) throws Exception {
		if (Hook.bigmap.containsKey(name)) {
			if (value.startsWith("\"") && value.endsWith("\"")) {
				String result = value.substring(1, value.length() - 1);
				Hook.bigmap.put(name, result);
				Hook.world.write("Key:[" + name + "] new value is: " + result);
			} else {
				ScriptEngineManager manager = new ScriptEngineManager();
				ScriptEngine se = manager.getEngineByName("js");

				Object result = se.eval(value);
				Hook.bigmap.put(name, result);
				Hook.world.write("Key:[" + name + "] new value is: " + result);
			}
		} else {
			Hook.world.write("Key:[" + name + "] not exist in bigmap, ignore");
		}
	}
}
