package Marvet.ClearanceManagementModule;

import java.time.Duration;

import org.apache.commons.math3.ode.events.EventHandler.Action;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Marvet.Login.Login;

public class ClearanceManagement extends Login {

	public void startVet() throws InterruptedException {
		waitForWebElementToAppear(By.xpath("//span[text()='Clearance Management']"));
		WebElement clearanceMgmt = driver.findElement(By.xpath("//span[text()='Clearance Management']"));
		clearanceMgmt.click();
		Thread.sleep(2000);

		WebElement searchBox = driver.findElement(By.xpath("//input[@formcontrolname='filterText']"));
		searchBox.sendKeys("9713129");

		WebElement searchIcon = driver.findElement(By.xpath("//button[@type='submit']"));
		searchIcon.click();
		Thread.sleep(2000);

		WebElement actionBtn = driver.findElement(By.id("dropdownButton"));
		actionBtn.click();

		WebElement startVetOption = driver.findElement(By.xpath("//a[text()=' Start Vet ']"));
		startVetOption.click();
		waitForWebElementToAppear(By.id("kt_wrapper"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("ngx-spinner-overlay")));		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Summary']")));

		WebElement summaryTab = driver.findElement(By.xpath("//span[text()='Summary']"));
		summaryTab.click();

		Actions actions =  new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath("//button[text()=' ELIGIBLE ']"))).build().perform();

		WebElement acceptBtn =driver.findElement(By.xpath("//button[text()=' ELIGIBLE ']"));		
		acceptBtn.click();

		WebElement confirmBtn = driver.findElement(By.cssSelector(".swal2-confirm"));
//		confirmBtn.click();
	}
}
