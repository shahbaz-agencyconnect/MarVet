package Mavet.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Marvet.AbstractComponent.AbstractComponent;

public class RemoveInspection extends AbstractComponent{
	WebDriver driver;
	public RemoveInspection(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	@FindBy(xpath = "//span[text()='Inspection Management']")
	WebElement inspection;

	@FindBy(xpath = "//input[contains(@placeholder,'Search inspection')]")
	WebElement searchBox;

	@FindBy(xpath = "//span[text()=' Total: 1 items ']")
	WebElement listLoad;

	@FindBy(css = ".fa-trash-alt")
	WebElement deleteIcon;

	@FindBy(css = ".swal2-confirm")
	WebElement confirmBtn;
	
	public void removeInspection() throws InterruptedException {
		waitForWebElementToAppear(inspection);
		inspection.click();
		waitForWebElementToAppear(searchBox);
		searchBox.click();
		searchBox.sendKeys("PLT");
		waitForWebElementToAppear(listLoad);
		Thread.sleep(1000);
		deleteIcon.click();
		confirmBtn.click();
	}
}
