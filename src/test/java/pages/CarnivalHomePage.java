package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarnivalHomePage extends BasePage {
	
	public CarnivalHomePage(WebDriver pDriver) {
		super(pDriver);
		pDriver.get("https://www.carnival.com//");
		pDriver.manage().window().maximize();
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("ccl-mainContainer")));
	}
	
	//Locators......!!!!!!!!!!!!!!!!!
	@FindBy(id="cdc-destinations")
	private WebElement sailToFilter;
	
	@FindBy(id="cdc-durations")
	private WebElement durationFilter;
	
	@FindBy(xpath="//button[@class='cdc-filter-button' and @aria-label='The Bahamas ']")
	private WebElement bahamasFilterButton;
	
	@FindBy(xpath="//button[@class='cdc-filter-button' and @aria-label='6 - 9 Days ']")
	private WebElement sixToNineDays;
	
	@FindBy(id="sfn-nav-pricing")
	private WebElement pricingFilter;
	
	@FindBy(css=".rz-pointer.rz-pointer-min")
	private WebElement lowerPricingPointer;
	
	@FindBy(css=".rz-pointer.rz-pointer-max")
	private WebElement higherPricingPointer;
	
	@FindBy(css=".sfp-reset__button")
	private WebElement resetPriceSlider;
	
	@FindBy(css=".vrgf-price-box__price")
	private List<WebElement> listOfPrices;
	
	@FindBy(css=".sbsc-container__sort-options")
	private WebElement sortResults;
	
	@FindBy(css=".sbsc-container__sort-options-icon")
	private WebElement sortIcon;
	
	//Methods......!!!!!!!!!!!!!!!!!	
	public void selectSailTo(String city){
		sailToFilter.click();
		getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("cdc-filter-button")));
		switch(city) {
			case "Bahamas":
				bahamasFilterButton.click();
				break;
		}
	}
		
	public void selectDuration(String duration){
		durationFilter.click();
		getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("cdc-filter-button")));
		switch(duration) {
			case "6 - 9 Days":
				sixToNineDays.click();
				break;
		}
	}
	
	public void resetPriceSlider() {
		resetPriceSlider.click();
	}
	
	public void clicOnPricingFilterButton() {
		pricingFilter.click();
	}
	
	public void moveLowerPricingPointerRight(String value) {
		if(pricingFilter.getAttribute("aria-expanded").equals("false"))
			clicOnPricingFilterButton();
		while(!lowerPricingPointer.getAttribute("aria-valuenow").equals(value)) {
			getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(lowerPricingPointer)));
			lowerPricingPointer.sendKeys(Keys.ARROW_RIGHT);
		}
	}
		
	public void moveHigherPricingPointerLeft(String value) {
		if(pricingFilter.getAttribute("aria-expanded").equals("false"))
			clicOnPricingFilterButton();
		while(!higherPricingPointer.getAttribute("aria-valuenow").equals(value)) {
			getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOf(higherPricingPointer)));
			higherPricingPointer.sendKeys(Keys.ARROW_LEFT);
		}
	}	
	
	public boolean verifyPricingFilter() {
		int minVal = Integer.parseInt(lowerPricingPointer.getAttribute("aria-valuenow"));
		int maxVal = Integer.parseInt(higherPricingPointer.getAttribute("aria-valuenow"));
		for (WebElement currentPrice : listOfPrices) {
			if (Integer.parseInt(currentPrice.getText().replaceAll("[^\\d]", ""))<minVal && Integer.parseInt(currentPrice.getText().replaceAll("[^\\d]", ""))>maxVal)
				return false;
		}
		return true;
	}
	
	public void clickOnSortButton() {
		sortResults.click();
	}
	
	public boolean verifySortResults() {
		if(sortIcon.getAttribute("alt").equals("High to low")) {
			getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(listOfPrices)));
			if (Integer.parseInt(listOfPrices.get(0).getText().replaceAll("[^\\d]", "")) >= Integer.parseInt(listOfPrices.get(listOfPrices.size()-1).getText().replaceAll("[^\\d]", "")))
			return true;
		}
		if(sortIcon.getAttribute("alt").equals("Low to high")) {
			getWait().until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(listOfPrices)));
			if (Integer.parseInt(listOfPrices.get(0).getText().replaceAll("[^\\d]", "")) <= Integer.parseInt(listOfPrices.get(listOfPrices.size()-1).getText().replaceAll("[^\\d]", "")))
				return true;
		}
		return false;
	}
}