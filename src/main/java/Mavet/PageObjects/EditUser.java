package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class EditUser extends AbstractComponent{
	WebDriver driver;
	public EditUser(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	@FindBy(xpath = "//span[text()='User']")
	WebElement user;

	@FindBy(xpath = "//input[@placeholder='Search user']")
	WebElement searchBox;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-pen ")
	WebElement editIcon;

	@FindBy(xpath = "//label[text()='First Name ']/parent::div/input")
	WebElement firstName;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;
	public void editUser() throws InterruptedException {
		user.click();
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys("keenan");
		waitForWebElementToAppear(listLoad);
		Thread.sleep(1000);
		editIcon.click();
		firstName.sendKeys(" Update");
//		saveBtn.click();
	}
}
