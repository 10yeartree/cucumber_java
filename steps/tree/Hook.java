package tree;

import cucumber.api.java.Before;

import java.util.HashMap;
import java.util.Map;

import cucumber.api.Scenario;

public class Hook {
	public static Scenario world = null;
	public static Map<String, Object> bigmap = null;
	
	@Before
	public void i_before(Scenario scenario) throws Exception {
		this.world = scenario;
		bigmap = new HashMap<String, Object>();
	}
	
	@Before("@start")
	public void i_before_tag() throws Exception {
		world.write("Only start tag will print this");
	}
}