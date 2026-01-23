package Matvet.VTOManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import Marvet.Login.Login;

public class VTOManagement extends Login {

	public void addVTO() throws InterruptedException {
		waitForWebElementToAppear(By.xpath("//span[text()='VTO Management']"));
		WebElement vtoMgmt = driver.findElement(By.xpath("//span[text()='VTO Management']"));
		vtoMgmt.click();
		waitForWebElementToAppear(By.xpath("//button[text()=' Add VTO ']"));
		WebElement addVTO = driver.findElement(By.xpath("//button[text()=' Add VTO ']"));
		addVTO.click();
		waitForWebElementToAppear(By.cssSelector(".modal-content"));
		WebElement vtoName = driver.findElement(By.xpath("//input[@placeholder='VTO Name']"));
		vtoName.sendKeys("Mobile Shipping");

		WebElement vtoEmail = driver.findElement(By.xpath("//input[@placeholder='VTO Email']"));
		vtoEmail.sendKeys("mobile.shipping21@testmail.com");

		WebElement clientGrpDropdown = driver
				.findElement(By.xpath("//label[text()='Client Group ']/parent::div//input"));
		clientGrpDropdown.click();

		WebElement selectClientGrp = driver.findElement(By.xpath("//span[text()='VTO']"));
		selectClientGrp.click();
		WebElement chooseFileBtn = driver.findElement(By.xpath("//input[@type='file']"));
		chooseFileBtn.sendKeys("C:\\Users\\khans\\Desktop\\sample.jpg");

		WebElement docCheckbox = driver.findElement(By.cssSelector(".form-check-input"));
		docCheckbox.click();		

		WebElement element = driver.findElement(By.id("undefined"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

		WebElement expiryDatePicker = driver.findElement(By.xpath("//input[@formcontrolname='vtoRatingExpiryDate']"));
		expiryDatePicker.click();

		WebElement selectCurrentYear = driver.findElement(By.xpath("//button[@class='current']//span"));
		selectCurrentYear.click();

		String monthXpath = "//table[@class='months']//span";
		String year = "2026";
		String month = "01";
		String date = "26";
		String day = "//span[@class='ng-star-inserted' and text()='" + date + "']";
		String nextButton = ".next";
		datePicker(monthXpath, year, month, day, nextButton);

		WebElement documentTypeDropdown = driver
				.findElement(By.xpath("//label[text()='Document Type ']/parent::div//input"));
		documentTypeDropdown.click();

		WebElement selectDocumentType = driver.findElement(By.xpath("//span[text()='BSP OVMSA Audit Report']"));
		selectDocumentType.click();
		
		WebElement vtoRatingDropdown = driver
				.findElement(By.xpath("//label[text()='VTO Rating ']/parent::div//input"));
		vtoRatingDropdown.click();

		WebElement selectVTORating= driver.findElement(By.xpath("//span[text()='CAUTION']"));
		selectVTORating.click();
		
		WebElement uploadFile = driver.findElement(By.xpath("//input[@id='undefined']"));
		uploadFile.sendKeys("C:\\Users\\khans\\Desktop\\sample.pdf");
		
		WebElement mmaComment = driver.findElement(By.xpath("//textarea[@placeholder='Enter MAA comments']"));
		mmaComment.sendKeys("This is a test MMA comment");
		
		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully added']"));
	}
	
	public void editVTO() {
		waitForWebElementToAppear(By.xpath("//input[contains(@placeholder,'Search client')]"));
		WebElement searchBox = driver.findElement(By.xpath("//input[contains(@placeholder,'Search client')]"));
		searchBox.sendKeys("Mobile Shipping");
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		waitForWebElementToAppear(By.cssSelector(".fa-trash-alt"));
		WebElement editIcon = driver.findElement(By.cssSelector(".fa-pen"));
		editIcon.click();
		
		waitForWebElementToAppear(By.cssSelector(".modal-content"));
		WebElement vtoName = driver.findElement(By.xpath("//input[@placeholder='VTO Name']"));
		vtoName.sendKeys(" Update");
		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Saved successfully.']"));
	}
	
	public void deleteVTO() {
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		waitForWebElementToAppear(By.cssSelector(".fa-pen"));
		WebElement deleteIcon = driver.findElement(By.cssSelector(".fa-trash-alt"));
		deleteIcon.click();
		WebElement confirmBtn = driver.findElement(By.cssSelector(".swal2-confirm"));
		confirmBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully deleted.']"));
	}
	
	
}
