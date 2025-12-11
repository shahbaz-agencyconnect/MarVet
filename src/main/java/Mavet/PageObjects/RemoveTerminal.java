package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class RemoveTerminal extends AbstractComponent{
	WebDriver driver;
	public RemoveTerminal(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(xpath = "//span[text()='Terminal or Charterer']")
	WebElement terminal;

	@FindBy(xpath = "//input[contains(@placeholder,'Search terminal ')]")
	WebElement searchBox;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-trash-alt")
	WebElement deleteIcon;

	@FindBy(css = ".swal2-confirm")
	WebElement confirmBtn;
	
	public void removeTerminal() throws InterruptedException {
		waitForWebElementToAppear(terminal);
		terminal.click();
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys("Test1");
		waitForWebElementToAppear(listLoad);
		Thread.sleep(1000);
		deleteIcon.click();
		confirmBtn.click();
	}
}
