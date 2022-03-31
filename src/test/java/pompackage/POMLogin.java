package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basePackage.BaseHRMclass;

public class POMLogin extends BaseHRMclass {
	//object repository 
	
	@FindBy (id = "txtUsername")
	WebElement username;
	@FindBy (id = "txtPassword")
	WebElement password;
	@FindBy (id = "btnLogin")
	WebElement login;
	
	//initiate page elements
	public POMLogin() {
		PageFactory.initElements(driver, this);
	}

	public void typeusername(String name) {
		username.sendKeys(name);
	}
	public void typepassword(String pass) {
		password.sendKeys(pass);
	}
	public void clicklogin() {
		login.click();
	}
	public String title() {
		return driver.getTitle();
	}
}
