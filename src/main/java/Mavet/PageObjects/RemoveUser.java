package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class RemoveUser extends AbstractComponent {
	WebDriver driver;
	public RemoveUser(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	@FindBy(xpath = "//span[text()='User']")
	WebElement user;

	@FindBy(xpath = "//input[@placeholder='Search user']")
	WebElement searchBox;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-trash-alt")
	WebElement deleteIcon;
	
	@FindBy(css = ".swal2-confirm")
	WebElement confirmBtn;	
	
	public void removeUser() throws InterruptedException {
		user.click();
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys("keenan");
		waitForWebElementToAppear(listLoad);
		Thread.sleep(1000);
		deleteIcon.click();
		confirmBtn.click();
	}
}
