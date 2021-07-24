package TestNGpractise;

import org.testng.annotations.Parameters;
//import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestNgdemo {
	@Parameters ("username")
	@Test (dependsOnMethods ="Youtubeerror")
	public void Youtubelogin(String username){
	System.out.println("I am able to login successfully:"  + username);	
	}
	@Parameters("userLname")
	@Test  
	public void Youtubeerror(String userLname){
		System.out.println("I am unable to login sorry:"  + userLname);
		
	}

}
