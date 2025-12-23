package Mavet.PageObjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Marvet.AbstractComponent.AbstractComponent;
import net.sourceforge.tess4j.TesseractException;
import org.testng.Assert;

public class ServiceRequest extends AbstractComponent {
	WebDriver driver;

	public ServiceRequest(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Clearance ']")
	WebElement clearanceCheckBox;

	@FindBy(xpath = "//app-text-input[@name='clientCompany']//input")
	WebElement endUserName;
	
	@FindBy(xpath = "//app-email-input[@name='clientEmail']//input")
	WebElement endUserEmail;
	
	@FindBy(xpath = "//app-textarea-input[@name='scopeOfWork']//textarea")
	WebElement workScope;		
	
	@FindBy(xpath = "//app-dropdown-input[@name='vesselId']//span[text()='-- Select --']")
	WebElement vesselNameDropDown;
	
	@FindBy(xpath = "//app-text-input[@name='imo']//input")
	WebElement vesselImo;

	@FindBy(xpath = "//span[contains(text(),'Vessel not found ')]")
	WebElement vesselNotFound;

	@FindBy(xpath = "//app-text-input[@name='docCompany']//input")
	WebElement vtoName;

	@FindBy(xpath = "//app-email-input[@name='docEmail']//input")
	WebElement vtoEmail;

	@FindBy(xpath = "//app-text-input[@name='submittedByEmail']//input")
	WebElement requestorEmail;

	@FindBy(xpath = "//app-text-input[@name='portAndTerminal']//input")
	WebElement portTerminal;

	@FindBy(xpath = "//bs-date-input[@name='clearanceStartDate']//input")
	WebElement clearanceRequestDate;
	
	@FindBy(xpath = "//bs-date-input[@name='clearanceEndDate']//input")
	WebElement clearanceEndDate;
	
	@FindBy(xpath = "//button[@class='current']//span")
	WebElement selectCurrentYear;

	@FindBy(xpath = "//button[text()=' Submit Request ']")
	WebElement submitBtn;
	
	@FindBy(xpath="//h2[@id='swal2-title']")
	WebElement successMessage;	
	
	@FindBy(css=".swal2-confirm")
	WebElement okBtn;		
	
	@FindBy(xpath = "//span[text()='Vetting Management']")
	WebElement vettingMgmtMenu;
	
	@FindBy(xpath = "//input[@formcontrolname='filterText']")
	WebElement searchBox;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement searchIcon;
	
	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;	
	
	@FindBy(id = "dropdownButton")
	WebElement actionBtn;
	
	@FindBy(xpath = "//a[text()=' Start Vet ']")
	WebElement startVetOption;
	
	@FindBy(id = "kt_wrapper")
	WebElement loadSummaryPage;	
	
	@FindBy(xpath = "//button[text()=' ACCEPTED ']")
	WebElement acceptBtn;
	
	@FindBy(css = ".swal2-confirm")
	WebElement confirmBtn;

	public void vesselService() throws IOException, TesseractException, InterruptedException {
		ArrayList<String> vesselEntries = excelRead("Request Service");
		String endUsername= vesselEntries.get(0);
		String endUseremail= vesselEntries.get(1);
		String workscope= vesselEntries.get(2);
		String vesselName = vesselEntries.get(3);
		String imoNum = vesselEntries.get(4);
		String vtoname = vesselEntries.get(5);
		String monthFromXpath = "//table[@class='months']//span";
		String fromYear = vesselEntries.get(6);
		String fromMonth = vesselEntries.get(7);
		String startDay = vesselEntries.get(8);
		String fromDay = "//span[@class='ng-star-inserted' and text()='" + startDay + "']";
		String toYear = vesselEntries.get(9);
		String toMonth = vesselEntries.get(10);
		String endDay = vesselEntries.get(11);
		String toDay = "//span[@class='ng-star-inserted' and text()='" + endDay + "']";
		String nextButton = ".next";
		String requestorEmailId = vesselEntries.get(12);

		clearanceCheckBox.click();
		endUserName.sendKeys(endUsername);
		endUserEmail.sendKeys(endUseremail);
		workScope.sendKeys(workscope);
		vesselNameDropDown.click();
		WebElement selectVessel =driver.findElement(By.xpath("//span[text()='"+vesselName+"']"));
		selectVessel.click();
//		vesselImo.sendKeys(imoNum);
//		waitForWebElementToAppear(vesselNotFound);

		clearanceRequestDate.click();
		selectCurrentYear.click();
		datePicker(monthFromXpath, fromYear, fromMonth, fromDay, nextButton);
		
		clearanceEndDate.click();
		selectCurrentYear.click();
		datePicker(monthFromXpath, toYear, toMonth, toDay, nextButton);
		
		vtoName.sendKeys(vtoname);
		requestorEmail.sendKeys(requestorEmailId);
		submitBtn.click();
		
		waitForWebElementToAppear(successMessage);
		okBtn.click();
//		ArrayList<String> data = excelRead("Login");
//		LandingPage landingPage = new LandingPage(driver);
//		landingPage.loginApplication(data.get(0), data.get(1));
//		waitForWebElementToAppear(vettingMgmtMenu);
//		vettingMgmtMenu.click();
//		Thread.sleep(2000);
//		searchBox.sendKeys(imoNum);
//		searchIcon.click();
//		Thread.sleep(2000);
//		String expectedImo = driver.findElement(By.xpath("(//table[contains(@id,'pr_id_')]//td)[2]")).getText();
//		Assert.assertEquals(imoNum, expectedImo);		
//		actionBtn.click();
//		startVetOption.click();
//		waitForWebElementToAppear(loadSummaryPage);
//		acceptBtn.click();
//		confirmBtn.click();
	}
}
