package Marvet.InspectorManagementModule;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.Login.Login;

public class InspectorManagement extends Login {
	public void updateInspectorReviewer() throws FileNotFoundException {
		waitForWebElementToAppear(By.xpath("//span[text()='Inspector Management']"));
		WebElement inspectorMgmt = driver.findElement(By.xpath("//span[text()='Inspector Management']"));
		inspectorMgmt.click();
		ArrayList<String> data = excelRead("Add User");
		String searchUser = data.get(2);
		waitForWebElementToAppear(By.xpath("//input[@placeholder='Search inspector']"));
		WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search inspector']"));
		searchBox.sendKeys(searchUser);
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		clickDesiredIcon(By.cssSelector(".fa-pen"));
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
		waitForWebElementToAppear(By.xpath("//span[text()='Upload Document']"));
		WebElement uploadDocBtn = driver.findElement(By.xpath("//span[text()='Upload Document']"));
		uploadDocBtn.click();
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='undefined']"));
		uploadFile.sendKeys(System.getProperty("user.dir")+"\\Sample File\\sample.pdf");
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
		String month = "03";
		String date = "31";
		String day = "//span[@class='ng-star-inserted' and text()='" + date + "']";
		String nextButton = ".next";
		datePicker(monthXpath, year, month, day, nextButton);

		WebElement reviewedByDropdown = driver.findElement(By.cssSelector(".ng-arrow-wrapper"));
		reviewedByDropdown.click();
		waitForWebElementToAppear(By.xpath("//span[contains(text(),'Harry')]"));
		WebElement selectReviewedBy = driver.findElement(By.xpath("//span[contains(text(),'Harry')]"));
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
		uploadFile.sendKeys(System.getProperty("user.dir")+"\\Sample File\\sample-Copy.pdf");

		
//		uploadFile.sendKeys("C:\\Users\\khans\\Desktop\\sample-Copy.pdf");

		WebElement docName = driver.findElement(By.xpath("//app-text-input[@name='docName']//input"));
		docName.sendKeys(" New");
		WebElement expiryDatePicker = driver.findElement(By.xpath("//bs-date-input[@name='docExpiryDate']//input"));
		expiryDatePicker.click();

		WebElement selectCurrentYear = driver.findElement(By.xpath("//button[@class='current']//span"));
		selectCurrentYear.click();

		String monthXpath = "//table[@class='months']//span";
		String year = "2026";
		String month = "04";
		String date = "25";
		String day = "//span[@class='ng-star-inserted' and text()='" + date + "']";
		String nextButton = ".next";
		datePicker(monthXpath, year, month, day, nextButton);

		WebElement saveBtn = driver.findElement(By.xpath("(//span[text()='Save'])[2]"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Document has been updated']"));
	}

	public void downloadDoc() {
		clickDesiredIcon(By.cssSelector(".flaticon2-download"));
	}

	public void deleteDocument() {
		clickDesiredIcon(By.cssSelector(".fa-trash"));
		WebElement confirmBtn = driver.findElement(By.cssSelector(".swal2-confirm"));
		confirmBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully deleted.']"));
		driver.findElement(By.xpath("//span[text()='Close']")).click();

	}
}
