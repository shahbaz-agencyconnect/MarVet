package Marvet.TerminalChartererModule;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Marvet.Login.Login;

public class TerminalCharter extends Login {
	public void addNewTerminal() {
		waitForWebElementToAppear(By.xpath("//span[text()='Terminal or Charterer']"));
		WebElement terminalMgmt = driver.findElement(By.xpath("//span[text()='Terminal or Charterer']"));
		terminalMgmt.click();

		waitForWebElementToAppear(By.xpath("//button[text()=' Add Terminal or Charterer ']"));
		WebElement addTerminal = driver.findElement(By.xpath("//button[text()=' Add Terminal or Charterer ']"));
		addTerminal.click();

		waitForWebElementToAppear(By.cssSelector(".modal-content"));

		WebElement terminalName = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		terminalName.sendKeys("Terminal 2");

		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully added']"));
	}

	public void editTerminal() {
		waitForWebElementToAppear(By.xpath("//input[contains(@placeholder,'terminal')]"));
		WebElement searchBox = driver.findElement(By.xpath("//input[contains(@placeholder,'terminal')]"));
		searchBox.sendKeys("Terminal 2");
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		waitForWebElementToAppear(By.cssSelector(".fa-trash-alt "));
		WebElement editIcon = driver.findElement(By.cssSelector(".fa-pen"));
		editIcon.click();
		waitForWebElementToAppear(By.cssSelector(".modal-content"));
		WebElement terminalName = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		terminalName.sendKeys(" Update");

		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Saved successfully.']"));
	}

	public void deleteTerminal() {
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		waitForWebElementToAppear(By.cssSelector(".fa-pen"));
		WebElement deleteIcon = driver.findElement(By.cssSelector(".fa-trash-alt "));
		deleteIcon.click();
		WebElement confirmBtn = driver.findElement(By.cssSelector(".swal2-confirm"));
		confirmBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully deleted.']"));
	}
}
