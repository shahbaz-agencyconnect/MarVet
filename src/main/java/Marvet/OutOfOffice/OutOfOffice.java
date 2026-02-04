package Marvet.OutOfOffice;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Marvet.Login.Login;

public class OutOfOffice extends Login {
	public void enableOutOfOffice() throws FileNotFoundException, InterruptedException {

		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		clickDesiredIcon(By.cssSelector(".fa-pen"));
		waitForWebElementToAppear(By.cssSelector(".modal-content"));
		WebElement outOfOfficeCheckbox = driver
				.findElement(By.xpath("//app-checkbox-input[@name='outOfOfficeEnabled']//span"));
		outOfOfficeCheckbox.click();
		WebElement substituteUserDropdown = driver
				.findElement(By.xpath("//label[text()='Substitute User ']/parent::div//input"));
		substituteUserDropdown.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ng-dropdown-panel")));
		WebElement option = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Ardella  (ardella4@yopmail.com)']")));
		option.click();

		// Delegation Start Date
		WebElement delegationStartDate = driver.findElement(By.id("DelegationStartDate"));
		delegationStartDate.click();
		String monthFromXpath = "//table[@class='months']//span";
		String fromYear = "2026";
		String fromMonth = "02";
		String day = "10";
		String fromDay = "//span[@class='ng-star-inserted' and text()='" + day + "']";
		String nextButton = ".next";
		WebElement selectCurrentYear = driver.findElement(By.xpath("//button[@class='current']//span"));
		selectCurrentYear.click();
		datePicker(monthFromXpath, fromYear, fromMonth, fromDay, nextButton);

		// Delegation End Date

		WebElement delegationEndDate = driver.findElement(By.id("DelegationEndDate"));
		delegationEndDate.click();
		String toYear = "2026";
		String toMonth = "02";
		String endDay = "10";
		String toDay = "//span[@class='ng-star-inserted' and text()='" + endDay + "']";
		WebElement selectEndDateCurrentYear = driver.findElement(By.xpath("//button[@class='current']//span"));
		selectEndDateCurrentYear.click();
		datePicker(monthFromXpath, toYear, toMonth, toDay, nextButton);
		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Saved successfully.']"));
	}
}
