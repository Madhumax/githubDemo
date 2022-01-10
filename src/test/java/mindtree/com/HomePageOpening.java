package mindtree.com;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
//import mindtree.com.Base;

import Resources.Base;

public class HomePageOpening extends Base
{
	public static Logger log=LogManager.getLogger(Base.class.getName());
	@BeforeTest
	public void initialize() throws IOException
	{
		driver=driverInitilization();
		
	}
	
	@Test(dataProvider="getData")
	public void HomePageNavigation(String email,String password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		LandingPage l=new LandingPage(driver);
		l.getlogin().click();
		LoginPage lp=new LoginPage(driver);
		lp.getEmail().sendKeys(email);
		lp.getPassword().sendKeys(password);
		lp.onSubmit().click();
		log.info("successfully entered email and password");
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object a[][]=new Object[2][2];
		
		a[0][0]="madhu";
		a[0][1]="123";
		
		a[1][0]="maru";
		a[1][1]="126";
		return a;
	}
	
	

	
}
