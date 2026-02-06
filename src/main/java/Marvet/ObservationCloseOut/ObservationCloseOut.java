package Marvet.ObservationCloseOut;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Marvet.Login.Login;

public class ObservationCloseOut extends Login {
	public void observationCloseOut() {
//		waitForWebElementToAppear(By.xpath("//span[text()='Inspection Management']"));
//		WebElement inspectionMgmt = driver.findElement(By.xpath("//span[text()='Inspection Management']"));
//		inspectionMgmt.click();
//
//		waitForWebElementToAppear(By.xpath("//input[@placeholder='Search inspection']"));
//		WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search inspection']"));
//		searchBox.sendKeys("0003734");
//		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'0003734')]")));
		clickDesiredIcon(By.xpath("//a[contains(text(),'0003734')]"));
//		selectVessel.click();
//
//		WebElement selectVessel = driver.findElement(By.xpath("//span[contains(text(),'0003734')]"));
//		selectVessel.click();
		waitForWebElementToAppear(By.xpath("(//label[text()='Yes'])[1]"));
		WebElement observationques1 = driver.findElement(By.xpath("(//label[text()='Yes'])[1]"));
		observationques1.click();
		
		WebElement comment=driver.findElement(By.id("comment-509"));
		comment.sendKeys("Test");
		
		WebElement observationques2 = driver.findElement(By.xpath("(//label[text()='Yes'])[2]"));
		observationques2.click();

		WebElement observationques3 = driver.findElement(By.xpath("(//label[text()='Yes'])[3]"));
		observationques3.click();

		WebElement completeBtn = driver.findElement(By.xpath("//span[text()='Complete']"));
		completeBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Inspection Completed']"));

	}
}
