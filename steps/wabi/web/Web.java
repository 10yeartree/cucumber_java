package wabi.web;

import cucumber.api.java.en.Given;
import tree.Hook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.WebDriver;

public class Web {
	public static WebDriver driver = null;

	@Given("^Open the browser$")
	public void i_open_browser() throws Exception {
		String driverType = System.getenv("BROWSER");
		if (driverType == null) {
			driverType = "Chrome";
		}

		if (driverType.equals("Chrome")) {
			driver = new ChromeDriver();
		} else if (driverType.equals("Firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("Not supported browser type: " + driverType);
		}
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
