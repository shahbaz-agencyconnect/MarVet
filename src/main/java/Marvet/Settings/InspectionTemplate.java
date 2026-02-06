package Marvet.Settings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Marvet.Login.Login;

public class InspectionTemplate extends Login {
	public void addInspectionTemplate() throws InterruptedException {
		Thread.sleep(5000);
		WebElement openInspectionType = driver.findElement(By.xpath("//a[text()=' Inspection Template ']"));
		openInspectionType.click();

		waitForWebElementToAppear(By.xpath("//button[text()=' Add Inspection Template ']"));
		WebElement addInspectionTypeBtn = driver.findElement(By.xpath("//button[text()=' Add Inspection Template ']"));
		addInspectionTypeBtn.click();
		waitForWebElementToAppear(By.cssSelector(".modal-content"));

		WebElement inspectionTypeDropdown = driver
				.findElement(By.xpath("//label[text()='Inspection Type ']/parent::div//input"));
		inspectionTypeDropdown.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-dropdown-panel")));
		WebElement selectInspectionType = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='OVID']")));
		selectInspectionType.click();

		WebElement sectionDropdown = driver.findElement(By.xpath("//label[text()='Section ']/parent::div//input"));
		sectionDropdown.click();

		WebElement selectsection = driver.findElement(By.xpath("//span[contains(text(),'Supply Operations')]"));
		selectsection.click();

		WebElement quesNum = driver.findElement(By.xpath("//input[@placeholder='Question No']"));
		quesNum.sendKeys("04");

		WebElement sectionOrder = driver.findElement(By.xpath("//input[@placeholder='Section Order']"));
		sectionOrder.sendKeys("01");

		WebElement questionDropdown = driver.findElement(By.xpath("//label[text()='Question ']/parent::div//input"));
		questionDropdown.click();

		// Select Question
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-dropdown-panel")));
		WebElement selectQuestion = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[contains(text(),'Date of last OVID inspection')]")));
		selectQuestion.click();

		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully added']"));
	}
	
	public void editInspectionTemplate() {
		waitForWebElementToAppear(By.xpath("//app-text-input[@name='filterText']//input"));
		WebElement searchBox=driver.findElement(By.xpath("//app-text-input[@name='filterText']//input"));
		searchBox.sendKeys("Supply Operations");
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		clickDesiredIcon(By.cssSelector(".fa-pen"));
		waitForWebElementToAppear(By.cssSelector(".modal-content"));

		WebElement inspectionTypeDropdown = driver
				.findElement(By.xpath("//label[text()='Inspection Type ']/parent::div//input"));
		inspectionTypeDropdown.click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-dropdown-panel")));
		WebElement selectInspectionType = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='BSP Vessel Pre-Hire Inspection ']")));
		selectInspectionType.click();

		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Saved successfully.']"));
	}
	
	public void deleteInspectionTemplate() {
		clickDesiredIcon(By.cssSelector(".fa-trash-alt "));
		WebElement confirmBtn = driver.findElement(By.cssSelector(".swal2-confirm"));
		confirmBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully deleted.']"));
	}
}
