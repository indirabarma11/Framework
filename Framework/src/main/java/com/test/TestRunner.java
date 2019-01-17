package com.test;


import org.testng.annotations.Test;

import com.implementation.LogInPageImplementation;

public class TestRunner {

	@Test
	public void testRun()
	{
		LogInPageImplementation login=new LogInPageImplementation();
		login.pageImpl( "1","LogInPage");
		
		
	}
}




