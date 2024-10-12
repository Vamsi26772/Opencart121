package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends BasePage{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {   // constructor name should be same as class name , then only we can invoke constructor
		
		super(driver);                  // we have already created constructor in parent class, to invoke that constructor
	}                                   // from child calss, child calss name is different so again we created one constructor and invoking parent class constructor
	

	@FindBy(xpath = "//a[@title='My Account']")
	WebElement Myaccount;
	
	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement Register;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement Login;
	
	public void clickMyAccount() {
		
		Myaccount.click();
	}
	
	public void clickRegister() {
		Register.click();
	}
	
	public void clickLogin() {
		
		Login.click();
		
	}
}
