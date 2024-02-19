package godigit.qa.ecom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import godigit.qa.ecom.constants.AppConstants;
import godigit.qa.ecom.utils.ElementUtil;


public class RegisterPage 
{
	
	private WebDriver driver;
	private ElementUtil elemUtil;

	private By firstName = By.id("input-firstname");
	private By lastName = By.id("input-lastname");
	private By email = By.id("input-email");
	private By telephone = By.id("input-telephone");
	private By password = By.id("input-password");
	private By confirmpassword = By.id("input-confirm");

	private By agreeCheckBox = By.name("agree");
	private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");

	private By subscribeYes = By.xpath("//label[normalize-space()='Yes']/input[@type='radio']");
	private By subscribeNo = By.xpath("//label[normalize-space()='No']/input[@type='radio']");

	private By registerSuccessMesg = By.cssSelector("div#content h1");

	private By logoutLink = By.linkText("Logout");
	private By registerLink = By.linkText("Register");

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		elemUtil = new ElementUtil(driver);
	}
	
	
	public boolean registerUser(String firstName, String lastName, 
			String email, String telephone, String password, String subscribe) {
		
		elemUtil.waitForElementVisible(this.firstName, AppConstants.DEFAULT_SHORT_TIME_OUT).sendKeys(firstName);
		elemUtil.doSendKeys(this.lastName, lastName);
		elemUtil.doSendKeys(this.email, email);
		elemUtil.doSendKeys(this.telephone, telephone);
		elemUtil.doSendKeys(this.password, password);
		elemUtil.doSendKeys(this.confirmpassword, password);
		
			if(subscribe.equalsIgnoreCase("yes")) {
				elemUtil.doClick(subscribeYes);
			}
			else {
				elemUtil.doClick(subscribeNo);
			}
		elemUtil.doActionsCick(agreeCheckBox);
		elemUtil.doClick(continueButton);
		
		String successMesg = elemUtil.waitForElementVisible(registerSuccessMesg, AppConstants.DEFAULT_MEDIUM_TIME_OUT).getText();
		System.out.println("user reg success messg : " + successMesg);
		
		if(successMesg.contains(AppConstants.USER_REG_SUCCESS_MESSG)) {
			elemUtil.doClick(logoutLink);
			elemUtil.doClick(registerLink);
			return true;
		}
		return false;
	}
	
	
	
	

}
