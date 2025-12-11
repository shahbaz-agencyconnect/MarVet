package Mavet.PageObjects;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Marvet.AbstractComponent.AbstractComponent;

public class EditClient extends AbstractComponent {
	WebDriver driver;

	public EditClient(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Client Management']")
	WebElement clientManagement;

	@FindBy(xpath = "//input[@placeholder='Search client']")
	WebElement searchBox;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-pen ")
	WebElement editIcon;
	
	@FindBy(xpath = "//label[text()='Client Name ']/parent::div/input")
	WebElement clientName;
	
	@FindBy(xpath = "//span[text()='Save']")
	WebElement saveBtn;

	public void editClient() throws FileNotFoundException, InterruptedException {
		waitForWebElementToAppear(clientManagement);
		clientManagement.click();
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys("Marvet");
		waitForWebElementToAppear(listLoad);
		Thread.sleep(1000);
		editIcon.click();
		clientName.sendKeys(" Update");
		saveBtn.click();
	}
}
