package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class RemoveInspectionQuestion extends AbstractComponent{
	WebDriver driver;
	public RemoveInspectionQuestion(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@FindBy(css = ".fa-chevron-down")
	WebElement settingsMenu;

	@FindBy(xpath = "//a[text()=' Inspection Question ']")
	WebElement openInspectionQuestion;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search inspection question')]")
	WebElement searchBox;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-trash-alt")
	WebElement deleteIcon;

	@FindBy(css = ".swal2-confirm")
	WebElement confirmBtn;
	
	public void removeInspectionQuestion() throws InterruptedException {
		settingsMenu.click();
		openInspectionQuestion.click();
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys("Preliminary");
		waitForWebElementToAppear(listLoad);
		Thread.sleep(1000);
		deleteIcon.click();
		confirmBtn.click();
	}
}
