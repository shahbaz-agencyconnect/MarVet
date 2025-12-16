package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class UploadUserProfile extends AbstractComponent {
	WebDriver driver;

	public UploadUserProfile(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "button-profile-menu")
	WebElement profileIcon;

	@FindBy(xpath = "//a[text()=' Account Settings ']")
	WebElement accountSettings;

	@FindBy(xpath = "//button[text()='Upload']")
	WebElement uploadBtn;

	@FindBy(id = "uploadProfilePicture")
	WebElement fileUploader;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;

	public void uploadUserProfile() {
		profileIcon.click();
		accountSettings.click();
		uploadBtn.click();
		fileUploader.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");
		saveBtn.click();
	}
}
