package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class DeleteUserAccount extends AbstractComponent {
	WebDriver driver;

	public DeleteUserAccount(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(css = ".d-flex")
	WebElement loadDashboard;

	@FindBy(id = "button-profile-menu")
	WebElement profileIcon;
	
	@FindBy(xpath = "//a[text()=' Account Settings ']")
	WebElement accountSettings;
	
	@FindBy(xpath = "//button[text()='Delete Account']")
	WebElement deleteAccountbtn;
	
	@FindBy(xpath = "//button[text()='Yes']")
	WebElement confirmbtn;
	
	public void deleteAccount() {
		waitForWebElementToAppear(loadDashboard);
		profileIcon.click();
		accountSettings.click();
		deleteAccountbtn.click();
		confirmbtn.click();
	}
}
