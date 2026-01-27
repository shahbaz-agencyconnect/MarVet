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
		waitForWebElementToAppear(By.cssSelector(".fa-pen"));
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

		clickDesiredIcon(By.xpath("//a[.//i[contains(@class, 'fa-file-alt')]]"));
//		waitForWebElementToAppear(By.cssSelector(".fa-file-alt"));
//		WebElement docIcon = driver.findElement(By.cssSelector(".fa-file-alt"));
//		docIcon.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Upload Document']"));
		WebElement uploadDocBtn = driver.findElement(By.xpath("//span[text()='Upload Document']"));
		uploadDocBtn.click();
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='undefined']"));
		uploadFile.sendKeys("C:\\Users\\khans\\Desktop\\sample.pdf");
		waitForWebElementToAppear(By.xpath("//app-text-input[@name='docType']//input"));
		WebElement docType = driver.findElement(By.xpath("//app-text-input[@name='docType']//input"));
		docType.sendKeys("PDF");
		WebElement docName = driver.findElement(By.xpath("//app-text-input[@name='docName']//input"));
		docName.sendKeys("Test001");
		WebElement expiryDatePicker = driver.findElement(By.xpath("//bs-date-input[@name='docExpiryDate']//input"));
		expiryDatePicker.click();

		WebElement selectCurrentYear = driver.findElement(By.xpath("//button[@class='current']//span"));
		selectCurrentYear.click();

		String monthXpath = "//table[@class='months']//span";
		String year = "2026";
		String month = "01";
		String date = "31";
		String day = "//span[@class='ng-star-inserted' and text()='" + date + "']";
		String nextButton = ".next";
		datePicker(monthXpath, year, month, day, nextButton);
		
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
		WebElement expiryDatePicker = driver.findElement(By.xpath("//bs-date-input[@name='docExpiryDate']//input"));
		expiryDatePicker.click();

		WebElement selectCurrentYear = driver.findElement(By.xpath("//button[@class='current']//span"));
		selectCurrentYear.click();

		String monthXpath = "//table[@class='months']//span";
		String year = "2026";
		String month = "02";
		String date = "2";
		String day = "//span[@class='ng-star-inserted' and text()='" + date + "']";
		String nextButton = ".next";
		datePicker(monthXpath, year, month, day, nextButton);
		
		WebElement saveBtn = driver.findElement(By.xpath("(//span[text()='Save'])[2]"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Document has been updated']"));
	}

	public void downloadDoc() {
		waitForWebElementToAppear(By.cssSelector(".fa-pencil-alt"));
		waitForWebElementToAppear(By.cssSelector(".flaticon2-download"));
		WebElement downloadIcon = driver.findElement(By.cssSelector(".flaticon2-download"));
		downloadIcon.click();		
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
