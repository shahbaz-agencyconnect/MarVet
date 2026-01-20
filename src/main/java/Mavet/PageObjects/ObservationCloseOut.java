package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class ObservationCloseOut extends AbstractComponent{
	WebDriver driver;
	public ObservationCloseOut(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	@FindBy(css = ".d-flex")
	WebElement loadDashboard;
	
	@FindBy(xpath = "//span[text()='Inspection Management']")
	WebElement inspectionMenu;
	
	@FindBy(xpath = "//input[@placeholder='Search inspection']")
	WebElement searchBox;	
	
	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(xpath = "//span[contains(text(),'1234563')]")
	WebElement selectVessel;
	
	@FindBy(xpath = "//label[text()='No']")
	WebElement observationques;	
	
	@FindBy(xpath = "//textarea[contains(@id,'observationDescription')]")
	WebElement observationDesc;	
	
	@FindBy(xpath = "//input[contains(@id,'closeOutDate')]")
	WebElement selectCalendar;	
	
	@FindBy(xpath = "//button[@class='current']//span")
	WebElement selectCurrentYear;
	
	@FindBy(xpath = "//span[text()='Save & Exit']")
	WebElement saveBtn;	
	
	public void observationCloseOut() throws InterruptedException {
		String monthFromXpath = "//table[@class='months']//span";
		String year = "2025";
		String month = "12";
		String day = "29";
		String fromDay = "//span[@class='ng-star-inserted' and text()='" + day + "']";
		String nextButton = ".next";
		
		waitForWebElementToAppear(loadDashboard);
		waitForWebElementToAppear(inspectionMenu);
		inspectionMenu.click();
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys("1234563");
		waitForWebElementToAppear(listLoad);
		selectVessel.click();
		observationques.click();
		observationDesc.sendKeys("Test");
		selectCalendar.click();
		selectCurrentYear.click();
		datePicker(monthFromXpath, year, month, fromDay, nextButton);
		saveBtn.click();
	}
}
