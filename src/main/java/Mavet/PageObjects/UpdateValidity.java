package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class UpdateValidity extends AbstractComponent {
	WebDriver driver;

	public UpdateValidity(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".d-flex")
	WebElement loadDashboard;

	@FindBy(xpath = "//span[text()='Inspector Management']")
	WebElement inspectorMgmt;

	@FindBy(xpath = "//input[@placeholder='Search inspector']")
	WebElement searchBox;

	@FindBy(css = ".fa-pen")
	WebElement editIcon;

	@FindBy(xpath = "//input[@placeholder='Select start date']")
	WebElement startDatepicker;

	@FindBy(css = ".p-datepicker-year")
	WebElement selectCurrentYear;

	@FindBy(xpath = "//input[@placeholder='Select end date']")
	WebElement endDatepicker;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;

	public void setValidity() throws InterruptedException {
		waitForWebElementToAppear(inspectorMgmt);
		inspectorMgmt.click();
		searchBox.sendKeys("ravi.kumar@yopmail.com");
		Thread.sleep(1000);
		editIcon.click();
		startDatepicker.click();
		selectCurrentYear.click();
		String monthXpath = "//span[contains(@class,'p-monthpicker-month')]";
		String startYear = "2026";
		String startMonth = "01";
		String day = "8";
		String startDay = "//span[contains(@class, 'p-element') and not(contains(@class, 'p-disabled')) and text()='"
				+ day + "']";
		String nextButton = ".pi-chevron-right";
		selectExpiryDate(monthXpath, startYear, startMonth, startDay, nextButton);
		endDatepicker.click();
		waitForWebElementToAppear(selectCurrentYear);
		selectCurrentYear.click();
		String endYear = "2026";
		String endMonth = "01";
		String day1 = "16";
		String endDay = "//span[contains(@class, 'p-element') and not(contains(@class, 'p-disabled')) and text()='"
				+ day1 + "']";
		selectExpiryDate(monthXpath, endYear, endMonth, endDay, nextButton);
		saveBtn.click();
	}
}
