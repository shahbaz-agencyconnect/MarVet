package Mavet.PageObjects;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class EditVessel extends AbstractComponent {
	WebDriver driver;

	public EditVessel(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@FindBy(xpath = "//span[text()='Vessel Management']")
	WebElement vesselManagement;

	@FindBy(xpath = "//input[contains(@placeholder,'vessel name')]")
	WebElement searchBox;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-pen ")
	WebElement editIcon;
	
	@FindBy(css = ".modal-content")
	WebElement vesselDialog;
	
	@FindBy(xpath = "//label[text()='Vessel Name ']/parent::div/input")
	WebElement vesselName;
	
	@FindBy(xpath = "//label[text()='IMO ']/parent::div/input")
	WebElement imoNum;
	
	@FindBy(xpath = "//label[text()='DWT ']/parent::div/input")
	WebElement dwt;
	
	@FindBy(xpath = "//label[text()='Vessel Type ']/parent::div/input")
	WebElement vesselType;
	
	@FindBy(xpath = "//label[text()='Flag ']/parent::div/input")
	WebElement flag;
	
	@FindBy(xpath = "//label[text()='Class ']/parent::div/input")
	WebElement className;
	
	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;

	public void editVessel() throws FileNotFoundException, InterruptedException {
		waitForWebElementToAppear(vesselManagement);
		vesselManagement.click();
		ArrayList<String> data = excelRead("Edit Vessel");
		String vesselImoNum = data.get(1);
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys(vesselImoNum);
		waitForWebElementToAppear(listLoad);
		Thread.sleep(1000);
		editIcon.click();
		waitForWebElementToAppear(vesselDialog);
		vesselName.sendKeys(" Update");
		imoNum.sendKeys(Keys.BACK_SPACE);
		imoNum.sendKeys(Keys.BACK_SPACE);
		imoNum.sendKeys(Keys.BACK_SPACE);
		imoNum.sendKeys(Keys.BACK_SPACE);
		imoNum.sendKeys(Keys.BACK_SPACE);
		imoNum.sendKeys(Keys.BACK_SPACE);
		imoNum.sendKeys(Keys.BACK_SPACE);
		imoNum.sendKeys("1111111");
		dwt.sendKeys("1");
		vesselType.sendKeys(" Update");
		flag.sendKeys(Keys.BACK_SPACE);
		flag.sendKeys(Keys.BACK_SPACE);
		flag.sendKeys("AUS");
		className.sendKeys("(Newzealand)");
		saveBtn.click();
	}
}
