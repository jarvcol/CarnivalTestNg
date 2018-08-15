package pages;

import static org.testng.Assert.expectThrows;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.gson.annotations.Until;

public class ItineraryPage extends BasePage{
	
	public ItineraryPage(WebDriver pDriver) {
		super(pDriver);
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("ccl-mainContainer")));
	}
	
	// Locators......!!!!!!!!!!!!!!!!!
	@FindBy(xpath = "//div[@class='ready']/a/span[text() = 'Book Now']")
	private WebElement bookNowBottomButton;
	
	@FindBy(css = ".itinerary-day-tile .day")
	private List<WebElement> itineraryDaysCardsCount;
	
	@FindBy(css = ".itinerary-day-tile .departure-time + a")
	private List<WebElement> aboutDayCardsCount;
	
	// Methods......!!!!!!!!!!!!!!!!!
	public String getPageUrl() {
		return getDriver().getCurrentUrl();
	}
	
	public boolean vefiryBookNowButton() {
		try {
			getWait().until(ExpectedConditions.visibilityOf(bookNowBottomButton));
			return true;
		}catch(org.openqa.selenium.TimeoutException exception) {
			return false;
		}
	}
	
	public boolean verifyEachDayCardHasAboutButton() {
		if(itineraryDaysCardsCount.size() == aboutDayCardsCount.size())
			return true;
		else
			return false;
	}
	
}




