package Mavet.PageObjects;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Marvet.AbstractComponent.AbstractComponent;

public class InspectorManagement extends AbstractComponent {
	WebDriver driver;

	public InspectorManagement(WebDriver driver) {
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
	
	@FindBy(xpath = "//input[@role='combobox']")
	WebElement userRole;
	
	@FindBy(xpath = "//label[text()='User Role Group ']/parent::div//span[text()='MER Inspector']")
	WebElement selectRole;	

	@FindBy(xpath = "//div[text()='Search for client...']/parent::div//input")
	WebElement client;

	@FindBy(xpath = "//div[text()='Search for terminal or charterer...']/parent::div//input")
	WebElement terminalCharterer;

	@FindBy(xpath = "//span[text()=' Password reset is required ']")
	WebElement uncheckPwdReset;

	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;
	
	@FindBy(xpath = "//span[text()='Saved successfully.']")
	WebElement successMsg;

	@FindBy(xpath = "//span[text()='Inspector Management']")
	WebElement inspectorMgmt;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	public void inspectorManagement() throws FileNotFoundException {
		waitForWebElementToAppear(loadDashboard);
		waitForWebElementToAppear(userMenu);
		userMenu.click();
		addUserBtn.click();
		waitForWebElementToAppear(dialog);
		ArrayList<String> data = excelRead("Add User");
		String firstname = data.get(0);
		String lastname = data.get(1);
		String email = data.get(2);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		userEmail.sendKeys(email);
		userRole.click();
		selectRole.click();
//		client.click();
//		waitForWebElementToAppear(driver.findElement(By.xpath("//div[contains(@id,'remote-select')]//span[text()='"+data.get(3)+"']")));
//		WebElement selectClient=driver.findElement(By.xpath("//div[contains(@id,'remote-select')]//span[text()='"+data.get(3)+"']"));
//		selectClient.click();
//		terminalCharterer.click();
//		waitForWebElementToAppear(driver.findElement(By.xpath("//span[contains(@class,'ng-option-label') and text()='"+data.get(4)+"']")));
//		WebElement selectTerminal=driver.findElement(By.xpath("//span[contains(@class,'ng-option-label') and text()='"+data.get(4)+"']"));
//		selectTerminal.click();
		uncheckPwdReset.click();
		saveBtn.click();
		waitForWebElementToAppear(successMsg);
		inspectorMgmt.click();
		driver.findElement(By.xpath("//input[@placeholder='Search inspector']")).sendKeys(email);
		waitForWebElementToAppear(listLoad);
		String getEmailElement = driver.findElement(By.xpath("//table[contains(@id,'pr_id')]//span[text()='"+email+"']")).getText();
		Assert.assertEquals("testmail.com", getEmailElement);

	}
}
