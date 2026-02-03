package Marvet.RequestService;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.Login.Login;

public class RequestService extends Login {

	public void vesselService() throws InterruptedException, FileNotFoundException {
		waitForWebElementToAppear(By.xpath("//span[text()='Request a Service']"));
		WebElement serviceRequestBtn = driver.findElement(By.xpath("//span[text()='Request a Service']"));
		serviceRequestBtn.click();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		waitForWebElementToAppear(By.xpath("//span[text()=' Clearance ']"));
		WebElement clearanceCheckbox = driver.findElement(By.xpath("//span[text()=' Clearance ']"));
		clearanceCheckbox.click();

		WebElement inspectionAuditCheckbox = driver.findElement(By.xpath("//span[text()=' Inspection/Audit ']"));
		inspectionAuditCheckbox.click();
		
		ArrayList<String> vesselEntries = excelRead("Request Service");
		String endUsername= vesselEntries.get(0);
		String endUseremail= vesselEntries.get(1);
		String workscope= vesselEntries.get(2);
		String vesselName = vesselEntries.get(3);
		String imoNum = vesselEntries.get(4);
		String vtoname = vesselEntries.get(5);
		String requestorEmailId = vesselEntries.get(12);
		
		WebElement clearanceRequestDate= driver.findElement(By.xpath("//bs-date-input[@name='clearanceStartDate']//input"));
		clearanceRequestDate.click();
		WebElement selectCurrentYear = driver.findElement(By.xpath("//button[@class='current']//span"));
		selectCurrentYear.click();
		
		String fromMonthXpath = "//table[@class='months']//span";
		String fromYear = "2026";
		String fromMonth = "02";
		String date = "2";
		String fromDay = "//span[@class='ng-star-inserted' and text()='" + date + "']";
		String nextButton = ".next";
		datePicker(fromMonthXpath, fromYear, fromMonth, fromDay, nextButton);
		
		WebElement clearanceEndDate= driver.findElement(By.xpath("//bs-date-input[@name='clearanceEndDate']//input"));
		clearanceEndDate.click();
		WebElement selectEndDateCurrentYear = driver.findElement(By.xpath("//button[@class='current']//span"));
		selectEndDateCurrentYear.click();
		
		String toMonthXpath = "//table[@class='months']//span";
		String toYear = "2026";
		String toMonth = "02";
		String toDate = "15";
		String today = "//span[@class='ng-star-inserted' and text()='" + toDate + "']";
		datePicker(toMonthXpath, toYear, toMonth, today, nextButton);		

		WebElement endUserName = driver.findElement(By.xpath("//app-text-input[@name='clientCompany']//input"));
		endUserName.sendKeys(endUsername);

		WebElement endUserEmail = driver.findElement(By.xpath("//app-email-input[@name='clientEmail']//input"));
		endUserEmail.sendKeys(endUseremail);

		WebElement workScope = driver.findElement(By.xpath("//app-textarea-input[@name='scopeOfWork']//textarea"));
		workScope.sendKeys(workscope);

		WebElement requestorEmail = driver.findElement(By.xpath("//app-email-input[@name='submittedByEmail']//input"));
		requestorEmail.sendKeys(requestorEmailId);

		WebElement vesselNameDropdown = driver
				.findElement(By.xpath("//app-dropdown-input[@name='vesselId']//span[text()='-- Select Vessel --']"));
		vesselNameDropdown.click();
		
		WebElement selectVessel = driver.findElement(By.xpath("// span[text()='"+vesselName+"']"));
		selectVessel.click();
		
		//Vessel Activities Selection
		waitForWebElementToAppear(By.xpath("//label[text()=' Accommodation/Floatel ']"));
		WebElement accomodation = driver.findElement(By.xpath("//label[text()=' Accommodation/Floatel ']"));
		accomodation.click();
		
		WebElement drilling = driver.findElement(By.xpath("//label[text()=' Drilling ']"));
		drilling.click();
		
		WebElement hospitality = driver.findElement(By.xpath("//label[text()=' Hospitality ']"));
		hospitality.click();
		
		WebElement working = driver.findElement(By.xpath("//label[text()=' Working in 500m Safety Zone ']"));
		working.click();
		
		//Operating Ports Selection

		WebElement operatingPort = driver.findElement(By.xpath("//label[text()=' KB Gov. Wharf ']"));
		operatingPort.click();
		
		WebElement viddacom = driver.findElement(By.xpath("//label[text()=' Viddacom ']"));
		viddacom.click();
		
		WebElement submitBtn= driver.findElement(By.xpath("//button[text()=' Submit Request ']"));
		submitBtn.click();
		
		waitForWebElementToAppear(By.cssSelector(".swal2-confirm"));
		WebElement okBtn= driver.findElement(By.cssSelector(".swal2-confirm"));
		okBtn.click();
		driver.switchTo().window(parentId);
	}
}
