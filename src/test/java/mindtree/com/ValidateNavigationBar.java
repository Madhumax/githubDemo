package mindtree.com;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Resources.Base;

public class ValidateNavigationBar extends Base
{
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=driverInitilization();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void validationofNavBar() throws IOException
	{
		
		LandingPage l=new LandingPage(driver);
		Assert.assertTrue(l.validateNavBar().isDisplayed());
		log.info("Nav bar is displayed good");
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
		driver=null;
	}
}
