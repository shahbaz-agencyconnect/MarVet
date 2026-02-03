package Marvet.VesselManagementModule;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Marvet.Login.Login;

public class VesselManagement extends Login {

	public void addNewVessel() throws FileNotFoundException {
		waitForWebElementToAppear(By.xpath("//span[text()='Vessel Management']"));
		WebElement vesselMgmt = driver.findElement(By.xpath("//span[text()='Vessel Management']"));
		vesselMgmt.click();
		ArrayList<String> data = excelRead("Create Vessel");
		waitForWebElementToAppear(By.xpath("//button[text()=' Add Vessel ']"));
		WebElement addVessel = driver.findElement(By.xpath("//button[text()=' Add Vessel ']"));
		addVessel.click();

		waitForWebElementToAppear(By.cssSelector(".modal-content"));
		// Vessel Details
		String name = data.get(0);
		String imo = data.get(1);
		String vesselDwt = data.get(2);
		String type = data.get(3);
		String buildYear = data.get(4);
		String nationFlag = data.get(5);
		String clsName = data.get(6);
		String contractHolderEmail = data.get(7);

		WebElement vesselName = driver.findElement(By.xpath("//input[@placeholder='Vessel Name']"));
		vesselName.sendKeys(name);

		WebElement iMO = driver.findElement(By.xpath("//input[@placeholder='IMO/Reg Number']"));
		iMO.sendKeys(imo);

		WebElement dwt = driver.findElement(By.xpath("//input[@placeholder='DWT']"));
		dwt.sendKeys(vesselDwt);

		WebElement vesselType = driver.findElement(By.xpath("//span[text()='Select Vessel Type']"));
		vesselType.click();

		WebElement selectVessel = driver.findElement(By.xpath("//span[text()='" + type + "']"));
		selectVessel.click();

		WebElement yearOfBuild = driver.findElement(By.xpath("//input[@placeholder='Year of Build']"));
		yearOfBuild.sendKeys(buildYear);

		WebElement flag = driver.findElement(By.xpath("//input[@placeholder='Flag']"));
		flag.sendKeys(nationFlag);

		WebElement className = driver.findElement(By.xpath("//input[@placeholder='Class']"));
		className.sendKeys(clsName);

		WebElement contractHolder = driver.findElement(By.xpath("//input[@placeholder='Contract Holder Email']"));
		contractHolder.sendKeys(contractHolderEmail);
		
		WebElement activeToggleBtn = driver.findElement(By.id("isActive"));
		activeToggleBtn.click();		

		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully added']"));
	}

	public void editVessel() throws FileNotFoundException {

		ArrayList<String> data = excelRead("Create Vessel");
		String imo = data.get(1);
		waitForWebElementToAppear(By.xpath("//input[contains(@placeholder,'vessel name')]"));
		WebElement searchBox = driver.findElement(By.xpath("//input[contains(@placeholder,'vessel name')]"));
		searchBox.sendKeys(imo);
		
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		clickDesiredIcon(By.xpath("//a[.//i[contains(@class, 'fa-pen')]]"));

		waitForWebElementToAppear(By.cssSelector(".modal-content"));
		WebElement vesselName = driver.findElement(By.xpath("//input[@placeholder='Vessel Name']"));
		vesselName.sendKeys(" Update");
		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Saved successfully.']"));
	}

	public void vesselDocUpload() throws FileNotFoundException, InterruptedException {

		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		waitForWebElementToAppear(By.cssSelector(".fa-file-alt "));
		WebElement docIcon = driver.findElement(By.cssSelector(".fa-file-alt"));
		docIcon.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Upload Document']"));
		WebElement uploadDocBtn = driver.findElement(By.xpath("//span[text()='Upload Document']"));
		uploadDocBtn.click();
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='undefined']"));
		uploadFile.sendKeys(System.getProperty("user.dir")+"\\Sample File\\sample.pdf");
		WebElement docCategoryDropdown = driver
				.findElement(By.xpath("//label[text()='Document Category ']/parent::div//input"));
		docCategoryDropdown.click();
		WebElement selectDocCategory = driver.findElement(By.xpath("//span[text()='OVID Inspection Report']"));
		selectDocCategory.click();
		WebElement docType = driver.findElement(By.xpath("//app-text-input[@name='docType']//input"));
		docType.sendKeys("PDF");
		WebElement docName = driver.findElement(By.xpath("//app-text-input[@name='docName']//input"));
		docName.sendKeys("Test001");
		WebElement selectCalendar = driver.findElement(By.xpath("//bs-date-input[@name='docExpiryDate']//input"));
		selectCalendar.click();
		WebElement selectCurrentYear = driver.findElement(By.xpath("//button[@class='current']//span"));
		selectCurrentYear.click();
		
		String monthXpath = "//table[@class='months']//span";
		String year = "2026";
		String month = "02";
		String date = "26";
		String day = "//span[@class='ng-star-inserted' and text()='" + date + "']";
		String nextButton = ".next";
		datePicker(monthXpath, year, month, day, nextButton);
		
		WebElement reviewedByDropdown = driver
				.findElement(By.xpath("//label[text()='Document Reviewed By ']/parent::div//input"));
		reviewedByDropdown.click();
		waitForWebElementToAppear(By.xpath("//span[contains(text(),'Rajeev')]"));
		WebElement selectReviewedBy = driver.findElement(By.xpath("//span[contains(text(),'Rajeev')]"));
		selectReviewedBy.click();
		WebElement statusDropdown = driver.findElement(By.xpath("//label[text()='Status ']/parent::div//input"));
		statusDropdown.click();

		waitForWebElementToAppear(By.xpath("//span[text()='Eligible']"));
		WebElement selectStatus = driver.findElement(By.xpath("//span[text()='Eligible']"));
		selectStatus.click();

		WebElement mmaComment = driver.findElement(By.xpath("//textarea[contains(@placeholder,'MAA')]"));
		mmaComment.sendKeys("TEST");
		WebElement uploadBtn = driver.findElement(By.xpath("//span[text()='Upload']"));
		uploadBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Document has been uploaded']"));

	}

	public void editVesselDocument() throws InterruptedException {
		waitForWebElementToAppear(By.cssSelector(".fa-pencil-alt"));
		WebElement editIcon = driver.findElement(By.cssSelector(".fa-pencil-alt"));
		editIcon.click();
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='undefined']"));
		uploadFile.sendKeys(System.getProperty("user.dir")+"\\Sample File\\sample-Copy.pdf");
		WebElement docCategoryDropdown = driver
				.findElement(By.xpath("//label[text()='Document Category ']/parent::div//input"));
		docCategoryDropdown.click();
		WebElement selectDocCategory = driver
				.findElement(By.xpath("//span[text()='License to Operate (Non-Brunei Flag Vessel)']"));
		selectDocCategory.click();

		WebElement selectCalendar = driver.findElement(By.xpath("//bs-date-input[@name='docExpiryDate']//input"));
		selectCalendar.click();
		WebElement selectCurrentYear = driver.findElement(By.xpath("//button[@class='current']//span"));
		selectCurrentYear.click();
		
		String monthXpath = "//table[@class='months']//span";
		String year = "2026";
		String month = "02";
		String date = "28";
		String day = "//span[@class='ng-star-inserted' and text()='" + date + "']";
		String nextButton = ".next";
		datePicker(monthXpath, year, month, day, nextButton);

		WebElement statusDropdown = driver.findElement(By.xpath("//label[text()='Status ']/parent::div//input"));
		statusDropdown.click();

		waitForWebElementToAppear(By.xpath("//span[text()='Eligible']"));
		WebElement selectStatus = driver.findElement(By.xpath("//span[text()='Caution']"));
		selectStatus.click();

		WebElement mmaComment = driver.findElement(By.xpath("//textarea[contains(@placeholder,'MAA')]"));
		mmaComment.sendKeys(" Updated");
		WebElement saveBtn = driver.findElement(By.xpath("(//span[text()='Save'])[2]"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Document has been updated']"));

	}

	public void downloadDoc() {
		//Click on download icon
		clickDesiredIcon(By.cssSelector(".flaticon2-download"));
	}

	public void deleteDocument() {
		waitForWebElementToAppear(By.cssSelector(".fa-trash"));
		WebElement deleteIcon = driver.findElement(By.cssSelector(".fa-trash"));
		deleteIcon.click();
		WebElement confirmBtn = driver.findElement(By.cssSelector(".swal2-confirm"));
		confirmBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully deleted.']"));
		WebElement closeBtn = driver.findElement(By.xpath("//span[text()='Close']"));
		closeBtn.click();
	}

	public void deleteVessel() {
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		waitForWebElementToAppear(By.cssSelector(".fa-pen"));
		WebElement deleteIcon = driver.findElement(By.cssSelector(".fa-trash-alt "));
		deleteIcon.click();
		WebElement confirmBtn = driver.findElement(By.cssSelector(".swal2-confirm"));
		confirmBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully deleted.']"));
	}

}
