package godigit.qa.ecom.pages;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import godigit.qa.ecom.constants.AppConstants;
import godigit.qa.ecom.utils.ElementUtil;

public class ProductInfoPage 
{
	
	private WebDriver driver;
	private ElementUtil elemUtil;

	
	private By productHeader = By.tagName("h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productMetaData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=1]/li");
	private By productPriceData = By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[position()=2]/li");
	private By quantity = By.id("input-quantity");
	private By addToCartBtn = By.id("button-cart");
	private By cartSuccessMsg = By.cssSelector("div.alert.alert-success");
	
	
	private Map<String,String> productInfoMap;
	

	public ProductInfoPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		
		this.driver = driver;
		elemUtil = new ElementUtil(driver);
	}
	
	public String getProductHeaderValue()
	{
		String productHeaderValue = elemUtil.doElementGetText(productHeader);
		System.out.println("product header:"+productHeaderValue);
		return productHeaderValue;
	}
	
	public int getProductImagesCount()
	{
		int imagesCount = elemUtil.waitForElementsVisible(productImages, AppConstants.DEFAULT_MEDIUM_TIME_OUT).size();
		System.out.println("product images count:"+imagesCount);
		return imagesCount;
	}
	
	public void enterQuantity(int qty)
	{
		System.out.println("Product Quantity:"+qty);
		elemUtil.doSendKeys(quantity, String.valueOf(qty));
	}
	
	public String addProductToCart()
	{
		elemUtil.doClick(addToCartBtn);
		String successMsg = elemUtil.waitForElementVisible(cartSuccessMsg, AppConstants.DEFAULT_SHORT_TIME_OUT).getText();
		StringBuilder sb = new StringBuilder(successMsg);
		String mesg = sb.substring(0,successMsg.length()-1).replace("\n", "").toString();
		
		System.out.println("cart Success Msg:"+mesg);
		return mesg;
	}

	public Map<String, String> getProductInfo()
	{
		//Brand: Apple
		//Product Code: Product 17
		//Reward Points: 700
		//Availability: In Stock
		
		productInfoMap = new LinkedHashMap<String,String>();
	//	productInfoMap = new HashMap<String,String>();
	//	productInfoMap = new TreeMap<String,String>();

		
		
		productInfoMap.put("productname",getProductHeaderValue());
		getProductMetaData();
		getProductPriceData();
		
		return productInfoMap;
		
	}
	
	//fetching metadata
	private void getProductMetaData()
	{
		List<WebElement> metaList = elemUtil.getElements (productMetaData);
		for(WebElement e:metaList)
		{
			String meta = e.getText();
			String metaInfo[] = meta.split(":");
			String key = metaInfo[0].trim();
			String value = metaInfo[1].trim();
			productInfoMap.put(key, value);
			
		}
		
	}
	
	//fetching price data
	
	private void getProductPriceData()
	{
		List<WebElement> priceList = elemUtil.getElements(productPriceData);
		String price = priceList.get(0).getText();
		String exTax = priceList.get(1).getText();
		String extraVal = exTax.split(":")[1].trim();
		
		productInfoMap.put("productprice", price);
		productInfoMap.put("extraVal", extraVal);
		
	}
}
