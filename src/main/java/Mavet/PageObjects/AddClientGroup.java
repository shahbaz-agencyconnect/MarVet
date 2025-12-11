package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import Marvet.AbstractComponent.AbstractComponent;

public class AddClientGroup extends AbstractComponent {
	WebDriver driver;

	public AddClientGroup(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".d-flex")
	WebElement loadDashboard;

	@FindBy(xpath = "//span[text()='Client Group']")
	WebElement clientGrpMenu;

	@FindBy(xpath = "//button[text()=' Add Client Group ']")
	WebElement addClientGrpBtn;

	@FindBy(css = ".modal-content")
	WebElement clientGrpDialog;

	@FindBy(xpath = "//input[@placeholder='Name']")
	WebElement clientGrpName;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;

	public void addClientGroup() {
		waitForWebElementToAppear(loadDashboard);
		waitForWebElementToAppear(clientGrpMenu);
		clientGrpMenu.click();
		addClientGrpBtn.click();
		waitForWebElementToAppear(clientGrpDialog);
		clientGrpName.sendKeys("Test Group");
		saveBtn.click();		
	}
}
