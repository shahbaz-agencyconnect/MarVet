package Marvet.ClearanceDocuments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Marvet.Login.Login;

public class ClearanceDocuments extends Login {

	public void goToClearanceDocument() throws InterruptedException {
		waitForWebElementToAppear(By.xpath("//span[text()='Clearance Management']"));
		WebElement clearanceMgmt = driver.findElement(By.xpath("//span[text()='Clearance Management']"));
		clearanceMgmt.click();
		Thread.sleep(2000);

		waitForWebElementToAppear(By.xpath("//input[@formcontrolname='filterText']"));
		WebElement searchBox = driver.findElement(By.xpath("//input[@formcontrolname='filterText']"));
		searchBox.sendKeys("1333311");

		WebElement searchIcon = driver.findElement(By.xpath("//button[@type='submit']"));
		searchIcon.click();
		Thread.sleep(2000);

		WebElement actionBtn = driver.findElement(By.id("dropdownButton"));
		actionBtn.click();

		WebElement startVetOption = driver.findElement(By.xpath("//a[text()=' Start Vet ']"));
		startVetOption.click();
		waitForWebElementToAppear(By.id("kt_wrapper"));
		waitForWebElementToAppear(By.cssSelector(".la-angle-down"));
		WebElement clearanceDocumentTab = driver.findElement(By.cssSelector(".la-angle-down"));
		clearanceDocumentTab.click();
	}

	public void uploadIFMInspection() throws InterruptedException {
		WebElement shipStaffTab = driver
				.findElement(By.xpath("//a[contains(normalize-space(), 'IFM Inspection (HML & MER)')]"));
		shipStaffTab.click();
		waitForWebElementToAppear(By.xpath("//p-dropdown[@placeholder='Select compliance status']"));
		WebElement complianceStatusDrodown = driver
				.findElement(By.xpath("//p-dropdown[@placeholder='Select compliance status']"));
		complianceStatusDrodown.click();
		
		WebElement selectComplianceStatus=driver.findElement(By.id("p-highlighted-option"));
		selectComplianceStatus.click();

		WebElement selectCalendar=driver.findElement(By.xpath("//p-calendar[@dateformat='dd/mm/yy']"));
		selectCalendar.click();

		WebElement selectCurrentYear=driver.findElement(By.cssSelector(".p-datepicker-year"));
		selectCurrentYear.click();
		
		String monthXpath = "//span[contains(@class,'p-monthpicker-month')]";
		String year = "2035";
		String month = "02";
		String date = "28";
		String day = "//span[contains(@class, 'p-element') and not(contains(@class, 'p-disabled')) and text()='"+date+"']";
		String nextButton = ".p-datepicker-next-icon";
		
		selectDate(monthXpath, year, month, day, nextButton);
		
		WebElement uploadFile=driver.findElement(By.xpath("//p-fileupload[@name='FileUpload']//input"));
		uploadFile.sendKeys(System.getProperty("user.dir")+"\\Sample File\\sample.pdf");
		
		WebElement feedbackComment=driver.findElement(By.xpath("//div[contains(@class,'ck-editor__editable')]//p"));
		feedbackComment.sendKeys("This is a test comment");
		
		WebElement saveBtn=driver.findElement(By.xpath("//button[text()='Save Comment']"));
		saveBtn.click();
//		waitForWebElementToAppear(By.xpath("//span[text()='Saved successfully.']"));
//		driver.quit();

		
	}
}
