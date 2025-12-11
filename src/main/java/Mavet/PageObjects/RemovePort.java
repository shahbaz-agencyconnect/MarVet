package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class RemovePort extends AbstractComponent{
	WebDriver driver;
	public RemovePort(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	@FindBy(xpath = "//span[text()='Port Management']")
	WebElement portManagement;

	@FindBy(xpath = "//input[contains(@placeholder,'Search port ')]")
	WebElement searchBox;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-trash-alt")
	WebElement deleteIcon;

	@FindBy(css = ".swal2-confirm")
	WebElement confirmBtn;
	
	public void removePort() throws InterruptedException {
		waitForWebElementToAppear(portManagement);
		portManagement.click();
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys("Thailand");
		waitForWebElementToAppear(listLoad);
		Thread.sleep(1000);
		deleteIcon.click();
		confirmBtn.click();
	}
}
