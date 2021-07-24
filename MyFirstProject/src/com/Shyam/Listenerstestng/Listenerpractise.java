package com.Shyam.Listenerstestng;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

public class Listenerpractise {
	@Test
	public void Testone(){
		Assert.assertEquals("5", "7");
	}
 @Test (dataProvider="dataprovidee")
	public void Testthree(String a){
		System.out.println(a);
		
	}
	@DataProvider
	public Object[] dataprovidee(){
		
		return new Object[]{"7","5"};
	}
	@Test
	public void Testtwo(){
		throw new SkipException("onnumila chumma");
	}
}
