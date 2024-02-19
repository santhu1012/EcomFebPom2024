package godigit.qa.ecom.tests;
import java.util.Random;

import godigit.qa.ecom.constants.AppConstants;
import godigit.qa.ecom.utils.ExcelUtil;
import godigit.qa.opencart.base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest 
{

	@BeforeClass
	public void regPageSetup() {
		registerPage = loginPage.navigateToRegisterPage();
	}

	public String getRandomEmail() {
		Random random = new Random();
		//String email = "automation" + random.nextInt(1000) + "@gmail.com";
		
		String email = "automation" + System.currentTimeMillis() + "@gmail.com";
		//automation12121212121@gmail.com
		//automation232323232323@gmail.com
		
		return email;
	}

	@DataProvider
	public Object[][] getRegTestData() {
		Object regData[][] = ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		return regData;
	}

	@Test(dataProvider = "getRegTestData")
	public void userRegTest(String firstName, String lastName, String telephone, String password, String subscribe) {

		Assert.assertTrue(
				registerPage.registerUser(firstName, lastName, getRandomEmail(), telephone, password, subscribe));

	}
	
}
