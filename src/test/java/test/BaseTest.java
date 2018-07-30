package test;

import org.testng.annotations.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import pages.CarnivalHomePage;
import pages.MyDriver;


public class BaseTest {

	MyDriver myDriver;
	
	private CarnivalHomePage carnivalHome;
	
	@BeforeTest(alwaysRun=true)
	@Parameters({"browser"})
	public void beforeSuite(String browser){
		myDriver = new MyDriver(browser);
		carnivalHome = new CarnivalHomePage(myDriver.getDriver());
	}
	
	@AfterTest(alwaysRun=true)
	public void afterSuite(){
		carnivalHome.dispose();
	}
	
	public CarnivalHomePage getCarnivalHomePage(){
		return carnivalHome;
	}
	
	@DataProvider(name="UserStory1TCData")
	public Object[][] dataProviderExc1(){
		return new Object[][]{
			{"Bahamas","6 - 9 Days","600","500"}
		};
	}
}