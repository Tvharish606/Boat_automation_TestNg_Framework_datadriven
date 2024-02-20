package Pom_Package;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pom_Homepage
{	
	 public WebDriver driver;
	 public WebDriverWait wait;
	 public Pom_Homepage(WebDriver driver)
	 {
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	 }
	 
	 
	@FindBy(xpath = "//span[text()='More']")
	private WebElement more_dropdown;
	public void More_dropdown()
	{
		wait=new WebDriverWait(driver,10);
		
		//WebElement drop_more = driver.findElement(By.xpath(more_dropdown));
		wait.until(ExpectedConditions.visibilityOf(more_dropdown));
		Actions action=new Actions(driver);
		action.moveToElement(more_dropdown).perform();
	}
	@FindBy(name="q")
	private WebElement search1;
	public WebElement search_valid()
	{
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(search1));
		return search1;
	}
	@FindBy(name="q")
	private WebElement search2;
	public WebElement search_invalid()
	{
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(search2));
		return search2;
		
	}
	@FindBy(xpath="//span[text()='Categories']")
	private WebElement categories_dropdown;
	public void categories()
	{
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(categories_dropdown));
		Actions a=new Actions(driver);
		a.moveToElement(categories_dropdown).perform();
	}
	@FindBy(xpath = "(//a[@href='/collections/party-speakers'])[1]")
	private WebElement party_speaker;
	public void partyspeaker_option()
	{
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(party_speaker));
		party_speaker.click();
		
	}
	@FindBy(xpath = "//h1[@class='header__logo']")
	private WebElement refresh_logo;
	public void Refresh_logo()
	{
		refresh_logo.click();
	}
}
