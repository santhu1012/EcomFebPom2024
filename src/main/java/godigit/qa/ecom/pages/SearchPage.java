package godigit.qa.ecom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import godigit.qa.ecom.constants.AppConstants;
import godigit.qa.ecom.utils.ElementUtil;

public class SearchPage 
{
	private WebDriver driver;
	private ElementUtil elemUtil;
	private By searchProductResults = By.cssSelector("div#content div.product-layout");

	public SearchPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
		elemUtil = new ElementUtil(driver);
	}
	
	public int getSearchProductsCount()
	{
		int productCount =  elemUtil.waitForElementsVisible(searchProductResults, AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
		System.out.println("Product Count::"+productCount);
		return productCount;
	}
	
	public ProductInfoPage selectProduct(String productName)
	{
		By productLocator = By.linkText(productName);
		elemUtil.waitForElementVisible(productLocator, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		return new ProductInfoPage(driver);
	}
	
	
	

}
