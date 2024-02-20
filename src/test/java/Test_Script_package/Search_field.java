package Test_Script_package;



import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Hooks_package.Base_class;
import Pom_Package.Pom_Homepage;
import Util_package.property_reader;

public class Search_field extends Base_class 
{
	@Test(priority = 1,testName = "search_validation_1",dataProvider = "search_text for_validation")
	public void Test1(String valid) throws InterruptedException
	{
		Pom_Homepage home=new Pom_Homepage(driver);
		home.search_valid().sendKeys(valid);
		Thread.sleep(3000);
		String actual_Url = driver.getCurrentUrl();
		System.out.println(actual_Url);
		String Excepted_url = "https://www.boat-lifestyle.com/pages/searchtap-search?q=Earbuds";
		Assert.assertEquals(actual_Url, Excepted_url);
		home.Refresh_logo();
			
	}
	@Test(priority = 2,testName = "Search_Validation_2",dataProvider = "search invalid1")
	public void Test2(String invalid_1) throws InterruptedException
	{
		Pom_Homepage home=new Pom_Homepage(driver);
		home.search_valid().sendKeys(invalid_1);
		Thread.sleep(3000);
		if(driver.getPageSource().contains("We've hit offshore with that search."))
		{
			System.out.println("invalid data");
			Assert.assertTrue(true);
		}
		home.Refresh_logo();
		Thread.sleep(2000);
	}
	@Test(priority = 2,testName = "Search_Validation_3",dataProvider = "search invalid1")
	public void Test3(String invalid_1 ) throws InterruptedException
	{
		Pom_Homepage home=new Pom_Homepage(driver);
		home.search_invalid().sendKeys(invalid_1);
		Thread.sleep(3000);
		if(driver.getPageSource().contains("We've hit offshore with that search."))
		{
			System.out.println("invalid data");
			Assert.assertTrue(true);
		}
		
	}
	@DataProvider(name = "search_text for_validation")
	public Object[][]  getdata()
	{
		Properties prop = property_reader.reader();
		String valid_data = prop.getProperty("valid_data_search");
		return new Object[][]
				{
			{ valid_data }
	 
				};
		
	}
	@DataProvider(name = "search invalid1")
	public Object[][] getinvaliddata1()
	{
		Properties prop = property_reader.reader();
		String invalid_data1 = prop.getProperty("invalid_data_search1");
		return new Object[][]
				{
			{ invalid_data1}
	 
				};
		}
}
