package Marvet.InspectionManagement;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Marvet.AbstractComponent.AbstractComponent;
import Marvet.Login.Login;

public class InspectionManagement extends Login {
	public void createInspection() throws InterruptedException, FileNotFoundException {
		waitForWebElementToAppear(By.xpath("//span[text()='Inspection Management']"));
		WebElement inspectionMgmt = driver.findElement(By.xpath("//span[text()='Inspection Management']"));
		inspectionMgmt.click();
		ArrayList<String> data = excelRead("Add Inspection");
		waitForWebElementToAppear(By.xpath("//span[text()='Create Inspection']"));
		WebElement createInspection = driver.findElement(By.xpath("//span[text()='Create Inspection']"));
		createInspection.click();
		waitForWebElementToAppear(By.cssSelector(".modal-content"));

		String inspection = data.get(0);
		String client = data.get(1);
		String doc = data.get(2);
		String vessel = data.get(3);
		String port = data.get(4);
		String inspector = data.get(5);
		String monthFromXpath = "//table[@class='months']//span";
		String year = data.get(6);
		String month = data.get(7);
		String day = data.get(8);
		String fromDay = "//span[@class='ng-star-inserted' and text()='" + day + "']";
		String nextButton = ".next";

		// Select Inspection
		WebElement inspectionDropdown = driver
				.findElement(By.xpath("//label[text()='Inspection ']/parent::div//input"));
		inspectionDropdown.click();
		waitForWebElementToDisappear(By.xpath("//span[text()='Loading...']"));
		selectNgOption(inspection);

		// Select Client
		WebElement clientDropdown = driver.findElement(By.xpath("//label[text()='Client ']/parent::div//input"));
		clientDropdown.click();
		waitForWebElementToDisappear(By.xpath("//span[text()='Loading...']"));
		selectNgOption(client);

		// Select DOC
		WebElement docDropdown = driver.findElement(By.xpath("//label[text()='DOC ']/parent::div//input"));
		docDropdown.click();
		waitForWebElementToDisappear(By.xpath("//span[text()='Loading...']"));
		selectNgOption(doc);

		// Select Vessel

		WebElement vesselDropdown = driver.findElement(By.xpath("//label[text()='Vessel ']/parent::div//input"));
		vesselDropdown.click();
		waitForWebElementToDisappear(By.xpath("//span[text()='Loading...']"));
		selectNgOption(vessel);

		// Select Port
		WebElement portDropdown = driver.findElement(By.xpath("//label[text()='Port ']/parent::div//input"));
		portDropdown.click();
		waitForWebElementToDisappear(By.xpath("//span[text()='Loading...']"));
		selectNgOption(port);

		WebElement datePicker = driver.findElement(By.id("date"));
		datePicker.click();
		WebElement selectYear = driver.findElement(By.xpath("//button[@class='current']//span"));
		selectYear.click();
		datePicker(monthFromXpath, year, month, fromDay, nextButton);
		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();

		waitForWebElementToAppear(By.xpath("//span[text()='Saved successfully.']"));
	}

	public void editInspection() throws FileNotFoundException, InterruptedException {

		ArrayList<String> data = excelRead("Add Inspection");
		String vesselName = data.get(3);
		waitForWebElementToAppear(By.xpath("//input[contains(@placeholder,'inspection')]"));
		WebElement searchBox = driver.findElement(By.xpath("//input[contains(@placeholder,'inspection')]"));
		searchBox.sendKeys(vesselName);
		Thread.sleep(2000);
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement editButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//span[contains(text(), '" + vesselName + "')]/ancestor::tr//button[i[contains(@class, 'fa-pen')]]")));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", editButton);

		js.executeScript("arguments[0].click();", editButton);

		waitForWebElementToAppear(By.cssSelector(".modal-content"));

		waitForWebElementToAppear(By.xpath("//label[text()='Inspection ']/parent::div//input"));
		WebElement inspectionDropdown = driver
				.findElement(By.xpath("//label[text()='Inspection ']/parent::div//input"));
		inspectionDropdown.click();
		waitForWebElementToDisappear(By.xpath("//span[text()='Loading...']"));
		selectNgOption("BSP Vessel Pre-Hire Inspection");

		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Saved successfully.']"));
	}

	public void deleteInspection() throws FileNotFoundException {
		ArrayList<String> data = excelRead("Add Inspection");
		String vesselName = data.get(3);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement deleteButton = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(text(), '" + vesselName
						+ "')]/ancestor::tr//button[i[contains(@class, 'fa-trash-alt')]]")));

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", deleteButton);

		js.executeScript("arguments[0].click();", deleteButton);

		WebElement confirmBtn = driver.findElement(By.cssSelector(".swal2-confirm"));
		confirmBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully deleted.']"));
	}

	public void selectNgOption(String optionText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-dropdown-panel")));
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//span[contains(@class, 'ng-option-label')][normalize-space()='" + optionText + "']")));
		option.click();
	}
}
