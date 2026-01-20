package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class ChangePassword extends AbstractComponent{
	WebDriver driver;
	public ChangePassword(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".d-flex")
	WebElement loadDashboard;

	@FindBy(id = "button-profile-menu")
	WebElement profileIcon;
	
	@FindBy(xpath = "//a[text()=' Change Password ']")
	WebElement changePassItem;
	
	@FindBy(id = "CurrentPassword")
	WebElement oldPassField;
	
	@FindBy(id = "NewPassword")
	WebElement newPassField;
	
	@FindBy(id = "NewPasswordRepeat")
	WebElement confirmPassField;
	
	@FindBy(xpath = "//span[text()='Update']")
	WebElement updateBtn;	
	
	public void changePass() {
		waitForWebElementToAppear(loadDashboard);
		profileIcon.click();
		changePassItem.click();
		oldPassField.sendKeys("Admin@123");
		newPassField.sendKeys("Admin@4321");
		confirmPassField.sendKeys("Admin@4321");
		updateBtn.click();
	}
}
