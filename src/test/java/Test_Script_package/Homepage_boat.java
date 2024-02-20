package Test_Script_package;


import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Hooks_package.Base_class;
import Pom_Package.Pom_Homepage;

public class Homepage_boat extends Base_class
{
	public WebDriverWait wait;
	@Test(priority = 1,testName = "Homepage_validation1")
	public void Test1()
	{
		System.out.println(driver.getCurrentUrl());
		if(driver.getCurrentUrl().equalsIgnoreCase("https://www.boat-lifestyle.com/"))
		{
			
			Assert.assertTrue(true);
		}
	}
	@Test(priority = 2,testName = "Homepage_validation2")
	public void Test2()
	{
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("Buy Earbuds"))
		{
			
			Assert.assertTrue(true);
		}
	}
	@Test(priority = 3,testName = "Homepage_validation3")
	public void Test3() throws InterruptedException
	{
		Pom_Homepage home=new Pom_Homepage(driver);
		home.More_dropdown();
		Thread.sleep(3000);
		
		if(driver.getPageSource().contains("Do What FloAts Your boAt"))
		{
			System.out.println("i entered inside dropdown");
			Assert.assertTrue(true);
		}
	}

}
