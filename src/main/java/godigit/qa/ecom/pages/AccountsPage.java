package godigit.qa.ecom.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import godigit.qa.ecom.constants.AppConstants;
import godigit.qa.ecom.utils.ElementUtil;

public class AccountsPage 
{
	private WebDriver driver;
	private ElementUtil elemUtil;
	
	private By logoutLink = By.linkText("Logout");
	private By accsHeaders = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By searchIcon = By.cssSelector("#search button");
	
	
	
	public AccountsPage(WebDriver driver)
	{
		this.driver=driver;
		elemUtil = new ElementUtil(driver);
		
	}

	public String getAccPageTitle()
	{
		String title = elemUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
		System.out.println("Acc page title :"+title);
		return title;
	}
	
	public String getAccPageUrl()
	{
		String url = elemUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, AppConstants.ACCOUNTS_PAGE_URL_FRACTION_VALUE);
		System.out.println("Acc page title :"+url);
		return url;
	}
	
	public boolean isLogoutLinkExist()
	{
		return elemUtil.waitForElementPresence(logoutLink, AppConstants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();
	}
	
	public boolean isSearchExist()
	{
		return elemUtil.waitForElementVisible(search, AppConstants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();

	}
	
	public List<String> getAccountsPageHeadersList()
	{
		
		List<WebElement> accHeadersList = elemUtil.waitForElementsVisible(accsHeaders, AppConstants.DEFAULT_MEDIUM_TIME_OUT );
	//	List<WebElement> accHeadersList = driver.findElements(accsHeaders);
		List<String> accHeadersValList = new ArrayList<String>();
		
		for(WebElement e:accHeadersList)
		{
			String text = e.getText();
			accHeadersValList.add(text);
		}
		
		return accHeadersValList;
	}
	
	public SearchPage performSearch(String searchkey)
	{
		if(isSearchExist())
		{
			elemUtil.doSendKeys(search, searchkey);
			elemUtil.doClick(searchIcon);
			return new  SearchPage(driver);
		}
		else
		{
			System.out.println("search field is not present on the page..");
			
			return null;
		}
	}

	
	
	
}
