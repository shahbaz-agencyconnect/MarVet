package Mavet.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class InspectorDocuments extends AbstractComponent {
	WebDriver driver;

	public InspectorDocuments(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(css = ".d-flex")
	WebElement loadDashboard;

	@FindBy(xpath = "//span[text()='Inspector Management']")
	WebElement inspectorMgmt;
	
	@FindBy(xpath = "//input[@placeholder='Search inspector']")
	WebElement searchBox;	

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;
	
	@FindBy(css = ".fa-file-alt")
	WebElement docIcon;	
	
	@FindBy(xpath = "//span[text()='Upload Document']")
	WebElement uploadDocBtn;
	
	@FindBy(xpath = "//input[@id='undefined']")
	WebElement uploadFile;	
	
	@FindBy(xpath = "//app-text-input[@name='docType']//input")
	WebElement docType;	
	
	@FindBy(xpath = "//app-text-input[@name='docName']//input")
	WebElement docName;	
	
	@FindBy(css = ".p-datepicker-trigger")
	WebElement selectCalendar;	
	
	@FindBy(css = ".p-datepicker-year ")
	WebElement selectCurrentYear;
	
	@FindBy(css = ".ng-arrow-wrapper")
	WebElement selectReviewedBy;	
	
	public void inspectorDocument() throws InterruptedException {
		String monthXpath="//span[contains(@class,'p-monthpicker-month')]";
		String year="2025";
		String month="12";
		String day = "30";
		String fromDay = "//span[contains(@class, 'p-element') and not(contains(@class, 'p-disabled')) and text()='"+day+"']";		
		String nextButton=".pi-chevron-right";
		waitForWebElementToAppear(loadDashboard);
		waitForWebElementToAppear(inspectorMgmt);
		inspectorMgmt.click();
		searchBox.sendKeys("clark.russel57@yopmail.com");
		waitForWebElementToAppear(listLoad);
		docIcon.click();
		uploadDocBtn.click();
		uploadFile.sendKeys("C:\\Users\\khans\\Desktop\\sample.pdf");
		docType.sendKeys("PDF");
		docName.sendKeys("Sample");
		selectCalendar.click();
		selectCurrentYear.click();
		selectExpiryDate(monthXpath, year, month, fromDay, nextButton);
		selectReviewedBy.click();
	}
	
	// Date Picker
	public void selectExpiryDate(String xPath, String selectYear, String selectMonth, String selectDay, String nextButton)
			throws InterruptedException {

		// Year select

		while (true) {

			List<WebElement> getyears = driver.findElements(By.cssSelector(".p-yearpicker-year"));
			boolean yearFound = false;

			for (WebElement yearElement : getyears) {
				String year = yearElement.getText();
				if (year.equals(selectYear) || year.equals(null)) {
					yearElement.click();
					yearFound = true;
					break;
				}
			}
			if (yearFound) {
				break;
			} else {
				WebElement nextYearBtn = driver.findElement(By.cssSelector(nextButton));
				nextYearBtn.click();
			}
		}

		// Month select
		driver.findElements(By.xpath(xPath)).get(Integer.parseInt(selectMonth) - 1).click();

		// Days select
		driver.findElement(By.xpath(selectDay)).click();
	}
}
