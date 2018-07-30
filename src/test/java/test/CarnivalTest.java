package test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pages.CarnivalHomePage;

public class CarnivalTest extends BaseTest{

	private SoftAssert softAssertions;
	private CarnivalHomePage homePage;
	
	//TestMethods
		//Test1
		@Test(groups={"UserStory1TC"},dataProvider = "UserStory1TCData")
		public void testExcercise1(String sailToPort, String duration, String lowestValue, String higherValue){
			
			softAssertions = new SoftAssert();
			homePage = getCarnivalHomePage();
			
			homePage.selectSailTo(sailToPort);
			
			homePage.selectDuration(duration);
			
			homePage.moveLowerPricingPointerRight(lowestValue);
			
			softAssertions.assertTrue(homePage.verifyPricingFilter(), "Pricing slide filter not working properly");
			
			homePage.resetPriceSlider();
			
			homePage.moveHigherPricingPointerLeft(higherValue);
			
			softAssertions.assertTrue(homePage.verifyPricingFilter(), "Pricing slide filter not working properly");
			
			homePage.resetPriceSlider();
			
			homePage.clickOnSortButton();
			
			softAssertions.assertTrue(homePage.verifySortResults(), "Sorting button not working - High to Low");
			
			homePage.clickOnSortButton();
			
			softAssertions.assertTrue(homePage.verifySortResults(), "Sorting button not working - Low to High");
		
			softAssertions.assertAll();
		
		}
	
}