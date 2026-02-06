package Marvet.Settings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Marvet.Login.Login;

public class Question extends Login{
	public void addQuestion() throws InterruptedException {
		Thread.sleep(5000);
		WebElement openQuestion = driver.findElement(By.xpath("//a[text()=' Question ']"));
		openQuestion.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement addQuestionBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()=' Add Question ']")));
		addQuestionBtn.click();
		
//		waitForWebElementToAppear(By.xpath("//button[text()=' Add Question ']"));
//		clickDesiredIcon(By.xpath("//button[text()=' Add Question ']"));
//		WebElement addQuestionBtn = driver.findElement(By.xpath("//button[text()=' Add Question ']"));
//		addQuestionBtn.click();
		waitForWebElementToAppear(By.cssSelector(".modal-content"));
		
		WebElement questionName = driver.findElement(By.xpath("//textarea[@placeholder='Question']"));
		questionName.sendKeys("Is security  check done for the vessel?");
		
		WebElement shortName = driver.findElement(By.xpath("//input[@placeholder='Short Name']"));
		shortName.sendKeys("GR3");
		
		WebElement guidanceNoteField = driver.findElement(By.xpath("//textarea[@placeholder='Note']"));
		guidanceNoteField.sendKeys("This is a test notes.");

		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully added']"));
	}

	public void editQuestion() {
		waitForWebElementToAppear(By.xpath("//input[@formcontrolname='filterText']"));
		WebElement searchBox=driver.findElement(By.xpath("//input[@formcontrolname='filterText']"));
		searchBox.sendKeys("Is security  check done for the vessel?");
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		clickDesiredIcon(By.cssSelector(".fa-pen"));
		waitForWebElementToAppear(By.xpath("//textarea[@placeholder='Question']"));
		WebElement updateQuestionName = driver.findElement(By.xpath("//textarea[@placeholder='Question']"));
		updateQuestionName.sendKeys(" Update");
		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Saved successfully.']"));
	}
	
	public void deleteQuestion() {
		clickDesiredIcon(By.cssSelector(".fa-trash-alt "));
		WebElement confirmBtn = driver.findElement(By.cssSelector(".swal2-confirm"));
		confirmBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully deleted.']"));
	}
}
