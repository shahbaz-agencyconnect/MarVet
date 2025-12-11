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

public class InspectionRequest extends AbstractComponent {
	WebDriver driver;

	public InspectionRequest(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()=' Inspection ']")
	WebElement inspection;

	@FindBy(xpath = "//span[text()=' Preliminary Mer Vet ']")
	WebElement PreliminaryMerVet;

	@FindBy(xpath = "//span[text()=' Full Term Mer Vet ']")
	WebElement FullTermMerVet;

	@FindBy(xpath = "//app-text-input[@name='vesselName']//input")
	WebElement vesselName;

	@FindBy(xpath = "//app-text-input[@name='imo']//input")
	WebElement vesselImo;

	@FindBy(xpath = "//span[contains(text(),'Vessel not found ')]")
	WebElement vesselNotFound;

	@FindBy(xpath = "//app-text-input[@name='clientCompany']//input")
	WebElement clientName;

	@FindBy(xpath = "//app-email-input[@name='clientEmail']//input")
	WebElement clientEmail;

	@FindBy(xpath = "//app-text-input[@name='docCompany']//input")
	WebElement docCompany;

	@FindBy(xpath = "//app-text-input[@name='portAndTerminal']//input")
	WebElement portTerminal;

	@FindBy(xpath = "//bs-date-input[@name='estimatedTimeOfArrival']//input")
	WebElement eTA;
	
	@FindBy(xpath = "//button[@class=\"current\"]//span")
	WebElement selectCurrentYear;

	@FindBy(xpath = "//button[text()=' Submit Request ']")
	WebElement submitBtn;
	
	@FindBy(id="swal2-title")
	WebElement successMessage;	
	
	@FindBy(css=".swal2-confirm")
	WebElement okBtn;		
	
	@FindBy(xpath = "//span[text()='Inspection Management']")
	WebElement inspectionMgmtMenu;
	
	@FindBy(xpath = "//input[@placeholder='Search inspection']")
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

	public void inspectionRequest() throws IOException, TesseractException, InterruptedException {
		ArrayList<String> vesselEntries = excelRead("Request Inspection");
		String name = vesselEntries.get(0);
		String imoNum = vesselEntries.get(1);
		String requestorComName = vesselEntries.get(2);
		String requestorEmail = vesselEntries.get(3);
		String docComp = vesselEntries.get(4);
		String portName = vesselEntries.get(5);
		String monthFromXpath = "//table[@class='months']//span";
		String year = vesselEntries.get(6);
		String month = vesselEntries.get(7);
		String day = vesselEntries.get(8);
		String fromDay = "//span[@class='ng-star-inserted' and text()='" + day + "']";
		String nextButton = ".next";
		inspection.click();
		vesselName.sendKeys(name);
		vesselImo.sendKeys(imoNum);
		waitForWebElementToAppear(vesselNotFound);
		clientName.sendKeys(requestorComName);
		clientEmail.sendKeys(requestorEmail);
		docCompany.sendKeys(docComp);
		portTerminal.sendKeys(portName);
		eTA.click();
		selectCurrentYear.click();
		datePicker(monthFromXpath, year, month, fromDay, nextButton);
		submitBtn.click();
		waitForWebElementToAppear(successMessage);
		okBtn.click();
		ArrayList<String> data = excelRead("Login");
		LandingPage landingPage = new LandingPage(driver);
		landingPage.loginApplication(data.get(0), data.get(1));
		waitForWebElementToAppear(inspectionMgmtMenu);
		inspectionMgmtMenu.click();
		Thread.sleep(2000);
		searchBox.sendKeys(imoNum);
		waitForWebElementToAppear(listLoad);
		String getText = driver.findElement(By.xpath("(//table[contains(@id,'pr_id_')]//td)[2]")).getText();
		String regex = "\\((\\d+)\\)";
		String getImoNumber = getText.replaceAll(".*" + regex + ".*", "$1");
        System.out.println("Extracted Number: " + getImoNumber);

	}
}
