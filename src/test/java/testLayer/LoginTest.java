package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.BaseHRMclass;
import pompackage.POMLogin;
import testdata.Excel;

public class LoginTest extends BaseHRMclass {
	POMLogin log;
	
	public LoginTest() {
	super();
	}

	@BeforeMethod
	public void initialsetup() {
		initiation();
		Screenshots("Login screenshot");
		 log = new POMLogin();
	}
	
	@Test
	public void Title() {
		String actual = log.title();
	   System.out.println(actual);
		Assert.assertEquals(actual, "OrangeHRM");
	}
	@DataProvider
	public Object[][] details(){
		Object result[][] = Excel.readdata("Sheet1");
		return result;
	}
	
	@Test (dataProvider = "details")
	public void login(String name, String pass) throws InterruptedException {
		log.typeusername(name);
		Thread.sleep(3000);
		log.typepassword(pass);
		//log.clicklogin();
	}
	@AfterMethod
	public void close() {
		driver.close();
	}
}
