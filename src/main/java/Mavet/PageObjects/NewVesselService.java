package Mavet.PageObjects;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class NewVesselService extends AbstractComponent {
	WebDriver driver;

	public NewVesselService(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Clearance ']")
	WebElement clearanceCheckBox;

	@FindBy(xpath = "//span[text()=' Inspection/Audit ']")
	WebElement inspectionAuditCheckBox;

	@FindBy(xpath = "//app-text-input[@name='clientCompany']//input")
	WebElement endUserName;

	@FindBy(xpath = "//app-email-input[@name='clientEmail']//input")
	WebElement endUserEmail;

	@FindBy(xpath = "//app-textarea-input[@name='scopeOfWork']//textarea")
	WebElement workScope;

	@FindBy(css = ".fa-plus ")
	WebElement addVesselLink;

	@FindBy(xpath = "//input[@placeholder='Vessel Name']")
	WebElement vesselName;

	@FindBy(xpath = "//input[@placeholder='IMO/Reg Number']")
	WebElement iMO;

	@FindBy(xpath = "//input[@placeholder='DWT']")
	WebElement dwt;

	@FindBy(xpath = "//span[text()='Select Vessel Type']")
	WebElement vesselTypeDropdown;

	@FindBy(xpath = "//input[@placeholder='Year of Build']")
	WebElement yearOfBuild;

	@FindBy(xpath = "//input[@placeholder='Flag']")
	WebElement flag;

	@FindBy(xpath = "//input[@placeholder='Class']")
	WebElement className;

	@FindBy(xpath = "//input[@placeholder='Contract Holder Email']")
	WebElement contractHolderEmail;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//h2[text()='Success']")
	WebElement successMsg;
	
	@FindBy(css = ".swal2-confirm")
	WebElement okBtn;
	
	@FindBy(xpath = "//bs-date-input[@name='clearanceStartDate']//input")
	WebElement clearanceRequestDate;
	
	@FindBy(xpath = "//bs-date-input[@name='clearanceEndDate']//input")
	WebElement clearanceEndDate;
	
	@FindBy(xpath = "//button[@class='current']//span")
	WebElement selectCurrentYear;
	
	@FindBy(xpath = "//app-text-input[@name='docCompany']//input")
	WebElement vtoName;

	@FindBy(xpath = "//app-text-input[@name='submittedByEmail']//input")
	WebElement requestorEmail;

	@FindBy(xpath = "//button[text()=' Submit Request ']")
	WebElement submitBtn;

	public void newVesselServiceRequest() throws FileNotFoundException, InterruptedException {
		waitForWebElementToAppear(clearanceCheckBox);
		clearanceCheckBox.click();
		inspectionAuditCheckBox.click();
		AbstractComponent abs = new AbstractComponent(driver);
		ArrayList<String> data = abs.excelRead("Add New Vessel");
		// Vessel Details
		String endUsername = data.get(0);
		String endUseremail = data.get(1);
		String workscope = data.get(2);
		String name = data.get(3);
		String imo = data.get(4);
		String vesselDwt = data.get(5);
		String type = data.get(6);
		String buildYear = data.get(7);
		String nationFlag = data.get(8);
		String clsName = data.get(9);
		String contractholderEmailId = data.get(10);		
		String vtoname = data.get(11);
		String monthFromXpath = "//table[@class='months']//span";
		String fromYear = data.get(12);
		String fromMonth = data.get(13);
		String startDay = data.get(14);
		String fromDay = "//span[@class='ng-star-inserted' and text()='" + startDay + "']";
		String toYear = data.get(15);
		String toMonth = data.get(16);
		String endDay = data.get(17);
		String toDay = "//span[@class='ng-star-inserted' and text()='" + endDay + "']";
		String nextButton = ".next";
		String requestorEmailId = data.get(18);
		
		endUserName.sendKeys(endUsername);
		endUserEmail.sendKeys(endUseremail);
		workScope.sendKeys(workscope);
		addVesselLink.click();
		vesselName.sendKeys(name);
		iMO.sendKeys(imo);
		dwt.sendKeys(vesselDwt);
		vesselTypeDropdown.click();
		driver.findElement(By.xpath("//span[text()='"+type+"']")).click();
		yearOfBuild.sendKeys(buildYear);
		flag.sendKeys(nationFlag);
		className.sendKeys(clsName);
		contractHolderEmail.sendKeys(contractholderEmailId);
		saveBtn.click();
		waitForWebElementToAppear(successMsg);
		okBtn.click();
		
		clearanceRequestDate.click();
		selectCurrentYear.click();
		datePicker(monthFromXpath, fromYear, fromMonth, fromDay, nextButton);
		
		clearanceEndDate.click();
		selectCurrentYear.click();
		datePicker(monthFromXpath, toYear, toMonth, toDay, nextButton);
		
		vtoName.sendKeys(vtoname);
		requestorEmail.sendKeys(requestorEmailId);
		submitBtn.click();
		
		waitForWebElementToAppear(successMsg);
		okBtn.click();
	}
}
