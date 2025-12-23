package Mavet.PageObjects;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class InspectionAudit extends AbstractComponent {
	WebDriver driver;

	public InspectionAudit(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Inspection/Audit ']")
	WebElement inspectionAuditCheckBox;

	@FindBy(xpath = "//app-text-input[@name='clientCompany']//input")
	WebElement endUserName;

	@FindBy(xpath = "//app-email-input[@name='clientEmail']//input")
	WebElement endUserEmail;

	@FindBy(xpath = "//app-textarea-input[@name='scopeOfWork']//textarea")
	WebElement workScope;

	@FindBy(xpath = "//app-dropdown-input[@name='vesselId']//span[text()='-- Select --']")
	WebElement vesselNameDropDown;

	@FindBy(xpath = "//app-text-input[@name='docCompany']//input")
	WebElement vtoName;

	@FindBy(xpath = "//app-text-input[@name='submittedByEmail']//input")
	WebElement requestorEmail;

	@FindBy(xpath = "//button[text()=' Submit Request ']")
	WebElement submitBtn;

	@FindBy(xpath = "//h2[@id='swal2-title']")
	WebElement successMessage;

	@FindBy(css = ".swal2-confirm")
	WebElement okBtn;

	public void inspectionAudit() throws InterruptedException, FileNotFoundException {
		ArrayList<String> vesselEntries = excelRead("Request InpectionAudit");
		String endUsername = vesselEntries.get(0);
		String endUseremail = vesselEntries.get(1);
		String workscope = vesselEntries.get(2);
		String vesselName = vesselEntries.get(3);
		String vtoname = vesselEntries.get(4);
		String requestorEmailId = vesselEntries.get(5);

		inspectionAuditCheckBox.click();
		endUserName.sendKeys(endUsername);
		endUserEmail.sendKeys(endUseremail);
		workScope.sendKeys(workscope);
		vesselNameDropDown.click();
		WebElement selectVessel = driver.findElement(By.xpath("//span[text()='" + vesselName + "']"));
		selectVessel.click();
		vtoName.sendKeys(vtoname);
		requestorEmail.sendKeys(requestorEmailId);
		submitBtn.click();
		waitForWebElementToAppear(successMessage);
		okBtn.click();
	}
}
