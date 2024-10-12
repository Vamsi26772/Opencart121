package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	
  public AccountRegistrationPage(WebDriver driver) {
	  
	  super(driver);
	  
  }
  
  @FindBy(xpath="//input[@id='input-firstname']")
  WebElement txtfname;
  
  @FindBy(xpath="//input[@id='input-lastname']")
  WebElement txtlname;
  
  @FindBy(xpath="//input[@id='input-email']")
  WebElement txtemail;
  
  @FindBy(xpath="//input[@id='input-telephone']")
  WebElement txtphone;
  
  @FindBy(xpath="//input[@id='input-password']")
  WebElement txtPassword;
  
  @FindBy(xpath="//input[@id='input-confirm']")
  WebElement txtConfirmPwd;
  
  @FindBy(xpath="//input[@name='agree']")
  WebElement chkPolicy;
  
  @FindBy(xpath="//input[@value='Continue']")
  WebElement btnContinue;
  
  @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
  WebElement msgConfirmation;
  
  public void setFirstName(String fname) {
	  txtfname.sendKeys(fname);
	  
  }
  
  public void setLastName(String lname) {
	  txtlname.sendKeys(lname);
	  
  }
  
  public void setEmail(String email) {
	  txtemail.sendKeys(email);
	  
  }
  
  public void setPhoneNumber(String phone) {
	  txtphone.sendKeys(phone);
	  
  }
  
  public void setPassword(String pwd) {
	  txtPassword.sendKeys(pwd);
	  
  }
  
  public void setConfirmPassword(String pwd) {
	  txtConfirmPwd.sendKeys(pwd);
	  
  }
  
  public void setPolicy() {
	 chkPolicy.click();
	  
  }
  
  public void clickContinue() {
	  btnContinue.click();
	  
  }
  // we can't do/perform any validations in page object class, then how can we do validations like confirmaton msg in this class
  
  public String getConfirmationMsg() {
	  
	  try {
		  return (msgConfirmation.getText());
	  } catch(Exception e) {
		 
		 return  (e.getMessage());
	  }
  }

}
