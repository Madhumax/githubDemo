package mindtree.com;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;

public class validateTextonHomePage extends Base
{
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=driverInitilization();
		log.info("Driver object is created");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to chrome");
	}
	
	@Test
	public void validationofText() throws IOException
	{
		
		LandingPage l=new LandingPage(driver);
		Assert.assertTrue(l.validateText().isDisplayed());
		log.info("Text is validated");
		
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
		driver=null;
	}
	
}
