package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class AddPort extends AbstractComponent{
	WebDriver driver;
	public AddPort(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".d-flex")
	WebElement loadDashboard;
	
	@FindBy(xpath = "//span[text()='Port Management']")
	WebElement portMenu;
	
	@FindBy(xpath = "//button[text()=' Add Port ']")
	WebElement addPortBtn;
	
	@FindBy(css = ".modal-content")
	WebElement portDialog;
	
	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement portName;	
	
	@FindBy(xpath = "//input[@placeholder='Code']")
	WebElement portCode;	
	
	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;	
	
	public void addPort() {
		waitForWebElementToAppear(loadDashboard);
		waitForWebElementToAppear(portMenu);
		portMenu.click();
		addPortBtn.click();
		waitForWebElementToAppear(portDialog);
		portName.sendKeys("Sundarban");
		portCode.sendKeys("SBN001");
		saveBtn.click();
	}
}
