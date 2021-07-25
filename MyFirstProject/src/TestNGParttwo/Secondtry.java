package TestNGParttwo;

import org.testng.annotations.Test;

public class Secondtry {
	@Test 
	public void FBLogin(){
	System.out.println("I am able to login successfully");	
	
	}
	@Test (dependsOnMethods="FBLogin")
	public void FBLoginerror(){
		System.out.println("I am unable to login sorry");
	}
}




