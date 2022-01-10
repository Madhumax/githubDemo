package mindtree.com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage 
{
	public WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By login=By.cssSelector("a[href*='sign_in']");
	By text=By.xpath("//*[@id=\"content\"]/div/div/h2");
	By nav=By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav");
	
	public WebElement getlogin()
	{
		return driver.findElement(login);
	}
	public WebElement validateText()
	{
		return driver.findElement(text);
	}
	public WebElement validateNavBar()
	{
		return driver.findElement(nav);
	}
}
