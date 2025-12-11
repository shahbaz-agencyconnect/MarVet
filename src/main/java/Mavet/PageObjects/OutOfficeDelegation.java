package Mavet.PageObjects;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class OutOfficeDelegation extends AbstractComponent{
	WebDriver driver;
	public OutOfficeDelegation(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	@FindBy(xpath = "//span[text()='User']")
	WebElement userMenu;
	
	@FindBy(xpath = "//input[@placeholder='Search user']")
	WebElement searchBox;
	
	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;
	
	@FindBy(css = ".fa-pen")
	WebElement editIcon;	
	
	@FindBy(css = ".modal-content")
	WebElement dialog;	 

	@FindBy(xpath = "//span[text()=' Enable Out of Office ']")
	WebElement outOfficeCheckbox;
	
	@FindBy(xpath = "//div[text()='Search for substitute user...']/parent::div//input")
	WebElement clickSubstituteUser;	
	
	@FindBy(xpath = "//span[text()='Alia  (alia.rohan17@yopmail.com)']")
	WebElement selectSubstituteUser;	
	
	@FindBy(id = "DelegationStartDate")
	WebElement delegationStartDate;	

	@FindBy(xpath = "//button[@class='current']//span")
	WebElement selectCurrentYear;
	
	@FindBy(id = "DelegationEndDate")
	WebElement delegationEndDate;	
	
	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;	
	
	public void outOfOfficeDelegation() throws InterruptedException, FileNotFoundException {
		userMenu.click();
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys("melvin_armstrong46@yopmail.com");
		waitForWebElementToAppear(listLoad);
		editIcon.click();
		waitForWebElementToAppear(dialog);
		outOfficeCheckbox.click();
		clickSubstituteUser.click();
		clickSubstituteUser.sendKeys("Alia");
		selectSubstituteUser.click();
		delegationStartDate.click();
		selectCurrentYear.click();
		String monthFromXpath = "//table[@class='months']//span";
		String fromYear = "2025";
		String fromMonth = "12";
		String day = "1";
		String fromDay = "//span[@class='ng-star-inserted' and text()='" + day + "']";
		String nextButton = ".next";
		datePicker(monthFromXpath, fromYear, fromMonth, fromDay, nextButton);
		delegationEndDate.click();
		selectCurrentYear.click();
		String toYear = "2025";
		String toMonth = "12";
		String today = "23";
		String toDay = "//span[@class='ng-star-inserted' and text()='" + today + "']";
		datePicker(monthFromXpath, toYear, toMonth, toDay, nextButton);	
		saveBtn.click();
		Thread.sleep(5000);
		String subject="//div[contains(text(),'Out of Office Delegation: Melvin Armstrong ')]";
		verificationLink("alia.rohan17@yopmail.com",subject);
	}
}
