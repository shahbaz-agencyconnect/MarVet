package Mavet.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class EditInspectorProfile extends AbstractComponent {
	WebDriver driver;

	public EditInspectorProfile(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".d-flex")
	WebElement loadDashboard;

	@FindBy(xpath = "//span[text()='Inspector Management']")
	WebElement inspectorMgmt;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-pen")
	WebElement editIcon;

	@FindBy(xpath = "//input[@role='combobox']")
	WebElement reviewerDropdown;
	
	@FindBy(xpath = "//span[text()='Josefa  (josefa54@yopmail.com)']")
	WebElement selectReviewer;
	
	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;

	public void editInspector() {
		String userEmail = "nora.brakus@yopmail.com";
		waitForWebElementToAppear(loadDashboard);
		waitForWebElementToAppear(inspectorMgmt);
		inspectorMgmt.click();
		driver.findElement(By.xpath("//input[@placeholder='Search inspector']")).sendKeys(userEmail);
		waitForWebElementToAppear(listLoad);
		editIcon.click();
		reviewerDropdown.click();
		selectReviewer.click();
		saveBtn.click();
	}
}
