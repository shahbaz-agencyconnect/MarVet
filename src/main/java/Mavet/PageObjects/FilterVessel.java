package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class FilterVessel extends AbstractComponent {
	WebDriver driver;

	public FilterVessel(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//input[@placeholder='Start Date']")
	WebElement selectStartCalendar;	
	
	@FindBy(css = ".p-datepicker-year")
	WebElement selectCurrentYear;
	
	@FindBy(xpath = "//input[@placeholder='End Date']")
	WebElement selectEndCalendar;
	
	@FindBy(xpath = "//span[text()='Client']")
	WebElement clientLookup;
	
	@FindBy(xpath = "//span[text()='EASTERN NAVIGATION PTE LTD']")
	WebElement selectClient;
	
	@FindBy(xpath = "//span[text()='DOC']")
	WebElement docLookup;
	
	@FindBy(xpath = "//span[text()='Vallianz Offshore marine Pte Ltd']")
	WebElement selectDoc;
	
	@FindBy(xpath = "//span[text()='Port']")
	WebElement portLookup;
	
	@FindBy(xpath = "//span[text()='Muara Port']")
	WebElement selectport;
	
	@FindBy(xpath = "//div[text()='Status']")
	WebElement statusLookup;
	
	@FindBy(xpath = "//span[text()='Completed']")
	WebElement selectStatus;	

	public void filterData() throws InterruptedException {
		selectStartCalendar.click();
		String monthXpath="//span[contains(@class,'p-monthpicker-month')]";
		String startYear="2026";
		String startMonth="01";
		String day = "8";
		String startDay = "//span[contains(@class, 'p-element') and not(contains(@class, 'p-disabled')) and text()='"+day+"']";		
		String nextButton=".pi-chevron-right";
		waitForWebElementToAppear(selectCurrentYear);
		selectCurrentYear.click();
		selectExpiryDate(monthXpath, startYear, startMonth, startDay, nextButton);
		selectEndCalendar.click();
		waitForWebElementToAppear(selectCurrentYear);
		selectCurrentYear.click();
		String endYear="2026";
		String endMonth="01";
		String day1 = "16";
		String endDay = "//span[contains(@class, 'p-element') and not(contains(@class, 'p-disabled')) and text()='"+day1+"']";	
		selectExpiryDate(monthXpath, endYear, endMonth, endDay, nextButton);
		clientLookup.click();
		selectClient.click();
		docLookup.click();
		selectDoc.click();
		portLookup.click();
		selectport.click();
		statusLookup.click();
		selectStatus.click();
	}
}
