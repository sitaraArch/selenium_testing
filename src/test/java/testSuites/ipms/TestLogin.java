package testSuites.ipms;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import base.TestBase;
import pageObjects.ipms.LoginPage;

public class TestLogin extends TestBase {
	
	LoginPage loginPage;
	
	@BeforeMethod
	public void testSetUp() {
		loginPage = new LoginPage(driver);
		loginPage.open();
		log.debug("Navigated to Sign In Page");
	}
	
	@Test(dataProvider="getData", description="1.3 Login Successfully with vallid details")
	public void loginIPMS(String fullName, String password) throws InterruptedException {

		loginPage.enterUsername(fullName);
		log.debug("Entered name: " + fullName);
		loginPage.enterPassword(password);
		log.debug("Entered password: " + password);
		loginPage.clickSubmit();
		log.debug("Clicked submit button");
		
		loginPage.waitForElementToBeVisible(loginPage.msg);
		Assert.assertTrue(driver.findElement(loginPage.msg).isDisplayed());
	}
	
	
	@Test(dataProvider="getData", description="1.4 Invalid Login Successfully with invalid details")
	public void invalidLoginTest(String fullName, String password) {
		
		loginPage.enterUsername(fullName);
		log.debug("Entered name: " + fullName);
		loginPage.enterPassword(password);
		log.debug("Entered password: " + password);
		loginPage.clickSubmit();
		log.debug("Clicked submit button");
		
		loginPage.waitForElementToBeVisible(loginPage.msg);
		Assert.assertTrue(driver.findElement(loginPage.msg).isDisplayed());
	}
}
