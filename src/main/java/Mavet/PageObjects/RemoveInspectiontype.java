package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class RemoveInspectiontype extends AbstractComponent {
	WebDriver driver;

	public RemoveInspectiontype(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	@FindBy(css = ".fa-chevron-down")
	WebElement settingsMenu;

	@FindBy(xpath = "//a[text()=' Inspection Type ']")
	WebElement openInspectionType;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search inspection type')]")
	WebElement searchBox;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-trash-alt")
	WebElement deleteIcon;

	@FindBy(css = ".swal2-confirm")
	WebElement confirmBtn;
	
	public void removeInspectionType() throws InterruptedException {
		settingsMenu.click();
		openInspectionType.click();
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys("Pre-hire");
		waitForWebElementToAppear(listLoad);
		Thread.sleep(1000);
		deleteIcon.click();
		confirmBtn.click();
	}
}
