package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CarnivalHomePage;

public class CarnivalTest extends BaseTest{

	private SoftAssert softAssertions;
	private CarnivalHomePage homePage;
	
	//TestMethods
		//Test1
		@Test(groups={"UserStory1TC"})
		public void testExcercise1(){
			
			softAssertions = new SoftAssert();
			homePage = getCarnivalHomePage();
			
		}
	
}