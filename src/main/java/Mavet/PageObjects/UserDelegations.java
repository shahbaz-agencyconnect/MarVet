package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class UserDelegations extends AbstractComponent {
	WebDriver driver;

	public UserDelegations(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(css = ".d-flex")
	WebElement loadDashboard;

	@FindBy(xpath = "//span[text()='Vetting Management']")
	WebElement vettingMgmtMenu;

	@FindBy(id = "kt_quick_user_toggle")
	WebElement stageBsp;

	@FindBy(id = "ManageUserDelegations")
	WebElement authorityDelegations;

	@FindBy(xpath = "//span[text()=' Delegate New User ']")
	WebElement delegateNewUserBtn;

	@FindBy(xpath = "//button[text()='Search']")
	WebElement searchBtn;

	@FindBy(xpath = "//input[@placeholder='Search...']")
	WebElement searchBox;

	@FindBy(xpath = "//i[@aria-label='Search']")
	WebElement searchIcon;
	
	@FindBy(xpath = "//span[text()='Total: 1']")
	WebElement listLoad;

	@FindBy(css = ".la-chevron-circle-right")
	WebElement selectUser;

	@FindBy(id = "StartTime")
	WebElement delegationStartTime;

	@FindBy(xpath = "//button[@class='current']//span")
	WebElement selectCurrentYear;

	@FindBy(id = "EndTime")
	WebElement delegationEndTime;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;

	@FindBy(xpath = "//span[text()='Saved successfully.']")
	WebElement successMsg;

	public void userDelegation() throws InterruptedException {
		waitForWebElementToAppear(loadDashboard);
		waitForWebElementToAppear(vettingMgmtMenu);
		vettingMgmtMenu.click();
		Thread.sleep(2000);
		stageBsp.click();
		authorityDelegations.click();
		delegateNewUserBtn.click();
		searchBtn.click();
		waitForWebElementToAppear(searchBox);
		searchBox.sendKeys("melvin_armstrong46@yopmail.com");
		searchIcon.click();
		waitForWebElementToAppear(listLoad);
		selectUser.click();
		delegationStartTime.click();
		selectCurrentYear.click();
		String monthFromXpath = "//table[@class='months']//span";
		String fromYear = "2025";
		String fromMonth = "12";
		String day = "1";
		String fromDay = "//span[@class='ng-star-inserted' and text()='" + day + "']";
		String nextButton = ".next";
		datePicker(monthFromXpath, fromYear, fromMonth, fromDay, nextButton);
		delegationEndTime.click();
		selectCurrentYear.click();
		String toYear = "2025";
		String toMonth = "12";
		String today = "23";
		String toDay = "//span[@class='ng-star-inserted' and text()='" + today + "']";
		datePicker(monthFromXpath, toYear, toMonth, toDay, nextButton);
		saveBtn.click();
		waitForWebElementToAppear(successMsg);
	}
}
