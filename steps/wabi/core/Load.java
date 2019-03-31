package wabi.core;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;
import cucumber.api.java.en.Given;
import tree.Hook;

public class Load {
	public static Map<String, String> bigmap = new HashMap<String, String>();

	@Given("^Load value (.*?)$")
	public void i_load_value(String fileName) throws Exception {
		bigmap.clear();

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
				bigmap.put(i[0], i[1]);
			}
		}
	}

	@Given("^Modify bigmap (.*?) value to (.*?)$")
	public void i_modify_value(String name, String value) throws Exception {
		if (bigmap.containsKey(name)) {
			if (value.startsWith("\"")) {
				value = value.substring(1, value.length()-1);
			}
			bigmap.put(name, value);
			Hook.world.write("Key:[" + name + "] new value is: " + value);
		} else {
			Hook.world.write("Key:[" + name + "] not exist in bigmap, ignore");
		}
	}
}
