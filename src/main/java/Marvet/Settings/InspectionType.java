package Marvet.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Marvet.Login.Login;

public class InspectionType extends Login{
	
	public void addInspectionType() throws InterruptedException {		
		Thread.sleep(5000);
		WebElement openInspectionType= driver.findElement(By.xpath("//a[text()=' Inspection Type ']"));
		openInspectionType.click();
		
		waitForWebElementToAppear(By.xpath("//button[text()=' Add Inspection Type ']"));
		WebElement addInspectionTypeBtn = driver.findElement(By.xpath("//button[text()=' Add Inspection Type ']"));
		addInspectionTypeBtn.click();
		waitForWebElementToAppear(By.cssSelector(".modal-content"));
		waitForWebElementToAppear(By.xpath("//input[@placeholder='Name']"));
		Thread.sleep(1000);
		WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		name.sendKeys("Test Inspection Type");
		
		WebElement titleBar = driver.findElement(By.xpath("//input[@placeholder='Title Bar']"));
		titleBar.sendKeys("Test123");
		
		WebElement summary = driver.findElement(By.xpath("//input[@placeholder='Summary']"));
		summary.sendKeys("Test Summary");
		
		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully added']"));		
	}
	
	public void editInspectionType() {
		waitForWebElementToAppear(By.xpath("//input[@formcontrolname='filterText']"));
		WebElement searchBox=driver.findElement(By.xpath("//input[@formcontrolname='filterText']"));
		searchBox.sendKeys("Test Inspection Type");
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		clickDesiredIcon(By.cssSelector(".fa-pen"));
		waitForWebElementToAppear(By.xpath("//input[@placeholder='Name']"));
		WebElement updateQuestionName = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		updateQuestionName.sendKeys(" Update");
		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Saved successfully.']"));
	}
	
	public void deleteInspectionType() {
		clickDesiredIcon(By.cssSelector(".fa-trash-alt "));
		WebElement confirmBtn = driver.findElement(By.cssSelector(".swal2-confirm"));
		confirmBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully deleted.']"));
	}
}
