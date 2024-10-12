package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	WebDriver driver;
	
	public BasePage(WebDriver driver) {         // // we have created constructor, because constructor is same 
		  
		  this.driver= driver;                   // for all page object classes , so instead of creating it many time 
		  PageFactory.initElements(driver, this);  // we can extends this class...so this class is a parent class of all the classes of page classes that we are going to create.
	}
}
