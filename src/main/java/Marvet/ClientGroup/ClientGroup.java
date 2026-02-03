package Marvet.ClientGroup;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Marvet.Login.Login;

public class ClientGroup extends Login{
	public void addClientGroup() {
		waitForWebElementToAppear(By.xpath("//span[text()='Client Group']"));
		WebElement clientMgmt = driver.findElement(By.xpath("//span[text()='Client Group']"));
		clientMgmt.click();
		waitForWebElementToAppear(By.xpath("//button[text()=' Add Client Group ']"));
		WebElement addClient= driver.findElement(By.xpath("//button[text()=' Add Client Group ']"));
		addClient.click();
		waitForWebElementToAppear(By.cssSelector(".modal-content"));
		waitForWebElementToAppear(By.xpath("//input[@placeholder='Name']"));
		WebElement clientGrp = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		clientGrp.sendKeys("Test Client Group");
		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully added']"));
	}
	

	public void editClientGroup() throws FileNotFoundException {

		waitForWebElementToAppear(By.xpath("//input[contains(@placeholder,'group')]"));
		WebElement searchBox = driver.findElement(By.xpath("//input[contains(@placeholder,'group')]"));
		searchBox.sendKeys("Test Client Group");
		
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		clickDesiredIcon(By.xpath("//a[.//i[contains(@class, 'fa-pen')]]"));

		waitForWebElementToAppear(By.cssSelector(".modal-content"));
		WebElement clientGroupName = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		clientGroupName.sendKeys(" Update");
		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Saved successfully.']"));
	}	
	
	public void deleteClientGroup() {
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		clickDesiredIcon(By.xpath("//a[.//i[contains(@class, 'fa-trash-alt')]]"));
		WebElement confirmBtn = driver.findElement(By.cssSelector(".swal2-confirm"));
		confirmBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully deleted.']"));
	}
}
