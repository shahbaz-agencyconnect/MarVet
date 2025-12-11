package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class EditClientGroup extends AbstractComponent {
	WebDriver driver;

	public EditClientGroup(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	@FindBy(xpath = "//span[text()='Client Group']")
	WebElement clientGroup;

	@FindBy(xpath = "//input[contains(@placeholder,'Search client ')]")
	WebElement searchBox;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-pen ")
	WebElement editIcon;

	@FindBy(xpath = "//label[text()='Name ']/parent::div/input")
	WebElement clientGrpName;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;
	
	public void editClientGroup() throws InterruptedException {
		clientGroup.click();
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys("Test");
		waitForWebElementToAppear(listLoad);
		Thread.sleep(1000);
		editIcon.click();
		clientGrpName.sendKeys(" Update");
		saveBtn.click();
	}
}
