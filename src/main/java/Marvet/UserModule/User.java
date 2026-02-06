package Marvet.UserModule;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Marvet.Login.Login;

public class User extends Login {

	public void addNewUser() throws FileNotFoundException {
		waitForWebElementToAppear(By.xpath("//span[text()='User']"));
		WebElement userMenu = driver.findElement(By.xpath("//span[text()='User']"));
		userMenu.click();
		ArrayList<String> data = excelRead("Add User");
		waitForWebElementToAppear(By.xpath("//button[text()=' Add User ']"));
		WebElement addUserBtn = driver.findElement(By.xpath("//button[text()=' Add User ']"));
		addUserBtn.click();
		waitForWebElementToAppear(By.cssSelector(".modal-content"));
		waitForWebElementToAppear(By.xpath("//input[@placeholder='First Name']"));
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
		WebElement userEmail = driver.findElement(By.xpath("//input[@placeholder='Email Address']"));
		firstName.sendKeys(data.get(0));
		lastName.sendKeys(data.get(1));
		userEmail.sendKeys(data.get(2));
		WebElement client = driver.findElement(By.xpath("//div[text()='Search for client...']/parent::div//input"));
		client.click();
		waitForWebElementToAppear(By.xpath("//div[contains(@id,'remote-select')]//span[text()='" + data.get(3) + "']"));
		WebElement selectClient = driver
				.findElement(By.xpath("//div[contains(@id,'remote-select')]//span[text()='" + data.get(3) + "']"));
		selectClient.click();
		WebElement terminalCharterer = driver
				.findElement(By.xpath("//div[text()='Search for terminal or charterer...']/parent::div//input"));
		terminalCharterer.click();
		waitForWebElementToAppear(
				By.xpath("//span[contains(@class,'ng-option-label') and text()='" + data.get(4) + "']"));
		WebElement selectTerminal = driver
				.findElement(By.xpath("//span[contains(@class,'ng-option-label') and text()='" + data.get(4) + "']"));
		selectTerminal.click();
		//Uncheck Password Reset
//		WebElement uncheckPwdReset = driver.findElement(By.xpath("//span[text()=' Password reset is required ']"));
//		uncheckPwdReset.click();

		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Saved successfully.']"));
	}

	public void editUser() throws FileNotFoundException {
		ArrayList<String> data = excelRead("Add User");
		WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search user']"));
		searchBox.sendKeys(data.get(2));
//		waitForWebElementToAppear(By.cssSelector(".fa-pen"));
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		
		clickDesiredIcon(By.cssSelector(".fa-pen"));
//		WebElement editIcon = driver.findElement(By.cssSelector(".fa-pen"));
//		editIcon.click();
		
		waitForWebElementToAppear(By.cssSelector(".modal-content"));
		WebElement firstName = driver.findElement(By.xpath("//input[@placeholder='First Name']"));
		firstName.sendKeys(" Edit");
		WebElement userRoleDropdown = driver
				.findElement(By.xpath("//label[text()='User Role Group ']/parent::div//input"));
		userRoleDropdown.click();
		WebElement selectUserRole = driver
				.findElement(By.xpath("//div[contains(@class,'ng-dropdown-panel-items')]//span[text()='Inspector']"));
		selectUserRole.click();
		WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
		saveBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Saved successfully.']"));
	}

	public void deleteUser() throws FileNotFoundException {
		waitForWebElementToAppear(By.xpath("//span[text()='User']"));
		WebElement userMenu = driver.findElement(By.xpath("//span[text()='User']"));
		userMenu.click();
		ArrayList<String> data = excelRead("Add User");
		WebElement searchBox = driver.findElement(By.xpath("//input[@placeholder='Search user']"));
		searchBox.sendKeys(data.get(2));
		waitForWebElementToAppear(By.xpath("//span[text()=' Total: 1 items ']"));
		clickDesiredIcon(By.xpath("//a[.//i[contains(@class, 'fa-trash-alt')]]"));
		WebElement confirmBtn = driver.findElement(By.cssSelector(".swal2-confirm "));
		confirmBtn.click();
		waitForWebElementToAppear(By.xpath("//span[text()='Successfully deleted.']"));
		System.out.println("User Deleted Successfully.");

	}
}
