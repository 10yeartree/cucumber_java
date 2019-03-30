package ngcp;

import cucumber.api.java.Before;
import cucumber.api.Scenario;

public class hook {
	public static Scenario world = null;
	
	@Before
	public void i_before(Scenario scenario) throws Exception {
		this.world = scenario;
	}
	
	@Before("@start")
	public void i_before_tag() throws Exception {
		world.write("Only start tag will print this");
	}
}