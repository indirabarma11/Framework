package com.basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Configuration {


	public WebDriver driver=null;
	public Configuration()
	
	{System.setProperty("webdriver.chrome.driver", ReadPropertyFile.getProperty("ChromeDriverPath"));
		 driver=new ChromeDriver();
		driver.get(ReadPropertyFile.getProperty("ApplicationURL"));
			
	}

}
