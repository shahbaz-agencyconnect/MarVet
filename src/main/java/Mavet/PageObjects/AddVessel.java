package Mavet.PageObjects;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class AddVessel extends AbstractComponent{
	WebDriver driver;
	public AddVessel(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[text()='Vessel Management']")
	WebElement vesselManagement;

	@FindBy(xpath = "//button[text()=' Add Vessel ']")
	WebElement addVessel;
	
	@FindBy(css = ".modal-content")
	WebElement vesselDialog;

	@FindBy(xpath = "//input[@placeholder='Vessel Name']")
	WebElement vesselName;

	@FindBy(xpath = "//input[@placeholder='IMO']")
	WebElement iMO;

	@FindBy(xpath = "//input[@placeholder='DWT']")
	WebElement dwt;

	@FindBy(xpath = "//input[@placeholder='Vessel Type']")
	WebElement vesselType;

	@FindBy(xpath = "//input[@placeholder='Year of Build']")
	WebElement yearOfBuild;

	@FindBy(xpath = "//input[@placeholder='Flag']")
	WebElement flag;

	@FindBy(xpath = "//input[@placeholder='Class']")
	WebElement className;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;
	
	public void addVessel() throws FileNotFoundException {
		AbstractComponent abs = new AbstractComponent(driver);
		ArrayList<String> data = abs.excelRead("Create Vessel");
		// Vessel Details
		String name = data.get(0);
		String imo = data.get(1);
		String vesselDwt = data.get(2);
		String type = data.get(3);
		String buildYear = data.get(4);
		String nationFlag = data.get(5);
		String clsName = data.get(6);
		waitForWebElementToAppear(vesselManagement);
		vesselManagement.click();
		addVessel.click();
		waitForWebElementToAppear(vesselDialog);
		vesselName.sendKeys(name);
		iMO.sendKeys(imo);
		dwt.sendKeys(vesselDwt);
		vesselType.sendKeys(type);
		yearOfBuild.sendKeys(buildYear);
		flag.sendKeys(nationFlag);
		className.sendKeys(clsName);
		saveBtn.click();
	}
}
