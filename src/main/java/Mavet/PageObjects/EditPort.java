package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class EditPort extends AbstractComponent {
	WebDriver driver;

	public EditPort(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//span[text()='Port Management']")
	WebElement portManagement;

	@FindBy(xpath = "//input[contains(@placeholder,'Search port')]")
	WebElement searchBox;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-pen ")
	WebElement editIcon;

	@FindBy(xpath = "//label[text()='Name ']/parent::div/input")
	WebElement portName;
	
	@FindBy(xpath = "//label[text()='Code ']/parent::div/input")
	WebElement codeName;	

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;

	public void editPort() throws InterruptedException {
		portManagement.click();
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys("Sundarban");
		waitForWebElementToAppear(listLoad);
		Thread.sleep(1000);
		editIcon.click();
		portName.sendKeys(" Update");
		codeName.sendKeys("321");
		saveBtn.click();
	}
}
