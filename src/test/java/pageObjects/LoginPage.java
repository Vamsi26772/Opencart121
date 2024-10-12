package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txtuserName;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btnclickLogin;
	
	
	public void setUserName(String user) {
		
		txtuserName.sendKeys(user);
		  
	}
	
	public void setPassword(String pwd) {
		
		txtpassword.sendKeys(pwd);
		
	}
	
	public void clickLoginto() {
		btnclickLogin.click();
	}

}
