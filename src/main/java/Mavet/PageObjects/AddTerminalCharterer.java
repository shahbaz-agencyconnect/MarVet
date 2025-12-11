package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class AddTerminalCharterer extends AbstractComponent{
	WebDriver driver;
	public AddTerminalCharterer(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".d-flex")
	WebElement loadDashboard;
	
	@FindBy(xpath = "//span[text()='Terminal or Charterer']")
	WebElement terminalMenu;
	
	@FindBy(xpath = "//button[text()=' Add Terminal or Charterer ']")
	WebElement addterminalBtn;
	
	@FindBy(css = ".modal-content")
	WebElement terminalDialog;
	
	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement terminalName;	
	
	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;	
	
	public void addTerminal() {
		waitForWebElementToAppear(loadDashboard);
		waitForWebElementToAppear(terminalMenu);
		terminalMenu.click();
		addterminalBtn.click();
		waitForWebElementToAppear(terminalDialog);
		terminalName.sendKeys("Alex");
		saveBtn.click();		
	}
}
