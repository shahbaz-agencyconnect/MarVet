package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class RemoveClient extends AbstractComponent {
	WebDriver driver;

	public RemoveClient(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//span[text()='Client Management']")
	WebElement client;

	@FindBy(xpath = "//input[contains(@placeholder,'Search client')]")
	WebElement searchBox;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-trash-alt")
	WebElement deleteIcon;

	@FindBy(css = ".swal2-confirm")
	WebElement confirmBtn;
	
	public void removeClient() throws InterruptedException {
		waitForWebElementToAppear(client);
		client.click();
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys("Test");
		waitForWebElementToAppear(listLoad);
		Thread.sleep(1000);
		deleteIcon.click();
		confirmBtn.click();
	}
}
