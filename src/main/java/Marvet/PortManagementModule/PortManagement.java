package Marvet.PortManagementModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.Login.Login;

public class PortManagement extends Login {

	public void addNewPort() throws InterruptedException {
		waitForWebElementToAppear(By.xpath("//span[text()='Port Management']"));
		WebElement portMgmt = driver.findElement(By.xpath("//span[text()='Port Management']"));
		portMgmt.click();
		waitForWebElementToAppear(By.xpath("//button[text()=' Add Port ']"));
		WebElement addPort = driver.findElement(By.xpath("//button[text()=' Add Port ']"));
		addPort.click();
		waitForWebElementToAppear(By.cssSelector(".modal-content"));
		WebElement portName = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		portName.sendKeys("Royal Caribbean's");
		WebElement portCode = driver.findElement(By.xpath("//input[@placeholder='Code']"));
		portCode.sendKeys("RCB");
		WebElement ratingDropdown = driver.findElement(By.xpath("//span[text()='Select Rating']"));
		ratingDropdown.click();
		WebElement selectRating = driver.findElement(By.xpath("//span[text()='APPROVED']"));
		selectRating.click();
		WebElement ratingExpirtyDatePicker = driver.findElement(By.xpath("//input[@placeholder='Select expiry date']"));
		ratingExpirtyDatePicker.click();
		WebElement selectCurrentYear = driver.findElement(By.xpath("//button[@class='current']//span"));
		selectCurrentYear.click();
		String monthXpath = "//table[@class='months']//span";
		String year = "2026";
		String month = "01";
		String date = "26";
		String day = "//span[@class='ng-star-inserted' and text()='" + date + "']";
		String nextButton = ".next";
		datePicker(monthXpath, year, month, day, nextButton);
		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully added']"));
	}

	public void editPort() {
		waitForWebElementToAppear(By.xpath("//input[contains(@placeholder,'Search port')]"));
		WebElement searchBox = driver.findElement(By.xpath("//input[contains(@placeholder,'Search port')]"));
		searchBox.sendKeys("Royal Caribbean");
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		waitForWebElementToAppear(By.cssSelector(".fa-file-alt"));
		WebElement editIcon = driver.findElement(By.xpath("//a[@title='Edit']"));
		editIcon.click();
		waitForWebElementToAppear(By.cssSelector(".modal-content"));
		WebElement portName = driver.findElement(By.xpath("//label[text()='Name ']/parent::div/input"));
		portName.sendKeys(" Update");
		WebElement codeName = driver.findElement(By.xpath("//label[text()='Code ']/parent::div/input"));
		codeName.sendKeys("103");
		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Saved successfully.']"));
	}

	public void portDocUpload() throws InterruptedException {
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		waitForWebElementToAppear(By.cssSelector(".fa-file-alt "));
		WebElement docIcon = driver.findElement(By.cssSelector(".fa-file-alt"));
		docIcon.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Upload Document']"));
		WebElement uploadDocBtn = driver.findElement(By.xpath("//span[text()='Upload Document']"));
		uploadDocBtn.click();
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='undefined']"));
		uploadFile.sendKeys("C:\\Users\\khans\\Desktop\\sample.pdf");
		WebElement docTypeDropdown = driver
				.findElement(By.xpath("//label[text()='Document Type ']/parent::div//input"));
		docTypeDropdown.click();
		WebElement selectDocType = driver.findElement(By.xpath("//span[text()='Port Information Booklet']"));
		selectDocType.click();
//		WebElement docType = driver.findElement(By.xpath("//app-text-input[@name='docType']//input"));
//		docType.sendKeys("PDF");
		WebElement docName = driver.findElement(By.xpath("//app-text-input[@name='docName']//input"));
		docName.sendKeys("Test001");
		
		WebElement selectCalendar = driver.findElement(By.xpath("//bs-date-input[@name='docExpiryDate']//input"));
		selectCalendar.click();
		WebElement selectCurrentYear = driver.findElement(By.xpath("//button[@class='current']//span"));
		selectCurrentYear.click();
		
		String monthXpath = "//table[@class='months']//span";
		String year = "2026";
		String month = "01";
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
		WebElement portRatingDropdown = driver
				.findElement(By.xpath("//label[text()='Port Rating ']/parent::div//input"));
		portRatingDropdown.click();

		waitForWebElementToAppear(By.xpath("//span[text()='CAUTION']"));
		WebElement selectPortRating = driver.findElement(By.xpath("//span[text()='CAUTION']"));
		selectPortRating.click();

		WebElement mmaComment = driver.findElement(By.xpath("//app-textarea-input[@name='mmaComments']//textarea"));
		mmaComment.sendKeys("This is a test MMA comment");
		WebElement uploadBtn = driver.findElement(By.xpath("//span[text()='Upload']"));
		uploadBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Document has been uploaded']"));
//		WebElement closeBtn = driver.findElement(By.xpath("//span[text()='Close']"));
//		closeBtn.click();
	}

	public void editPortDocument() throws InterruptedException {
		waitForWebElementToAppear(By.cssSelector(".fa-pencil-alt"));
		WebElement editIcon = driver.findElement(By.cssSelector(".fa-pencil-alt"));
		editIcon.click();
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='undefined']"));
		uploadFile.sendKeys("C:\\Users\\khans\\Desktop\\sample-Copy.pdf");
		WebElement docTypeDropdown = driver
				.findElement(By.xpath("//label[text()='Document Type ']/parent::div//input"));
		docTypeDropdown.click();
		WebElement selectDocCategory = driver.findElement(By.xpath("//span[text()='Port Inspection Report']"));
		selectDocCategory.click();
//		WebElement docType = driver.findElement(By.xpath("//app-text-input[@name='docType']//input"));
//		docType.sendKeys("PDF");
//		WebElement docName = driver.findElement(By.xpath("//app-text-input[@name='docName']//input"));
//		docName.sendKeys("Test001");
		String monthXpath = "//span[contains(@class,'p-monthpicker-month')]";
		String year = "2026";
		String month = "02";
		String day = "25";
		String fromDay = "//span[contains(@class, 'p-element') and not(contains(@class, 'p-disabled')) and text()='"
				+ day + "']";
		String nextButton = ".pi-chevron-right";
		WebElement selectCalendar = driver.findElement(By.cssSelector(".p-datepicker-trigger"));
		selectCalendar.click();
		WebElement selectCurrentYear = driver.findElement(By.cssSelector(".p-datepicker-year "));
		selectCurrentYear.click();
		selectDate(monthXpath, year, month, fromDay, nextButton);
//		WebElement reviewedByDropdown = driver
//				.findElement(By.xpath("//label[text()='Document Reviewed By ']/parent::div//input"));
//		reviewedByDropdown.click();
//		waitForWebElementToAppear(By.xpath("//span[contains(text(),'Rajeev')]"));
//		WebElement selectReviewedBy = driver.findElement(By.xpath("//span[contains(text(),'Rajeev')]"));
//		selectReviewedBy.click();
//		WebElement statusDropdown = driver
//				.findElement(By.xpath("//label[text()='Status ']/parent::div//input"));
//		statusDropdown.click();
//		
//		waitForWebElementToAppear(By.xpath("//span[text()='Eligible']"));
//		WebElement selectStatus= driver.findElement(By.xpath("//span[text()='Caution']"));
//		selectStatus.click();

		WebElement mmaComment = driver.findElement(By.xpath("//app-textarea-input[@name='mmaComments']//textarea"));
		mmaComment.sendKeys(" Updated");
		WebElement saveBtn = driver.findElement(By.xpath("(//span[text()='Save'])[2]"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Document has been updated']"));
//		WebElement closeBtn = driver.findElement(By.xpath("//span[text()='Close']"));
//		closeBtn.click();
	}

	public void downloadDoc() {
		waitForWebElementToAppear(By.cssSelector(".fa-pencil-alt"));
		waitForWebElementToAppear(By.cssSelector(".flaticon2-download"));
		WebElement downloadIcon = driver.findElement(By.cssSelector(".flaticon2-download"));
		downloadIcon.click();
//		WebElement closeBtn = driver.findElement(By.xpath("//span[text()='Close']"));
//		closeBtn.click();
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

	public void deletePort() {
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		waitForWebElementToAppear(By.cssSelector(".fa-pen"));
		WebElement deleteIcon = driver.findElement(By.cssSelector(".fa-trash-alt "));
		deleteIcon.click();
		WebElement confirmBtn = driver.findElement(By.cssSelector(".swal2-confirm"));
		confirmBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully deleted.']"));
	}
}
