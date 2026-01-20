package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class EditInspection extends AbstractComponent {
	WebDriver driver;

	public EditInspection(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".d-flex")
	WebElement loadDashboard;

	@FindBy(xpath = "//span[text()='Inspection Management']")
	WebElement inspectionMenu;

	@FindBy(xpath = "//input[@placeholder='Search inspection']")
	WebElement searchBox;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-pen")
	WebElement editIcon;

	@FindBy(xpath = "//label[text()='Client ']/parent::div//input")
	WebElement clientName;

	@FindBy(xpath = "//span[text()='ASIAN GEOS SDN BHD']")
	WebElement selectClient;

	@FindBy(xpath = "//label[text()='DOC ']/parent::div//input")
	WebElement docName;

	@FindBy(xpath = "//span[text()='GO Offshore Pty Ltd']")
	WebElement selectDoc;

	@FindBy(xpath = "//label[text()='Port ']/parent::div//input")
	WebElement portName;

	@FindBy(xpath = "//span[text()='Ray Jetty (RJ)']")
	WebElement selectPort;

	@FindBy(xpath = "//label[text()='Inspector ']/parent::div//input")
	WebElement inspectorName;

	@FindBy(xpath = "//span[contains(text(),'Rajeev')]")
	WebElement selectInspector;

	@FindBy(xpath = "//label[text()='Status ']/parent::div//input")
	WebElement statusDropdown;

	@FindBy(xpath = "//span[text()='In Progress']")
	WebElement selectStatus;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;

	public void editInspection() {
		waitForWebElementToAppear(loadDashboard);
		waitForWebElementToAppear(inspectionMenu);
		inspectionMenu.click();
		searchBox.sendKeys("9606170");
		waitForWebElementToAppear(listLoad);
		editIcon.click();
		clientName.click();
		selectClient.click();
		docName.click();
		selectDoc.click();
		portName.click();
		selectPort.click();
		inspectorName.click();
		selectInspector.click();
		statusDropdown.click();
		selectStatus.click();
		saveBtn.click();
	}
}
