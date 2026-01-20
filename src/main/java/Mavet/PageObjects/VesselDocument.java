package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class VesselDocument extends AbstractComponent {
	WebDriver driver;

	public VesselDocument(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".d-flex")
	WebElement loadDashboard;

	@FindBy(xpath = "//span[text()='Vessel Management']")
	WebElement vesselMgmt;
	
	@FindBy(xpath = "//input[contains(@placeholder,'vessel name')]")
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
	WebElement reviewedByDropdown;
	
	@FindBy(xpath = "//span[text()='admin (admin@defaulttenant.com)']")
	WebElement selectReviewer;	
	
	@FindBy(xpath = "//span[text()='Upload']")
	WebElement upload;		
	
	public void uploadDocument() throws InterruptedException {
		String monthXpath="//span[contains(@class,'p-monthpicker-month')]";
		String year="2025";
		String month="12";
		String day = "30";
		String fromDay = "//span[contains(@class, 'p-element') and not(contains(@class, 'p-disabled')) and text()='"+day+"']";		
		String nextButton=".pi-chevron-right";
		waitForWebElementToAppear(loadDashboard);
		waitForWebElementToAppear(vesselMgmt);
		vesselMgmt.click();
		searchBox.sendKeys("2580258");
		waitForWebElementToAppear(listLoad);
		docIcon.click();
		uploadDocBtn.click();
		uploadFile.sendKeys("C:\\Users\\khans\\Desktop\\sample.pdf");
		docType.sendKeys("PDF");
		docName.sendKeys("Sample");
		selectCalendar.click();
		selectCurrentYear.click();
		selectExpiryDate(monthXpath, year, month, fromDay, nextButton);
		reviewedByDropdown.click();
		selectReviewer.click();
		upload.click();
	}
}
