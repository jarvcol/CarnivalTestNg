package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CarnivalHomePage extends BasePage {
	
	public CarnivalHomePage(WebDriver pDriver) {
		super(pDriver);
		pDriver.get("https://www.carnival.com//");
		getWait().until(ExpectedConditions.visibilityOfElementLocated(By.id("ccl-mainContainer")));
	}

}