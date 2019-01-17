package com.basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class GenricFunctions extends Configuration {

	public  abstract  void pageImpl(String testCaseName,String sheetName);
	
	public void set(String ele,String data)
	{
		driver.findElement(By.xpath(ele)).sendKeys(data);
		
	}
	public void click(String ele)
	{
		driver.findElement(By.xpath(ele)).click();
	}
}






