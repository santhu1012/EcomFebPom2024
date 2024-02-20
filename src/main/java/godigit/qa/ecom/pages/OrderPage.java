package godigit.qa.ecom.pages;

import org.openqa.selenium.By;

public class OrderPage {

	By loc = By.id("order");
	
	public void getOrder()
	{
		System.out.println("get order");
	}
	
	public void getPrice()
	{
		System.out.println("get price");
	}
}
