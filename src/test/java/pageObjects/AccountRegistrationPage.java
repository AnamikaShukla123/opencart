package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	

@FindBy(xpath="//input[@id='input-firstname']") private WebElement txtFirstname;
@FindBy(xpath="//input[@id='input-lastname']")private WebElement txtLastname;

@FindBy(xpath="//input[@id='input-email']")  private WebElement txtEmail;
@FindBy(xpath="//input[@id='input-telephone']")private WebElement txtTelephone;
@FindBy(xpath="//input[@id='input-password']")private  WebElement txtPassword;
@FindBy(xpath="//input[@id='input-confirm']")private WebElement txtConfirmPassword;

@FindBy(xpath="//input[@name='agree']") 
WebElement chkdPolicy;

@FindBy(xpath="//input[@value='Continue']") 
WebElement btnContinue;

@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
WebElement msgConfirmation;



public void SetFirstName(String fname) {
	txtFirstname.sendKeys(fname);
}
public void setLastName(String lname) {
	txtLastname.sendKeys(lname);

}

public void setEmail(String email) {
	txtEmail.sendKeys(email);

}

public void setTelephone(String tel) {
	txtTelephone.sendKeys(tel);

}

public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);

}

public void setConfirmPassword(String pwd) {
	txtConfirmPassword.sendKeys(pwd);

}

public void setPrivacyPolicy() {
	chkdPolicy.click();

}

public void clickContinue() {
	//sol1 
	btnContinue.click();
}
public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());

	}

}
}
