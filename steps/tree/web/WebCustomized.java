package tree.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.Given;
import tree.Hook;
import wabi.web.Web;

public class WebCustomized {
	@Given("^Click the (.*?)$")
	public void i_click(String obj) throws Exception {
		String objValue = Hook.obj_hash.containsKey(obj) ? (String) Hook.obj_hash.get(obj) : obj;
		String objMethod = Hook.acc_hash.containsKey(obj) ? (String) Hook.acc_hash.get(obj) : "id";

		WebElement element = null;
		if (objMethod.equals("id")) {
			element = Web.driver.findElement(By.id(objValue));
		} else if (objMethod.equals("xpath")) {
			element = Web.driver.findElement(By.xpath(objValue));
		} else {
			throw new Exception("Not supported obj type");
		}
		
		element.click();
		Hook.world.write(obj + " is clicked");
	}
}
