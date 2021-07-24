package com.rediff.datepicker;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Datepickertryrediff {
	
	WebDriver driver=null;
	
	@Test
	public void datepicker() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver", "C://Users//Shyam//Downloads//Selenium drivers//chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
		driver.get("https://www.rediff.com/");
		
		driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/a[2]")).click();
		
		driver.findElement(By.xpath("//*[@title='Already a user? Sign in']")).click();
		
		driver.findElement(By.id("useremail")).sendKeys("anshulc55@rediffmail.com");
		
		driver.findElement(By.id("userpass")).sendKeys("Test@1234");
		
		driver.findElement(By.id("loginsubmit")).click();
		
		driver.findElement(By.className("black")).click();
		
		Select portfolio= new Select(driver.findElement(By.id("portfolioid")));
		
		portfolio.selectByVisibleText("Hello");
		
		
		
		//WebElement stocking=driver.findElement(By.id("createPortfolioButton"));
		
		//stocking.click();
		
		driver.get(driver.getCurrentUrl());
		
		driver.findElement(By.xpath("//*[@id='addStock']")).click();
		
		driver.findElement(By.id("addstockname")).sendKeys("Nestle India Ltd.");
		
		driver.findElement(By.id("stockPurchaseDate")).click();
		Thread.sleep(10000);
		datepickfunction("13/07/2021");
		
	}

	public void datepickfunction(String datey){
		 Date date=new Date();
		
	SimpleDateFormat simpl=new SimpleDateFormat("dd-MM-yyyy");
	
	try {
		Date expecteddate= simpl.parse(datey);
		String day= new SimpleDateFormat("dd").format(expecteddate);
		String month= new SimpleDateFormat("MMMM").format(expecteddate);
		String year= new SimpleDateFormat("yyyy").format(expecteddate);
		
		String monthnyear=month+" "+year;
		
		while(true){
			String displaydate=driver.findElement(By.className("dpTitleText")).getText();
			
			if(displaydate.equals(monthnyear)){
				driver.findElement(By.xpath("//td[@text='"+day+"']")).click();
				break;
			}
			else if(date.compareTo(expecteddate)>0){
				driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[1]/button")).click();
			}
			else{
				driver.findElement(By.xpath("//*[@id='datepicker']/table/tbody/tr[1]/td[4]/button")).click();
			}
		}
		
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}
}
