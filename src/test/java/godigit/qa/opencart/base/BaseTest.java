package godigit.qa.opencart.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import godigit.qa.ecom.factory.DriverFactory;
import godigit.qa.ecom.pages.AccountsPage;
import godigit.qa.ecom.pages.LoginPage;
import godigit.qa.ecom.pages.ProductInfoPage;
import godigit.qa.ecom.pages.RegisterPage;
import godigit.qa.ecom.pages.SearchPage;

public class BaseTest
{
	
	DriverFactory df;
	WebDriver driver;
	protected Properties prop;
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected SearchPage searchPage;
	protected ProductInfoPage productInfoPage;
	protected RegisterPage registerPage;

	
	protected SoftAssert softAssert;
	
	@BeforeTest
	public void setUp()
	{
		df = new DriverFactory();
		prop = df.initProp();
		driver = df.initDriver(prop);
		loginPage = new LoginPage(driver);
		
		softAssert = new SoftAssert();
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
