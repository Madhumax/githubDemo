package Resources;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base 
{
	public WebDriver driver;
	public Properties prop;
	public WebDriver driverInitilization() throws IOException
	{
		prop=new Properties();
		FileInputStream f=new FileInputStream("C:\\Users\\Admin\\MainProject\\src\\main\\java\\Resources\\Details.properties");
		prop.load(f);
		String browserName=prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\MainProject\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();	
		}
		if(browserName.equalsIgnoreCase("mozilla"))
		{
			System.setProperty("webdriver.firefox.driver", "C:\\Users\\Admin\\MainProject\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();	
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
		
		
	}
	
	
}
