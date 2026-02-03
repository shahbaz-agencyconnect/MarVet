package Marvet.Settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Marvet.Login.Login;

public class Section extends Login {
	public void addSection() {

		waitForWebElementToAppear(By.cssSelector(".fa-chevron-down"));
		WebElement settingsMenu = driver.findElement(By.cssSelector(".fa-chevron-down"));
		settingsMenu.click();

		WebElement openSection = driver.findElement(By.xpath("//a[text()=' Section ']"));
		openSection.click();
		waitForWebElementToAppear(By.xpath("//button[text()=' Add Section ']"));
		WebElement addSectionBtn = driver.findElement(By.xpath("//button[text()=' Add Section ']"));
		addSectionBtn.click();

		waitForWebElementToAppear(By.cssSelector(".modal-content"));
		WebElement sectionName = driver.findElement(By.xpath("//input[@placeholder='Section Name']"));
		sectionName.sendKeys("Navigation Bridge");

		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully added']"));

	}
	
	public void editSection() {
		waitForWebElementToAppear(By.xpath("//input[@formcontrolname='filterText']"));
		WebElement searchBox=driver.findElement(By.xpath("//input[@formcontrolname='filterText']"));
		searchBox.sendKeys("Navigation Bridge");
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		clickDesiredIcon(By.cssSelector(".fa-pen"));
		waitForWebElementToAppear(By.xpath("//input[@placeholder='Section Name']"));
		WebElement updateSectionName = driver.findElement(By.xpath("//input[@placeholder='Section Name']"));
		updateSectionName.sendKeys(" Update");
		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Saved successfully.']"));
	}
	
	public void deleteSection() {
		clickDesiredIcon(By.cssSelector(".fa-trash-alt "));
		WebElement confirmBtn = driver.findElement(By.cssSelector(".swal2-confirm"));
		confirmBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully deleted.']"));
	}
}
