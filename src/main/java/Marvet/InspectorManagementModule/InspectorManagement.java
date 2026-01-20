package Marvet.InspectorManagementModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.Login.Login;

public class InspectorManagement extends Login {
	public void updateInspectorReviewer() {
		waitForWebElementToAppear(By.xpath("//span[text()='Inspector Management']"));
		WebElement inspectorMgmt = driver.findElement(By.xpath("//span[text()='Inspector Management']"));
		inspectorMgmt.click();
		waitForWebElementToAppear(By.xpath("//input[@placeholder='Search inspector']"));
		WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search inspector']"));
		searchBox.sendKeys("ardella4@yopmail.com");
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		WebElement editIcon = driver.findElement(By.cssSelector(".fa-pen"));
		editIcon.click();
		WebElement reviewerDropdown = driver.findElement(By.xpath("//input[@role='combobox']"));
		reviewerDropdown.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Ravi (ravi.kumar@yopmail.com)']"));
		WebElement selectReviewer = driver.findElement(By.xpath("//span[text()='Ravi (ravi.kumar@yopmail.com)']"));
		selectReviewer.click();
		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Inspector profile updated successfully.']"));
	}

	public void inspectorDocUpload() throws InterruptedException {

		waitForWebElementToAppear(By.cssSelector(".fa-file-alt"));
		WebElement docIcon = driver.findElement(By.cssSelector(".fa-file-alt"));
		docIcon.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Upload Document']"));
		WebElement uploadDocBtn = driver.findElement(By.xpath("//span[text()='Upload Document']"));
		uploadDocBtn.click();
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='undefined']"));
		uploadFile.sendKeys("C:\\Users\\khans\\Desktop\\sample.pdf");
		WebElement docType = driver.findElement(By.xpath("//app-text-input[@name='docType']//input"));
		docType.sendKeys("PDF");
		WebElement docName = driver.findElement(By.xpath("//app-text-input[@name='docName']//input"));
		docName.sendKeys("Test001");
		String monthXpath = "//span[contains(@class,'p-monthpicker-month')]";
		String year = "2026";
		String month = "01";
		String day = "30";
		String fromDay = "//span[contains(@class, 'p-element') and not(contains(@class, 'p-disabled')) and text()='"
				+ day + "']";
		String nextButton = ".pi-chevron-right";
		WebElement selectCalendar = driver.findElement(By.cssSelector(".p-datepicker-trigger"));
		selectCalendar.click();
		WebElement selectCurrentYear = driver.findElement(By.cssSelector(".p-datepicker-year "));
		selectCurrentYear.click();
		selectDate(monthXpath, year, month, fromDay, nextButton);
		WebElement reviewedByDropdown = driver.findElement(By.cssSelector(".ng-arrow-wrapper"));
		reviewedByDropdown.click();
		waitForWebElementToAppear(By.xpath("//span[contains(text(),'Rajeev')]"));
		WebElement selectReviewedBy = driver.findElement(By.xpath("//span[contains(text(),'Rajeev')]"));
		selectReviewedBy.click();
		WebElement uploadBtn = driver.findElement(By.xpath("//span[text()='Upload']"));
		uploadBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Document has been uploaded']"));
	}

	public void editInspectorDocument() throws InterruptedException {
		
		waitForWebElementToAppear(By.cssSelector(".fa-pencil-alt"));
		WebElement editIcon = driver.findElement(By.cssSelector(".fa-pencil-alt"));
		editIcon.click();
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='undefined']"));
		uploadFile.sendKeys("C:\\Users\\khans\\Desktop\\sample-Copy.pdf");

		WebElement docName = driver.findElement(By.xpath("//app-text-input[@name='docName']//input"));
		docName.sendKeys(" New");
		String monthXpath = "//span[contains(@class,'p-monthpicker-month')]";
		String year = "2026";
		String month = "02";
		String day = "20";
		String fromDay = "//span[contains(@class, 'p-element') and not(contains(@class, 'p-disabled')) and text()='"
				+ day + "']";
		String nextButton = ".pi-chevron-right";
		WebElement selectCalendar = driver.findElement(By.cssSelector(".p-datepicker-trigger"));
		selectCalendar.click();
		WebElement selectCurrentYear = driver.findElement(By.cssSelector(".p-datepicker-year "));
		selectCurrentYear.click();
		selectDate(monthXpath, year, month, fromDay, nextButton);
		WebElement saveBtn = driver.findElement(By.xpath("(//span[text()='Save'])[2]"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Document has been updated']"));
	}

	public void deleteDocument() {

		waitForWebElementToAppear(By.cssSelector(".fa-trash"));
		WebElement deleteIcon = driver.findElement(By.cssSelector(".fa-trash"));
		deleteIcon.click();
		WebElement confirmBtn = driver.findElement(By.cssSelector(".swal2-confirm"));
		confirmBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully deleted.']"));
		driver.findElement(By.xpath("//span[text()='Close']")).click();

	}
}
