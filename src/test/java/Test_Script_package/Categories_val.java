package Test_Script_package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Hooks_package.Base_class;
import Pom_Package.Pom_Homepage;

public class Categories_val extends Base_class
{
	public WebDriverWait wait;
	@Test(priority = 1,testName = "categories_dropdown_list_validation")
	public void Test1() throws InterruptedException
	{
		Pom_Homepage cat=new Pom_Homepage(driver);
		cat.categories();
		Thread.sleep(3000);
		WebElement categories_list = driver.findElement(By.xpath("//ul[@id='desktop-menu-1']"));
		if(categories_list.isDisplayed())
		{
			Assert.assertTrue(false);
		}
	}
	@Test(priority = 2,testName = "categories_list_click_validation")
	public void categories_list_options() throws InterruptedException
	{
		Pom_Homepage pom=new Pom_Homepage(driver);
		pom.categories();
		pom.partyspeaker_option();
		Thread.sleep(3000);
		String expected_party_speaker_url = "https://www.boat-lifestyle.com/collections/party-speakers";
		String actual_party_spekaer_url = driver.getCurrentUrl();
		Assert.assertEquals(actual_party_spekaer_url, expected_party_speaker_url);
	}

}
