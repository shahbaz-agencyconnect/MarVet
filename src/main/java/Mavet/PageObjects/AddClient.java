package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class AddClient extends AbstractComponent{
	WebDriver driver;
	public AddClient(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".d-flex")
	WebElement loadDashboard;
	
	@FindBy(xpath = "//span[text()='Client Management']")
	WebElement clientMngtMenu;
	
	@FindBy(xpath = "//button[text()=' Add Client ']")
	WebElement addClientBtn;
	
	@FindBy(css = ".modal-content")
	WebElement clientDialog;
	
	@FindBy(xpath = "//input[@placeholder='Client Name']")
	WebElement clientName;
	
	@FindBy(xpath = "//input[@placeholder='Client Email']")
	WebElement clientEmail;
	
	@FindBy(xpath = "//div[contains(@id,'searchable-select')]//div")
	WebElement clientGroup;
	
	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;
	
	public void addClient() {
		waitForWebElementToAppear(loadDashboard);
		waitForWebElementToAppear(clientMngtMenu);
		clientMngtMenu.click();
		addClientBtn.click();
		waitForWebElementToAppear(clientDialog);
		clientName.sendKeys("Kamal");
		clientEmail.sendKeys("kamal.kantt@yopmail.com");
		clientGroup.click();
		saveBtn.click();
	}
}
