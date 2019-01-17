package com.implementation;


import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.basic.GenricFunctions;
import com.data.ReadData;



public class LogInPageImplementation extends GenricFunctions{
	
	
	
	@Override
	public  void pageImpl(String testCaseName,String sheetName) {
		
	
		Map<String,String> elements=new HashMap<String,String>();
		Map<String,String> data=new HashMap<String,String>();
		elements=ReadData.getPageElements(sheetName);
		data=ReadData.getTestData(testCaseName,sheetName );
		
		
		
			set(elements.get("FirstName"),data.get("FirstName"));
			set(elements.get("LastName"),data.get("LastName"));
			set(elements.get("MobileOrEmail"),data.get("MobileOrEmail"));
			set(elements.get("NewPassword"),data.get("NewPassword"));
			set(elements.get("Date"),data.get("Date"));
			set(elements.get("Month"),data.get("Month"));
			set(elements.get("Year"),data.get("Year"));
			click(elements.get("SignUp"));
	}

}





