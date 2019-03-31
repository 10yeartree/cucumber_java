package wabi.web;

import cucumber.api.java.en.Given;
import tree.Hook;
import org.openqa.selenium.chrome.ChromeDriver;


public class Web {
	public static ChromeDriver driver = null;
	
	@Given("^Open the browser$")
	public void i_open_browser() throws Exception {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Given("^Close the browser$")
	public void i_close_browser() throws Exception {
		driver.close();
	}
	
	@Given("^Get url (.*?)$")
	public void i_open_browser(String url) throws Exception {
		url = Hook.bigmap.containsKey(url) ? Hook.bigmap.get(url) : url;
		driver.get(url);
	}
}
