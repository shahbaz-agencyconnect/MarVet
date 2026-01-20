package Mavet.PageObjects;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Marvet.AbstractComponent.AbstractComponent;

public class AddUser extends AbstractComponent {
	WebDriver driver;

	public AddUser(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".d-flex")
	WebElement loadDashboard;

	@FindBy(xpath = "//span[text()='User']")
	WebElement userMenu;

	@FindBy(xpath = "//button[text()=' Add User ']")
	WebElement addUserBtn;

	@FindBy(css = ".modal-content")
	WebElement dialog;

	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstName;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastName;

	@FindBy(xpath = "//input[@placeholder='Email Address']")
	WebElement userEmail;

	@FindBy(xpath = "//div[text()='Search for client...']/parent::div//input")
	WebElement client;

	@FindBy(xpath = "//div[text()='Search for terminal or charterer...']/parent::div//input")
	WebElement terminalCharterer;
	
	@FindBy(xpath = "//span[text()=' Password reset is required ']")
	WebElement uncheckPwdReset;	

//	@FindBy(xpath = "(//span[text()='Koch Shipping (Cr)'])[2]")
//	WebElement selectTerminal;

//	@FindBy(xpath = "//div[contains(@id,'remote-select')]//span[text()='The Curator']")
//	WebElement selectClient;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//span[text()='Saved successfully.']")
	WebElement successMsg;

	public void addnewUser() throws FileNotFoundException, InterruptedException {
		waitForWebElementToAppear(loadDashboard);
		waitForWebElementToAppear(userMenu);
		userMenu.click();
		addUserBtn.click();
		waitForWebElementToAppear(dialog);
		ArrayList<String> data = excelRead("Add User");
		firstName.sendKeys(data.get(0));
		lastName.sendKeys(data.get(1));
		userEmail.sendKeys(data.get(2));
		client.click();
		waitForWebElementToAppear(driver.findElement(By.xpath("//div[contains(@id,'remote-select')]//span[text()='"+data.get(3)+"']")));
		WebElement selectClient=driver.findElement(By.xpath("//div[contains(@id,'remote-select')]//span[text()='"+data.get(3)+"']"));
		selectClient.click();
		terminalCharterer.click();
		waitForWebElementToAppear(driver.findElement(By.xpath("//span[contains(@class,'ng-option-label') and text()='"+data.get(4)+"']")));
		WebElement selectTerminal=driver.findElement(By.xpath("//span[contains(@class,'ng-option-label') and text()='"+data.get(4)+"']"));
		selectTerminal.click();
		uncheckPwdReset.click();
		saveBtn.click();
		waitForWebElementToAppear(successMsg);
	}
}
