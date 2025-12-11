package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class EditTerminalCharterer extends AbstractComponent{
	WebDriver driver;
	public EditTerminalCharterer(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	@FindBy(xpath = "//span[text()='Terminal or Charterer']")
	WebElement terminal;

	@FindBy(xpath = "//input[contains(@placeholder,'Search terminal ')]")
	WebElement searchBox;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-pen ")
	WebElement editIcon;

	@FindBy(xpath = "//label[text()='Name ']/parent::div/input")
	WebElement terminalName;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;
	
	public void editTerminalCharterer() throws InterruptedException {
		terminal.click();
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys("Alex");
		waitForWebElementToAppear(listLoad);
		Thread.sleep(1000);
		editIcon.click();
		terminalName.sendKeys(" Update");
		saveBtn.click();
	}
}
