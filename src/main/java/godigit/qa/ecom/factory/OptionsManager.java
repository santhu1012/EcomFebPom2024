package godigit.qa.ecom.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager
{
	private Properties prop;
	private ChromeOptions co;
	private FirefoxOptions fo;
	private EdgeOptions eo;
	
	
	public OptionsManager(Properties prop)
	{
		this.prop=prop;
	}
	
	public ChromeOptions getChromeOptions()
	{
		co = new ChromeOptions();
		co.addArguments("--remote-allow-origins=*");
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) co.addArguments("--headless");
		
	//	System.out.println("----Running in Headless Mode------");
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) co.addArguments("--incognito");

		return co;
	}
	
	public FirefoxOptions getFirefoxOptionsOptions()
	{
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) co.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) co.addArguments("--incognito");

		return fo;
	}
	
	public EdgeOptions getEdgeOptions()
	{
		co = new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim())) co.addArguments("--headless");
		if(Boolean.parseBoolean(prop.getProperty("incognito").trim())) co.addArguments("--incognito");

		return eo;
	}
	
	
	

}
